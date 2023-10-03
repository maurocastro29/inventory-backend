package co.com.mauricio.inventory.services;

import org.springframework.http.ResponseEntity;

import co.com.mauricio.inventory.model.Category;
import co.com.mauricio.inventory.response.CategoryResponseRest;

public interface ICategoryService {

	public ResponseEntity<CategoryResponseRest> search();
	
	public ResponseEntity<CategoryResponseRest> searchById(Long id);
	
	public ResponseEntity<CategoryResponseRest> save(Category category);
	
	public ResponseEntity<CategoryResponseRest> update(long id, Category category);
	
}
