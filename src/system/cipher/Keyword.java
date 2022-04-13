package system.cipher;
/*keyword cipher*/

import java.util.ArrayList;
import java.util.List;

public class Keyword {

//    public static void main(String[] args) {
//        System.out.println("-------------------------welcome to keyword cipher!-------------------------");
//        System.out.println("Please give your choice ( Encryption to 1    Decryption to 2    Exit to 3  ");
//
//        Scanner in1 = new Scanner(System.in);
//        int choice = in1.nextInt();
//
//        if (choice == 1) {
//            System.out.println("Encryption process");
//            System.out.println("\t\tPlease input the plaintext:");
//            System.out.print("\t\t");
//            Scanner sc=new Scanner(System.in);
//            String s1=sc.nextLine();
//            System.out.println("\t\tPlease input the key:");
//            System.out.print("\t\t");
//            Scanner sc1=new Scanner(System.in);
//            String key=sc1.nextLine();
//            Encryption(s1,key);
//
//        } else if (choice == 2) {
//            System.out.println("Decryption process");
//            System.out.println("\t\tPlease input the ciphertext:");
//            System.out.print("\t\t");
//            Scanner sc2=new Scanner(System.in);
//            String s2=sc2.nextLine();
//            System.out.println("\t\tPlease input the key:");
//            System.out.print("\t\t");
//            Scanner sc3=new Scanner(System.in);
//            String keyy=sc3.nextLine();
//            Decryption(s2,keyy);
//
//        } else if (choice == 3) {
//            System.exit(0);
//        } else {
//            System.out.println("Sorry, your input is incorrect.");
//            System.exit(0);
//
//        }
//
//    }

    /*对输入的密钥进行去重处理*/
    public static List<Character> key_operate(String k)
    {
        char[] keys = k.toCharArray();
        List<Character> keyss = new ArrayList<>();

        for (int i = 0; i < keys.length; i++) {
            if (i > 0) {
                if (keyss.contains(keys[i]))
                    continue;
            }
            keyss.add(keys[i]);
        }
        System.out.println("\t\tThe key after de-duplication is :"+keyss.toString());
        return keyss;
    }

    public static String Encryption(String str, String k) {
        int i,j;
        /*字母表数组*/
        char[] arr2=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        StringBuilder sb = new StringBuilder();

        /*去重密钥数组(List->Object->char)*/
        String kk=k.toLowerCase();
        List<Character> realkey=key_operate(kk);
        Object[] strr=realkey.toArray();
        char[] arr1=new char[strr.length];
        for(j=0;j<strr.length;j++)
        {
            arr1[j]= (char) strr[j];
        }

        /*明文对照表数组*/
        char []miwen1=new char[arr2.length];
        System.arraycopy(arr1,0,miwen1,0,arr1.length);
        System.arraycopy(arr2,0,miwen1,arr1.length,arr2.length-arr1.length);

        List<Character> list = new ArrayList<>();
        for (i=0; i<miwen1.length; i++) {
            if(!list.contains(miwen1[i])) {
                list.add(miwen1[i]);
            }
        }
        for(i=0;i<arr2.length;i++){
            if(!list.contains(arr2[i])) {
                list.add(arr2[i]);
            }
        }

        Object[] aee=list.toArray();
        char[] miwen2=new char[aee.length];
        for(j=0;j<miwen2.length;j++)
        {
            miwen2[j]= (char) aee[j];
        }
        /*拼凑密文字符串*/
        String strs=str.toLowerCase();
        char[] plaintext = strs.toCharArray();
        char[] ciphertext= new char[plaintext.length];
        for(i=0;i<plaintext.length;i++)
        {
            for(j=0;j<miwen2.length;j++)
            {
                if(plaintext[i]==arr2[j])
                    ciphertext[i]=miwen2[j];
            }
        }
        System.out.print("\t\tThe ciphertext is :");
        for(i=0;i<ciphertext.length;i++)
        {
            sb.append(ciphertext[i]);
        }
        return sb.toString();
    }

    public static String Decryption(String str, String n) {
        int i,j;
        /*字母表数组*/
        char[] arr2=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        StringBuilder sb = new StringBuilder();
        /*去重密钥数组(List->Object->char)*/
        String nn=n.toLowerCase();
        List<Character> realkeyss=key_operate(nn);
        Object[] strrss=realkeyss.toArray();
        char[] arr1=new char[strrss.length];
        for(j=0;j<strrss.length;j++)
        {
            arr1[j]= (char) strrss[j];
        }

        /*明文对照表数组*/
        char []miwen11=new char[arr2.length];
        System.arraycopy(arr1,0,miwen11,0,arr1.length);
        System.arraycopy(arr2,0,miwen11,arr1.length,arr2.length-arr1.length);

        List<Character> list = new ArrayList<>();
        for (i=0; i<miwen11.length; i++) {
            if(!list.contains(miwen11[i])) {
                list.add(miwen11[i]);
            }
        }
        for(i=0;i<arr2.length;i++){
            if(!list.contains(arr2[i])) {
                list.add(arr2[i]);
            }
        }

        Object[] aee=list.toArray();
        char[] miwen22=new char[aee.length];
        for(j=0;j<miwen22.length;j++)
        {
            miwen22[j]= (char) aee[j];
        }

        /*拼凑明文字符串*/
        String strss=str.toLowerCase();
        char[] ciphertext = strss.toCharArray();
        char[] plaintext= new char[ciphertext.length];
        for(i=0;i<ciphertext.length;i++)
        {
            for(j=0;j<arr2.length;j++)
            {
                if(ciphertext[i]==miwen22[j])
                    plaintext[i]=arr2[j];
            }
        }
        System.out.print("\t\tThe plaintext is :");
        for(i=0;i<plaintext.length;i++)
        {
           // System.out.print(plaintext[i]);
            sb.append(plaintext[i]);
        }
        return sb.toString();
    }
}
