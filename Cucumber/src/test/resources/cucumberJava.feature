Feature: CucumberJava
Description: HISTORIA DE USUARIO HU-01

Scenario: Como usuario quiero consultar la lista de empleos para poder identificar los empleos disponibles en diferentes localidades.

Given Que estoy en el menu empleados debo ingresar una(s) palabra(s) en el cuadro de  Keywords y Location 
When necesito mostrar los empleos
Then se mostrara una grilla con los resultados de los empleos disponibles


