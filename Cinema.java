import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInEachRow = scanner.nextInt();

        char[][] cinema = new char[rows][seatsInEachRow];

        fillingArray(cinema);

        while (true) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            int action = scanner.nextInt();
            if (action == 0) {
                break;
            }
            switch (action) {
                case 1:
                    printSeats(cinema);
                    break;
                case 2:
                    buyTicket(cinema);
                    break;
                case 3:
                    statistics(cinema);
                    break;
                default:
                    System.out.println("Wrong input data");
            }
        }
    }

    public static int money = 0;
    public static int countOfTickets = 0;

    public static void statistics(char[][] array) {
        char initial = '%';
        System.out.println("\nNumber of purchased tickets: " + countOfTickets);
        System.out.printf("Percentage: %.2f%c%n", countOfTickets * 100.0 / ((array.length) * (array[0].length)), initial);
        System.out.println("Current income: $" + money);
        int total = array.length * array[0].length <= 60 ? array.length * array[0].length * 10 : array.length / 2
                * array[0].length * 10 + (array.length / 2 + array.length % 2) * array[0].length * 8;
        System.out.println("Total income: $" + total);
    }

    public static void fillingArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = 'S';
            }
        }
    }

    public static void buyTicket (char[][] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        if (rowNumber <= array.length && rowNumber > 0 & seatNumber <= array[0].length & seatNumber > 0) {
            if (array[rowNumber - 1][seatNumber - 1] == 'S') {
                array[rowNumber - 1][seatNumber - 1] = 'B';
                if (array.length * array[0].length <= 60) {
                    System.out.println("Ticket price: $10");
                    countOfTickets++;
                    money += 10;
                } else {
                    if (rowNumber <= array[0].length / 2) {
                        System.out.println("Ticket price: $10");
                        countOfTickets++;
                        money += 10;
                    } else {
                        System.out.println("Ticket price: $8");
                        countOfTickets++;
                        money += 8;
                    }
                }
            } else {
                System.out.println("That ticket has already been purchased!\n");
                buyTicket(array);
            }
        } else {
            System.out.println("Wrong input!\n");
            buyTicket(array);
        }
    }
    public static void printSeats (char[][] array) {

        int[] numberOfSeat = new int[array[0].length];
        for (int i = 0; i < numberOfSeat.length; i++) {
            numberOfSeat[i] = i + 1;
        }
        System.out.print("\nCinema:\n  ");
        for (int x : numberOfSeat) {
            System.out.print(x + " ");
        }
        System.out.println();

        int count = 1;
        for (char[] x : array) {
            System.out.print(count++ + " ");
            for (char z : x) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}