package hibernatexml;
// Generated Feb 1, 2019 10:05:11 AM by Hibernate Tools 4.3.1



/**
 * Advancedcrud generated by hbm2java
 */
public class Advancedcrud  implements java.io.Serializable {


     private Integer id;
     private Userlist userlist;
     private String advRandomdata;

    public Advancedcrud() {
    }

    public Advancedcrud(Userlist userlist, String advRandomdata) {
       this.userlist = userlist;
       this.advRandomdata = advRandomdata;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Userlist getUserlist() {
        return this.userlist;
    }
    
    public void setUserlist(Userlist userlist) {
        this.userlist = userlist;
    }
    public String getAdvRandomdata() {
        return this.advRandomdata;
    }
    
    public void setAdvRandomdata(String advRandomdata) {
        this.advRandomdata = advRandomdata;
    }




}


