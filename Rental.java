public class Rental {

    private Hotel hotelRoom;
    private Customer customer;
    private int days;

    public Rental(Hotel hotelRoom, Customer customer, int days) {
        this.hotelRoom = hotelRoom;
        this.customer = customer;
        this.days = days;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Hotel getHotelRoom() {
        return hotelRoom;
    }

    public int getDays() {
        return days;
    }
}
