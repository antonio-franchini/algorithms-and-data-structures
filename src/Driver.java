import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {
    static public void main(String args[]){
        SelectionSort l = new SelectionSort();

        int testArr[] = {2,7,3,9,5,4,8};

        l.printArray(testArr);

        l.sort(testArr);

        l.printArray(testArr);
    }

}


