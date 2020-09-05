package FifthHomeWork.object.tests;

import FifthHomeWork.object.BaseFunction;
import FifthHomeWork.object.pages.HW5_ArticlePage;
import FifthHomeWork.object.pages.HW5_CommentsPage;
import FifthHomeWork.object.pages.HW5_HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import page.object.pages.CommentsPage;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HW5_PageObjectTests {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void pageObjectTest() {
        int articleID = 2;
        String pageLink = "rus.delfi.lv";

        LOGGER.info("This test will check article title and comments count on Home, Article and Comments pages");

        BaseFunction baseFunction = new BaseFunction();
        baseFunction.openPage(pageLink);

        HW5_HomePage homePage = new HW5_HomePage(baseFunction);
        String homePageTitle = homePage.getTitleById(articleID);
        int homePageCommentsCount = homePage.getHomePageCommentsCount(articleID);

        HW5_ArticlePage articlePage = homePage.openArticle(articleID);
        String articlePageTitle = articlePage.getTitle();
        int articleComCount = articlePage.getCommentsCount();

        HW5_CommentsPage commentsPage = articlePage.openComments();
        String commentsPageTitle = commentsPage.getTitle();
        int commentsCount = commentsPage.getCommentsCount();

        LOGGER.info("Getting assertion if article title is correct");
        assertTrue(homePageTitle.startsWith(articlePageTitle), "Wrong title");
        assertTrue(homePageTitle.startsWith(commentsPageTitle), "Wrong title");

        LOGGER.info("Getting assertion if comments count is correct");
        assertEquals(homePageCommentsCount, articleComCount, "Wrong comments count!");
        assertEquals(homePageCommentsCount, commentsCount, "Wrong comments count!");
    }
}
