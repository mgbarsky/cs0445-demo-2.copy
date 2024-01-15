package demo2;

public class ArchiveTestDrive {
	public static void main(String [] args)	{
		Archive A = new Archive(10);
		A.add(new StringBuilder("Ann: broken heart | "));
		A.add(new StringBuilder("Bob: bruised ego | "));
		A.add(new StringBuilder("Dave: healthy | "));		
   
   		// Make three copies of the Archive:
		// a shallow copy
		// a deeper copy 
		// a deep copy.  
		// See class Archive to learn how these copies are made. 
		
		// calling copy constructor
		Archive shallow = new Archive(A, Archive.SHALLOW);
		Archive deeper = new Archive(A, Archive.DEEPER);
		Archive deep = new Archive(A, Archive.DEEP);
            
        System.out.println("Initial Data - all the same:"); 
		System.out.println("Orig. archive:\t" + A.toString());
		System.out.println("Shallow copy:\t" + shallow.toString());
		System.out.println("Deeper copy:\t" + deeper.toString());
		System.out.println("Deep copy:\t" + deep.toString());
             
		// Set a new value in the shallow copy.
		// Since array is shared, this will affect
		// the original object
		shallow.set(0, new StringBuilder("Jane: unknown | "));
			
		// With the deeper copy the arrays are separate
		// so a new element will not affect original array		
		deeper.set(0, new StringBuilder("John: unknown |"));		
		deep.set(0, new StringBuilder("Prince: unknown |"));

		System.out.println("\nAfter some sets:"); 	
		System.out.println("Orig. archive:\t" + A.toString());
		System.out.println("Shallow copy:\t" + shallow.toString());
		System.out.println("Deeper copy:\t" + deeper.toString());
		System.out.println("Deep copy:\t" + deep.toString());		

		// Mutate some StringBuilders
		
		// This append will affect A, shallow and deeper, since
		// they share the same StringBuilder in that location.
		// However, deep has a separate copy at A[0]and will not be affected
		A.get(1).append("cured");		
		
		deep.get(1).append("no change");
		
		System.out.println("\nAfter mutating some StringBuilders:"); 	 
		System.out.println("Orig. object:\t" + A.toString());
		System.out.println("Shallow copy:\t" + shallow.toString());
		System.out.println("Deeper copy:\t" + deeper.toString());
		System.out.println("Deep copy:\t" + deep.toString());
	}  
}
