package system.cipher;

import java.util.*;

/**
 * 置换加密技术，密钥为置换和逆置换
 * 通过根据置换表改变明文字符串的排列顺序
 */
public class Permutation {
    private static final ArrayList<Integer> order = new ArrayList<>();

    /**
     * 得到逆置换
     *
     * @param key 置换表
     * @return 逆置换表
     */
    public static int[] reverseKey(int[] key) {
        int[] revKeyArray = new int[key.length];
        List<Integer> list = new ArrayList<>();
        for (int k : key) {
            list.add(k);
        }
        for (int i = 0; i < key.length; i++) {
            revKeyArray[i] = list.indexOf(i + 1) + 1;//List第一个下标是0
        }
        return revKeyArray;
    }

    /**
     * 打印密钥
     **/
    public static void printK(int[] keyArray) {
        for (int i = 0; i < keyArray.length; i++)
            System.out.print(keyArray[i] + " ");
        System.out.println();
    }

    /**
     * description:将关键字密钥的字符拆分后存入数组
     *
     * @return java.lang.String[]  原始密钥的字符串数组
     * @Param: key  密钥
     */
    private static String[] getStrKey(String key) {
        key = key.toLowerCase();//将密钥转换成小写
        key = key.replaceAll("[^a-z]", "");//去除所有的非字母字符
        String[] strKey = key.split("");
        return strKey;
    }

    public static int[] sortKey(String key) {
        int[] keyArr = new int[key.length()];
        key = key.toLowerCase();
        key = key.replaceAll("[^a-z]", "");

        char[]  keyArrayInOrder=key.toCharArray();
        Arrays.sort(keyArrayInOrder);
        char[] keyArray=key.toCharArray();
        for (int i=0;i<keyArray.length;i++) {//将输入的密钥转化为数字序号
            for (int j=0;j<keyArrayInOrder.length;j++) {
                if(keyArray[i]==keyArrayInOrder[j]) {
                    keyArray[i]=(char)(j+1+'0');
                    break;
                }
            }
        }
        for (int i = 0; i < key.length(); i++) {
            keyArr[i] = keyArray[i] - '0';
        }
        return keyArr;
    }

    /**
     * 根据密钥，改变字符串的排列顺序，
     * 可以对明文进行加密（K为置换表），
     * 或对密文进行解密（K为逆置换表）
     *
     * @param text      字符串
     * @param keyArray 密钥
     * @return
     */
    public static String EorD(String text, int[] keyArray) {
        text = text.toLowerCase();//去除空格,并转换成小写
        int count = text.length() % keyArray.length == 0 ? text.length() / keyArray.length : text.length() / keyArray.length + 1;
        char[] text_char = new char[count * keyArray.length];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            text_char[i] = text.charAt(i);
        }
        for (int i = 0; i < count * keyArray.length; i++) {
            if(text_char[i] == '\u0000')
                text_char[i] = ' ';
        }

        List<Integer> list = new ArrayList<>();
        for (int k : keyArray) {
            list.add(k);
        }
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < keyArray.length; j++) {
                sb.append(text_char[i * keyArray.length + list.indexOf(j+1)]);
            }
        }
        return sb.toString();
    }

//
//    /**
//     * 测试
//     **/
//    public static void main(String args[]) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Key>> ");
//        String key = scanner.nextLine();
//
//        for (int i = 0; i < key.length(); i++) {
//            System.out.println(sortKey(key)[i]);
//        }
//
//        System.out.print("Plaintext>> ");
//        String plaintext = scanner.nextLine();
//        String ciphertext = EorD(plaintext, sortKey(key));
//        System.out.println("Ciphertext is : " + ciphertext);
//
//        System.out.println("Decrypt\nCiphertext>> ");
//        String ciphertext2 = scanner.nextLine();
//        System.out.print("Key>> ");
//        String key2 = scanner.nextLine();
//        int[] key2Arr = reverseKey(sortKey(key));
//        String plaintext2 = EorD(ciphertext2, key2Arr);
//        System.out.println("Plaintext is : " + plaintext2);
//
//    }
}