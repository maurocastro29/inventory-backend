package co.com.mauricio.inventory.dao;

import org.springframework.data.repository.CrudRepository;

import co.com.mauricio.inventory.model.Product;

public interface IProductDao extends CrudRepository<Product, Long> {

}
