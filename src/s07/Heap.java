package s07;


import java.util.Arrays;

class Heap {
    public int[] HeapArray;

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        int tree_size = (int) (Math.pow(2, (depth + 1))) - 1;
        HeapArray = new int[tree_size];

        if (a == null) {
            return;
        }
        if (HeapArray[0] == -1 && a.length == 1) {
            HeapArray[0] = a[0];
            return;
        }

        for (int i = (tree_size / 2); i >= 0; i--) {
            heapIfy(a, tree_size, i);
        }
        HeapArray = Arrays.copyOf(a, tree_size);

    }

    private void heapIfy(int[] a, int tree_size, int index) {
        int rightChild;
        int leftChild;
        int largestChild;

        for (int i = 0; i < a.length; i++) {
            leftChild = 2 * index + 1;
            rightChild = 2 * index + 2;
            largestChild = index;

            if (leftChild < a.length && a[leftChild] > a[largestChild]) {
                largestChild = leftChild;
            }
            if (rightChild < a.length && a[rightChild] > a[largestChild]) {
                largestChild = rightChild;
            }
            if (largestChild == index) {
                return;
            }
            int temp = a[index];
            a[index] = a[largestChild];
            a[largestChild] = temp;
            index = largestChild;
        }
    }




    public int GetMax() {
        int result = HeapArray[0];
        HeapArray[0] = HeapArray[HeapArray.length - 1];
        HeapArray[HeapArray.length - 1] = 0;
        for (int i = (HeapArray.length / 2); i >= 0; i--) {
            heapIfy(HeapArray, HeapArray.length, i);
        }
        return result;
    }


    public boolean Add(int key) {
        int index = searchPlace();
        if (index == 0 && HeapArray[0] != 0) {
            return false;
        }
        if (index == 0) {
            HeapArray[0] = key;
            return true;
        }
        HeapArray[index] = key;
        for (int i = (HeapArray.length / 2); i >= 0; i--) {
            heapIfy(HeapArray, HeapArray.length, i);
        }
        return true;
    }

    private int searchPlace() {
        for (int i = 0; i < HeapArray.length; i++) {
            if (HeapArray[i] == 0) {
                return i;

            }
        }
        return 0;
    }

}
