import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {

    public static void main(String args[]){
        int matrix[][] = {
                { 1,   2,  3,  4,  5},
                { 6,   7,  8,  9, 10},
                { 11, 12, 13, 14, 15},
                { 16, 17, 18, 19, 20},
                { 21, 22, 23, 24, 25},
        };

        MatrixUtil m = new MatrixUtil();
        m.rotateMatrix(matrix);

        MyPrinter p = new MyPrinter();
        p.printArray(matrix);
    }

}


