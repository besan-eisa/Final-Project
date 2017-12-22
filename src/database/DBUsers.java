/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import registration.Pharmacist;
import security.Encrypt;

/**
 *
 * @author besan
 */
public class DBUsers {
    private Statement aStatement;
    private static DBUsers dbusers;
    private DBUsers(){}
      
        public static synchronized DBUsers getDBUsers(){
           if(dbusers == null) {
              dbusers = new DBUsers();
        }
           return dbusers;
    }    
        public boolean verifyUser(String email, String password){
            boolean isFound = false;
            DBConnection adbConnection = DBConnection.getDBConnection();
        try {
            aStatement = adbConnection.getStatement();
            ResultSet rs = aStatement.executeQuery
            ("Select * from users where email='"+email+"' and password='" + Encrypt.encryptWithMD5(password)+"'" );
                if(rs.next())
                  isFound=true;
        } catch (SQLException ex) {
                Logger.getLogger(DBUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
       return isFound;
    }
    
        public void registration(Pharmacist apharmacist){
            DBConnection adbConnection = DBConnection.getDBConnection();
            String sql = "Insert into users(email,password,fname,lname,address) values('"+
                      apharmacist.getEmail()+"','"+
                      Encrypt.encryptWithMD5(apharmacist.getPassword())+"','"+
                      apharmacist.getFname()+"','"+
                      apharmacist.getLname()+"','"+
                      apharmacist.getAddress()+"')";    
        try {
            aStatement = adbConnection.getStatement();
            aStatement.executeUpdate(sql);
              
        } catch (SQLException ex) {
                Logger.getLogger(DBUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
        public String welcomeUser(String email){
            String s = null ;
            DBConnection adbConnection = DBConnection.getDBConnection();
        try {    
            aStatement = adbConnection.getStatement();
            ResultSet rs = aStatement.executeQuery("Select fname from users");
             if(rs.next())
                s = rs.getString("fname");
        } catch (SQLException ex) {
            Logger.getLogger(DBUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
          return s;
        }
    }




