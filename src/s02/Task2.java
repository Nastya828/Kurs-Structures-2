package s02;

public class Task2 {
    public static void main(String[] args) {

        BSTNode<String> root = new BSTNode<>(100, "root", null);
        BST<String> tree = new BST<>(root);
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("MAX = " + tree.FinMinMax(root, true).NodeKey);
        System.out.println(tree.AddKeyValue(6, "six"));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println(tree.AddKeyValue(5, "five"));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);

        System.out.println(tree.AddKeyValue(1, "first"));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println(tree.AddKeyValue(10, "ten"));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println(tree.AddKeyValue(10, "ten"));
        System.out.println(tree.AddKeyValue(5, "five"));
        System.out.println(tree.AddKeyValue(2, "two"));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println(tree.AddKeyValue(4, "four"));
        System.out.println(tree.AddKeyValue(3, "tree"));
        System.out.println(tree.AddKeyValue(9, "nine"));
        System.out.println(tree.AddKeyValue(24, "twenty-four"));
        System.out.println(tree.AddKeyValue(19, "nineteen"));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println(tree.AddKeyValue(110, "hundred ten"));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("-5 = " + tree.AddKeyValue(-5, "minus five"));
        System.out.println("PRINT, size = " + tree.Count());
        //routeTree(root);


        System.out.println("/*--------------------------------------*/");
        System.out.println("Delete 110: " + tree.DeleteNodeByKey(110));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete 10: " + tree.DeleteNodeByKey(10));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete 200: " + tree.DeleteNodeByKey(200));
        System.out.println("PRINT, size = " + tree.Count());
        // routeTree(root);
        System.out.println("Delete 6: " + tree.DeleteNodeByKey(6));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete 5: " + tree.DeleteNodeByKey(5));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete 9: " + tree.DeleteNodeByKey(9));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete 3: " + tree.DeleteNodeByKey(3));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete 1: " + tree.DeleteNodeByKey(1));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete 2: " + tree.DeleteNodeByKey(2));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete 19: " + tree.DeleteNodeByKey(19));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete 4: " + tree.DeleteNodeByKey(4));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete -5: " + tree.DeleteNodeByKey(-5));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(root);
        System.out.println("Delete 24: " + tree.DeleteNodeByKey(24));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(tree.Root);
        System.out.println("Delete root: " + tree.DeleteNodeByKey(100));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(tree.Root);
        tree.AddKeyValue(99, "root");
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(tree.Root);
        System.out.println("Delete root: " + tree.DeleteNodeByKey(99));
        System.out.println("PRINT, size = " + tree.Count());
        routeTree(tree.Root);
    }

    static void routeTree(BSTNode<String> head) {
        if (head == null) {
            return;
        }
        if (head != null) {
            System.out.println(" head = " + head.NodeKey + " Value = " + head.NodeValue);
        }

        if (head.Parent != null) {
            System.out.println("\nparent.key = " + head.Parent.NodeKey + " value =" + head.Parent.NodeValue);
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
