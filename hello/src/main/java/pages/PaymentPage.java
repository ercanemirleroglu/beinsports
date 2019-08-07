package pages;

import org.openqa.selenium.By;

public class PaymentPage extends BaseTest {
    By Lbl_TermCheck_Xpath = By.xpath("//label[@for='checkTerms']");
    By Inp_PayNow_Xpath = By.xpath("//input[@type='submit' and @class='bc-subscribe border-none show']");
    By Inp_Cardholder_Id = By.id("Ecom_Payment_Card_Name");
    By Inp_CardNumber_Id = By.id("Ecom_Payment_Card_Number");
    By Inp_ExpMon_Id = By.id("Ecom_Payment_Card_ExpDate_Month");
    By Inp_ExpYear_Id = By.id("Ecom_Payment_Card_ExpDate_Year");
    By Opt_Year_Xpath = By.xpath("//option[@value='2019']");
    By Inp_Verification_Id = By.id("Ecom_Payment_Card_Verification");
    By Inp_ConfirmPayment_Xpath = By.xpath("//input[@name='payment']");
    By Td_Validation_Xpath = By.xpath("//*[@id=\"content\"]/div/table[2]/tbody/tr/td");

    public PaymentPage checkTerms()  {
        toSleep(1000).toHover(Lbl_TermCheck_Xpath).toSleep(1000).toClick(Lbl_TermCheck_Xpath);
        return this;
    }

    public PaymentPage payNowBtn()  {
        toClick(Inp_PayNow_Xpath).toSleep(3000);
        return this;
    }

    public PaymentPage cardNumber(String card)  {
        toSendKeys(Inp_CardNumber_Id, card);
        return this;
    }

    public PaymentPage cardholderName(String name)  {
        toSendKeys(Inp_Cardholder_Id, name);
        return this;
    }

    public PaymentPage expiryDateMonth(String month)  {
        By Opt_Month_Xpath = By.xpath("//option[@value='"+month+"']");
        toClick(Inp_ExpMon_Id).toSleep(1000).toClick(Opt_Month_Xpath);
        return this;
    }

    public PaymentPage expiryDateYear(String year)  {
        By Opt_Year_Xpath = By.xpath("//option[@value='"+year+"']");
        toClick(Inp_ExpYear_Id).toSleep(1000).toClick(Opt_Year_Xpath);
        return this;
    }

    public PaymentPage verificationCode(String code)  {
        toSendKeys(Inp_Verification_Id, code);
        return this;
    }

    public PaymentPage confirmPayment()  {
        toClick(Inp_ConfirmPayment_Xpath).toSleep(2000);
        return this;
    }

    public PaymentPage validatePaymentResult(){
        if(driver.findElement(Td_Validation_Xpath).getText().contains("Card number incorrect or incompatible")){
            log.info("Scenerio has done succesfully!");
        }
        return this;
    }

}
