package common;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class SeleniumElements {
    public static WebDriver driver;
    private JavascriptExecutor jsExec;
    protected static final Logger log = Logger.getLogger("Log: ");

    public SeleniumElements toHover(By by){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(by);
        action.moveToElement(element).perform();
        return this;
    }

    public SeleniumElements toClick(By by) {
        try{
            int cnt = 0;
            waitUntilPageLoad();
            do{
                if(driver.findElement(by).isDisplayed()){
                    driver.findElement(by).click();
                    break;
                }else{
                    this.scrollTo(by, 100);
                }
                cnt++;
            }while(cnt<2);
        }catch (Exception ex){
            Assert.fail("click error!");
        }
        return this;
    }

    public SeleniumElements toSendKeys(By by, String str)  {
        try{
            int cnt = 0;
            waitUntilPageLoad();
            do{
                if(driver.findElement(by).isDisplayed()){
                    driver.findElement(by).sendKeys(str);
                    break;
                }else{
                    scrollTo(by, 100);
                }
                cnt++;
            }while(cnt<2);
        }catch (Exception ex){
            Assert.fail("sendKeys error!");
        }
        return this;
    }

    public SeleniumElements toSleep(int time)  {
        try{
            Thread.sleep(time);
        }catch (Exception ex){
            Assert.fail("sleep error!");
        }
        return this;
    }


    protected boolean waitUntilUrlContains(String expectedValue) {
        try {
            Wait<WebDriver> wait = (new FluentWait(driver)).withTimeout(Duration.ofSeconds(30L)).pollingEvery(Duration.ofMillis(100L)).ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class);
            boolean urlExists = (Boolean)wait.until(ExpectedConditions.urlContains(expectedValue));
            if (urlExists) {
                log.info(expectedValue + " bulundu");
            }
            return true;
        } catch (Exception var4) {
            log.warning(expectedValue+ " bulunamadı");
            return false;
        }
    }

    protected void waitUntilPageLoad(){
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }

    protected void scrollTo(By by, int margin) {
        WebElement element = (WebElement) by;
        this.scrollTo(element.getLocation().x, element.getLocation().y - margin);
    }

    protected void scrollTo(int x, int y) {
        this.jsExec.executeScript("scrollTo(" + x + "," + y + ");", new Object[0]);
    }
}
