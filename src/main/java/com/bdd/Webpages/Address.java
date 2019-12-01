package com.bdd.Webpages;
import com.bdd.BasePage;
import com.bdd.Util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Address extends BasePage
{
    public Address(WebDriver driver) {
        super(driver);
    }

    By buttonProceedCheckout=By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]");

    public Boolean Proceed ( ) {
       try{
           waitVisibility(buttonProceedCheckout);
           click(buttonProceedCheckout);
           return true;
       }catch(Exception e)
       {
           Log.error(e.getMessage());
           return false;
       }


    }

}
