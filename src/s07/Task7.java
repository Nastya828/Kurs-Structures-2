package s07;

import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) {
        Heap heap = new Heap();
       // int[] a = null;
        System.out.println("HeapMax: " + Arrays.toString(heap.HeapArray));
        int[] a = {1, 9, 77, 68, 44, 9, 6, 10, 5, 7, 22, 70, 46, 2, 80};
        heap.MakeHeap(a, 3);
        System.out.println("HeapMax: " + Arrays.toString(heap.HeapArray));
        System.out.println("Max = "+heap.GetMax());
        System.out.println("HeapMax: " + Arrays.toString(heap.HeapArray));
        System.out.println(heap.Add(199));
        System.out.println("HeapMax: " + Arrays.toString(heap.HeapArray));
        System.out.println(heap.Add(9));
        System.out.println("HeapMax: " + Arrays.toString(heap.HeapArray));

    }
}
