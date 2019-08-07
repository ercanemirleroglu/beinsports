package BeinSports;

import common.Browser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BaseTest;
import pages.LoginPage;
import pages.MainPage;
import pages.PaymentPage;
import users.User;

public class PaymentStepdefs extends BaseTest {
    User user = new User();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    PaymentPage paymentPage = new PaymentPage();

    @Given("^Open browser and go to url$")
    public void openBrowserAndGoToUrl() {
        Browser browser= Browser.CHROME;
        getDriver(browser);
    }

    @Then("^Subscribe Options$")
    public void subscribeOptions() {
        mainPage.subscriberButton();
    }

    @Then("^I choose one month$")
    public void iChooseOneMonth() {
        mainPage.timeSub("3");
    }

    @Then("^Control Price$")
    public void controlPrice() {
        mainPage.validatePrice("฿99");
    }

    @Then("^I chose Monthly Pass with One Week Free Trial$")
    public void iChoseMonthlyPassWithOneWeekFreeTrial() {
        mainPage.specialSubscriberButton();
    }

    @Then("^Login Here$")
    public void login() {
        mainPage.loginHere();
    }

    @When("^Enter username password and click login$")
    public void enterUsernamePasswordAndClickLogin() {
        loginPage.login(user.ercanUser, user.ercanPass);
    }


    @Then("^Check Terms Condisions$")
    public void checkTermsCondisions() {
        paymentPage.checkTerms();
    }

    @Then("^Click Pay Now Button$")
    public void clickPayNowButton() {
        paymentPage.payNowBtn();
    }

    @When("^Enter name in Cardholdes name$")
    public void enterNameInCardholdesName() {
        paymentPage.cardholderName("Ercan Emirleroglu");
    }

    @When("^Enter Card Number$")
    public void enterCardNumber() {
        paymentPage.cardNumber("1111222233334444");
    }

    @When("^Enter Expiry Month$")
    public void enterExpiryMonth() {
        paymentPage.expiryDateMonth("01");
    }

    @When("^Enter Expiry Year$")
    public void enterExpiryYear() {
        paymentPage.expiryDateYear("2023");
    }

    @When("^Enter Veritification Code$")
    public void enterVeritificationCode() {
        paymentPage.verificationCode("111");
    }

    @When("^Click Confirm Paymen Button$")
    public void clickConfirmPaymenButton() {
        paymentPage.confirmPayment();
    }

    @Then("^Validate Error Message$")
    public void validateErrorMessage() {
        paymentPage.validatePaymentResult();
    }
}
