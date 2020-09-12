package oneAProject.object.pages;

import oneAProject.object.OneA_BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class OneA_HomePage {
    private OneA_BaseFunc baseFunc;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By ELEMENT_MENU = By.linkText("Datortehnika, preces birojam");
    private final By ELEMENT_SUBMENU = By.linkText("Portatīvie datori");

    public OneA_HomePage (OneA_BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public OneA_PageOfNotebooks openPageOfNotebooks () {
        LOGGER.info("Open page of notebooks on home page");

        baseFunc.moveToElementViaActions(baseFunc.findElement(ELEMENT_MENU));
        baseFunc.moveToElementAndClickViaActions(baseFunc.findElement(ELEMENT_SUBMENU));
        return new OneA_PageOfNotebooks(baseFunc);
    }
}
