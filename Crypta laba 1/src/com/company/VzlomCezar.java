package com.company;
// task 6
public class VzlomCezar {
    public static void yea() {
        System.out.println("\n\nВзлом шифра Цезаря");
        String cryptTxt = "Pbatenghyngvbaf Vgf n pnrfne pvcure";
        int len = cryptTxt.length();
        char[] ch = new char[len];
        char c = 'a';
        String decryptText ="";
        cryptTxt.getChars(0,len,ch,0);
        for (int i=1;i<26;i++){
            int key=i;

            for(char x : ch) {
                int l = (int) x;
                int FirstChar = 0;
                if (l >= 65 && l <= 90) {
                    FirstChar = 65;
                }
                if (l >= 97 && l <= 123) {
                    FirstChar = 97;
                }
               // l = FirstChar + ((l - FirstChar + key + 26) % 26);
                l = FirstChar + ((l - FirstChar + key + 26) % 26);
                c = (char) l;
                //  char c = (char) l;
                String cryptChar = Character.toString(c);
                decryptText += cryptChar;
            }
            System.out.println("Ключ: "+key);
            System.out.println("Дешифрованный текст:   "+decryptText);
            decryptText="";
        }
    }
}
