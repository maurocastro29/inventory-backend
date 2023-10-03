package co.com.mauricio.inventory.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.com.mauricio.inventory.model.Category;

public interface ICategoryDao extends CrudRepository<Category, Long>{

	Category save(Optional<Category> buscarCategoria);

}
