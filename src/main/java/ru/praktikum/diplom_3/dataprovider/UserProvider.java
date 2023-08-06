package ru.praktikum.diplom_3.dataprovider;

import org.apache.commons.lang3.RandomStringUtils;
import ru.praktikum.diplom_3.pojo.CreateUserRequest;

public class UserProvider {
    public static CreateUserRequest getRandomCreateUserRequestValidData() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setEmail(RandomStringUtils.randomAlphabetic(6) + "@test.com");
        createUserRequest.setPassword(RandomStringUtils.randomAlphabetic(6));
        createUserRequest.setName(RandomStringUtils.randomAlphabetic(6));
        return createUserRequest;
    }

    public static CreateUserRequest getRandomCreateUserRequestInvalidData() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setEmail(RandomStringUtils.randomAlphabetic(6) + "@test.com");
        createUserRequest.setPassword(RandomStringUtils.randomAlphabetic(3));
        createUserRequest.setName(RandomStringUtils.randomAlphabetic(6));
        return createUserRequest;
    }
}