package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.*;

public class CheckoutNavigationTest extends BaseTest {

    @Test
    public void testContinueButtonTakesToOverviewPage() {
        // Login and navigate to Checkout Step One
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCartByIndex(0);

        driver.findElement(By.className("shopping_cart_link")).click();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // Fill in customer details and click Continue
        CheckOutFirstPage stepOnePage = new CheckOutFirstPage(driver);
        stepOnePage.enterCustomerDetails("Test", "User", "12345");
        stepOnePage.clickContinue();

        // Assert title of next page
        WebElement header = driver.findElement(By.className("title"));
        Assert.assertEquals(header.getText(), "Checkout: Overview");
    }

    @Test
    public void testCancelButtonReturnsToInventoryPage() {
        // Login and navigate to Checkout Step One
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addItemToCartByIndex(0);

        driver.findElement(By.className("shopping_cart_link")).click();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // Click Cancel
        WebElement cancelBtn = driver.findElement(By.id("cancel"));
        cancelBtn.click();

        // Assert we're back on inventory page
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
}
