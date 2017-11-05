package assignment3;

// code taken from class notes
// used separate classes for LinkedList and LinkedListElement
public class LinkedList<E> {
	
	  LinkedListElement<E> head = null, tail = null;
	  
	  // push into stack
	  void addHead(E e) {
	    head = new LinkedListElement<E>(e, head);
	    if(tail == null)
	      tail = head;
	    }
	  
	  // pop out of stack
	  public E removeHead() {
		  E temp = head.e;
	      head = head.next;
	      if(head == null)
	        tail = null;
	      return temp;
	      }
}
