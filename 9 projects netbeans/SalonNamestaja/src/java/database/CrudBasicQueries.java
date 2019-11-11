package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.CrudBasicData;

public class CrudBasicQueries {

    public static void basicInsert(CrudBasicData data) throws SQLException{
        Connection baza = DBConnection.getConn();
        String upit = "INSERT INTO basiccrud (basic_randomdata) VALUES (?);";
        PreparedStatement pst = baza.prepareStatement(upit);
        pst.setString(1, data.getMessage());
        pst.execute();
    }
    
    public static ArrayList<CrudBasicData> basicGet() throws SQLException {
        ArrayList<CrudBasicData> dataList = new ArrayList<>();
        Connection baza = DBConnection.getConn();
        String upit = "select * from basiccrud;";
        PreparedStatement pst = baza.prepareStatement(upit);
        ResultSet rsBasicResults = pst.executeQuery();
        while(rsBasicResults.next()){
            CrudBasicData data = new CrudBasicData();  
            data.setId(rsBasicResults.getInt("id"));  
            data.setMessage(rsBasicResults.getString("basic_randomdata"));   
            dataList.add(data);
        }
        return dataList;
    }
    
    /*
    public static List<CRUDbasicData> basicGet(String parameter) throws SQLException {
        List<CRUDbasicData> dataList = new ArrayList<>();
        Connection baza = DBConnection.getConn();
        String upit = "select * from basiccrud where basic_randomdata = ?;";
        PreparedStatement pst = baza.prepareStatement(upit);
        pst.setString(1, parameter);
        ResultSet rsBasicResults = pst.executeQuery();
        while(rsBasicResults.next()){
            CrudBasicData data = new CrudBasicData();  
            data.setId(rsBasicResults.getInt("id"));  
            data.setMessage(rsBasicResults.getString("basic_randomdata"));   
            dataList.add(data);
        }
        return dataList;
    }
    
    public static List<CRUDbasicData> basicGet(String parameter) throws SQLException {
        List<CRUDbasicData> dataList = new ArrayList<>();
        Connection baza = DBConnection.getConn();
        String upit = "select * from basiccrud where basic_randomdata = ? or basic_randomdata is null;";
        PreparedStatement pst = baza.prepareStatement(upit);
        pst.setString(1, parameter);
        ResultSet rsBasicResults = pst.executeQuery();
        while(rsBasicResults.next()){
            CrudBasicData data = new CrudBasicData();  
            data.setId(rsBasicResults.getInt("id"));  
            data.setMessage(rsBasicResults.getString("basic_randomdata"));   
            dataList.add(data);
        }
        return dataList;
    }
    */

    public static CrudBasicData basicGet(int id) throws SQLException {
        CrudBasicData data = null;
        Connection baza = DBConnection.getConn();
        String upit = "select * from basiccrud where id = ?;";
        PreparedStatement pst = baza.prepareStatement(upit);
        pst.setInt(1, id);
        ResultSet rsBasicResults = pst.executeQuery();
        while(rsBasicResults.next()){
            data = new CrudBasicData();  
            data.setId(rsBasicResults.getInt("id"));  
            data.setMessage(rsBasicResults.getString("basic_randomdata"));  
        }
        return data;
    }
    
    public static void basicUpdate(CrudBasicData data) throws SQLException {
        String upit = "update basiccrud set basic_randomdata=? where id=?;";
        Connection baza = DBConnection.getConn();
        PreparedStatement pst = baza.prepareStatement(upit);
        pst.setString(1, data.getMessage());
        pst.setInt(2, data.getId());
        pst.execute();
    }
    
    public static void basicDelete(int id) throws SQLException {
        String upit = "delete from basiccrud where id=?;";
        Connection baza = DBConnection.getConn();
        PreparedStatement pst = baza.prepareStatement(upit);
        pst.setInt(1, id);
        pst.execute();
    }
}
