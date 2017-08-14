public class BubbleSort {

    public void sort(int arr[]){
        for(int i = 0; i < arr.length; i++){
            int j = i;
            while(arr[j] > arr[j+1]){
                swap(arr, j, j+1);
                j++;
            }
        }
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
