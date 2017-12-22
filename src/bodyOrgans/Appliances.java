/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodyOrgans;

import database.ConnectionMaker;
import drugs.Drugs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author besan
 */
public abstract class Appliances {
    
    List<Drugs> drugs = new ArrayList();
    
        public String retriveNameOfOrgansBody(String drugName){
        ConnectionMaker cm = new ConnectionMaker();
        String s = cm.retriveNameOfOrgansBody0(drugName);
        
    /* Drugs drug = this.createDrug(drugName);
        drugs.add(drug);*/
        
        return s;
        }
        
     /* public List<Drugs> getDrugs() {
        return drugs;
        }*/

    /*  public void setDrugs(List<Drugs> drugs) {
        this.drugs = drugs;
        }*/
        
        public abstract Drugs createDrug(String drugName);
   

        
}

