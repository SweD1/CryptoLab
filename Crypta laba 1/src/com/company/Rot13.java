package com.company;
//task 7
public class Rot13 {
    public static void use(){
        String Input = "Good job";
        System.out.println("\nРеализация ROT13");
        String cryptotxt = enCryptor(Input);
        String deCryptotxt = enCryptor(cryptotxt);
        System.out.println("Шифротекст:"+cryptotxt);
        System.out.println("Дешифрованный текст:"+deCryptotxt);
    }
    public static String enCryptor(String input){
        int len = input.length();
        char[] ch = new char[len];
        String cryptText = "";
        input.getChars(0, len, ch, 0);
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
            l = FirstChar + ((l - FirstChar + 13 + 26) % 26);
            char c = (char) l;
            String cryptChar = Character.toString(c);
            cryptText += cryptChar;
        }
        return  cryptText;
    }
}
