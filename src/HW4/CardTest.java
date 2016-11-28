/**
 * CardTest
 * Author: Feng Zhang
 * 11/14/2016
 * window 10 64bit, eclipse
 * This is main class that tests BST with a new PipComparator and BST with a new SuitComparator, bst's
 * inorder method. 
 */
package HW4;

import java.util.Scanner;

public class CardTest {

		public static void main(String[] args) {
		// TODO Auto-generated method stub		
		BST<Card> bst1 = new BST<Card>(new PipsComparator());	//Assign the variables a new BST with a new PipComparator passed as an argument
		BST<Card> bst2 = new BST<Card>(new SuitComparator());	//Assign to the variable a new BST with a new SuitComparator as an argument.
		
		fillbothBSTs(bst1, bst2);	// fill both BSTs with cards
		
		System.out.println("Pips Sorted Tree inorder traversal: ");
		bst1.inorder(new PipsVisitor());	
		
		System.out.println("\nSuit Sorted Tree inorder traversal: ");
		bst2.inorder(new SuitVisitor());
		
		testBST(bst1);	// test bst1
		testBST(bst2);	// test bst2
		
		testDelete(bst1, bst2); // test delete bst1 and bst2
		testCopy(bst1, bst2);
		
		System.out.println("\nPips-ordered Tree, Postorder traversal: ");
		bst1.postorder(new PipsVisitor());
	}
	
	public static void fillbothBSTs(BST<Card> bst1, BST<Card> bst2){
		
		boolean[] array = new boolean[52]; //assign an array of 52 boolean to the local array
		int randomNum;	// initialize a random 
		for(int i = 0; i < 25; i++){
			do{
				randomNum = (int) (Math.random()*52);	// get a random number from 0 to 51
			}while(array[randomNum]);
			
			array[randomNum] = true;	// Set the boolean array element at the local int index to true
			Card card = new Card(((randomNum%13)+1), (randomNum/13)); //Instantiate a Card
			bst1.insert(card);	// insert card
			bst2.insert(card);	// insert card
		}
	}
	
	public static void testDelete(BST<Card> bst1, BST<Card> bst2){
		Card first1 = bst1.getFirst();
		Card last1 = bst1.getLast();
		
		if(bst1.delete(bst1.getFirst()))
			System.out.println("Deletion successful from pips-ordered tree of " + first1);
		else
			System.out.println("Unsuccessful");
		
		if(bst1.delete(bst1.getLast()))
			System.out.println("Deletion successful from pips-ordered tree of " + last1);
		else
			System.out.println("Unsuccessful");
		
		
		Card first2 = bst2.getFirst();
		Card last2 = bst2.getLast();
		
		if(bst2.delete(bst2.getFirst()))
			System.out.println("Deletion successful from suit-ordered tree of " + first2);
		else
			System.out.println("Unsuccessful");
		
		if(bst2.delete(bst2.getLast()))
			System.out.println("Deletion successful from suit-ordered tree of " + last2);
		else
			System.out.println("Unsuccessful");
		
	}

	
	public static void testBST(BST<Card> tree)
	{
		int tempPips, tempSuitNum;
		Card searchItem;
		Card foundItem;
		String prompt="\n\nEnter a Card (1-13  0-3) that should be in the tree: ";
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 2; ++i) 
		{
			System.out.print( prompt );
			
			tempPips = scanner.nextInt();
			tempSuitNum = scanner.nextInt();
			searchItem = new Card(tempPips, tempSuitNum);
			foundItem = tree.getEntry(searchItem);
			if (foundItem != null)
			{
				System.out.println( "Found : " + foundItem );
			}
			else
				System.out.println( searchItem + " not found" );

			prompt = "\nEnter a Card (1-13  0-3) that should NOT be in the tree: ";
		} // end for

	} // end testBST

	public static void testCopy(BST<Card> tree1,
			BST<Card> tree2)
		{
			BST<Card> localTree;
			Visitor<Card> visitor, testvisitor ;
			testvisitor = new TestVisitor();

			localTree = new BST<Card>(tree1);
			visitor = new PipsVisitor();
			System.out.println( "\n\nThe local tree from copy constructor copying Pips-ordered tree");
			localTree.inorder(visitor);
			localTree.postorder(testvisitor);
			System.out.println("local tree has been changed, now it has: ");
			localTree.inorder(visitor);
			
			System.out.println( "\nChecking if Original Pips-ordered Tree was not changed: ");
			tree1.inorder(visitor);

			localTree = new BST<Card>(tree2);
			visitor = new SuitVisitor();
			System.out.println( "\nThe local tree from copy constructor copying Suit-ordered tree");
			localTree.inorder(visitor);
			localTree.postorder(testvisitor);
			System.out.println("local tree has been changed, now it has: ");
			localTree.inorder(visitor);
			System.out.println( "\nChecking if Original Suit-ordered Tree was not changed: ");
			tree2.inorder(visitor);
		} // end testCopy
}

