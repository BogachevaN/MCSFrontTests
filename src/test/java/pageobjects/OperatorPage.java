package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class OperatorPage extends BasePage {
    @FindBy (css = "button.mat-button") private SelenideElement buttonLogout;
    @FindBy (xpath = "//ftc-search-client/form/mat-form-field/div/div[1]/div/input") private SelenideElement clientSearchLine;
    @FindBy (xpath = "//div/div/div/div/mat-option[1]/span") private SelenideElement firstClientInSearchLine;
    @FindBy (xpath = "//mat-toolbar-row[@class='mat-toolbar-row']//button[.='account_circle']") private SelenideElement userIcon;
    private String urlOperatorPage;

    {
        try {
            urlOperatorPage = getAllUrl().getProperty("operatorPage.url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void selectClientInSearchLine() {
        firstClientInSearchLine.shouldBe(Condition.exist).click();
    }

    public void clickUserIcon() {
        userIcon.click();
    }

    public void clickLogout() {
        buttonLogout.click();
    }

    public void searchLineAvailable() {
        clientSearchLine.shouldBe(Condition.exist);
    }

    public void setClientSearchLine(String clientSearchLine) {
        this.clientSearchLine.shouldBe(Condition.visible).setValue(clientSearchLine);
    }

    public void setFirstClientInSearchLine(SelenideElement firstClientInSearchLine) {
        this.firstClientInSearchLine = firstClientInSearchLine;
    }

    public String getUrlOperatorPage() {
        return urlOperatorPage;
    }
}
