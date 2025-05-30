# 🧾 Proyecto: Transformación Digital - Perfulandia SPA

Este repositorio contiene el desarrollo técnico del sistema basado en microservicios para la empresa Perfulandia SPA, como parte de la Evaluación Parcial 2 de la asignatura **Desarrollo Full Stack I**.

## 📦 Descripción General del Proyecto

> 📝 El proyecto consiste en la mejora de un software de la empresa Perfulandia SPA mediante la creacion de nuevos microservicios

## 🧩 Arquitectura de Microservicios

> 📝 

### Microservicios Desarrollados
- `carritoservice`: > 📝 Este servicio permite a los clientes navegar por el catálogo de perfumes y seleccionar productos para su compra, asegurando una experiencia fluida y eficiente.
- `compraservice`: > 📝 Este servicio gestiona todo el proceso de compra, desde el pago hasta las devoluciones asegurando una experiencia fluida y segura para los clientes.
- `gestionservice`: > 📝 Este servicio administra todos los aspectos operativos de cada sucursal de Perfumelandia, permitiendo una coordinación eficiente entre horarios, personal, proveedores y el reabastecimiento de productos.
- `autenticacionservice`: > 📝 Se encarga de gestionar la identidad de los usuarios dentro de la plataforma, asegurando un acceso seguro y confiable a los recursos y funcionalidades de la empresa.

## 🛠️ Tecnologías Utilizadas

> 📝 tecnologías y herramientas utilizadas en el proyecto:

> Spring Boot, Maven, MySQL, Postman, GitHub,IntelliJ.

## 🗄️ Configuración de Bases de Datos

> 📝 En nuestro caso nosotros usamos el programa de base de datos Laragon para crear las base de datos necesarias para nuestros microservicios. Algunos de los microservicios comparten base de datos debido a sus usos (como el de autenticación y el de usuarios).
Aqui esta el fragmento de el archivo properties de uno de los microservicios:

spring.application.name=AutenticacionService

server.port=8087

spring.datasource.url=jdbc:mysql://localhost:3306/perfulandia_usuarios
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

Este es el archivo properties del microservicio de usuarios y podemos ver que usa la base de datos de usuarios para revisar si el usuario es correcto aka si el usuario se encuentra dentro de los datos guardados en la tabla de usuarios.

Este solo fue un ejemplo de las bases de datos que usaremos para los microservicios.

## 📮 Endpoints y Pruebas

![Microservicio_carrito](https://github.com/user-attachments/assets/e2044e9c-4699-458f-a5a0-c5891f7b7cc7)
![Microservicio_Gestion](https://github.com/user-attachments/assets/4d75df5c-624e-4b8f-9036-abce47bbe510)
![Microservicio_compra](https://github.com/user-attachments/assets/590f20b0-2bdd-4929-9010-1ef4708639a5)

## 🔁 CI/CD (Integración y Entrega Continua)

> 📝 para la integracion usamos github 


## 🧑‍💻 Integrantes del Equipo

| Nombre                  | Rol en el proyecto         | Servicio principal trabajado |
|-------------------------|----------------------------|------------------------------|
| Vicente Oyarzun         |  Backend - Autenticacion   | autenticacionservice               |
| Tomás López             |  Backend - Carrito  | carritoservice              |
| Samuel Pérez            |  Backend - Repositorio - compras)  | Compraservice                |
| Gabriel Altamirano      |  Backend - gestion                           |   gestionservice                           |

## 📂 Estructura del Repositorio

> 📝  El proyecto se organizo mediante una carpeta main la cual almacena todos los microservicios creados.
```

📦 perfulandia-microservices
├── usuarioservice
├── productoservice
├── carritoervice
├── autenticacionservice
├── gestionservice
├── compraservice
└── README.md

```

## 👥 Colaboración en GitHub

> 📝 El proyecto se organizo mediante brach en el cual cada integrante debe subir su progreso de los microservicios.

## 📈 Lecciones Aprendidas

> 📝En conclusión en este trabajo se vio como se puede solucionar el caso de perfumelandia para mejorar su sistema informático, se observaron los problemas en este sistema y se busco  solucionarlos cambiando el sistema de uno monolítico a uno de microservicios para que este funcione de manera más estable y rápida.

---
