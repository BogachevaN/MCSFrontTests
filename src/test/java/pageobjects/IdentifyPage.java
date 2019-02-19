package pageobjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class IdentifyPage extends BasePage {
    @FindBy (css = "span.ng-binding.flex") private SelenideElement windowTitle;
    @FindBy (id = "identify-fio") private SelenideElement fio;
    @FindBy (id = "identify-birthdate") private SelenideElement birthDate;
    @FindBy (id = "identify-doctype") private SelenideElement docype;
    @FindBy (id = "identify-docnum") private SelenideElement docNum;
    @FindBy (id = "identify-docdate") private SelenideElement docDate;
    @FindBy (id = "identify-docwho") private SelenideElement docWho;
    @FindBy (css = "img.client-photo") private SelenideElement clientPhoto;
    @FindBy (xpath = "//ftc-identify-form/form/div[3]/div") private SelenideElement automaticСhecktLink;
    @FindBy (xpath = "/ftc-identify-form/form/div[4]/div[1]/label") private SelenideElement visualCheckLink;
    @FindBy (id = "mat-radio-2-input") private SelenideElement checkYes;
    @FindBy (id = "mat-radio-3-input") private SelenideElement checkNo;
    @FindBy (id = "identify-checkcomment") private SelenideElement comment;
    @FindBy (id = "identificationSuccess") private SelenideElement button;
    private String urlIdentifyPage;

    {
        try {
            urlIdentifyPage = getAllUrl().getProperty("identifyPage.url");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getUrlIdentifyPage() {
        return urlIdentifyPage;
    }


}
