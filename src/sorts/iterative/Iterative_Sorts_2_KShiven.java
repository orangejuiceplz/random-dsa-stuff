package sorts.iterative;

import static utils.Utilities.swapArr;

public class Iterative_Sorts_2_KShiven {

    public static void insertionSort(int[] arr) {
        for (int sorted = 1; sorted < arr.length - 1; sorted++) {
            int sorting = sorted;
            while (sorting != 0  && arr[sorting] < arr[sorting - 1]) {
                swapArr( arr, sorting - 1, sorting );
                sorting--;
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int sorted = 0; sorted < arr.length - 1; sorted++) {
            int best = sorted;

            for (int current = sorted + 1; current < arr.length; current++) {
                if (arr[current] < arr[best]) {
                    best = current;
                }
            }

            if (best != sorted) {
                swapArr(arr, best, sorted );
            }
        }
    }

    public static void main(String[] args) {
        int[] toBeSorted = {1, 4, 7 ,5, 9, 11};

        insertionSort(toBeSorted);

        for (int i : toBeSorted) {
            System.out.print(i + " ");
        }
    }
}


