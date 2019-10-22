package com.company;
import org.bouncycastle.util.encoders.Hex;

import javax.crypto.*;
import java.security.*;

import org.bouncycastle.jce.provider.BouncyCastleProvider;


public class Main {
static {
    Security.addProvider(new BouncyCastleProvider());
}
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        byte inputText[]="RussianSlippers".getBytes();
        String algoritm = "GOST-28147";
        Cipher cipher = Cipher.getInstance(algoritm,"BC");
        SecretKey key = generateSymmetricKey(algoritm);
        byte cryptoMas[]= enCrypt(cipher,key,inputText);
        byte deCryptoMas[]= deCrypt(cipher,key,cryptoMas);
        System.out.println("Алгоритм: "+algoritm);
        System.out.println("Ключ: 0x"+ new String(Hex.encode(key.getEncoded())));
        System.out.println("Шифротекст: 0x"+ new String(Hex.encode(cryptoMas)));
        System.out.println("Дешифрованный Текст: "+ new String(deCryptoMas));
    }

    private static byte[] deCrypt(Cipher cipher, SecretKey key, byte[] cryptoMas) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        cipher.init(Cipher.DECRYPT_MODE,key);
        return cipher.doFinal(cryptoMas);
    }

    private static byte[] enCrypt(Cipher cipher, SecretKey key, byte[] inputText) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        cipher.init(Cipher.ENCRYPT_MODE,key);
        return cipher.doFinal(inputText);
    }

    private static SecretKey generateSymmetricKey(String algoritm) throws NoSuchAlgorithmException {
        KeyGenerator kg = KeyGenerator.getInstance(algoritm);
        return kg.generateKey();
    }
}
