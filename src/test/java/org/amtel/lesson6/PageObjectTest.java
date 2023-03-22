package org.amtel.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PageObjectTest {
    WebDriver driver;
    static ChromeOptions options;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--window-size=1350,1050");
        options.addArguments("--remote-allow-origins=*");
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver(options);
        driver.get("https://mmprod.ru/");
    }


    @Test
    void putTShirtToCartTest() throws InterruptedException {
    /* ��� �������� �� �������� ���� �� ������ ���������� void
        MainPage manePage = new MainPage(driver);
        manePage.clickSignInButton();
        new LoginPage(driver).login("kazahovartur7@gmail.com", "Aa43214321");
        new MainMenuBlock(driver).hoverWomenButton();
        new PoIngredientamSubMenu(driver).
    */

        // ��� �������� �������� ����� ������ ���������� ������ ����. ���
        new MainPage(driver).clickSignInButton()
                .login("kazahovartur7@gmail.com", "Aa43214321")
                .mainMenuBlock.hoverWomenButton()
                .clickBludaSOrehamiButton()
                .moveMouseToRecipeAndClickOnRecipe()
                .checkRecipePageSOrehami("https://mmprod.ru/recipes/kantuchchi");
        Thread.sleep(5000);
    }


    //����� ��:
    //������� ��� - MainPage
    //��� ����������� - LoginPage
    //������� ��� - MainPage
    //������ �� ���� "�� ������������" - MainMenuBlock
    //������� �� ������������ ��� "����� � �������" - PoIngredientamSubMenu
    //�������� �� ����� "��������" - BludaSOrehamiPage
    //Assertions ��� ����� "��������"



    @AfterEach
    void killBrouser() {
        driver.quit();
    }

}
