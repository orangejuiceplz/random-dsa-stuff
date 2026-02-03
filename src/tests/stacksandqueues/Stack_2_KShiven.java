package tests.stacksandqueues;

import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Stack_2_KShiven {

    Stack<String> stack = new Stack<>();
    String document = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack_2_KShiven stack = new Stack_2_KShiven();
        String option = "";
        System.out.println("Begin entering your commands below: ");
        System.out.println("-----------------------------------");
        String charToWrite = "";

        do {
            option = scanner.nextLine();
            if (option.contains("WRITE "))  {
                charToWrite = option.substring(option.length() - 1);
                option = option.substring(0, 5);
            } else if (option.contains(" ")) {
                option = option.substring(0, 5);
            }

            switch (option) {

                case "WRITE" -> {


                    stack.WRITE(charToWrite);
                    System.out.println("Done!");
                    System.out.println("---------");

                }


                case "UNDO" -> {
                    stack.UNDO();
                    System.out.println("Done!");
                    System.out.println("---------");
                }

                case "REDO" -> {
                    stack.REDO();
                    System.out.println("Done!");
                    System.out.println("----------");
                }
                case "READ" -> {
                    stack.READ();
                    System.out.println("----------");
                }
                case "HELP" -> {
                    System.out.println("Please enter one of the available commands: ");
                    System.out.println("----------");
                    System.out.println("WRITE X: Writes character X to the document ");
                    System.out.println("----------");
                    System.out.println("REDO: Redo a change made to the document by the UNDO command");
                    System.out.println("----------");
                    System.out.println("READ: Print the document to the stdout");
                    System.out.println("----------");
                    System.out.println("UNDO: Undo a written change to the document one charcater at a time");
                    System.out.println("----------");
                    System.out.println();
                }
                default -> {
                    System.out.println("Invalid option: " + option);
                    System.out.println("Please type a proper option");
                    System.out.println("Hint: Maybe use all caps for operations?");
                    System.out.println("----------");
                }
            }

        } while (!option.contains("EXIT"));







    }

    public void WRITE(String character) {
        document += character;
        // stack.clear();
        //
    }

    public void READ() {
        System.out.println(document);
    }

    public void UNDO() {
        if (!document.isEmpty()) {
            stack.push(document.substring(document.length() - 1));
            document = document.substring(0, document.length() - 1);
        } else {
            System.out.println("There is nothing to do as the document is empty");
        }
    }

    public void REDO() {
        if (!stack.isEmpty()) {
            document += stack.pop();
            System.out.println("Done");
        } else {
            System.out.println("Nothing to do");
        }
    }



}
