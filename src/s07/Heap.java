package s07;

import java.util.*;

class Heap {
    public int[] HeapArray;

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        int tree_size = (int) (Math.pow(2, (depth + 1))) - 1;
        HeapArray = new int[tree_size];
        for (int i = 0; i < tree_size; i++) {
            HeapArray[i] = -1;
        }
        if (a == null) {
            return;
        }
        if (HeapArray[0] == -1 && a.length == 1) {
            HeapArray[0] = a[0];
            return;
        }

        Arrays.sort(a);
        F(a, 0);
        for (int i = (tree_size / 2); i >= 0; i--) {
            heapIfy(i);
        }

    }

    private void heapIfy(int index) {
        int rightChild;
        int leftChild;
        int largestChild;

        for (int i = 0; i < HeapArray.length; i++) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            largestChild = index;

            if (leftChild < HeapArray.length && HeapArray[leftChild] > HeapArray[largestChild]) {
                largestChild = leftChild;
            }
            if (rightChild < HeapArray.length && HeapArray[rightChild] > HeapArray[largestChild]) {
                largestChild = rightChild;
            }
            if (largestChild == index) {
                return;
            }
            int temp = HeapArray[index];
            HeapArray[index] = HeapArray[largestChild];
            HeapArray[largestChild] = temp;
            index = largestChild;
        }
    }

    private void F(int[] a, int i) {
        if (i >= HeapArray.length) {
            return;
        }
        if (a.length == 0) {
            return;
        }

        int middle = (int) Math.floor(a.length / 2);

        while (middle > 0 && a[middle] == a[middle - 1]) {
            middle--;
        }
        HeapArray[i] = a[middle];

        int[] leftSubtree = Arrays.copyOfRange(a, 0, middle);
        F(leftSubtree, 2 * i + 1);

        int[] rightSubtree = Arrays.copyOfRange(a, middle + 1, a.length);
        F(rightSubtree, 2 * i + 2);
    }


    public int GetMax() {
        int result = HeapArray[0];
        HeapArray[0] = HeapArray[HeapArray.length - 1];
        HeapArray[HeapArray.length - 1] = -1;
        for (int i = (HeapArray.length / 2); i >= 0; i--) {
            heapIfy(i);
        }
        return result;
    }


    public boolean Add(int key) {
        int index = searchPlace();
        if (index == 0 && HeapArray[0] != -1) {
            return false;
        }
        if (index == 0) {
            HeapArray[0] = key;
            return true;
        }
        HeapArray[index] = key;
        for (int i = (HeapArray.length / 2); i >= 0; i--) {
            heapIfy(i);
        }
        return true;
    }

    private int searchPlace() {
        for (int i = 0; i < HeapArray.length; i++) {
            if (HeapArray[i] == -1) {
                return i;

            }
        }
        return 0;
    }

}
