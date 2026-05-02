package edu.qs.spring_data_jpa_demo.web_client.web_client.get;

public class Products {

	private Integer id;
	
	private String title;
	
	private Double price;

	public Products() {
		super();
	}

	public Products(Integer id, String title, Double price) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
