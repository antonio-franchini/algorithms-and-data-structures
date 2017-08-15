public class SelectionSort {


    //         i
    //         j
    //     2,  7,  3,  9,  5,  4,  8
    //     2,  7,  3,  9,  5,  4,  8
    //     2,  7,  3,  9,  5,  4,  8
    //     2,  7,  3,  9,  5,  4,  8
    //     2,  7,  3,  9,  5,  4,  8
    public void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int min_index = 0;

            for (int j = i; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_index = j;
                    swap(arr, min_index, i);
                }
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
