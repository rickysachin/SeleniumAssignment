package com.bdd.Webpages;
import com.bdd.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Authentication extends BasePage
{

    public Authentication(WebDriver driver) {
        super(driver);
    }


    By inputEmail=By.cssSelector("input[id='email']");
    By inputPassword =By.cssSelector("input[id='passwd']");
    By buttonSignIn=By.xpath("//p[@class='submit']//span[1]");
    By linkLogout=By.cssSelector("a[class='logout']");
    By linkCustAccount=By.cssSelector("a[title='View my customer account']");
    By linkuser=By.xpath("//a[@class='account']//span");


    public Boolean login (String user,String pwd ) {
        try {
            waitVisibility(inputEmail);
            driver.findElement(inputEmail).sendKeys(user);
            driver.findElement(inputPassword).sendKeys(pwd);
            driver.findElement(buttonSignIn).click();
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }
    public Boolean getUser (String user ) {
        waitVisibility(linkuser);
        String name=driver.findElement(linkuser).getText();
        String fname[]=name.split(" ");
        String firstname="";
        if (fname.length>2)
        {
            for (int i = 0; i < (fname.length - 1); i++) {
                firstname = firstname + fname[i];
                if (i + 1 != fname.length - 1)
                    firstname = firstname + " ";
            }
        }
        else
            firstname=fname[0];
        if(user.equalsIgnoreCase(firstname.trim()))
            return true;
        else
            return false;

    }

    public Boolean clickMyaccount ( ) {
       try {
           int count = 0;
           waitVisibility(linkCustAccount);
           driver.findElement(linkCustAccount).click();
           return true;
       }catch(Exception e)
       {
           return false;
       }
    }
}
