package com.netty.fuse;

import org.springframework.stereotype.Service;

@Service
public class GenerateFLDum {

	public String generate() {
		String respIdmCashout = "2016-05-31 15:45:34TOKO      abc123    G001T001GO-PAY    REVERSAL  123456789           00success     ";
		
		return respIdmCashout;
	}

}
