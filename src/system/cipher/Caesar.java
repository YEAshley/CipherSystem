package system.cipher;
/*Caesar cipher*/

public class Caesar {

//    public static void main(String[] args) {
//        System.out.println("-------------------------welcome to Caesar cipher!-------------------------");
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
//            int key=sc1.nextInt();
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
//            int keyy=sc3.nextInt();
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

    public static String Encryption(String str, int k) {
        String string = "";
        for (int i = 0; i < str.length(); i++) {
            /*charAt()用于返回指定索引处的字符*/
            char j = str.charAt(i);
            if (j >= 'A' && j <= 'Z') {
                j += k % 26;
                if (j < 'A') j += 26;/*向左超界*/
                if (j > 'Z') j -= 26;/*向右超界*/
            } else if (j >= 'a' && j <= 'z') {
                j += k % 26;
                if (j < 'a') j += 26;/*向左超界*/
                if (j > 'z') j -= 26;/*向右超界*/
            }
            string += j;/*将加密后的字符合并成密文*/
        }
        return string;
    }

    public static String Decryption(String str, int n) {
        int k = Integer.parseInt("-" + n);
        String string = "";
        /*charAt()用于返回指定索引处的字符*/
        for (int i = 0; i < str.length(); i++) {
            /*charAt()用于返回指定索引处的字符*/
            char j = str.charAt(i);
            if (j >= 'A' && j <= 'Z') {
                j += k % 26;
                if (j < 'A') j += 26;/*向左超界*/
                if (j > 'Z') j -= 26;/*向右超界*/
            } else if (j >= 'a' && j <= 'z') {
                j += k % 26;
                if (j < 'a') j += 26;/*向左超界*/
                if (j > 'z') j -= 26;/*向右超界*/
            }
            string += j;/*将解密后的字符合并明文*/
        }
        return string;
    }


}

