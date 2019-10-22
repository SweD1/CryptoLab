package com.company;
//task 1
public class Podstanovochiy {
    public static void run(){
        System.out.println("\nРеализация перестановочного шифра");
        String inputText = "RussianLanguageIsVeryBigProblem";
        int colomnusKey = 5;
       byte [] cryptoTet=enCrypto(inputText,colomnusKey);
       byte [] deCryptoTet = deCrypto(cryptoTet,colomnusKey);
        System.out.println("Шифротекст:"+new String(cryptoTet));
        System.out.println("Дешифрованный текс:"+new String(deCryptoTet));
    }
    public static byte[] enCrypto(String inputText,int colomnusKey){
        byte[] masBytes = inputText.getBytes();
        byte[] cryptoBytes = new byte[inputText.length()];
        int numberByte = 0;
        int perekluchatel = 0;
        for (int i=0;i<cryptoBytes.length;i++){
            cryptoBytes[i]=masBytes[numberByte];
            numberByte+=colomnusKey;
            if(numberByte>=inputText.length()){
                perekluchatel ++;
                numberByte = perekluchatel;
            }
        }
        return cryptoBytes;
    }
    public static byte[] deCrypto(byte[] cryptoTet,int colomnusKey){
        byte[] deCryptoText = new byte[cryptoTet.length];
        int deColomnusKey = cryptoTet.length/colomnusKey;
        int numberByte = 0;
        int perekluchatel = 0;
        for (int i=0;i<cryptoTet.length;i++){
            deCryptoText[i] = cryptoTet[numberByte];
            if(numberByte==perekluchatel){
                numberByte+=1;
            }
            numberByte +=deColomnusKey;
            if (numberByte>=cryptoTet.length){
                perekluchatel ++;
                numberByte = perekluchatel;
            }
        }
        return deCryptoText;
    }
}
