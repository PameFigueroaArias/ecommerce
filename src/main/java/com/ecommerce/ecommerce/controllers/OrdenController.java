package com.ecommerce.ecommerce.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dto.OrdenDTO;
import com.ecommerce.ecommerce.models.entities.Orden;
import com.ecommerce.ecommerce.models.entities.Producto;
import com.ecommerce.ecommerce.models.entities.ProductoOrden;
import com.ecommerce.ecommerce.service.OrdenService;

@RestController
@RequestMapping("/api/ordenes")
@CrossOrigin("*")
public class OrdenController {
  @Autowired
  private OrdenService ordenService;

  public OrdenController(OrdenService ordenService) {
    this.ordenService = ordenService;
}

@PostMapping
public ResponseEntity<?> crearOrden(@RequestBody OrdenDTO ordenDTO) {
    try {
        Orden orden = new Orden();
        orden.setCustomerName(ordenDTO.getCustomerName());
        orden.setCustomerEmail(ordenDTO.getCustomerEmail());

        // Convertir productos del DTO a entidades ProductoOrden
        List<ProductoOrden> productosOrden = ordenDTO.getProductos().stream().map(prodDto -> {
            Producto producto = new Producto();  // ✅ Se crea sin constructor
            producto.setId(prodDto.getId());  // ✅ Se asigna solo el ID
            
            ProductoOrden productoOrden = new ProductoOrden();
            productoOrden.setOrden(orden); 
            productoOrden.setProducto(producto);
            productoOrden.setFlavor(prodDto.getFlavor());
            productoOrden.setQuantity(prodDto.getQuantity());
            productoOrden.setPrice(prodDto.getPrice());

            return productoOrden;
        }).collect(Collectors.toList());

        Orden nuevaOrden = ordenService.crearOrden(orden, productosOrden);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOrden);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
    }
}
}




