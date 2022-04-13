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


        System.out.println("--------------��Կ����˽Կ���ܹ���-------------------");
        String plainText="ihep_��Կ����˽Կ����";
        //��Կ���ܹ���
        byte[] cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)),plainText.getBytes());
        String cipher= Base64.encode(cipherData);
        //String cipher2=new String(cipherData);
        //˽Կ���ܹ���
        byte[] res=RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)), Base64.decode(cipher));
        String restr=new String(res);
        System.out.println("ԭ�ģ�"+plainText);
        System.out.println("���ܣ�"+cipher);
        System.out.println("���ܣ�"+restr);
        System.out.println();

        System.out.println("--------------˽Կ���ܹ�Կ���ܹ���-------------------");
        plainText="ihep_˽Կ���ܹ�Կ����";
        //˽Կ���ܹ���
        cipherData=RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(filepath)),plainText.getBytes());
        cipher=Base64.encode(cipherData);
        //��Կ���ܹ���
        res=RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(filepath)), Base64.decode(cipher));
        restr=new String(res);
        System.out.println("ԭ�ģ�"+plainText);
        System.out.println("���ܣ�"+cipher);
        System.out.println("���ܣ�"+restr);
        System.out.println();

        System.out.println("---------------˽Կǩ������------------------");
        String content="ihep_��������ǩ����ԭʼ����";
        String signstr=RSASignature.sign(content,RSAEncrypt.loadPrivateKeyByFile(filepath));
        System.out.println("ǩ��ԭ����"+content);
        System.out.println("ǩ������"+signstr);
        System.out.println();

        System.out.println("---------------��ԿУ��ǩ��------------------");
        System.out.println("ǩ��ԭ����"+content);
        System.out.println("ǩ������"+signstr);

        System.out.println("��ǩ�����"+RSASignature.doCheck(content, signstr, RSAEncrypt.loadPublicKeyByFile(filepath)));
        System.out.println();

    }
*/


}
