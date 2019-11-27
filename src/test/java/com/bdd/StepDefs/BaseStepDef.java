package com.bdd.StepDefs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Properties;
import com.bdd.Util.Log;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class BaseStepDef {

    public static Properties config = new Properties();
    private static InputStream input = null;
    private static String configProperty = System.getProperty("user.dir") + "/src/test/resources/properties/config.properties";
    public static String ENV;
    public static String URL;
    public static String BROWSER;
    public static String USER;
    public static String PWD;
    public static String logfile=System.getProperty("user.dir")+"/log/testlog.log";
    public static String snapshotFile=System.getProperty("user.dir")+"/Snapshot/";
    public static Boolean IsInitialized=false;

    public void init() throws IOException {
        try {
            if(!IsInitialized) {
                IsInitialized=true;
                FileUtils.write(new File(logfile), "", "ISO-8859-1");
                deleteAllFiles(snapshotFile);
                Log log = new Log();
                Log.startLogging();
                input = new FileInputStream(configProperty);
                config.load(input);
                ENV = config.getProperty("ENV");

                if (ENV != null) {
                    if (ENV.contains("TEST"))
                        URL = config.getProperty("TEST_URL");
                } else {
                    URL = config.getProperty("TEST_URL");
                }
                BROWSER = config.getProperty("BROWSER");
                USER = config.getProperty("USER");
                PWD = config.getProperty("PASSWORD");
            }
        } catch (Exception e) {
            Log.error(e.getMessage());
            throw new IOException("\nCouldn't Read Environment file\n", e);

        }
    }

    public  static void captureScreenshot(WebDriver driver,String path, String pageError) throws IOException {
        File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source_file, new File(path+"//"+pageError+".png"));
    }

    public void deleteAllFiles(String path)
    {
        File dir = new File(path);
        File[] listFiles = dir.listFiles();
        for(File file : listFiles){
           file.delete();
        }
    }


}
