package org.amtel.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenuBlock extends BasePage {

    public MainMenuBlock(WebDriver driver) {
        super(driver);
    }







    @FindBy(xpath = "//a[@href='/category/po-ingredientam']")
    private WebElement poIngredientam;



    public PoIngredientamSubMenu hoverWomenButton() {
        actions.moveToElement(poIngredientam)
                .build()
                .perform();
        return new PoIngredientamSubMenu(driver);
    }






}
