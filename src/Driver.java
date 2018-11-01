import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {

    public static void main(String args[]){
        // A = 5, 8, 3, 9, 10
        // B = 1, 2, 3, 4, 5, 6, 7, 10, 44

        Set A = new Set();
        Set B = new Set();

        A.add(9);
        A.add(8);
        A.add(3);
        A.add(10);
        A.add(5);

        B.add(1);
        B.add(10);
        B.add(3);
        B.add(2);
        B.add(4);
        B.add(5);
        B.add(6);
        B.add(44);
        B.add(7);

        printVector(A.getSet());
        printVector(B.getSet());
        System.out.println("");
        System.out.println("");

        printVector(A.union(A, B).getSet());
        System.out.println("");

        printVector(A.intersection(A, B).getSet());
        System.out.println("");

        printVector(A.difference(A, B).getSet());
        System.out.println("");


        System.out.println("");
        System.out.println("is subset? " + A.subset(A, B));

    }

    public static void printVector(Vector<Integer> v) {
            for (int i = 0; i < v.size(); i++) {
                System.out.print(" " + v.get(i));
            }
            System.out.println("");
    }

}


