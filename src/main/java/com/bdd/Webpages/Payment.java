package com.bdd.Webpages;
import com.bdd.BasePage;
import com.bdd.Util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Payment extends BasePage
{
    public Payment(WebDriver driver) {
        super(driver);
    }
    By linkbankWire=By.xpath("//a[contains(text(),'Pay by bank wire')]");
    By spanConfirmOrder=By.xpath("//span[contains(text(),'I confirm my order')]");

    public Boolean clickBankwirePaymentMethod()
    {
        try
        {
            waitVisibility(linkbankWire);
            click(linkbankWire);
            return true;
        }
        catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }

    }
    public Boolean confirmOrder()
    {
        try
        {
            waitVisibility(spanConfirmOrder);
            click(spanConfirmOrder);
            return true;
        }
        catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }

    }
}
