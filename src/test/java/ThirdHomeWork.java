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

    @Test
    public void verificationThirdArticle() {
        System.setProperty("webdriver.chrome.driver", "c://users/carol/IdeaProjects/Apps/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rus.delfi.lv");

        List<WebElement> articles = driver.findElements(ARTICLE);

        WebElement article = articles.get(2);
        String thirdArticleTitle = article.getText();
        int homePageCommentsCount = 0;
        if (!article.findElements(COMMENTS_COUNT).isEmpty()){
            homePageCommentsCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }

        article.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_TITLE));

        WebElement articleTitle = driver.findElement(ARTICLE_TITLE);
        String articleTitleText = articleTitle.getText();
        WebElement articleComments = driver.findElement(COMMENTS_COUNT);
        int articleComCount = parseCommentCount(articleComments.getText());

        WebElement articleCommentsPage = driver.findElement(COMMENTS_PAGE);

        articleCommentsPage.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(COMMENTS_PAGE_TITLE));

        WebElement commentsPageTitle = driver.findElement(COMMENTS_PAGE_TITLE);
        String commentsPageTitleText = commentsPageTitle.getText();

        List<WebElement> comments = driver.findElements(COMMENTS_PAGE_COMMENTS);
        int commentsA = parseCommentCount(comments.get(0).getText());
        int commentsR = parseCommentCount(comments.get(1).getText());
        int commentsCount = commentsA + commentsR;

        Assertions.assertTrue(thirdArticleTitle.startsWith(articleTitleText), "Wrong title");
        Assertions.assertTrue(thirdArticleTitle.startsWith(commentsPageTitleText), "Wrong title");

        Assertions.assertEquals(homePageCommentsCount, articleComCount, "Wrong comments count!");
        Assertions.assertEquals(homePageCommentsCount, commentsCount, "Wrong comments count!");
    }

    private int parseCommentCount(String textToParse) {
        textToParse = textToParse.substring(1, textToParse.length() - 1);
        return Integer.parseInt(textToParse);
    }
}
