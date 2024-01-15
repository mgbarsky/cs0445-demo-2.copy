package demo2;
/**
 * Class that stores the history of hospital patients
 * in an array where each element is a mutable StringBuilder
 * This is a demo of copy constructors which copy at different depth
 */
public class Archive {
	
	public static final int SHALLOW = 	0;
	public static final int DEEPER = 	1;
	public static final int DEEP = 		2;
	
	private StringBuilder [] A;
	private int size;

	public Archive(int max)	{
		A = new StringBuilder[max];
		size = 0;
	}
	
	// Copy constructor.  Based on the value of the flag
	// it will be shallow, "deeper", or deep.
	public Archive(Archive old, int flag) {
		if (flag == SHALLOW) {  
			// shallow - just copy values of reference variables
			this.A = old.A;
			this.size = old.size;
		}
		else if (flag == DEEPER) { 
			// deeper - make new array
			// but copy into it old reference variables
			this.A = new StringBuilder[old.A.length];
			for (int i = 0; i < old.size; i++)
				this.A[i] = old.A[i];
			this.size = old.size;
		}
		else { 
			// DEEP - make all new objects inside a new array   	
	   		this.A = new StringBuilder[old.A.length];
	   		for (int i = 0; i < old.size; i++)	{
	   			StringBuilder newS = new StringBuilder(old.A[i]);
	   			this.A[i] = newS;
	   		}
	   		this.size = old.size;
	   	}
	}

	// add another StringBuilder to end of array
	public void add(StringBuilder S) {
		if (size < A.length) {
			A[size] = S;
			size++;
		}
	}
	
	// replace a StringBuilder element at A[i]
	public void set(int i, StringBuilder S)	{
		if (0 <= i && i < size)	{
			A[i] = S;
		}
	}
	
	// return value of A[i]
	public StringBuilder get(int i)	{
		if (0 <= i && i < size)
			return A[i];
		else
			return null;
	}
	
	// Return a single String containing all data
	public String toString() {
		StringBuilder total = new StringBuilder("[");
		for (int i = 0; i < size-1; i++)
			total.append(A[i].toString() + ",  ");
		if (size > 0)
			total.append(A[size-1].toString() + "]");
		return total.toString();
	}
}
