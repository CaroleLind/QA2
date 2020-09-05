package FifthHomeWork.object.pages;

import FifthHomeWork.object.BaseFunction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static org.openqa.selenium.By.xpath;

public class HW5_CommentsPage {
    private final By TITLE = xpath(".//h1[@class = 'article-title']/a");
    private final By COMMENTS_PAGE_COMMENTS = xpath(".//span[contains(@class, 'type-cnt')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    private BaseFunction baseFunction;

    public HW5_CommentsPage(BaseFunction baseFunction) {
        this.baseFunction = baseFunction;
    }

    public String getTitle() {
        LOGGER.info("Getting title on comments page ");

        return  baseFunction.getText(TITLE);
    }

    public int getCommentsCount(){
        LOGGER.info("Getting 3rd article all comments  on comment page");

        List<WebElement> comments = baseFunction.findElements(COMMENTS_PAGE_COMMENTS);

        LOGGER.info("Getting the total count of anonymous and registered comments");

        int commentsA = 0;
        int commentsR = 0;
        if (comments.get(0).findElements(COMMENTS_PAGE_COMMENTS).isEmpty()) {
            commentsA = baseFunction.parseCommentCount(comments.get(0).getText());
        }
        if (comments.get(1).findElements(COMMENTS_PAGE_COMMENTS).isEmpty()) {
            commentsR = baseFunction.parseCommentCount(comments.get(1).getText());
        }
        int commentsCount = commentsA + commentsR;
        return commentsCount;
    }
}
