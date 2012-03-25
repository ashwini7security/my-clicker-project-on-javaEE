/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ashwini
 */
@ManagedBean (name="user_details")
@RequestScoped
public class userdetails_mng_bean {

    
      private String username;
     /**
     * /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String fetchName1 () {
         if(username.equals(username)  || email_id == null || password == null )
         return " Enter all Details Mr. "+username;
         else
             return " you are successfully register: Please Login again !" ;
        
    }

    

    /* * Creates a new instance of userdetails_mng_bean
     */
     
    private String password;

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    private String email_id;

    /**
     * Get the value of email_id
     *
     * @return the value of email_id
     */
    public String getEmail_id() {
        return email_id;
    }

    /**
     * Set the value of email_id
     *
     * @param email_id new value of email_id
     */
    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public userdetails_mng_bean() {
    }
}
