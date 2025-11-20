package searching;

public class Search_2_KShiven {
    static int linSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 9, 11, 13, 16, 21};
        System.out.println("Index of 5 is: " + binarySearch(arr, 5)); // should print 1
        System.out.println("Index of 9 is : " + linSearch(arr, 9)); // should print 2
    }
}
