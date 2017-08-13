import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {
    static public void main(String args[]){
        LinkedList l = new LinkedList();

        l.printLinkedlist();

        l.addNodeToEnd(6);
        l.addNodeToEnd(9);
        l.addNodeToEnd(1);
        l.addNodeToEnd(7);
        l.addNodeToEnd(8);
        l.addNodeToEnd(2);

        l.printLinkedlist();

        l.reverse();

        l.printLinkedlist();
    }

}


