
package model;

public class CrudBasicData {
    
    int id;
    String message;

    public CrudBasicData() {
    }

    // optional constructors for search???
    public CrudBasicData(int id) {
        this.id = id;
    }

    // optional constructors for search???
    public CrudBasicData(String message) {
        this.message = message;
    }
    
    public CrudBasicData(int id, String message) {
        this.id = id;
        this.message = message;
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
}
