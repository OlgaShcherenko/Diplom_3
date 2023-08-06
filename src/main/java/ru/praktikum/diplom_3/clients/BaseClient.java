package ru.praktikum.diplom_3.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static ru.praktikum.diplom_3.config.AppConfig.APP_URL;

public class BaseClient {
    protected RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(APP_URL)
                .build();
    }
}