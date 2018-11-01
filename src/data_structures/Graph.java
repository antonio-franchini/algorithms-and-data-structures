import com.sun.javafx.geom.Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    HashMap<String, Vertex> vertices;
    ArrayList<Edge> edges;

    public class Vertex{
        String label;
        ArrayList<Edge> neighbors;

        Vertex(String label){
            this.label = label;
            this.neighbors = new ArrayList<Edge>();
        }

        public void addNeighbor(Vertex neighbor){
            this.neighbors.add(new Edge(this, neighbor));
        }
    }

    public class Edge {
        Vertex v1;
        Vertex v2;
        int weight;

        Edge(Vertex v1, Vertex v2) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = 1;
        }

        public Vertex getOtherVertex(Vertex current) {
            if (current == this.v1) {
                return v2;
            } else {
                return v1;
            }
        }
    }

    Graph(){
        vertices = new HashMap<String, Vertex>();
        edges = new ArrayList<Edge>();
    }

    public void addVertex(String label){
        vertices.put(label, new Vertex(label));
    }

    public void addEdge(String label1, String label2){
        edges.add(new Edge(vertices.get(label1), vertices.get(label2)));
        vertices.get(label1).addNeighbor(vertices.get(label2));
        vertices.get(label2).addNeighbor(vertices.get(label1));
    }

    public void printGraph() {
        for (String label : vertices.keySet()) {
            Vertex currentVert = vertices.get(label);
            System.out.print("[" + currentVert.label + "]  ");
            for (int j = 0; j < vertices.get(label).neighbors.size(); j++) {
                Vertex neighborVert = currentVert.neighbors.get(j).getOtherVertex(currentVert);
                System.out.print(neighborVert.label + " ");
            }
            System.out.println("");
        }
    }

    public void DeepFirstSearch(String label) {
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        DeepFirstSearch(this.vertices.get(label), visited);
    }

    public void DeepFirstSearch(Vertex v, ArrayList<Vertex> visited) {
        System.out.print(v.label + " ");
        visited.add(v);
        for(int i = 0; i < v.neighbors.size(); i++){
            if(!visited.contains(v.neighbors.get(i).getOtherVertex(v))){
                DeepFirstSearch(v.neighbors.get(i).getOtherVertex(v), visited);
            }
        }
    }

    public void BreadthFirstSearch(String label) {
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        BreadthFirstSearch(this.vertices.get(label), visited);
    }

    public void BreadthFirstSearch(Vertex v, ArrayList<Vertex> visited) {
        Queue<Vertex> q = new LinkedList<>();

        q.add(v);
        visited.add(v);

        while (!q.isEmpty()) {
            Vertex current = q.poll();
            System.out.print(current.label + " ");

            for (int i = 0; i < current.neighbors.size(); i++) {
                if (!visited.contains(current.neighbors.get(i).getOtherVertex(current))) {
                    q.add(current.neighbors.get(i).getOtherVertex(current));
                    visited.add(current.neighbors.get(i).getOtherVertex(current));
                }
            }
        }
    }

    public void exerciseGraph(){
        //        This test graph looks like this:
        //
        //        A ---- B ---- F ---- E ---- G
        //	      | \  /        |      |      |
        //        |  \/         |      |      |
        //        |  /\	        |      |      |
        //        | /  \        |      |      |
        //        C ---- D      K      H ---- M

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
    }

}
