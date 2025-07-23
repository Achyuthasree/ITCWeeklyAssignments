package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckoutInformationTest extends BaseTest {

    @Test
    public void testValidCheckoutInformation() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        // Add item to cart
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCartByIndex(0);

        // Go to cart
        driver.findElement(By.className("shopping_cart_link")).click();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // Fill in checkout form
        CheckOutFirstPage checkoutStepOnePage = new CheckOutFirstPage(driver);
        checkoutStepOnePage.enterCustomerDetails("Alice", "Johnson", "560001");
        checkoutStepOnePage.clickContinue();

        // Assert navigation to step two
        WebElement header = driver.findElement(By.className("title"));
        Assert.assertEquals(header.getText(), "Checkout: Overview");
    }
}

