package s02;

import java.util.ArrayList;
import java.util.List;

class BSTNode<T> {
    public int NodeKey;
    public T NodeValue;
    public BSTNode<T> Parent;
    public BSTNode<T> LeftChild;
    public BSTNode<T> RightChild;

    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}


class BSTFind<T> {

    public BSTNode<T> Node;


    public boolean NodeHasKey;


    public boolean ToLeft;

    public BSTFind() {
        Node = null;
    }
}

class BST<T> {
    BSTNode<T> Root;

    public BST(BSTNode<T> node) {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        BSTNode<T> head = this.Root;
        BSTFind<T> result = new BSTFind<>();
        return searchRec(head, key, result);
    }

    private BSTFind<T> searchRec(BSTNode<T> head, int key, BSTFind<T> result) {

        if (key == head.NodeKey) {
            result.Node = head;
            result.NodeHasKey = true;
            result.ToLeft = false;
            return result;

        }
        if (key >= head.NodeKey && head.RightChild == null) {
            result.Node = head;
            result.NodeHasKey = false;
            result.ToLeft = false;
            return result;
        }

        if (key < head.NodeKey && head.LeftChild == null) {
            result.Node = head;
            result.NodeHasKey = false;
            result.ToLeft = true;
            return result;
        }


        if (key < head.NodeKey) {
            searchRec(head.LeftChild, key, result);
        }

        if (key >= head.NodeKey) {
            searchRec(head.RightChild, key, result);
        }

        return result;
    }


    public boolean AddKeyValue(int key, T val) {
        BSTFind<T> placeForNode = FindNodeByKey(key);

        if (placeForNode.NodeHasKey) {
            return false;
        }
        if (placeForNode.ToLeft) {
            placeForNode.Node.LeftChild = new BSTNode<>(key, val, placeForNode.Node);
        } else {
            placeForNode.Node.RightChild = new BSTNode<>(key, val, placeForNode.Node);
        }

        return true;
    }


    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        if (FindMax && FromNode.RightChild == null) {
            return FromNode;
        }
        if (!FindMax && FromNode.LeftChild == null) {
            return FromNode;
        }

        if (FindMax) {
            return FinMinMax(FromNode.RightChild, true);
        }
        return FinMinMax(FromNode.LeftChild, false);


    }


    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> nodeWithKey = FindNodeByKey(key);
        if (!nodeWithKey.NodeHasKey) {
            return false;
        }

        if (nodeWithKey.Node.LeftChild == null && nodeWithKey.Node.RightChild == null) {
            delete(nodeWithKey.Node);
            return !FindNodeByKey(nodeWithKey.Node.NodeKey).NodeHasKey;
        }

        BSTNode<T> newNode;
        if (nodeWithKey.Node.RightChild != null) {
            newNode = searchInsteadNode(nodeWithKey.Node.RightChild);
        } else {
            newNode = nodeWithKey.Node.LeftChild;
        }

        if (nodeWithKey.Node.LeftChild == null || nodeWithKey.Node.LeftChild.equals(newNode)) {
            nodeWithKey.Node.LeftChild = newNode.LeftChild;
        }

        if (newNode.LeftChild != null) {
            newNode.LeftChild.Parent = nodeWithKey.Node;
        }

        if (nodeWithKey.Node.RightChild == null || nodeWithKey.Node.RightChild.equals(newNode)) {
            nodeWithKey.Node.RightChild = newNode.RightChild;
        }
        nodeWithKey.Node.NodeKey = newNode.NodeKey;
        nodeWithKey.Node.NodeValue = newNode.NodeValue;

        delete(newNode);

        return !FindNodeByKey(key).NodeHasKey;
    }

    private void delete(BSTNode<T> newNode) {
        if (newNode.Parent.RightChild == newNode) {
            newNode.Parent.RightChild = null;
        } else if (newNode.Parent.LeftChild == newNode) {
            newNode.Parent.LeftChild = null;
        }
    }


    private BSTNode<T> searchInsteadNode(BSTNode<T> deleted) {

        if (deleted.RightChild == null && deleted.LeftChild == null) {
            return deleted;
        }
        if (deleted.LeftChild == null) {
            return deleted;
        }

        return searchInsteadNode(deleted.LeftChild);
    }


    public int Count() {
        BSTNode<T> head = this.Root;
        List<BSTNode<T>> listForCounter = new ArrayList<>();
        routeTree(head, listForCounter);
        return listForCounter.size();
    }

    private void routeTree(BSTNode<T> head, List<BSTNode<T>> listForCounter) {

        listForCounter.add(head);
        if (head.LeftChild == null && head.RightChild == null) {
            return;
        }
        if (head.LeftChild != null) {
            routeTree(head.LeftChild, listForCounter);
        }
        if (head.RightChild != null) {
            routeTree(head.RightChild, listForCounter);
        }
    }

}
