package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static utils.Utilities.*;
import static sorts.recursive.RecursiveSorts_2_KShiven.*;
import static sorts.iterative.Iterative_Sorts_2_KShiven.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

public class SortsTest {

    Random random;
    int[] arr;

    @Test
    void testMerge() {
        mergeSort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void testQuick() {
        quickSort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void testInsertion() {
        insertionSort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void testSelection() {
        selectionSort(arr);
        assertTrue(isSorted(arr));
    }

    @BeforeEach
    void init() {
        random = new Random();
        arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100000);
        }
    }
}