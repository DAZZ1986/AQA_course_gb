package org.amtel.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.amtel.lesson4.DZ.Triangle;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AfishaTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String AFISHA_BASE_URL = "https://afisha.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(AFISHA_BASE_URL);
    }




    @Test
    void likeMovieTest() throws InterruptedException {
        //Thread.sleep(5000);
        //driver.findElement(By.xpath("//button[text()='���������� �����']")).click();
        //Thread.sleep(20000);

        //���� ���� �� ����������� ������ � ��������
        webDriverWait.until(d -> d.findElements(By.xpath(
                "//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]/h2")).size() > 0);
        //���� � ��������� ������ � ��������
        List<WebElement> filmsList = driver.findElements(By.xpath(
                "//a[@data-test='LINK ITEM-NAME ITEM-URL' and contains(@href, 'movie')]/h2"));

        //������� �� ������ �����
        //filmsList.get(0).getText().equals("���������"); //������� ������ 1 - ������
        //filmsList.stream().filter(f -> f.getText().contains("���������")).findFirst().get().click(); //������� ������ ����� �������������, ������������ �� ������ ���������� �� ���� ������
        filmsList.get(0).click(); //� ����� ������� �� ������ ����������, �� ��� ����������
        /*
        for (WebElement item: filmsList) {
            if (item.isDisplayed()) {
                webDriverWait.until(ExpectedConditions.visibilityOf(item)).click();
            }
        }*/
        /*for (WebElement item: filmsList) {
            if (webDriverWait.until(ExpectedConditions.elementToBeClickable(item))) {
                item.click();
            }
        }*/

        //�� ��� � ������� ���� ���� ����������� ������ "����"
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")));
        //������� �� ������ "����"
        driver.findElement(By.xpath(
                "//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']")).click();
        //��������� � iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        //���� ����� �������� ���� � ������������
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        //��������� ��� ����� ����������� ���������
        Assertions.assertEquals(true, driver.findElement(By.id("login")).isDisplayed());

    }


    @Test
    void hoverCinemaButtonAndClickOkkoLinkTest() throws InterruptedException {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(
                "//button[text()='�����������']")));
        Thread.sleep(5000);

        actions.moveToElement(driver.findElement(By.xpath("//a[text()='����']")))
                .clickAndHold(driver.findElement(By.xpath("//a[text()='����']")))
                .build()
                .perform();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//header//a[text()='����� ������ � Okko']")).click();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.afisha.ru/movie/okko-soon/");

        ((JavascriptExecutor)driver).executeScript("Let element = document.evaluate(\"//div[@data-test='HONEY-AD AD-ad_2']\", " +
                "document, null, element.singleNodeValue.remove()");
        Thread.sleep(5000);





    }












    @AfterEach
    void quitBrowser() {
        driver.quit();
    }


}
