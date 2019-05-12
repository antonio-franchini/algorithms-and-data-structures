import java.util.ArrayList;
import java.util.HashMap;

public class TreesAndGraphs {

    /***************************************************************************************************************************
     4.1
     Implement a function to check if a tree is balanced. For the purposes of this question,
     a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from the root by more than one
     ***************************************************************************************************************************/

    public boolean isBalanced(BSTNode root) {
        return (maxDepth(root) - minDepth(root) < 2);
    }

    public int maxDepth(BSTNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    public int minDepth(BSTNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + min(minDepth(root.left), minDepth(root.right));
        }
    }

    public int min(int a, int b) {
        return a < b ? a : b;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }


    /***************************************************************************************************************************
     4.2
     Given a directed graph, design an algorithm to find out whether there is a route between two nodes
     ***************************************************************************************************************************/

    public boolean pathExists(Graph.Vertex v1, Graph.Vertex v2) {
        ArrayList<Graph.Vertex> visited = new ArrayList<>();
        return pathExists(v1, v2, visited);
    }

    public boolean pathExists(Graph.Vertex v1, Graph.Vertex v2, ArrayList<Graph.Vertex> visited) {
        boolean found = false;

        if (v1 == v2) {
            return true;
        }
        if (!visited.contains(v1)) {
            visited.add(v1);
            for (int i = 0; i < v1.neighbors.size(); i++) {
                found |= pathExists(v1.neighbors.get(i).getOtherVertex(v1), v2, visited);
            }
        }
        return found;
    }


    /***************************************************************************************************************************
     4.3
     Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height
     ***************************************************************************************************************************/

    public BSTNode createBinaryTreeFromArray(int[] arr) {
        BinarySearchTree b = new BinarySearchTree();
        getMiddleElement(arr, 0, arr.length, b);
        return b.root;
    }

    public void getMiddleElement(int arr[], int start, int end, BinarySearchTree b) {
        if (start < end) {
            int middle = (start + end) / 2;
            b.addNode(arr[middle]);
            getMiddleElement(arr, start, middle, b);
            getMiddleElement(arr, middle + 1, end, b);
        }
    }


    /***************************************************************************************************************************
     4.4
     Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
     (i e , if you have a tree with depth D, you’ll have D linked lists)
     ***************************************************************************************************************************/

    public ArrayList<LLNode> getLevelsLists(BSTNode root) {
        HashMap<Integer, LLNode> temp = new HashMap<>();
        int level = 0;
        getLevelsListsHelper(root, temp, level);
        ArrayList<LLNode> retVal = new ArrayList<>(temp.values());
        return retVal;
    }

    public void getLevelsListsHelper(BSTNode root, HashMap<Integer, LLNode> temp, int level) {
        if (root == null) {
            return;
        }

        if (!temp.containsKey(level)) {
            temp.put(level, new LLNode(root.data));
        } else {
            LLNode i = temp.get(level);
            while (i.next != null) {
                i = i.next;
            }
            i.next = new LLNode(root.data);
        }

        level++;
        getLevelsListsHelper(root.left, temp, level);
        getLevelsListsHelper(root.right, temp, level);
    }


    /***************************************************************************************************************************
     4.5
     Write an algorithm to find the ‘next’ node (i e , in-order successor) of a given node in a binary search tree where each
     node has a link to its parent
     ***************************************************************************************************************************/

    public int findInOrderSuccessor(BSTNode root, int data) {
        BinarySearchTree b = new BinarySearchTree();
        BSTNode start = b.find(root, data);
        BSTNode successor = findInOrderSuccessor(start);
        return successor != null ? successor.data : -1;
    }

    public BSTNode findInOrderSuccessor(BSTNode node) {
        return findInOrderSuccessorHelper(node, node);
    }

    public BSTNode findInOrderSuccessorHelper(BSTNode start, BSTNode node) {
        if (start == null || node == null) {
            return null;
        }
        if (node.right != null && node.right != start) {
            return node.right;
        } else if (isLeftChild(node)) {
            return node.parent;
        } else {
            return findInOrderSuccessorHelper(node, node.parent);
        }
    }

