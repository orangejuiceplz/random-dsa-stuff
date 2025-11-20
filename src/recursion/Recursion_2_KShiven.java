package recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Recursion_2_KShiven {

    // challenge 1
    static void strictlyIncreasingDigitsGen(int n, int k) { // where n is numberOfDigits and k is the current integer
        if (n > 9) {
            return;
        }

        if (n == 0) {
            return;
        }

        if (n==1) {
            System.out.println(k);
            strictlyIncreasingDigitsGen(n, k+1);
        }
        System.out.println(k);
        strictlyIncreasingDigitsGen(n-1, k * 10 + (k % 10 + 1));
        strictlyIncreasingDigitsGen(n, k + 1);
    }

    static int mthSummation(int n, int m) { // m is num Summations

        if (m == 0) {
            return n;
        }

        if (m == 1) {
            return((n * (n + 1)) / 2);
        }

        if (n == 0) {
            return 0;
        }

        return mthSummation(n-1, m) + mthSummation(n, m-1);
    }





    // challenge 3
    static ArrayList<String> genBinString(int k) { // k = length

        if (k == 1) {
           ArrayList<String> str = new ArrayList<>();
           str.add("0");
           str.add("1");
           return str;
        }

        if (k == 0) {
            return new ArrayList<String>();
        }

        ArrayList<String> correctLen = genBinString(k);
        ArrayList<String> previousOne = genBinString(k-1);
        for (String strings : previousOne) {
            correctLen.add(strings + "0");
            if (strings.charAt(strings.length() - 1) != '1') {
                correctLen.add(strings + "1");
            }
        }
        return correctLen;
    }




    // challenge 4
    static void printNBinaryNums(int n) {
        helper("", n);
    }

    static void helper(String curr, int n) {
       if (curr.length() == n) {
            // compareHalves
            int countOnesFirst = 0;
            int countOnesSecond = 0;
            if (n % 2 == 0 ) {

                String firstHalf = curr.substring(0, n/2);
                String secondHalf = curr.substring(n/2);
                for (int i = 0; i < n/2; i++) {
                    if (firstHalf.charAt(i) == '1') {
                        countOnesFirst++;
                    }
                    if (secondHalf.charAt(i) == '1') {
                        countOnesSecond++;
                    }
                }
            } else { // needed to do an odd check
                String firstHalf = curr.substring(0, n/2);
                String secondHalf = curr.substring(n/2 + 1);
                for (int i = 0; i < n/2; i++) {
                    if (firstHalf.charAt(i) == '1') {
                        countOnesFirst++;
                    }
                }
                for (int i = 0; i < n /2; i++) {
                    if (secondHalf.charAt(i) == '1') {
                        countOnesSecond++;
                    }
                }
            }
            if (countOnesFirst == countOnesSecond) {
                System.out.println(curr);
            }
/*

            for (int i = 0; i < firstHalf.length(); i++) {
                if (firstHalf.charAt(i) == 1) {
                    countOnesFirst++;
                }
            }
            for (int i = 0; i < secondHalf.length(); i++) {
                if (secondHalf.charAt(i) == 1) {
                    countOnesSecond++;
                }
            }
            if (countOnesFirst == countOnesSecond) {
                System.out.println(firstHalf + secondHalf);
            }
*/

        } else {
            helper(curr + "0", n);
            helper(curr + "1", n);
        }
    }




    // challenge 5
    static int calcMaxChocInit(int money, int priceOfChoc) {
        if (priceOfChoc > money) {
            return 0;
        }
        int chocolate = 0;
        chocolate++;

        return chocolate + calcMaxChocInit(money - priceOfChoc, priceOfChoc);

        // return money / priceOfChoc;
    }
    static int calcMaxChocWrap(int wrap, int wrappers) {

        if (wrappers < wrap) {
            return 0;
        }

        int chocolates = wrappers / wrap;
        int leftOverChocolates = wrappers % wrap;

        return chocolates + calcMaxChocWrap(wrap, chocolates + leftOverChocolates);
    }

    /* @ParameterizedTest
    @CsvSource({
            "", ""
    })
    void testStrictlyIncreasingDigitsGen(int n, int k) {

    }

    @ParameterizedTest
    @CsvSource({
            "2", "3", "10"
    })
    void testSummation(int n, int m, int expected) { // num 2
        assertEquals(expected, mthSummation(n, m));
    }

    @ParameterizedTest
    @CsvSource({
            "100", "2", "50"
    })
    void testChocInit(int money, int price, int expected) {
        assertEquals(expected, calcMaxChocInit(money, price));
    }
    @ParameterizedTest
    @CsvSource({
            "2", "50", "49"
    })
    void testMaxChoc(int wrap, int wrappers, int expected) {
        assertEquals(expected, calcMaxChocWrap(wrap, wrappers));
    }

     */


    public static void main(String[] args) {
        // challenge 1
       strictlyIncreasingDigitsGen(2, 3);
       //challenge 2
       int mthSummation = mthSummation(3, 2);
       System.out.println(mthSummation);
       //challenge 3
       //genBinString(3);
       // challenge 4
        printNBinaryNums(4);
        // challenge 5
        int mon = 100;
        int price = 2;
        int wrap = 5;
        System.out.println(calcMaxChocInit(mon, price));
        System.out.println(calcMaxChocWrap(2, 100));
    }







}
