import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Sample data
        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel("Deluxe Room", "101", "Deluxe", 2000));
        hotels.add(new Hotel("Suite Room", "102", "Suite", 3000));
        hotels.add(new Hotel("Standard Room", "103", "Standard", 1500));

       ArrayList<Customer> customers = new ArrayList<>();
       ArrayList<Rental> rentals = new ArrayList<>();

        BookingSystem bookingSystem = new BookingSystem(hotels, customers, rentals);
        bookingSystem.menu();
    }

}
