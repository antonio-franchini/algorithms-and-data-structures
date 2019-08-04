public class Driver {

    public static void main(String args[]){
        // 0 1 2 3 4 5   6   7   8   9
        // 1 1 2 3 5 8  13  21  34  55

        int input = 9;
        System.out.println("Fibonacci number for " + input + " is: " + fibIterative(input));
    }

    public static int fibIterative(int n){
        if( n == 0 || n==1 ){
            return 1;
        }

        int arr[] = new int[n];
        int prevPrev = 1;
        int prev = 1;

        for(int i = 2; i < n; i++){
            int current = prev + prevPrev;
            prevPrev = prev;
            prev = current;
        }

        return prev + prevPrev;
    }

}


