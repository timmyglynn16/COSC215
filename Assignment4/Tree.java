package assignment4;

import java.util.Scanner;

public class Tree<K extends Comparable,D> {

	private Node<K,D> root; // start with a root node, thats how we traverse the tree 

	public Tree() { root = null; }

	public Tree(K[] keys, D[] data) {
		root = buildTree(keys, data, 0, keys.length-1);
	}

	// from class
	private Node<K,D> buildTree(K[] keys, D[] data, int lo, int hi) {
		if(lo > hi)
			return null;
		int m = (hi - lo) / 2 + lo;
		return new Node(keys[m], data[m], buildTree(keys, data, lo, m-1), buildTree(keys, data, m+1, hi));
	}

	// from class
	private D find(K key, Node<K,D> x) {
		if(x == null)
			return null;
		int c = key.compareTo(x.key); 
		if(c == 0)
			return x.data;
		else if(c < 0) 
			return find(key, x.left);
		else // c > 0
			return find(key, x.right);
	} 

	public D find(K key) {
		return find(key, root);
	}

	// from class
	// add the data that will go inside the node that we will be creating
	private Node<K,D> add(K key, D data, Node<K,D> root) {

		// returns the tree with the added record.
		// pass in the data into the new node we are creating
		// add it to the tree itself
		if(root == null)
			return new Node<K,D>(key,data); 
		int c = key.compareTo(root.key); 

		// error message 
		if(c == 0) {
			System.err.println("Error: duplicate key: "+key);
			System.exit(1);
			return null;
		}

		// if c < 0, traverse left child, else traverse the right child...
		// until we get to a node that we can't traverse... insert our new node
		else if(c < 0) {
			root.left =  add(key, data, root.left);
			return root;
		}
		else { // if  c > 0
			root.right = add(key, data, root.right);
			return root;
		}
	}

	public void add(K key, D data) {
		root = add(key, data, root);
	}

	//from class
	private void modify(K key, D data, Node<K,D> root) {
		if(root == null) {
			System.err.println("Error: key not found: "+key);
			System.exit(1);
		}
		int c = key.compareTo(root.key);
		if(c == 0)
			root.data = data;
		else if(c < 0) 
			modify(key, data, root.left);
		else // c > 0
			modify(key, data, root.right);
	}
	
	//from class
	public void modify(K key, D data) {
		modify(key, data, root);
	}

	// from class
	private Node<K,D> findLeftmost(Node<K,D> root) {
		// Assumes root != null.
		return root.left == null 
				? root
						: findLeftmost(root.left);
	}

	// from class
	private Node<K,D> removeLeftmost(Node<K,D> root) {
		if(root.left == null) 
			return root.right;
		else {
			root.left = removeLeftmost(root.left);
			return root;
		}
	}

	// from class
	private Node<K,D> delete(K key, Node<K,D> root) {
		if(root == null) {
			System.err.println("Error: key not found");
			System.exit(1);
			return null;
		}
		int c = key.compareTo(root.key);
		if(c == 0) {
			if(root.left == null)
				return root.right;
			else if(root.right == null)
				return root.left;
			else {
				Node<K,D> t = root;
				root = findLeftmost(root.right);
				root.right = removeLeftmost(t.right);
				root.left = t.left;
				return root;
			}
		}
		else if(c < 0) {
			root.left = delete(key, root.left);
			return root;
		}
		else { // c > 0
			root.right = delete(key, root.right);
			return root;
		}
	}

	// from class
	public void delete(K key) {
		root = delete(key, root);
	}

	int height(Node node)
	{
	   //base case
	   if(node == null)
	       return 0;
	
	   //1 for current node + the max height between either side
	   return 1 + Math.max(height(node.left), height(node.right));
	}

	// from class
	private String toString(Node<K,D> root) {
		if(root == null)
			return "";
		return toString(root.left) 
				+ "(" + root.key + "," 
				+ root.data + ")" 
				+ toString(root.right);
	}

	//helper function for toString
	public String toString() {
		return toString(root);
	}
	
	// ASSIGNMENT: METHOD 1
	//same thing as the toString, but traverse right instead of left
	private String toStringReversed(Node<K,D> root){
		if(root == null)
			return "";
		return toStringReversed(root.right) 
				+ "(" + root.key + "," 
				+ root.data + ")" 
				+ toStringReversed(root.left);
	}
	
	public String toStringReversed() {
		return toStringReversed(root);
	}
	

	// ASSIGNMENT: METHOD 2
	public Node ceiling(K key){
		return ceiling(key,root);
	}
	// returns the node with the smallest key that is greater than or
	//equal to key. If key is in the tree, then the node containing key is returned. If key is greater than any
	//key in the true, null is returned. 

