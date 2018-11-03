import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class Driver {

    public static void main(String args[]){

        Graph l = new Graph();

        l.addVertex("A");
        l.addVertex("B");
        l.addVertex("C");
        l.addVertex("D");
        l.addVertex("E");
        l.addVertex("F");
        l.addVertex("G");
        l.addVertex("H");
        l.addVertex("K");
        l.addVertex("M");

        l.addEdge("A", "B");
        l.addEdge("A", "C", 80);
        l.addEdge("A", "D", 5);
        l.addEdge("B", "C", 2);
        l.addEdge("B", "F");
        l.addEdge("C", "D");
        l.addEdge("F", "K");
        l.addEdge("F", "E");
        l.addEdge("E", "G");
        l.addEdge("E", "H");
        l.addEdge("G", "M");
        l.addEdge("H", "M");

        //        This test graph looks like this:
        //
        //        A ---- B ---- F ---- E ---- G
        //        | \  / 2      |      |      |
        //        |   /         |      |      |
        //     80 |  /\         |      |      |
        //        | /  \ 5       |      |      |
        //        C ---- D      K      H ---- M

        l.BreadthFirstSearch("H");

        System.out.println( "\nDistance = " + l.dijkstras( "A", "D" ) );
    }

}


