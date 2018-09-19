package assignment3;

// code taken from class notes 
//used separate classes for LinkedList and LinkedListElement
public class LinkedListElement<E> {
	E e;
	LinkedListElement<E> next;
	
	public LinkedListElement(E e0, LinkedListElement<E> n) { 
		e = e0; next = n;
		}

}
