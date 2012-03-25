/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session_bean;

import entity.Tweet;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ashwini
 */
@Stateless
public class tweetsessionbean implements tweetsessionbeanLocal {
    @PersistenceContext(unitName = "clickerPU")
    private EntityManager em;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void post(String tweet)
    {
        Tweet t=new Tweet();
        t.setTweet(tweet);
       
        
       FacesContext context = FacesContext.getCurrentInstance();  
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();  
        HttpServletResponse response = (HttpServletResponse)context.getExternalContext().getResponse();  
        t.setUsername((String)request.getSession().getAttribute("username"));
        em.persist(t);
        //System.out.println(t);
    }

    public void persist(Object object) {
        em.persist(object);
    }

}
