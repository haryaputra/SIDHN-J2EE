/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.bi.ejb;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author idabagus
 */
@Stateless
@LocalBean
public class SimpleEncryption {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static byte[] key = {
        0x42, 0x49, 0x73, 0x69, 0x44, 0x48, 0x4E, 0x70, 0x70, 0x40, 0x53, 0x50, 0x32, 0x30, 0x31, 0x33
    };//"BIsiDHNpp@SP2013"

    public  String encrypt(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            final String encryptedString = Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes()));
            return encryptedString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public String decrypt(String strToDecrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            final String decryptedString = new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
            return decryptedString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String generateRandomPassword(){
        return RandomStringUtils.randomAlphanumeric(8);
    }
}
