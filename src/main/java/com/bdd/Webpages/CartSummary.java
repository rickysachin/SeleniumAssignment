package com.bdd.Webpages;
import com.bdd.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;


public class CartSummary extends BasePage
{
    public CartSummary(WebDriver driver) {
        super(driver);
    }
    By linkYourlaga=By.xpath("//a[@title='My Store']");
    By buttonAddTocart=By.name("Submit");
    By linkProceedCheckout=By.xpath("//span[contains(text(),'Proceed to checkout')]");
    By spanProceedCheckout=By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");

    public void addtocart () {
        waitVisibility(buttonAddTocart);
        driver.findElement(buttonAddTocart).click();
    }

    public Boolean proceedToChecout ()  {
       try {
           waitVisibility(linkProceedCheckout);
           driver.findElement(linkProceedCheckout).click();
           waitVisibility(spanProceedCheckout);
           return true;
       }catch(Exception e)
       {
           return false;
       }
    }

    public void confirmCheckout()
    {

        driver.findElement(spanProceedCheckout).click();
    }
    public void isPresentYourlaga () {
        waitVisibility(linkYourlaga);
    }
}
