package com.company;

import java.util.Arrays;
import java.util.Random;

public class BloknotXor {
    public static void apply() {
        System.out.println("\n\nРеализаци блокнота с методом XOR");
        String[] inputTxt = {"HiWorld","sabaka"};
        byte[] masBloknot = new byte[100];
        ///Создание блокнота
        Random rand = new Random();
        rand.nextBytes(masBloknot);
        ///
        byte[][] crypto = enCryptor(masBloknot, inputTxt, rand);
        vivoDvuMas(crypto);
        byte[] deCrypto = deCryptor(crypto,masBloknot);
        proverka(inputTxt,deCrypto);
        String deCrypttxt= new String(deCrypto);
        System.out.println("Дешифрованный текст: "+deCrypttxt);
    }
    private static byte[][] enCryptor(byte[] masBloknot,String[] inpeutTxt,Random rand){
        byte[][] cryptoText = new byte[inpeutTxt.length][];
        int indexPage = 0;
        for(int j = 0;j<inpeutTxt.length;j++){
            String str = inpeutTxt[j];
            byte mas[] = str.getBytes();
            cryptoText[j] = new byte[mas.length];
            int k =0;
            for(int i = 0;i<mas.length;i++,k++){
                if(indexPage+i>=masBloknot.length){
                    rand.nextBytes(masBloknot);
                    indexPage = 0;
                    k = 0;
                }
                cryptoText[j][i]= (byte) (mas[i]^masBloknot[indexPage+k]);
            }
            indexPage+=k;
        }
        return cryptoText;
    }
    private static byte[] deCryptor(byte[][] cryptoTxt,byte[] masBloknot){
        ////Нахождение размерности двумерного массива
        int razmernost = 0;
        for(int raz =0;raz<cryptoTxt.length;raz++){
            razmernost+=cryptoTxt[raz].length;
        }
        ////
        byte[] outputTxt = new byte[razmernost];
        int indexPage = 0;//Индекс окончания страницы
        for(int j = 0;j<cryptoTxt.length;j++){
            int k = 0;
            for(int i = 0;i<cryptoTxt[j].length;i++,k++){
                outputTxt[i+indexPage]= (byte) (cryptoTxt[j][i]^masBloknot[k+indexPage]);
            }
            indexPage+=k;
        }
        return outputTxt;
    }
    private static void proverka(String[] inpuTxt,byte[] deCrypto){
        int len = 0;
        for(int i =0;i<inpuTxt.length;i++){
            String str = inpuTxt[i];
            byte[] mas = str.getBytes();
            len+=mas.length;
        }
        byte[] masInput = new byte[len];
        int index=0;
        for(int j =0;j<inpuTxt.length;j++){
            String str = inpuTxt[j];
            byte[] mas=str.getBytes();
            int k = 0;
            for(int u = 0;u<mas.length;u++,k++){
                masInput[u+index]=mas[u];
            }
            index+=k;
        }
        boolean OK = Arrays.equals(deCrypto,masInput);
        if(OK){
            System.out.println("Проверка исходного и дешифрованного сообщения: "+"AllRight");
        }
    }
    private static void vivoDvuMas(byte[][] crypto){
        for(int i = 0;i<crypto.length;i++){
            String str = new String(crypto[i]);
            System.out.println("Шифротекс: "+str);
        }
    }
}
