package com.kishore;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Simple_FIle_Copier {

	private static CamelContext camelContext;

	public static void main(String[] args) throws Exception {

		camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new RouteBuilder() {

			@Override
			public void configure() throws Exception {
				from("file:data/inbox?noop=true").to("file:date/outbox");
			}

		});

		camelContext.start();
		Thread.sleep(1000000);

		camelContext.stop();

	}

}
