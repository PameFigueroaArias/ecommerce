package com.ecommerce.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.models.entities.Producto;
import com.ecommerce.ecommerce.repositories.ProductoRepository;

@Service
public class ProductoService {

 @Autowired
  private ProductoRepository productoRepository;

     
    // Obtener todos los productos
    public List<Producto> obtenerTodos() {
        return (List<Producto>) productoRepository.findAll();
    }

    // Buscar producto por ID
    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }

    // Guardar o actualizar un producto
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    // Reducir stock después de una compra
    public boolean reducirStock(Long productoId, String sabor, int cantidad) {
        Optional<Producto> productoOpt = productoRepository.findById(productoId);
        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            int stockDisponible = producto.getStock().getOrDefault(sabor, 0);
            
            if (stockDisponible >= cantidad) {
                // Reducir el stock
                producto.getStock().put(sabor, stockDisponible - cantidad);
                productoRepository.save(producto);
                return true;
            }
        }
        return false; // Stock insuficiente o producto no encontrado
    }

}
