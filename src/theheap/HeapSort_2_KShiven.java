package theheap;

import javax.sound.midi.MidiFileFormat;
import java.util.Random;

public class HeapSort_2_KShiven{

    public static <E extends Comparable<E>> void heapSort(E[] arr) {

        int end = arr.length - 1;
        heapify(arr);
        swap(arr, 0, end);
        end--;
        int gwKiddo = (end - 2 + end % 2 ) / 2;
        for (int i = end; i > 0; i--) {
            reheapifyMax(0, gwKiddo, i, arr);
            swap(arr, 0, end);
            end--;
            gwKiddo = (end - 2 + end % 2 ) / 2;
        }
    }

    public static <E extends Comparable<E>> void heapify(E[] arr) {
        int end = arr.length - 1;
        int gwKiddo = (end -2 + end % 2) / 2;
        for (int i = gwKiddo; i >= 0; i--) {
            reheapifyMax(i, gwKiddo, arr.length - 1, arr);
        }
    }

    public static <E extends Comparable<E>> void reheapifyMax(int n, int gwKiddo, int endIndex, E[] arr) {
        // 2n + 1;
        // 2n + 2;
        int LC = 2 * n + 1;
        int max = 0;
        if (arr[LC].compareTo(arr[n]) > 0) {
            max = LC;
        } else {
            max = n;
        }

        if ((2 * n + 2) <= endIndex) {
            int RC = 2 * n + 2;
            if (arr[RC].compareTo(arr[max]) > 0) {
                max = RC;
            }
        }

        if (max != n) {
            swap(arr, max, n);
            if (max <= gwKiddo) {
                reheapifyMax(max, gwKiddo, endIndex, arr);
            }
        }
    }

    public static <E extends Comparable<E>> void swap(E[] arr, int index1, int index2) {
        E temp = arr[index1]; arr[index1] = arr[index2]; arr[index2] = temp;
    }

    public static void main(String[] args) {

        Random random = new Random();

        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(0, 100);
        }

        heapify(arr);
        for (Integer integer: arr) {
            System.out.println(integer);
        }

//        heapSort(arr);
//        for (Integer integer: arr) {
//            System.out.println(integer);
//        }
    }


}
