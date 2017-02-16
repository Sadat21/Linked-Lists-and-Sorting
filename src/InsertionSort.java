/**
 * Uses insertion sort to sort a linked list or an array of chars
 * Created by Sadat Msi on 2/5/2017.
 */
public class InsertionSort {

    /**
     * Sorts a linked list into lexicographic order
     * @param x
     */
    public LinkedList sortLinkedLists(LinkedList x)
    {
        if(x.head.next == null) {return x;}

        LinkedList temp_list = new LinkedList();
        temp_list.head = new Node(x.head.data, null);

        Node temp_node = x.head.next;
        do{
            if( (temp_node.data).compareTo(temp_list.head.data) <= 0 ){
                temp_list.add(temp_node.data);
            }
            else{
                Node temp = temp_list.head;
                while( temp.next != null && (temp_node.data).compareTo(temp.next.data) > 0  ){
                    temp = temp.next;
                }
                temp_list.insertAfter(temp_node.data, temp);
            }

            temp_node = temp_node.next;
        }while(temp_node != null);

        return x = temp_list;
    }

    /**
     * Sorts an array of chars
     * @param arr
     */
    public void sortChars(char [] arr)
    {
        for( int i = 1, j; i < arr.length; i++)
        {
            char temp = arr[i];
            for( j = i; j > 0 && temp < arr[j - 1]; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }
}
