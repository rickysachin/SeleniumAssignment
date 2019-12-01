package com.bdd.Webpages;
import com.bdd.BasePage;
import com.bdd.Util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderConfirmation extends BasePage
{
    public OrderConfirmation(WebDriver driver) {
        super(driver);
    }

    By divOrderSummary=By.cssSelector("div[class='box']");
    By linkbacktoSummary=By.cssSelector("a[class='button-exclusive btn btn-default']");
    By tdOrderLink=By.xpath("//tr[contains(@class,'first_item')]//td[@class='history_link bold footable-first-column']");

    public String extractOrderReference()
    {

        waitVisibility(divOrderSummary);
        String text=getText(divOrderSummary);
        String newtext=text.replace("\n"," ");
        return newtext;
    }

    public Boolean backToSummary()
    {
        try
        {
            click(linkbacktoSummary);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }

    public Boolean verifyOrder(String orderId)
    {

        String text=getText(tdOrderLink);

        if(orderId.contains(text))
            return true;
        else
            return false;

    }
}
