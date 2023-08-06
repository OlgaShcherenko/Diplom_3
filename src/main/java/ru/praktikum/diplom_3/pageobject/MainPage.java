package ru.praktikum.diplom_3.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Локатор заголовка "Соберите бургер"
    private By titleConstructor = By.xpath(".//h1[text()='Соберите бургер']");

    //Локатор кнопки "Войти в аккаунт"
    private By buttonAccountEntry = By.xpath(".//button[text()='Войти в аккаунт']");

    //Локатор кнопки "Оформить заказ"
    private By buttonOrderCreate = By.xpath(".//button[text() = 'Оформить заказ']");

    //Локатор кнопки "Булки" конструктора бургера
    private By buttonBuns = By.xpath(".//span[text()='Булки']");

    //Локатор кнопки "Соусы" конструктора бургера
    private By buttonSauces = By.xpath(".//span[text()='Соусы']");

    //Локатор кнопки "Начинки" конструктора бургера
    private By buttonIFillings = By.xpath(".//span[text()='Начинки']");

    //Локатор активной кнопки конструктора бургера
    private By activeButton = By.xpath(".//div[contains(@class,'tab_tab_type_current')]");

    @Step("Method for clicking on button Account Entry")
    public void clickButtonAccountEntry() {
        webDriver.findElement(buttonAccountEntry).click();
    }

    @Step("Method for clicking on button Buns")
    public void clickButtonBuns() {
        webDriver.findElement(buttonBuns).click();
    }

    @Step("Method for clicking on button Sauces")
    public void clickButtonSauces() {
        webDriver.findElement(buttonSauces).click();
    }

    @Step("Method for clicking on button Fillings")
    public void clickButtonFillings() {
        webDriver.findElement(buttonIFillings).click();
    }

    @Step("Method for getting the active button of the constructor")
    public String getActiveButton() {
        return webDriver.findElement(activeButton).getText();
    }

    @Step("Method for checking displayed button Order Create")
    public boolean displayButtonOrderCreate() {
        return webDriver.findElement(buttonOrderCreate).isDisplayed();
    }

    @Step("Method for checking displayed title Constructor")
    public boolean displayTitleConstructor() {
        return webDriver.findElement(titleConstructor).isDisplayed();
    }
}