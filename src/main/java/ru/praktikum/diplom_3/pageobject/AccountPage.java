package ru.praktikum.diplom_3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver webDriver;

    public AccountPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Локатор подзаголовка с текстом описания страницы
    private By textAboutPage = By.xpath("//p[text()='В этом разделе вы можете изменить свои персональные данные']");

    //Локатор кнопки "Выход"
    private By buttonLogOut = By.xpath("//button[text()='Выход']");

    @Step("Method for checking displayed text about page")
    public boolean displayTextAboutPage() {
        return webDriver.findElement(textAboutPage).isDisplayed();
    }

    @Step("Method for clicking on button Logout")
    public void clickButtonLogOut() {
        webDriver.findElement(buttonLogOut).click();
    }
}