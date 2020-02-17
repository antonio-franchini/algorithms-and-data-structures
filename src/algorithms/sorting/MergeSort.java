public class MergeSort {

    public void sort(int arr[]) {
        mergeSort(arr, 0, arr.length);
    }

    public void mergeSort(int arr[], int start, int end) {
        int middle = (start + end) / 2;

        if (end - start > 1) {
            mergeSort(arr, start, middle);
            mergeSort(arr, middle, end);
            merge(arr, start, end, middle);
        }
    }

    public void merge(int arr[], int start, int end, int middle) {
        int left[] = new int[middle - start];
        int right[] = new int[end - middle];

        for (int l = 0; l < left.length; l++) {
            left[l] = arr[start + l];
        }

        for (int r = 0; r < right.length; r++) {
            right[r] = arr[middle + r];
        }

        int l = 0;
        int r = 0;
        int z = start;

        while (l < left.length && r < right.length) {
            if (left[l] < right[r]) {
                arr[z] = left[l];
                l++;
                z++;
            } else {
                arr[z] = right[r];
                r++;
                z++;
            }
        }

        while (l < left.length) {
            arr[z] = left[l];
            l++;
            z++;
        }

        while (r < right.length) {
            arr[z] = right[r];
            r++;
            z++;
        }

    }

}
