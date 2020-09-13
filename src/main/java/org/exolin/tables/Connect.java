package org.exolin.tables;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sqlitetutorial.net
 */
public class Connect
{
    /**
     * Connect to a sample database
     */
    public static void connect()
    {
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:"))
        {
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        connect();
    }
}
