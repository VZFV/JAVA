package teamproject;

//@author Cody

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class TeamProjectDriver {
    
    static MaxFlow<String> myGraph = null;
    
    public static void main(String[] args)
    {
        while (true)
        {
            System.out.println();
            System.out.println("Main Menu:");
            System.out.println("1) Input File");
            System.out.println("2) Add Edge");
            System.out.println("3) Remove Edge");
            System.out.println("4) Undo Remove Edge");
            System.out.println("5) Display Graph");
            System.out.println("6) Solve Graph");
            System.out.println("7) Write Graph To Text File");
            
            System.out.println("8) Exit");
            
            System.out.print(">> ");
            
            Scanner sc = new Scanner(System.in);
            boolean flag;
            
            do
            {
                if (flag = sc.hasNextInt())
                {
                    switch(sc.nextInt())
                    {
                        case 1:
                        {
                            myGraph = new MaxFlow(openInputFile());
                        }
                        break;
                        case 2:
                        {
                            System.out.print("First vertex name: ");
                            String source = sc.next();
                            System.out.print("Second vertex name: ");
                            String destination = sc.next();
                            System.out.print("Edge Weight: ");
                            double weight = sc.nextDouble();
                            
                            if (myGraph != null)
                                myGraph.addEdge(source, destination, weight);
                            else
                            {
                                myGraph = new MaxFlow<>();
                                myGraph.addEdge(source, destination, weight);
                            }
                        }
                        break;
                        case 3:
                        {
                            System.out.print("First vertex name: ");
                            String source = sc.next();
                            System.out.print("Second vertex name: ");
                            String destination = sc.next();
                            
                            if (myGraph != null)
                                myGraph.remove(source, destination);
                            else
                            {
                                System.out.println("No Graph...");
                            }
                        }
                        break;
                        case 4:
                        {
                            if (myGraph != null)
                                myGraph.undoRemove();
                        }
                        break;
                        case 5:
                        {
                            displayGraph();
                        }
                        break;
                        case 6:
                        {
                            System.out.print("Source: ");
                            String source = sc.next();
                            System.out.print("Destination: ");
                            String destination = sc.next();
                            
                            myGraph.fordFulkerson(myGraph.vertexSet.get(source), myGraph.vertexSet.get(destination));
                        }
                        break;
                        case 7:
                        {
                            System.out.print("File Name: ");
                            String name = sc.next();
                            
                            PrintWriter outFile;
                            try {
                                outFile = new PrintWriter(name + ".txt");
                            }catch( FileNotFoundException e ){
                                System.err.println(e);
                                return ;
                            } //end catch
                            
                            myGraph.outputText(outFile);
                        }
                        break;
                        case 8: return;
                    }
                }
                else
                {
                    System.out.println("no");
                    sc.next();
                }
            } while (!flag);
        }
    }
    
    public static void displayGraph()
    {
        System.out.println("8) Back");
        
        System.out.print(">> ");
        
        Scanner sc = new Scanner(System.in);
        boolean flag;
        
        do
        {
            if (flag = sc.hasNextInt())
            {
                switch(sc.nextInt())
                {
                    case 1:
                    {
                        System.out.print("Start Element: ");
                        String start = sc.next();
                        myGraph.depthFirstTraversal(start, obj -> {
                            myGraph.vertexSet.get(obj).visit();
                            System.out.println(obj);
                        });
                    }
                    break;
                    case 2:
                    {
                        System.out.print("Start Element: ");
                        String start = sc.next();
                        myGraph.breadthFirstTraversal(start, obj -> {
                            myGraph.vertexSet.get(obj).visit();
                            System.out.println(obj);
                        });
                    }
                    break;
                    case 3:
                    {
                        myGraph.showAdjTable();
                    }
                    break;
                    case 8: return;
                }
            }
            else
            {
                System.out.println("no");
                sc.next();
            }
        } while (!flag);
    }
    
    public static Scanner userScanner = new Scanner(System.in);
    
    public static Scanner openInputFile()
    {
        String filename;
        Scanner scanner=null;
        
        System.out.print("Enter the input filename: ");
        filename = userScanner.nextLine();
        File file= new File(filename);
        
        try{
            scanner = new Scanner(file);
        }// end try
        catch(FileNotFoundException fe){
            System.out.println("Can't open input file\n");
            return null; // array of 0 elements
        } // end catch
        return scanner;
    }
    
}