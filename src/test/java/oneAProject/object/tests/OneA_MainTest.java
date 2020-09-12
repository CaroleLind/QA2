package oneAProject.object.tests;

import oneAProject.object.pages.OneA_CartPage;
import oneAProject.object.pages.OneA_HomePage;
import oneAProject.object.pages.OneA_NotebookPage;
import oneAProject.object.pages.OneA_PageOfNotebooks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import oneAProject.object.OneA_BaseFunc;

public class OneA_MainTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void oneA_MainTest() {
        int notebookID = 7;
        String pageLink = "www.1a.lv";
        LOGGER.info("This test will add notebook to cart and check if everything is correct");

        OneA_BaseFunc baseFunc = new OneA_BaseFunc();
        baseFunc.openPage(pageLink);

        OneA_HomePage oneA_HomePage = new OneA_HomePage(baseFunc);
        OneA_PageOfNotebooks oneA_PageOfNotebooks = oneA_HomePage.openPageOfNotebooks();

        OneA_NotebookPage oneA_NotebookPage = oneA_PageOfNotebooks.openNotebookPage(notebookID);
        String productID = oneA_NotebookPage.getID();
        String productName = oneA_NotebookPage.getName();
        String productPrice = oneA_NotebookPage.getPrice();

        OneA_CartPage oneA_CartPage = oneA_NotebookPage.addToCartAndOpenCartPage();

        String productID_Cart = oneA_CartPage.getID();
        String productName_Cart = oneA_CartPage.getName();
        String productPrice_Cart = oneA_CartPage.getPrice();

        Assertions.assertTrue(productID.startsWith(productID_Cart),"Wrong product ID");
        Assertions.assertTrue(productName.startsWith(productName_Cart),"Wrong product name");
        Assertions.assertTrue(productPrice.startsWith(productPrice_Cart),"Wrong product price");
    }
}
