/**
 * HashTable
 * Author: Feng Zhang
 * 11/23/2016
 * window 10 64bit, eclipse
 * This is HashTable class. 
 */
package HW5;

import java.util.*;

public abstract class HashTable<E> {
	   protected int numCollisions; // ADDED FOR HW#5
	   protected int longestCollisionRun;// ADDED FOR HW#5
	   protected Hasher<E> hasher;
	   protected Comparator<E> comparator;
	   
	   public HashTable(Hasher<E> h, Comparator<E> c)
	   {
		   hasher = h;
		   comparator = c;
	   }
	   
	   public abstract E getEntry(E target);
	   public abstract boolean contains( E x);
	   public abstract void makeEmpty();
	   public abstract boolean insert( E x);
	   public abstract boolean remove( E x);
	   public abstract int size();
	   public abstract boolean setMaxLambda( double lam );
	   public abstract void displayTable();
	   public abstract void displayStatistics();
}
