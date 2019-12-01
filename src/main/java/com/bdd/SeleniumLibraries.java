package com.bdd;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.firefox.FirefoxDriver;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SeleniumLibraries {
    private WebDriver driver;

    public WebDriver setupChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Maximize Window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver setupFireFox() {
        WebDriverManager.firefoxdriver().setup();
          System.setProperty("webdriver.firefox.bin", "C:\\Users\\sachin_khatri01\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        driver = new FirefoxDriver();
        //Maximize Window
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    public WebDriver setURL(String url) {
        driver.get(url);
        return driver;
    }



}
