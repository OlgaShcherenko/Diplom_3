package ru.praktikum.diplom_3.clients;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.praktikum.diplom_3.pojo.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseClient {
    public static final String CREATE_USER_PATH = "/api/auth/register";
    public static final String LOGIN_USER_PATH = "/api/auth/login";
    public static final String DATA_USER_PATH = "/api/auth/user";

    @Step("User creation request")
    public ValidatableResponse createUser(CreateUserRequest createUserRequest) {
        return given()
                .spec(getSpec())
                .body(createUserRequest)
                .when()
                .post(CREATE_USER_PATH)
                .then();
    }

    @Step("User delete request")
    public void deleteUser(String accessToken) {
        given()
                .header("authorization", accessToken)
                .spec(getSpec())
                .when()
                .delete(DATA_USER_PATH);
    }
}