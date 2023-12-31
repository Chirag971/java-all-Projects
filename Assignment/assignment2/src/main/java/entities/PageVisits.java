/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "page_visits")
@NamedQueries({
    @NamedQuery(name = "PageVisits.findAll", query = "SELECT p FROM PageVisits p"),
    @NamedQuery(name = "PageVisits.findById", query = "SELECT p FROM PageVisits p WHERE p.id = :id"),
    @NamedQuery(name = "PageVisits.findByClientIp", query = "SELECT p FROM PageVisits p WHERE p.clientIp = :clientIp"),
    @NamedQuery(name = "PageVisits.findByPageUrl", query = "SELECT p FROM PageVisits p WHERE p.pageUrl = :pageUrl"),
    @NamedQuery(name = "PageVisits.findByVisitCount", query = "SELECT p FROM PageVisits p WHERE p.visitCount = :visitCount")})
public class PageVisits implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "client_ip")
    private String clientIp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "page_url")
    private String pageUrl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "visit_count")
    private int visitCount;

    public PageVisits() {
    }

    public PageVisits(Integer id) {
        this.id = id;
    }

    public PageVisits(Integer id, String clientIp, String pageUrl, int visitCount) {
        this.id = id;
        this.clientIp = clientIp;
        this.pageUrl = pageUrl;
        this.visitCount = visitCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
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
        if (!(object instanceof PageVisits)) {
            return false;
        }
        PageVisits other = (PageVisits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PageVisits[ id=" + id + " ]";
    }
    
}
