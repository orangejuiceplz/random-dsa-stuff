package tests.stacksandqueues;

import java.util.Scanner;
import java.util.Stack;

public class Stack_2_KShiven {

    Stack<String> stack = new Stack<>();
    String document;




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack_2_KShiven b = new Stack_2_KShiven();

        b.WRITE("A");
        b.WRITE("B");
        b.WRITE("C");

        b.READ();

        b.UNDO();


    }

    public void WRITE(String character) {
        document += character;
    }

    public void READ() {
        System.out.println(document);
    }

    public void UNDO() {
        stack.push(document.substring(document.length() - 1));
        document = document.substring(0, document.length() - 1);
    }

    public void REDO() {
        document += stack.pop();
    }



}
