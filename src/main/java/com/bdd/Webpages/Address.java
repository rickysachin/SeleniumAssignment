package com.bdd.Webpages;
import com.bdd.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Address extends BasePage
{
    public Address(WebDriver driver) {
        super(driver);
    }

    By buttonProceedCheckout=By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]");
    public void Proceed ( ) {
        waitVisibility(buttonProceedCheckout);
        driver.findElement(buttonProceedCheckout).click();
    }

}
