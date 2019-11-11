/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatejpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author M
 */
@Entity
@Table(name = "userlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userlist.findAll", query = "SELECT u FROM Userlist u")
    , @NamedQuery(name = "Userlist.findById", query = "SELECT u FROM Userlist u WHERE u.id = :id")
    , @NamedQuery(name = "Userlist.findByUserlistUsername", query = "SELECT u FROM Userlist u WHERE u.userlistUsername = :userlistUsername")
    , @NamedQuery(name = "Userlist.findByUserlistPassword", query = "SELECT u FROM Userlist u WHERE u.userlistPassword = :userlistPassword")
    , @NamedQuery(name = "Userlist.findByUserlistSex", query = "SELECT u FROM Userlist u WHERE u.userlistSex = :userlistSex")})
public class Userlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "userlist_username")
    private String userlistUsername;
    @Basic(optional = false)
    @Column(name = "userlist_password")
    private String userlistPassword;
    @Basic(optional = false)
    @Column(name = "userlist_sex")
    private String userlistSex;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "advFkUsernameId")
    private List<Advancedcrud> advancedcrudList;
    @JoinColumn(name = "userlist_fk_city_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private City userlistFkCityId;

    public Userlist() {
    }

    public Userlist(Integer id) {
        this.id = id;
    }

    public Userlist(Integer id, String userlistUsername, String userlistPassword, String userlistSex) {
        this.id = id;
        this.userlistUsername = userlistUsername;
        this.userlistPassword = userlistPassword;
        this.userlistSex = userlistSex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserlistUsername() {
        return userlistUsername;
    }

    public void setUserlistUsername(String userlistUsername) {
        this.userlistUsername = userlistUsername;
    }

    public String getUserlistPassword() {
        return userlistPassword;
    }

    public void setUserlistPassword(String userlistPassword) {
        this.userlistPassword = userlistPassword;
    }

    public String getUserlistSex() {
        return userlistSex;
    }

    public void setUserlistSex(String userlistSex) {
        this.userlistSex = userlistSex;
    }

    @XmlTransient
    public List<Advancedcrud> getAdvancedcrudList() {
        return advancedcrudList;
    }

    public void setAdvancedcrudList(List<Advancedcrud> advancedcrudList) {
        this.advancedcrudList = advancedcrudList;
    }

    public City getUserlistFkCityId() {
        return userlistFkCityId;
    }

    public void setUserlistFkCityId(City userlistFkCityId) {
        this.userlistFkCityId = userlistFkCityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userlist)) {
            return false;
        }
        Userlist other = (Userlist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernatejpa.Userlist[ id=" + id + " ]";
    }
    
}
