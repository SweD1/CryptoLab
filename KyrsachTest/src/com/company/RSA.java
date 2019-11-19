package com.company;

import java.math.BigInteger;
import java.util.Random;

public class RSA {
    public int run(String message,int p,int q ,int d) {
    //int p = primeNumber(12,20);
    //int q = primeNumber(10,20);
    int n = p*q;
    int fi= (p-1)*(q-1);
    System.out.println("p="+p);
    System.out.println("q="+q);
    System.out.println("n="+n);
    System.out.println("fi(n)="+fi);
    //int d = mutuallyPrime(fi);
    System.out.println("Взаимнопростое число: "+d);
    int e = findingE(fi,d);
    System.out.println("e="+e);
    BigInteger[] C = enCryptor(message,e,n);
    String Crypto= vivodCryptoMas(C);
    BigInteger[] deC = deCryptor(C,d,n);
    String DeCrypto= vivodMas(deC);
    System.out.println("\nШифротекст: "+Crypto);
    System.out.println("Дешифро текст: "+DeCrypto);
    return e;
}
    private static BigInteger[] enCryptor(String M,int e ,int n){
        BigInteger[] C= new BigInteger[M.length()];
        BigInteger N = BigInteger.valueOf(n);
        System.out.println(e);
        BigInteger E = BigInteger.valueOf(e);
        char[] chmas= new char[M.length()];
        M.getChars(0,M.length(),chmas,0);
        for(int i =0;i<chmas.length;i++){
            int prom = (int) chmas[i]-848;//1039
            //System.out.println(prom);
            BigInteger PROM;
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
            if(rnd % 2 != 0 && rnd % 3 != 0 && rnd % 5 != 0 && rnd % 7 != 0 && rnd % 8 != 0 && rnd % 9 != 0) {
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
    public static int findingE(int fi ,int d){
        int e=0;
        for(int i=0;i<d;i++){
            if((fi*i+1)%d==0){
                e+=(fi*i+1)/d;
                break;
            }
        }
        return e;
    }
    private static String vivodMas(BigInteger[] txt){
        String output= "";
        for(int i=0;i<txt.length;i++){
            int znach = txt[i].intValue()+848;
            System.out.print((znach-848)+" ");
            char letter = (char) znach;
            output+=letter;
        }
        return output;
    }
    private static String vivodCryptoMas(BigInteger[] txt){
        String output= "";
        for(int i=0;i<txt.length;i++){
            int znach = txt[i].intValue();
            System.out.print(znach + " ");
            char letter = (char) znach;
            output+=letter;
        }
        return output;
    }
}

