package com.kishore.models;

public class CarBrands {
	private String id;
	private String brand;

	public CarBrands() {
		super();
	}

	public CarBrands(String id, String brand) {
		super();
		this.id = id;
		this.brand = brand;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "CarBrands [id=" + id + ", brand=" + brand + "]";
	}

}
