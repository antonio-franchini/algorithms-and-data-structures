import java.util.ArrayList;

public class Driver {

    public static void main(String args[]) {

        boolean grid[][] = {
                {true,  false, false, false, false},
                {true,  false, false, false, false},
                {true,  true,  true,  true,  true},
                {false, false, true,  false, true},
                {false, false, true,  true,  true},
        };

        Recursion r = new Recursion();
//        r.findPaths(grid);

        Set set = new Set();
        set.add(1);
        set.add(2);
        set.add(3);

//        r.printSubsets(set);

//        r.permutations("abcd");
//        r.printParentheses(3);

        int screen[][] = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };

        r.paintFill(screen, 4, 3, 1);
        MyPrinter myPrinter = new MyPrinter();
        myPrinter.printArray(screen);
    }

}


