public class MergeSort {
    public void sort(int[] arr, int start, int end){
        int middle = (start + end) / 2;

        if(start < end){
            sort(arr, start, middle);
            sort(arr, middle+1, end);
            merge(arr, start, end);
        }
    }

    public void sort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    public void merge(int[] arr, int start, int end){
        int middle = (start + end) / 2;

        int sizeL = middle-start+1;
        int sizeR = end - middle;

        int[] L = new int[sizeL];
        int[] R = new int[sizeR];

        for(int i =0; i < sizeL; i++){
            L[i] = arr[start+i];
        }
        for(int j =0; j < sizeR; j++){
            R[j] = arr[middle+1+j];
        }

        int k = start;

        int i = 0;
        int j = 0;

        while(i < sizeL && j < sizeR){
            if(L[i] < R[j]){
                arr[k] = L[i];
                i++;
                k++;
            }
            else {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        while(i < sizeL){
            arr[k] = L[i];
            i++;
            k++;
        }

        while(j < sizeR){
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    /* A utility function to print array of size n */
    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
