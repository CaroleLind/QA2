package oneAProject.object;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class OneA_BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public OneA_BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "c://users/carol/IdeaProjects/Apps/chromedriver.exe");
        driver = new ChromeDriver();
        action = new Actions(driver);
        wait = new WebDriverWait(driver,200);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void openPage(String url){
        LOGGER.info("Trying to open page: " + url);

        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
    }

    public List<WebElement> findElements(By locator) {
        System.out.println(driver.getCurrentUrl());
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElements(locator);
    }

    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public void moveToElementViaActions(WebElement element) {
        LOGGER.info("Moving to element (actions)");
        action.moveToElement(element).build().perform();
    }

    public void moveToElementAndClickViaActions(WebElement element) {
        LOGGER.info("Moving to element and click on it (actions)");
        action.moveToElement(element).click().build().perform();
    }

    public void moveToElementViaJs(WebElement element) {
        LOGGER.info("Moving to element (js)");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void moveToElementAndClickViaJs(WebElement element) {
        LOGGER.info("Moving to element and click on it (js)");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
