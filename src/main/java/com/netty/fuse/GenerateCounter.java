package com.netty.fuse;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.properties.PropertiesComponent;

public class GenerateCounter implements Processor {

//	public PropertiesComponent generate(Exchange exchange) {
//		PropertiesComponent pc = exchange.getContext().getComponent("properties", PropertiesComponent.class);
//		int existingCounter = Integer.parseInt(exchange.getProperty("counter").toString());
//		pc.setLocation("classpath:application.properties");
//		pc.setCache(false);
//		java.util.Properties properties = new java.util.Properties();
//		System.out.println("before :" + existingCounter);
//		int newCounter = existingCounter + 1;
//		properties.setProperty("test", String.valueOf(newCounter));
//		System.out.println(properties.getProperty("test"));
//		pc.setOverrideProperties(properties);
//		return pc;
//
//	}

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		PropertiesComponent pc = exchange.getContext().getComponent("properties", PropertiesComponent.class);
		int existingCounter = Integer.parseInt(exchange.getProperty("counter").toString());
		pc.setLocation("classpath:application.properties");
		pc.setCache(false);
		java.util.Properties properties = new java.util.Properties();
		System.out.println("before :" + existingCounter);
		int newCounter = existingCounter + 1;
		properties.setProperty("test", String.valueOf(newCounter));
		System.out.println(properties.getProperty("test"));
		pc.setOverrideProperties(properties);

	}

}
