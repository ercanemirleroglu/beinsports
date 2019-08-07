package BeinSports;

import common.Browser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LoginPage;
import pages.MainPage;
import pages.PaymentPage;
import users.User;

public class PaymentTest extends BaseTest {
    User user = new User();

    @BeforeMethod
    public void BeforeTest(){
        Browser browser= Browser.CHROME;
        getDriver(browser);

    }

    @Test(enabled = true, description= "In order to Try to Pay with Wrong Card Info")
    public void TS0001_Payment_With_Wrong_Card() throws Exception {

        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        PaymentPage paymentPage = new PaymentPage();

        mainPage.subscriberButton().timeSub("3").validatePrice("฿99").specialSubscriberButton().loginHere();
        loginPage.login(user.ercanUser, user.ercanPass);
        paymentPage.checkTerms().payNowBtn().cardholderName("Ercan Emirleroglu").cardNumber("1111222233334444")
                .expiryDateMonth("01").expiryDateYear("2023").verificationCode("111").confirmPayment().validatePaymentResult();
        toSleep(5000);
    }




}