    public boolean isLeftChild(BSTNode node) {
        if (node.parent != null && node.parent.left == node) {
            return true;
        } else {
            return false;
        }
    }


    /***************************************************************************************************************************
     4.6
     Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.  Avoid storing
     additional nodes in a data structure.  NOTE: This is not necessarily a binary search tree
     ***************************************************************************************************************************/

    static final int FOUND_NONE = 0;
    static final int FOUND_A = 1;
    static final int FOUND_B = 2;
    static final int FOUND_BOTH = 3;
    static final int FOUND_PARENT_CHILD_RELATIONSHIP = 4;

    public BSTNode LCA(BSTNode root, BSTNode a, BSTNode b) {
        ArrayList<BSTNode> lca = new ArrayList<>();
        LCA(root, a, b, lca);
        return lca.isEmpty() ? null : lca.get(0);
    }

    public int LCA(BSTNode root, BSTNode a, BSTNode b, ArrayList<BSTNode> lca) {
        if (root == null) {
            return FOUND_NONE;
        }
        if (root == a) {
            int left = LCA(root.left, a, b, lca);
            int right = LCA(root.right, a, b, lca);
            if (left == FOUND_B || right == FOUND_B) {
                return FOUND_PARENT_CHILD_RELATIONSHIP;
            }
            return FOUND_A;
        }
        if (root == b) {
            int left = LCA(root.left, a, b, lca);
            int right = LCA(root.right, a, b, lca);
            if (left == FOUND_A || right == FOUND_A) {
                return FOUND_PARENT_CHILD_RELATIONSHIP;
            }
            return FOUND_B;
        }
        int left = LCA(root.left, a, b, lca);
        int right = LCA(root.right, a, b, lca);

        if (left == FOUND_PARENT_CHILD_RELATIONSHIP || right == FOUND_PARENT_CHILD_RELATIONSHIP) {
            lca.add(root);
            return FOUND_BOTH;
        }
        if (left == FOUND_BOTH || right == FOUND_BOTH) {
            return FOUND_BOTH;
        }
        if ((left == FOUND_A && right == FOUND_B) || (left == FOUND_B && right == FOUND_A)) {
            lca.add(root);
            return FOUND_BOTH;
        }
        if ((left == FOUND_A || right == FOUND_A) && root == b) {
            return FOUND_PARENT_CHILD_RELATIONSHIP;
        }
        if ((left == FOUND_B || right == FOUND_B) && root == a) {
            return FOUND_PARENT_CHILD_RELATIONSHIP;
        }

        if (left == FOUND_A || right == FOUND_A) {
            return FOUND_A;
        }
        if (left == FOUND_B || right == FOUND_B) {
            return FOUND_B;
        } else {
            return FOUND_NONE;
        }
    }


    /***************************************************************************************************************************
     4.7
     You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
     Create an algorithm to decide if T2 is a subtree of T1
     ***************************************************************************************************************************/

    public boolean isSubtree(BSTNode root1, BSTNode root2) {
        ArrayList<Boolean> flags = new ArrayList<>();
        flags.add(false);
        return isSubtreeHelper(root1, root2, root2, flags);
    }

