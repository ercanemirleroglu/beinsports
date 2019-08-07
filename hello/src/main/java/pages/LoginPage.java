package pages;

import org.openqa.selenium.By;

public class LoginPage extends BaseTest{

    By Input_Username_Xpath = By.xpath("//input[@placeholder='Email or Mobile Number']");
    By Input_Password_Xpath = By.xpath("//input[@name='Password']");
    By Input_Login_Xpath = By.xpath("//input[@type='submit']");

    public LoginPage login(String user, String pass) {
        signIn(user, pass);
        return this;
    }

    public void signIn(String user, String pass)  {
        toSendKeys(Input_Username_Xpath, user)
                .toSendKeys(Input_Password_Xpath, pass)
                .toSleep(1000)
                .toClick(Input_Login_Xpath);
    }

}
