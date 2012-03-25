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
@Table(name = "tweet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tweet.findAll", query = "SELECT t FROM Tweet t"),
    @NamedQuery(name = "Tweet.findByTweetid", query = "SELECT t FROM Tweet t WHERE t.tweetid = :tweetid"),
    @NamedQuery(name = "Tweet.findByTweet", query = "SELECT t FROM Tweet t WHERE t.tweet = :tweet"),
    @NamedQuery(name = "Tweet.findByTimestamp", query = "SELECT t FROM Tweet t WHERE t.timestamp = :timestamp"),
    @NamedQuery(name = "Tweet.findByUsername", query = "SELECT t FROM Tweet t WHERE t.username = :username")})
public class Tweet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "tweetid")
    private Integer tweetid;
    //@Size(max = 250)
    @Column(name = "tweet")
    private String tweet;
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
   // @Size(max = 20)
    @Column(name = "username")
    private String username;

    public Tweet() {
    }

    public Tweet(Integer tweetid) {
        this.tweetid = tweetid;
    }

    public Tweet(Integer tweetid, Date timestamp) {
        this.tweetid = tweetid;
        this.timestamp = timestamp;
    }

    public Integer getTweetid() {
        return tweetid;
    }

    public void setTweetid(Integer tweetid) {
        this.tweetid = tweetid;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
