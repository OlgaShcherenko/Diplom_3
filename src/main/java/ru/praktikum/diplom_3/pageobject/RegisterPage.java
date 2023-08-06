package ru.praktikum.diplom_3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.diplom_3.pojo.CreateUserRequest;

public class RegisterPage {
    private WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Локатор поля ввода "Имя"
    private By fieldName = By.xpath(".//label[text()='Имя']/parent::div/input");

    //Локатор поля ввода "Email"
    private By fieldEmail = By.xpath(".//label[text()='Email']/parent::div/input");

    //Локатор поля ввода "Пароль"
    private By fieldPassword = By.xpath(".//label[text()='Пароль']/parent::div/input");

    //Локатор кнопки "Зарегистрироваться"
    private By buttonRegister = By.xpath(".//button[text()='Зарегистрироваться']");

    //Локатор кнопки "Войти"
    private By buttonEnter = By.xpath(".//a[text()='Войти']");

    //Локатор текста ошибки при вводе некорректного пароля
    private By textErrorPassword = By.xpath(".//p[text()='Некорректный пароль']");

    @Step("Method for clicking on button Register")
    public void clickButtonRegister() {
        webDriver.findElement(buttonRegister).click();
    }

    @Step("Method for clicking on button Enter")
    public void clickButtonEnter() {
        webDriver.findElement(buttonEnter).click();
    }

    @Step("Method for filling the field Name")
    public void fillFieldName(String name) {
        webDriver.findElement(fieldName).sendKeys(name);
    }

    @Step("Method for filling the field Email")
    public void fillFieldEmail(String email) {
        webDriver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Method for filling the field Password")
    public void fillFieldPassword(String password) {
        webDriver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Method for checking displayed text of error")
    public boolean displayTextErrorPassword() {
        return webDriver.findElement(textErrorPassword).isDisplayed();
    }

    @Step("Method for filling register form")
    public void fillRegisterForm(CreateUserRequest createUserRequest) {
        fillFieldName(createUserRequest.getName());
        fillFieldEmail(createUserRequest.getEmail());
        fillFieldPassword(createUserRequest.getPassword());
        clickButtonRegister();
    }
}