import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SecondHomeWork {
    private final By ARTICLE = By.xpath(".//h1[contains(@class,'headline__title')]");
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By ARTICLE_TITLE_COMCOUNT = By.xpath(".//a[contains(@class, '-red-')]");

    @Test
    public void compareTitle() {
        System.setProperty("webdriver.chrome.driver", "c://users/carol/IdeaProjects/Apps/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");

        WebElement firstArticle = driver.findElement(ARTICLE);
        String articleTitle = firstArticle.getText();
        WebElement articleComments = driver.findElement(COMMENTS_COUNT);
        String articleCommentsCount = articleComments.getText();

        firstArticle.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_TITLE));

        WebElement pageTitle = driver.findElement(ARTICLE_TITLE);
        String pageTitleText = pageTitle.getText();

        WebElement pageComment = driver.findElement(ARTICLE_TITLE_COMCOUNT);
        String pageCommentsCount = pageComment.getText();

        Assertions.assertEquals(articleTitle, pageTitleText, "Wrong article title!");
        Assertions.assertEquals(articleCommentsCount, pageCommentsCount, "Wrong comments count!");

    }
}


