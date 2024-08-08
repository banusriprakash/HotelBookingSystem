public class Hotel {

    private String room;
    private String roomNum;
    private String roomType;
    private boolean isAvailable;
    private double price;

    public Hotel(String room, String roomNum, String roomType, double price) {
        this.room = room;
        this.roomNum = roomNum;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;
    }

    public String getRoom() {
        return room;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getRoomType() {
        return roomType;
    }

    public double calculatePrice(int rentalDays) {
        return price * rentalDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void checkout() {
        isAvailable = true;
    }

    public void book() {
        isAvailable = false;
    }
}
