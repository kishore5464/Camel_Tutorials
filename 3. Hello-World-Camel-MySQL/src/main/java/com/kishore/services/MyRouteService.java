package com.kishore.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishore.models.CarBrands;

@Service
public class MyRouteService extends RouteBuilder {

	@Autowired
	private DataSource dataSource;

	// CREATING GETTER AND SETTER FOR DATASOURCE
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void configure() throws Exception {

		// INSERT ROUTE
		from("direct:insert").process(new Processor() {
			@Override
			public void process(Exchange exchange) throws Exception {

				CarBrands brand = exchange.getIn().getBody(CarBrands.class);

				String insertQuery = "INSERT INTO carbrands(id, brand) VALUES ('" + brand.getId() + "','"
						+ brand.getBrand() + "')";

				exchange.getIn().setBody(insertQuery);
			}
		}).to("jdbc:dataSource");

		// SELECT ROUTE
		from("direct:select").setBody(constant("SELECT * FROM carbrands")).to("jdbc:dataSource")
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {

						List<Map<String, String>> dataLists = (List<Map<String, String>>) exchange.getIn().getBody();
						List<CarBrands> brands = new ArrayList<>();

						dataLists.forEach(System.out::println);

						dataLists.forEach(carBrands -> {
							CarBrands brand = new CarBrands();
							brand.setId(Integer.parseInt(carBrands.get("id")));
							brand.setBrand(carBrands.get("brand"));
						});

						exchange.getIn().setBody(brands);

						if (brands.isEmpty()) {
							System.out.println("No Record in DB");
						} else {
							System.out.println(brands.size() + " records found ");
						}

					}
				});
	}

}
