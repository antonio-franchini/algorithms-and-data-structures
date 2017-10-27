import java.util.Vector;

public class HeapSort2 {

    public void sort(int arr[]){
        for(int i = arr.length/2; i >= 0; i--){
            heapify(arr, i, arr.length);
        }
        swap(arr,0, arr.length-1);
        for(int i = arr.length-1; i > 0; i--){
            heapify(arr, 0,i);
            swap(arr,0, i-1);
        }

    }

    public void heapify(int arr[], int current, int n){
        int max = current;
        if(left(current) < n && arr[left(current)] > arr[current]){
            max = left(current);
        }
        if(right(current) < n && arr[right(current)] > arr[max] ){
            max = right(current);
        }

        if(max != current){
            swap(arr, max, current);
            heapify(arr, max, n);
        }

    }

    public void swap(int arr[], int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public int left(int current){
        return ( ( current * 2 ) + 1 );
    }

    public int right(int current){
        return ( ( current * 2 ) + 2 );
    }

}
