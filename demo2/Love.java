package demo2;

public class Love {
	public static void main(String [] args) {
		if (args.length < 2)
			return;	
		
		String s1 = "eggplant";				// literal - constant string - known at compile time
		String s2 = s1;						// this one has the same address as s1
		String s3 = "eggplant";
		String s4 = new String("eggplant");	// creates a new string using string literal
		String s5 = new String (s1);		// copy constructor - explicitly asks to create a copy
		
		String a0 = args[0];				// these two are known only  during run time
		String a2 = args[1];
	}

}
