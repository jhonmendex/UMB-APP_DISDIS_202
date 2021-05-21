
# Microservicio order_history

Desarrollo del micro servicio de historial de ordenes, para el proyecto de Aula de la materia sistemas distribuidos de la Universidad Manuela Beltran

## Requerimientos

### F001 El sistema debe poder registrar los pedidos realizados.

### Entradas:

- Pedidos realizados exitosamente
- Pedidos cancelados
- Fecha del pedido

### Resultados:
El sistema deberá almacenar los pedidos que el usuario logro pagar y realizar exitosamente y a su vez los que se cancelaron para así tener la información clara de los pedidos realizados y cancelados con su respectiva fecha para ser de utilidad al momento de desplegar la aplicación.

### F002 El sistema debe tener la opción de eliminar o archivar pedidos

### Entradas:

- Pedidos realizados exitosamente
- Pedidos cancelados
- Fecha del pedido

### Resultados:
El sistema deberá poder darle al usuario las opciones de eliminar pedidos de su lista y a su vez la opción de archivarlos para así poder tener un control mas visual de los pedidos que el usuario desee

### F003 El sistema debe poder mostrar los pedidos archivados

### Entradas:

- Pedidos archivados
- Fecha del pedido

### Resultados:
El sistema deberá tener la opción de filtrar y ver solamente los pedidos que el usuario decidió archivar y dejando a su vez la opción para así desarchivar lo pedidos

### F004 El sistema deberá tener un filtrado

### Entradas:

- Pedidos realizados
- Pedidos cancelados
- Fecha del pedido

### Resultado:
El sistema debe proveer al usuario la opción de filtrar los pedidos ya sea por fecha o por cantidad de artículos de modo que el

### F005 El sistema debe poder redirigir al usuario a reviews

### Entradas:

- Pedidos realizados
- Pedidos cancelados
- Reviews

### Resultado:
El sistema deberá mostrar los pedidos previos que no tengan review por el usuario y deberá darle la opción para redirigirse a review y poder dejar sus comentarios del pedido.