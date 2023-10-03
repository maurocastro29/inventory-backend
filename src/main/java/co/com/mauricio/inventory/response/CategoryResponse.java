package co.com.mauricio.inventory.response;

import java.util.List;

import co.com.mauricio.inventory.model.Category;


public class CategoryResponse {
	
	private List<Category> category;
	
	

	public List<Category> getCategory() {
		return category;
	}
	
	public void setCategory(List<Category> category) {
		this.category = category;
	}

}
