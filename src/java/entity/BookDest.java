
package entity;


public class BookDest {
    
    private int bookId;
    private String name;
    private String email;
    private String mobile;
    private String travelDate;
    private String travellerCount;
    private String message;
    private String bookDate;

    public BookDest(String name, String email, String mobile, String travelDate, String travellerCount, String message) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.travelDate = travelDate;
        this.travellerCount = travellerCount;
        this.message = message;
    }

    public BookDest(int bookId, String name, String email, String mobile, String travelDate, String travellerCount, String message, String bookDate) {
        this.bookId = bookId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.travelDate = travelDate;
        this.travellerCount = travellerCount;
        this.message = message;
        this.bookDate = bookDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookDate() {
        return bookDate;
    }

    public void setBookDate(String bookDate) {
        this.bookDate = bookDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public String getTravellerCount() {
        return travellerCount;
    }

    public void setTravellerCount(String travellerCount) {
        this.travellerCount = travellerCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
