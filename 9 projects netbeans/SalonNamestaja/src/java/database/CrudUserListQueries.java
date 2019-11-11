
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

public class CrudUserListQueries {
    
    // get with fields from another tables
    public static ArrayList<User> userGet() throws SQLException {
        ArrayList<User> userList = new ArrayList<>();
        Connection conn = DBConnection.getConn();
        String query = "SELECT * FROM userlist "
                + "INNER JOIN city ON userlist_fk_city_id=city.id;";
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            User data = new User();
            data.setId(rs.getInt("id"));
            data.setUsername(rs.getString("userlist_username"));
            data.setPassword(rs.getString("userlist_password"));
            data.setSex(rs.getString("userlist_sex").charAt(0));
            data.setGrad_id(rs.getInt("userlist_fk_city_id"));
            data.setGrad(rs.getString("city_name"));

            userList.add(data);
        }
        return userList;
    }
}
