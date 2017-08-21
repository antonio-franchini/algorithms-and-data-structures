import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {
    static public void main(String args[]){

    int arr[] = {6,3,1,9,7,14,25,2,4,3};

    MaxHeap l = new MaxHeap(arr);

    l.print();

    l.getRoot();

    l.print();

    }

}


