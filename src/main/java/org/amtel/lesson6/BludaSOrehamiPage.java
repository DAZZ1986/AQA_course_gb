package org.amtel.lesson6;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BludaSOrehamiPage extends BasePage {

    public BludaSOrehamiPage(WebDriver driver) {
        super(driver);
    }

/*
    //вытаскиваем весь список рецептов на странице
    @FindBy(xpath = "//a[contains(@href, '/recipes/')]/ancestor::div[@class='name']/a")
    private List<WebElement> bludaSOrehamiList;

    public BludaSOrehamiPage selectSize(String recipe) {
        bludaSOrehamiList.stream().filter(r -> r.getText().contains(recipe)).findFirst().get().click();
        return this;
    }
*/


    //наводим мышку на имя рецепта
    @FindBy(xpath = "//a[@href='/recipes/kantuchchi']/ancestor::div[@class='img']")
    private WebElement moveMouseOnRecipeElement;
    //кликаем на конкретный рецепт
    @FindBy(xpath = "//a[contains(@href, '/recipes/')]/ancestor::div[@class='name']/a[contains(text(), 'Кантуч')]")
    private WebElement recipeElement;

    public SuccessMoveToRecipeBludaSOrehami moveMouseToRecipeAndClickOnRecipe() throws InterruptedException {
        actions.moveToElement(moveMouseOnRecipeElement)
                .build()
                .perform();
        Thread.sleep(2000);
        //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", recipeElement);
        moveMouseOnRecipeElement.click();

        return new SuccessMoveToRecipeBludaSOrehami(driver);
    }









}
