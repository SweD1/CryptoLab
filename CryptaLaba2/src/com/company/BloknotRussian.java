package com.company;

import java.util.Random;

public class BloknotRussian {
    public static void run(){
        System.out.println("\nРеализация шифра с одноразовым блокнотом");
       String inputtext="рашнхайзенберг";
       System.out.println("Исходный текст: "+inputtext);
       int[] masBloknot = new int[20];
        ////Создание страницы блокнота
        masBloknot=createBloknot(masBloknot.length);
        ////
        int len = inputtext.length();
        char[] ch = new char[len];
        String cryptText = "";
        inputtext.getChars(0, len, ch, 0);
        int[] cryptoTxt = enCryptor(ch,masBloknot);
        int[] deCrypto = deCryptor(cryptoTxt,masBloknot);
    }
    private static int[] enCryptor(char[] ch,int[]masBLoknota){
        int[] cryptoTXT = new int[ch.length];
        System.out.print("\nШифротекст: ");
        int k =0;
        for(int i = 0;i<ch.length;i++, k++){
            /////Переворот страницы и уничтожение предыдущей страницы
            if(k==masBLoknota.length){
                masBLoknota = createBloknot(20);
                k=0;
            }
            /////
            cryptoTXT[i]=(int) 1072+(ch[i]-1072+masBLoknota[k]+32)%32;
            char simv = (char) cryptoTXT[i];
            System.out.print(Character.toString(simv));
        }
        return cryptoTXT;
    }
    private static int[] deCryptor(int[] cryptoTxt,int[]masBLoknota){
        int[] decryptoTXT = new int[cryptoTxt.length];
        System.out.print("\nДеШифротекст: ");
        for(int i = 0;i<cryptoTxt.length;i++){
            decryptoTXT[i]=(int) 1103-(1103+masBLoknota[i]-cryptoTxt[i])%32;
            char simv = (char) decryptoTXT[i];
            System.out.print(Character.toString(simv));
        }
        return decryptoTXT;
    }
    private static int[] createBloknot(int len){
        Random rand = new Random();
        String parasha ="";
        int[] mas=new int[len];
        int min = 1072;
        int max = 1103;
        int dif = max - min;
        System.out.print("СТраница блокнота: ");
        for (int j=0;j<mas.length;j++) {
            int i =min+ rand.nextInt(dif + 1);
            mas[j]=i;
            char bukva = (char) mas[j];
            System.out.print(Character.toString(bukva));
        }
        return mas;
    }

}
