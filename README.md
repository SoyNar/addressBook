# Agenda de Contactos

Laboratorio de Java sobre el Framework de Colecciones. La aplicacion permite agregar, buscar, eliminar y listar contactos, organizarlos en grupos y mantener un historial en orden de insercion. Se maneja desde un menu de consola.

## Estructura del proyecto

```
Contacto.java        Datos de un contacto (nombre, telefono, email)
Agenda.java          Logica: contactos, grupos e historial
MenuPrincipal.java   Menu interactivo por consola
```

## Colecciones utilizadas

| Estructura | Implementacion | Uso |
|------------|----------------|-----|
| `Map<String, Contacto>` | `TreeMap` | Busqueda por nombre y orden alfabetico |
| `Set<String>` | `TreeSet` | Grupos unicos y ordenados |
| `Map<String, Set<String>>` | `TreeMap` de `TreeSet` | Grupo y nombres de sus contactos |
| `List<Contacto>` | `ArrayList` | Historial en orden de insercion |

## Como ejecutar

```bash
javac Contacto.java Agenda.java MenuPrincipal.java
java MenuPrincipal
```

## Pruebas

Cada prueba incluye el resultado esperado y la captura de la ejecucion.

### 1. Agregar contacto nuevo
Resultado esperado: `Contacto agregado: X`

![Prueba 1](pruebasAddress/crearContacto.png)

### 2. Agregar contacto duplicado
Resultado esperado: `Error: Ya existe un contacto con el nombre 'X'`

![Prueba 2](pruebasAddress/crearContactoNoExiste.png)

### 3. Buscar contacto existente
Resultado esperado: se muestra el contacto.

![Prueba 3](pruebasAddress/buscarContacto.png)

### 4. Buscar contacto inexistente
Resultado esperado: `Contacto no encontrado: X`

![Prueba 4](pruebasAddress/BuscarContactoNoExiste.png)

### 5. Eliminar contacto existente
Resultado esperado: `Contacto eliminado: X`

![Prueba 5](pruebasAddress/eliminarContacto.png)

### 6. Eliminar contacto inexistente
Resultado esperado: `Contacto no encontrado: X`

![Prueba 6](pruebasAddress/eliminarNoexistente.png)

### 7. Listar contactos
Resultado esperado: contactos en orden alfabetico.

![Prueba 7](pruebasAddress/listarOrdenAlfabetico.png)

### 8. Listar historial
Resultado esperado: contactos en orden de insercion.

![Prueba 8](pruebasAddress/listarHistorial.png)

### 9. Agregar grupo nuevo
Resultado esperado: `Grupo 'X' creado`

![Prueba 9](pruebasAddress/crearGrupo.png)

### 10. Agregar grupo duplicado
Resultado esperado: `Error: El grupo 'X' ya existe`

![Prueba 10](pruebasAddress/agregarGrupoYaExiste.png)

### 11. Agregar contacto a grupo existente
Resultado esperado: `Contacto agregado al grupo 'X'`

![Prueba 11](pruebasAddress/agregarAGrupoContactoNoExiste.png)

### 12. Agregar contacto inexistente a grupo
Resultado esperado: `Error: El contacto 'X' no existe`

![Prueba 12](pruebasAddress/AgregarContactoGruponoexistente.png)

### 13. Agregar contacto a grupo inexistente
Resultado esperado: `Error: El grupo 'X' no existe`

![Prueba 13](pruebasAddress/AgregarContactoGruponoexistente.png)

### 14. Mostrar contactos de un grupo con contactos
Resultado esperado: lista de los contactos del grupo.

![Prueba 14](pruebasAddress/MostrarGrupoConContactos.png)

### 15. Mostrar contactos de un grupo vacio
Resultado esperado: `El grupo 'X' no tiene contactos`

![Prueba 15](pruebasAddress/mostrarGrupoSincontactos.png)

### 16. Mostrar contactos de un grupo inexistente
Resultado esperado: `Error: El grupo 'X' no existe`

![Prueba 16](pruebasAddress/MostrarContactoGrupoNoExiste.png)

### 17. Eliminar un contacto que esta en grupos
Resultado esperado: se elimina del mapa, del historial y de todos los grupos.

![Prueba 17](pruebasAddress/eliminarContacto.png)

### 18. Opcion invalida (letra)
Resultado esperado: `Opcion invalida, intenta de nuevo`

![Prueba 18](pruebasAddress/OpcionInvalida.png)

### 19. Opcion fuera de rango
Resultado esperado: `Opcion invalida, intenta de nuevo`

![Prueba 19](pruebasAddress/OpcionInvalida.png)

### 20. Salir del menu
Resultado esperado: `Saliendo de la agenda...`

![Prueba 20](pruebasAddress/saliendoDeAGenda.png)