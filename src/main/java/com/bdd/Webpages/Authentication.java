package com.bdd.Webpages;
import com.bdd.BasePage;
import com.bdd.Util.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Authentication extends BasePage
{

    public Authentication(WebDriver driver) {
        super(driver);
    }


    By inputEmail=By.cssSelector("input[id='email']");
    By inputPassword =By.cssSelector("input[id='passwd']");
    By buttonSignIn=By.cssSelector("p[class='submit'] span:nth-child(1)");
    By linkCustAccount=By.cssSelector("a[title='View my customer account']");
    By linkuser=By.cssSelector("a[class='account'] span");


    public Boolean login (String user,String pwd ) {
        try {
            waitVisibility(inputEmail);
            enterText(inputEmail,user);
            enterText(inputPassword,pwd);
            click(buttonSignIn);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }
    public Boolean getUser (String user ) {
        waitVisibility(linkuser);
        String name=getText(linkuser);
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

            waitVisibility(linkCustAccount);
            click(linkCustAccount);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }

    public Boolean IsCustomerLogin( ) {
        try {

            waitVisibility(linkCustAccount);
            return true;
        }catch(Exception e)
        {
            Log.error(e.getMessage());
            return false;
        }
    }
}
