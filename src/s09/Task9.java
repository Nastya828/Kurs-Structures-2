package s09;

import java.util.List;

public class Task9 {
    public static void main(String[] args) {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(55, null);
        SimpleTreeNode<Integer> Node77 = new SimpleTreeNode<>(77, root);
        SimpleTreeNode<Integer> Node78 = new SimpleTreeNode<>(78, root);
        SimpleTreeNode<Integer> Node79 = new SimpleTreeNode<>(79, root);

        SimpleTree<Integer> treeForTest = new SimpleTree<>(root);
        System.out.println("\n--------------EvenTrees()-------------");
        for (int i : treeForTest.EvenTrees()) {
            System.out.print(i + " ");
        }
        // print(treeForTest);
        treeForTest.AddChild(root, Node77);
        treeForTest.AddChild(root, Node78);
        treeForTest.AddChild(root, Node79);
        // print(treeForTest);
        SimpleTreeNode<Integer> Node7 = new SimpleTreeNode<>(7, Node77);
        treeForTest.AddChild(Node77, Node7);
        SimpleTreeNode<Integer> Node8 = new SimpleTreeNode<>(8, Node77);
        treeForTest.AddChild(Node77, Node8);
        //print(treeForTest);
        SimpleTreeNode<Integer> Node88 = new SimpleTreeNode<>(88, Node78);
        treeForTest.AddChild(Node78, Node88);
        SimpleTreeNode<Integer> Node89 = new SimpleTreeNode<>(89, Node78);
        treeForTest.AddChild(Node78, Node89);
        SimpleTreeNode<Integer> Node87 = new SimpleTreeNode<>(87, Node78);
        treeForTest.AddChild(Node78, Node87);
        print(treeForTest);
        System.out.println("\n--------------EvenTrees()-------------");
        for (int i : treeForTest.EvenTrees()) {
            System.out.print(i + " ");
        }
        SimpleTreeNode<Integer> Node34 = new SimpleTreeNode<>(34, Node88);
        treeForTest.AddChild(Node88, Node34);
        System.out.println("\n--------------EvenTrees()-------------");
        for (int i : treeForTest.EvenTrees()) {
            System.out.print(i + " ");
        }
        treeForTest.DeleteNode(Node7);
        treeForTest.DeleteNode(Node34);
        print(treeForTest);
        System.out.println("\n--------------EvenTrees()-------------");
        for (int i : treeForTest.EvenTrees()) {
            System.out.print(i + " ");
        }
        SimpleTreeNode<Integer> Node99 = new SimpleTreeNode<>(99, Node78);
        treeForTest.AddChild(Node78, Node99);
        SimpleTreeNode<Integer> Node808 = new SimpleTreeNode<>(808, Node88);
        treeForTest.AddChild(Node88, Node808);
        SimpleTreeNode<Integer> Node809 = new SimpleTreeNode<>(809, Node88);
        treeForTest.AddChild(Node88, Node809);
        SimpleTreeNode<Integer> Node810 = new SimpleTreeNode<>(810, Node88);
        treeForTest.AddChild(Node88, Node810);
        print(treeForTest);
        System.out.println("\n--------------EvenTrees()-------------");
        for (int i : treeForTest.EvenTrees()) {
            System.out.print(i + " ");
        }
        treeForTest.DeleteNode(Node99);
        print(treeForTest);
        System.out.println("\n--------------EvenTrees()-------------");
        for (int i : treeForTest.EvenTrees()) {
            System.out.print(i + " ");
        }
        SimpleTreeNode<Integer> Node102 = new SimpleTreeNode<>(102, Node79);
        treeForTest.AddChild(Node79, Node102);
        SimpleTreeNode<Integer> Node104 = new SimpleTreeNode<>(104, Node102);
        treeForTest.AddChild(Node102, Node104);

        print(treeForTest);
        System.out.println("\n--------------EvenTrees()-------------");
        for (int i : treeForTest.EvenTrees()) {
            System.out.print(i + " ");
        }
    }

    static void print(SimpleTree<Integer> treeForTest) {
        List<SimpleTreeNode<Integer>> list = treeForTest.GetAllNodes();
        //System.out.println("list.size() = " + list.size());
        System.out.println("tree.count = " + treeForTest.Count());
        System.out.println("LeafCount = " + treeForTest.LeafCount());
        for (SimpleTreeNode<Integer> node : list) {
            if (node.Parent != null) {
                System.out.println("parent - " + node.Parent.NodeValue + " NodeValue - " + node.NodeValue);
            } else {
                System.out.println("parent - " + null + " NodeValue - " + node.NodeValue);
            }
        }
    }

}
