import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaceOrder extends PageObject {

    @FindBy (xpath = "/html/body/div[3]/main/div[2]/div/div[2]/aside/div[2]/div/div/div[1]/table/tbody/tr[2]/td/span")
    private WebElement shippingPrice;

    @FindBy (xpath = "/html/body/div[3]/main/div[2]/div/div[2]/aside/div[2]/div/div/div[1]/table/tbody/tr[3]/td/strong/span")
    private WebElement orderTotal;

    @FindBy (xpath = "/html/body/div[3]/main/div[2]/div/div[2]/aside/div[2]/div/div/div[2]/div/div[1]/div[2]")
    private WebElement shippingInfo;


    @FindBy (xpath =  "//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button/span")
    private WebElement placeOrderButton;

    public PlaceOrder(WebDriver driver) {
        super(driver);
    }

    public double getShippingPrice () {
        String textShipping = this.shippingPrice.getText();
        StringBuilder newString = new StringBuilder(textShipping);
        newString.setCharAt(0, ' ');
        double fullShippingPrice = Double.parseDouble(String.valueOf(newString));
        return fullShippingPrice;
    }

    public double getOrderTotal () {
        String textOrderTotal = this.orderTotal.getText();
        StringBuilder newString = new StringBuilder(textOrderTotal);
        newString.setCharAt(0, ' ');
        double fullOrderTotal = Double.parseDouble(String.valueOf(newString));
        return fullOrderTotal;
    }

    public String checkShippingInfo() {return this.shippingInfo.getText();}

    public void clickPlaceOrderButton() {this.placeOrderButton.click();}
}

