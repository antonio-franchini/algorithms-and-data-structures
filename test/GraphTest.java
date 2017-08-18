import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class GraphTest {

    private ByteArrayOutputStream outStream;
    private PrintStream outOrig;

    @Before
    public void setUp() throws Exception {
        outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);
        outOrig = System.out;
        System.setOut(out);
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(outOrig);
    }

    @Test
    public void mainTest5() {
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
        l.addEdge("A", "C");
        l.addEdge("A", "D");
        l.addEdge("B", "C");
        l.addEdge("B", "F");
        l.addEdge("C", "D");
        l.addEdge("F", "K");
        l.addEdge("F", "E");
        l.addEdge("E", "G");
        l.addEdge("E", "H");
        l.addEdge("G", "M");
        l.addEdge("H", "M");

        l.BreadthFirstSearch("H");

        assertEquals("H E M F G B K A C D", outStream.toString().trim());
    }

}