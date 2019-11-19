package com.company;

import java.io.UnsupportedEncodingException;

public class DES {
    private static byte[] swapMasOne = {58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,
                                        30,22,14,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17,9,1,59,
                                        51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,
                                        15,7};
    private static byte[] swapMasTwo = {40,8,48,16,56,24,64,32,39,7,47,15,55,23,63,31,38,6,46,14,54,
                                        22,62,30,37,5,45,13,53,21,61,29,36,4,44,12,52,20,60,28,35,3,
                                        43,11,51,19,59,27,34,2,42,10,50,18,58,26,33,1,41,9,49,17,57,
                                        25};
    private static byte[][] sBlockOne = {{14,4,13,1,2,15,11,8,3,10,6,12,5,9,0,7},
                                        {0,15,7,4,14,2,13,1,10,6,12,11,9,5,3,8},
                                        {4,1,14,8,13,6,2,11,15,12,9,7,3,10,5,0},
                                        {15,12,8,2,4,9,1,7,5,11,3,14,10,0,6,13}};
    private static byte[][] sBlockTwo = {{15,1,8,14,6,11,3,4,9,7,2,13,12,0,5,10},
                                        {3,13,4,7,15,2,8,14,12,0,1,10,6,9,11,5},
                                        {0,14,7,11,10,4,13,1,5,8,12,6,9,3,2,15},
                                        {13,8,10,1,3,15,4,2,11,6,7,12,0,5,14,9}};
    private static byte[][] sBlockThree = {{10,0,9,14,6,3,15,5,1,13,12,7,11,4,2,8},
                                          {13,7,0,9,3,4,6,10,2,8,5,14,12,11,15,1},
                                          {13,6,4,9,8,15,3,0,11,1,2,12,5,10,14,7},
                                          {1,10,13,0,6,9,8,7,4,15,14,3,11,5,2,12}};
    private static byte[][] sBlockFour = {{7,13,14,3,0,6,9,10,1,2,8,5,11,12,4,15},
                                         {13,8,11,5,6,15,0,3,4,7,2,12,1,10,14,9},
                                         {10,6,9,0,12,11,7,13,15,1,3,14,5,2,8,4},
                                         {3,15,0,6,10,1,13,8,9,4,5,11,12,7,2,14}};
    private static byte[][] sBlockFive = {{2,12,4,1,7,10,11,6,8,5,3,15,13,0,14,9},
                                         {14,11,2,12,4,7,13,1,5,0,15,10,3,9,8,6},
                                         {4,2,1,11,10,13,7,8,15,9,12,5,6,3,0,14},
                                         {11,8,12,7,1,14,2,13,6,15,0,9,10,4,5,3}};
    private static byte[][] sBlockSix = {{12,1,10,15,9,2,6,8,0,13,3,4,14,7,5,11},
                                        {10,15,4,2,7,12,9,5,6,1,13,14,0,11,3,8},
                                        {9,14,15,5,2,8,12,3,7,0,4,10,1,13,11,6},
                                        {4,3,2,12,9,5,15,10,11,14,1,7,6,0,8,13}};
    private static byte[][] sBlockSeven = {{4,11,2,14,15,0,8,13,3,12,9,7,5,10,6,1},
                                          {13,0,11,7,4,9,1,10,14,3,5,12,2,15,8,6},
                                          {1,4,11,13,12,3,7,14,10,15,6,8,0,5,9,2},
                                          {6,11,13,8,1,4,10,7,9,5,0,15,14,2,3,12}};
    private static byte[][] sBlockEight = {{13,2,8,4,6,15,11,1,10,9,3,14,5,0,12,7},
                                          {1,15,13,8,10,3,7,4,12,5,6,11,0,14,9,2},
                                          {7,11,4,1,9,12,14,2,0,6,10,13,15,3,5,8},
                                          {2,1,14,7,4,10,8,13,15,12,9,0,3,5,6,11}};
    private static byte[][][] sBlocks = {sBlockOne,sBlockTwo,sBlockThree,sBlockFour,
                                        sBlockFive,sBlockSix,sBlockSeven,sBlockEight};

