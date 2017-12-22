/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

/**
 *
 * @author besan
 */
public class FacadeRegistration {
    private static Pharmacist aPharmacist;
    private static PharmacistModel aPharmacistModel;
    
    public FacadeRegistration(){
        aPharmacist = new Pharmacist();
        aPharmacistModel = new PharmacistModel();
    }
}
