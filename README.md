ASSIGNMENT 1:
For your first assignment, you are to write a program in Java, that reads in two sequences of integers, both in ascending order, then prints out the two numbers, one from each sequence, that are the closest to one another, of all the pairs of numbers with one from each sequence. The program should also print out the difference of the two numbers. The program should prompt the user for the size of each sequence before reading in the sequence.
Sample Run
Enter size of first sequence > 10
Enter first sequence > 1 10 100 1000 4000 8000 16000 32000 64000 1024000
Enter size of second sequence > 5
Enter second sequence > 3000 9000 16005 48000 48001
16000 16005 5

ASSIGNMENT 2:
For your second assignment, you are to write a program that allows four players to play a very simple shooter game. The game is played on a five-by-five grid. Each player begins in a different corner of the grid: Player 1 starts at (1,1), Player 2 at (5,1), Player 3 at (1,5), and Player 4 at (5,5). Note that the players will use coordinates from 1 to 5, although the game will internally use coordinates from 0 to 4.
The game consists of a number of turns. In a turn, each player will have the chance to move and shoot at one of the other players. The four players will go in order. Each player may move up to one square away or a player may choose to stay put. To move, the player types in the coordinates from the square to move to. To stay put, the player types in the player's current position.
A player will then fire, up to two squares away. Again, the player types in the coordinates of the square being fired at. If there is a player in target square, that player will take 1 point of damage. It there is no player in the target square, it is a miss.
Distance is measure in terms of the "Manhattan" distance, that is, the distance between (x1,y1) and (x2,y2) is | x1-x2| + |y1-y2|. A player who has taken five hits is considered to be dead, does not appear on the board, and
takes no more actions in the game. The current board should be printed out before each player is asked to move and once the game is finished. The program should check that position typed in is a valid position, and loop until the player types in a valid position.
Additional Requirement:
The program will be graded with an automatic testing program. It is very important that the program follow the specifications for input precisely. The program should read from standard input and should only use one Scanner object. The coordinates for the square to move to or to fire on will be two integers, each from 1 to 5, separated by whitespace and followed by a new line character. You should use the Position class attached to this assignment.

ASSIGNMENT 3:
Write a program that prompts the user for a decimal number, reads in a number, and then prints out the number in binary. The program should continue to prompt the user, read in, and process numbers, until the user types in a negative number. The program should work properly for the number 0. The program must use a stack in a meaningful way.
To convert a decimal number to binary one place at a time (starting with the ones place): Take the remainder of the number divided by 2, e.g., n % 2. The remainder is the ones place. Then divide the number by 2, and find the ones place of that number. That remainder is the twos place of the original number. Divide the number by 2 again, and so on, until the number becomes 0. For example, if n = 14:
14 % 2 = 0; 14 / 2 = 7 7 % 2 = 1; 7 / 2 = 3
3 % 2 = 1; 3 / 2 = 1
1 % 2 = 1; 1 / 2 = 0
The process stops when the number becomes 0. The remainders taken in reverse order is the number in binary, e.g., 1410 = 11102.
Use the stack to reverse the digits. That is, push the remainders onto the stack when they are generated. When finished, pop the elements from the stack, one at a time, and print them out.
Use the linked list representation of the stack. You may use code from the book, from the book's web-site, from class, or roll your own.

ASSIGNMENT 4:
For this assignment, you are to add the following methods, implemented efficiently, to the Tree class from class:
• public String toStringReversed() // Returns a string that contains the keys in reverse order.
• public Node ceiling(K key) // returns the node with the smallest key that is greater than or equal to key. If key is in the tree, then the node containing key is returned. If key is greater than any key in the true, null is returned.
• public Node floor(K key) // returns the node with the largest key that is less than or equal to key. If key is in the tree, then the node containing key is returned. If key is less than any key in the true, null is returned.
• public int diameter() // Returns the diameter of the tree (see below).
• public int numBetween(K key1, K key2) // Returns the number of records in the tree
whose keys are between key1 and key2, inclusive.
The diameter of a tree is the number of nodes on the longest path in the tree. Neither of the end nodes need be the root of the tree, that is, the longest path need not go through the root of the tree! The diameter is always the largest of these three numbers: (height of the left subtree + height of the right subtree + 1; diameter of the left subtree, diameter of the right subtree).
Examples
In the tree is created by adding the keys B, G, K, P, R, S, V, in that order to an initially empty tree, then:
• toStringReversed should return the string "V S R P K G B".
• ceiling("C") is "G", ceiling("P") is "P", and ceiling("Y") is null.
• floor("C") is "B", floor("P") is "P", and floor("A") is null.
• The diameter of this tree would be 7. The diameter of the tree formed by adding the keys in this order:
P, G, B, K, S, R, V would be 5. The diameter of the tree formed by this order: B P G K S R V would
also be 5.
• numBetween("B","V") is 7, numBetween("A","Z") is 7, numBetween("C","Q") is 3, and
numBetween("H","J") is 0.
Additional requirements
These internal methods to implement these functions must be recursive. In addition to writing these methods, please write a main method (in the Tree class) that tests your code. You may have external, non-recursive methods call the internal, recursive methods. Also, give the worst-case running time of your methods in big- O notation. Your code should be efficient.

