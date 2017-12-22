/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author besan
 */
public class DBConnection {
    
         private Connection connection;
         private Statement statement;
         private static DBConnection aDBConnection;
         
        private DBConnection(){
          
        }
    
    public static synchronized DBConnection getDBConnection(){
        if(aDBConnection == null) {
           aDBConnection = new DBConnection();
       }
           return aDBConnection;
       }    
    
    
    public Statement getStatement() {
        try {
            dbConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        return statement;
    }

    public Connection dbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pharmacy", "root", "");
            this.statement = (Statement) this.connection.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
             return null;
    }

    public void disDBConnection() {
        try {
            connection.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
         
}
