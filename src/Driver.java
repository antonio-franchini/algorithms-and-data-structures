import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {
    static public void main(String args[]){

    int arr[] = {1,3,6,9,11,14,25};
        //int arr[] = {6,3,1,9,7,14,25,2,4,3};

    NumFinder l = new NumFinder();
    System.out.println("Return value is: " + l.pairSumsToTarget(arr, 6));

    }

}


