package com.dtec.main;

import java.util.ArrayList;
import java.util.List;

public class BaseFunction {
	static Integer base;

	public BaseFunction(Integer base) {
		BaseFunction.base = base;
	}
	
	public static String multiple(String p1, String p2){
		Long timePlus=convertToDecimal(convertStringToBase(p2));
		String result=p1;
		for(int i=0;i<timePlus-1;i++){
			result=plus(result, p1);
		}
		return result;
	}

	public static String plus(String p1, String p2) {
		List<String> result = null;
		List<String> t1 = null;
		if(p1.length()<=p2.length()){
			result = convertStringToBase(p1);
			t1 = convertStringToBase(p2);
		}else{
			result = convertStringToBase(p2);
			t1 = convertStringToBase(p1);
		}

		int tod = 0;
		for (int n = 0; n < t1.size(); n++) {
			Integer sum = 0;
			try{
				result.get(n);
			}catch(IndexOutOfBoundsException e){
				result.add("0");
			}
			sum = tod + Integer.parseInt(result.get(n)==null?"0":result.get(n))+ Integer.parseInt(t1.get(n));
			if (sum >= base) {
				tod = (int) sum / base;
				result.set(n, String.valueOf(sum % base));
			} else {
				result.set(n, String.valueOf(sum % base));
				tod = 0;
			}
			if((n+1)==t1.size()&&tod!=0){
				result.add(String.valueOf(tod));
			}
		}
		return convertToAZ(result);
	}

	public static List<String> convertStringToBase(String input) {
		List<String> sum = new ArrayList<>();
		for (int i = input.length()-1; i >=0 ; i--) {
			sum.add(String.valueOf(InputMain.mapToInt.get(input.charAt(i))));
		}
		return sum;
	}

	public static String convertToAZ(List<String> input) {
		String result = "";
		for (int i = 0; i < input.size(); i++) {
			result = InputMain.mapToChar.get(Integer.valueOf(input.get(i)))
					+ result;
		}
		return result;
	}
	
	public static Long convertToDecimal(List<String> input){
		Long result = 0l;
		List<String>t1=input;
		Double d=null;
		for(int i=0;i<t1.size();i++){
			if(i==0){
				result+=Long.parseLong(t1.get(i));
			}else{
				d=new Double(Math.pow(base, i));
				d=(Double.parseDouble(t1.get(i))*d);
				result+=d.longValue();
			}
		}
		return result;
	}
	
}
