/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import drugs.Drugs;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author besan
 */
public class DBDrugs {
    
    private DBConnection dbconnection;
    private Statement statement;
    private static DBDrugs dbdrugs;
     
    private DBDrugs(){}
    
        public static synchronized DBDrugs getDBDrugs(){
               if(dbdrugs == null) {
                dbdrugs = new DBDrugs();
            } 
        return dbdrugs; 
       }
        
        public String retriveNameOfOrgansBody(String drug){
            String s = null;
        try {    
            dbconnection = dbconnection.getDBConnection();
            statement = (Statement) dbconnection.getStatement();
            ResultSet r = (ResultSet) statement.executeQuery("SELECT bodyOrgans FROM drugs WHERE drugName ='"+drug+"'");
              if(r.next()) {
                s =  r.getString("bodyOrgans");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DBDrugs.class.getName()).log(Level.SEVERE, null, ex);
        }
          return s;
        }
        
        public String showingContradictions() {
            String s = null;
        try {
            dbconnection = dbconnection.getDBConnection();
            statement = (Statement) dbconnection.getStatement();
            String desc1 = "It is a strong central analgesic, opioid opiate ag..." ; 
            String desc2 = "Alopripatant Aprepitant is anti Alnorochinin neuro...";
            ResultSet r = (ResultSet) statement.executeQuery
                ("SELECT drugName FROM drugs WHERE descriptionAndComposition ='"+desc1+"'or'"+desc2+"'");
            
            while(r.next()) {
              s =  r.getString("drugName");
             //System.out.println(s);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DBDrugs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
        }
        
        public String compositionAndDescription(String drug) {
            String s = null;
        try {
            dbconnection = dbconnection.getDBConnection();
            statement = (Statement) dbconnection.getStatement();    
            String query = ("SELECT descriptionAndComposition FROM drugs WHERE drugName  ='"+drug+"'");
            ResultSet r = (ResultSet) statement.executeQuery(query);
            
            while (r.next()) {
                s = r.getString("descriptionAndComposition");
               // System.out.println(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBDrugs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
        }
        
        public String displayAlternativeMedicine(String drug) {
            String s = null;
        try {   
            dbconnection = dbconnection.getDBConnection();
            statement = (Statement) dbconnection.getStatement();
            ResultSet r = (ResultSet) statement.executeQuery
                                ("SELECT alternativeMedicine FROM drugs " + "WHERE drugName ='"+drug+"'");
             
            while (r.next()) {
                s = r.getString("alternativeMedicine");
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DBDrugs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s; 
    }
        
        public String displayTheSideEffect(String drug) {
              String s = null;
        try {
            dbconnection = dbconnection.getDBConnection();
            statement = (Statement) dbconnection.getStatement();            
            ResultSet r = (ResultSet) statement.executeQuery("SELECT sideEffects FROM drugs WHERE drugName ='"+drug+"'");
           
                while (r.next()) {
                    s = r.getString("sideEffects");
                }
        } catch (SQLException ex) {
            Logger.getLogger(DBDrugs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

        public void add(Drugs drugs){
        DBConnection adbConnection = DBConnection.getDBConnection();
        String sql = "Insert into drugs(drugName,alternativeMedicine,descriptionAndComposition,sideEffects,bodyOrgans) values('"+
                drugs.getName()+"','"+
                drugs.getAlternativeMedicine()+"','"+
                drugs.getDescriptionAndComposition()+"','"+
                drugs.getSideEffects()+"','"+
                drugs.getBodyOrgans()+"')";
        try {
              statement = (Statement) adbConnection.getStatement();
              statement.executeUpdate(sql);  
        }   catch (SQLException ex) {
               Logger.getLogger(DBUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
        
        public void delete(Drugs drugs){
        DBConnection adbConnection = DBConnection.getDBConnection();
        String sql = "delete from drugs where drugName ='"+drugs.getName()+"'";
        try {
              statement = (Statement) adbConnection.getStatement();
              statement.executeUpdate(sql);  
               
        }   catch (SQLException ex) {
            Logger.getLogger(DBUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        /*
        public void fetch(Drugs drugs){
        String s = null;
        try {
            dbconnection = dbconnection.getDBConnection();
            statement = (Statement) dbconnection.getStatement();
            String query = ("SELECT * FROM drugs");
            ResultSet r = (ResultSet) statement.executeQuery(query);

            while (r.next()) {
                 String d = r.getString("drugName");
                String alt = r.getString("alternativeMedicine");
                String des = r.getString("descriptionAndComposition");
                String sid = r.getString("sideEffects");
                String bod = r.getString("bodyOrgans");
                System.out.println(s);
            }
        }
         catch (SQLException ex) {
            Logger.getLogger(DBUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
        
        public void update(Drugs drugs){
        DBConnection adbConnection = DBConnection.getDBConnection();
         String sql = "UPDATE drugs " +"SET drugName = '"+ drugs.getName()+"','"+
                drugs.getAlternativeMedicine()+"','"+drugs.getDescriptionAndComposition()+"','"+
                drugs.getSideEffects()+"','"+drugs.getBodyOrgans()+"' WHERE drugName = '"+drugs+"'";
        try {
              statement = (Statement) adbConnection.getStatement();
              statement.executeUpdate(sql);  
        JOptionPane.showMessageDialog(null, "Updated");    
        }                 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "update not successful");
        }
    }   
       
        public void view(String drug){
        try {
            dbconnection = dbconnection.getDBConnection();
            statement = (Statement) dbconnection.getStatement();
            String query = ("SELECT * FROM drugs WHERE drugName ='"+drug+"'");
            ResultSet r = (ResultSet)statement.executeQuery(query);
                while (r.next()) {
                 String s =  r.getString("drugName")+"\n";
                 String alt = r.getString("alternativeMedicine")+"\n";
                 String desc = r.getString("descriptionAndComposition")+"\n";
                 String side  = r.getString("sideEffects")+"\n";
                 String bod = r.getString("bodyOrgans");
                 
                 Drugs d = new Drugs();
                 d.setName(s);
                 d.setAlternativeMedicine(alt);
                 d.setDescriptionAndComposition(desc);
                 d.setSideEffects(side);
                 d.setBodyOrgans(bod);
                }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
        public String searchById(String drug) {
        String s = null;
        try {
            dbconnection = dbconnection.getDBConnection();
            statement = (Statement) dbconnection.getStatement();
            String query = ("SELECT * FROM drugs WHERE id ="+drug);
            ResultSet r = (ResultSet) statement.executeQuery(query);
                while(r.next()) {
                    s =  r.getString("id".trim()) +" "+r.getString("drugName".trim()) +" "+
                        r.getString("alternativeMedicine".trim()) +" "+
                        r.getString("descriptionAndComposition".trim())+" "+r.getString("sideEffects".trim())+" "+
                        r.getString("bodyOrgans".trim());
                       
                    System.out.println(s);
                } 
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
        
        public String searchByName(String drug) {
        String s = null;
        try {
            dbconnection = dbconnection.getDBConnection();
            statement = (Statement) dbconnection.getStatement();
            String query = ("SELECT * FROM drugs WHERE drugName ="+drug);
            ResultSet r = (ResultSet) statement.executeQuery(query);
            while(r.next()) {
                s =  r.getString("id".trim()) +" "+r.getString("drugName".trim()) +" "+
                        r.getString("alternativeMedicine".trim())
                        +" "+ r.getString("descriptionAndComposition".trim())+" "+r.getString("sideEffects".trim())
                        +" "+  r.getString("bodyOrgans".trim());
                       

                 System.out.println(s);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
        
}


