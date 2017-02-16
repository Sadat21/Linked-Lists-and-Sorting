/**
 * User created Vector Class
 * Created by Sadat Msi on 2/9/2017.
 */
public class Vector {
    /**
     * Size of the Vector
     */
    private int sizeM;
    /**
     * Max capacity of the current Vector
     */
    private int capM;
    /**
     * Data structure to hold the refereces of linked lists
     */
    public LinkedList [] storageM;

    /**
     * Constructs an empty vector with a capacity of 1
     */
    public Vector(){
        this.sizeM = 0;
        this.capM = 1;
        storageM = new LinkedList[capM];

    }

    /**
     * Adds a new Linked List reference to the end of the vector, expands vector if there is no space
     * @param newList
     */
    public void add(LinkedList newList){
        if(sizeM + 1 > capM)
        {
            capM *= 2;
            LinkedList [] temp = new LinkedList[capM];
            for(int i = 0; i < sizeM; i++)
            {
                temp[i] = storageM[i];
            }
            temp[sizeM] = newList;
            storageM = temp;
            sizeM++;


        }
        else {
            storageM[sizeM] = newList;
            sizeM++;
        }

    }

    /**
     * Returns the size of the vector
     * @return sizeM
     */
    public int getSize(){
        return sizeM;
    }

    /**
     * Set's an index of the Vector with a Linked List reference
     * @param x Linked List reference to be inserted
     * @param i index of the vector
     */
    public void setIndex(LinkedList x, int i){
        storageM[i] = x;
    }
}
