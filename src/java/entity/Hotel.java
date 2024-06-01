package entity;

/**
 *
 * @author VIMAL SUKU
 */
public class Hotel {

    private int hotelId;
    private String hotelName;
    private String hotelDescription;
    private String hotelImageLoc;

    public Hotel(int hotelId, String hotelName, String hotelDescription, String hotelImageLoc) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.hotelDescription = hotelDescription;
        this.hotelImageLoc = hotelImageLoc;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public String getHotelImageLoc() {
        return hotelImageLoc;
    }

    public void setHotelImageLoc(String hotelImageLoc) {
        this.hotelImageLoc = hotelImageLoc;
    }

    @Override
    public String toString() {
        return "Hotel{"
                + "hotelId=" + hotelId
                + ", hotelName='" + hotelName + '\''
                + ", hotelDescription='" + hotelDescription + '\''
                + ", hotelImageLoc='" + hotelImageLoc + '\''
                + '}';
    }

}
