/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import database.ConnectionMaker;

/**
 *
 * @author besan
 */
public class SearchByName implements ISearch{

    @Override
    public void search(String drug) {
          ConnectionMaker cm = new ConnectionMaker();
          cm.searchByName0(drug);
    }
    
}
