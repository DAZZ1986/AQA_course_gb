package org.amtel.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SuccessMoveToRecipeBludaSOrehami extends BasePage {
    public SuccessMoveToRecipeBludaSOrehami(WebDriver driver) {
        super(driver);
    }


    //private final String hOneNameRecipeLocator = "//h1[text()='Рецепт кантуччи']";
    //private final String hOneNameRecipeLocator = "//h4[@class='black_title']";
    List<WebElement> sharedBtn = driver.findElements(By.xpath("//span[text()='ВКонтакте']")); //тут не
    //добавляются элементы в лист по локатору, как следствие на след строке кода ловим ошибку тк в
    //стринге нулл.
    //String expectTwoTextShared = String.valueOf(sharedBtn.get(0));


    //@FindBy(xpath = hOneNameRecipeLocator)
    //private WebElement hOneNameRecipe;

    public SuccessMoveToRecipeBludaSOrehami checkRecipePageSOrehami(String expectedUrlRecipe) throws InterruptedException {
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(sharedBtn.get(0)))));
        //Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrlRecipe, url);
        //Assertions.assertEquals(expectTwoTextShared, "ВКонтакте");
        return this;
    }

}
