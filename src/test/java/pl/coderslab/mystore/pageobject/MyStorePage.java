package pl.coderslab.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyStorePage {

    private WebDriver driver;

    @FindBy(css = "div#_desktop_user_info div.user-info a")
    private WebElement signIn;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "submit-login")
    private WebElement logIn;

    @FindBy(css = "ul#top-menu li#category-3")
    private WebElement clothes;

    @FindBy(css = "div.thumbnail-container a.thumbnail.product-thumbnail")
    private List<WebElement> clothingItems;

    @FindBy(css = "span.discount.discount-percentage")
    private WebElement discount;

    @FindBy(id = "group_1")
    private WebElement sizeSelection;

    @FindBy(id = "quantity_wanted")
    private WebElement quantitySelection;

    @FindBy(css = "button.btn.btn-primary.add-to-cart")
    private WebElement additionToCart;

    @FindBy(css = "div.cart-content-btn a.btn.btn-primary")
    private WebElement proceedingToCheckout1;

    @FindBy(css = "div.text-sm-center a.btn.btn-primary")
    private WebElement proceedingToCheckout2;

    @FindBy(name = "confirm-addresses")
    private WebElement addressConfirmation;

    @FindBy(css = "span.custom-radio.float-xs-left")
    private List<WebElement> shippingMethods;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement shippingConfirmation;

    @FindBy(id = "payment-option-1")
    private WebElement paymentOption;

    @FindBy(css = "span.custom-checkbox")
    private WebElement paymentConfirmation;

    @FindBy(css = "div#payment-confirmation button.btn.btn-primary.center-block")
    private WebElement obligationToPay;

    @FindBy(css = "tr.font-weight-bold td")
    private List<WebElement> totalPriceToSave;

    @FindBy(css = "a.account")
    private WebElement myAccount;

    @FindBy(id = "history-link")
    private WebElement orderHistoryAndDetails;

    @FindBy(css = "td.text-xs-right")
    private List<WebElement> totalPrices;

    @FindBy(css = "span.label.label-pill.bright")
    private List<WebElement> orderStatusList;

    public MyStorePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void logInToYourAccount() {
        this.signIn.click();
        this.email.clear();
        this.email.sendKeys("pdamgiapmwwotjyrll@miucce.com");
        this.password.clear();
        this.password.sendKeys("password123");
        this.logIn.click();
    }

    public void clickClothes() {
        this.clothes.click();
    }

    public void chooseHummingbirdPrintedSweater() {
        this.clothingItems.get(1).click();
    }

    public String checkDiscount() {
        return discount.getText();
    }

    public void chooseSize(String size) {
        this.sizeSelection.sendKeys(size);
    }

    public void chooseQuantity(String quantity) {
        this.quantitySelection.clear();
        this.quantitySelection.sendKeys(quantity);
    }

    public void addToCart() {
        this.additionToCart.click();
    }

    public void proceedToCheckout() {
        this.proceedingToCheckout1.click();
        this.proceedingToCheckout2.click();
    }

    public void confirmAddress() {
        this.addressConfirmation.click();
    }

    public void chooseShippingMethod() {
        this.shippingMethods.get(0).click();
        this.shippingConfirmation.click();
    }

    public void choosePayment() {
        this.paymentOption.click();
        this.paymentConfirmation.click();
    }

    public void orderWithAnObligationToPay() {
        this.obligationToPay.click();
    }

    public String saveTotalPrice() {
        return this.totalPriceToSave.get(1).getText();
    }

    public void enterOrderHistory() {
        this.myAccount.click();
        this.orderHistoryAndDetails.click();
    }

    public String getTotalPrice() {
        return this.totalPrices.get(0).getText();
    }

    public String getOrderStatus() {
        return this.orderStatusList.get(0).getText();
    }
}
