package ru.praktikum.diplom_3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver webDriver;

    public ForgotPasswordPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Локатор кнопки "Войти"
    private By buttonEnter = By.xpath(".//a[text()='Войти']");

    @Step("Method for clicking on button Enter")
    public void clickButtonEnter(){
        webDriver.findElement(buttonEnter).click();
    }
}
