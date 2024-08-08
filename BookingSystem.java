import java.util.List;
import java.util.Scanner;

public class BookingSystem {

    List<Hotel> hotels;
    List<Customer> customers;
    List<Rental> rentals;

    BookingSystem(List<Hotel> hotels, List<Customer> customers, List<Rental> rentals) {
        this.rentals = rentals;
        this.customers = customers;
        this.hotels = hotels;
    }

    public void addRentals(Rental rental) {
        rentals.add(rental);
    }

    public void addCustomers(Customer customer) {
        customers.add(customer);
    }

    public void addHotels(Hotel hotel) {
        hotels.add(hotel);
    }

    public void rentRoom(Hotel room, Customer customer, int days) {
        if (room.isAvailable()) {
            room.book();
            rentals.add(new Rental(room, customer, days));
        } else {
            System.out.println("Room is currently not available, Sir.");
        }
    }

    public void checkout(Hotel room) {
        room.checkout();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getHotelRoom().equals(room)) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            System.out.println("Customer is checked out successfully!");
        } else {
            System.out.println("Customer is not checked out.");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println();
            System.out.println("--------Booking---------");
            System.out.println("1. Book a Room");
            System.out.println("2. Checkout");
            System.out.println("3. Exit");
            System.out.print("Enter Your Choice Now Sir:");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("\n====== Book a Room ======\n");
                System.out.println("Enter your name, Sir:");
                String customerName = sc.nextLine();

                System.out.println("\nAvailable rooms:");
                for (Hotel room : hotels) {
                    if (room.isAvailable()) {
                        System.out.println(room.getRoomNum() + " " + room.getRoom() + " " + room.getRoomType());
                    }
                }

                System.out.println("Enter the room number you want to book:");
                String roomNum = sc.nextLine();

                System.out.println("Enter the number of days needed:");
                int rentDays = sc.nextInt();
                sc.nextLine();

                Customer newCustomer = new Customer("Customer" + (customers.size() + 1), customerName);
                addCustomers(newCustomer);

                Hotel selectedRoom = null;
                for (Hotel room : hotels) {
                    if (room.getRoomNum().equalsIgnoreCase(roomNum) && room.isAvailable()) {
                        selectedRoom = room;
                        break;
                    }
                }

                if (selectedRoom != null) {
                    double totalPrice = selectedRoom.calculatePrice(rentDays);
                    System.out.println("\n====== Booking Information ======\n");
                    System.out.println("Customer Id: " + newCustomer.getName());
                    System.out.println("Customer Name: " + newCustomer.getNumber());
                    System.out.println("Room: " + selectedRoom.getRoom() + " " + selectedRoom.getRoomType());
                    System.out.println("Rental Days: " + rentDays);
                    System.out.printf("Total Price: Rs %.2f%n", totalPrice);

                    System.out.println("Confirm booking (Y/N)?");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentRoom(selectedRoom, newCustomer, rentDays);
                        System.out.println("\nRoom booked successfully, Sir.");
                        System.out.println();
                    } else {
                        System.out.println("\nRoom booking is cancelled.\n");
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid room number or room is not available, Sir.");
                    System.out.println();
                }

            } else if (choice == 2) {
                System.out.println("\n======== Checkout the Room ========\n");
                System.out.println("Enter the room number you want to checkout:");
                String roomNum = sc.nextLine();

                Hotel returnRoom = null;
                for (Hotel room : hotels) {
                    if (room.getRoomNum().equalsIgnoreCase(roomNum) && !room.isAvailable()) {
                        returnRoom = room;
                        break;
                    }
                }

                if (returnRoom != null) {
                    checkout(returnRoom);
                } else {
                    System.out.println("Invalid room number or room is already available, Sir.");
                    System.out.println();
                }

            } else if (choice == 3) {
                System.out.println();
                System.out.println("Exiting the system. Goodbye!");

                break;
            } else {
                System.out.println();
                System.out.println("Invalid choice. Please try again.");

            }
        }
        sc.close();
    }


}
