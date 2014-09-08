/*
 * Shaun Mbateng
 * Tape Equilibrium
 * This program computes the minimum absolute difference of all
 * 		the indexes in an Array (the Tape Equilbrium)
 * This Programs has an O(n) Time Complexity
 */
import java.util.Scanner;

public class TapeEquilibrium 
{
	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in);
		
		int [] A; //Array of Values
		int mad; //Minimum Absolute Difference
		int len; //Length
		
		//Enter and Set Array Length
		System.out.print("Enter the Length of the Array: ");
		len = cin.nextInt();
		A = new int [len];
		
		//Fill Array
		for (int i=0; i<A.length; i++)
		{
			System.out.print("Enter Element "+(i+1)+": ");
			A[i] = cin.nextInt();
		}
		
		cin.close(); //Close cin, No Longer Needed
		mad = minDifference(A); //Call Function to Solve for "mad"
		
		//Display Minimum Absolute Difference
		System.out.println("");
		System.out.println("The minimum absolute difference of the tape is "+mad);
	}
	
	static int minDifference(int[] A) //Function to Solve for Minimum Absolute Difference (Tape Equilibrium)
    {
        //Base Case
		long lsum = A[0]; //Set Left Sum Equal to First Element
        long rsum = 0; //Set Right Sum Equal to Zero
        long diff; //Variable to Hold Difference
        
        //Set Right Sum to Sum of Rest of Values in Array
        for (int i=1; i<A.length; i++)
            rsum += A[i];
        
        diff = Math.abs(lsum-rsum); //Set Diff Equal to Absolute Difference of Left and Right Sums
        
        //If More Elements
        if (A.length>2)
        {
            //Update Left and Right Sums, and Difference (If Necessary)
        	for (int P=1; P<A.length-1; P++)
            {
                lsum += A[P];
                rsum -= A[P];
                
                long tmp = Math.abs(lsum-rsum);
                
                if (tmp<diff) //If Smaller, Update Difference
                {
                    diff = tmp;
                }
            }
        }
        
        return (int) diff; //Return diff as Integer
    }
}
