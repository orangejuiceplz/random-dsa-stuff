
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

public class TestAlgs {

    @Test
    void testMerge() {
        Random random = new Random();

        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        RecursiveSorts_2_KShiven.mergeSort(arr);
        assertTrue(RecursiveSorts_2_KShiven.isSorted(arr));
    }

    @Test
    void testQuick() {
        Random random = new Random();

        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        RecursiveSorts_2_KShiven.quickSort(arr);

        assertTrue(RecursiveSorts_2_KShiven.isSorted(arr));

    }

    public static void main(String[] args) {

        System.out.println("hello world");

    }



}