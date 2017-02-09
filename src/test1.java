import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zf930
 */


class ObjectFileTest

{ public static void main(String[] args)

{ try

{

int [] staff = new int[3];

staff[0] = new int();

staff[1] = new int();

staff[2] = new int();

ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("A.dat"));

out.writeObject(staff);

out.close();

ObjectInputStream in = new ObjectInputStream(new FileInputStream("A.dat"));

A[] newStaff = (A[]) in.readObject();

}

catch(Exception e)

{ System.out.print("Error: " + e);

System.exit(1);

}

}

} // end class Addition
