package s04;

import java.util.Arrays;

class aBST {
    public Integer[] Tree;

    public aBST(int depth) {

        int tree_size = depth + 1;
        Tree = new Integer[tree_size];
        for (int i = 0; i < tree_size; i++) Tree[i] = null;
    }

    public Integer FindKeyIndex(int key) {
        if (Tree[0] != null && Tree[0] == key) {
            return 0;
        }
        int indexFound = searchPlaceForAdd(0, key);
        if (indexFound != 0 && indexFound != -1 && Tree[indexFound] == null) {
            return -indexFound;
        }
        if (indexFound != -1 && indexFound != 0) {
            return indexFound;
        }
        return null;
    }


    public int AddKey(int key) {

        if (Tree[0] == null) {
            Tree[0] = key;
            return 0;
        }
        int resultAdd = searchPlaceForAdd(0, key);
        if (resultAdd != -1) {
            Tree[resultAdd] = key;
        }
        return resultAdd;

    }

    private int searchPlaceForAdd(int I, int key) {
        if (I >= Tree.length) {
            return -1;
        }
        if (Tree[I] == null) {
            return I;
        }

        if (Tree[I] != null && key < Tree[I]) {
            I = 2 * I + 1;
            return searchPlaceForAdd(I, key);
        }

        if (Tree[I] != null && key > Tree[I]) {
            I = 2 * I + 2;
            return searchPlaceForAdd(I, key);
        }

        return I;
    }

    @Override
    public String toString() {
        return "aBST{" +
                "Tree=" + Arrays.toString(Tree) +
                '}';
    }
}
