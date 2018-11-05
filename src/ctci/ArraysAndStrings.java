public class ArraysAndStrings {

    /***************************************************************************************************************************
     1.1
     Implement an algorithm to determine if a string has all unique characters.
     What if you can not use additional data structures?
     ***************************************************************************************************************************/

    public boolean uniqueChars( String in[] ){
        return false;
    }


    /***************************************************************************************************************************
     1.2
     Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters,
     including the null character.)
     ***************************************************************************************************************************/

    public String reverseString( String in[] ){
        return "out";
    }


    /***************************************************************************************************************************
     1.3
     Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
     NOTE: One or two additional variables are fine.  An extra copy of the array is not.

     FOLLOW UP: Write the test cases for this method
     ***************************************************************************************************************************/

    public String removeDuplicates( String in[] ){
        return "out";
    }


    /***************************************************************************************************************************
     1.4
     Write a method to decide if two strings are anagrams or not.
     ***************************************************************************************************************************/

    public boolean areAnagrams( String a[], String b[] ){
        return false;
    }


    /***************************************************************************************************************************
     1.5
     Write a method to replace all spaces in a string with ‘%20’.
     ***************************************************************************************************************************/

    public String replaceSpaces( String in[] ){
        return "out";
    }


    /***************************************************************************************************************************
     1.6
     Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
     write a method to rotate the image by 90 degrees. Can you do this in place?
     ***************************************************************************************************************************/

    public boolean rotateMatrixby90( int in[][] ){
        return false;
    }


    /***************************************************************************************************************************
     1.7
     Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
     ***************************************************************************************************************************/

    public void zeroOut( int in[][] ){

    }


    /***************************************************************************************************************************
     1.8
     Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings,
     s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
     (i.e., “waterbottle” is a rotation of “erbottlewat”).
     ***************************************************************************************************************************/

    public boolean isRotation( String a[], String b[] ){
        return false;
    }

    public boolean isSubstring( String a[], String b[] ){
        return false;
    }


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


