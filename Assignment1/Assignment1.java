// user enters two sequences, program prints the two closest numbers between the arrays and subtracts the values 
// package assignments;

import java.util.Scanner;

public class Assignment1 {
	

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
			 
		// sequence1 size input 
		System.out.println("Enter the size of your first sequence");
		int n = sc.nextInt();
			 
		int mySequence1[] = new int[n];
		int j;
		int i;

		System.out.println("Enter your first sequence");
		// sequence1 input 
		// for loop for defining array 
		for(i=0; i<mySequence1.length; i++) {
				 
			mySequence1[i] = sc.nextInt();
			
		}
			 
		// sequence2 size input
		System.out.println("Enter the size of your second sequence");
		int k = sc.nextInt();
			 
		int mySequence2[] = new int[k];
			 
		System.out.println("Enter your second sequence");
		// sequence2 input
		// for loop for defining array 
		for(j=0; j<mySequence2.length; j++) {
			
			mySequence2[j] = sc.nextInt();
			
		}
		
		int x, y, diff, temp = 0;
		
		x = mySequence1[0];
		y = mySequence2[0];
		
		// calculate the absolute value of the difference between array1 and array2
		// we havent iterated anything yet so start with first indexes as a base (array1[0] and array2[0])
		diff = Math.abs(mySequence1[0] - mySequence2[0]);
		
		// loop through each index of array1 and subtract from each index of array1
		// for example: (array1[0] - array2[0]), (array1[0] - array2[1]), (array1[0] - array2[2])... etc.)
		for(i=0; i < mySequence1.length; i++) {
			
			for(j=0; j < mySequence2.length; j++) {
				
				// store the differences in a temporary value
				temp = Math.abs(mySequence1[i] - mySequence2[j]);
				
				// if that temporary value is less than our desired difference value...
				if (temp < diff) {
					
					// then the temporary value is stored as our desired difference and x and y are our two closest ints 
					diff = temp;
					x = mySequence1[i];
					y = mySequence2[j];
					
				}					
			}	
		}
		
		// print the two numbers (x,y) and their difference (diff) 
		System.out.println(x + " " + y);
		System.out.println(diff);
	
	}
}
	
// my notes - where to start...
// math.abs(some equation - array1[0] - array2[0]) will give the abs value of difference of indexes 
// anything involving iterating through indexes - use for loop
// when dealing with multiple arrays - need nested for loop
// for (
//    for (
// 		if (
