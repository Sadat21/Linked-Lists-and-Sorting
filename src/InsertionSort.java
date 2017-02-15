/**
 * Created by Sadat Msi on 2/5/2017.
 */
public class InsertionSort {

    /**
     *
     * @param x
     */
    /*private static void InsertionSort( LinkedList x)
    {
        for( int i = 1, j; i < x.length; i++)
        {
            int temp = x[i];
            for( j = i; j > 0 && temp < arr[j - 1]; j--)
                x[j] = x[j - 1];
            x[j] = temp;
        }
    }*/

    /**
     * Sorts an array of chars
     * @param arr
     */
    public void insertionSort( char [] arr)
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
