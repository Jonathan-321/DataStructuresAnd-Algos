package doublylinkedlists;

import java.util.ArrayList;

/**
 * This class represents a doubly linked list data structure.
 * It allows adding elements to the beginning and end of the list,
 * removing elements from the beginning and end of the list,
 * and provides methods to convert the list to an array and clone the list.
 */ 

public class doublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    /**
     * Constructs an empty doubly linked list.
     * @return 
     */
    public doublyLinkedList() {

        head = new Node(null, null, null);
        tail = new Node(null, head, null);
        head.setNext(tail); 
        size = 0;

    }
    /**
     * This class represents a node in the doubly linked list.
     * Each node contains an element and references to the previous and next nodes.
     */
    private class Node {
        private Object element;
        private Node previous;
        private Node next;

        public Node(Object element, Node previous, Node next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
        public Object getElement() {
            return element;
        }
        public Node getPrevious() {
            return previous;
        }
        public Node getNext() {
            return next;
        }
        public void setPrev(Node previous) {
            this.previous = previous;
        }
        public void setNext(Node next) {
            this.next = next;
        }
    }
    /**
     * Returns the number of elements in the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }  

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0; 
    }

    /**
     * Adds an element to the beginning of the list.
     *
     * @param element the element to be added
     */


    public void addFirst(Object element) {
        addBetween(element, head, head.getNext());
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param element the element to be added
     */
    public void addLast(Object element) {
        addBetween(element, tail.getPrevious(), tail);
    }

    /**
     * Removes and returns the first element of the list.
     *
     * @return the first element of the list
     */
    public Object removeFirst() {
        if (isEmpty()) return null;
        return remove(head.getNext());
    }

    /**
     * Removes and returns the last element of the list.
     *
     * @return the last element of the list
     */
    public Object removeLast() {
        if (isEmpty()) return null;
        return remove(tail.getPrevious());
    }

    // private update methods

    /**
     * Adds element to the linked list between the given nodes.
     *
     * @param element     the element to be added
     * @param predecessor the predecessor node
     * @param successor   the successor node
     */
    private void addBetween(Object element, Node predecessor, Node successor) {
        Node newest = new Node(element, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    /**
     * Removes the given node from the list and returns its element.
     *
     * @param node the node to be removed
     * @return the element of the removed node
     */
    private Object remove(Node node) {
        Node predecessor = node.getPrevious();
        Node successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    /**
     * Converts the list to an array starting from the first element.
     *
     * @return an ArrayList containing the elements of the list in the order they appear
     */

    public ArrayList<Object> toArrayFromFirst() {
        ArrayList<Object> list = new ArrayList<>();
        Node current = head;
        while (current != null) {
            list.add(current.element);
            current = current.next;
        }
        return list;
    }

    /**
     * Converts the list to an array starting from the last element.
     *
     * @return an ArrayList containing the elements of the list in reverse order
     */

    public ArrayList<Object> toArrayFromLast() {
        ArrayList<Object> list = new ArrayList<>();
        Node current = tail;
        while (current != null) {
            list.add(current.element);
            current = current.previous;
        }
        return list;
    }

    /**
     * Creates a shalow copy of the list.
     *
     * @return a new LinkedLists object with the same elements as the original list
     */

    public doublyLinkedList clone() {
        doublyLinkedList listCopy = new doublyLinkedList();
        Node current = head;
        while (current != null) {
            listCopy.addLast(current.element);
            current = current.next;
        }
        return listCopy;
    }
    
}







