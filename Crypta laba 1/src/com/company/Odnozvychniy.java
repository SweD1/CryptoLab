package com.company;

import java.util.Arrays;

// task 3
public class Odnozvychniy {
    public static void enter() {
        System.out.println("\n Реалицазия однозвучного шифра");
        String inputTxt = "russianfederation";
        int cryptoAlphabet[][] = {{12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,42,44,46,48,50,52,54,56,58,60,62},{101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126}};
        char ch[] = new char[inputTxt.length()];
        inputTxt.getChars(0,inputTxt.length(),ch,0);
        int[] cryptoTxt = enCryptor(ch,cryptoAlphabet);
        System.out.println("Шифротекст: "+ Arrays.toString(cryptoTxt));
        deCryptor(cryptoTxt,cryptoAlphabet);
    }
    private static int[] enCryptor (char[] ch,int[][]cryptoAlhabet){
        int[] cryptoTxt = new int[ch.length];
        int k = 0 ;
        for(int i = 0;i<ch.length;i++){
            if(k==2){
                k=0;
            }
            int bukva = (int) ch[i]-97;
            cryptoTxt[i]=cryptoAlhabet[k][bukva];
            k++;
        }
        return cryptoTxt;
    }
   private static void deCryptor(int[] cryptoTxt,int[][] cryptoAlphabet){
        System.out.print("Дешифрованный текст: ");
        for (int element:cryptoTxt) {
            for (int i = 0; i < cryptoAlphabet.length; i++) {
                for (int j = 0; j < cryptoAlphabet[i].length; j++) {
                    if (element==cryptoAlphabet[i][j]){
                        char bukva = (char) (j+97);
                        System.out.print(bukva);
                    }
                }
            }
        }
   }
}
