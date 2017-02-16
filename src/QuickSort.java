/**
 * Implementation of my previous quicksort but to work with Vector containing LinkedLists
 * Created by Sadat Msi on 2/5/2017.
 */
public class QuickSort {

    /**
     * Sorts an array into ascending order
     *
     * Code received from Drozdek- Data Structures and Algorithms in Java 2nd Edition
     * @param arr master vector
     * @param first index of first element of sub array
     * @param last index of last element of sub array
     */
    public void quickSort( Vector arr, int first, int last)
    {
        int lower = first + 1, upper = last;
        swap( arr, first, (first + last) / 2);

        // How we chose the pivot (mid point)
        String pivot = arr.storageM[first].head.data;

        while( lower <= upper)
        {
            while( arr.storageM[lower].head.data.compareTo(pivot) <= 0)
                lower++;
            while( arr.storageM[upper].head.data.compareTo(pivot) > 0)
                upper--;
            if( lower < upper)
                swap( arr, lower++, upper--);
            else
                lower++;
        }
        swap( arr, upper, first);
        if( first < upper - 1)
            quickSort( arr, first, upper - 1);
        if( upper + 1 < last)
            quickSort( arr, upper + 1, last);

    }

    /**
     * Finds the largest value in the array and moves it to the correct spot, this is to
     * solve out of bound errors.
     *
     * Code received from Drozdek- Data Structures and Algorithms in Java 2nd Edition
     * @param arr array to be sorted
     */
    public void quickSort( Vector arr)
    {
        if( arr.getSize() < 2)
            return;
        int max = 0;
        for(int i = 1; i < arr.getSize(); i++)
            if( arr.storageM[i].head.data.compareTo(arr.storageM[max].head.data)  > 0 )
                max = i;
        swap(arr, arr.getSize() - 1, max);
        quickSort( arr, 0, arr.getSize() - 2);


    }

    /**
     * Swaps the contents of the vector
     * @param arr
     * @param a
     * @param b
     */
    private void swap( Vector arr, int a, int b)
    {
        LinkedList temp = arr.storageM[a];
        arr.storageM[a] = arr.storageM[b];
        arr.storageM[b] = temp;
    }
}
