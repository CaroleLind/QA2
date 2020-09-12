package oneAProject.object.pages;

import oneAProject.object.OneA_BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class OneA_CartPage {
    private OneA_BaseFunc baseFunc;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By PRODUCT_ID = By.xpath(".//p[@class = 'detailed-cart-item__options']");
    private final By PRODUCT_NAME = By.xpath(".//p[@class = 'detailed-cart-item__name']");
    private final By PRODUCT_PRICE = By.xpath(".//p[@class = 'detailed-cart-item__price']");

    public OneA_CartPage(OneA_BaseFunc baseFunc) {
        LOGGER.info("Open cart page");
        this.baseFunc = baseFunc;
    }

    public String getID () {
        LOGGER.info("Get product ID on cart page");
        return baseFunc.findElement(PRODUCT_ID).getText();
    }

    public String getName () {
        LOGGER.info("Get product name on cart page");
        return baseFunc.findElement(PRODUCT_NAME).getText();
    }

    public String getPrice () {
        LOGGER.info("Get product price on cart page");

        String str_price = baseFunc.findElement(PRODUCT_PRICE).getText();
        return str_price.substring(0,str_price.length() - 2);
    }
}
