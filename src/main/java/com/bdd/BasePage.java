package com.bdd;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.bdd.Util.Log;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);

    }
    public void waitVisibility(By element) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }
    public void click(By element) {
        driver.findElement(element).click();
    }
    public String getText(By element) {
        return driver.findElement(element).getText();
    }
    public void enterText(By element,String text) {
        driver.findElement(element).sendKeys(text);
    }

    public Boolean isElementPresent(By element)
    {
        if(driver.findElements(element).size()>0)
            return true;
        else
            return false;
    }
    public void clickusingJavaScript(By element) {
        WebElement element1 =  driver.findElement(element);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element1);
    }

    public void clearText(By element)
    {
        driver.findElement(element).clear();
    }

    public String getTextForInputBox(By element) {
        return driver.findElement(element).getAttribute("value");
    }

    public void openURL(String url)
    {
        driver.get(url);
    }
}
