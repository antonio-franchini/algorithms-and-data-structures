public class QuickSort {

    public void sort(int arr[]){
        sort(arr, 0, arr.length-1);
    }

    public void sort(int arr[], int start, int end){
        if(start < end){
            int p = partition(arr, start, end);
            sort(arr, start, p-1);
            sort(arr, p+1, end);
        }
    }

    public int partition(int arr[], int start, int end){
        int pivot = arr[end];
        int wall = start-1;

        for(int i = start; i < end; i++){
            if(arr[i] < pivot){
                wall++;
                swap(arr, wall, i);
            }
        }
        wall++;
        swap(arr, wall, end);

        return wall;
    }

    public void swap(int arr[], int index_a, int index_b){
        int temp = arr[index_a];
        arr[index_a] = arr[index_b];
        arr[index_b] = temp;
    }

    public void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
}
