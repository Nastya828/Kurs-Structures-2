package s01;

import java.util.*;

public class SimpleTreeNode<T> {
    public T NodeValue;
    public SimpleTreeNode<T> Parent;
    public List<SimpleTreeNode<T>> Children;

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = null;
    }
}

class SimpleTree<T> {
    public SimpleTreeNode<T> Root;

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        if (!GetAllNodes().contains(ParentNode)) {
            return;
        }
        NewChild.Parent = ParentNode;
        if (ParentNode.Children == null) {
            ParentNode.Children = new ArrayList<>();
            ParentNode.Children.add(NewChild);
        } else {
            ParentNode.Children.add(NewChild);
        }

    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        if (NodeToDelete == this.Root || !GetAllNodes().contains(NodeToDelete)) {
            return;
        }

        if (NodeToDelete.Children != null) {
            NodeToDelete.Children.clear();
        }

        NodeToDelete.Parent.Children.remove(NodeToDelete);
        NodeToDelete.Parent = null;
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {

        List<SimpleTreeNode<T>> allNodesList = new ArrayList<>();
        if (this.Root == null) {
            return allNodesList;
        }

        if (this.Root.Children == null) {
            allNodesList.add(this.Root);
            return allNodesList;
        }
        SimpleTreeNode<T> head = this.Root;
        allNodesList.add(head);
        routeTree(head, allNodesList);

        return allNodesList;
    }

    private void routeTree(SimpleTreeNode<T> startNode, List<SimpleTreeNode<T>> allNodesList) {

        if (startNode.Children == null) {
            return;
        }
        for (int i = 0; i < startNode.Children.size(); i++) {
            allNodesList.add(startNode.Children.get(i));
            routeTree(startNode.Children.get(i), allNodesList);
        }

    }

    public Map<SimpleTreeNode<T>, Integer> writeLevel() {
        Map<SimpleTreeNode<T>, Integer> nodesWithLevels = new HashMap<>();
        SimpleTreeNode<T> head = this.Root;

        nodesWithLevels.put(head, 0);
        int level = 1;
        routeTreeLevel(head, nodesWithLevels, level);
        return nodesWithLevels;
    }

    private void routeTreeLevel(SimpleTreeNode<T> startNode, Map<SimpleTreeNode<T>, Integer> nodesWithLevels, int level) {
        if (startNode.Children == null) {
            return;
        }
        for (int i = 0; i < startNode.Children.size(); i++) {
            nodesWithLevels.put(startNode.Children.get(i), level);
            routeTreeLevel(startNode.Children.get(i), nodesWithLevels, level + 1);
        }

    }


    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        List<SimpleTreeNode<T>> specNodesList = new ArrayList<>();
        for (SimpleTreeNode<T> node : GetAllNodes()) {
            if (node.NodeValue == val) {
                specNodesList.add(node);
            }
        }
        return specNodesList;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        if (OriginalNode == this.Root) {
            return;
        }
        if (!(GetAllNodes().contains(NewParent) && GetAllNodes().contains(OriginalNode))) {
            return;
        }

        OriginalNode.Parent.Children.remove(OriginalNode);
        AddChild(NewParent, OriginalNode);

    }

    public int Count() {
        return GetAllNodes().size();
    }

    public int LeafCount() {
        List<SimpleTreeNode<T>> listAllNodes = GetAllNodes();
        int count = 0;
        for (SimpleTreeNode<T> nodeSearchLeaf : listAllNodes) {
            if (nodeSearchLeaf.Children == null) {
                count++;
            }
        }
        return count;
    }

}
