package steps;
import com.codeborne.selenide.Selenide;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import pageobjects.LoginPage;

import com.codeborne.selenide.WebDriverRunner;
import pageobjects.OperatorPage;

import java.io.FileInputStream;
import java.util.Properties;

public class Stepdefs {

    LoginPage loginPage = Selenide.page(LoginPage.class);
    OperatorPage operatorPage = Selenide.page(OperatorPage.class);

    @Given("^open 'http://localhost:4200/login'$")
    public void openLoginPage() {
        loginPage.openPage(loginPage.getUrlLoginPage());
    }

    @When("^fill input field 'Логин' text: \"([^\"]*)\"$")
    public void fillLoginField(String arg1) {
        loginPage.setLogin(arg1);
    }

    @And("^fill input field 'Пароль' text: \"([^\"]*)\"$")
    public void fillPasswordField(String arg1) {
        loginPage.setPassword(arg1);
    }

    @And("^click button login")
    public void clickLogin() {
        loginPage.initAuthorization();
    }

    @Then("^operator's page 'http://localhost:4200/operator' opens$")
    public void operatorSPageOpens() throws InterruptedException {
        //проверка доступности строки поиска клиента, которая расположена на странице http://localhost:4200/operator
        operatorPage.searchLineAvailable();
    }

    @Given("^page 'http://localhost:4200/operator' opens$")
    public void pageHttpLocalhostOperatorOpens(){
        Assert.assertEquals(WebDriverRunner.url(), operatorPage.getUrlOperatorPage());
    }

    @When("^fill input field 'Поиск' text: \"([^\"]*)\"$")
    public void fillFieldSearchClient(String arg0){
       operatorPage.setClientSearchLine(arg0);
    }

    @And("^select first client in list$")
    public void selectFirstClientInSearchLine(){
        operatorPage.selectClientInSearchLine();
    }

    @When("^click on user icon$")
    public void clickOnUserIcon(){
        operatorPage.clickUserIcon();
    }

    @And("^click 'Выйти'$")
    public void clickLogout() {
        operatorPage.clickLogout();
    }

    @Then("^page 'http://localhost:(\\d+)/login' opens$")
    public void pageHttpLocalhostLoginOpens(int arg0) throws InterruptedException {
        loginPage.loginFieldAvailable();
    }



}
