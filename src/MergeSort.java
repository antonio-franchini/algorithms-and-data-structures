public class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]

    private void merge(int arr[], int start, int middle, int end) {
        // Find sizes of two subarrays to be merged
        int n1 = middle - start + 1;
        int n2 = end - middle;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) {
            L[i] = arr[start + i];
        }
        for (int j=0; j<n2; ++j) {
            R[j] = arr[middle + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Recursive function that sorts arr[start..end] using merge()
    private void sort(int arr[], int start, int end) {
        if (start < end) {
            // Find the middle point
            int middle = (start+end)/2;

            // Sort first and second halves
            sort(arr, start, middle);
            sort(arr , middle+1, end);

            // Merge the sorted halves
            merge(arr, start, middle, end);
        }
    }

    // Main function that sorts arr
    public void sort(int arr[]) {
        sort(arr, 0, arr.length-1);
    }

    /* A utility function to print array of size n */
    public void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
