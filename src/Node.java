/**
 * User implementation of a Node for a Linked List
 * Created by Sadat Msi on 2/5/2017.
 */
public class Node {
    /**
     * Data contained in a Node
     */
    public String data;
    /**
     * Points to the next Node
     */
    public Node next;

    /**
     * Constructs a node with the fields provided
     * @param data
     * @param next
     */
    public Node( String data, Node next){
        this.data = data;
        this.next = next;
    }

}
