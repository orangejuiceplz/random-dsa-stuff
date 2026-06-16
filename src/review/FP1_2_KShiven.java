package review;

import java.util.*;

public class FP1_2_KShiven {

    public static boolean wrapped(String str) {
        // () {} [] <>
        Stack<String> stack = new Stack<>();
        String open ="({[<";
        String close=")}]>";
//        HashSet<String> del = new HashSet<>(List.of(arr));
        for (int i = 0; i < str.length(); i++) {

            if (open.contains(str.substring(i, i+1))) {
                stack.add(str.substring(i, i+1));
            } else if (close.contains(str.substring(i, i+1)) && (stack.isEmpty() || (str.indexOf(stack.pop()) > str.indexOf(str.substring(i, i+1)))))
                return false;
        }

        return stack.isEmpty();

        }
        // Map of delimeters -> their count
        // if one of the count is odd return false
        // if all of their counts are 0 or even return ture
//        HashMap<String, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < str.length(); i++) {
//            String key = str.
//        }
//        // -------------
//        for (int i = 0; i < str.length(); i++) {
//            String current = str.substring(i, i+1);
//            if (!stack.contains(current)) {
//                stack.add(current);
//            }
//        }
//        for (int i = 0; i < stack.size(); i++) {
//            if (!del.contains(stack.peek())) {
//                continue;
//            } else {
//                stack.pop();
//            }
//        }

    }

