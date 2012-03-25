/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manage_beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import session_bean.register_sessionLocal;

/**
 *
 * @author sneha
 */
@ManagedBean
@RequestScoped
public class register_managed 
{
    

    @EJB
    private register_sessionLocal register_session;

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

    private String firstname;

    /**
     * Get the value of firstname
     *
     * @return the value of firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Set the value of firstname
     *
     * @param firstname new value of firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    private String lastname;

    /**
     * Get the value of lastname
     *
     * @return the value of lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Set the value of lastname
     *
     * @param lastname new value of lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    private String username;

    /**
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
    private String emailid;

    /**
     * Get the value of emailid
     *
     * @return the value of emailid
     */
    public String getEmailid() {
        return emailid;
    }

    /**
     * Set the value of emailid
     *
     * @param emailid new value of emailid
     */
    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }
    public void register_pass()
    {
          System.out.println(username+" "+password+" "+firstname+" "+lastname+" "+emailid);
            register_session.register(username, password, firstname, lastname, emailid);
            
    }

    /**
     * Creates a new instance of register_managed
     */
    
    private String check_username;

    /**
     * Get the value of check_username
     *
     * @return the value of check_username
     */
    public String getCheck_username() {
        return check_username;
    }

    /**
     * Set the value of check_username
     *
     * @param check_username new value of check_username
     */
    public void setCheck_username(String check_username) {
        this.check_username = check_username;
    }
    private String check_password;

    /**
     * Get the value of check_password
     *
     * @return the value of check_password
     */
    public String getCheck_password() {
        return check_password;
    }

    /**
     * Set the value of check_password
     *
     * @param check_password new value of check_password
     */
    public void setCheck_password(String check_password) {
        this.check_password = check_password;
    }
/** validate code
     * 
     */
     public String check_userlogin()
    {
        String str = register_session.check_login(check_username,check_password);
        if(str.equals("success"))
        {
            System.out.println("on success    "+check_username);
            
            //set session
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession)context.getExternalContext().getSession(true);
            session.setAttribute("usr", check_username);
            //
            
            return "user_home.xhtml";
        }
        else
        {
            //System.out.println("fail    "+validate_username);
            return "Invalid Username or Password";
        }
    }
    public register_managed() {
    }
}
