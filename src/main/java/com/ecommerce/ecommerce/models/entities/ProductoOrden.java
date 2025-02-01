package com.ecommerce.ecommerce.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenes_productos")
public class ProductoOrden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "orden_id", nullable = false) // Relación con Orden
    private Orden orden;

    public Orden getOrden() {
      return orden;
    }
    public void setOrden(Orden orden) {
      this.orden = orden;
    }
    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false) // Relación con Producto
    private Producto producto;
    
    public Producto getProducto() {
      return producto;
    }
    public void setProducto(Producto producto) {
      this.producto = producto;
    }
    private String flavor;
    private int quantity;
    private double price;

    public Long getId() {
      return id;
    }
    public void setId(Long id) {
      this.id = id;
    }
   
    public String getFlavor() {
      return flavor;
    }
    public void setFlavor(String flavor) {
      this.flavor = flavor;
    }
    public int getQuantity() {
      return quantity;
    }
    public void setQuantity(int quantity) {
      this.quantity = quantity;
    }
    public double getPrice() {
      return price;
    }
    public void setPrice(double price) {
      this.price = price;
    }
   

}
