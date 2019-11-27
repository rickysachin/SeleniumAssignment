package com.bdd.Webpages;
import com.bdd.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderConfirmation extends BasePage
{
    public OrderConfirmation(WebDriver driver) {
        super(driver);
    }

    By divOrderSummary=By.cssSelector("div[class='box']");
    By linkbacktoSummary=By.xpath("//a[@class='button-exclusive btn btn-default']");
    By tdOrderLink=By.xpath("//tr[contains(@class,'first_item')]//td[@class='history_link bold footable-first-column']");

    public String extractOrderReference()
    {

        waitVisibility(divOrderSummary);
        String text=driver.findElement(divOrderSummary).getText();
        String newtext=text.replace("\n"," ");
        return newtext;
    }

    public void backToSummary()
    {
        driver.findElement(linkbacktoSummary).click();
    }

    public Boolean verifyOrder(String orderId)
    {
        String text=driver.findElement(tdOrderLink).getText();

        if(orderId.contains(text))
            return true;
        else
            return false;

    }
}
