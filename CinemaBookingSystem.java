import java.util.Scanner;

public class CinemaBookingSystem {
    private static final int TOTAL_SEATS = 10; // Total number of seats
    private static boolean[] seats = new boolean[TOTAL_SEATS]; // false means available, true means booked

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu:");
            System.out.println("1. Check seat availability");
            System.out.println("2. Book a seat");
            System.out.println("3. Cancel booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkAvailability();
                    break;
                case 2:
                    bookSeat(scanner);
                    break;
                case 3:
                    cancelBooking(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void checkAvailability() {
        System.out.println("Seat availability:");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            if (!seats[i]) {
                System.out.println("Seat " + (i + 1) + ": Available");
            } else {
                System.out.println("Seat " + (i + 1) + ": Booked");
            }
        }
    }

    private static void bookSeat(Scanner scanner) {
        System.out.print("Enter seat number to book (1-" + TOTAL_SEATS + "): ");
        int seatNumber = scanner.nextInt() - 1; // Adjust for 0-based index

        if (seatNumber < 0 || seatNumber >= TOTAL_SEATS) {
            System.out.println("Invalid seat number.");
        } else if (seats[seatNumber]) {
            System.out.println("Seat " + (seatNumber + 1) + " is already booked.");
        } else {
            seats[seatNumber] = true;
            System.out.println("Seat " + (seatNumber + 1) + " has been successfully booked.");
        }
    }

    private static void cancelBooking(Scanner scanner) {
        System.out.print("Enter seat number to cancel booking (1-" + TOTAL_SEATS + "): ");
        int seatNumber = scanner.nextInt() - 1; // Adjust for 0-based index

        if (seatNumber < 0 || seatNumber >= TOTAL_SEATS) {
            System.out.println("Invalid seat number.");
        } else if (!seats[seatNumber]) {
            System.out.println("Seat " + (seatNumber + 1) + " is not booked.");
        } else {
            seats[seatNumber] = false;
            System.out.println("Booking for seat " + (seatNumber + 1) + " has been canceled.");
        }
    }
}

