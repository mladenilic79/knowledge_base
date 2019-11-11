/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernatejpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author M
 */
@Entity
@Table(name = "advancedcrud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Advancedcrud.findAll", query = "SELECT a FROM Advancedcrud a")
    , @NamedQuery(name = "Advancedcrud.findById", query = "SELECT a FROM Advancedcrud a WHERE a.id = :id")
    , @NamedQuery(name = "Advancedcrud.findByAdvRandomdata", query = "SELECT a FROM Advancedcrud a WHERE a.advRandomdata = :advRandomdata")})
public class Advancedcrud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "adv_randomdata")
    private String advRandomdata;
    @JoinColumn(name = "adv_fk_username_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Userlist advFkUsernameId;

    public Advancedcrud() {
    }

    public Advancedcrud(Integer id) {
        this.id = id;
    }

    public Advancedcrud(Integer id, String advRandomdata) {
        this.id = id;
        this.advRandomdata = advRandomdata;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdvRandomdata() {
        return advRandomdata;
    }

    public void setAdvRandomdata(String advRandomdata) {
        this.advRandomdata = advRandomdata;
    }

    public Userlist getAdvFkUsernameId() {
        return advFkUsernameId;
    }

    public void setAdvFkUsernameId(Userlist advFkUsernameId) {
        this.advFkUsernameId = advFkUsernameId;
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
        if (!(object instanceof Advancedcrud)) {
            return false;
        }
        Advancedcrud other = (Advancedcrud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hibernatejpa.Advancedcrud[ id=" + id + " ]";
    }
    
}
