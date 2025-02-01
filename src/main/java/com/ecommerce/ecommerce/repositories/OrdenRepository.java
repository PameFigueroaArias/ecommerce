package com.ecommerce.ecommerce.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.ecommerce.models.entities.Orden;

public interface  OrdenRepository extends CrudRepository <Orden, Long> {

}
