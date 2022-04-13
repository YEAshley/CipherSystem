package system.cipher.RSA;


import system.utils.Base64;

public class RSA {

    public static String filepath = "C:\\Users\\10408\\ideaProject\\Cryptosystem\\src\\system\\cipher\\RSA\\file";

    public RSA(){
        RSAEncrypt.genKeyPair(filepath);
    }

    public static String getCiphertext1(String plaintext1) throws Exception {
        byte[] cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),plaintext1.getBytes());
        return Base64.encode(cipherData);
    }

    public static String getPlaintext1(String ciphertext1) throws Exception {
        byte[] res=RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), Base64.decode(ciphertext1));
        return new String(res);
    }

    public static String getCiphertext2(String plaintext2) throws Exception {
        byte[] cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),plaintext2.getBytes());
       return Base64.encode(cipherData);
    }

    public static String getPlaintext2(String ciphertext2) throws Exception {
        byte[] res=RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)), Base64.decode(ciphertext2));
        return new String(res);
    }

    public static String getSignStr(String content) throws Exception {
        String signStr=RSASignature.sign(content,RSAEncrypt.loadPrivateKeyByFile(filepath));
        return signStr;
    }

    public static boolean getResult(String content) throws Exception {
        return RSASignature.doCheck(content, getSignStr(content), RSAEncrypt.loadPublicKeyByFile(filepath));
    }

/*

    public static void main(String[] args) throws Exception {
        String filepath="C:\\Users\\10408\\ideaProject\\Cryptosystem\\src\\system\\cipher\\RSA\\file";

        RSAEncrypt.genKeyPair(filepath);


        System.out.println("--------------公钥加密私钥解密过程-------------------");
        String plainText="ihep_公钥加密私钥解密";
        //公钥加密过程
        byte[] cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),plainText.getBytes());
        String cipher= Base64.encode(cipherData);
        //String cipher2=new String(cipherData);
        //私钥解密过程
        byte[] res=RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), Base64.decode(cipher));
        String restr=new String(res);
        System.out.println("原文："+plainText);
        System.out.println("加密："+cipher);
        System.out.println("解密："+restr);
        System.out.println();

        System.out.println("--------------私钥加密公钥解密过程-------------------");
        plainText="ihep_私钥加密公钥解密";
        //私钥加密过程
        cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),plainText.getBytes());
        cipher=Base64.encode(cipherData);
        //公钥解密过程
        res=RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)), Base64.decode(cipher));
        restr=new String(res);
        System.out.println("原文："+plainText);
        System.out.println("加密："+cipher);
        System.out.println("解密："+restr);
        System.out.println();

        System.out.println("---------------私钥签名过程------------------");
        String content="ihep_这是用于签名的原始数据";
        String signstr=RSASignature.sign(content,RSAEncrypt.loadPrivateKeyByFile(filepath));
        System.out.println("签名原串："+content);
        System.out.println("签名串："+signstr);
        System.out.println();

        System.out.println("---------------公钥校验签名------------------");
        System.out.println("签名原串："+content);
        System.out.println("签名串："+signstr);

        System.out.println("验签结果："+RSASignature.doCheck(content, signstr, RSAEncrypt.loadPublicKeyByFile(filepath)));
        System.out.println();

    }
*/


}
