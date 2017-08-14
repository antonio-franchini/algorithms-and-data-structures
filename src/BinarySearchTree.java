public class BinarySearchTree {

    // SUBCLASSES
    public class Node {
        Node left;
        Node right;
        int data;

        Node(int data){
            this.right = null;
            this.left = null;
            this.data = data;
        }
    }

    // DATA
    Node root;

    // METHODS
    BinarySearchTree(){
        root = null;
    }

    public void addNode(int data) {
        this.root = addNode(this.root, data);
    }

    private Node addNode(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }

        if(data <= root.data){
            root.left = addNode(root.left, data);
        }

        else{
            root.right = addNode(root.right, data);
        }
        return root;
    }

    public void inOrderPrint(){
        if(this.root == null){
            return;
        }
        else{
            inOrderPrint(this.root);
        }
        System.out.println("");
    }

    private void inOrderPrint(Node root){
        if(root.left != null){
            inOrderPrint(root.left);
        }
        System.out.print(root.data + " ");
        if(root.right != null) {
            inOrderPrint(root.right);
        }
    }

    public void flatten(Node root) {
        if(root == null){
            return;
        }

        Node temp;
        temp = root;
        while(temp.left != null){
            temp = temp.left;
        }

        if(root.right != null){
            temp.left = root.right;
            root.right=null;
        }

        if(root.left != null){
            flatten(root.left);
        }

        if(root.right != null){
            flatten(root.right);
        }


    }

}
