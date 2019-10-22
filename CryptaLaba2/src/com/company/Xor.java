package com.company;

import java.util.Arrays;
//Task 1
public class Xor {
    public static void run(){
        String input = "Hisenberg";
        byte[] masByte = input.getBytes();
        byte[] key = {2,3,4,5};
        byte[] cryptoText= enCrypt(masByte,key);
        byte[] deCrypto = enCrypt(cryptoText,key);
        String deCrypttxt= new String(deCrypto);
        Boolean prov = Arrays.equals(cryptoText,masByte);
        Boolean prov1 = Arrays.equals(deCrypto,masByte);
        System.out.println("Проверка шифротекста и исходного: "+prov);
        System.out.println("Дешифрованный текст:"+deCrypttxt);
        System.out.println("Проверка дешифрованного и исходного: "+prov1);
    }
    private static byte[] enCrypt(byte[] masByte,byte[] key){
        byte[] cryptoMas = new byte[masByte.length];
        for(int i = 0;i<masByte.length;i++){
            cryptoMas[i]=(byte)( masByte[i]^key[i%3]);
        }
        return cryptoMas;
    }
}
