package searching;

public class BinarySearch {
    int attempts;
//    int arr[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

    public int search(int arr[], int target){
        attempts = 0;
        return searchHelper(arr, target, 0, arr.length);
    }

    public int searchHelper(int arr[], int target, int start, int end){
        int middle = (start + end) / 2;

        attempts++;
        if(arr[middle] == target){
            return attempts;
        }
        else if(arr[middle] < target){
            return searchHelper(arr, target, middle+1, end);
        }
        else {/* arr[middle] > target */
            return searchHelper(arr, target, start, middle);
        }
    }
}
