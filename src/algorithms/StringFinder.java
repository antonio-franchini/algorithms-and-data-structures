import java.util.HashSet;

public class StringFinder {

    /* Determines if string 1 contains all letters of string 2 */
    public boolean containsAllLetters(String string1, String string2){
        HashSet<Character> container = new HashSet<>();

        for(int i = 0; i < string1.length(); i++){
            container.add(string1.charAt(i));
        }

        for(int i = 0; i < string2.length(); i++){
            if(!container.contains(string2.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /* Determines if string 1 contains instances of string 2 */
    public boolean containsString(String string1, String string2){
        return true;
    }

    /* Determines if string 1 contains anagrams (or direct instances) of string 2 */
    public boolean containsAnagrams(String string1, String string2){
        final int TOTAL_ASCII = 256;
        int[] countInText = new int[TOTAL_ASCII];
        int[] countInPattern = new int[TOTAL_ASCII];
        boolean retVal = false;

        /* Look at first set of letters (length of pattern) */
        for(int i = 0; i < string2.length(); i++){
            countInText[string1.charAt(i)]++;
            countInPattern[string2.charAt(i)]++;
        }

        /* Iterate through the middle part of string1 (length of pattern) */
        for(int i = string2.length(); i < string1.length(); i++){
            if(areEqual(countInText, countInPattern)){
                printInstance(i-string2.length(), string1.substring(i-string2.length(), i));
                retVal = true;
            }
            countInText[string1.charAt(i)]++;
            countInText[string1.charAt(i-string2.length())]--;
        }

        /* Look at last set of letters (length of pattern) */
        if(areEqual(countInText, countInPattern)){
            printInstance(string1.length()-string2.length(), string1.substring(string1.length()-string2.length(), string1.length()));
            retVal = true;
        }

        return retVal;
    }

    public boolean areEqual(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        else{
            for(int i = 0; i < arr1.length; i++){
                if(arr1[i] != arr2[i]){
                    return false;
                }
            }
        }
        return true;
    }

    public void printInstance(int lineNum, String instance){
        System.out.println("Anagram " + instance + " found at line " + lineNum);
    }

}
