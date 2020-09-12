package oneAProject.object.pages;

import oneAProject.object.OneA_BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OneA_NotebookPage {
    private OneA_BaseFunc baseFunc;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final By PRODUCT_ID = By.xpath(".//p[@class = 'product-id']");
    private final By PRODUCT_NAME = By.xpath(".//h1");
    private final By PRODUCT_PRICE = By.xpath(".//span[@class = 'price']");

    public OneA_NotebookPage(OneA_BaseFunc baseFunc) {
        LOGGER.info("Open notebook page");
        this.baseFunc = baseFunc;
    }

    public String getID () {
        LOGGER.info("Get product ID on notebook page");
        return baseFunc.findElement(PRODUCT_ID).getText();
    }

    public String getName () {
        LOGGER.info("Get product name on notebook page");
        return baseFunc.findElement(PRODUCT_NAME).getText();
    }

    public String getPrice () {
        LOGGER.info("Get product price on notebook page");

        String str_price = baseFunc.findElement(PRODUCT_PRICE).getText();
        return str_price.substring(0,str_price.length() - 9);
    }

    public OneA_CartPage addToCartAndOpenCartPage() {
        WebElement cart_btn = baseFunc.findElement(By.xpath(".//button[@id = 'add_to_cart_btn']"));
        baseFunc.moveToElementViaJs(cart_btn);
        baseFunc.moveToElementAndClickViaJs(cart_btn);

        WebElement cart_btn_click = baseFunc.findElement(By.linkText("Pārlūkot pirkumu grozu"));
        baseFunc.moveToElementViaJs(cart_btn_click);
        baseFunc.moveToElementAndClickViaJs(cart_btn_click);
        return new OneA_CartPage(baseFunc);
    }
}
