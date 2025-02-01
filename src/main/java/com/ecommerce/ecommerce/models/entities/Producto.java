package com.ecommerce.ecommerce.models.entities;


import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;


@Entity
@Table(name = "productos")
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  private double price;

    @ElementCollection
    @CollectionTable(name = "producto_stock", joinColumns = @JoinColumn(name = "product_id"))
    @MapKeyColumn(name = "flavor")
    @Column(name = "quantity")
    private Map<String, Integer> stock; // Ejemplo: {Chocolate: 10, Vainilla: 5}


  public Map<String, Integer> getStock() {
      return stock;
    }

    public void setStock(Map<String, Integer> stock) {
      this.stock = stock;
    }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
