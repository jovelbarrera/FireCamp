/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Manuel
 */

public class _Net {
          
    private String driver = "com.mysql.jdbc.Driver";
    private String Net = "jdbc:mysql://localhost/firecamp";
    private String UserDb = "root";
    private String PassWordDb = "";        

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @return the Net
     */
    public String getNet() {
        return Net;
    }

    /**
     * @return the UserDb
     */
    public String getUserDb() {
        return UserDb;
    }

    /**
     * @return the PassWordDb
     */
    public String getPassWordDb() {
        return PassWordDb;
    }
}
