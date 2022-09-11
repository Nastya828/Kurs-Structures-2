package s07;


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

        for (int key : a) {
            int x = F(key, 0);
            if (x != -1) {
                HeapArray[x] = key;
            }
        }
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

    private int F(int key, int i) {
        if (i >= HeapArray.length) {
            return -1;
        }
        if (HeapArray[i] == -1) {
            return i;
        }

        if (HeapArray[i] != -1 && key < HeapArray[i]) {
            i = 2 * i + 1;
            return F(key, i);
        }

        if (HeapArray[i] != -1 && key > HeapArray[i]) {
            i = 2 * i + 2;
            return F(key, i);
        }

        return i;
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
