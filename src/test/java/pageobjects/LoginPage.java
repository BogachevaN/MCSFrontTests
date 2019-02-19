package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class LoginPage extends BasePage{

    @FindBy (id = "auth-username") private SelenideElement login;
    @FindBy ( id = "auth-password") private SelenideElement password;
    @FindBy (id = "auth-submit") private SelenideElement buttonLogin;
    private String urlLoginPage;

    {
        try {
            urlLoginPage = getAllUrl().getProperty("loginPage.url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLogin(String login) {
        this.login.shouldBe(Condition.visible).setValue(login);
    }

    public void setPassword(String password) {
        this.password.shouldBe(Condition.visible).setValue(password);
    }

    public String getUrlLoginPage() {
        return urlLoginPage;
    }

    public void initAuthorization() {
        buttonLogin.click();
    }

    public void loginFieldAvailable() {
        login.shouldBe(Condition.exist);
    }
}
