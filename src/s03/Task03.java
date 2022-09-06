package s03;

public class Task03 {
    public static void main(String[] args) {
        BSTNode<Integer> root = new BSTNode<>(0, 0, null);
        BST<Integer> treeInt = new BST<>(root);
        treeInt.AddKeyValue(8, 8);
        treeInt.AddKeyValue(-8, -8);
        treeInt.AddKeyValue(9, 9);
        treeInt.AddKeyValue(-9, -9);
        treeInt.AddKeyValue(1, 1);
        treeInt.AddKeyValue(-1, -1);
        System.out.println("PRINT, size = " + treeInt.Count());
        //printTree(treeInt.Root);

        System.out.print("{Tree: [");
        for (BSTNode<Integer> n : treeInt.WideAllNodes()) {
            System.out.print(n.NodeKey + ", ");
        }
        System.out.print("]\n");
        System.out.println("-----Deep 0, in-Order - Root = middle-------");
        System.out.print("{Tree: [");
        for (BSTNode<Integer> n : treeInt.DeepAllNodes(0)) {
            System.out.print(n.NodeKey + ", ");
        }
        System.out.print("]\n");

        System.out.print("]\n");
        System.out.println("-----Deep 1, post-Order - Root = last-------");
        System.out.print("{Tree: [");
        for (BSTNode<Integer> n : treeInt.DeepAllNodes(1)) {
            System.out.print(n.NodeKey + ", ");
        }
        System.out.print("]\n");


        System.out.print("]\n");
        System.out.println("-----Deep 2, pre-Order - Root = first-------");
        System.out.print("{Tree: [");
        for (BSTNode<Integer> n : treeInt.DeepAllNodes(2)) {
            System.out.print(n.NodeKey + ", ");
        }
        System.out.print("]\n");

    }

    static void printTree(BSTNode<Integer> head) {
        if (head == null) {
            return;
        }
        if (head != null) {
            System.out.println(" head = " + head.NodeKey + " Value = " + head.NodeValue);
        }

        if (head.Parent != null) {
            System.out.println("parent.key = " + head.Parent.NodeKey + " value =" + head.Parent.NodeValue);
        }

        if (head.RightChild != null) {
            System.out.println(" Right = " + head.RightChild.NodeKey + " Value = " + head.RightChild.NodeValue);
        }
        if (head.LeftChild != null) {
            System.out.println(" Left = " + head.LeftChild.NodeKey + " Value = " + head.LeftChild.NodeValue);
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
