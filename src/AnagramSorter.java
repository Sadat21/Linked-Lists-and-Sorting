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


    public static String charSort(String x){
        if(x.length() == 1) { return x; }

        char storage [];
        InsertionSort sort = new InsertionSort();
        storage = x.toCharArray();
        sort.sortChars(storage);

        return new String(storage);
    }




    /**
     *
     * @param args
     */
    public static void main (String [] args){

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

                    for (int i = 0; cont && i < main_array.getSize(); i++) {
                        String temp_data = main_array.getLinkedList(i).head.data;
                        if( temp_data.length() == word.length() ){
                            String temp1 = charSort(temp_data);
                            String temp2 = charSort(word);
                            if(temp1.compareTo(temp2) == 0){
                                main_array.getLinkedList(i).add(word);
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

        }

        //Sort the linked lists
        InsertionSort sort_lists = new InsertionSort();
        for( int i = 0; i < main_array.getSize(); i++)
        {
            main_array.setIndex( sort_lists.sortLinkedLists( main_array.getLinkedList(i)), i );
        }



        //Output main Array
        //Output to file

        try
        {
            FileWriter writer = new FileWriter(args[1]);
            for( int i = 0; i < main_array.getSize(); i++)
            {
                Node temp = main_array.getLinkedList(i).head;
                do {
                    writer.write(temp.data + " ");
                    temp = temp.next;

                }while(temp != null);
                writer.write("\r\n");

            }

            writer.close();





        } catch(IOException e){
            e.printStackTrace();
        }







    }


}
