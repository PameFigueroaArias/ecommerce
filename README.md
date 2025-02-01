
# E-Commerce Backend - Spring Boot API 🛒🚀

Este proyecto consiste en el desarrollo de un backend plataforma de comercio electrónico, construido con Spring Boot, Spring Data JPA y MySQL. Su propósito es gestionar productos, pedidos y clientes, proporcionando una API eficiente y segura para la interacción con el frontend.

#🔹 Tecnologías Utilizadas
- Java 17
- Spring Boot 3 (Spring Web, Spring Data JPA, Spring Validation)
- MySQL (Gestión de datos relacionales)
- Hibernate (ORM para persistencia de datos)

#🔹 Características Principales
- Gestión de Productos: Creación, actualización, eliminación y consulta de productos con stock diferenciado por sabores.
- Carrito de Compras: Permite agregar productos con sabor y cantidad seleccionados, calculando el total de la compra.
- Gestión de Órdenes: Creación de órdenes con validación de stock y relación entre productos y pedidos.
- Validaciones y Manejo de Errores: Uso de Spring Validation y control centralizado de excepciones.

#🔹 Endpoints Principales
🛍️ Productos /api/productos
- GET /api/productos → Obtiene la lista de productos.
- POST /api/productos → Agrega un nuevo producto.
- DELETE /api/productos/{id} → Elimina un producto.
🛒 Carrito y Órdenes /api/ordenes
- POST /api/ordenes → Registra una nueva orden con validación de stock.

