package s06;

import java.util.*;

class BSTNode {
    public int NodeKey;
    public BSTNode Parent;
    public BSTNode LeftChild;
    public BSTNode RightChild;
    public int Level;

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {
    public BSTNode Root;

    public BalancedBST() {
        Root = null;
    }


    public void GenerateTree(int[] a) {
        if (a == null) {
            return;
        }
        if (a.length == 1) {
            this.Root = new BSTNode(a[0], null);
            return;
        }
        Arrays.sort(a);
        F(null, 0, a);
    }

    private BSTNode F(BSTNode parent, int level, int[] a) {

        if (a.length == 0) {
            return null;
        }


        int middle = (int) Math.floor(a.length / 2);

        while (middle > 0 && a[middle] == a[middle - 1]) {
            middle--;
        }
        BSTNode head = new BSTNode(a[middle], parent);
        head.Level = level;
        if (parent == null) {
            this.Root = head;
        }

        int[] leftSubtree = Arrays.copyOfRange(a, 0, middle);
        head.LeftChild = F(head, level + 1, leftSubtree);

        int[] rightSubtree = Arrays.copyOfRange(a, middle + 1, a.length);
        head.RightChild = F(head, level + 1, rightSubtree);
        return head;
    }


    public boolean IsBalanced(BSTNode root_node) {
        if (root_node == null || (this.Root.RightChild == null && this.Root.LeftChild == null)) {
            return true;
        }
        return CheckTreeHeight(root_node) != -1;
    }

    private int CheckTreeHeight(BSTNode root) {

        if (root == null) {
            return 0;
        }
        int leftChildHeight = CheckTreeHeight(root.LeftChild);
        if (leftChildHeight == -1) {
            return -1;
        }

        int rightChildHeight = CheckTreeHeight(root.RightChild);
        if (rightChildHeight == -1) {
            return -1;
        }
        int heightDifference = leftChildHeight - rightChildHeight;

        if (Math.abs(heightDifference) <= 1) {
            return Math.max(leftChildHeight, rightChildHeight) + 1;
        }
        return -1;
    }

}
