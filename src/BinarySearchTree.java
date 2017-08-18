import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTree {

    public class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinarySearchTree(){
        this.root = null;
    }

    public Node getRoot(){
        return this.root;
    }

    public void addNode(int data){
        if(this.root == null){
            this.root = new Node(data);
        }
        else {
            addNode(data, this.root);
        }
    }

    public void addNode(int data, Node root){
        if(data < root.data){
            if(root.left == null) {
                root.left = new Node(data);
            }
            else{
                addNode(data, root.left);
            }
        }
        else{
            if(root.right == null) {
                root.right = new Node(data);
            }
            else{
                addNode(data, root.right);
            }
        }
    }

    public void printTree(){
        if(this.root == null){
            System.out.println("The tree is empty");
        }
        else{
            printTree(this.root);
        }
    }

    public void printTree(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }

    //          5
    //        /    \
    //       2      8
    //     /  \    /
    //    1   4   6
    //
    //
    //   5 2 8 1 4 6

    public void printTreeDiagram() {
        Node root = this.root;
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }
        return true;
    }

}
