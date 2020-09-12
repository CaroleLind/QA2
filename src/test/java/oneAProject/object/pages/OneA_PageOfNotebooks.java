package oneAProject.object.pages;

import oneAProject.object.OneA_BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OneA_PageOfNotebooks {
    private OneA_BaseFunc baseFunc;
    private final By NOTEBOOKS = By.xpath(".//a[contains(@class, 'catalog-taxons-product__name')]");
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public OneA_PageOfNotebooks(OneA_BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    private WebElement getElementByID (int id) {
        LOGGER.info("Preparing list of elements on notebooks page");

        List<WebElement> notebooks =  baseFunc.findElements(NOTEBOOKS);
        return notebooks.get(id);
    }

    public OneA_NotebookPage openNotebookPage (int id) {
        LOGGER.info("Open notebook page");

        WebElement notebook = getElementByID(id);
        baseFunc.moveToElementViaJs(notebook);
        baseFunc.moveToElementAndClickViaJs(notebook);
        return new OneA_NotebookPage(baseFunc);
    }
}
