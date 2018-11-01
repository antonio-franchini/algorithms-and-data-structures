public class LinkedList {
    public class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    Node root;

    LinkedList(){
        root = null;
    }

    public void addNodeToEnd(int data){

        if(this.root == null){
            root = new Node(data);
        }
        else {
            Node iter = root;
            while(iter != null && iter.next != null){
                iter = iter.next;
            }
            iter.next = new Node(data);
        }
    }

    public void reverse(){

        if(this.root == null){
            return;
        }

        Node iter = root;
        Node prevPrev = null;
        Node prev = null;

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
            Node iter = root;
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
