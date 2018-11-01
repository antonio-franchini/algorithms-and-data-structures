public class InsertionSort {
    public void sort(int arr[]){
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            int j = i;
            while(j > 0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }

    public void printArray(int arr[]){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
