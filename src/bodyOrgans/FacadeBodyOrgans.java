/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodyOrgans;

/**
 *
 * @author besan
 */
public class FacadeBodyOrgans {
    
    private static Appliances aDigestiveSystem;
    private static Appliances aRespiratorySystem;
    private static Appliances aNervousSystem;
    private Appliances app;
    
    
    public FacadeBodyOrgans(){
        aDigestiveSystem = new DigestiveSystem();
        aRespiratorySystem = new RespiratorySystem();
        aNervousSystem = new NervousSystem();
                
    }
    
    public void retriveNameOfOrgansBody0(String drugName){
        app.retriveNameOfOrgansBody(drugName);
    }

    public void createDrugInDigestiveSystem(String drugName) {
           aDigestiveSystem.createDrug(drugName);
           
    }
    
    public void createDrugInRespiratorySystem(String drugName) {
           aRespiratorySystem.createDrug(drugName);
    } 
    
    public void createDrugInNervousSystem(String drugName) {
           aNervousSystem.createDrug(drugName);
    }
    
}
