package assignment3;
import java.util.Scanner;

public class binConvert {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		int num;
		int i = 0;
		int j = 0;  
		int temp = 0;
		
		//set up input object
		Scanner kb = new Scanner(System.in);
		
		do{
			i = 0; //need to reset the counter for amount of times to pop out of stack 
					// if we dont reset to 0 we get a null pointer 
			System.out.println("Enter a decimal number");
			num = kb.nextInt(); // input your number 
			temp = num; // store 'num' in a temporary variable 
			
			if(num == 0)
				System.out.println("0 converted to binary is: 0000"); 
			else if(num > 0) 
			{
        
				while(num > 0) { // while the number is > 0
					list.addHead(num%2); //store the remainder (using mod) in the 'addHead' method from LinkedList
					num = num/2; // a new 'num' is now stored as the old 'num'  divided by 2
					i++;  
				}
        
				System.out.println(temp + " converted to binary is: " );
				for(j=0; j<i; j++) // while an element still exists in the list...
				{          
					System.out.print(list.removeHead()); //...print out an element using the 'removeHead' method from LinkedList   
				}        
				System.out.println();     
			} 
		}
		
		while(num >= 0); 
	}
}
