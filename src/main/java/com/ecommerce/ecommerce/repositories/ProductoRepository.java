package com.ecommerce.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.ecommerce.models.entities.Producto;

public interface ProductoRepository extends CrudRepository <Producto,Long> {
  
}
