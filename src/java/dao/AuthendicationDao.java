package dao;

import java.sql.*;

public class AuthendicationDao {

    public boolean loginVerification(String name, String password) {

        boolean result = false;
        Connection con = new Database().getConnection();
        String query = "{call sp_LoginAuthendication(?,?,?)}";

        try {
            CallableStatement cs = con.prepareCall(query);
            cs.setString(1, name);
            cs.setString(2, password);
            cs.registerOutParameter(3, Types.BOOLEAN);
            cs.executeUpdate();
            result = cs.getBoolean(3);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
