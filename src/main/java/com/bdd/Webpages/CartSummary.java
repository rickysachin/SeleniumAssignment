package com.bdd.Webpages;
import com.bdd.BasePage;
import com.bdd.Util.Log;
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

    By buttonAddTocart=By.name("Submit");
    By linkProceedCheckout=By.xpath("//span[contains(text(),'Proceed to checkout')]");
    By spanProceedCheckout=By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]");

    public Boolean addtocart () {
        try
        {
            waitVisibility(buttonAddTocart);
            click(buttonAddTocart);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }

    }

    public Boolean proceedToCheckout()  {
        try
        {
            waitVisibility(linkProceedCheckout);
            click(linkProceedCheckout);

            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }

    public Boolean confirmCheckout()
    {
        try
        {
            click(spanProceedCheckout);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }
    public Boolean isPresentProceedCheckout () {
        try
        {
            waitVisibility(spanProceedCheckout);
            return true;
        } catch (Exception e) {
            Log.error(e.getMessage());
            return false;
        }
    }
}
