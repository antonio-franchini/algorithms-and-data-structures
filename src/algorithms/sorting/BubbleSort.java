public class BubbleSort {

    public void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public void swap(int arr[], int index_a, int index_b){
        int temp = arr[index_a];
        arr[index_a] = arr[index_b];
        arr[index_b] = temp;
    }

}
