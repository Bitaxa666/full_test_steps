package test.java.com.testautomationguru.container.test;

import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {

    protected WebDriver driver;
    
    @BeforeTest
    public void setUp() throws MalformedURLException {

        System.out.println("before test");
        DesiredCapabilities dc = DesiredCapabilities.chrome();

       /* if (System.getProperty("browser").equals("firefox"))
            dc = DesiredCapabilities.firefox();*/

        String host = System.getProperty("seleniumHubHost");
        
        /*driver = new RemoteWebDriver(new URL("http://" + host + ":5555/wd/hub"), dc);*/
        driver = new RemoteWebDriver(new URL("http://172.20.0.3:5555/wd/hub"), dc);
        
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        driver.quit();
    }  
}
