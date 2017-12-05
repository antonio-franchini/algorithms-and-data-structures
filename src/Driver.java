import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {

    public static void main(String args[]){
        int A[][] = {
                { 1,   2},
                { 3,   4},
        };

        int B[][] = {
                { 2,   0},
                { 1,   2},
        };

        MatrixUtil m = new MatrixUtil();
        int[][] C = m.multiply( A, B );

        MyPrinter p = new MyPrinter();
        p.printArray(C);
    }

}


