
# E-Commerce Backend - Spring Boot API 🛒🚀

Este proyecto consiste en el desarrollo de un backend plataforma de comercio electrónico, construido con Spring Boot, Spring Data JPA y MySQL. Su propósito es gestionar productos, pedidos y clientes, proporcionando una API eficiente y segura para la interacción con el frontend.

🔹 Tecnologías Utilizadas
- Java 17
- Spring Boot 3 (Spring Web, Spring Data JPA, Spring Validation)
- MySQL (Gestión de datos relacionales)
- Hibernate (ORM para persistencia de datos)

🔹 Características Principales
- Gestión de Productos: Creación, actualización, eliminación y consulta de productos con stock diferenciado por sabores.
- Carrito de Compras: Permite agregar productos con sabor y cantidad seleccionados, calculando el total de la compra.
- Gestión de Órdenes: Creación de órdenes con validación de stock y relación entre productos y pedidos.
- Validaciones y Manejo de Errores: Uso de Spring Validation y control centralizado de excepciones.

🔹 Endpoints Principales
- 🛍️ Productos /api/productos
  - GET /api/productos → Obtiene la lista de productos.
  - POST /api/productos → Agrega un nuevo producto.
  - DELETE /api/productos/{id} → Elimina un producto.
- 🛒 Carrito y Órdenes /api/ordenes
  - POST /api/ordenes → Registra una nueva orden con validación de stock.
 
 Instalación y Configuración
1. Clonar el repositorio

git clone https://github.com/PameFigueroaArias/ecommerce.git

2. Configurar MySQL
Crear una base de datos en MySQL:

CREATE DATABASE db_carro;
Modificar application.properties o application.yml con las credenciales de la BD.


3. Ejecutar la aplicación

mvn spring-boot:run


4. Insertar productos en la base de datos:
    -ejecutar el siguiente escript:
  
  -- Insertar productos en la tabla producto
INSERT INTO db_carro.productos (id, name, description, price) VALUES
(1, 'Optimum Nutrition - Gold Standard 100% Whey Protein (5 Lb) - Original', 
'Gold Standard 100% Whey de Optimum Nutrition, diseñado para apoyar el desarrollo muscular.', 81990);

INSERT INTO db_carro.productos (id, name, description, price) VALUES
(2, 'MUSCLETECH - Nitro Tech, Whey Protein (4 Lb) - Original', 
'Nitro Tech es el producto insignia de la marca MuscleTech, diseñado con proteínas de alta calidad.', 47990);

INSERT INTO db_carro.productos (id, name, description, price) VALUES
(3, 'Optimum Nutrition - Gold Standard 100% Whey Protein (2 Lb) - Original', 
'Proteína de suero aislada, concentrada y péptidos hidrolizados para un soporte óptimo.', 41990);

-- Insertar stock en la tabla producto_stock con la estructura completa
INSERT INTO db_carro.producto_stock (product_id, flavor, quantity) VALUES
(1, 'Chocolate', 50),
(1, 'Vainilla', 40),
(1, 'Fresa', 30),
(2, 'Cookies & Cream', 60),
(2, 'Chocolate', 50),
(3, 'Vainilla', 35),
(3, 'Fresa', 25);

   





