package dao;

import entity.Hotel;
import java.sql.*;
import java.util.*;

/**
 *
 * @author VIMAL SUKU
 */
public class HotelDao {

    public boolean insertHotelData(String hName, String hDesc, String hImageLoc) {

        Connection con = new Database().getConnection();
        String query = "{call sp_HotelInsert(?,?,?)}";
        boolean result = false;
        try {
            CallableStatement cs = con.prepareCall(query);
            cs.setString(1, hName);
            cs.setString(2, hDesc);
            cs.setString(3, hImageLoc);
            int i = cs.executeUpdate();
            if (i > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean updateHotelData(int hotelId,String hName,String hDescription){
        
        boolean result=false;
        String query="{call sp_UpdateHotel(?,?,?)}";
        Connection con=new Database().getConnection();
        try{
            CallableStatement cs=con.prepareCall(query);
            cs.setInt(1, hotelId);
            cs.setString(2, hName);
            cs.setString(3, hDescription);
            int i=cs.executeUpdate();
            if(i>0){
                result=true;
            }
            
        }catch(SQLException e){
           
            e.printStackTrace();
        }
        
        return result;
    }
    
    public List<Hotel> getDataFromHotelsTable(){
        List<Hotel> list=new ArrayList<>();
        String query="{call sp_GetHotelData}";
        Connection con=new Database().getConnection();
        try{
            CallableStatement cs=con.prepareCall(query);
            ResultSet rs=cs.executeQuery();
            while(rs.next()){
                list.add(new Hotel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            
//            for(Hotel obj:list){
//                System.out.println(obj);
//            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    
    
     public boolean deleteDataFromHotelsTable(int hotelId){
         
         boolean result=false;
         String query="{call sp_DeleteHotelData(?)}";
        Connection con=new Database().getConnection();
        try{
            CallableStatement cs=con.prepareCall(query);
            cs.setInt(1, hotelId);
            int i=cs.executeUpdate();
            
            if(i>0){
                
                result=true;
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    
    public static void main(String[] args) {
        
  //      new HotelDao().getDataFromHotelsTable();
  
    }
}
