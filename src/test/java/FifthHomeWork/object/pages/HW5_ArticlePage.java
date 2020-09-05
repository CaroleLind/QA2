package FifthHomeWork.object.pages;

import FifthHomeWork.object.BaseFunction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.By.xpath;

public class HW5_ArticlePage {
    private final By TITLE = xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENTS_COUNT = By.xpath(".//a[@class = 'text-size-19 text-size-md-28 text-red-ribbon d-print-none']");
    private final By COMMENTS = xpath(".//i[contains(@class, 'icon-ui-comments')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunction baseFunction;

    public HW5_ArticlePage(BaseFunction baseFunction) {
        this.baseFunction = baseFunction;

    }

    public String getTitle() {
        LOGGER.info("Getting article title on article page");

        return baseFunction.getText(TITLE).trim();
    }

    public int getCommentsCount() {
        LOGGER.info("Getting article comments count on article page");

        int commentCount = 0;
        if (!baseFunction.findElements(COMMENTS_COUNT).isEmpty()) {
            commentCount = baseFunction.parseCommentCount(baseFunction.getText(COMMENTS_COUNT));
        }
        return commentCount;
    }

    public HW5_CommentsPage openComments() {
        LOGGER.info("Open comments page");

        baseFunction.click(COMMENTS);
        return new HW5_CommentsPage(baseFunction);
    }
}
