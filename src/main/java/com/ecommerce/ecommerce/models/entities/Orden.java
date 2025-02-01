package com.ecommerce.ecommerce.models.entities;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


@Entity
@Table(name = "ordenes")
public class Orden {

      @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerEmail;

       @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductoOrden> productos = new ArrayList<>();

    // Métodos para asociar productos con la orden
    public void agregarProducto(ProductoOrden productoOrden) {
        productos.add(productoOrden);
        productoOrden.setOrden(this); // ASOCIACIÓN CORRECTA
    }

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getCustomerName() {
      return customerName;
    }

    public void setCustomerName(String customerName) {
      this.customerName = customerName;
    }

    public String getCustomerEmail() {
      return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
      this.customerEmail = customerEmail;
    }

    public List<ProductoOrden> getProductos() {
      return productos;
    }

    public void setProductos(List<ProductoOrden> productos) {
      this.productos = productos;
    }

}
