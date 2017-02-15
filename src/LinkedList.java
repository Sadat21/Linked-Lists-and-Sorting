/**
 * Created by Sadat Msi on 2/5/2017.
 *
 * User created linkedList class
 */
public class LinkedList {
    public Node head;

    public LinkedList(){
        this.head = null;
    }

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





}
