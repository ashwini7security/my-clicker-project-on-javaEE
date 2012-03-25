/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ashwini
 */
@Entity
@Table(name = "Tweet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tweet.findAll", query = "SELECT t FROM Tweet t"),
    @NamedQuery(name = "Tweet.findByTweetid", query = "SELECT t FROM Tweet t WHERE t.tweetid = :tweetid"),
    @NamedQuery(name = "Tweet.findByTweetcontent", query = "SELECT t FROM Tweet t WHERE t.tweetcontent = :tweetcontent"),
    @NamedQuery(name = "Tweet.findByUsername", query = "SELECT t FROM Tweet t WHERE t.username = :username"),
    @NamedQuery(name = "Tweet.findByTweettime", query = "SELECT t FROM Tweet t WHERE t.tweettime = :tweettime")})
public class Tweet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "tweetid")
    private Integer tweetid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "tweetcontent")
    private String tweetcontent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tweettime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tweettime;

    public Tweet() {
    }

    public Tweet(Integer tweetid) {
        this.tweetid = tweetid;
    }

    public Tweet(Integer tweetid, String tweetcontent, String username, Date tweettime) {
        this.tweetid = tweetid;
        this.tweetcontent = tweetcontent;
        this.username = username;
        this.tweettime = tweettime;
    }

    public Integer getTweetid() {
        return tweetid;
    }

    public void setTweetid(Integer tweetid) {
        this.tweetid = tweetid;
    }

    public String getTweetcontent() {
        return tweetcontent;
    }

    public void setTweetcontent(String tweetcontent) {
        this.tweetcontent = tweetcontent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getTweettime() {
        return tweettime;
    }

    public void setTweettime(Date tweettime) {
        this.tweettime = tweettime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tweetid != null ? tweetid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tweet)) {
            return false;
        }
        Tweet other = (Tweet) object;
        if ((this.tweetid == null && other.tweetid != null) || (this.tweetid != null && !this.tweetid.equals(other.tweetid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tweet[ tweetid=" + tweetid + " ]";
    }
    
}