    public static void run(String text,String key) throws UnsupportedEncodingException {
        ToBinary toBinary=new  ToBinary();
        byte[] inputByte= toBinary.toBi(text);
        byte[] inputByteKey = toBinary.toBi(key);
        String inputKey = outputByteArray(inputByteKey);
        String inputText = outputByteArray(inputByte);
        System.out.println(inputText);
        String afterSwap = swap(inputText,swapMasOne);
        System.out.println(afterSwap);
        String L0 = afterSwap.substring(0,32);
        String R0 = afterSwap.substring(32);
        System.out.println("L0= " + L0);
        System.out.println("R0= " + R0);
        String compressedKey = manipulationWithKey(inputKey);
        System.out.println("Ключ из 48 бит: " + compressedKey);
        String expansionR0 = expansionR0(R0);
        System.out.println("Расширение R0: " + expansionR0);
        String sumModTwo = moduloAdditionTwo(expansionR0,compressedKey);
        System.out.println("Сумма по модулю 2: " + sumModTwo);
        String afterUseSBlocks = useSBlocks(sumModTwo);
        System.out.println("После использования S-блоков: " + afterUseSBlocks);
        System.out.println(afterUseSBlocks + L0);
        String cryptoText = swap( afterUseSBlocks + L0,swapMasTwo);
        System.out.println("Шифр: " + cryptoText);
    }
    private static String useSBlocks (String sumModTwo){
        String result = "";
        for (int i= 0, begin = 0, end = 6; i<sumModTwo.length()/6; i++, begin+=6, end+=6){
            String intermediate = sumModTwo.substring(begin,end);
            int vector1 = Integer.parseInt(intermediate.substring(0,1) + intermediate.substring(5), 2);
            int vector2 = Integer.parseInt(intermediate.substring(1,5),2);
            byte swapByte = sBlocks[i][vector1][vector2];
            String im = Integer.toBinaryString(swapByte);
            for(;im.length()<4;){
                im = "0" + im;
            }
            result += im;
        }
        return result;
    }
    private static String expansionR0(String R0){
        String result = R0.substring(31) + R0.substring(0,5) + R0.substring(3,9) + R0.substring(7,13) +
                R0.substring(11,17) + R0.substring(15,21) + R0.substring(19,25) + R0.substring(23,29) +
                R0.substring(27) + R0.substring(0,1);
        return result;
    }
    private static String moduloAdditionTwo(String R0,String comressedKey){
        String result = "";
        for (int i =0,c=0,k=1;i<R0.length();i++,k+=1,c+=1){
            int a = Integer.parseInt(R0.substring(c,k),2);
            int b = Integer.parseInt(comressedKey.substring(c,k));
            int mod = (a+b)%2;
            result+= mod;
        }
        return result;
    }
    private static String swap(String masBytes, byte[] swapMas){
        String afterSwap = "";
        char[] charsArray = masBytes.toCharArray();
        int[] intermediate = new int[charsArray.length];
        for (int j = 0; j<intermediate.length; j++){
            intermediate[j] = (int) charsArray[j]-48;
        }
        for(int i = 0; i<intermediate.length; i++){
            afterSwap += intermediate[swapMas[i]-1];
        }
        return afterSwap;
    }
    private static String outputByteArray(byte[] array){
        String s = "";
        for(byte x:array){
            s += String.format("%8s",Integer.toBinaryString((x&0xFF)+0x100).substring(1));
        }
        return s;
    }
    private static String manipulationWithKey(String key){
        String compressedKey = key.substring(0,7) + key.substring(8,15) + key.substring(16,23) +
                key.substring(24,31) + key.substring(32,39) + key.substring(40,47) + key.substring(48,54);
        return compressedKey;
    }

}
