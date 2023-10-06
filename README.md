# diploCloudGeoService
Proyecto Diplomado Nube 2023.

Este microservicio (geojason service) implementa un CRUD para Reservas (Reservas Ecológicas).


Deploy
//TODO

Test

GET /reservas/{id}

curl -X GET http://localhost:8082/reservas/{id}

{
  "id": "string",
  "nombre": "string"
}


PUT /reservas/{id}

curl -X PUT http://localhost:8082/reservas/json

{
  "id": "string",
  "nombre": "string"
}


POST /reservas/{id}

curl -X POST http://localhost:8082/reservas/json

{
  "id": "string",
  "nombre": "string"
}



DELETE /reservas/{id}

curl -X DELETE http://localhost:8082/reservas/{id}


GET /reservas

curl -X GET http://localhost:8082/reservas

[
  {
    "id": "string",
    "nombre": "string"
  }
]


