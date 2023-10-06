# diploCloudGeoService
Proyecto Diplomado Nube 2023.

José Luis Villarreal Benítez

Este microservicio (geojason service) implementa un CRUD para Reservas (Reservas Ecológicas).

La creación de la base de datos requiere del script: scripMongoDB.

El API está documetado en el archivo geojson-service-api-docs.yaml. También se proporciona el api-docs.json.


Instrucciones para ejecutar el proyecto

1. En este sitio, clona el repositorio.
2. Importa el proyecto a un IDE Java (Eclipse de preferencia).
3. Has un UpDate a Maven.
4. Ejecutalo desde Boot Dashboard.
5. El proyecto se despliega en el localhost:8082.
6. Puedes ejecutar las pruebas con POSTMAN.



Deploy

//TODO


Test (en POSTMAN)

POST http://localhost:8082/reservas/json

{

  "nombre": "string"
  
}

Responde con el JSON enviado, con un id creado automáticamnete.

{

  "id": "string",
  
  "nombre": "string"
  
}


GET http://localhost:8082/reservas/

Regresa todos las reservas en la base de datos como un arreglo

[

  {
  
    "id": "string",
    
    "nombre": "string"
    
  },
  
  ...
  
]



Toma u id del GET y sustitúyelo en {id}

GET http://localhost:8082/reservas/{id}

Respuesta esperada

{

  "id": "string",
  
  "nombre": "string"
  
}

Indica el cambio en el nombre para el id seleccioado

PUT http://localhost:8082/reservas/json

{

  "id": "string",
  
  "nombre": "string"
  
}

Regresa el JSON con el cambio realizado

{

  "id": "string",
  
  "nombre": "string"
  
}


DELETE http://localhost:8082/reservas/{id}

{

  "id": "string",
  
}


Solo regresa código 100


