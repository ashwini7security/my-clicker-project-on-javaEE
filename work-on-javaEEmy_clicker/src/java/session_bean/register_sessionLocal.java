/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session_bean;

import javax.ejb.Local;

/**
 *
 * @author ashwini
 */
@Local
public interface register_sessionLocal
{
public void register(String username,String password,String firstname,String lastname,String emailid);

    public void persist(java.lang.Object object);

    public java.lang.String check_login(java.lang.String username, java.lang.String password);
}
