/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session_bean;
import entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sneha
 */
@Stateless
public class register_session implements register_sessionLocal
{
    @PersistenceContext(unitName = "clickerPU")
    private EntityManager em;
    
    @Override
    public void register(String username,String password,String firstname,String lastname,String emailid)
    {
        Users u = new Users();
        u.setEmailid(emailid);
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setPassword(password);
        u.setUsername(username);
        em.persist(u);
    }
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void persist(Object object) {
        em.persist(object);
    }

      public String usr;
    @Override
    public String check_login(String username, String password) 
    {
        Users check_user = em.find(Users.class,username);
        String pass = check_user.getPassword();
        if(pass.equals(password))
        {  
            usr = username;
            return "success";
        }
        else
        {
            return "fail";
        }
    }
   
    
}
