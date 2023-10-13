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

POST http://localhost:8082/reservas

{
    "nombre": "Racho El Cielo"
}

Responde con el JSON enviado, con un id creado automáticamnete.

{
    "id": "652893cda5a12b50463765ff",
    "nombre": "Racho El Cielo"
}


GET http://localhost:8082/reservas

Regresa todos las reservas en la base de datos como un arreglo

[
    {
        "id": "651e58334a1b18695382c99b",
        "nombre": "Los Tuxtlas"
    },
    {
        "id": "651e5cd909438c7579e3283f",
        "nombre": "Chamela"
    },
    {
        "id": "651e5ce409438c7579e32840",
        "nombre": "Montes Azules"
    },
    {
        "id": "652889108a3db6307abdd856",
        "nombre": "Bolsón de Mapimí"
    },
    {
        "id": "652893cda5a12b50463765ff",
        "nombre": "Racho El Cielo"
    }
]


Toma un id del GET y sustitúyelo en {id}

GET http://localhost:8082/reservas/652893cda5a12b50463765ff

Respuesta esperada

{
    "id": "652893cda5a12b50463765ff",
    "nombre": "Racho El Cielo"
}

Indica el cambio en el nombre para el id seleccioado

PUT http://localhost:8082/reservas/652893cda5a12b50463765ff

{
  "nombre": "Rancho el Cielo"
}

Regresa el JSON con el cambio realizado

{
    "id": "652893cda5a12b50463765ff",
    "nombre": "Rancho El Cielo"
}


DELETE http://localhost:8082/reservas/652889108a3db6307abdd856

Solo regresa código 204 No contet

##Dependencias

Se usará una base de datos MongoDB externalizada.

Referencia

Mongo Docker Official Image: https://hub.docker.com/_/mongo

