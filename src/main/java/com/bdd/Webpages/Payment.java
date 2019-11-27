package com.bdd.Webpages;
import com.bdd.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Payment extends BasePage
{
    public Payment(WebDriver driver) {
        super(driver);
    }
    By linkbankWire=By.xpath("//a[contains(text(),'Pay by bank wire')]");
    By spanConfirmOrder=By.xpath("//span[contains(text(),'I confirm my order')]");

    public void clickPaymentMethod()
    {
        waitVisibility(linkbankWire);
        driver.findElement(linkbankWire).click();
    }
    public Boolean confirmOrder()
    {
        try {
            waitVisibility(spanConfirmOrder);

            driver.findElement(spanConfirmOrder).click();
            return true;
        }catch(Exception e)
        {
            return false;
        }

    }
}
