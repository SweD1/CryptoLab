package com.company;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String input = "ПОБОЧНАЯ";
        String inputkey = "ГАМУ";//КРОВ
        String inputKeyForDes = "КРОВАТЬ";
        String messageForRSA = "КНД";//КНД
        String messageForHESH = "КАЗНАЧЕЕВ";//КАЗНАЧЕЕВ
        int pForRsaHesh = 11;//11
        int qForRSAHesh = 23;//23
        int closeKeyRsa = 157;//157
        int n = pForRsaHesh*qForRSAHesh;
        int fi= (pForRsaHesh-1)*(qForRSAHesh-1);
        int initializationVector = 5;//5
        /////GOST-89 Algorithm implementation
        System.out.println("\nGOST-89 Algorithm implementation");
        GOST gost = new GOST();
        gost.run(input,inputkey);
        /////
        /////RSA Algorithm implementation
        System.out.println("\nRSA Algorithm implementation");
        RSA rsa = new RSA();
        int openKeyRsa = rsa.run(messageForRSA,pForRsaHesh,qForRSAHesh,closeKeyRsa);
        /////
        /////HESH Algorithm implementation
        System.out.println("\nHESH Algorithm implementation");
        int hesh = HESH.getHESH(pForRsaHesh,qForRSAHesh,initializationVector,messageForHESH);
        System.out.println("Хеш равен: " + hesh);
        /////E-signature
        System.out.println("\nE-signature");
        BigInteger eSignature = Esignature.getEsignature(closeKeyRsa,n,hesh);
        System.out.println("ЭЦП: " + eSignature);
        //Esignature.checkEsignature(openKeyRsa,n,eSignature,hesh);
        //////DES Algorithm implementation
        System.out.println("\nDES Algorithm implementation");
        DES des = new DES();
        des.run(input,inputKeyForDes);
        /////

    }
}
