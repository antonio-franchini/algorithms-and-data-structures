public class HeapSort {

    //  Tree visualization of heap
//
//                    0
//                 /     \
//                /       \
//               /         \
//              1           2
//            / \          / \
//           /   \        /   \
//          3     4      5     6
//         / \   / \    / \    / \
//        7  8  9  10   11 12  13 14

    public void sort(int[] arr){
        int n = arr.length - 1;

        for(int i = n / 2; i >= 0; i--){
            heapify(arr, i, n);
        }

        while(n > 0){
            swap(arr, 0, n);
            n--;
            heapify(arr, 0, n);
        }
    }

    public void heapify(int arr[], int current, int n){
        int max = current;

        if(left(current) <= n && arr[current] < arr[left(current)]){
            max = left(current);
        }
        if(right(current) <= n && arr[max] < arr[right(current)]){
            max = right(current);
        }
        if(max != current){
            swap(arr, max, current);
            heapify(arr, max, n);
        }
    }

    public int parent(int current){
        return (current - 1) / 2;
    }

    public int left(int current){
        return (current * 2) + 1;
    }

    public int right(int current){
        return (current * 2) + 2;
    }

    public void swap(int arr[], int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}
