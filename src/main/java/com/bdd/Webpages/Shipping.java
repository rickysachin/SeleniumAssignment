package com.bdd.Webpages;
import com.bdd.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Shipping extends BasePage
{
    public Shipping(WebDriver driver) {
        super(driver);
    }


    By checkTerms=By.xpath("//input[@id='cgv']");
    By buttonProceedCheckout=By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]");


    public void checkTerms()
    {
        driver.findElement(checkTerms).click();
    }
    public void clickProceed()
    {
        driver.findElement(buttonProceedCheckout).click();
    }
}
