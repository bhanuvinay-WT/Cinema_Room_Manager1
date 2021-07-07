package cinema;

import java.util.Scanner;
public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        int totalSeats = rows * seats;

        if(totalSeats <= 60){
            System.out.println("Total income:$"+totalSeats*10);
        }
        else{
            if(rows%2==1){
                totalSeats = (rows/2*10)*seats + (((rows/2)+1)*8)*seats;
            }
            else{
                totalSeats = (rows/2*10)*seats + (rows/2*8)*seats;
            }
            System.out.println("Total income:$"+totalSeats);
        }/*  System.out.println("Cinema:");
       System.out.print(" ");
       for(int i=1;i<=8;i++){
           System.out.print(" "+i);
        }
        System.out.println();
        for(int i=1;i<8;i++){
            System.out.print(i);
            for(int j=0;j<8;j++){
                System.out.print(" "+"S");
            }
            System.out.println();
        }   */
    }
}