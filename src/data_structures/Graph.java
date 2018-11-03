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

        Vertex( String label ){
            this.label = label;
            this.neighbors = new ArrayList<Edge>();
        }

        public void addNeighbor( Vertex neighbor ){
            this.neighbors.add( new Edge(this, neighbor ) );
        }
        public void addNeighbor(Vertex neighbor, int w ){
            this.neighbors.add( new Edge(this, neighbor, w ) );
        }

    }

    public class Edge {
        Vertex v1;
        Vertex v2;
        int weight;

        Edge( Vertex v1, Vertex v2 ) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = 1;
        }

        Edge( Vertex v1, Vertex v2, int w ) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = w;
        }

        public Vertex getOtherVertex( Vertex current ) {
            if ( current == this.v1 ) {
                return this.v2;
            } else {
                return this.v1;
            }
        }
        public int getWeight() {
            return this.weight;
        }
    }

    Graph(){
        this.vertices = new HashMap<String, Vertex>();
        this.edges = new ArrayList<Edge>();
    }

    public void addVertex( String label ){
        this.vertices.put( label, new Vertex( label ) );
    }

    public void addEdge( String label1, String label2 ){
        this.edges.add( new Edge( this.vertices.get( label1 ), this.vertices.get( label2 ) ) );
        this.vertices.get( label1 ).addNeighbor( this.vertices.get( label2 ) );
        this.vertices.get( label2 ).addNeighbor( this.vertices.get( label1 ) );
    }

    public void addEdge( String label1, String label2, int w ){
        this.edges.add( new Edge( this.vertices.get(label1), this.vertices.get(label2), w ));
        this.vertices.get( label1 ).addNeighbor( this.vertices.get( label2 ), w );
        this.vertices.get( label2 ).addNeighbor( this.vertices.get( label1 ), w );
    }

    public void printGraph() {
        for (String label : this.vertices.keySet()) {
            Vertex currentVert = this.vertices.get( label );
            System.out.print("[" + currentVert.label + "]  ");
            for( int j = 0; j < this.vertices.get( label ).neighbors.size(); j++ ) {
                Vertex neighborVert = currentVert.neighbors.get( j ).getOtherVertex( currentVert );
                System.out.print( neighborVert.label + " " );
            }
            System.out.println( "" );
        }
    }

    public void DeepFirstSearch( String label ) {
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        DeepFirstSearch( this.vertices.get(label), visited );
    }

    public void DeepFirstSearch( Vertex v, ArrayList<Vertex> visited ) {
        System.out.print( v.label + " " );
        visited.add( v );
        for( int i = 0; i < v.neighbors.size(); i++ ){
            if( !visited.contains(v.neighbors.get( i ).getOtherVertex( v ) ) ){
                DeepFirstSearch( v.neighbors.get( i ).getOtherVertex( v ), visited );
            }
        }
    }

    public void BreadthFirstSearch( String label ) {
        ArrayList<Vertex> visited = new ArrayList<Vertex>();
        BreadthFirstSearch( this.vertices.get( label ), visited );
    }

    public void BreadthFirstSearch( Vertex v, ArrayList<Vertex> visited ) {
        Queue<Vertex> q = new LinkedList<>();

        q.add( v );
        visited.add( v );

        while ( !q.isEmpty() ) {
            Vertex current = q.remove();
            System.out.print( current.label + " " );

            for ( int i = 0; i < current.neighbors.size(); i++ ) {
                if ( !visited.contains( current.neighbors.get( i ).getOtherVertex( current ) ) ) {
                    q.add( current.neighbors.get( i ).getOtherVertex( current ) );
                    visited.add( current.neighbors.get( i ).getOtherVertex( current ) );
                }
            }
        }
    }

    public int dijkstras( String orig, String dest ){
        return dijkstras( this.vertices.get( orig ), this.vertices.get( dest ) );
    }

    public int dijkstras( Vertex orig, Vertex dest ){
        HashMap<Vertex, Integer> visited = new HashMap<>();
        Queue<Vertex> v = new LinkedList<>();

        v.add( orig );
        visited.put( orig, 0 );

        while( !v.isEmpty() ){
            Vertex vert = v.remove();

            for( int i = 0; i < vert.neighbors.size(); i++ ){

                if( !visited.containsKey( vert.neighbors.get( i ).getOtherVertex( vert ) ) ){
                    v.add( vert.neighbors.get( i ).getOtherVertex( vert ) );
                    int w = vert.neighbors.get( i ).getWeight();
                    visited.put( vert.neighbors.get( i ).getOtherVertex( vert ), visited.get( vert ) + w );
                }
                else if( visited.get( vert.neighbors.get( i ).getOtherVertex( vert ) ) > visited.get( vert ) + vert.neighbors.get( i ).getWeight() ){
                    visited.put( vert.neighbors.get( i ).getOtherVertex( vert ), visited.get( vert ) + vert.neighbors.get( i ).getWeight() );
                }
            }
        }

        if( visited.containsKey( dest ) ){
            return visited.get( dest );
        }
        else {
            return -1;
        }
    }

    public void exerciseGraph(){
        //        This test graph looks like this:
        //
        //        A ---- B ---- F ---- E ---- G
        //        | \  /        |      |      |
        //        |   /         |      |      |
        //        |  /\         |      |      |
        //        | /  \        |      |      |
        //        C ---- D      K      H ---- M

        Graph l = new Graph();

        l.addVertex("A" );
        l.addVertex("B" );
        l.addVertex("C" );
        l.addVertex("D" );
        l.addVertex("E" );
        l.addVertex("F" );
        l.addVertex("G" );
        l.addVertex("H" );
        l.addVertex("K" );
        l.addVertex("M" );

        l.addEdge("A", "B" );
        l.addEdge("A", "C" );
        l.addEdge("A", "D" );
        l.addEdge("B", "C" );
        l.addEdge("B", "F" );
        l.addEdge("C", "D" );
        l.addEdge("F", "K" );
        l.addEdge("F", "E" );
        l.addEdge("E", "G" );
        l.addEdge("E", "H" );
        l.addEdge("G", "M" );
        l.addEdge("H", "M" );

        l.BreadthFirstSearch("H" );
    }

}
