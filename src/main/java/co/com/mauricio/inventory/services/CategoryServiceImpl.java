package co.com.mauricio.inventory.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.mauricio.inventory.dao.ICategoryDao;
import co.com.mauricio.inventory.model.Category;
import co.com.mauricio.inventory.response.CategoryResponseRest;

@Service
public class CategoryServiceImpl implements ICategoryService{
	
	@Autowired
	private ICategoryDao categoryDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> search() {
		CategoryResponseRest response = new CategoryResponseRest();
		try {
			List<Category> category = (List<Category>) categoryDao.findAll();
			response.getCategoryResponse().setCategory(category);
			response.setMetaData("Respuesta OK", "00", "Respuesta exitosa");
		}catch (Exception e) {
			response.setMetaData("Respuesta no OK", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(response.getCategoryResponse().getCategory() == null) {
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> searchById(Long id) {
		CategoryResponseRest response = new CategoryResponseRest();
		List<Category> list = new ArrayList<>();
		try {
			Optional<Category> category = categoryDao.findById(id);
			if(category.isPresent()) {
				list.add(category.get());
				response.setMetaData("Respuesta OK", "00", "Respuesta exitosa");
				response.getCategoryResponse().setCategory(list);
			}else {
				response.setMetaData("Respuesta no OK", "404", "Categoria no encontrada");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			response.setMetaData("Respuesta no OK", "-1", "Error al consultar por id");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResponseRest> save(Category category) {
		CategoryResponseRest response = new CategoryResponseRest();
		List<Category> list = new ArrayList<>();
		try {
			Category categorySaved = categoryDao.save(category);
			if(categorySaved != null) {
				list.add(categorySaved);
				response.setMetaData("Respuesta OK", "00", "Respuesta exitosa");
				response.getCategoryResponse().setCategory(list);
			}else {
				response.setMetaData("Respuesta no OK", "-1", "Categoria no guardada");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			response.setMetaData("Respuesta no OK", "-1", "Error al almacenar la categoria");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResponseRest> update(long id, Category category) {
		CategoryResponseRest response = new CategoryResponseRest();
		List<Category> list = new ArrayList<>();
		
		
		try {
			Optional<Category> buscarCategoria = categoryDao.findById(id);
			
			if(buscarCategoria.isPresent()) {
				buscarCategoria.get().setName(category.getName());
				buscarCategoria.get().setDescription(category.getDescription());
				
				Category categoryUpdate = categoryDao.save(buscarCategoria.get());
				if(categoryUpdate != null) {
					list.add(categoryUpdate);
					response.setMetaData("Respuesta OK", "00", "Respuesta exitosa");
					response.getCategoryResponse().setCategory(list);
				}else {
					response.setMetaData("Respuesta no OK", "-1", "Categoria no actualizada");
					return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.BAD_REQUEST);
				}
				
			}else {
				response.setMetaData("Respuesta no OK", "404", "Categoria no actualizada");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
			}
			
			
			
		}catch (Exception e) {
			response.setMetaData("Respuesta no OK", "-1", "Error al actualizar la categoria");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<CategoryResponseRest> deleteById(long id) {
		CategoryResponseRest response = new CategoryResponseRest();
		List<Category> list = new ArrayList<>();
		try {
			Optional<Category> buscarCategoria = categoryDao.findById(id);
			if(buscarCategoria.isPresent()) {
				categoryDao.deleteById(id);
				list.add(buscarCategoria.get());
				response.setMetaData("Respuesta OK", "00", "Registro eliminado");
				response.getCategoryResponse().setCategory(list);
			}else {
				response.setMetaData("Respuesta no OK", "404", "Categoria no eliminada");
				return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.NOT_FOUND);
			}
		}catch (Exception e) {
			response.setMetaData("Respuesta no OK", "-1", "Error al eliminar la categoria");
			e.getStackTrace();
			return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoryResponseRest>(response, HttpStatus.OK);
	}

}













