package co.com.mauricio.inventory.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.com.mauricio.inventory.dao.ICategoryDao;
import co.com.mauricio.inventory.dao.IProductDao;
import co.com.mauricio.inventory.model.Category;
import co.com.mauricio.inventory.model.Product;
import co.com.mauricio.inventory.response.ProductResponseRest;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private ICategoryDao categoryDao;
	@Autowired
	private IProductDao productDao;

	@Override
	public ResponseEntity<ProductResponseRest> save(Product product, Long categoryId) {
		ProductResponseRest response = new ProductResponseRest();
		List<Product> list = new ArrayList<Product>();
		try {
			//search category in the product object
			Optional<Category> category = categoryDao.findById(categoryId);
			if(category.isPresent()) {
				product.setCategory(category.get());
			}else {
				response.setMetaData("Respuesta no ok", "-1", "Categoria no encontrada, asociada al producto");
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.NOT_FOUND);
			}
			
			Product productSave = productDao.save(product);
			if(productSave != null) {
				list.add(productSave);
				response.getResponse().setProducts(list);
				response.setMetaData("Respuesta ok", "00", "Producto guardado con éxito");
			}else {
				response.getResponse().setProducts(list);;
				response.setMetaData("Respuesta no ok", "-1", "Producto no guardado");
				return new ResponseEntity<ProductResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
			
		}catch (Exception e) {
			response.getResponse().setProducts(list);;
			response.setMetaData("Respuesta no ok", "-1", ("Error al guardar producto: " + e.getMessage()));
			return new ResponseEntity<ProductResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ProductResponseRest>(response, HttpStatus.CREATED);
	}
}














