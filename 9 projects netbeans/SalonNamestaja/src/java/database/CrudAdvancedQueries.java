
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CrudAdvancedData;

public class CrudAdvancedQueries {
    
    public static void advancedInsert(CrudAdvancedData data) throws SQLException{
        Connection conn = DBConnection.getConn();
        String query = "INSERT INTO advancedcrud (adv_randomdata, adv_fk_username_id) VALUES (?,?);";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, data.getMessage());
        pst.setInt(2, data.getFk_user());
        pst.execute();
    }
    
    // get with fields from another tables
    public static ArrayList<CrudAdvancedData> advancedGet() throws SQLException {
        ArrayList<CrudAdvancedData> advList = new ArrayList<>();
        Connection conn = DBConnection.getConn();
        String query = "SELECT * FROM advancedcrud "
                + "INNER JOIN userlist ON adv_fk_username_id=userlist.id "
                + "INNER JOIN city ON userlist_fk_city_id=city.id;";
        PreparedStatement pst = conn.prepareStatement(query);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            CrudAdvancedData data = new CrudAdvancedData();
            data.setId(rs.getInt("id"));
            data.setMessage(rs.getString("adv_randomdata"));
            data.setFk_user(rs.getInt("adv_fk_username_id"));
            // from other tables
            data.setUser(rs.getString("userlist_username"));
            data.setCity(rs.getString("city_name"));

            advList.add(data);
        }
        return advList;
    }
    
    // get with id, with fields from another table
    public static CrudAdvancedData advancedGetId(int id) throws SQLException {
        CrudAdvancedData data = null;
        Connection conn = DBConnection.getConn();
        String query = "SELECT * FROM advancedcrud "
                + "INNER JOIN userlist ON adv_fk_username_id=userlist.id "
                + "INNER JOIN city ON userlist_fk_city_id=city.id WHERE advancedcrud.id=?;";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            data = new CrudAdvancedData();
            data.setId(rs.getInt("id"));
            data.setMessage(rs.getString("adv_randomdata"));
            data.setFk_user(rs.getInt("adv_fk_username_id"));
            // from other tables
            data.setUser(rs.getString("userlist_username"));
            data.setCity(rs.getString("city_name"));
        }
        return data;
    }
    
    public static void advancedUpdate(CrudAdvancedData data) throws SQLException {
        String query = "UPDATE advancedcrud SET adv_randomdata=?, adv_fk_username_id=? WHERE id=?;";
        Connection conn = DBConnection.getConn();
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, data.getMessage());
        pst.setInt(2, data.getFk_user());
        pst.setInt(3, data.getId());
        pst.execute();
    }
    
    public static void advancedDelete(int id) throws SQLException {
        String query = "DELETE FROM advancedcrud WHERE id=?;";
        Connection conn = DBConnection.getConn();
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        pst.execute();
    }
}
