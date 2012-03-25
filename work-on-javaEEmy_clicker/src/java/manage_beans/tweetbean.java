/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_beans;

import entity.Tweet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import session_bean.tweetsessionbean;
import session_bean.tweetsessionbeanLocal;

    
/**
 *
 * @author ashwini
 */
@ManagedBean
@RequestScoped
public class tweetbean{

    private String tweet;

    /**
     * Get the value of tweet
     *
     * @return the value of tweet
     */
    public String getTweet() {
        return tweet;
    }

    /**
     * Set the value of tweet
     *
     * @param tweet new value of tweet
     */
    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
    

    
    @EJB
    private tweetsessionbeanLocal tweetsessionbean;
    @PersistenceContext(unitName = "clickerPU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;

    /**
     * Creates a new instance of tweetbean
     */
    public tweetbean() {
    }

    public void persist(Object object) {
        try {
            utx.begin();
            em.persist(object);
            utx.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }
       public void post()
    {
        tweetsessionbean.post(tweet);
    }
    
public List<Tweet> listall()
   {
        FacesContext context = FacesContext.getCurrentInstance();  
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
        
        Query q1 = em.createNamedQuery("Tweet.findByUsername").setParameter("username",request.getSession().getAttribute("username") );
       
       
        System.out.println("Simmi session"+request.getSession().getAttribute("username"));
       
        List<Tweet> list;
        list =  q1.getResultList();
      
        return list;
}    
    
    
    }

