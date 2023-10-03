package co.com.mauricio.inventory.services;

import org.springframework.http.ResponseEntity;

import co.com.mauricio.inventory.response.CategoryResponseRest;

public interface ICategoryService {

	public ResponseEntity<CategoryResponseRest> search();
	
	public ResponseEntity<CategoryResponseRest> searchById(Long id);
	
}
