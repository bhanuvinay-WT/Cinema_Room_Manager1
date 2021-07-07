package cinema;
import java.text.DecimalFormat;
import java.util.Scanner;
public class Cinema {

    public static int ticketsSold = 0;
    public static int currentIncome = 0;
    public static int totalSeats = 0;
    public static char[][] theatre;
    static Scanner scanner = new Scanner(System.in);
    public static int seat = -1;
    public static int row = -1;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        totalSeats = rows * seats;
        theatre = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                theatre[i][j] = 'S';
            }
        }


        while (true) {
            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {

                TheaterSeating(theatre, row, seat);
            } else if (choice == 2) {
                bookingSeat(rows, seats);
            } else if (choice == 3) {
                System.out.println("Number of purchased tickets:" + ticketsSold);
                if (ticketsSold == 0 || totalSeats == 0) {
                    System.out.println("Percentage: 0.00%");
                } else {
                    // System.out.println(ticketsSold + " " + totalSeats);
                    double percentage = ((double) (ticketsSold * 100) / totalSeats);
                    DecimalFormat df = new DecimalFormat("0.00");
                    System.out.println("Percentage: " + df.format(percentage) + "%");
                }
                System.out.println("Current income: $" + currentIncome);
                System.out.println("Total income:$" + TotalPrice(rows, seats));
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

    public static void TicketPrice(int row, int seat, int totalSeats, int rows) {
        if (totalSeats <= 60) {
            // System.out.println("Total income:$"+totalSeats*10);
            System.out.println("Ticket price: $10");
            currentIncome = currentIncome + 10;
        } else {
            if (row > (rows / 2)) {
                System.out.println("Ticket price: $8");
                currentIncome = currentIncome + 8;
            } else {
                System.out.println("Ticket price: $10");
                currentIncome = currentIncome + 10;
            }
        }
    }

    public static int TotalPrice(int rows, int seats) {
        if (totalSeats <= 60) {
            return totalSeats * 10;
        } else {
            if (rows % 2 == 1) {
                totalSeats = (rows / 2 * 10) * seats + (((rows / 2) + 1) * 8) * seats;
            } else {
                totalSeats = (rows / 2 * 10) * seats + (rows / 2 * 8) * seats;
            }
            return totalSeats;
        }
    }

    public static void bookingSeat(int rows, int seats) {
        System.out.println("Enter a row number:");
        row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        seat = scanner.nextInt();
        totalSeats = rows * seats;
        if (row != -1 && seat != -1) {
            // System.out.println(row+" "+seat);
            if (row > rows || seat > seats) {
                System.out.println("Wrong input!");
                bookingSeat(rows, seats);
            } else if (theatre[row - 1][seat - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
                bookingSeat(rows, seats);
            }else {
                theatre[row - 1][seat - 1] = 'B';
                ticketsSold++;
                TicketPrice(row, seat, totalSeats, rows);
            }
        }

    }
}