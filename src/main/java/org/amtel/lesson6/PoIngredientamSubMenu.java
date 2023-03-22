package org.amtel.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PoIngredientamSubMenu extends BasePage {


    public PoIngredientamSubMenu(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//ul[contains(@class, 'scrolling-menu')]//a[@href='/category/orehi']")
    private WebElement bludaSOrehami;



    public BludaSOrehamiPage clickBludaSOrehamiButton() {
        bludaSOrehami.click();
        return new BludaSOrehamiPage(driver);
    }



}
