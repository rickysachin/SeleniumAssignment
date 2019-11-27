package com.bdd.Webpages;
import com.bdd.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage
{
    public HomePage (WebDriver driver) {
        super(driver);
    }

    By textSearch=By.id("search_query_top");
    By buttonSearch=By.name("submit_search");

    By linkImage=By.cssSelector("a[class='product_img_link']");
    By buttonAddTocart=By.name("Submit");
    By linkLogin=By.xpath("//a[@class='login']");

    public Boolean enterText (String text)
    {
        try {
            waitVisibility(textSearch);
            driver.findElement(textSearch).sendKeys(text);
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    public int clickSearch ()
    {
        waitVisibility(buttonSearch);
        driver.findElement(buttonSearch).click();
        waitVisibility(linkImage);
        return (driver.findElements(linkImage).size());

    }
    public Boolean clickInStock ()
    {

        try{
            WebElement element =  driver.findElement(linkImage);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", element);
            waitVisibility(buttonAddTocart);
            return true;
          }catch(Exception e)
        {
            return false;
        }
    }

    public void clickLogin () {
        waitVisibility(linkLogin);
        driver.findElement(linkLogin).click();
    }
}