ASSIGNMENT 5:
Consider the following new Abstract Data Type (ADT): 2-Key Database.
A 2-Key Database consists of a list of records, each having having two key fields and a data field. Both types of keys must be Comparable. A 2-Key Database must be able to store records, and then efficiently retrieve a record given either key. For example, consider a university student database where the student records are indexed by the student's name (a String) and an ID number (say a Long). The data field can be of any type. You may assume that records have unique keys.
The class should be defined as:
public class TwoKey<K1 extends Comparable, K2 extends Comparable, D>
{ ... }
The operations that define a 2-Key Database are:
• void add(K1 key1, K2 key2, D data) // add a record to the database
• D find1(K1 key1) // find and return the data associated with key1
• D find2(K2 key2) // find and return the data associated with key2
• void modify1(K1 key1, D data) // modify the record associated with key1 to contain the
new data
• void modify2(K2 key2, D data) // modify the record associated with key2 to contain the
new data
• void change1(K1 key1, K2 key2) // change the second key of the record associated with
key1 to be key2
• void change2(K2 key2, K1 key1) // change the first key of record associated with key2 to
be key1
• String list1() // return the list (key, data) in order by key1 as a String
• String list2() // return the list (key, data) in order by key2 as a String
Note that if a record is (key1, key2, data), modifying the data associated with key1 also modifies the data associated with key2. Should find1 or find2 not find the record associated with the key they return null.
The code implementing the 2-Key Database must be in its own file, and the ADT must be implemented using generic types for the keys and data. You should write a test program that tests your code. Be sure to test all the methods and look at special cases including error conditions. You do not have to submit your test program.
Additional Requirement
Your code should use the simple database ADT (implemented as a tree) in a meaningful way. Hint 1: Use two simple databases, one which uses key1 as its key and the other which uses key2 as its key to implement a 2- key database. Call the operations of simple database ADT to implement the operations of the 2-Key database. You do not need to change the simple database code in any way for this assignment. Hint 2: Store both key1 and key2 in the data along with the real data.
You may use the code for the simple database ADT done in class, the code in the book, or the TreeMap API.
Example
Consider the following main method:
    public static void main(String[] args) {
        TwoKey<String, Integer, Integer> db = new TwoKey();
        db.add("Sam", 1, 2);
        db.add("Joe", 2, 3);
        db.add("Wilma", 3, 5);
        db.add("Bob", 4, 7);
        System.out.println(db.find1("Wilma"));
        System.out.println(db.find2(4));
        System.out.println(db.list1());
        System.out.println(db.list2());
        db.modify1("Sam", 11);
        db.modify1("Joe", 13);
        db.modify2(1, 17);
        db.change1("Bob", 5);
        db.change2(3, "Pebbles");
        System.out.println(db.list1());
        System.out.println(db.list2());
}
The output should be:
java TwoKey
5
7
(Bob,7)(Joe,3)(Sam,2)(Wilma,5)
(1,2)(2,3)(3,5)(4,7)
(Bob,7)(Joe,13)(Pebbles,5)(Sam,17)
(1,17)(2,13)(3,5)(5,7)

ASSIGNMENT 6:
For your last assignment, write a program that will print out all the anagrams for a given word. Here, an anagram is defined as an English word which has exactly the same letters, but may be in a different order. For example, "god" and "dog" are anagrams. The words will always be in lowercase. The program should first read in a list of English words from the file "wordsEn.txt" and then prompt the user to enter words. The program will then read in words from standard input, one word per line, and print out to standard output a list of all anagrams that match each word. The user will type in a blank line to end the program.
The program must use a HashMap in a meaningful way and should use the file "wordsEn.txt" for a list of English words.
Hint: The trick is to process the list of words as you read them in. Put each word into canonical form, by sorting the letters in the word. Two words which are anagrams will have the same canonical form. Use a HashMap whose key is the canonical form of the word (a String), and whose data is a list of English words with the same letters as the canonical form (ArrayList<String>.) When the program reads in a word from the word list, sort the letters, use the HashMap to find the list of English words associated with the canonical form, and then add the new word to that list. Create the ArrayList if it's not already created.
Further hint: To sort the letters of a word use:
char[] x = word.toCharArray();
Arrays.sort(x);
String canonicalWord = new String(x);
(There's need for the CharArray wrapper class that we used in class. You can convert the char[] array back to a String, and the HashMap will use the hashCode for String, which is fine.)
Example
Enter a word (blank line to end) > god
[dog, god]
Enter a word (blank line to end) > spare
[apers, apres, asper, pares, parse, pears, rapes, reaps, spare, spear]
Enter a word (blank line to end) > eat
[ate, eat, eta, tea]
Enter a word (blank line to end) > grape
[gaper, grape]
Enter a word (blank line to end) > cry
[cry]
Enter a word (blank line to end) > xyxxy
null
Enter a word (blank line to end) >
