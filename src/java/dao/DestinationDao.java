package dao;

import entity.Cab;
import entity.Dest;
import entity.Hotel;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DestinationDao {

    public boolean insertDestData(String name, String desc, String imageLoc) {

        Connection con = new Database().getConnection();
        String query = "{call sp_InsertDest(?,?,?)}";
        boolean result = false;
        try {
            CallableStatement cs = con.prepareCall(query);
            cs.setString(1, name);
            cs.setString(2, desc);
            cs.setString(3, imageLoc);
            int i = cs.executeUpdate();
            if (i > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean deleteDataFromDestTable(int id) {

        boolean result = false;
        String query = "{call sp_DeleteDest(?)}";
        Connection con = new Database().getConnection();
        try {
            CallableStatement cs = con.prepareCall(query);
            cs.setInt(1, id);
            int i = cs.executeUpdate();

            if (i > 0) {

                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean updateDestData(int id, String name, String description) {

        boolean result = false;
        String query = "{call sp_UpdateDest(?,?,?)}";
        Connection con = new Database().getConnection();
        try {
            CallableStatement cs = con.prepareCall(query);
            cs.setInt(1, id);
            cs.setString(2, name);
            cs.setString(3, description);
            int i = cs.executeUpdate();
            if (i > 0) {
                result = true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return result;
    }

    public List<Dest> getDataFromDestTable() {
        List<Dest> list = new ArrayList<>();
        String query = "{call sp_GetDest}";
        Connection con = new Database().getConnection();
        try {
            CallableStatement cs = con.prepareCall(query);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                list.add(new Dest(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }

//            for(Hotel obj:list){
//                System.out.println(obj);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
