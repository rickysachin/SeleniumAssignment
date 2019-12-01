package com.bdd.Webpages;
import com.bdd.BasePage;
import com.bdd.Util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Shipping extends BasePage
{
    public Shipping(WebDriver driver) {
        super(driver);
    }


    By checkTerms=By.cssSelector("input[id='cgv']");
    By buttonProceedCheckout=By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]");


    public Boolean checkTerms()
    {
        try {
            click(checkTerms);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }
    public Boolean clickProceed()
    {
        try
        {
            click(buttonProceedCheckout);
            return true;
        }
        catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }
}
