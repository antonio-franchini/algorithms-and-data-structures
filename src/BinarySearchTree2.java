public class BinarySearchTree2 {

    /*********************************************************************
     *   BinarySearchTree2 class
     **********************************************************************/
    public BSTNode root;
    public BSTNode head; /* For transformation to doubly linked list */

    BinarySearchTree2(){
        this.root = null;
        this.head = null;
    }

    /*********************************************************************
     *   instert interface
     **********************************************************************/
    public void insert(int data){
        if(this.root == null){
            this.root = new BSTNode(data);
        }
        else{
            insert(data, this.root);
        }
    }

    /*********************************************************************
     *   instert (recursive)
     **********************************************************************/
    public void insert(int data, BSTNode root){
        if( data < root.data ){
            if(root.left == null) {
                root.left = new BSTNode(data);
            }
            else{
                insert(data, root.left);
            }
        }
        else { /* data >= root.data */
            if(root.right == null) {
                root.right = new BSTNode(data);
            }
            else{
                insert(data, root.right);
            }
        }
    }

    /*********************************************************************
     *   Transforms tree to dobly linked list (interface)
     **********************************************************************/
    public void BSTtoDLL(){
        if(this.root == null){
            return;
        }
        BSTtoDLL(this.root);
    }

    /*********************************************************************
     *   Transforms tree to doubly linked list (recursive)
     **********************************************************************/
    public void BSTtoDLL(BSTNode root){
        if(root == null){
            return;
        }

        BSTtoDLL(root.right);

        root.right = this.head;
        if(this.head != null){
            this.head.left = root;
        }
        this.head = root;

        BSTtoDLL(root.left);

    }

    /*********************************************************************
     *   Prints doubly linked list from left to right and from right to left
     **********************************************************************/
    public void printDLL(BSTNode head){
        BSTNode temp = null;
        System.out.println("From left to right:");
        while(head != null){
            System.out.print(head.data + " --> ");
            temp = head;
            head = head.right;
        }
        System.out.println("null");
        System.out.println("From right to left:");
        while(temp != null){
            System.out.print(temp.data + " --> ");
            temp = temp.left;
        }
        System.out.println("null");
    }

    /*********************************************************************
     *   Finds the lowest common ancestor of two nodes in binary search tree
     *   (more efficient than finding it in regular binary tree)
     **********************************************************************/
    public void findLCA_BST(BSTNode root, int n1, int n2) {

        if (root == null) {
            System.out.println("Node not found!");
            return;
        }

        if (n1 < root.data && n2 < root.data) {
            findLCA_BST(root.left, n1, n2);
        }
        else if (n1 > root.data && n2 > root.data) {
            findLCA_BST(root.right, n1, n2);
        }
        else{
            System.out.println("The LCA is " + root.data);
            return;
        }

    }

    /*********************************************************************
     *   Finds the lowest common ancestor of two nodes in binary tree
     **********************************************************************/
    public void findLCA(int n1, int n2) {
        BSTNode LCA = findLCA(this.root, n1, n2);
        if(LCA != null){
            System.out.println("The LCA is " + LCA.data);
        }
        else{
            System.out.println("Node not found!");
        }
    }

    /*********************************************************************
     *   Finds the lowest common ancestor of two nodes in binary tree
     **********************************************************************/
    public BSTNode findLCA(BSTNode root, int n1, int n2) {

        BSTNode left_LCA;
        BSTNode right_LCA;

        if (root == null) {
            return null;
        }
        if (n1 == root.data || n2 == root.data) {
            return root;
        }
        left_LCA = findLCA(root.left, n1, n2);
        right_LCA = findLCA(root.right, n1, n2);

        if(left_LCA != null && right_LCA != null){
            return root;
        }
        else {
            return ((left_LCA != null) ? left_LCA : right_LCA);
        }
    }

}
