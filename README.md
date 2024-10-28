## EJERCICIO #3

### Sistema de Gestion de Biblioteca

Por: Tadeo Gaviria


## Tecnologías utilizadas

- **Java**: Lenguaje principal para la programacion de la logica del servicio.
- **MySQL**: Base de datos relacional para almacenar la información de libros y usuarios.
- **JDBC**: Para la conexión y manejo de la base de datos.
- **IntelliJ IDEA**: IDE usado para el desarrollo.
- **Swagger**: Es una interface de usuario que permite crear conjunto de reglas, especificaciones y herramientas que ayudan a documentar las API.
- **Postman**: Es una aplicación útil en el desarrollo web y de apps móviles que se comunica con servicios web a través de APIs

## Funcionamiento

1. se debe inicializar la base de datos abriendo MySQL Workbrench y copiando y ejecutando las siguentes lineas:

Para crear la db:
```bash
CREATE DATABASE dbpruebataller3;
USE dbpruebataller3;
```
para crear usuario:
```bash
CREATE USER 'taller3admin'@'localhost' IDENTIFIED BY 'password';
```

y finalmente le damos los permisos respectivos al usuario:
```bash
GRANT ALL PRIVILEGES ON dbpruebataller3.* TO
'taller3admin'@'localhost';
FLUSH PRIVILEGES;
```

2. Abrimos el proyecto desde intellij IDEA y lo ejecutamos desde la terminal de MAVEN con:
```bash
mvn spring-boot:run
```
3. despues de ejecutarlo podremos acceder a Swagger para hacer pruebas desde la interface:
```bash
http://localhost:8080/swagger-ui/index.html#/usuario-controller/crearUsuario
```
4. Desde Postman tambien puedes hacer pruebas de los endpoints importando la collecion que
se encuentra guardada en la carpeta taller3>src>main>com.tadeog.taller3>postman>Taller3 POSTMAN Collection.postman_collection.json