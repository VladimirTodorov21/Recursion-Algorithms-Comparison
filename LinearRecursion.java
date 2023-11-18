/*This program runs a linear recursive algorithm that computes Tetranacci Numbers. The program goes through a loop that records the output of the tetranacci numbers
 * at a given position and records the time it takes for the algorithm to run while writing the output and time measurements in 2 distinct text files to eventually compare
 * the results with another algorithm.*/

package comp352_assignment1;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class LinearRecursionTetranacci {
	public static void main(String[] args) {
		double startTime, endTime = 0; //variables used to record time
		
		//set printwriter objects to null before try catch statement
		PrintWriter pwTetraOutput = null;
		PrintWriter pwTetraTime = null;
		
		try {
			//Creates New files on the given file path
			pwTetraOutput = new PrintWriter(new FileOutputStream("C:\\Users\\arnol\\eclipse-workspace\\Assignments\\COMP352\\comp352_assignment1\\TetraLinearOutput.txt"));
			pwTetraTime = new PrintWriter(new FileOutputStream("C:\\Users\\arnol\\eclipse-workspace\\Assignments\\COMP352\\comp352_assignment1\\TetraLinearTime.txt"));
			
			//Prints first output in files
			pwTetraOutput.print("Linear Recursion Tetranacci Algorithm Output results:\n");
			pwTetraTime.print("Linear Recursion Tetranacci Algorithm Time results:\n");
			
			//Iteration of the tetranacci algorithm every 5 indices and prints output in console and the seperate text files
			for (int i=5;i<=200;i=i+5){
	        	startTime = System.nanoTime(); //start recording
	        	tetranacciLinearRecursion(0,0,0,1,i);
	        	endTime = System.nanoTime(); //stop recording
	        	System.out.println("Tetranacci number at position " + i + " is: " + tetranacciLinearRecursion(0,0,0,1,i) + ". It took " + (endTime-startTime)/1000000 + " miliseconds.");
	        	pwTetraOutput.print("    TetranacciLinearRecursion(" + i + ") is: " + tetranacciLinearRecursion(0,0,0,1,i) + "\n");
	        	pwTetraTime.print("    TetranacciLinearRecursiion(" + i + ") took " + (endTime-startTime)/1000000 + " miliseconds to perform the algorithm.\n");
	        	startTime = 0;//set timer to 0 for the loop to iterate and record again
	        	endTime = 0; //set timer to 0 for the loop to iterate and record again
	        }
			//close both objects to print the output onto text files
			pwTetraOutput.close();
			pwTetraTime.close();
		}
		//Exception handling on file not found
        catch(FileNotFoundException e) {
        	System.out.println("\nAttention! Cannot proceed to copy the file because files do not exist.");
			System.out.println("Terminating the program.");
			System.exit(0);
        }
    }
	
	//Linear Recursion Algorithm
    public static double tetranacciLinearRecursion(double a, double b, double c, double d, int n) {
    	//Error Handling on negative integers
    	if (n < 0) {
            throw new IllegalArgumentException("Input cannot be negative. Please try again!");
        }
    	//Base case 1
        if (n < 3) {
            return 0;
        } 
        //Base case 2
        else if (n == 3) {
            return d;
        } else {
            return tetranacciLinearRecursion(b,c,d,a+b+c+d,n-1); //each recursive call will compute the next double d being the sum of all the parameters aside from n
        }	
    }
}
