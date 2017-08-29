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

}
