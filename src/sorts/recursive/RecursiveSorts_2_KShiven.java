package sorts.recursive;

import static utils.Utilities.*;

public class RecursiveSorts_2_KShiven implements RecursiveSorts {

    public static void mergeSort(int[] arr) {
        RecursiveSorts_2_KShiven obj = new RecursiveSorts_2_KShiven();
        obj.mergeSort(arr, 0, arr.length - 1);

    }

    public void mergeSort(int[] arr, int low, int high) {

        if (low >= high) return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int Llen = mid - low + 1;
        int Rlen = high - mid;

        int[] left = new int[Llen];
        int[] right = new int[Rlen];

         for (int i = 0; i < Llen; i++) {
             left[i] = arr[low + i];
         }

         for (int j = 0; j < Rlen; j++) {
             right[j] = arr[mid + 1 + j];
         }

        int i = 0, j = 0, k = low;

        while (i < Llen && j < Rlen) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }


        while (i < Llen) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < Rlen) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void quickSort(int[] arr) {
        RecursiveSorts_2_KShiven obj = new RecursiveSorts_2_KShiven();
        obj.quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int low, int high) {

        if (low >= high) return;

        int pivotIndex = LPartition(arr, low, high);

        quickSort(arr, low, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, high);

    }

    private static int LPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapArr(arr, i, j);
            }
        }
        swapArr(arr, i + 1, high);
        return i + 1;


    }

}
