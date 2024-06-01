
package entity;


public class BookCab {
    
    private int bookId;
    private String location;
    private String name;
    private String emailId;
    private String mobile;
    private String bookingTime;

    public BookCab(String location, String name, String emailId, String mobile) {
        this.location = location;
        this.name = name;
        this.emailId = emailId;
        this.mobile = mobile;
    }

    public BookCab(int bookId, String location, String name, String emailId, String mobile, String bookingTime) {
        this.bookId = bookId;
        this.location = location;
        this.name = name;
        this.emailId = emailId;
        this.mobile = mobile;
        this.bookingTime = bookingTime;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(String bookingTime) {
        this.bookingTime = bookingTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    
    
}
