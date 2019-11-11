
package model;

public class CrudAdvancedData implements Comparable<CrudAdvancedData> {
    
    int id;
    String message;
    int fk_user;
    // from anoter table
    String user;
    String city;

    public CrudAdvancedData() {
    }

    public CrudAdvancedData(int id, String message, int fk_user) {
        this.id = id;
        this.message = message;
        this.fk_user = fk_user;
    }

    public CrudAdvancedData(int id, String message, int fk_user, String user) {
        this.id = id;
        this.message = message;
        this.fk_user = fk_user;
        this.user = user;
    }

    public CrudAdvancedData(int id, String message, int fk_user, String user, String city) {
        this.id = id;
        this.message = message;
        this.fk_user = fk_user;
        this.user = user;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    @Override
    public String toString() {
        return "CRUDadvancedData{" + "id=" + id + ", message=" + message + ", fk_user=" + fk_user + ", user=" + user + ", city=" + city + '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // comparable
    @Override
    public int compareTo(CrudAdvancedData o) {
        
        // in case of comparing strings
        return this.getMessage().compareTo(o.getMessage());
    }
    
    
}
