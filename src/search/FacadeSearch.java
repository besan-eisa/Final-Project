/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author besan
 */
public class FacadeSearch {
    private  ISearch aSearchByName;
    
    
    public FacadeSearch(){
        aSearchByName = new SearchByName();
    }
}
