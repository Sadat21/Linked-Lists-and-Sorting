/**
 * Created by Sadat Msi on 2/9/2017.
 */
public class Vector {

    private int sizeM;
    private int capM;
    private LinkedList [] storageM;


    public Vector(){
        this.sizeM = 0;
        this.capM = 1;
        storageM = new LinkedList[capM];

    }


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

    public int getSize(){
        return sizeM;
    }

    public LinkedList getLinkedList(int index){
        return storageM[index];
    }

    public void setIndex(LinkedList x, int i){
        storageM[i] = x;
    }
}
