import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {
    static public void main(String args[]){
        MyBinarySearchTree l = new MyBinarySearchTree();

        l.addNode(5);
        l.addNode(2);
        l.addNode(8);
        l.addNode(1);
        l.addNode(4);
        l.addNode(6);

        l.printTreeDiagram();
    }

}


