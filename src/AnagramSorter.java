import java.io.*;
/**
 * Created by Sadat Msi on 2/5/2017.
 *
 * Arranges a list of words into sperate lists of anagrams. Takes a text file as an input that contains
 * a list of words, each word on it's own line. Prints to an output text file that:
 *  1: All words that are anagrams are on the same line
 *  2: Words of each line are in alphabetical order
 *  3: Lines of words are in alphabetical order
 *  4: Words in a line are separated by a single space.
 */
public class AnagramSorter {
    /**
     * Checks if an String is greater then 1, and returns a sorted array as a string.
     * @param x String to be sorted based on it's chars
     * @return
     */
    public static String stringSort(String x){
        if(x.length() == 1) { return x; }       //2 op

        char storage [];                        //1 op
        InsertionSort sort = new InsertionSort();   // 1 op
        storage = x.toCharArray();              //3 op
        sort.sortChars(storage);                // 3 op
        return new String(storage);             // 3 op
    }

    /**
     * Fufills the requirements stated in the class description
     * @param args (input file, output file)
     */
    public static void main (String [] args){

        //Start the timer
        System.out.println("Sorting the " + args[0] + " file and will put it in the " + args[1] + " file.");
        long start = System.nanoTime();

        Vector main_array = new Vector();

        //Putting the words into the main array
        try{

            String word;
            String filePath = ("input/" + args[0]);
            BufferedReader buff = new BufferedReader(new FileReader(filePath));

            while( (word = buff.readLine()) != null ){
                if(main_array.getSize() == 0){
                    Node temp_node = new Node(word, null);
                    LinkedList temp_list = new LinkedList(temp_node);
                    main_array.add(temp_list);
                }
                else {
                    boolean cont = true;

                    for (int i = 0; cont && i < main_array.getSize(); i++) {    //1 op to intitalize, 4ops each iteration
                        String temp_data = main_array.storageM[i].head.data;    //5 ops
                        if( temp_data.length() == word.length() ){              //5 ops
                            String temp1 = stringSort(temp_data);               //3 ops
                            String temp2 = stringSort(word);                    //3 ops
                            if(temp1.compareTo(temp2) == 0){
                                main_array.storageM[i].add(word);
                                cont = false;
                            }
                        }

                    }
                    if(cont == true){
                        Node temp_node = new Node(word, null);
                        LinkedList temp_list = new LinkedList(temp_node);
                        main_array.add(temp_list);
                    }
                }

            }
            buff.close();

        }
        catch (IOException e){
            System.err.println("An IOException was caught: " + e.getMessage());
            System.exit(1);

        }

        //Sort the linked lists
        InsertionSort sort_lists = new InsertionSort();
        for( int i = 0; i < main_array.getSize(); i++)
        {
            main_array.setIndex( sort_lists.sortLinkedLists( main_array.storageM[i]), i );
        }

        //Sort the Vector
        QuickSort sort = new QuickSort();
        sort.quickSort(main_array);

        //End the timer
        long end = System.nanoTime();
        long time_elapsed = end - start;
        System.out.println("Time taken is: " + (time_elapsed * 1E-9) + " seconds to load and sort the array.");


        //Output main Array
        //Output to file

        try
        {
            FileWriter writer = new FileWriter(args[1]);
            for( int i = 0; i < main_array.getSize(); i++)
            {
                Node temp = main_array.storageM[i].head;
                do {
                    writer.write(temp.data + " ");
                    temp = temp.next;

                }while(temp != null);
                writer.write("\r\n");

            }
            writer.close();

        } catch(IOException e){
            System.err.println("An IOException was caught: " + e.getMessage());
        }
    }
}
