import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {

    public static void main(String args[]){
        BinarySearchTree b = new BinarySearchTree();
        //          5
        //        /    \
        //       2      8
        //     /  \    /
        //    1   4   6
        //
        //
        //   5 2 8 1 4 6

//        b.addNode(5);
//        b.addNode(2);
//        b.addNode(8);
//        b.addNode(1);
//        b.addNode(4);
//        b.addNode(6);

        /* Build the non-binary tree */
        BinarySearchTree.Node five = b.createNode(5);
        BinarySearchTree.Node two = b.createNode(2);
        BinarySearchTree.Node eight = b.createNode(8);
        BinarySearchTree.Node one = b.createNode(1);
        BinarySearchTree.Node four = b.createNode(4);
        BinarySearchTree.Node six = b.createNode(6);
        five.left = two; five.right = eight;
        two.left = one; two.right = four;
        eight.left = six;
        b.setRoot(five);

        System.out.println("Is this a binary search tree? " + b.isBinaryTree(b.getRoot(), Integer.MIN_VALUE, Integer.MAX_VALUE));

        BinarySearchTree.Node n1 = six;
        BinarySearchTree.Node n2 = six;
        System.out.println("Lowest common ancestor of " + n1.data + " and " + n2.data + " is " + b.getLowestCommonAncestor(b.getRoot(), n1, n2).data);

        PrintTree p = new PrintTree();
        p.printTreeDiagram(b.getRoot());

    }

}


