package test.java.com.testautomationguru.container.test;

import java.net.MalformedURLException;

import main.java.com.testautomationguru.container.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class SearchTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();

    private SearchPage google;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        super.setUp();
        google = new SearchPage(driver);
    }

    @Test(dataProvider = "search-keywords")
    public void googleTest(String searchKeyword) {
        google.goTo();
        google.searchFor(searchKeyword);
        softAssert.assertTrue(google.getResults().size()<0);
        softAssert.assertAll();
    }
   
    @DataProvider(name = "search-keywords")
    public static Object[][] credentials() {
          return new Object[][] {
              /*{ "test automation guru" },
              { "selenium webdriver" },
              { "dockerized selenium grid" },
              { "test automation blog" },
              { "jmeter docker" } ,
              { "test automation guru" },
              { "selenium webdriver" },
              { "dockerized selenium grid" },*/
              { "test automation blog" },
              { "jmeter docker" }               
          };
    }

}
