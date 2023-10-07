package co.com.mauricio.inventory.response;

import java.util.List;

import co.com.mauricio.inventory.model.Product;

public class ProductResponse {
	
	List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
