package ru.praktikum.diplom_3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.praktikum.diplom_3.clients.UserClient;
import ru.praktikum.diplom_3.dataprovider.UserProvider;
import ru.praktikum.diplom_3.pageobject.AccountPage;
import ru.praktikum.diplom_3.pageobject.Header;
import ru.praktikum.diplom_3.pageobject.LoginPage;
import ru.praktikum.diplom_3.pageobject.MainPage;
import ru.praktikum.diplom_3.pojo.CreateUserRequest;

public class AccountTest extends BaseTest{
    private static UserClient userClient ;
    private static CreateUserRequest createUserRequest;
    private static String accessToken;

    @BeforeClass
    @DisplayName("Create user")
    public static void setUp(){
        userClient = new UserClient();
        createUserRequest = UserProvider.getRandomCreateUserRequestValidData();
        accessToken = userClient.createUser(createUserRequest)
                .extract().jsonPath().get("accessToken");
    }

    @Test
    @DisplayName("Successful transition to personal account")
    public void successTransitionToAccount(){
        MainPage mainPage = new MainPage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        AccountPage accountPage = new AccountPage(webDriver);
        mainPage.clickButtonAccountEntry();
        loginPage.fillLoginForm(createUserRequest);
        header.clickButtonAccount();
        Assert.assertEquals(true, accountPage.displayTextAboutPage());
    }

    @Test
    @DisplayName("Successful transition to constructor")
    public void successTransitionToConstructorClickButton(){
        MainPage mainPage = new MainPage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        mainPage.clickButtonAccountEntry();
        loginPage.fillLoginForm(createUserRequest);
        header.clickButtonAccount();
        header.clickButtonConstructor();
        Assert.assertEquals(true, mainPage.displayTitleConstructor());
    }

    @Test
    @DisplayName("Successful transition to constructor")
    public void successTransitionToConstructorClickLogo(){
        MainPage mainPage = new MainPage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        mainPage.clickButtonAccountEntry();
        loginPage.fillLoginForm(createUserRequest);
        header.clickButtonAccount();
        header.clickLogoStellarBurger();
        Assert.assertEquals(true, mainPage.displayTitleConstructor());
    }

    @Test
    @DisplayName("Successful logout")
    public void successLogOut(){
        MainPage mainPage = new MainPage(webDriver);
        Header header = new Header(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        AccountPage accountPage = new AccountPage(webDriver);
        mainPage.clickButtonAccountEntry();
        loginPage.fillLoginForm(createUserRequest);
        header.clickButtonAccount();
        accountPage.clickButtonLogOut();
        Assert.assertEquals(true, loginPage.displayTitleEnter());
    }

    @AfterClass
    @DisplayName("Delete user")
    public static void cleanUp(){
        if (accessToken != null) {
            userClient.deleteUser((accessToken));
        }
    }
}