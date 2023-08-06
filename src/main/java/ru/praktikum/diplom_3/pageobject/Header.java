package ru.praktikum.diplom_3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private WebDriver webDriver;

    public Header(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Локатор кнопки "Конструктор"
    private By buttonConstructor = By.xpath(".//*[text()= 'Конструктор']");

    //Локатор кнопки "Личный кабинет"
    private By buttonAccount = By.xpath(".//p[text()='Личный Кабинет']");

    //Локатор логотипа Stellar Burger
    private By logoStellarBurger = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");

    @Step("Method for clicking on button Constructor")
    public void clickButtonConstructor() {
        webDriver.findElement(buttonConstructor).click();
    }

    @Step("Method for clicking on button Account")
    public void clickButtonAccount() {
        webDriver.findElement(buttonAccount).click();
    }

    @Step("Method for clicking on logo Stellar Burger")
    public void clickLogoStellarBurger() {
        webDriver.findElement(logoStellarBurger).click();
    }
}