package dao;

import java.util.*;
import java.sql.*;
import entity.*;

public class FetchAdminDao {
    
    public List<BookHotel> getBookHotelData() {
        
        List<BookHotel> list = new ArrayList<>();
        String query = "{call sp_GetBookHotelData}";
        Connection con = new Database().getConnection();
        
        try {
            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                
                int bookingId = rs.getInt(1);
                String customerName = rs.getString(2);
                String Customermobile = rs.getString(3);
                String hotelName = rs.getString(4);
                String checkInDate = rs.getString(5);
                String checkOutDate = rs.getString(6);
                int noOfRooms = rs.getInt(7);
                String hBookingDate = rs.getString(8);
                
                list.add(new BookHotel(bookingId, customerName, Customermobile, hotelName, checkInDate, checkOutDate, noOfRooms, hBookingDate));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<BookCab> getBookCabData() {
        
        List<BookCab> list = new ArrayList<>();
        String query = "{call sp_GetBookCabData}";
        Connection con = new Database().getConnection();
        
        try {
            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                
                int bookId = rs.getInt(1);
                String location = rs.getString(2);
                String name = rs.getString(3);
                String emailId = rs.getString(4);
                String mobile = rs.getString(5);
                String bookingTime = rs.getString(6);
                
                list.add(new BookCab(bookId, location, name, emailId, mobile, bookingTime));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<BookDest> getDestData() {
        
        List<BookDest> list = new ArrayList<>();
        String query = "{call sp_GetEnquireDestinationData}";
        Connection con = new Database().getConnection();
        
        try {
            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                
                int bookId = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String mobile = rs.getString(4);
                String travelDate = rs.getString(5);
                String travellerCount = rs.getString(6);
                String message = rs.getString(7);
                String bookDate = rs.getString(8);
                
                list.add(new BookDest(bookId, name, email, mobile, travelDate, travellerCount, message, bookDate));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<NewsLetter> getNewsLetterData() {
        
        List<NewsLetter> list = new ArrayList<>();
        String query = "{call sp_GetNewsLetterData}";
        Connection con = new Database().getConnection();
        
        try {
            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String email = rs.getString(2);
                
                list.add(new NewsLetter(id, email));
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
}
