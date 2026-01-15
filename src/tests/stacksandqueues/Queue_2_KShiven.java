package tests.stacksandqueues;

import java.util.Scanner;

public class Queue_2_KShiven {

    public static void main(String[] args) {

        Queue<String> queue = new Queue<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("How many people are on line: ");
        int people = scanner.nextInt();
        String person;
        for (int i = 0; i < people; i++) {
            System.out.println("Please enter the next person who got onto the line(no spaces): ");
            person = scanner.nextLine();
            queue.enqueue(person);
        }

        System.out.println("How many cars on each coaster: ");
        int cars = scanner.nextInt();

        System.out.println("How many seats in each car: ");
        int seats = scanner.nextInt();

        System.out.println("How many times should each coaster run: ");
        int runs = scanner.nextInt();

        for (int i = 0; i < runs; i++) {

            System.out.println("Run " + i + 1);

            for (int j = 0; j < seats * cars; j++) {
                System.out.println(queue.dequeue());
            }

        }

    }



}
