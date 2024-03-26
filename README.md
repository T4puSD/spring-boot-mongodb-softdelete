## Soft Delete Repository Demo Project
*A demo project to show how to implement:*
* Soft delete feature with mongodb and spring data jpa.
* Auditing feature available by MongoDB Auditing Framework

### Soft delete feature is implemented at 2 stage
1. Defining unique partial index at document level   
https://github.com/T4puSD/spring-boot-demo-mongodb-softdelete/blob/bea63de15b825b9b65041136d315e1f3c6d5be08/src/main/java/com/tapusd/demomongoref/domain/Currency.java#L10-L18
2. Defining Soft Delete Repository and utilizing it   
https://github.com/T4puSD/spring-boot-demo-mongodb-softdelete/blob/bea63de15b825b9b65041136d315e1f3c6d5be08/src/main/java/com/tapusd/demomongoref/repository/SoftDeleteRepository.java#L11-L32   
https://github.com/T4puSD/spring-boot-demo-mongodb-softdelete/blob/bea63de15b825b9b65041136d315e1f3c6d5be08/src/main/java/com/tapusd/demomongoref/repository/CurrencyRepository.java#L5-L6

## How to run the project
To run the project we first need to generate the `MapStruct` annotated
mapper class implementation. 

For that run the following command first `mvn clean install` to generate the
`MapStruct` implementations.
