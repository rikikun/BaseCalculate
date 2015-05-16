package com.dtec.main;

import java.util.HashMap;
import java.util.Map;
import static com.dtec.main.BaseFunction.*;

public class InputMain {
	public static Map<Character, Integer> mapToInt = new HashMap<>();
	public static Map<Integer,Character> mapToChar = new HashMap<>();
	static {
		for (int i = 0; i < (26); i++) {
			mapToInt.put((char) (i + 97), i);
			mapToChar.put(i, (char) (i + 97));
		}
	}
	public static void main(String...args){
		BaseFunction baseFunction=new BaseFunction(26);
		System.out.println(plus("bzde","bbb"));
		System.out.println(plus("tmfafj",multiple(plus("ijlegcod",plus("dota", "is")),"zanroo")));
		System.out.println(multiple("zz", "zz"));
	}
	
	
}
