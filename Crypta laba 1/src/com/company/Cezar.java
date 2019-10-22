package com.company;
// task 5
public class Cezar {

    public static void apply() {
        String inputText = "Hi guys how Are u";
        System.out.println("Реализация шифра Цезаря");
        int key =296;
        String cryptText = crypto(inputText,key);
        String decryptText = deCrypto(cryptText,key);
        System.out.println("Шифротекст:   "+cryptText);
        System.out.println("Дешифрованный текст:   "+decryptText);
    }
    public static String crypto(String inputText,int key){
        int len = inputText.length();
        char[] ch = new char[len];
        String cryptText = "";
        inputText.getChars(0, len, ch, 0);
        for(char x : ch) {
            int l = (int) x;
            int FirstChar = 0;
            if (l >= 65 && l <= 90) {
                FirstChar = 65;
            }
            if (l >= 97 && l <= 123) {
                FirstChar = 97;
            }
            if (l==32){
                FirstChar = 32;
            }
            l = FirstChar + ((l - FirstChar + key + 26) % 26);
            char c = (char) l;
            String cryptChar = Character.toString(c);
            cryptText += cryptChar;
        }
        return  cryptText;
    }
    public static  String deCrypto (String cryptText,int key) {
        int len = cryptText.length();
        char[] ch = new char[len];
        String decryptText = "";
        cryptText.getChars(0, len, ch, 0);
        for (char x : ch) {
            int l = (int) x;
            int LastChar = 32;
            if (l >= 65 && l <= 90) {
                LastChar= 90;//с конца
            }
            if (l >= 97 && l <= 123) {
                LastChar = 123;//с конца
            }
            l=LastChar-(key+LastChar-l)%26;
            char c = (char) l;
            String decryptChar = Character.toString(c);
            decryptText += decryptChar;
        }
        return decryptText;
    }
}

