package com.bdd.Webpages;
import com.bdd.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccount extends BasePage
{

    public MyAccount(WebDriver driver) {
        super(driver);
    }

    By textSearch=By.id("search_query_top");
    By buttonMyPersonalInfo=By.xpath("//span[contains(text(),'My personal information')] ");
    By editFirstName=By.xpath("//input[@id='firstname']");
    By buttonsave=By.xpath("//span[contains(text(),'Save')]");
    By editOldPwd=By.xpath("//input[@id='old_passwd']");


    public Boolean clickMyPersonalInfo()
    {
        try {

            driver.findElement(buttonMyPersonalInfo).click();
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    public void setEditFirstName(String updatedname)
    {
        driver.findElement(editFirstName).clear();
        driver.findElement(editFirstName).sendKeys(updatedname);
        driver.findElement(editOldPwd).sendKeys("password");
    }
    public Boolean clickButtonSave()
    {
        try {

            driver.findElement(buttonsave).click();
            return true;
        }catch(Exception e)
        {
            return false;
        }

    }

}
