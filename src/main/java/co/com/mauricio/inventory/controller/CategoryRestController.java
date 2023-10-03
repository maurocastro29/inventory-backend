package co.com.mauricio.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mauricio.inventory.model.Category;
import co.com.mauricio.inventory.response.CategoryResponseRest;
import co.com.mauricio.inventory.services.ICategoryService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	
	@Autowired
	private ICategoryService service;
	
	/**
	 * Get all the Categories
	 * @return
	 */
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest> searchCategories(){
		ResponseEntity<CategoryResponseRest> response = service.search();
		
		return response;
	}
	
	/**
	 * Get categories by id	
	 * @param id
	 * @return
	 */
	@GetMapping("/categories/{id}")
	public ResponseEntity<CategoryResponseRest> searchcategoriesById(@PathVariable Long id){
		ResponseEntity<CategoryResponseRest> response = service.searchById(id);
		
		return response;
	}
	
	/**
	 * Save categories
	 * @param category
	 * @return
	 */
	@PostMapping("/categories")
	public ResponseEntity<CategoryResponseRest> save(@RequestBody Category category){
		ResponseEntity<CategoryResponseRest> response = service.save(category);
		
		return response;
	}
	

	/**
	 * Update a category
	 * @param id
	 * @param category
	 * @return
	 */
	@PutMapping("/categories/{id}")
	public ResponseEntity<CategoryResponseRest> update(@PathVariable Long id, @RequestBody Category category){
		ResponseEntity<CategoryResponseRest> response = service.update(id, category);
		
		return response;
	}
	

	/**
	 * Delete category by id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<CategoryResponseRest> delete(@PathVariable Long id){
		ResponseEntity<CategoryResponseRest> response = service.deleteById(id);
		
		return response;
	}
	
}
