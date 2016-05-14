/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import static java.lang.System.out;

/**
 *
 * @author Manuel
 */
public class _Security {
    
    private boolean autentication;

    /**
     * @return the autentication
     */
    public boolean isAutentication() {
        return autentication;
    }

    /**
     * @param autentication the autentication to set
     */
    public void setAutentication(boolean autentication) {
        this.autentication = autentication;
    }
    
    public void isLogin()
    {
        if (autentication) 
        {
            out.println("<script language='javascript'>window.location='index.jsp'</script>");
        }
    }
    
    public void redirection(String redirection)
    {
            out.println("<script language='javascript'>window.location='"+ redirection +" '</script>");        
    }        
}
