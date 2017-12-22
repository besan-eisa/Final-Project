/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drugs;

/**
 *
 * @author besan
 */
public class FacadeDrugs {
    private static DigestiveDrugs aDigestiveDrugs;
    private static NervousDrugs aNervousDrugs;
    private static RespiratoryDrugs aRespiratoryDrugs;
    
    public FacadeDrugs(){
        aDigestiveDrugs = new DigestiveDrugs();
        aNervousDrugs = new NervousDrugs();
        aRespiratoryDrugs = new RespiratoryDrugs();
    }
}
