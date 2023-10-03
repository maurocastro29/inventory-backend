package co.com.mauricio.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mauricio.inventory.response.CategoryResponseRest;
import co.com.mauricio.inventory.services.ICategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryRestController {
	
	@Autowired
	private ICategoryService service;
	
	@GetMapping("/categories")
	public ResponseEntity<CategoryResponseRest> searchCategories(){
		ResponseEntity<CategoryResponseRest> response = service.search();
		
		return response;
	}
	
}
