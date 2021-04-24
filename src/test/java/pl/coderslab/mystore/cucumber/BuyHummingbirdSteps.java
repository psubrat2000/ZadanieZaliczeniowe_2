package pl.coderslab.mystore.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.mystore.pageobject.MyStorePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class BuyHummingbirdSteps {

    private WebDriver driver;
    private MyStorePage myStorePage;
    private String savedTotalPrice;

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    @Given("an user logged into My Store")
    public void shouldLogIntoMyStore() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://prod-kurs.coderslab.pl/index.php");
        this.myStorePage = new MyStorePage(driver);
        this.myStorePage.logInToYourAccount();
    }

    @When("user chooses Hummingbird Printed Sweater")
    public void shouldChooseHummingbirdPrintedSweater() {
        this.myStorePage.clickClothes();
        this.myStorePage.chooseHummingbirdPrintedSweater();
    }

    @Then("discount is 20%")
    public void shouldHaveDiscount() {
        assertEquals("SAVE 20%", this.myStorePage.checkDiscount());
    }

    @When("user chooses size {string}")
    public void shouldChooseSize(String size) {
        this.myStorePage.chooseSize(size);
    }

    @And("user chooses {word} pieces")
    public void shouldChooseQuantity(String quantity) {
        this.myStorePage.chooseQuantity(quantity);
    }

    @And("user adds the product to the cart")
    public void shouldAddProductsToTheBasket() {
        this.myStorePage.addToCart();
    }

    @And("user proceeds to checkout")
    public void shouldProceedToCheckout() {
        wait(1000);
        this.myStorePage.proceedToCheckout();
    }

    @And("user confirms address")
    public void shouldConfirmAddress() {
        this.myStorePage.confirmAddress();
    }

    @And("user chooses shipping method to pick up in store")
    public void shouldChooseShippingMethod() {
        this.myStorePage.chooseShippingMethod();
    }

    @And("user chooses the way of payment")
    public void shouldChooseTheWayOfPayment() {
        this.myStorePage.choosePayment();
    }

    @And("user clicks \"order with an obligation to pay\"")
    public void shouldOrderWithAnObligationToPay() {
        this.myStorePage.orderWithAnObligationToPay();
    }

    @Then("a confirmation screenshot is made and price is saved for comparison")
    public void shouldTakeScreenshotAndSavePrice() throws IOException {
        this.savedTotalPrice = this.myStorePage.saveTotalPrice();
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        Files.copy(source.toPath(), new File("C:\\Users\\PC\\Desktop\\Screen.png").toPath());
    }

    @When("user enters order history")
    public void shouldEnterOrderHistory() {
        this.myStorePage.enterOrderHistory();
    }

    @Then("the most recent order is {string} and the total price is equal to price saved earlier")
    public void shouldAssertOrderDetails(String orderStatus) {
        assertEquals(orderStatus, this.myStorePage.getOrderStatus());
        assertEquals(savedTotalPrice, this.myStorePage.getTotalPrice());
    }
}
