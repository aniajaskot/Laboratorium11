package exercise2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class NumbersQueue {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę elementów");

        int count = scanner.nextInt();
        scanner.nextLine();

        Queue<Integer> numbers = new PriorityQueue<>();

        for (int i = 0; i < count; i++) {
            System.out.println("Podaj liczbę #" + (i + 1));
            numbers.add(scanner.nextInt());
            scanner.nextLine();
        }

        while (!numbers.isEmpty()) {
            Integer number = numbers.poll();
            System.out.println(number * number);
        }

    }

}
