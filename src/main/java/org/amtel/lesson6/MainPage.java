package org.amtel.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MainPage extends BasePage {

    //авторизация
    @FindBy(xpath = "//li[@class='user-item']//a[@href='/site/login']")
    private WebElement signInButton;


    public MainPage(WebDriver driver) {
        super(driver);
        mainMenuBlock = new MainMenuBlock(driver);
    }


    public MainMenuBlock mainMenuBlock;

    public LoginPage clickSignInButton() {
        signInButton.click();
        return new LoginPage(driver);
    }


}
