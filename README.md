# 💬 Foro Hub - API REST

## 📝 Descripción
Foro Hub es una API REST construida en Java con Spring Boot. Este proyecto es la culminación de los desafíos de Backend del programa **Oracle Next Education (ONE)** y **Alura Latam**. La API simula el comportamiento de un foro, permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre tópicos de discusión, con validaciones de datos y persistencia en una base de datos relacional.

## 🚀 Funcionalidades (CRUD)
- **Crear tópico:** Registro de nuevos temas validando que el título y mensaje no estén vacíos.
- **Listar tópicos:** Obtención de todos los temas registrados en la base de datos.
- **Detalle de tópico:** Búsqueda específica de un tema mediante su ID.
- **Actualizar tópico:** Modificación del título o mensaje de un tema existente.
- **Eliminar tópico:** Borrado de temas por su ID.
- **Seguridad:** Rutas protegidas mediante autenticación básica de Spring Security.

## 🛠️ Tecnologías Utilizadas
- **Java 17**
- **Spring Boot 3** (Web, Data JPA, Validation, Security)
- **PostgreSQL**
- **Hibernate**
- **Maven**

## ⚙️ Cómo ejecutar el proyecto
1. Clona el repositorio.
2. Crea una base de datos en PostgreSQL llamada `forohub`.
3. Configura tus credenciales en `application.properties`. Se ha configurado el puerto `8081` por defecto.
4. Inicia la aplicación desde `ForohubApplication`.
5. Utiliza Postman o Insomnia para interactuar con los endpoints en `http://localhost:8081/topicos` (Requiere Autenticación Básica con las credenciales del application.properties).

## 👤 Autor
**Jhoan Sebastián Montealegre Vargas**
