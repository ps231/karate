package karate.chops.general;

import java.util.ArrayList;
import java.util.List;

public class FindSubmergedPeaks {

    public static void main(String args[]) throws Exception {
        printList("Should print 1, 2", getSubmergedPeaks(new int[]{5, 4, 3, 5}));
        printList("Should print 1, 2, 3", getSubmergedPeaks(new int[]{5, 1, 1, 1, 5}));
        printList("Should print empty", getSubmergedPeaks(new int[]{5}));
        printList("Should print empty", getSubmergedPeaks(new int[]{5, 4, 3}));
        printList("Should print empty", getSubmergedPeaks(new int[]{3, 4, 5}));
        printList("Should print empty", getSubmergedPeaks(new int[]{}));
//        printList("Should print 1, 2, 4", getSubmergedPeaks(new int[]{8, 3, 4, 8, 5, 8}));
    }

    private static void printList(String message, List<Integer> l) {
        System.out.print(message + ":");
        if (l == null)
            return;
        for (int i : l)
            System.out.print(i + " ");
        System.out.println("");
    }

    private static List<Integer> getSubmergedPeaks(int[] mountainPeaks) {
        List<Integer> submergedPeaks = new ArrayList<>();
        if (mountainPeaks == null || mountainPeaks.length == 0)
            return null;

        if (mountainPeaks.length <= 2)
            return submergedPeaks;

        int leftPeak = mountainPeaks[0];
        int rightPeak = mountainPeaks[mountainPeaks.length - 1];

        for (int i = 1, j = mountainPeaks.length - 2; i <= j; i++, j--) {
            if (mountainPeaks[i] > leftPeak) {
                leftPeak = mountainPeaks[i];
                continue;
            }

            if (mountainPeaks[j] > rightPeak) {
                rightPeak = mountainPeaks[j];
                continue;
            }

            submergedPeaks.add(i);
            if (i != j)
                submergedPeaks.add(j);

        }
        return submergedPeaks;
    }
}