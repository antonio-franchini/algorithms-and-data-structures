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

        r.permutations("abcd");
    }

}


