# Swagger Test Codes

Swagger is rest api documentation framework.This repository contains spring boot and jax-rs code examples

## Spring Boot

Following dependancies used for documentation geneartion with spring boot.

```xml
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.6.1</version>
</dependency>
        
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.6.1</version>
</dependency>
```

## JAX-RS (reast-easy)

For jax-rs project we need to deploy swagger ui sperately. We can generate swagger.json file from the jax-rs application. Using swagger.json url we can generate documenttion with seprately deployed swagger ui. 

[I have used this user guide to create this sample project](https://github.com/swagger-api/swagger-core/wiki/Swagger-Core-RESTEasy-2.X-Project-Setup-1.5)

Following dependancies used for documentation geneartion with jax-rs(rest-easy).

```xml
<dependency>
  <groupId>io.swagger</groupId>
  <artifactId>swagger-jaxrs</artifactId>
  <version>1.5.0</version>
</dependency>
```
