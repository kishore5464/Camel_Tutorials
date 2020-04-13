package com.kishore;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyCamelRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:myFolder/inbox?noop=true").to("file:myFolder/outbox");
	}

}
