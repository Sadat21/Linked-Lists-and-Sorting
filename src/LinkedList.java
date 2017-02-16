/**
 * Created by Sadat Msi on 2/5/2017.
 *
 * User created linkedList class
 */
public class LinkedList {
    /**
     * Points to the first node
     */
    public Node head;

    /**
     * Constructs an empty Linked List
     */
    public LinkedList(){
        this.head = null;
    }

    /**
     * Constructor that makes the newNode the first element
     * @param newNode
     */
    public LinkedList(Node newNode){
        this.head = newNode;
    }

    /**
     * Add's a Node to the beginning of the linked list
     * @param data data to be added
     */
    public void add(String data){
        Node temp = new Node(data, head);
        head = temp;
    }

    /**
     * Insert into middle or end of a linked list
     * @param data data to be inserted
     * @param prev Node that will precede the data to be inserted
     */
    public void insertAfter(String data, Node prev){
        Node temp = new Node(data, prev.next);
        prev.next = temp;
    }

}
