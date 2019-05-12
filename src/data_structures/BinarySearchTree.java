import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class BinarySearchTree {

    BSTNode root;

    BinarySearchTree(){
        this.root = null;
    }

    public void setRoot(BSTNode root){
        this.root = root;
    }

    public BSTNode getRoot(){
        return this.root;
    }

    public void addNode(int data){
        if(this.root == null){
            this.root = new BSTNode(data, null);
        }
        else {
            addNode(data, this.root);
        }
    }

    public BSTNode createNode(int data){
        return new BSTNode(data);
    }

    public void addNode(int data, BSTNode root){
        if(data < root.data){
            if(root.left == null) {
                root.left = new BSTNode(data, root);
            }
            else{
                addNode(data, root.left);
            }
        }
        else{
            if(root.right == null) {
                root.right = new BSTNode(data, root);
            }
            else{
                addNode(data, root.right);
            }
        }
    }

    public void printTreePreorder(){
        if(this.root == null){
            System.out.println("The tree is empty");
        }
        else{
            printTreePreorder(this.root);
        }
    }

    public void printTreePreorder(BSTNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printTreePreorder(root.left);
        printTreePreorder(root.right);
    }

    public void printTreeLevelOrder(BSTNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printTreePreorder(root.levelRight);
    }

    //          5
    //        /    \
    //       2      8
    //     /  \    /
    //    1   4   6
    //
    //
    //   5 2 8 1 4 6

    public boolean isBinaryTree(BSTNode root, int min, int max){
        /* An empty tree is a Binary Tree */
        if (root == null)
            return true;
        /* False if this node violates the min/max constraints */
        if (root.data < min || root.data > max)
            return false;
        /* Otherwise check the subtrees recursively tightening the min/max constraints */
        return (isBinaryTree(root.left, min, root.data) &&
                isBinaryTree(root.right, root.data, max));
    }

    public BSTNode getLowestCommonAncestor(BSTNode root, BSTNode n1, BSTNode n2){
        /* return null if this path didn't find neither n1 or n2 */
        if (root == null)
            return null;

        /* return this node if this path did find either n1 or n2 */
        if (root == n1 || root == n2)
            return root;

        /* continue searching in the left and right paths (for either one of the two nodes or null) */
        BSTNode leftTree = getLowestCommonAncestor(root.left, n1, n2);
        BSTNode rightTree = getLowestCommonAncestor(root.right, n1, n2);

        /* if the current node subtree contain the two target nodes then this is the ancestor */
        if(leftTree != null && rightTree != null ){
            return root;
        }
        /* otherwise the left child is the the ancestor */
        else if(leftTree != null){
            return leftTree;
        }
        /* otherwise the right child is the the ancestor */
        else{
            return rightTree;
        }
    }

    public void convertToList(BSTNode root){
        if(root == null){
            return;
        }
        if(root.left != null) {
            convertToList(root.left);
        }
        if(root.right != null) {
            convertToList(root.right);
        }
        if(root.right != null) {
            BSTNode i = root;
            while(i != null && i.left != null){
                i = i.left;
            }
            i.left = root.right;
        }
        /* This step needs to occur at the end if inorder style is used so
        that we don't skip nodes in the right subtree in the conversion */
        root.right = null;

    }

    public void connectLevels(){
        Vector<Vector<BSTNode>> v = new Vector<>();
        v.add(new Vector<BSTNode>());
        connectLevels(this.root, v, 0);

        for(int i = 0; i < v.size(); i++){
            int j;
            for(j = 0; j < v.get(i).size()-1; j++){
                v.get(i).get(j).levelRight = v.get(i).get(j+1);
            }
        }
    }

    public void connectLevels(BSTNode root, Vector<Vector<BSTNode>> v, int level){
        if(root == null){
            return;
        }

        v.get(level).add(root);
        v.add(new Vector<BSTNode>());
        level++;

        if(root.left != null){
            connectLevels(root.left, v, level);
        }
        if(root.right != null){
            connectLevels(root.right, v, level);
        }
    }

    public BSTNode find(BSTNode root, int data){
        if(root == null){
            return null;
        }
        if(root.data > data){
            return find(root.left, data);
        }
        if(root.data < data){
            return find(root.right, data);
        }
        /* else if root.data == data */
        return root;
    }


}
