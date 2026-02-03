package tests.stacksandqueues;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Queue_2_KShiven {

    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();

        Scanner scanner = new Scanner(System.in);

        int people = 0;

        while (true) {
            System.out.print("How many people are on line: ");
            try {
                people = scanner.nextInt();

                if (people > 0) {
                    break;
                } else {
                    System.out.println("People must be greater than 0");
                    scanner.nextLine();
                    System.out.println();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                System.out.println();
                scanner.nextLine();
            }
        }
        scanner.nextLine();


        String person;

        for (int i = 0; i < people; i++) {
            while(true) {
                System.out.print("Please enter the next person who got onto the line(no spaces): ");

                    person = scanner.nextLine();

                    if (person.contains(" ") || person.isEmpty()) {
                        System.out.println("Person name cannot contain spaces");
                        System.out.println();
                    } else {
                        break;
                    }
                scanner.nextLine();



            }

            queue.enqueue(person);
        }

        int cars = 0;

        while (true) {
            System.out.print("How many cars on each coaster: ");
            try {
                cars = scanner.nextInt();

                if (cars <= 0) {
                    System.out.println("Cars must be greater than 0");
                    System.out.println();
                } else {
                    break;
                }

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Invalid input");
                System.out.println();
            }
        }

        int seats;

        while (true) {
            System.out.print("How many seats in each car: ");

            try {
                seats = scanner.nextInt();

                if (seats <= 0) {
                    System.out.println("Seats must be greater than 0");
                    System.out.println();
                } else {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                scanner.nextLine();
                System.out.println();
            }

        }



        int runs;


        while (true) {

            System.out.print("How many times should each coaster run: ");

            try {
                runs = scanner.nextInt();

                if (runs < 0) {
                    System.out.println("Runs cannot be negative");
                    System.out.println();
                } else {
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input");
                System.out.println();
                scanner.nextLine();
            }
        }


        for (int i = 0; i < runs; i++) {

            System.out.println("Run # " + (i + 1));
            System.out.println("-------------");

            int capacity = seats * cars;

            for (int j = 0; j < capacity; j++) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.dequeue());
                }
            }

            System.out.println("-------------");
        }

        System.out.println("----------------");
        System.out.println("Line");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        System.out.println("-------------");
    }



}
