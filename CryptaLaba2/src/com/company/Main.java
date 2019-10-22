package com.company;

import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
	Xor xor = new Xor();
	xor.run();
	BloknotRussian bloknotRussian =new BloknotRussian();
	bloknotRussian.run();
	BloknotXor bloknotXor = new BloknotXor();
	bloknotXor.apply();
    }
}