	//basically same as find code but you switch around a little bit the caveat for >= and <= for floor
	public Node ceiling(K key, Node<K,D> x){
		if(x == null)
			return null;
		int c = key.compareTo(x.key); 
		if(c == 0)
			return x;
		else if(c < 0){ 
			if(x.left == null){
				return x;
			}
			return ceiling(key, x.left);
		}
		else // c > 0
			if(x.right == null){
				//this caveat check here is only for the ceiling function, since we need to check if its the max
				int max = key.compareTo(x.key); 
				if(max > 0) //key is max of tree
					return null;
				return x;
			}
		return ceiling(key, x.right);
	}

	// ASSIGNMENT: METHOD 3
	public Node floor(K key){
		return floor(key,root);
	}
	// returns the node with the largest key that is less than or equal to
	//key. If key is in the tree, then the node containing key is returned. If key is less than any key in the
	//true, null is returned. 

	//basically same as find code but you switch around a little bit the case for >= and <= for floor
	public Node floor(K key, Node<K,D> x){

		if(x == null)
			return null;
		int c = key.compareTo(x.key); 

		if(c == 0)
			return x;
		else if(c < 0){ 
			//System.out.println("x.left =" + x.left.key);
			if(x.left == null){

				//this check here is only for the floor function, since we need to check if its the min
				int min = key.compareTo(x.key); 
				if(min < 0) //key is min of tree
					return null;
				return x;
			}
			return floor(key, x.left);
		}
		else // c > 0
			if(x.right == null){

				return x;
			}
		return floor(key, x.right);
	}
		
	// ASSIGNMENT: METHOD 4
	//helper function for diameter
	public int diameter(){
		return diameter(root);
	}
	
	//pass the node to start on
	public int diameter(Node node){
		
		//base case
		if(node == null){
			return 0;
		}
		//outer heights
		int leftheight = height(node.left);
		int rightheight = height(node.right);

		//subtrees
		int leftDiameter = diameter(node.left);
		int rightDiameter = diameter(node.right);
		
		int outerHeights = leftheight + rightheight;
		//if the left is less, check vs the outer
		if(leftDiameter > rightDiameter){
			//if the outer is more, return that + current node
			if(outerHeights > leftDiameter){
				return outerHeights+1;
			}
			return leftDiameter;
		}
		else{
			//if the outer is more, return that + current node
			if(outerHeights > rightDiameter){
				return outerHeights+1;
			}
			return rightDiameter;
		}
}
	
	// ASSIGNMENT: METHOD 5
	// helper function for numBetween
		public int numBetween(K low, K high){
			return numBetween(root, low, high);
		}
		
		public int numBetween(Node node, K low, K high)
		{
		    // Base case
		    if (node == null)
		    	return 0;
		
		    // split off left and right
		    if ((node.key.compareTo(high) <= 0) && (node.key.compareTo(low) >= 0))
		         return 1 + numBetween(node.left, low, high) +
		        		 numBetween(node.right, low, high);
		 
		    //traverse right
		    else if (node.key.compareTo(low) < 0)
		         return numBetween(node.right, low, high);
		 
		    //traverse left
		    else return numBetween(node.left, low, high);
		}
	
public static void main(String[] args) {
	
	int i;
	
	// arrays for keys/data - couldn't figure out to use ArrayList here
	Character[] keys = new Character[6];
	String[] dataArr = new String[6];
	
	Scanner sc = new Scanner(System.in);
	
	char key;
	char key1;
	char key2;
	String data;	
	
	// have user enter their keys to create their own tree
	System.out.println("Enter keys to create your tree");
	key = sc.next().charAt(0);
	i = 0;
	while(key != ' ' && i != 6) {
		keys[i] = key;
		i++;
		key = sc.next().charAt(0);
	}
	
	// enter your data (this is arbitrary and kind of irrelevant for this assignment
	// but if the user wanted to do previous tasks from class, this would help
	System.out.println("Enter your data");
	data = sc.next();
	i = 0;
	while(data != " " && i != 6) {
		dataArr[i] = data;
		i++;
		data = sc.next();
	}
	
	// declare the tree
	Tree<Character, String> tree = new Tree<Character, String>(keys, dataArr);
	System.out.println("Your tree is " + tree);
	
	
	//for ceiling/floor: was trying to make error messages for null exception, didnt work
	//Node<Character, String> nodeCeil = tree.ceiling(key);
	//Node<Character, String> nodeFloor = tree.floor(key);
	
	// reverse
	System.out.println("Your tree reversed is " + tree.toStringReversed());

	
	// ceiling 
	System.out.println("Enter your ceiling key");
	key = sc.next().charAt(0);
	System.out.println("The ceiling of " + key + " is " + tree.ceiling(key).key);;
	
	// floor
	System.out.println("Enter your floor key");
	key = sc.next().charAt(0);
	System.out.println("The floor of " + key + " is " + tree.floor(key).key);

	// diameter
	System.out.println();
	System.out.println("The diameter of the tree is " + tree.diameter());
	System.out.println();
	
	// numBetween
	System.out.println("Enter two keys");
	key1 = sc.next().charAt(0);
	key2 = sc.next().charAt(0);
	System.out.println("The number of records between " + key1 + " and " + key2 + " is " 
			+ tree.numBetween(key1, key2));


}


}
