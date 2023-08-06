package ru.praktikum.diplom_3;


import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import ru.praktikum.diplom_3.clients.UserClient;
import ru.praktikum.diplom_3.dataprovider.UserProvider;
import ru.praktikum.diplom_3.pageobject.*;
import ru.praktikum.diplom_3.pojo.CreateUserRequest;

public class LoginTest extends BaseTest{
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
    @DisplayName("Successful authorization on the button on the main page")
    public void successLogInThrowMainPage(){
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        mainPage.clickButtonAccountEntry();
        loginPage.fillLoginForm(createUserRequest);
        Assert.assertEquals(true, mainPage.displayButtonOrderCreate());
    }

    @Test
    @DisplayName("Successful authorization on the button on the header")
    public void successLogInThrowHeader(){
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        Header header = new Header(webDriver);
        header.clickButtonAccount();
        loginPage.fillLoginForm(createUserRequest);
        Assert.assertEquals(true, mainPage.displayButtonOrderCreate());
    }

    @Test
    @DisplayName("Successful authorization on the button on the register page")
    public void successLogInThrowRegisterPage(){
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        RegisterPage registerPage = new RegisterPage(webDriver);
        mainPage.clickButtonAccountEntry();
        loginPage.clickButtonRegister();
        registerPage.clickButtonEnter();
        loginPage.fillLoginForm(createUserRequest);
        Assert.assertEquals(true, mainPage.displayButtonOrderCreate());
    }

    @Test
    @DisplayName("Successful authorization on the button on the forgot-password page")
    public void successLogInThrowForgotPasswordPage(){
        MainPage mainPage = new MainPage(webDriver);
        LoginPage loginPage = new LoginPage(webDriver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(webDriver);
        mainPage.clickButtonAccountEntry();
        loginPage.clickButtonRestorePassword();
        forgotPasswordPage.clickButtonEnter();
        loginPage.fillLoginForm(createUserRequest);
        Assert.assertEquals(true, mainPage.displayButtonOrderCreate());
    }

    @AfterClass
    @DisplayName("Delete user")
    public static void cleanUp(){
        if (accessToken != null) {
            userClient.deleteUser((accessToken));
        }
    }
}