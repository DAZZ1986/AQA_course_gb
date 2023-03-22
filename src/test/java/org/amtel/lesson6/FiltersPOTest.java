package org.amtel.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FiltersPOTest {
    WebDriver driverOne;  //это переменная начинает путешествовать, и в нее кладется driverSuper
    static ChromeOptions options;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--window-size=1350,1050");
    }
    @BeforeEach
    void initDriver() {
        driverOne = new ChromeDriver(options);
        driverOne.get("https://mmprod.ru/");
    }



    @Test
    void checkFilterPage() throws InterruptedException {
        new MainPage(driverOne).clickSignInButton();
        Thread.sleep(5000);


    }



    @AfterEach
    void killBrouser() {
        driverOne.quit();
    }

}
