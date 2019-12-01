package com.bdd.Webpages;
import com.bdd.BasePage;
import com.bdd.Util.Log;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage
{
    public HomePage (WebDriver driver) {
        super(driver);
    }

    By textSearch=By.id("search_query_top");
    By buttonSearch=By.name("submit_search");
    By linkImage=By.cssSelector("a[class='product_img_link']");
    By buttonAddTocart=By.name("Submit");
    By linkLogin=By.cssSelector("a[class='login']");

    public Boolean enterText (String text)
    {
        try {
            waitVisibility(textSearch);
            enterText(textSearch,text);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }
    public Boolean clickSearch ()
    {
        try
        {
        waitVisibility(buttonSearch);
        click(buttonSearch);
        return true;
        }catch(Exception e)
        {
            Log.info(e.getMessage());
            return false;
        }
    }
    public Boolean clickInStock ()
    {

        try
        {
            clickusingJavaScript(linkImage);
            waitVisibility(buttonAddTocart);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }

    public Boolean clickLogin () {
        try
        {
            waitVisibility(linkLogin);
            click(linkLogin);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }

    }

    public Boolean IsSearchBoxPresent () {
        if(isElementPresent(textSearch))
            return true;
        else
            return false;
    }
}
