public class LinkedList {

    LLNode root;

    LinkedList(){
        root = null;
    }

    public void addNodeToEnd(int data){

        if(this.root == null){
            root = new LLNode(data);
        }
        else {
            LLNode iter = root;
            while(iter != null && iter.next != null){
                iter = iter.next;
            }
            iter.next = new LLNode(data);
        }
    }

    public void reverse(){

        if(this.root == null){
            return;
        }

        LLNode iter = root;
        LLNode prevPrev = null;
        LLNode prev = null;

        while(iter != null){
            prevPrev = prev;
            prev = iter;
            iter = iter.next;

            if(prev != null){
                prev.next = prevPrev;
            }
        }
        root = prev;
    }

    public void printLinkedlist(){
        if(this.root == null){
            System.out.print("List empty");
        }
        else {
            LLNode iter = root;
            while(iter != null && iter.next != null) {
                System.out.print(iter.data + " --> ");
                iter = iter.next;
            }
            if(iter != null) {
                System.out.print(iter.data + "");
            }
        }
        System.out.println("");
    }

}
