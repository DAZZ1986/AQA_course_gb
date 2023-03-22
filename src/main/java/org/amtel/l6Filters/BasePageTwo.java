package org.amtel.l6Filters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageTwo {
    WebDriver driverSuper;
    WebDriverWait webDriverWait;
    Actions actions;

    public BasePageTwo(WebDriver driverR) {
        this.driverSuper = driverR;
        webDriverWait = new WebDriverWait(driverR, Duration.ofSeconds(5));
        actions = new Actions(driverR);
        PageFactory.initElements(driverR, this);
    }
}
