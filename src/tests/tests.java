package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sorts.recursive.RecursiveSorts_2_KShiven;
import utils.Utilities;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

public class tests {

    @Test
    void testMerge() {
        Random random = new Random();

        int[] arr = new int[100000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }

        RecursiveSorts_2_KShiven.mergeSort(arr);
        Assertions.assertTrue(Utilities.isSorted(arr));
    }

    @Test
    void testQuick() {
        Random random = new Random();

        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        RecursiveSorts_2_KShiven.quickSort(arr);

        Assertions.assertTrue(Utilities.isSorted(arr));

    }

}