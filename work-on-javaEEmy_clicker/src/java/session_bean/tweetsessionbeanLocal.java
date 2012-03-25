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
public interface tweetsessionbeanLocal {

    public void post(java.lang.String tweet);
    
}
