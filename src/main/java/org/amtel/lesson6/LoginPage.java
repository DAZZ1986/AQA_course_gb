package org.amtel.lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private final String emailIdLocator = "loginform-email";

    @FindBy(id = emailIdLocator)
    private WebElement emailField;

    @FindBy(id = "loginform-password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@name='login-button']")
    private WebElement signInButton;



    private final String hFourOnMainPageLocator = "//h4[text()='Рецепты блюд по типу']";

    @FindBy(xpath = hFourOnMainPageLocator)
    private WebElement hFourOnMainPage;



    public MainPage login(String login, String password) throws InterruptedException {
        //webDriverWait.until(ExpectedConditions.visibilityOf(emailField));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id(emailIdLocator)));
        emailField.sendKeys(login);
        passwordField.sendKeys(password);
        signInButton.click();
        Thread.sleep(3000);
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(hFourOnMainPageLocator)));
        return new MainPage(driver);
    }








}
