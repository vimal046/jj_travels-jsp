package dao;

import entity.*;
import java.sql.*;

public class BookDao {

    public boolean insertIntoHotelBookingTable(BookHotel obj) {

        boolean result = false;
        Connection con = new Database().getConnection();
        String query = "{call sp_InsertIntoBookHotel(?,?,?,?,?,?)}";

        try {
            CallableStatement cs = con.prepareCall(query);

            cs.setString(1, obj.getCustomerName());
            cs.setString(2, obj.getCustomermobile());
            cs.setString(3, obj.getHotelName());
            cs.setString(4, obj.getCheckInDate());
            cs.setString(5, obj.getCheckOutDate());
            cs.setInt(6, obj.getNoOfRooms());

            int i = cs.executeUpdate();

            if (i > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean insertIntoCabBookingTable(BookCab obj) {

        boolean result = false;
        Connection con = new Database().getConnection();
        String query = "{call sp_InsertIntoBookCab(?,?,?,?)}";

        try {
            CallableStatement cs = con.prepareCall(query);

            cs.setString(1, obj.getLocation());
            cs.setString(2, obj.getName());
            cs.setString(3, obj.getEmailId());
            cs.setString(4, obj.getMobile());

            int i = cs.executeUpdate();

            if (i > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean insertIntoDestEnquiryTable(BookDest obj) {

        boolean result = false;
        Connection con = new Database().getConnection();
        String query = "{call sp_InsertIntoDest(?,?,?,?,?,?)}";

        try {
            CallableStatement cs = con.prepareCall(query);

            cs.setString(1, obj.getName());
            cs.setString(2, obj.getEmail());
            cs.setString(3, obj.getMobile());
            cs.setString(4, obj.getTravelDate());
            cs.setString(5, obj.getTravellerCount());
            cs.setString(6, obj.getMessage());

            int i = cs.executeUpdate();

            if (i > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean insertIntoNewsLetterTable(String email) {

        boolean result = false;
        Connection con = new Database().getConnection();
        String query = "{call sp_InsertIntoNewsLetter(?)}";

        try {
            CallableStatement cs = con.prepareCall(query);

            cs.setString(1, email);

            int i = cs.executeUpdate();

            if (i > 0) {

                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
