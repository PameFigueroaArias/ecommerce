package com.ecommerce.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.models.entities.Orden;
import com.ecommerce.ecommerce.models.entities.Producto;
import com.ecommerce.ecommerce.models.entities.ProductoOrden;
import com.ecommerce.ecommerce.repositories.OrdenRepository;
import com.ecommerce.ecommerce.repositories.ProductoRepository;

@Service
public class OrdenService {

   @Autowired
  private OrdenRepository ordenRepository;

   @Autowired
    private ProductoRepository productoRepository;


    public Orden crearOrden(Orden orden, List<ProductoOrden> productosOrden) {
        for (ProductoOrden productoOrden : productosOrden) {
            Producto producto = productoRepository.findById(productoOrden.getProducto().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            // Validar stock
            if (producto.getStock().getOrDefault(productoOrden.getFlavor(), 0) < productoOrden.getQuantity()) {
                throw new RuntimeException("Stock insuficiente para " + producto.getName() + " - " + productoOrden.getFlavor());
            }

            // Reducir stock
            producto.getStock().put(productoOrden.getFlavor(), producto.getStock().get(productoOrden.getFlavor()) - productoOrden.getQuantity());
            productoRepository.save(producto);

            // Asignar la orden a cada productoOrden
            orden.agregarProducto(productoOrden);
        }

        return ordenRepository.save(orden);
    }

}
