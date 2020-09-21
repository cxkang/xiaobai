package entity;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class AESUtil {


        private IvParameterSpec ivspec;
        private SecretKeySpec keyspec;
        private Cipher cipher;
        private final static String SecretKey = "de19489dd93f40e5";//16 char secret key

        public AESUtil() {
            ivspec = new IvParameterSpec(SecretKey.getBytes());

            keyspec = new SecretKeySpec(SecretKey.getBytes(), "AES");

            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (NoSuchPaddingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public static String encrypt(String valueToEncrypt) throws Exception {
            AESUtil enc = new AESUtil();
            return Base64.encodeBase64String(enc.encryptInternal(valueToEncrypt));
        }

        public static String decrypt(String valueToDecrypt) throws Exception {
            AESUtil enc = new AESUtil();
            return new String(enc.decryptInternal(valueToDecrypt));
        }

        private byte[] encryptInternal(String text) throws Exception {
            if (text == null || text.length() == 0) {
                throw new Exception("Empty string");
            }

            byte[] encrypted = null;
            try {
                cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
                encrypted = cipher.doFinal(text.getBytes());
            } catch (Exception e) {
                throw new Exception("[encrypt] " + e.getMessage());
            }
            return encrypted;
        }

        private byte[] decryptInternal(String code) throws Exception {
            if (code == null || code.length() == 0) {
                throw new Exception("Empty string");
            }

            byte[] decrypted = null;
            try {
                cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
                decrypted = cipher.doFinal(Base64.decodeBase64(code));
            } catch (Exception e) {
                throw new Exception("[decrypt] " + e.getMessage());
            }
            return decrypted;
        }




}
