import java.util.Scanner;
import java.util.Arrays;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class FindAnagram {
	
	//create hashmap - 'hmap'
	HashMap<String, ArrayList<String>> hmap;
	
	//initialize hashmap - 'hmap'
	public FindAnagram() {
		hmap = new HashMap<>();
	}

	//method reads from wordsEn.txt file and creates our keys/values
	//'key' is the canonical form of the word
	//'hashValue' is the value of the canonical word 
	private void readWords() {
		try {
			Scanner sc1 = new Scanner(new File("wordsEn.txt")); //read from file
			while (sc1.hasNextLine()) {
				String word = sc1.nextLine();
				String key = getCanonical(word);
				if (!hmap.containsKey(key)) {
					ArrayList<String> hashValue = new ArrayList<>();
					hmap.put(key, hashValue);
				}
				hmap.get(key).add(word);
			}
		}
		
		// help from online
		catch (FileNotFoundException e) {
			//'e.printStackTract();' - prints the stack trace of the Exception to System.err
			//very simple, but very useful tool for diagnosing an Exception
			//tells you what happened and where in the code the error happened
			e.printStackTrace();
		}
	}

	//program segment given
	private static String getCanonical(String word) {
		char[] x = word.toCharArray();
		Arrays.sort(x);
		return new String(x);
	}
	
	public static void main(String[] args) throws Exception {
		String word;
		String cWord;
		Scanner kb = new Scanner(System.in);
		File file = new File("wordsEn.txt"); //input file 
		Scanner sc2 = new Scanner(file);
	      	FindAnagram anagram = new FindAnagram();
	      	anagram.readWords();
	      	do {
	      		System.out.println("Enter a word (enter a blank line to quit)");
	      		word = kb.nextLine(); //enter word
	      		cWord = getCanonical(word); //get canonical form of entered word
	      		System.out.println(anagram.hmap.get(cWord)); //gets the value associated with the canonical word
	      	} while (!word.equals(""));
	}
}
