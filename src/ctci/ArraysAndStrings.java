import java.util.Vector;

public class ArraysAndStrings {

    /***************************************************************************************************************************
     1.1
     Implement an algorithm to determine if a string has all unique characters.
     What if you can not use additional data structures?
     ***************************************************************************************************************************/

    public boolean uniqueChars(String s) {
        final int NUM_ASCII_CHARS = 256;
        int counts[] = new int[NUM_ASCII_CHARS];
        for (int i = 0; i < s.length(); i++) {
            counts[(int) s.charAt(i)]++;
            if (counts[(int) s.charAt(i)] > 1) {
                return false;
            }
        }
        return true;
    }


    /***************************************************************************************************************************
     1.2
     Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters,
     including the null character.)
     ***************************************************************************************************************************/

    public String reverseString(String s) {
        for (int i = 0; i < (s.length() - 1) / 2; i++) {
            s = swapLetters(s, i, s.length() - 2 - i);
        }
        return s;
    }

    public String swapLetters(String s, int idx1, int idx2) {
        if (s.length() - 1 < idx1 || s.length() - 1 < idx2) {
            return s;
        }
        String outString = "";
        int first = (idx1 < idx2) ? idx1 : idx2;
        int second = (first == idx1) ? idx2 : idx1;

        outString += s.substring(0, first);
        outString += s.charAt(second) + s.substring(first + 1, second) + s.charAt(first);
        outString += s.substring(second + 1, s.length());

        return outString;
    }


    /***************************************************************************************************************************
     1.3
     Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
     NOTE: One or two additional variables are fine.  An extra copy of the array is not.

     FOLLOW UP: Write the test cases for this method
     ***************************************************************************************************************************/

    public String removeDuplicates(String s) {
        final int NUM_ASCII_CHARS = 256;
        int counts[] = new int[NUM_ASCII_CHARS];
        for (int i = 0; i < s.length(); i++) {
            counts[(int) s.charAt(i)]++;
            if (counts[(int) s.charAt(i)] > 1) {
                s = s.substring(0, i) + s.substring(i + 1, s.length());
                i--;
            }
        }
        return s;
    }


    /***************************************************************************************************************************
     1.4
     Write a method to decide if two strings are anagrams or not.
     ***************************************************************************************************************************/

    public boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        final int NUM_ASCII_CHARS = 256;
        int countsA[] = new int[NUM_ASCII_CHARS];
        int countsB[] = new int[NUM_ASCII_CHARS];
        int n = a.length();

        for (int i = 0; i < n; i++) {
            countsA[(int) a.charAt(i)]++;
        }
        for (int i = 0; i < n; i++) {
            countsB[(int) b.charAt(i)]++;
        }

        for (int i = 0; i < NUM_ASCII_CHARS; i++) {
            if (countsA[i] != countsB[i]) {
                return false;
            }
        }
        return true;
    }


    /***************************************************************************************************************************
     1.5
     Write a method to replace all spaces in a string with ‘%20’.
     ***************************************************************************************************************************/

    public String replaceSpaces(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                s = s.substring(0, i) + "%20" + s.substring(i + 1, s.length());
                i = +2;
            }
        }
        return s;
    }


    /***************************************************************************************************************************
     1.6
     Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes,
     write a method to rotate the image by 90 degrees. Can you do this in place?
     ***************************************************************************************************************************/

    public void rotateMatrixby90(int matrix[][]) {
        if (matrix.length != matrix[0].length) {
            return;
        }
        int n = matrix.length - 1;
        for (int loop = 0; loop < n / 2; loop++) {
            for (int offset = loop; offset < n - loop; offset++) {
                int temp = matrix[offset][loop];
                matrix[offset][loop] = matrix[n - loop][offset];
                matrix[n - loop][offset] = matrix[n - offset][n - loop];
                matrix[n - offset][n - loop] = matrix[loop][n - offset];
                matrix[loop][n - offset] = temp;
            }
        }
    }


    /***************************************************************************************************************************
     1.7
     Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
     ***************************************************************************************************************************/

    public void zeroOut(int matrix[][]) {
        Vector<Integer> rowsToZero = new Vector<>();
        Vector<Integer> colsToZero = new Vector<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowsToZero.add(i);
                    colsToZero.add(j);
                }
            }
        }

        for (int i = 0; i < rowsToZero.size(); i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[rowsToZero.get(i)][j] = 0;
            }
        }
        for (int i = 0; i < colsToZero.size(); i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][colsToZero.get(i)] = 0;
            }
        }

    }


    /***************************************************************************************************************************
     1.8
     Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings,
     s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
     (i.e., “waterbottle” is a rotation of “erbottlewat”).
     ***************************************************************************************************************************/

    public boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        String doubleCopy = s1 + s1;

        if (isSubstring(s2, doubleCopy)) {
            return true;
        }
        return false;
    }

    public boolean isSubstring(String a, String b) {
        if (a.length() > b.length()) {
            return false;
        }

        for (int i = 0; i < b.length() - a.length(); i++) {
            int j = 0;
            while (j < a.length() && b.charAt(i + j) == a.charAt(j)) {
                j++;
            }
            if (j == a.length()) {
                return true;
            }
        }
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

    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (isCycle(nums, i, nums[i] > 0)) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int[] nums, int idx, boolean movingRight) {
        int n = nums.length;
        if (nums == null || n == 0 || nums[idx] == 0) {
            return false;
        }

        int i = idx;
        do {
            int prevI = i;
            i = stepOnce(nums, i);
            if ((movingRight && (nums[i] < 0)) || (i == prevI)) {
                return false;
            }
            if ((!movingRight && (nums[i] > 0)) || (i == prevI)) {
                return false;
            }
        } while (i < n && i != idx);

        if (i >= n) {
            return false;
        } else {
            return true;
        }
    }

    public int stepOnce(int arr[], int currentIdx) {
        int n = arr.length;
        int nextIdx = 0;
        nextIdx = (currentIdx + arr[currentIdx]) % n;
        if (nextIdx < 0) {
            nextIdx = n + nextIdx;
        }
        return nextIdx;
    }

}


