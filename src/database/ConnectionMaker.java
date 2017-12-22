/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import drugs.Drugs;
import registration.Pharmacist;

/**
 *
 * @author besan
 */
public class ConnectionMaker {
    private static DBDrugs dbdrugs;
    private static DBUsers dbusers;
         
    public ConnectionMaker(){}
    
    
    public String retriveNameOfOrgansBody0(String drug){
       String result = dbdrugs.getDBDrugs().retriveNameOfOrgansBody(drug);
       return result;
    }
    public void add0(Drugs drug){
      dbdrugs.getDBDrugs().add(drug);
        
    }
    public void delete0(Drugs drug){
        dbdrugs.getDBDrugs().delete(drug);
    }
    public void update0(Drugs drugs){
        dbdrugs.getDBDrugs().update(drugs);
    }
    public void view0(String drugs){
         dbdrugs.getDBDrugs().view(drugs);
       
    }
    public void searchById0(String drug){
        dbdrugs.getDBDrugs().searchById(drug);
    }
    public void searchByName0(String drug){
        dbdrugs.getDBDrugs().searchByName(drug);
    }
    
    public String showingContradictions0() {
         String name = dbdrugs.getDBDrugs().showingContradictions();
        return name;
    }
    
    public String compositionAndDescription0(String drug) {
      String result = dbdrugs.getDBDrugs().compositionAndDescription(drug);
          return result;
    }
 
    public String displayAlternativeMedicine0(String drug) {        
        String alt = dbdrugs.getDBDrugs().displayAlternativeMedicine(drug);
         return alt;    
    }

    public String displayTheSideEffect0(String drug) {
        String result = dbdrugs.getDBDrugs().displayTheSideEffect(drug);
        return result;
    }

    
    public boolean verifyUser0(String email, String password){
        if( dbusers.getDBUsers().verifyUser(email, password))
      
        return true; 
        else              
        return false;
    }
    
    public void registration0(Pharmacist apharmacist){
        dbusers.getDBUsers().registration(apharmacist);
    }
}
