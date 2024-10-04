# Proyecto Gasolieras

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=App-Gasolineras-Grupo3&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=App-Gasolineras-Grupo3)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=App-Gasolineras-Grupo3&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=App-Gasolineras-Grupo3)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=App-Gasolineras-Grupo3&metric=sqale_index)](https://sonarcloud.io/summary/new_code?id=App-Gasolineras-Grupo3)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=App-Gasolineras-Grupo3&metric=coverage)](https://sonarcloud.io/summary/new_code?id=App-Gasolineras-Grupo3)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=App-Gasolineras-Grupo3&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=App-Gasolineras-Grupo3)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=App-Gasolineras-Grupo3&metric=bugs)](https://sonarcloud.io/summary/new_code?id=App-Gasolineras-Grupo3)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=App-Gasolineras-Grupo3&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=App-Gasolineras-Grupo3)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=App-Gasolineras-Grupo3&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=App-Gasolineras-Grupo3)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=App-Gasolineras-Grupo3&metric=ncloc)](https://sonarcloud.io/summary/new_code?id=App-Gasolineras-Grupo3)

## Descripción del proyecto

Aplicación realizada en el proyecto integrado del Grado en Ingeniería Informática de la Universidad de Cantabria (Mención en Ingeniería del Software). En este proyecto se buscaba combinar los conocimientos adquiridos en distintas asignaturas para desarrollar una aplicación para dispositivos móviles a medida según las especificaciones de un cliente. Se engloba todo el proyecto desde la captura de requisitos y el diseño a la realización de la aplicación mediante una metodología ágil (Scrum), así como toda la documentación y pruebas del proceso de desarrollo.

Se trata de una aplicación Android que permite la consulta de los precios de combustibles en las distintas gasolineras de Cantabria, diseñada para facilitar la gestión de los repostajes a los transportistas. En la página principal se muestra un listado con los precios de todas las gasolineras, que pueden ser filtradas en función del precio y la distancia con respecto a la posición actual del vehículo. La información de las gasolineras también puede consultarse en una vista de detalle. Igualmente, permite que los transportistas comprueben su listado de convenios (gasolineras o franquicias con las cuales su empresa tiene algún tipo de descuento) y el histórico de respostajes.

## Diseño del sistema

Diagrama de la arquitectura Model-View-Presenter del sistema.

![](Docs/Models/Class_Diagram__Arquitectura.jpg)

## Habilidades y lenguajes

| Elemento	| Lenguajes					|
|--------------	|-----------------------------------------------|
| Android app	| Android Studio, Java				|
| Testing	| Gradle, Espresso, JUnit, Mockito		| 
| Arquitectura	| Arquitectura MVP (Model-View-Presenter)	|