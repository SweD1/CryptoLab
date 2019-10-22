package com.company;
//task 2
public class MonoAlfavitnii {
    public static void ready(){
        System.out.println("\nРеализация моноалфовитного шифра");
        String inputtext = "goodmorning";
        byte[] masBytes = inputtext.getBytes();
        int[] cryptoBytes = new int[inputtext.length()];
        cryptoBytes=enCryptor(masBytes);
        String outtext = deCryptor(cryptoBytes);
        System.out.println("\nДешифрованный текст: "+outtext);

    }
    public static int[] enCryptor(byte[] masbyte){
        int[] cryptomas = new int[masbyte.length];
        System.out.print("Шифротекст: ");
        for(int i = 0; i<masbyte.length; i++) {
            cryptomas[i] = (int) masbyte[i];
            System.out.print(cryptomas[i]+" ");
        }
        return cryptomas;
    }
    public static String deCryptor(int[] cryptoBytes){
        String outtext="";
        for(int i = 0; i<cryptoBytes.length; i++) {
            char ch = (char)cryptoBytes[i];
            String out =Character.toString(cryptoBytes[i]) ;
            outtext+=out;
        }
        return outtext;
    }
}
