import java.util.Vector;

public class MaxHeap {
    Vector<Integer> H;

//  Tree visualization of MaxHeap Vector
//                                       _
//                    0                   |
//                 /     \                |
//                /       \               |
//               /         \              |
//              1           2             |  h
//            / \          / \            |
//           /   \        /   \           |
//          3     4      5     6          |
//         / \   / \    / \    / \        |
//        7  8  9  10   11 12  13 14     _|
//                                                  h-1
//                                                2      =    n          ---->        log  n   =   h
//                                                                                       2

    MaxHeap() {
        H = new Vector<Integer>();
    }

    MaxHeap(int arr[]){
        H = new Vector<Integer>();
        for(int i = 0; i < arr.length; i++){
            insert(arr[i]);
        }
    }

    /* Return index of parent */
    public int parent(int currentIndex){
        return((currentIndex - 1) / 2);
    }

    /* Return index of left child */
    public int left(int currentIndex){
        return((currentIndex * 2) + 1);
    }

    /* Return index of right child */
    public int right(int currentIndex){
        return((currentIndex * 2) + 2);
    }

    /* Return the max element but don't pop */
    public int peek(){
        return(H.get(0));
    }

    /* Pop the max element */
    public int getRoot(){
        int retVal = H.get(0);

        swap(0, H.size()-1);
        H.remove(H.size()-1);
        heapyfy(0);

        return retVal;
    }

    /* Insert new element in the MaxHeap */
    public void insert(int value){
        H.add(value);
        int index = H.size()-1;
        while(index >= 0 && value > H.get(parent(index))){
            swap(index, parent(index));
            index = parent(index);
        }
    }

    /* Bubble down a given target to the right spot in the MaxHeap */
    public void heapyfy(int index){
        int max;

        if(left(index) < H.size() && H.get(index) < H.get(left(index))){
            max = left(index);
        }
        else{
            max = index;
        }

        if(right(index) < H.size() && max < H.get(right(index))){
            max = right(index);
        }

        if(max != index){
            swap(index, max);
            heapyfy(max);
        }
    }

    /* Swap two elements of the MaxHeap */
    public void swap(int idx1, int idx2){
        int temp = H.get(idx1);
        H.set(idx1, H.get(idx2));
        H.set(idx2, temp);
    }

    /* Print the MaxHeap in array form*/
    public void print() {
        int n = H.size();
        for (int i=0; i<n; ++i)
            System.out.print(H.get(i) + " ");
        System.out.println();
    }

}
