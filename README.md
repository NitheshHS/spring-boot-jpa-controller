# spring-boot-jpa-controller

API
Base url: http://localhost:8880/api

GET /employees :- list all the employees in mySQL DB

POST /employees :- To create new employee 
Payload:-
{
"first_name":"String",
"last_name":"String",
"email":"String"
}

PUT /employees/{employeeID} :- Update the existing employee in mysql DB
Payload:-
{
"first_name":"String",
"last_name":"String",
"email":"String"
}

DELETE /employees/{employeeID} :- delete employee


