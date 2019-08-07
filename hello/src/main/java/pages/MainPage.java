package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

public class MainPage extends BaseTest{

    By Btn_Subscribe_Xpath = By.xpath("//a[@name='Subscribe']");
    By Spn_PriceValidate_Xpath = By.xpath("/html/body/div[5]/div[4]/div/div[2]/div[1]/span[2]");
    By Btn_SubButton_Xpath = By.xpath("(//span[@id='form-result']/../a)[4]");
    By A_LoginHere_Xpath = By.xpath("//input[@value='/en/card/basket']/../a");

    public MainPage subscriberButton()  {
        toClick(Btn_Subscribe_Xpath);
        return this;
    }

    public MainPage timeSub(String secim)  {
        By Btn_TimeSub_Xpath = By.xpath("/html/body/div[5]/div[1]/div["+secim+"]/span");
        toClick(Btn_TimeSub_Xpath);
        return this;
    }

    public MainPage validatePrice(String _price){
        String price = driver.findElement(Spn_PriceValidate_Xpath).getText();
        if (price.equalsIgnoreCase(_price)){
            System.out.println("Price is correct!");
            log.info("Price is correct");
        }else{
            Assert.fail("Prices can not match!");
        }
        return this;
    }

    public MainPage specialSubscriberButton()  {
        toHover(Btn_SubButton_Xpath).toClick(Btn_SubButton_Xpath);
        return this;
    }

    public MainPage loginHere()  {
        toSleep(2500).toClick(A_LoginHere_Xpath);
        return this;
    }
}
