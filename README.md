emp-service with RESTful Service and EJB3
=========================================

This is sample employee service project , exposing list, add, delete operations for employee.

This project demonstrated how implementation of RESTful web service can be exposed as EJB for consuming for other client projects which might not want to consume RESTful web services but want to depend on same business logic.

This design enables using same business logic exposed by RESTful web services and EJB as the same time.  Designing the right kind of interfaces is the key here.

example RESTful urls :

http://localhost:8080/emp-service/employees gives below json response:

[{"id":22,"name":"Sachin Tendulkar","city":"Mumbai","age":40},{"id":11,"name":"Sachin Bhosale","city":"Pune","age":30}]

