package com.ecommerce.ecommerce.dto;

import java.util.List;


public class OrdenDTO {
  private String customerName;
  private String customerEmail;
  private List<ProductoOrdenDTO> productos;
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
  public List<ProductoOrdenDTO> getProductos() {
    return productos;
  }
  public void setProductos(List<ProductoOrdenDTO> productos) {
    this.productos = productos;
  }

  

}
