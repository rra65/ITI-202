/******************************************************************************
 *  source code for this class was downloaded from: 
 *  http://introcs.cs.princeton.edu/java/43stack/
 ******************************************************************************/
package blackJack;

public class StackOfObjects {
	//instance variable
    private Node first; //this node is the "top" of the stack

    // linked list node helper data type
    private class Node {
        private Object item;
        private Node next;
    }

    //this constructor creates an empty stack
    public StackOfObjects() {
        first = null;
    }

    //returns true if the stack is empty
    public boolean isEmpty() {
        return first == null;
    }

    //"pushing" adds an item to a stack
    public void push(Object item) {
        Node oldfirst = first; //store the previous first item in the stack
        first = new Node(); //make first a new node
        first.item = item; //set first.item to the Object item
        first.next = oldfirst; //set the link to the old first from the new
    }

    //"popping" removes the most recent item
    public Object pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow"); //if you try to pop but nothing is there
        Object item = first.item; //this stores the item before it is "popped"
        first = first.next; // the first item is now what was the second item
        return item; //return the item we stored
    }
}