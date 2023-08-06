package ru.praktikum.diplom_3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.diplom_3.pojo.CreateUserRequest;

public class LoginPage {
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Локатор заголовка "Вход"
    private By titleEnter = By.xpath("//h2[contains(text(),'Вход')]");

    //Локатор поля ввода "Email"
    private By fieldEmail = By.xpath(".//label[text()='Email']/parent::div/input");

    //Локатор поля ввода "Пароль"
    private By fieldPassword = By.xpath(".//label[text()='Пароль']/parent::div/input");

    //Локатор кнопки "Войти"
    private By buttonEnter = By.xpath(".//button[text()='Войти']");

    //Локатор кнопки "Зарегистрироваться"
    private By buttonRegister = By.xpath("//*[text()='Зарегистрироваться']");

    //Локатор кнопки "Восстановить пароль"
    private By buttonRestorePassword = By.xpath(".//a[text()='Восстановить пароль']");

    @Step("Method for checking displayed title")
    public boolean displayTitleEnter() {
        return webDriver.findElement(titleEnter).isDisplayed();
    }

    @Step("Method for clicking on button Enter")
    public void clickButtonEnter() {
        webDriver.findElement(buttonEnter).click();
    }

    @Step("Method for clicking on button Register")
    public void clickButtonRegister() {
        webDriver.findElement(buttonRegister).click();
    }

    @Step("Method for clicking on button Restore Password")
    public void clickButtonRestorePassword() {
        webDriver.findElement(buttonRestorePassword).click();
    }

    @Step("Method for filling the field Email")
    public void fillFieldEmail(String email) {
        webDriver.findElement(fieldEmail).sendKeys(email);
    }

    @Step("Method for filling the field Password")
    public void fillFieldPassword(String password) {
        webDriver.findElement(fieldPassword).sendKeys(password);
    }

    @Step("Method for filling authorization form")
    public void fillLoginForm(CreateUserRequest createUserRequest) {
        fillFieldEmail(createUserRequest.getEmail());
        fillFieldPassword(createUserRequest.getPassword());
        clickButtonEnter();
    }
}