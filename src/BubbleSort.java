public class BubbleSort {

    //                 i
    //                             j
    //     2,  7,  3,  9,  5,  4,  8
    //     2,  3,  7,  9,  5,  4,  8
    //     2,  3,  7,  5,  9,  4,  8
    //     2,  3,  7,  5,  4,  9,  8
    //     2,  3,  7,  5,  4,  8,  9

    public void sort(int arr[]){
        for(int i = 0; i < arr.length-1; i++){
            int j = i;
            while(j < arr.length-1){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
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
