package s03;

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


    public ArrayList<BSTNode> WideAllNodes() {
        ArrayList<BSTNode> resultWide = new ArrayList<>();
        int index = 0;
        if (this.Root == null) {
            return resultWide;
        }
        if (this.Root.RightChild == null && this.Root.LeftChild == null) {
            resultWide.add(this.Root);
            return resultWide;
        }
        resultWide.add(index, this.Root);
        routeWide(resultWide, index);
        return resultWide;
    }

    private void routeWide(ArrayList<BSTNode> resultWide, int index) {
        boolean cancelRout = (resultWide.get(index).LeftChild == null && resultWide.get(index).RightChild == null);
        if (cancelRout) {
            return;
        }
        if (resultWide.get(index).LeftChild != null) {
            resultWide.add(resultWide.get(index).LeftChild);
        }
        if (resultWide.get(index).RightChild != null) {
            resultWide.add(resultWide.get(index).RightChild);
        }
        routeWide(resultWide, index + 1);
    }


    public ArrayList<BSTNode> DeepAllNodes(int order) {
        ArrayList<BSTNode> resultDeep = new ArrayList<>();
        BSTNode<T> head = this.Root;
        if (head == null) {
            return resultDeep;
        }
        if (head.RightChild == null && head.LeftChild == null) {
            resultDeep.add(head);
            return resultDeep;
        }
        if (order == 0) {
            inOrder(head, resultDeep);
        }
        if (order == 1) {
            postOrder(head, resultDeep);
        }
        if (order == 2) {
            preOrder(head, resultDeep);
        }
        return resultDeep;
    }

    private void postOrder(BSTNode head, ArrayList<BSTNode> resultDeep) {
        if (head == null) {
            return;
        }
        if (head.LeftChild != null) {
            postOrder(head.LeftChild, resultDeep);
        }
        if (head.RightChild != null) {
            postOrder(head.RightChild, resultDeep);
        }
        resultDeep.add(head);

    }

    private void inOrder(BSTNode head, ArrayList<BSTNode> resultDeep) {
        if (head == null) {
            return;
        }
        if (head.LeftChild != null) {
            inOrder(head.LeftChild, resultDeep);
        }
        resultDeep.add(head);
        if (head.RightChild != null) {
            inOrder(head.RightChild, resultDeep);
        }

    }

    private void preOrder(BSTNode head, ArrayList<BSTNode> resultDeep) {
        if (head == null) {
            return;
        }
        resultDeep.add(head);
        if (head.LeftChild != null) {
            preOrder(head.LeftChild, resultDeep);
        }
        if (head.RightChild != null) {
            preOrder(head.RightChild, resultDeep);
        }
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
        if (key > head.NodeKey && head.RightChild == null) {
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

        if (key > head.NodeKey) {
            searchRec(head.RightChild, key, result);
        }

        return result;
    }


    public boolean AddKeyValue(int key, T val) {
        if (this.Root == null) {
            this.Root = new BSTNode<>(key, val, null);
            return true;
        }

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
        if (this.Root.NodeKey == key) {
            this.Root = null;
            return true;
        }
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
        if (this.Root == null) {
            return 0;
        }
        BSTNode<T> head = this.Root;
        List<BSTNode<T>> listForCounter = new ArrayList<>();
        routeTree(head, listForCounter);
        System.out.print("{Tree: [");
        for (BSTNode<T> n : listForCounter) {
            System.out.print(n.NodeKey + ", ");
        }
        System.out.print("]\n");
        return listForCounter.size();
    }

    private void routeTree(BSTNode<T> head, List<BSTNode<T>> listForCounter) {

        listForCounter.add(head);
        if (head == null || (head.LeftChild == null && head.RightChild == null)) {
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
