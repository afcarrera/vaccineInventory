# vaccineInventory
***

## Información
***
Registro de vacunas.
## Tecnologías
***
* [Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html): Version 11
* [Spring Boot](https://spring.io/projects/spring-boot): Version 2.6.7
* [IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/): Community Edition 2022.1
* [PostgreSQL](https://www.postgresql.org/docs/9.3/release-9-3-2.html): Version 9.3.2

## Instalación
***
Comandos recomendados para instalación en plataformas Windows. 
```
> git clone https://github.com/afcarrera/vaccineInventory
> cd VaccineInventory
> cd database
> psql -U postgres
> \i 'create-database-vaccine_inventory.sql'
> \i 'create-tables-vaccine_inventory.sql'
> \i 'insert-vaccine_inventory-data.sql'
> \q
> cd..
> cd oauth-authorization-server
> mvnw spring-boot:run 
> cd..
> cd vaccine-inventory
> mvnw spring-boot:run 
```

## Uso
***
La aplicación responde a lo planteado por las preguntas de kruger con sus respectivas validaciones, su documentación se encuentra en [http://localhost:9000/swagger-ui.html](#)
Los datos de entrada necesarios para uso del API son:
| Entidad | Variable | Posibles Valores |
| --- | --- | --- |
| phone | type | CON, CEL |
| employee | vaccinationStatusId | V, N |
| vaccination | doseId | 1S, 2S, 1AZ, 2AZ, 3AZ, 1P, 2P, 3P, 1JJ, 2JJ |
| vaccine | type | S, AZ, P, JJ |
El detalle de los endpoint es el siguiente.
### POST
[/employee](#) 
**Request**
```
{
    "userId" : "2", 
    "identification" : "123456789",
    "firstName" :"Alberto",
    "secondName" :"Francisco",
    "firstSurname" :"Quito",
    "secondSurname": "Ecuador",
    "email":"acarrera@mail.com"
}
```
[/employee/{employeeId}/phone](#)   
**Request**
```
{
    "type" : "CON",
    "number" : "2022123312"
}
```
[/employee/{employeeId}/address](#)  
**Request**
```
{
    "description" : "calle 123 esquina"
}
```
### PATCH
[/employee/{employeeId}](#) 
**Request**
```
{
    "vaccinationStatusId" :"V",
    "vaccinations" : [
        {
            "doseId" : "1JJ",
            "date" : "2021-04-01"
        },
        {
            "doseId" : "2JJ",
            "date" : "2021-09-01"
        }
    ],
    "birthdayDate" :"1994-09-25"
}
```
### GET ALL
[/employee](#)
### GET BY ID
[/employee/{employeeId}](#) 

[/employee/vaccionation-by-date?startDate={startDate}&endDate={endDate}](#)

[/employee/vaccionation-by-status/{status}](#)

[/employee/vaccionation-by-type/{type}](#) 
