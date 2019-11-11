package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.City;
import model.User;

public class DBAccount {

    public static int logon = 0;
    
    public static ArrayList<City> getAllCities() throws SQLException {
        ArrayList<City> gradovi = new ArrayList<>();
        Connection baza = DBConnection.getConn();
        Statement st = baza.createStatement();
        String upit = "select * from basicdb.city;";
        ResultSet rs = st.executeQuery(upit);
        while (rs.next()) {
            City c = new City();
            c.setId(rs.getInt(1));
            c.setNaziv(rs.getString(2));
            gradovi.add(c);
        }
        return gradovi;
    }

    public static void register(User u) throws SQLException {
        String upit = "insert into userlist ("
                + "userlist_username, userlist_password, userlist_sex, "
                + "userlist_fk_city_id) values (?,?,?,?);";
        Connection baza = DBConnection.getConn();
        PreparedStatement pst = baza.prepareStatement(upit);
        pst.setString(1, u.getUsername());
        pst.setString(2, u.getPassword());
        pst.setString(3, "" + u.getSex());
        pst.setInt(4, u.getGrad_id());
        pst.execute();
        System.out.println("registred");
        logon = 1;
    }
    
    public static int login(User u) throws SQLException {
        String username = u.getUsername();
        String password = u.getPassword();
        String upit = "select * from userlist where userlist_username=?;";
        Connection baza = DBConnection.getConn();
        PreparedStatement pst = baza.prepareStatement(upit);
        pst.setString(1, username);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            String getedPassword = rs.getString("userlist_password");
            if(getedPassword.equals(password)){
                System.out.println("welcome");
                logon = 1;
                return 1;
            }else{
                System.out.println("not correct try again");
                return 2;
            }
        }else{
            System.out.println("you are not registred");
            return 3;
        }
    }
    
    public static void logout(){
        logon = 0;
    }
}