    public boolean isSubtreeHelper(BSTNode node1, BSTNode node2, BSTNode root2, ArrayList<Boolean> flags) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.data != node2.data) {
            return isSubtreeHelper(node1.left, root2, root2, flags) || isSubtreeHelper(node1.right, root2, root2, flags);
        } else {
            boolean temp = isSubtreeHelper(node1.left, node2.left, root2, flags) && isSubtreeHelper(node1.right, node2.right, root2, flags);
            if (node1.data == root2.data) {
                return (temp
                        || isSubtreeHelper(node1.left, root2, root2, flags)
                        || isSubtreeHelper(node1.right, root2, root2, flags));
            } else {
                return temp;
            }
        }
    }


    /***************************************************************************************************************************
     4.8
     You are given a binary tree in which each node contains a value.  Design an algorithm to print all paths which sum up
     to that value.  Note that it can be any path in the tree - it does not have to start at the root
     ***************************************************************************************************************************/


    /***************************************************************************************************************************
     TreesAndGraphs informal testing
     ***************************************************************************************************************************/

    public void exerciseTreesAndGraphs() {

        MyPrinter p = new MyPrinter();
        BinarySearchTree b = new BinarySearchTree();
        TreesAndGraphs t = new TreesAndGraphs();

        b.addNode(5);
        b.addNode(2);
        b.addNode(8);
        b.addNode(1);
        b.addNode(4);
        b.addNode(6);
        b.addNode(9);
        b.addNode(10);

        //    Binary search tree b now looks like this:
        //
        //          5
        //        /    \
        //       2      8
        //     /  \    / \
        //    1   4   6   9
        //                 \
        //                  10

        p.printTreeDiagram(b.root);

        System.out.println("(4.1) Is balanced: " + t.isBalanced(b.root));

        System.out.println("(4.4) Level order printout:");
        ArrayList<LLNode> nodeArray = t.getLevelsLists(b.root);
        nodeArray.forEach(n -> p.printLinkedlist(n));

        int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("(4.3) Tree generated from the list:");
        p.printTreeDiagram(t.createBinaryTreeFromArray(arr));

        System.out.println("(4.5) The in-order successor is: " + t.findInOrderSuccessor(b.root, 6));

        Graph g = new Graph();

        g.addVertex("A");
        g.addVertex("B");
        g.addVertex("C");
        g.addVertex("D");
        g.addVertex("E");
        g.addVertex("F");
        g.addVertex("G");
        g.addVertex("H");
        g.addVertex("K");
        g.addVertex("M");

        g.addEdge("A", "B");
        g.addEdge("A", "C");
        g.addEdge("A", "D");
        g.addEdge("B", "C");
        g.addEdge("B", "F");
        g.addEdge("C", "D");
        g.addEdge("F", "E");
        g.addEdge("E", "G");
        g.addEdge("E", "H");
        g.addEdge("G", "M");
        g.addEdge("H", "M");
        g.addEdgeDirected("K", "F");

        //        Graph g looks now like this:
        //
        //        A ---- B ---- F ---- E ---- G
        //        | \  /        ^      |      |
        //        |  \/         |      |      |
        //        |  /\         |      |      |
        //        | /  \        |      |      |
        //        C ---- D      K      H ---- M
        //
        //        Note that all the edges are bidirectional except for K --> F

        System.out.println("(4.2) The path between the two nodes exists: " + t.pathExists(g.getVertexFromLabel("A"), g.getVertexFromLabel("K")));

        //    Binary search tree b still looks like this:
        //
        //          5
        //        /    \
        //       2      8
        //     /  \    / \
        //    1   4   6   9
        //                 \
        //                  10

        BSTNode lca = t.LCA(b.root, b.find(b.root, 1), b.find(b.root, 10));
        System.out.println("(4.6) The LCA between the two nodes is: " + (lca == null ? "none" : lca.data));
        System.out.println("");

        BSTNode bLeaf = b.find(b.root, 10);
        BSTNode ten = new BSTNode(10);
        BSTNode nine = new BSTNode(9, null, ten);
        BSTNode six = new BSTNode(6);
        BSTNode eight = new BSTNode(8, six, nine);
        bLeaf.setRight(eight);

        //    Tree b is no longer a binary serach tree and it now looks like this:
        //
        //          5
        //        /    \
        //       2      8
        //     /  \    / \
        //    1   4   6   9
        //                 \
        //                  10
        //                   \
        //                    8
        //                   / \
        //                  6   9
        //                       \
        //                        10

        System.out.println("b diagram:");
        p.printTreeDiagram(b.root);

        BinarySearchTree b2 = new BinarySearchTree();
        b2.addNode(8);
        b2.addNode(6);
        b2.addNode(9);
        b2.addNode(10);

        //    Binary search tree b2 looks like this:
        //
        //      8
        //     / \
        //    6   9
        //         \
        //         10

        System.out.println("b2 diagram:");
        p.printTreeDiagram(b2.root);

        System.out.println("(4.7) Tree b2 is a subtree of b: " + t.isSubtree(b.root, b2.root));
    }

}
