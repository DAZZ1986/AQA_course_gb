package org.amtel.l6Filters;

import org.amtel.lesson6.LoginPage;
import org.amtel.lesson6.MainMenuBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageTwo extends BasePageTwo {

    //авторизация
    @FindBy(xpath = "//li[@class='user-item']//a[@href='/site/login']")
    private WebElement signInButtonTwo;


    public MainPageTwo(WebDriver driverTwo) {
        super(driverTwo);
        //mainMenuBlockTwo = new MainMenuBlockTwo(driverTwo);
    }


    //public MainMenuBlockTwo mainMenuBlockTwo;

    public LoginPageTwo clickSignInButton() {
        signInButtonTwo.click();
        return new LoginPageTwo(driverSuper);
    }

}
