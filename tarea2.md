Un servicio REST (Representational State Transfer) es un estilo de arquitectura para diseñar servicios web.
Aquí te dejo los puntos clave:

Sin estado (Stateless): Cada solicitud del cliente al servidor debe contener toda la información necesaria para entender
 y procesar la solicitud. El servidor no guarda ningún estado de la sesión del cliente entre solicitudes1.
Interfaz uniforme: Todas las interacciones con los recursos se realizan de manera uniforme, generalmente a través de HTTP.
Esto incluye operaciones como GET (obtener datos), POST (enviar datos), PUT (actualizar datos) y DELETE (eliminar datos)2.
Desacoplamiento cliente-servidor: El cliente y el servidor están separados, lo que permite que evolucionen de manera independiente.
 El cliente solo necesita conocer la URI del recurso y no cómo se implementa en el servidor2.
Recursos identificados por URIs: Los recursos (datos) se identifican mediante URIs (Uniform Resource Identifiers),
 lo que facilita su acceso y manipulación2.Uso de formatos estándar: Los datos se intercambian en formatos estándar
 como JSON o XML, lo que facilita la interoperabilidad entre diferentes sistemas3.
 
 Los principios del diseño RESTful son fundamentales para crear servicios web eficientes y escalables. Aquí te los explico:

Identificación de recursos: Los recursos se identifican mediante URIs (Uniform Resource Identifiers). 
Cada recurso tiene una dirección única que permite acceder a él.
Representaciones de recursos: Los recursos pueden tener múltiples representaciones, como JSON, XML, HTML, etc.
 El cliente y el servidor intercambian estas representaciones para realizar operaciones sobre los recursos.
Mensajes autodescriptivos: Cada mensaje contiene suficiente información para describir cómo debe ser procesado.
 Esto incluye detalles como el método HTTP (GET, POST, PUT, DELETE), los encabezados y el cuerpo del mensaje.
Hipermedios como el motor del estado de la aplicación (HATEOAS): Los clientes interactúan con la aplicación 
enteramente a través de hipermedios proporcionados dinámicamente por las aplicaciones. Esto significa que las respuestas
 del servidor contienen enlaces a otras acciones posibles, guiando al cliente en su uso del API.
Interfaz uniforme: Una interfaz uniforme simplifica y desacopla la arquitectura, permitiendo que cada parte del sistema 
evolucione de manera independiente. Esto se logra mediante el uso de métodos HTTP estándar y convenciones de URI.
Sin estado (Stateless): Cada solicitud del cliente al servidor debe contener toda la información necesaria para entender y procesar
 la solicitud. El servidor no guarda ningún estado de la sesión del cliente entre solicitudes.
Cacheabilidad: Las respuestas deben ser explícitamente marcadas como cacheables o no cacheables.
 Esto permite que los clientes almacenen en caché las respuestas para mejorar el rendimiento y reducir la carga en el servidor.
HTTP (Hypertext Transfer Protocol) es el protocolo utilizado para la comunicación entre navegadores web y servidores. 
Es la base de cualquier intercambio de datos en la web y define cómo se formatean y transmiten los mensajes, así como las acciones que los servidores
y navegadores deben tomar en respuesta a varios comandos.

Métodos HTTP más comunes:
GET: Solicita una representación de un recurso específico. Las peticiones GET solo deben recuperar datos y no modificar el estado del servidor1.
POST: Envía datos al servidor para crear o actualizar un recurso. Las peticiones POST pueden cambiar el estado del servidor1.
PUT: Reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la petición1.
DELETE: Elimina el recurso especificado1.
HEAD: Solicita una respuesta idéntica a la de una petición GET, pero sin el cuerpo de la respuesta2.
OPTIONS: Describe las opciones de comunicación para el recurso de destino2.
PATCH: Aplica modificaciones parciales a un recurso2.
Estos métodos permiten realizar diversas operaciones sobre los recursos web,
facilitando la interacción entre clientes y servidores de manera eficiente y estandarizada.
En el contexto de un servicio REST, un recurso es cualquier tipo de dato que puede ser identificado y manipulado a través de una URI (Uniform Resource Identifier).
 Los recursos son los elementos fundamentales con los que interactúan los clientes y servidores en una arquitectura RESTful.

Características de un recurso:
Identificación única: Cada recurso tiene una URI única que lo identifica. 
Por ejemplo, en una API de una tienda en línea, un recurso podría ser un producto específico identificado por /productos/123.
Representaciones: Un recurso puede tener múltiples representaciones, como JSON, XML, HTML, etc.
 Estas representaciones son las formas en que los datos del recurso se envían y reciben entre el cliente y el servidor.
Manipulación a través de métodos HTTP: Los recursos se manipulan utilizando métodos HTTP estándar como GET, POST, PUT, DELETE, etc.
Por ejemplo:
GET /productos/123 recupera la información del producto con ID 123.
POST /productos crea un nuevo producto.
PUT /productos/123 actualiza el producto con ID 123.
DELETE /productos/123 elimina el producto con ID 123.
Estado y transiciones: Los recursos pueden tener estados y pueden cambiar de estado a través de las interacciones con el cliente.
 Por ejemplo, un pedido en una tienda en línea puede tener estados como “pendiente”, “enviado” y “entregado”.
Ejemplo práctico:
Imagina una API para gestionar una biblioteca. Los recursos podrían ser libros, autores y categorías.
 Cada uno de estos recursos tendría su propia URI y podría ser manipulado a través de métodos HTTP:
 
