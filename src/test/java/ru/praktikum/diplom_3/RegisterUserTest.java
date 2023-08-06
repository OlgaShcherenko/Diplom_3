package ru.praktikum.diplom_3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.diplom_3.dataprovider.UserProvider;
import ru.praktikum.diplom_3.pageobject.LoginPage;
import ru.praktikum.diplom_3.pageobject.MainPage;
import ru.praktikum.diplom_3.pageobject.RegisterPage;
import ru.praktikum.diplom_3.pojo.CreateUserRequest;

public class RegisterUserTest extends BaseTest{

    @Test
    @DisplayName("Successful new user registration")
    public void successRegisterUserTest() {
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        RegisterPage registerPage = new RegisterPage(webDriver);
        CreateUserRequest createUserRequest = UserProvider.getRandomCreateUserRequestValidData();
        mainPage.clickButtonAccountEntry();
        loginPage.clickButtonRegister();
        registerPage.fillRegisterForm(createUserRequest);
        Assert.assertEquals(true, loginPage.displayTitleEnter());
    }

    @Test
    @DisplayName("Registration error when entering an incorrect password")
    public void errorRegisterUserTest() {
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        RegisterPage registerPage = new RegisterPage(webDriver);
        CreateUserRequest createUserRequest = UserProvider.getRandomCreateUserRequestInvalidData();
        mainPage.clickButtonAccountEntry();
        loginPage.clickButtonRegister();
        registerPage.fillRegisterForm(createUserRequest);
        Assert.assertEquals(true, registerPage.displayTextErrorPassword());
    }
}