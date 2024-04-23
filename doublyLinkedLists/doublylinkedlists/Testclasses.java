package doublylinkedlists;
import java.util.ArrayList;


public class   Testclasses {
    public static void main(String[] args) {
        doublyLinkedList list = new doublyLinkedList();

        // Add strings to the list
        list.addFirst("USA");
        list.addLast("Germany");
        list.addFirst("France");
        list.addLast("England");
        list.addFirst("Belgium");
        
 
        // Print list from beginning to end

        ArrayList<Object> listFromFirst = list.toArrayFromFirst();
        System.out.println("List from first to last: " + listFromFirst);

        // Print list from end to beginning
        ArrayList<Object> listFromLast = list.toArrayFromLast();
        System.out.println("List from last to first: " + listFromLast);

        // Clone the list
        doublyLinkedList listClone = list.clone();

        // Print cloned list from beginning to end
        ArrayList<Object> clonedListFromFirst = listClone.toArrayFromFirst();
        System.out.println("Cloned list from first to last: " + clonedListFromFirst);
    }
}