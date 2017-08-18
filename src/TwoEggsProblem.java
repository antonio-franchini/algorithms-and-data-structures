public class TwoEggsProblem {

    int breakingFloor;
    int totFloors;

    TwoEggsProblem(){
        this.breakingFloor = 47;
        this.totFloors = 120;
    }

    TwoEggsProblem(int breakingFloor, int totFloors){
        this.breakingFloor = breakingFloor;
        this.totFloors = totFloors;
    }

    public boolean itBreaks(int floor){
        if(floor < breakingFloor){
            return false;
        }
        else{
            return true;
        }
    }

    public void findNumDrops(){
        boolean Xbox_1_broke = false;
        boolean Xbox_2_broke = false;

        int numAttempts = 0;
        int currentAttempt = 0;
        int previousAttempt = 0;

        while(Xbox_1_broke == false && currentAttempt < totFloors - 1){
            previousAttempt = currentAttempt;
            currentAttempt = currentAttempt + ( (totFloors - currentAttempt) / 2 );
            Xbox_1_broke = itBreaks(currentAttempt);
            numAttempts++;
        }

        currentAttempt = previousAttempt+1;

        while(Xbox_2_broke == false  && currentAttempt <= totFloors){
            Xbox_2_broke = itBreaks(currentAttempt);
            numAttempts++;
            currentAttempt++;
        }

        System.out.println("Max floor without breaking Xbox: " + (currentAttempt - 1));
        System.out.println("Total number of attempts: " + (numAttempts));

    }

}
