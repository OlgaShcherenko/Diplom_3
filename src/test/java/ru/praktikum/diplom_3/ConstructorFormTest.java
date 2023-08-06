package ru.praktikum.diplom_3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.diplom_3.pageobject.MainPage;

public class ConstructorFormTest extends BaseTest {

    @Test
    @DisplayName("Successful switch to section Buns")
    public void switchOnSectionBuns() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickButtonFillings();
        mainPage.clickButtonBuns();
        Assert.assertEquals("Булки", mainPage.getActiveButton());
    }

    @Test
    @DisplayName("Successful switch to section Sauces")
    public void switchOnSectionSauces() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickButtonSauces();
        Assert.assertEquals("Соусы", mainPage.getActiveButton());
    }

    @Test
    @DisplayName("Successful switch to section Fillings")
    public void switchOnSectionFillings() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickButtonFillings();
        Assert.assertEquals("Начинки", mainPage.getActiveButton());
    }
}