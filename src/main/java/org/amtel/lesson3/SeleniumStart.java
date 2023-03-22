package org.amtel.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumStart {

    public static void main(String[] args) throws InterruptedException {
        //Ниже вручную скачали chromedriver под мою версию Chrome браузера.
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://google.com/");

        Thread.sleep(3000);
        chromeDriver.quit();  //закрывает браузер
        //driver.close(); //закрывает вкладку

        //Ниже чтобы не мучиться бесконечно с перебором версий драйвера и Хрома, тк
        //Хром обновляется сам, будем работать через менеджер, который будет сам
        //скачивать нужню версию драйвра под версию моего Хром браузера и сам
        //пропишет путь до драйвера на пк.
        WebDriverManager.firefoxdriver().setup();
        WebDriver firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://ya.ru/");

        Thread.sleep(3000);
        firefoxDriver.quit();  //закрывает браузер






    }
}
