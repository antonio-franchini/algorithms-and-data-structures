import java.util.HashMap;
import java.util.HashSet;

public class NumConverter {

    /* Converts an integer to a string */
    public String intToString(int input){
        return intToStringOfBase(input, 10);
    }

    /* Converts an integer to a string according to the given base */
    public String intToStringOfBase(int input, int base){
        String temp = "";
        String output = "";

        if(base == 0){
            System.out.println("The base cannot be zero!");
            return "";
        }
        if(input == 0){
            return"0";
        }

        while(input > 0){
            switch(input % base){
                case 0:  temp += "0"; break;
                case 1:  temp += "1"; break;
                case 2:  temp += "2"; break;
                case 3:  temp += "3"; break;
                case 4:  temp += "4"; break;
                case 5:  temp += "5"; break;
                case 6:  temp += "6"; break;
                case 7:  temp += "7"; break;
                case 8:  temp += "8"; break;
                case 9:  temp += "9"; break;
                case 10: temp += "A"; break;
                case 11: temp += "B"; break;
                case 12: temp += "C"; break;
                case 13: temp += "D"; break;
                case 14: temp += "E"; break;
                case 15: temp += "F"; break;
            }
            input /= base;
        }
        for(int i = temp.length()-1; i >= 0; i--){
            output += temp.charAt(i);
        }
        return output;
    }

    /* Converts an integer to a string */
    public int stringToInt(String input) {
        int output = 0;
        int multFactor = 1;
        int currentNum = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            /* Determine digit corresponding to current character */
            switch (input.charAt(i)) {
                case '0': currentNum = 0; break;
                case '1': currentNum = 1; break;
                case '2': currentNum = 2; break;
                case '3': currentNum = 3; break;
                case '4': currentNum = 4; break;
                case '5': currentNum = 5; break;
                case '6': currentNum = 6; break;
                case '7': currentNum = 7; break;
                case '8': currentNum = 8; break;
                case '9': currentNum = 9; break;
                default:
                    System.out.println("Invalid input");
                    return -1;
            }
            /* Check for overflow */
            if (Integer.MAX_VALUE - (currentNum * multFactor) >= output) {
                output += (currentNum * multFactor);
            }
            else {
                System.out.println("Overflow!");
                return -1;
            }
            /* Increment multiplication factor for the next digit */
            multFactor *= 10;
        }
        return output;
    }

}
