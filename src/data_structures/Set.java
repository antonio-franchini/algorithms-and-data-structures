import java.util.HashSet;
import java.util.Vector;

public class Set {

    Vector<Integer> items;

    Set(){
        items = new Vector<>();
    }

    public Vector<Integer> getSet(){
        return items;
    }

    public void remove( int a ){
        items.remove( a );
    }

    public void add( int a ){
        int location = 0;
        while( location < items.size() && items.get(location) < a ){
            location++;
        }

        items.add( a );
        for( int i = items.size() - 1; i > location; i-- ){
            swap( i, i-1 );
        }
    }

    public Set union( Set A, Set B ){
        Set C = new Set();

        Vector<Integer> a = A.getSet();
        Vector<Integer> b = B.getSet();
        Vector<Integer> c = new Vector<>();

        int idxA = 0;
        int idxB = 0;

        while( idxA < a.size() && idxB < b.size() ){
            if( a.get( idxA ) == b.get( idxB ) ){
                c.add( a.get( idxA ) );
                idxA++;
                idxB++;
            }
            else if( a.get( idxA ) > b.get( idxB ) ){
                if( !c.contains( b.get( idxB ) )){
                    c.add( b.get( idxB ) );
                }
                idxB++;
            }
            else if( a.get( idxA ) < b.get( idxB ) ){
                if( !c.contains( a.get( idxA ) )){
                    c.add( a.get( idxA ) );
                }
                idxA++;
            }
        }

        for( int i = 0; i < c.size(); i++ ){
            C.add( c.get( i ) );
        }
        return C;
    }

    public Set intersection( Set A, Set B ){
        Set C = new Set();

        Vector<Integer> a = A.getSet();
        Vector<Integer> b = B.getSet();

        int idxA = 0;
        int idxB = 0;

        while( idxA < a.size() && idxB < b.size() ){
            if( a.get( idxA ) == b.get( idxB ) ){
                C.add( a.get( idxA ) );
                idxA++;
                idxB++;
            }
            else if( a.get( idxA ) > b.get( idxB ) ){
                idxB++;
            }
            else if( a.get( idxA ) < b.get( idxB ) ){
                idxA++;
            }
        }
        return C;
    }

    public Set difference( Set A, Set B ){
        Set C = new Set();
        Set intersection = intersection( A, B );
        Set union = union( A, B );

        Vector<Integer> in = intersection.getSet();
        Vector<Integer> un = union.getSet();

        for(int i = 0; i < un.size(); i++ ){
            if( !in.contains( un.get( i ) ) ){
                C.add( un.get( i ) );
            }
        }
        return C;
    }

    public boolean subset( Set A, Set B ){
        Vector<Integer> a = A.getSet();
        Vector<Integer> b = B.getSet();

        for( int i = 0; i < a.size(); i++ ){
            if( !b.contains( a.get( i ) ) ){
                return false;
            }
        }
        return true;
    }

    public void swap( int idx1, int idx2 ){
        int temp = items.get( idx1 );
        items.set( idx1, items.get( idx2 ) );
        items.set( idx2, temp );
    }
}
