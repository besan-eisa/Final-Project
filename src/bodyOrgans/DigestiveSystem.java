/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bodyOrgans;

import drugs.DigestiveDrugs;
import drugs.Drugs;

/**
 *
 * @author besan
 */
public class DigestiveSystem extends Appliances{

    @Override
    public Drugs createDrug(String name) {
     return new DigestiveDrugs(name);
    }
    
}
