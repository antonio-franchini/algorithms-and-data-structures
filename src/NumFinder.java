public class NumFinder {
    public void sort(int[] arr){

    }

    /* Returns true if two numbers in the array add up to the given target, false otherwise */
    public  boolean pairSumsToTarget(int[] arr, int target){
        sort(arr);
        int low = 0;
        int high = arr.length - 1;

        while(low < high){
            if(arr[low] + arr[high] == target){
                return true;
            }
            else if( (arr[low] + arr[high]) < target){
                low++;
            }
            else{ /* arr[low] + arr[high] > target */
                high--;
            }
        }
        return false;
    }

    /* Returns the array index of the given target, -1 if the target was not found */
    /* This function is designed for a sorted but rotated array */
    public int findInRotatedSortedArr(int[] arr, int start, int end, int target){
        if(start > end){
            return -1;
        }

        int middle = (end + start) / 2;

        if (arr[middle] == target) {
            return middle;
        }

        if (arr[start] <= arr[middle]){
            if(target >= arr[start] && target <= arr[middle]){
                return findInRotatedSortedArr(arr, start, middle, target);
            }
            else{
                return findInRotatedSortedArr(arr, middle+1, end, target);
            }
        }
        else{ /* (arr[middle] < arr[end]) */
            if(target >= arr[middle+1] && target <= arr[end]) {
                return findInRotatedSortedArr(arr, middle+1, end, target);
            }
            else{
                return findInRotatedSortedArr(arr, start, middle, target);
            }
        }
    }

    /* Finds all the triplets that add up to zero in a given array */
    public void threeSum(int[] nums) {
        //HeapSort2.sort(nums);

        for(int i = 0; i < nums.length-3; i++){
            int l = i+1;
            int h = nums.length-1;

            while(l < h){
                if(nums[i] + nums[l] + nums[h] > 0){
                    h--;
                }
                else if(nums[i] + nums[l] + nums[h] < 0){
                    l++;
                }
                else{
                    System.out.println(" " + nums[i] + " " + nums[l] + " " + nums[h]);
                    l++;
                }
            }
        }
    }
	
}
