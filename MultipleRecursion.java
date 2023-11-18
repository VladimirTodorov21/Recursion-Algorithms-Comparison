/*This program runs a multiple recursive algorithm that computes Tetranacci Numbers. The program goes through a loop that records the output of the tetranacci numbers
 * at a given position and records the time it takes for the algorithm to run while writing the output and time measurements in 2 distinct text files to eventually compare
 * the results with another algorithm.*/

package comp352_assignment1;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MultipleRecursionTetranacci {
	public static void main(String[] args) {
		double startTime, endTime = 0; //variables used to record time
		
		//set printwriter objects to null before try catch statement
		PrintWriter pwTetraOutput = null;
		PrintWriter pwTetraTime = null;
		
		try {
			//Creates New files on the given file path
			pwTetraOutput = new PrintWriter(new FileOutputStream("C:\\Users\\arnol\\eclipse-workspace\\Assignments\\COMP352\\comp352_assignment1\\TetraMultipleOutput.txt"));
			pwTetraTime = new PrintWriter(new FileOutputStream("C:\\Users\\arnol\\eclipse-workspace\\Assignments\\COMP352\\comp352_assignment1\\TetraMultipleTime.txt"));
			
			//Prints first output in files
			pwTetraOutput.print("Multiple Recursion Tetranacci Algorithm Output results:\n");
			pwTetraTime.print("Multiple Recursion Tetranacci Algorithm Time results:\n");
			
			//Iteration of the tetranacci algorithm every 5 indices and prints output in console and the seperate text files
			for (int i=5;i<=30;i=i+5){
	        	startTime = System.nanoTime(); //start recording
	        	tetranacciMultipleRecursion(i);
	        	endTime = System.nanoTime(); //stop recording
	        	System.out.println("Tetranacci number at position " + i + " is: " + tetranacciMultipleRecursion(i) + ". It took " + (endTime-startTime)/1000000 + " miliseconds.");
	        	pwTetraOutput.print("    TetranacciMultipleRecursion(" + i + ") is: " + tetranacciMultipleRecursion(i) + "\n");
	        	pwTetraTime.print("    TetranacciMultipleRecursion(" + i + ") took " + (endTime-startTime)/1000000 + " miliseconds to perform the algorithm.\n");
	        	startTime = 0; //set timer to 0 for the loop to iterate and record again
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

	//Multiple Recursion Algorithm
    public static double tetranacciMultipleRecursion(int a) {
    	//Error Handling on negative integers
    	if (a < 0) {
            throw new IllegalArgumentException("Input cannot be negative. Please try again!");
        }
    	//Base case 1
        if (a < 3) {
            return 0;
        } 
        //Base case 2
        else if (a == 3) {
            return 1;
        } else {
        	//each recursive call calls upon themselves, and since there are 4 of them, they will call multiple times until they reach the base case
            return tetranacciMultipleRecursion(a-1) + tetranacciMultipleRecursion(a-2) + tetranacciMultipleRecursion(a-3) + tetranacciMultipleRecursion(a-4);
        }	
    }
}
