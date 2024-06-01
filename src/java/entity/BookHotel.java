
package entity;


public class BookHotel {
    
    private int hBookId;
    private String customerName;
    private String Customermobile;
    private String hotelName;
    private String checkInDate;
    private String checkOutDate;
    private int noOfRooms;
    private String hBookingDate;

    public BookHotel(String customerName, String Customermobile, String hotelName, String checkInDate, String checkOutDate, int noOfRooms) {
        this.customerName = customerName;
        this.Customermobile = Customermobile;
        this.hotelName = hotelName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfRooms = noOfRooms;
    }

    public BookHotel(int hBookId, String customerName, String Customermobile, String hotelName, String checkInDate, String checkOutDate, int noOfRooms, String hBookingDate) {
        this.hBookId = hBookId;
        this.customerName = customerName;
        this.Customermobile = Customermobile;
        this.hotelName = hotelName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfRooms = noOfRooms;
        this.hBookingDate = hBookingDate;
    }

    public int gethBookId() {
        return hBookId;
    }

    public void sethBookId(int hBookId) {
        this.hBookId = hBookId;
    }

    public String gethBookingDate() {
        return hBookingDate;
    }

    public void sethBookingDate(String hBookingDate) {
        this.hBookingDate = hBookingDate;
    }
    

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomermobile() {
        return Customermobile;
    }

    public void setCustomermobile(String Customermobile) {
        this.Customermobile = Customermobile;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
    }
    
    
}
