package co.com.mauricio.inventory.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class CategoryResponseRest extends ResponseRest {
	
	private CategoryResponse categoryResponse = new CategoryResponse();

	public CategoryResponse getCategoryResponse() {
		return categoryResponse;
	}

	public void setCategoryResponse(CategoryResponse categoryResponse) {
		this.categoryResponse = categoryResponse;
	}

}
