import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class ThirdHomeWork {
    private final By ARTICLE = By.tagName("article");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, '-red-')]");
    private final By ARTICLE_TITLE = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENTS_PAGE = By.xpath(".//a[contains(@class, 'text-red-ribbon d-print-none')]");
    private final By COMMENTS_PAGE_TITLE = By.xpath(".//h1[(@class='article-title')]");
    private final By COMMENTS_PAGE_COMMENTS = By.xpath(".//span[contains(@class, 'type-cnt')]");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void verificationThirdArticle() {
        LOGGER.info("This test verificate third article");
        System.setProperty("webdriver.chrome.driver", "c://users/carol/IdeaProjects/Apps/chromedriver.exe");

        LOGGER.info("Opening browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Opening home page");
        driver.get("https://rus.delfi.lv");

        LOGGER.info("Getting all articles");
        List<WebElement> articles = driver.findElements(ARTICLE);

        LOGGER.info("Get 3rd article on home page");
        WebElement article = articles.get(2);

        LOGGER.info("Get 3rd article title on home page");
        String thirdArticleTitle = article.getText();

        LOGGER.info("Checking comments count 3rd article on home page");
        int homePageCommentsCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()){
            homePageCommentsCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }

        LOGGER.info("Open 3rd article on home page");
        article.click();

        LOGGER.info("Waiting ten seconds to open the  3rd article ");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_TITLE));

        LOGGER.info("Getting 3rd article title on article page");
        WebElement articleTitle = driver.findElement(ARTICLE_TITLE);
        String articleTitleText = articleTitle.getText();

        LOGGER.info("Getting 3rd article comments count on article page");
        WebElement articleComments = driver.findElement(COMMENTS_COUNT);
        int articleComCount = parseCommentCount(articleComments.getText());

        LOGGER.info("Getting 3rd article comments page");
        WebElement articleCommentsPage = driver.findElement(COMMENTS_PAGE);

        LOGGER.info("Open 3rd article comment page");
        articleCommentsPage.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENTS_PAGE_TITLE));

        LOGGER.info("Getting 3rd article comment page title");
        WebElement commentsPageTitle = driver.findElement(COMMENTS_PAGE_TITLE);
        String commentsPageTitleText = commentsPageTitle.getText();

        LOGGER.info("Getting 3rd article all comments  on comment page");
        List<WebElement> comments = driver.findElements(COMMENTS_PAGE_COMMENTS);

        LOGGER.info("Getting the total count of comments");
        int commentsA = parseCommentCount(comments.get(0).getText());
        int commentsR = parseCommentCount(comments.get(1).getText());
        int commentsCount = commentsA + commentsR;

        LOGGER.info("Getting assertion if article title is correct");
        Assertions.assertTrue(thirdArticleTitle.startsWith(articleTitleText), "Wrong title");
        Assertions.assertTrue(thirdArticleTitle.startsWith(commentsPageTitleText), "Wrong title");

        LOGGER.info("Getting assertionif comments count is correct");
        Assertions.assertEquals(homePageCommentsCount, articleComCount, "Wrong comments count!");
        Assertions.assertEquals(homePageCommentsCount, commentsCount, "Wrong comments count!");
    }

    private int parseCommentCount(String textToParse) {
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }
}
