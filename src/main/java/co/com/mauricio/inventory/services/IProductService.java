package co.com.mauricio.inventory.services;

import org.springframework.http.ResponseEntity;

import co.com.mauricio.inventory.model.Product;
import co.com.mauricio.inventory.response.ProductResponseRest;

public interface IProductService {

	public ResponseEntity<ProductResponseRest> save(Product product, Long categoryId);
	
}
