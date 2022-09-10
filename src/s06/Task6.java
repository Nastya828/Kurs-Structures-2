package s06;


import java.util.Arrays;

public class Task6 {
    public static void main(String[] args) {
         //int[] a = {1, 9, 77, 68, 44, -9, 6, -10, 5, 7, 22, 70, 46, 80, 2, 2, 2};
        int[] a = { 1, 1};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        //int[] a = null;
        BalancedBST tree = new BalancedBST();

        printTree(tree.Root);
        tree.GenerateTree(a);

        printTree(tree.Root);
        System.out.println("isBalanced: " + tree.IsBalanced(tree.Root));

    }

    static void printTree(BSTNode head) {
        if (head == null) {
            return;
        }
        if (head != null) {
            System.out.println(" head = " + head.NodeKey + " Value = " + head.NodeKey + " level = " + head.Level);
        }

        if (head.Parent != null) {
            System.out.println("parent.key = " + head.Parent.NodeKey + " value =" + head.Parent.NodeKey);
        }

        if (head.RightChild != null) {
            System.out.println(" Right = " + head.RightChild.NodeKey + " Value = " + head.RightChild.NodeKey);
        }
        if (head.LeftChild != null) {
            System.out.println(" Left = " + head.LeftChild.NodeKey + " Value = " + head.LeftChild.NodeKey);
        }

        System.out.println("END");

        if (head.LeftChild == null && head.RightChild == null) {
            return;
        }
        if (head.LeftChild != null) {
            printTree(head.LeftChild);
        }
        if (head.RightChild != null) {
            printTree(head.RightChild);
        }

    }
}
