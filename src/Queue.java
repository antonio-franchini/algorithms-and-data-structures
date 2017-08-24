public class Queue {
    int arr[];
    int front;
    int back;

    Queue(){
        this.arr = new int[10];
        this.front = 0;  /* Points to the index of first item                        */
        this.back = -1;  /* Points to the index of last item(except when it's empty) */
    }

    Queue(int size){
        this.arr = new int[size];
        this.front = 0;  /* Points to the index of first item                        */
        this.back = -1;  /* Points to the index of last item(except when it's empty) */
    }

    public int itemsCount(){
        return back-front+1;
    }

    public void enqueue(int value){
        /* Queue is full */
        if(itemsCount() == arr.length){
            System.out.println("Cannot enqueue. The queue is full!");
        }
        /* Queue is not full */
        else{
            /* Needs shifted to the left */
            if((back == arr.length-1 && front > 0)){
                for(int i = 0; i < itemsCount(); i++) {
                    arr[i] = arr[i+front];
                }
                back = itemsCount() - 1;
                front = 0;
            }
            /* Proceed with enqueue operation */
            back++;
            arr[back] = value;
        }
    }

    public int dequeue(){
        /* Queue is empty */
        if(itemsCount() == 0){
            System.out.println("Cannot dequeue. The queue is empty!");
            return -1;
        }
        /* Queue has exactly one item */
        else if(itemsCount() == 1){
            int retVal = arr[front];
            front = 0;
            back = -1;
            return retVal;
        }
        /* Normal case - more than one item in teh queue */
        else {
            int retVal = arr[front];
            front++;
            return retVal;
        }
    }

    public void printQueue() {

        for (int i = front; i <= back; i++) {
            System.out.print(arr[i] + " ");
        }
        if(itemsCount() == 0){
            System.out.println("Empty");
        }
        System.out.println();
    }

}
