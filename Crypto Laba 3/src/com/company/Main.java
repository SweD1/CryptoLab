package com.company;

import java.math.BigInteger;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String M = "Hello";
        int p = primeNumber(10,50);
        int q = primeNumber(10,50);
        int n = p*q;
        int fi= (p-1)*(q-1);
        System.out.println("p="+p);
        System.out.println("q="+q);
        System.out.println("fi(n)="+fi);
        int e = mutuallyPrime(fi);
        System.out.println("Взаимно простое число: "+e);
        int d = findingD(fi,e);
        System.out.println("d="+d);
        BigInteger[] C = enCryptor(M,e,n);
       String Crypto= vivodMas(C);
        BigInteger[] deC = deCryptor(C,d,n);
       String DeCrypto= vivodMas(deC);
        System.out.println("Шифротекст: "+Crypto);
        System.out.println("ДешифрованныйТекст: "+DeCrypto);
    }
    private static BigInteger[] enCryptor(String M,int e ,int n){
        BigInteger[] C= new BigInteger[M.length()];
        BigInteger N = BigInteger.valueOf(n);
        BigInteger E = BigInteger.valueOf(e);
        char[] chmas= new char[M.length()];
        M.getChars(0,M.length(),chmas,0);
        for(int i =0;i<chmas.length;i++){
            int prom = (int) chmas[i];
            BigInteger PROM = BigInteger.valueOf(prom);
            PROM=BigInteger.valueOf(prom);
            C[i]=PROM.modPow(E,N);;
        }
        return C;
    }
    private static BigInteger[] deCryptor(BigInteger[] C,int d,int n){
        BigInteger[] deC = new BigInteger[C.length];
        BigInteger D = BigInteger.valueOf(d);
        BigInteger N = BigInteger.valueOf(n);
        for (int i =0;i<deC.length;i++){
            deC[i]=C[i].modPow(D,N);
        }
        return deC;
    }
    private static int primeNumber(int min,int max){
        int result=0;
        Random rand = new Random();
        int dif = max - min;
        for(int i = 0;i<max;i++) {
            int rnd = min + rand.nextInt(dif + 1);
             if(rnd%2!=0 && rnd%3!=0 && rnd%4!=0 && rnd%5!=0 && rnd%6!=0 && rnd%7!=0 && rnd%8!=0 && rnd%9!=0) {
                result += rnd;
                 break;
             }
        }
        return result;
    }
    private static int mutuallyPrime(int fi){
        Random random = new Random();
        int e = 0;
        for( int i=0;i<fi;i++){
            e= random.nextInt(fi);
            if(algorithmEvklida(fi,e)==1){
                break;
            }
        }
        return e;
    }
    private static int algorithmEvklida(int a, int b) {
        int c;
        while (b > 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return Math.abs(a);
    }
    private static int findingD(int fi ,int e){
        int d=0;
        for(int i=0;i<e;i++){
            if((fi*i+1)%e==0){
                d+=(fi*i+1)/e;
                break;
            }
        }
        return d;
    }
    private static String vivodMas(BigInteger[] txt){
        String output= "";
        for(int i=0;i<txt.length;i++){
            int znach = txt[i].intValue();
            char letter = (char) znach;
            output+=letter;
        }
        return output;
    }
}
