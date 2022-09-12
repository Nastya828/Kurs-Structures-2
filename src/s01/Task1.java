package s01;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(55, null);
        SimpleTreeNode<Integer> Node77 = new SimpleTreeNode<>(77, root);
        SimpleTreeNode<Integer> Node78 = new SimpleTreeNode<>(78, root);
        SimpleTreeNode<Integer> Node79 = new SimpleTreeNode<>(79, root);
        SimpleTree<Integer> treeForTest = new SimpleTree<>(root);
        // print(treeForTest);
        treeForTest.AddChild(root, Node77);
        treeForTest.AddChild(root, Node78);
        treeForTest.AddChild(root, Node79);
        // print(treeForTest);
        SimpleTreeNode<Integer> Node7 = new SimpleTreeNode<>(7, Node77);
        treeForTest.AddChild(Node77, Node7);
        SimpleTreeNode<Integer> Node8 = new SimpleTreeNode<>(8, Node77);
        treeForTest.AddChild(Node77, Node8);
        print(treeForTest);
        SimpleTreeNode<Integer> Node88 = new SimpleTreeNode<>(88, Node78);
        treeForTest.AddChild(Node78, Node88);
        SimpleTreeNode<Integer> Node89 = new SimpleTreeNode<>(89, Node78);
        treeForTest.AddChild(Node78, Node89);
        SimpleTreeNode<Integer> Node87 = new SimpleTreeNode<>(87, Node78);
        treeForTest.AddChild(Node78, Node87);
        print(treeForTest);
        treeForTest.DeleteNode(Node78);
        print(treeForTest);
        treeForTest.DeleteNode(Node77);
        print(treeForTest);
        treeForTest.DeleteNode(Node79);
        System.out.println(treeForTest.Root.Children);
        print(treeForTest);



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
