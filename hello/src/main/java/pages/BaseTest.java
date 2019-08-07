package pages;

import common.Browser;
import common.SeleniumElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Random;
import java.util.logging.Logger;

public class BaseTest extends SeleniumElements {

    public WebDriverWait webDriverWait;
    public String browser;
    public String driverPath;
    public String key;
    Browser browserChrome = Browser.CHROME;
    Browser browserFirefox = Browser.FIREFOX;
    public final String chrome = browserChrome.getBrowser();
    public final String firefox = browserFirefox.getBrowser();
    public final String chromeDriver = "\\chromedriver.exe";
    public final String firefoxDriver = "\\geckodriver.exe";
    public final String chromeKey = "webdriver.chrome.driver";
    public final String firefoxKey = "webdriver.gecko.driver";
    public String url = "https://connect-th.beinsports.com/en";

    protected static final Logger log = Logger.getLogger("Log: ");


    public void chooseBrowser(String _browser){
        this.browser=_browser;
        if (this.browser.equalsIgnoreCase(chrome)){
            this.driverPath = chromeDriver;
            this.key = chromeKey;
            this.browser = chrome;

        }else if(this.browser.equalsIgnoreCase(firefox)){
            this.driverPath = firefoxDriver;
            this.key = firefoxKey;
            this.browser = firefox;
        }
    }

    public WebDriver chooseDriverType(Browser browser){
        if (browser.equals(Browser.CHROME)) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver( options );
        }else if(browser.equals(Browser.FIREFOX)){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }else{
            Assert.fail("Driver can be choosen!");
        }
        return driver;
    }

    public String sendDriverPath(){
        this.driverPath = System.getProperty("user.dir")+"\\drivers"+this.driverPath;
        return this.driverPath;
    }

    public void getDriver(Browser _browser){
        chooseBrowser(_browser.getBrowser());
        String path = sendDriverPath();
        System.setProperty(this.key, path);
        driver = chooseDriverType(_browser);
        driver.get(url);
        waitUntilUrlContains(url);
    }




    public int randomNumber(int size){
        Random rnd = new Random();
        return rnd.nextInt(size-1);
    }


}
