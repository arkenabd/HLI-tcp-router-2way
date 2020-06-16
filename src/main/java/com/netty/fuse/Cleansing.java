package com.netty.fuse;

public class Cleansing {
	public String process(String body) {
		body = body.replaceAll("\n\r", "");
		String lengthField = body.substring(0, 4);
		int lengthInt = Integer.parseInt(lengthField);
		System.out.println("field length :" + lengthInt);

		if (body.length() > lengthInt) {
			body = body.substring(0, lengthInt);
		}

		return body;
	}

}