/*
 * Pips Sorted Tree inorder traversal: 
Ace of Clubs
Ace of Hearts
2 of Clubs
2 of Diamonds
2 of Hearts
3 of Clubs
3 of Diamonds
3 of Hearts
3 of Spades
4 of Clubs
4 of Diamonds
5 of Clubs
6 of Hearts
6 of Spades
7 of Spades
8 of Hearts
9 of Spades
10 of Clubs
10 of Diamonds
10 of Hearts
Jack of Clubs
Queen of Hearts
Queen of Spades
King of Clubs
King of Spades

Suit Sorted Tree inorder traversal: 
Clubs, Ace
Clubs, 2
Clubs, 3
Clubs, 4
Clubs, 5
Clubs, 10
Clubs, Jack
Clubs, King
Diamonds, 2
Diamonds, 3
Diamonds, 4
Diamonds, 10
Hearts, Ace
Hearts, 2
Hearts, 3
Hearts, 6
Hearts, 8
Hearts, 10
Hearts, Queen
Spades, 3
Spades, 6
Spades, 7
Spades, 9
Spades, Queen
Spades, King


Enter a Card (1-13  0-3) that should be in the tree: 13 3
Found : King of Spades

Enter a Card (1-13  0-3) that should NOT be in the tree: 13 1
King of Diamonds not found


Enter a Card (1-13  0-3) that should be in the tree: 10 0
Found : 10 of Clubs

Enter a Card (1-13  0-3) that should NOT be in the tree: 9 0
9 of Clubs not found
Deletion successful from pips-ordered tree of Ace of Clubs
Deletion successful from pips-ordered tree of King of Spades
Deletion successful from suit-ordered tree of Ace of Clubs
Deletion successful from suit-ordered tree of King of Spades


The local tree from copy constructor copying Pips-ordered tree
local tree has been changed, now it has: 

Checking if Original Pips-ordered Tree was not changed: 
Ace of Hearts
2 of Clubs
2 of Diamonds
2 of Hearts
3 of Clubs
3 of Diamonds
3 of Hearts
3 of Spades
4 of Clubs
4 of Diamonds
5 of Clubs
6 of Hearts
6 of Spades
7 of Spades
8 of Hearts
9 of Spades
10 of Clubs
10 of Diamonds
10 of Hearts
Jack of Clubs
Queen of Hearts
Queen of Spades
King of Clubs

The local tree from copy constructor copying Suit-ordered tree
local tree has been changed, now it has: 

Checking if Original Suit-ordered Tree was not changed: 
Clubs, 2
Clubs, 3
Clubs, 4
Clubs, 5
Clubs, 10
Clubs, Jack
Clubs, King
Diamonds, 2
Diamonds, 3
Diamonds, 4
Diamonds, 10
Hearts, Ace
Hearts, 2
Hearts, 3
Hearts, 6
Hearts, 8
Hearts, 10
Hearts, Queen
Spades, 3
Spades, 6
Spades, 7
Spades, 9
Spades, Queen

Pips-ordered Tree, Postorder traversal: 
3 of Clubs
9 of Spades
10 of Clubs
10 of Diamonds
10 of Hearts
Jack of Clubs
Queen of Hearts
Queen of Spades
King of Clubs
Ace of Hearts
2 of Clubs
2 of Diamonds
2 of Hearts
3 of Clubs
3 of Diamonds
3 of Hearts
3 of Spades
4 of Clubs
4 of Diamonds
5 of Clubs
6 of Hearts
6 of Spades
7 of Spades
8 of Hearts
9 of Spades
10 of Clubs
10 of Diamonds
10 of Hearts
Jack of Clubs
Queen of Hearts
Queen of Spades
King of Clubs
*/
