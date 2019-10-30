import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class Recursion {

    /***************************************************************************************************************************
     8.1
     Write a method to generate the nth Fibonacci number
     ***************************************************************************************************************************/

    public int fibonacciIterative(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int nMinusOne = 1;
        int nMinusTwo = 1;

        for (int i = 2; i < n; i++) {
            int temp = nMinusTwo;
            nMinusTwo = nMinusOne;
            nMinusOne = nMinusOne + temp;
        }
        return nMinusOne + nMinusTwo;
    }

    public int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    /***************************************************************************************************************************
     8.2
     Imagine a robot sitting on the upper left hand corner of an NxN grid The robot can only move in two directions:
     right and down How many possible paths are there for the robot?
     FOLLOW UP
     Imagine certain squares are “off limits”, such that the robot can not step on them.  Design an algorithm to get all
     possible paths for the robot
     ***************************************************************************************************************************/

    public class PathNode {
        PathNode parent;
        ArrayList<PathNode> children;
        String move;

        PathNode(PathNode parent, String move) {
            this.parent = parent;
            this.move = move;
            this.children = new ArrayList<>();
        }
    }

    public void findPaths(boolean[][] grid) {
        ArrayList<PathNode> paths = new ArrayList<>();
        PathNode destination = createMoveTree(grid, paths);
        paths.forEach(path ->
        {
            PathNode i = path;
            while (i.parent != null) {
                System.out.print(i.move + " ");
                i = i.parent;
            }
            System.out.println();
        });
    }

    public PathNode createMoveTree(boolean[][] grid, ArrayList<PathNode> paths) {
        PathNode destination = new PathNode(null, "destination");
        int n = grid.length;

        if (n == 0 || n == 1) {
            return null;
        }

        if (grid[n - 1][n - 2]) {
            PathNode up = new PathNode(destination, "right");
            destination.children.add(up);
            move(up, grid, n - 1, n - 2, paths);
        }

        if (grid[n - 2][n - 1]) {
            PathNode left = new PathNode(destination, "down");
            destination.children.add(left);
            move(left, grid, n - 2, n - 1, paths);
        }

        return destination;
    }

    public void move(PathNode pathNode, boolean[][] grid, int x, int y, ArrayList<PathNode> paths) {
        if (x == 0 && y == 0) {
            paths.add(pathNode);
            return;
        }

        if (y - 1 >= 0 && grid[x][y - 1]) {
            PathNode up = new PathNode(pathNode, "right");
            pathNode.children.add(up);
            move(up, grid, x, y - 1, paths);
        }

        if (x - 1 >= 0 && grid[x - 1][y]) {
            PathNode left = new PathNode(pathNode, "down");
            pathNode.children.add(left);
            move(left, grid, x - 1, y, paths);
        }
    }


    /***************************************************************************************************************************
     8.3
     Write a method that returns all subsets of a set
     ***************************************************************************************************************************/
    public class SubsetNode {
        SubsetNode parent;
        ArrayList<SubsetNode> children;
        Integer data;

        SubsetNode(SubsetNode parent, Integer data) {
            this.parent = parent;
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public void printSubsets(Set set) {
        ArrayList<SubsetNode> subsets = new ArrayList();
        findSubsets(set, subsets);
        subsets.forEach((subset) ->
        {
            System.out.print("{ ");
            SubsetNode i = subset;
            while (i != null) {
                if (i.data != null) {
                    System.out.print(i.data + " ");
                }
                i = i.parent;
            }
            System.out.println("}");
        });
    }

    public SubsetNode findSubsets(Set set, ArrayList<SubsetNode> subsets) {
        int index = 0;
        SubsetNode root = new SubsetNode(null, null);
        findSubsetsHelper(set, index, root, subsets);
        return root;
    }

    public void findSubsetsHelper(Set set, int index, SubsetNode node, ArrayList<SubsetNode> subsets) {

        if (index >= set.items.size()) {
            subsets.add(node);
            return;
        }

        SubsetNode exclude = new SubsetNode(node, null);
        SubsetNode include = new SubsetNode(node, set.items.elementAt(index));

        findSubsetsHelper(set, index + 1, exclude, subsets);
        findSubsetsHelper(set, index + 1, include, subsets);

    }


    /***************************************************************************************************************************
     8.4
     Write a method to compute all permutations of a string
     ***************************************************************************************************************************/
    public class PermNode {
        PermNode parent;
        ArrayList<PermNode> children;
        Character data;

        public PermNode(PermNode parent, Character data) {
            this.parent = parent;
            this.children = new ArrayList<>();
            this.data = data;
        }
    }

    public void permutations(String string) {
        PermNode root = new PermNode(null, null);
        ArrayList<PermNode> leaves = new ArrayList<>();
        permutationsHelper(string, root, leaves);
        leaves.forEach(leaf ->
        {
            PermNode i = leaf;
            while (i.parent != null) {
                System.out.print(i.data + "");
                i = i.parent;
            }
            System.out.println();
        });
    }

    public void permutationsHelper(String string, PermNode node, ArrayList<PermNode> leave) {
        if (string.length() == 1) {
            PermNode leaf = new PermNode(node, string.charAt(0));
            node.children.add(leaf);
            leave.add(leaf);
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            PermNode current = new PermNode(node, string.charAt(i));
            node.children.add(current);
            permutationsHelper(string.substring(0, i) + string.substring(i + 1), current, leave);
        }
    }


    /***************************************************************************************************************************
     8.5
     Implement an algorithm to print all valid(e g, properly opened and closed) combinations of n-pairs of parentheses
     EXAMPLE:
     input:3(e g, 3 pairs of parentheses)
     output:()()(),()(()),(())(),((()))
     ***************************************************************************************************************************/

    public class ParenNode {
        ParenNode parent;
        ArrayList<ParenNode> children;
        String data;

        ParenNode(ParenNode parent, String data) {
            this.parent = parent;
            this.children = new ArrayList<>();
            this.data = data;
        }
    }

    public void printParentheses(int n) {

        // Check for zero case
        if (n == 0) {
            System.out.println("Nothing!");
            return;
        }
        // Get tree of combinations
        ParenNode root = new ParenNode(null, ")");
        ArrayList<ParenNode> leaves = new ArrayList<>();
        int remainingCount = n - 1;
        int openCount = 1;
        findCombinations(remainingCount, root, leaves, openCount);

        //Print all combinations
        leaves.forEach(leave -> {
            while (leave != null) {
                System.out.print(leave.data);
                leave = leave.parent;
            }
            System.out.println("");
        });
    }

    public void findCombinations(int remainingCount, ParenNode node, ArrayList<ParenNode> leaves, int openCount) {
        if (remainingCount == 0 && openCount == 0) {
            leaves.add(new ParenNode(node, ""));
        }
        if (remainingCount > 0) {
            ParenNode current = new ParenNode(node, ")");
            node.children.add(current);
            findCombinations(remainingCount - 1, current, leaves, openCount + 1);
        }
        if (openCount > 0) {
            ParenNode current = new ParenNode(node, "(");
            node.children.add(current);
            findCombinations(remainingCount, current, leaves, openCount - 1);
        }
    }


    /***************************************************************************************************************************
     8.6
     Implement the “paint fill” function that one might see on many image editing programs That is, given a screen
     (represented by a 2 dimensional array of Colors), a point, and a new color, fill in the surrounding area until you hit
     a border of that color
     ***************************************************************************************************************************/
    public void paintFill(int[][] screen, int x, int y, int color) {
        if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length) {
            return;
        }

        if (screen[x][y] == color) {
            return;
        }

        screen[x][y] = color;
        paintFill(screen, x - 1, y, color);
        paintFill(screen, x + 1, y, color);
        paintFill(screen, x, y - 1, color);
        paintFill(screen, x, y + 1, color);
    }

/***************************************************************************************************************************
 8.7
 You have two Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent),
 write code to calculate the number of ways of representing n cents
 ***************************************************************************************************************************/




/***************************************************************************************************************************
 8.8
 Write an algorithm to print all ways of arranging eight queens on a chess board so that none of them share the same row,
 column or diagonal
 ***************************************************************************************************************************/



}
