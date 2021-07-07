package cinema;

import java.util.Scanner;
public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        TheaterSeating(rows, seats, -1, -1);
        System.out.println();
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();

        int totalSeats = rows * seats;

        if (totalSeats <= 60) {
            // System.out.println("Total income:$"+totalSeats*10);
            System.out.println("Ticket price: $10");
        } else {
            if (row > (rows / 2)) {
                System.out.println("Ticket price: $8");
            } else
                System.out.println("Ticket price: $10");

        }
        TheaterSeating(rows, seats, row, seat);
        scanner.close();
    }

    public static void TheaterSeating(int rows, int seats, int row, int seat) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i);
            for (int j = 0; j < seats; j++) {
                if (i == row && j == seat - 1) {
                    System.out.print(" " + "B");
                } else
                    System.out.print(" " + "S");
            }
            System.out.println();
        }
    }
}