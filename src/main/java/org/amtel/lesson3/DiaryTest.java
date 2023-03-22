package org.amtel.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Random;

public class DiaryTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();  //скачали и добавили путь до драйвера
        ChromeOptions chromeOptions = new ChromeOptions();  //создали объект настройки драйвера
        chromeOptions.addArguments("--disable-notifications"); //добавили настройку по отключению нотификаций на сайте
        WebDriver driver = new ChromeDriver(chromeOptions);  //создали объект драйвера и передали в него как аргумент настройки

/*      Тут пример авторизации без использования Cookies
        driver.get("https://diary.ru/user/login");
        //ввели логин
        WebElement loginForm = driver.findElement(By.id("loginform-username"));
        loginForm.sendKeys("dazz77665544332211");
        //ввели пароль
        driver.findElement(By.id("loginform-password")).sendKeys("43214321Aa");
        //переключились в frame (сайт в сайте)
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
        //клик по капче
        driver.findElement(By.xpath("//div[@class=\"recaptcha-checkbox-border\"]")).click();
        //переключаемся обратно во внешний сайт
        driver.switchTo().parentFrame();
        //клик по кнопке "Войти"
        driver.findElement(By.id("login_btn")).click();
*/

//      Тут пример авторизации С использованием Cookies
        driver.get("https://diary.ru/");
        //добавляем куки в браузер для авторизации
        Cookie cookie = new Cookie("_identity_", "b93f798fbdd5be8aa711c4855f27b1c7332f4d4d2ec93356f6a555bf08c730afa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3577957%2C%22OqeuUnyXgCBdXbp203Daff2u-iXn2Fye%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        //удаляем куки из браузера для логаута
        //driver.manage().deleteCookieNamed("_identity_");
        //driver.manage().deleteCookieNamed("_session");
        //driver.navigate().refresh();

        driver.findElement(By.id("writeThisDiary")).click();
        String postTitle = "ttttttt111111" + new Random().nextInt(1000);
        driver.findElement(By.id("postTitle")).sendKeys(postTitle);
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("ttttttt111111!");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();

        //driver.findElement(By.xpath(String.format("//a[text='%s']", postTitle))).click();
        List<WebElement> postTitles = driver.findElements(By.xpath("//a[@class='title'] "));
        postTitles.stream().filter(p -> p.getText().equals(postTitle)).findFirst().get().click();







        Thread.sleep(25000);
        //diary.ru auth - art.murtazov@gmail.com
        //dazz77665544332211
        //43214321Aa
        driver.quit();
    }
}
