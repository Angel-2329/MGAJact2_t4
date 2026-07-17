# Actividad 2 Backend

## Portada

* **Materia:** Curso de Verano de Programacion Web
* **Actividad:** Actividad 2 Backend
+ **Maestra:** Adelina Martinez Nieto
* **Alumno:** Angel de Jesus Mendez Garcia

## Introducción
Esta es mi segunda actividad trabajando con Spring Boot. En este proyecto aprendí cómo organizar mi código usando el patrón **MVC (Modelo, Vista, Controlador)**. Básicamente, separé la información (Modelo), las páginas que ve el usuario (Vistas) y la lógica que conecta todo (Controlador). También aprendí a usar una clase **DTO** (`Equipo`) para mover los datos de un lado a otro sin tener que conectarme directamente a la base de datos todavía.

## Métodos creados

En el controlador normal (`ControladorEquipo`) creé estos métodos:
*   **`listarEquipos`**: Ocupé la anotación `@GetMapping("/lista")` para que al entrar a esa ruta se muestre la página con todos los equipos. Usé el objeto `Model` para mandarle la lista a la vista.
*   **`mostrarFormulario`**: También usa `@GetMapping("/nuevo")`. Su único trabajo es cargar la pantalla del formulario vacío para que el usuario lo llene.
*   **`guardarEquipo`**: Aquí usé `@PostMapping("/guardar")` porque la información viaja oculta al enviar el formulario. Lo nuevo que aprendí fue usar la anotación `@ModelAttribute` para atrapar los datos que el usuario escribió en el HTML y convertirlos automáticamente en mi objeto `Equipo` de Java.
*   **`buscarPorPais`**: Usa `@GetMapping("/buscar")`. Aquí aprendí a usar la anotación `@RequestParam` para atrapar parámetros que vienen pegados en la URL (por ejemplo: `?pais=Argentina`).
*   **`verDetalle`**: Usa `@GetMapping("/detalle/{id}")`. A diferencia del anterior, aquí usé la anotación `@PathVariable` para atrapar un valor que forma parte directa de la ruta de la URL (por ejemplo: `/detalle/99`).

En el controlador de API (`RestControladorEquipo`):
*   **`crearEquipoRest`**: Como este es un `@RestController`, las cosas cambian. Ocupé `@PostMapping("/crear")` y la anotación `@RequestBody`. Esto sirve para recibir información en formato JSON (como desde Postman) en lugar de un formulario web normal.

## Vistas que se crearon

Para la parte visual ocupé HTML con Thymeleaf:
*   **`lista.html`**: Es la página donde se muestra la tabla. Usé Thymeleaf (`th:each`) para recorrer la lista que me mandó el controlador y dibujar cada fila de la tabla.
*   **`formulario.html`**: Es la página para registrar un equipo. Aquí aprendí a conectar los inputs del HTML con mi objeto de Java usando `th:object` y `th:field`.

## Capturas de Pantalla

### Formulario de Registro
![Formulario](/src/main/resources/img/formulario.png)

### Lista de Equipos
![Lista](/src/main/resources/img/lista-equipos.png)

### Detalle por ID
![Detalle](/src/main/resources/img/detalles-equipo-id.png)

### Búsqueda por País
![Búsqueda](/src/main/resources/img/busqueda-pais.png)

### Prueba de API en POSTMAN
![API](/src/main/resources/img/prueba-postman.png)


## URL de mis actividades
*   **Lista de Equipos:** [http://68.183.115.226:2923/mvc/equipos/lista](http://68.183.115.226:2923/MGAJ_Act2/mvc/equipos/lista)
*   **Formulario de Registro:** [http://68.183.115.226:2923/mvc/equipos/nuevo](http://68.183.115.226:2923/MGAJ_Act2/mvc/equipos/nuevo)
*   **Detalle por ID (Ejemplo con ID 99):** [http://68.183.115.226:2923/mvc/equipos/detalle/99](http://68.183.115.226:2923/MGAJ_Act2/mvc/equipos/detalle/99)
*   **Búsqueda por País (Ejemplo con Argentina):** http://68.183.115.226:2923/mvc/equipos/buscar?pais=Argentina
