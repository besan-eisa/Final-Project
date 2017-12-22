/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import java.util.Observable;

/**
 *
 * @author besan
 */
public class PharmacistModel extends Observable {
    
    private Pharmacist apharmacist;

    public Pharmacist getApharmacist() {
        return apharmacist;
    }

    public void setApharmacist(Pharmacist apharmacist) {
        this.apharmacist = apharmacist;
        setChanged();
        notifyObservers();
    }
    
    
}
