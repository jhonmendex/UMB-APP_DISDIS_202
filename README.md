# UMB-APP_DISDIS_202
Proyecto de microservicios sistemas distribuidos

# Reviews

Microserivicio para el manejo de reviews.

## Requerimientos

### F001 El sistema debe permitir registrar una review.

### Entradas:

1. Comentario de la review. 
2. Calificación del producto. 
3. Nombre del usuario.
4. Id de la publicación.


### Resultados:

El Sistema creará un nuevo registro de la review en el cual se tendrán en cuenta los siguientes aspectos: el comentario,
la calificación, el nombre del usuario, la id de la publicación, la fecha de creación del comentario
y la fecha de modificación.

### F002 El sistema debe permitir modificar una Review.

### Entradas:

1. Nuevo comentario.
2. Nueva calificación del producto.
3. Id de la Review.

### Resultados:

El Sistema Actualizará la review con los nuevos parámetros (comentario y calificación) escritos por el usuario y 
actualizará la fecha de modificación.

### F003 El sistema debe permitir mostrar las reviews por producto.

#### Entradas:

1. Id de la publicación

#### Resultados:

El Sistema consultará las reviews y las calificaciones que tiene un producto junto con su promedio y procederá
a mostrarselos al usuario.

### F004 El sistema debe permitir eliminar un comentario.

#### Entradas:

1. id de la Review.

#### Resultados:

El Sistema borrará de forma lógica el registro de la review seleccionada por el usuario de la base de datos del 
servicio.

### F005 El sistema debe producir mensajes con las reviews por producto

#### Entradas:

1. Una review nueva o una actualización de una review.

#### Resultados:

Emitir un evento (review-by-product-event) con la información actualizada de las reviews.

## Estructura de Mensajes (KAFKA)

### Productor

#### review-by-product-event (nombre del evento)

#### Ejemplo de una lista de reviews por producto

```JSON
{
  "average": 4,
  "productId": 3,
  "reviews": [
    {
      "id": 1,
      "userName": "Alejandro",
      "created_at": "2020-05-16",
      "modificated_at": "2020-05-16",
      "comment": "Buen producto",
      "score": 4
    }
  ]
}
```