package FifthHomeWork.object.pages;

import FifthHomeWork.object.BaseFunction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HW5_HomePage {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[contains(@class, '-red-')]");

    private BaseFunction baseFunction;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public HW5_HomePage(BaseFunction baseFunction) {
        this.baseFunction = baseFunction;
    }

    public String getTitleById(int id) {
        LOGGER.info("Get 3rd article title on home page");

        return getArticleById(id).findElement(TITLE).getText().trim();
    }

    public int getHomePageCommentsCount(int id) {
        LOGGER.info("Checking comments count 3rd article on home page");

        int homePageCommentsCount =0;
        if (!getArticleById(id).findElements(COMMENTS_COUNT).isEmpty()) {
            homePageCommentsCount = baseFunction.parseCommentCount(getArticleById(id).findElement(COMMENTS_COUNT).getText());
        }
        return homePageCommentsCount;
    }

        public HW5_ArticlePage openArticle(int id) {
        LOGGER.info("Open 3rd article on home page");

        baseFunction.click(getArticleById(id));
        return new HW5_ArticlePage(baseFunction);
    }

    public WebElement getArticleById(int id) {
        LOGGER.info("Getting all articles");
        List<WebElement> articles = baseFunction.findElements(ARTICLE);

        LOGGER.info("Getting assertion if articles are present");
        Assertions.assertFalse(articles.isEmpty(), "There is no articles");
        return articles.get(id);
    }
}
