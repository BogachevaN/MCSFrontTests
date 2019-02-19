package runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.IdentifyPage;

public class IdentifyTests {

    IdentifyPage identifyPage = Selenide.page(IdentifyPage.class);

    @BeforeMethod
    public void ensurePreconditions() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        Configuration.browser = "chrome";
        identifyPage.openPage(identifyPage.getUrlIdentifyPage());
    }

    @Test
    public void testConditionsFields(){

    }

}
