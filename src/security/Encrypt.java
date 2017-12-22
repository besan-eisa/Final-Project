/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author besan
 */
public class Encrypt {
    private static MessageDigest md;
    public static String encryptWithMD5(String password){
        
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passwordBytes = password.getBytes();
            md.reset();
            byte[] digested = md.digest(passwordBytes);
            StringBuffer sb = new StringBuffer();
            
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }   
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
