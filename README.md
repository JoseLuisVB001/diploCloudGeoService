# diploCloudGeoService
Proyecto Diplomado Nube 2023.

José Luis Villarreal Benítez

5532339441

josel@unam.mx

DGTIC - UNAM

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



# Deploy

Creación de la imagen
Esta imagene está basada en arm64/jdk-17 para Mac OS.

La especificación completa de la imagen que contiene la aplicación se encuentra en el Dockerfile.

Construcción (Building) de la imagen.

La imagen se construye usando docker o podman.

podman build -t joseluisvb/diploCloudGeoService:1.0 .

¡Advertencia!

No olvide usar su cuenta de Hub para crear las etiquetas o Tags de la imagen.

# Para correr la aplicación

podman run -p 8081:8081 joseluisvb/diploCloudGeoService:1.0

# Tasks & Pipelines

This project use Tekton as CI/CD tool. Common commands used for the automatism:

Git clone repository

tkn task start git-clone \
--param=url=https://github.com/urielhdez/diploCloudGeoService \
--param=deleteExisting="true" \
--workspace=name=output,claimName=shared-workspace \
--showlog

List directory

tkn task start list-directory \
--workspace=name=directory,claimName=shared-workspace \
--showlog

Build source code

tkn task start maven \
--param=GOALS="-B,-DskipTests,clean,package" \
--workspace=name=source,claimName=shared-workspace \
--workspace=name=maven-settings,config=maven-settings \
--showlog

Para los proyectos Java que usen el JDK 17, recomendamos hacer uso de esta imagen maven que te permitirá llevar a cabo la compilación, tendrás que proporcionar el párametro MAVEN_IMAGE con el siguiente valor: gcr.io/cloud-builders/maven:3.6.3-openjdk-17@sha256:c74c4d8f7b470c2c47ba3fcb7e33ae2ebd19c3a85fc78d7b40c8c9a03f873312

Build image

tkn task start buildah \
--param=IMAGE="docker.io/joseluisvb/diploCloudGeoService:v3" \
--param=TLSVERIFY="false" \
--workspace=name=source,claimName=shared-workspace \
--serviceaccount=tekton-pipeline \
--showlog

Deployment

tkn task start kubernetes-actions \
--param=script="kubectl apply -f https://raw.githubusercontent.com/brightzheng100/tekton-pipeline-example/master/manifests/deployment.yaml; kubectl get deployment;" \
--workspace=name=kubeconfig-dir,emptyDir=  \
--workspace=name=manifest-dir,emptyDir= \
--serviceaccount=tekton-pipeline \
--showlog

Integrated pipeline

tkn pipeline start pipeline-git-clone-build-push-deploy \
-s tekton-pipeline \
--param=repo-url=https://github.com/joseluisvb001/diploCloudGeoService \
--param=tag-name=main \
--param=image-full-path-with-tag=docker.io/joseluisvb/
--param=deployment-manifest=https://raw.githubusercontent.com/brightzheng100/tekton-pipeline-example/master/manifests/deployment.yaml \
--workspace=name=workspace,claimName=shared-workspace \
--workspace=name=maven-settings,config=maven-settings \
--showlog

Para más detalles sobre el uso de tekton en el proyecto, puede visitar la secciñon maifest.


# Test (en POSTMAN)

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

Estrategia de ramas Git

Se configura y establece la estrategia de ramas en GitHub para la ejecución de un proyecto con un líder y 6 colaboradores desarrolladores. Para ello se propone:

a)	Una rama  release para publicar y resguardar las versiones de la secuencia de liberaciones.
b)	Una rama main para almacenar el historial de publicación oficial, sobre la cual se deberá etiquetar todas las confirmaciones co un número de versión.
c)	Una rama dev o de desarrollo para integrar las funciones, la cual debe bifurcar a la rama release.
d)	Una rama de corrección hotfix que se bifurcará directamente de la rama main y la cual se debe fusionar con la rama main una vez que se alcanzó la corrección.
e)	Tres ramas feature que utilizarán la rama dev como rama primaria y sobre las cuales se coordinarán las nuevas funciones designadas a los diferentes desarrolladores; esto es, la rama dev y las ramas feature conforman el flujo de trabajo de ramas de función. Estas ramas serán coordinadas por los seis desarrolladores trabajando en parejas.

![image](https://github.com/JoseLuisVB001/diploCloudGeoService/assets/117409168/5242e9e4-acd5-4892-8a21-92feff2e2e8b)


# Referencias

Mongo Docker Official Image: https://hub.docker.com/_/mongo

Official Apache Maven documentation

Spring Boot Maven Plugin Reference Guide

Create an OCI image

Spring Web

Spring Data MongoDB

> cafaray: ___Project revision.___

