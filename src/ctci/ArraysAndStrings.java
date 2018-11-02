public class ArraysAndStrings {

    /***************************************************************************************************************************
    You are given an array of positive and negative integers. If a number n at an index is positive, then move forward n steps.
    Conversely, if it's negative (-n), move backward n steps. Assume the first element of the array is forward next to the last
    element, and the last element is backward next to the first element. Determine if there is a loop in this array. A loop
    starts and ends at a particular index with more than 1 element along the loop. The loop must be "forward" or "backward'.

    Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.
    Example 2: Given the array [-1, 2], there is no loop.
    Note: The given array is guaranteed to contain no element "0".

    Can you do it in O(n) time complexity and O(1) space complexity?
    ***************************************************************************************************************************/

    public boolean circularArrayLoop( int[] nums ) {
        for( int i = 0; i < nums.length; i++ ){
            if( isCycle( nums, i, nums[i] > 0 ) ){
                return true;
            }
        }
        return false;
    }

    public boolean isCycle( int[] nums, int idx, boolean movingRight ) {
        int n = nums.length;
        if (nums == null || n == 0 || nums[idx] == 0) {
            return false;
        }

        int i = idx;
        do {
            int prevI = i;
            i = stepOnce( nums, i );
            if( ( movingRight && ( nums[i] < 0 ) ) || ( i == prevI ) ){
                return false;
            }
            if( ( !movingRight && ( nums[i] > 0 ) ) || ( i == prevI ) ){
                return false;
            }
        } while ( i < n && i != idx );

        if ( i >= n ) {
            return false;
        }
        else {
            return true;
        }
    }

    public int stepOnce( int arr[], int currentIdx ){
        int n = arr.length;
        int nextIdx = 0;
        nextIdx = ( currentIdx + arr[ currentIdx ] ) % n;
        if( nextIdx < 0 ){
            nextIdx = n + nextIdx;
        }
        return nextIdx;
    }

}


