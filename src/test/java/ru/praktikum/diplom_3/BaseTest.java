package ru.praktikum.diplom_3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static ru.praktikum.diplom_3.config.AppConfig.APP_URL;

public class BaseTest {
    WebDriver webDriver;

    @Before
    public void unit() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(APP_URL);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}