public class Transformer {

    public static String itoa(int number, int base) {

        int currentDigit = number;
        String reVal = "";

        if(number == 0){
            return"0";
        }

        while(number > 0) {
            currentDigit = number % base;
            number = number / base;
            if(currentDigit == 0) {
                reVal += "0";
            }
            else if(currentDigit == 1) {
                reVal += "1";
            }
            else if(currentDigit == 2) {
                reVal += "2";
            }
            else if(currentDigit == 3) {
                reVal += "3";
            }
            else if(currentDigit == 4) {
                reVal += "4";
            }
            else if(currentDigit == 5) {
                reVal += "5";
            }
            else if(currentDigit == 6) {
                reVal += "6";
            }
            else if(currentDigit == 7) {
                reVal += "7";
            }
            else if(currentDigit == 8) {
                reVal += "8";
            }
            else if(currentDigit == 9) {
                reVal += "9";
            }
            else if(currentDigit == 10) {
                reVal += "A";
            }
            else if(currentDigit == 11) {
                reVal += "B";
            }
            else if(currentDigit == 12) {
                reVal += "C";
            }
            else if(currentDigit == 13) {
                reVal += "D";
            }
            else if(currentDigit == 14) {
                reVal += "E";
            }
            else if(currentDigit == 15) {
                reVal += "F";
            }
        }

        String reVal2 = "";
        for(int index =  reVal.length() -1 ; index >= 0 ; index--) {
            reVal2 += reVal.charAt(index);
        }
        
        return reVal2;
    }

}
