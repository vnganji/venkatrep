package com.pom.pages;

import java.util.HashMap;

public interface Testpages {
	
	public final static HashMap<String,Object> p1 = new HashMap<>();
	public static Object Page = null;
	public static void main(String[] args) {
		
		p1.put("homepage", new homePage());
	}

}
