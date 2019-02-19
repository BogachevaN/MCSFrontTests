package pageobjects;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public  class BasePage {

    public Properties getAllUrl () throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/data/allURL.properties");
        prop.load(fis);
        return prop;
    }

    public SelenideElement getElementByText(String text) {
        return $(byText(text));
    }


    public void openPage(String url) {
        open(url);
    }
}
