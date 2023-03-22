package org.amtel.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfishaTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://afisha.ru/");

        driver.findElement(By.xpath("//input[@placeholder='Событие, актер, место']")).sendKeys("Брат");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Брат']")));
        //webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Брат']")))); //это просто вариант который нам не подойдет
        driver.findElement(By.xpath("//a[@title='Брат']")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //это просто вариант который нам не подойдет


        Thread.sleep(25000);
        driver.quit();
    }
}
