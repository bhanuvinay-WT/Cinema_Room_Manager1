package cinema;

import java.util.Scanner;
public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        char[][] theatre = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                theatre[i][j] = 'S';
            }
        }
        int seat = -1;
        int row = -1;
        while (true) {
            System.out.println("1. Show the seats\n2. Buy a ticket\n0. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                theatre = BookingSeat(theatre, row, seat);
                TheaterSeating(theatre, row, seat);
            } else if (choice == 2) {
                System.out.println("Enter a row number:");
                row = scanner.nextInt();
                System.out.println("Enter a seat number in that row:");
                seat = scanner.nextInt();
                int totalSeats = rows * seats;
                TicketPrice(row, seats, totalSeats, rows);
            } else {
                break;
            }
        }
        scanner.close();

    }

    public static void TheaterSeating(char[][] theatre, int row, int seat) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= theatre[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println("");
        int p = 1;
        for (int i = 0; i <= theatre.length - 1; i++) {
            for (int j = -1; j <= theatre[0].length - 1; j++) {
                if (j == -1) {
                    System.out.print(p);
                    p++;
                } else {
                    System.out.print(" " + theatre[i][j]);
                }
            }
            System.out.println("");
        }
    }

    public static char[][] BookingSeat(char[][] theatre, int row, int seat) {
        if (row == -1 && seat == -1) {
            return theatre;
        } else {
            theatre[row-1][seat-1] = 'B';
            return theatre;
        }
    }

    public static void TicketPrice(int row, int seat, int totalSeats, int rows) {
        if (totalSeats <= 60) {
            // System.out.println("Total income:$"+totalSeats*10);
            System.out.println("Ticket price: $10");
        } else {
            if (row > (rows / 2)) {
                System.out.println("Ticket price: $8");
            } else
                System.out.println("Ticket price: $10");

        }
    }
}