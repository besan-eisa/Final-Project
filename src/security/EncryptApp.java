/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

/**
 *
 * @author besan
 */
public class EncryptApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String md = Encrypt.encryptWithMD5("PassWord TeSt");
        System.out.println("The MD5 hash of PassWord TeSt is: "+ md);
    }
    
}
