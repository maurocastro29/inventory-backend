package co.com.mauricio.inventory.response;

public class ProductResponseRest extends ResponseRest{

	private ProductResponse response = new ProductResponse();

	public ProductResponse getResponse() {
		return response;
	}

	public void setResponse(ProductResponse response) {
		this.response = response;
	}
	
	
	
}