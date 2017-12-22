/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodyOrgans;

import drugs.Drugs;
import drugs.RespiratoryDrugs;

/**
 *
 * @author besan
 */
public class RespiratorySystem extends Appliances{

    @Override
    public Drugs createDrug(String name) {
        return new RespiratoryDrugs(name);
    }
    
}
