public class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;
    BSTNode levelRight;
    BSTNode parent;

    BSTNode(){
    }

    BSTNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.levelRight = null;
        this.parent = null;
    }

    BSTNode(int data, BSTNode left, BSTNode right){
        this.data = data;
        this.left = left;
        this.right = right;
        this.levelRight = null;
        this.parent = null;
    }

    BSTNode(int data, BSTNode parent){
        this.data = data;
        this.left = null;
        this.right = null;
        this.levelRight = null;
        this.parent = parent;
    }

    public void setLeft(BSTNode left){
        this.left = left;
    }

    public void setRight(BSTNode right){
        this.right = right;
    }

}
