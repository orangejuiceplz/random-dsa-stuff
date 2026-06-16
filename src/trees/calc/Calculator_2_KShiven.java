package trees.calc;

import java.util.ArrayList;
import java.util.Stack;

import static trees.calc.MathSymbol.isOperation;
import static trees.calc.MathSymbol.leastPrecedence;

public class Calculator_2_KShiven implements Calculator1, Calculator2, Calculator3 {

    public ExpNode buildTree(String expression) {
        // start from the right, and parse the expression until an operation,
        // look for the least precedence first, the first one is the root of the entire tree, then recursively do that
        // if you encounter parenthesis, skip

        int parenthesis = 0, idx = -1;

        for (int i = expression.length() - 1; i >= 0; i--) {

            if (expression.charAt(i) == ')') {
                parenthesis++;
            }
            if (expression.charAt(i) == '(') {
                parenthesis--;
            }

            if (parenthesis == 0 && isOperation(String.valueOf(expression.charAt(i)))) {
                idx = (idx == -1) ? i : leastPrecedence(String.valueOf(expression.charAt(idx)), idx, String.valueOf(expression.charAt(i)), i);
            }
        }

        if (idx != -1) {

            return new ExpNode(
                    String.valueOf(expression.charAt(idx)),
                    buildTree(expression.substring(0, idx)),
                    buildTree(expression.substring(idx + 1))
            );
        }
        if (expression.charAt(0) == '(' && expression.charAt(expression.length() -1) == ')') {
            return buildTree(expression.substring(1, expression.length() - 1));
        }
        return new ExpNode(expression);
    }

    public ArrayList<MathSymbol> postfix(ExpNode current) {
        ArrayList<MathSymbol> list = new ArrayList<>();
        if (current == null) return list;
        list.addAll(postfix(current.getLeft()));
        list.addAll(postfix(current.getRight()));
        list.add(current.getValue());
        return list;
    }


    public Double calculate(ArrayList<MathSymbol> postfix) {

        Stack<MathSymbol> stack = new Stack<>();

        for (MathSymbol s: postfix) {

            if (s.isNumber()) {
                stack.push(s);
            }
            // if the above if statement passes without pushing to the stack
            // then we know that `s` must be an operation.
            // however, for sanity checks, you check if
            // s's operation does not equal null
            // if it doesn't, we know that due to the constructor in MathSymbol that it's value is false and isNumber is false
            // so we know it's an operation
            else if (s.getOperation() != null) {
                Double right = stack.pop().getValue();
                Double left = stack.pop().getValue();
                Double computed = s.compute(left, right);
                stack.push(new MathSymbol(computed));
            }

        }
        return stack.pop().getValue();
    }

    public Double calculate(String expression) {
        return calculate(postfix(buildTree(expression)));
    }
}
