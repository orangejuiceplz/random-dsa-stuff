package recursion;

public class recursivePractice {

    // practice one
    static boolean checkIfPalindrome(int n) {
        int reversed = 0;

        int temp = Math.abs(n);
        while (temp != 0) {
            reversed = (reversed * 10) + temp % 10;

            temp = temp / 10;
        }

        return reversed == Math.abs(n);
    }

    static String reverseAString(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        if (str.length() == 1) {
            return str;
        }

        return reverseAString(str.substring(1)) + str.charAt(0);
    }

    static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }

        if (exponent < 0) {
            throw new IllegalArgumentException("exponent must be a positive integer");
        }

        return base * power(base, exponent - 1);
    }

    // static boolean binSearch(int[] sortedArray, int target, int hi, int lo) {
    //    if (hi <= lo) {
    //        return false;
    //    }
    //
    //    int midIndex = (hi + lo) / 2;
    //
    //    if (sortedArray[midIndex] == target) {
    //        return true;
    //    } else if (sortedArray[midIndex] > target) {
    //        return binSearch(sortedArray, target, hi, midIndex - 1);
    //    } else {
    //        return binSearch(sortedArray, target, hi, midIndex + 1);
    //    }
    // }

    static void printPermuatation(String str, String remaining) {

    }


    public static void main(String[] args) {
        System.out.println(checkIfPalindrome(133));
        System.out.println(reverseAString("abcd"));
        System.out.println(power(2, 3));
    //    System.out.println(power(2, -3));
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //System.out.println(binSearch(sortedArr, 2, 10, 1));





    }



}
