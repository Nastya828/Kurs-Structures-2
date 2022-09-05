package s02;

public class Task2 {
    public static void main(String[] args) {

        BSTNode<String> root = new BSTNode<>(100, "root", null);
        BST<String> tree = new BST<>(root);
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(tree.Root);

        System.out.println(tree.DeleteNodeByKey(100));

        System.out.println("PRINT, size = " + tree.Count());
        routeTree(tree.Root);
        System.out.println(tree.AddKeyValue(43, "43"));


    }

    static void routeTree(BSTNode<String> head) {
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
            routeTree(head.LeftChild);
        }
        if (head.RightChild != null) {
            routeTree(head.RightChild);
        }

    }
}
