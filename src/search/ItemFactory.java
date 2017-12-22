/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author besan
 */
public class ItemFactory {
    
        private static ArrayList<Class> className = new ArrayList<Class>();

         public static ISearch createItem(String s){
             
              ISearch i = null;
                Class cc;
            try {
                cc = Class.forName(s);
                Constructor con = cc.getConstructor();
                i = (ISearch)con.newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException ex) {
                Logger.getLogger(ItemFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (InstantiationException ex) {
                Logger.getLogger(ItemFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ItemFactory.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException ex) {
                Logger.getLogger(ItemFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
         return i;
        }

    public static void ComItem(Class aclass) {
       className.add(aclass);
    }
     
    public static ArrayList<Class> getComboItem() {
        return className;
    }
         

   

               
                 
          
}
