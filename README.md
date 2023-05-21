## BJI Luxe - Proyecto Final PAT
En este trabajo se ha realizado una tienda online de diferentes tipos de productos. Las ventas se han dividido en multiples páginas a las que se accede a través de una barra de navegación. El procedimiento para realizar una compra es sencillo y se detalla a continuación. El usuario, no autenticado inicialmente, puede navegar por la página visualizando los productos y añadirlos a su carrito de compra. Una vez ha finalizado, para poder pagar los productos añadidos a dicho carrito, deberá introducir su clave y contraseña que serán verificados por el sistema. En caso de ser correctos se realizará el pago. En caso contrario, será necesaria la creación de una cuenta para realizar la compra. Como se ha indicado, la página no tiene inicialmente ningún requerimiento para entrar y ver sus productos, esto se debe a que se pretende conseguir el mayor número de clientes.
**AUTORES:** **B**eatriz Ordoñez, **J**avier del Águila e **I**ván Sánchez.

## Estructura del proyecto (Scaffolding)

 - **/controller:** Paquete donde se almacenarán las clases que representan la API-REST del microservicio
 - **/service:** Declaración de la capa de Servicio que será invocada desde la capa API (Controller)
 - **/service/impl:**  Implementación de la capa de servicios. En estas clases se deberá implementar la capa de negocio de nuestros microservicios
 - **/resources/static:** Contenido del HTML, JS y CSS de nuestra tienda Web

## Instrucciones de uso

Limpiar dependencias
> mvn clean

Empaquetar microservicio (Jar file)

> mvn package

Ejecutar microservicio en una terminal

> mvn spring-boot-run


## Operaciones disponibles

Mostrar página principal 
> http://localhost:8080/index.html

Visualizar productos y añadirlos al carrito
> Moda Mujer: http://localhost:8080/mujeres.html

> Moda Hombre: http://localhost:8080/hombres.html 

> Accesorios: http://localhost:8080/accesorios.html 

Pagar el pedido
> http://localhost:8080/carrito.html

Ver pedidos
> http://localhost:8080/pedidos.html

Crear usuarios 
> http://localhost:8080/FormularioSignUp.html

Buscar usuarios
> http://localhost:8080/UserSearcher.html

Actualizar usuarios
> http://localhost:8080/Update_user.html

Borrar usuarios
> http://localhost:8080/Delete_user.html

## Funcionalidades Extra 
- **¡Visualización y Almacenamiento de imágenes en BBDD!** BJI Luxe cuenta con un sistema de visualización y almacenamiento de imágenes en su base de datos (BBDD). Esto le permite a los administradores guardar imágenes y asociarlas con los distintos productos de la tienda, quitando la dependencia a provedores externos que nos faciliten las imagenes de los productos.
<img width="609" alt="image" src="https://github.com/202006359/BJI-Luxe/assets/113789409/5c232108-0a99-4633-ba71-49bad31f0553">

- **Persistencia BBDD - Anotacion @Transactional** Los servicios más delicados están implemetados con lógica transacional. De esta forma nos aseguramos que se hace un rollback automáticamente  en caso de error. 
<img width="609" alt="image" src="https://github.com/202006359/BJI-Luxe/assets/113789409/ff3823bb-ec1a-40c7-a2aa-82e8d270ccd5">

- **Repositorios con @Query** los CrudRepository están implementados mediante  sentencias SQL personalizadas.
<img width="609" alt="image" src="https://github.com/202006359/BJI-Luxe/assets/113789409/622b5e2d-95e8-465b-be4c-a502618d3c6c">

- **import lombok.extern.slf4j.Slf4j** Para tener un control en tiempo real de lo que va ocurriendo en la ejecución del programa. A través de las funciones log.info y log.error.
<img width="609" alt="image" src="https://github.com/202006359/BJI-Luxe/assets/113789409/ef7e75bf-4855-44ad-ad90-fbffc2c8c8a9">

- **Test** Se han añadido clases TEST E2E a todos los controladores. Implementan lógica de SpringBootTest y JUnit para verificar el correcto funcionamiento del controlador y los servicios asociados a la llamada de la API y la persistencia en BBDD. Adicionalmente, se ha hecho uso de **MockMvc** para simular las solicitudes HTTP y las respuestas durante las pruebas. Además, se utiliza la anotación **@MockBean** para crear objetos simulados (mocks) de las dependencias del controlador, como CarritoService, OrdenService y TestRestTemplate. Por último, la clase **TestRestTemplate** se utiliza para realizar llamadas a servicios REST externos durante las pruebas. 
- **Test HTTP bajo circunstancias no óptimas** Se verifica el correcto funcionamiento de la aplicación bajo distintos posibles escenarios: 200 (OK), 201 (Created), 221(Im_Used), 400(Bad_Request) y 404(Not_Found).
- **Seguridad - Encriptación de contraseñas.** El sistema utiliza una encriptación de las contraseñas de los usuarios antes de guardarlas en la base de datos.
<img width="609" alt="image" src="https://github.com/202006359/BJI-Luxe/assets/113789409/4f6216a7-b414-48ea-85b5-e44c4ac1f8de">

- **Seguridad - OAUTH2.0 .** Para mejorar los mecanismos de seguridad, nos hemos basado en OAUTH2.0 "PASSWORD" e "IMPLICIT FLOW". Para acceder a las funcionalidades exclusivas de cada usuario (realizar pedido y ver pedidos realizados). Es necesario introducir el nombre de usuario y la contraseña, para que esta sea verificada por el servidor. Una vez el servidor lo ha comprobado, se sigue la metodologia de Implicit Flow y se envia directamente la información a la que se ha pedido acceso (ver compras realizadas), y se permite directamente realizar la acción pedida (comprar la cesta).
- **Seguridad - Verificación Input HTML.** Todos los campos html sensibles a la introduccion de input por parte del usuario estan blindados con seguridad en el HTML con JavaScript. Adicionalmente, el servidor comprueba toda la informacion enviada para una doble verificación.
- **Seguridad - Página Personalizada de Error** En caso de que el usuario realice algun error, aparecerá la pagina personalizada informando del error y permitiendole navegar de vuelta a la pagina principal.
 <img width="609" alt="image" src="https://github.com/202006359/BJI-Luxe/assets/113789409/f3912175-49e9-4abd-a9c4-3a6abe972ae5">


## Schemas BBDD
<img width="609" alt="image" src="https://github.com/202006359/BJI-Luxe/assets/113789409/f8d1a956-f8a7-478c-83ad-33850d899159">
<img width="609" alt="image" src="https://github.com/202006359/BJI-Luxe/assets/113789409/b2ed94c0-bd45-41ef-ba42-2c47fe6f5f53">

