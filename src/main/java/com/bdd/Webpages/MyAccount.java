package com.bdd.Webpages;
import com.bdd.BasePage;
import com.bdd.Util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccount extends BasePage
{

    public MyAccount(WebDriver driver) {
        super(driver);
    }
    By buttonMyPersonalInfo=By.xpath("//span[contains(text(),'My personal information')] ");
    By editFirstName=By.cssSelector("input[id='firstname']");
    By buttonsave=By.xpath("//span[contains(text(),'Save')]");
    By editOldPwd=By.cssSelector("input[id='old_passwd']");

    public Boolean clickMyPersonalInfo()
    {
        try {
            click(buttonMyPersonalInfo);
            return true;
        }
        catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }
    public Boolean setEditFirstName(String updatedname,String pwd)
    {
        try {
            clearText(editFirstName);
            enterText(editFirstName, updatedname);
            enterText(editOldPwd, pwd);
            return true;
        }
        catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }

    }
    public Boolean clickButtonSave()
    {
        try
        {
            click(buttonsave);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }

    }

    public String getFirstNameText()
    {
        String text;
        try
        {
            text=getTextForInputBox(editFirstName);
            return text;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return e.getMessage();
        }

    }

}
