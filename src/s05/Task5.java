package s05;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int[] a = {1, 9, 77, 68, 44, -9, 6, -10, 5, 7, 22, 70, 46, 80, 2};
        System.out.println("a = " + Arrays.toString(AlgorithmsDataStructures2.GenerateBBSTArray(a)));

        int[] a1 = {1, 9, 77, 68, 44, -9, 6};
        System.out.println("a1 = " + Arrays.toString(AlgorithmsDataStructures2.GenerateBBSTArray(a1)));

        int[] a2 = {1, 9, 68};
        System.out.println("a2 = " + Arrays.toString(AlgorithmsDataStructures2.GenerateBBSTArray(a2)));

        int[] a3 = {9};
        System.out.println("a3 = " + Arrays.toString(AlgorithmsDataStructures2.GenerateBBSTArray(a3)));

        int[] a4 = null;
        System.out.println("a4 = " + Arrays.toString(AlgorithmsDataStructures2.GenerateBBSTArray(a4)));
    }
}
