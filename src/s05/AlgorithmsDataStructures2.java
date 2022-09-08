package s05;

import java.util.*;


public class AlgorithmsDataStructures2 {
    private static Integer midElement(int start, int end) {
        if (start > end) {
            return null;
        }
        return (start + end) / 2;
    }

    public static int[] GenerateBBSTArray(int[] a) {
        if (a == null) {
            return new int[0];
        }
        if (a.length < 3) {
            return a;
        }
        Arrays.sort(a);
        Integer middle = midElement(0, a.length);
        if (middle == null) {
            return new int[a.length];
        }
        Map<Integer, Integer> mapLevel = new TreeMap<>();
        mapLevel.put(a[middle], 0);
        int[] left = new int[a.length - middle - 1];
        for (int i = 0; i < middle; i++) {
            left[i] = a[i];
        }
        int[] right = new int[a.length - middle - 1];
        for (int i = middle + 1; i < a.length; i++) {
            right[i - (middle + 1)] = a[i];
        }

        recAddBst(left, right, mapLevel, 1);
        int[] result = new int[a.length];
        Map<Integer, Integer> resultMap = new LinkedHashMap<>();

        mapLevel.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> resultMap.put(x.getKey(), x.getValue()));

        int number = 0;
        for (int i : resultMap.keySet()) {
            if (number < result.length) {
                result[number] = i;
            }
            number++;
        }

        return result;
    }


    private static void recAddBst(int[] left, int[] right, Map<Integer, Integer> mapLevel, int level) {

        if (left.length < 1) {
            return;
        }
        Integer middleLeft = midElement(0, left.length);
        Integer middleRight = midElement(0, right.length);

        if (middleLeft == null && middleRight == null) {
            return;
        }

        mapLevel.put(left[middleLeft], level);
        mapLevel.put(right[middleRight], level);
        int[] leftM = new int[left.length - middleLeft - 1];
        int[] leftR = new int[right.length - middleRight - 1];


        for (int i = 0; i < middleLeft; i++) {
            leftM[i] = left[i];
        }

        for (int i = middleLeft + 1; i < left.length; i++) {
            leftR[i - (middleLeft + 1)] = left[i];
        }

        recAddBst(leftM, leftR, mapLevel, level + 1);

        int[] rightM = new int[right.length - middleRight - 1];
        int[] rightR = new int[right.length - middleRight - 1];

        for (int i = 0; i < middleRight; i++) {
            rightR[i] = right[i];
        }

        for (int i = middleRight + 1; i < right.length; i++) {
            rightM[i - (middleRight + 1)] = right[i];
        }
        recAddBst(rightR, rightM, mapLevel, level + 1);
    }

}

