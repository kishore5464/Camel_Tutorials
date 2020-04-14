package com.kishore.service;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.sql.SqlComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.kishore.model.Books;

@Service
public class MyRouteService extends RouteBuilder {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// SETTING MySQL DATASOURCE INTO SQLCOMPONENT(CAMEL) AND RETURNING
	@Bean
	public SqlComponent sqlCompo(DataSource dataSource) {
		SqlComponent sqlCompo = new SqlComponent();
		sqlCompo.setDataSource(dataSource);
		return sqlCompo;
	}

	@Override
	public void configure() throws Exception {

		// INSERT OPERATION
		from("direct:insert").log("Insertion Processing Message: ").setHeader("message", body())
				.process(new Processor() {

					@Override
					public void process(Exchange exchange) throws Exception {
						Books book = exchange.getIn().getBody(Books.class);

						Map<String, Object> booksMap = new HashMap<>();
						booksMap.put("id", book.getId());
						booksMap.put("bookName", book.getBookName());
						booksMap.put("authorName", book.getAuthorName());

						exchange.getIn().setBody(booksMap);
					}

				}).to("sql:INSERT INTO Books(id, bookName, authorName) VALUES (:#id, :#bookName, :#authorName)");
	}

}
