package model;

public class User {
    private int id;
    private String username, password;
    private char sex;
    private int grad_id;
    // string from another table
    private String grad;

    public User() {
    }

    public User(int id, String username, String password, char sex, int grad_id, String grad) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.grad_id = grad_id;
        this.grad = grad;
    }

    public User(String username, String password, char sex, int grad_id) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.grad_id = grad_id;
    }

    public User(String username, String password, char sex, int grad_id, String grad) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.grad_id = grad_id;
        this.grad = grad;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getGrad_id() {
        return grad_id;
    }

    public void setGrad_id(int grad_id) {
        this.grad_id = grad_id;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", sex=" + sex + ", grad_id=" + grad_id + '}';
    }
    
    // from another table

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
