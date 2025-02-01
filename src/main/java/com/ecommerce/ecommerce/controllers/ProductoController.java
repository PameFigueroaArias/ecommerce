package com.ecommerce.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.models.entities.Producto;
import com.ecommerce.ecommerce.repositories.ProductoRepository;


@RestController
@RequestMapping("/api/productos")
@CrossOrigin("*")
public class ProductoController {

  @Autowired
  private ProductoRepository productoRepository;

  @GetMapping
  public List<Producto> listarProductos() {
      return (List<Producto>) productoRepository.findAll();
  }

  @PostMapping
  public Producto agregarProducto(@RequestBody Producto producto) {
      return productoRepository.save(producto);
  }
}
