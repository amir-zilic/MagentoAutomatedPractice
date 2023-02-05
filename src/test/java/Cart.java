import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends PageObject {


    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div/div[2]/form/div[1]/table/tbody/tr[1]/td[1]/div/dl/dd[1]")
    private WebElement cartSize;

    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div/div[2]/form/div[1]/table/tbody/tr[1]/td[1]/div/dl/dd[2]")
    private WebElement cartColor;

    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div/div[2]/div[1]/ul/li[1]/button")
    private WebElement proceedToCheckoutButton;

    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span")
    private WebElement OrderTotal;

    public Cart(WebDriver driver) {super(driver);
    }


        public String getCartSize() {return this.cartSize.getText();}

        public String getCartColor() {return this.cartColor.getText();}

        public double getOrderTotal() {
            String findorderTotal = this.OrderTotal.getText();
            StringBuilder newString = new StringBuilder(findorderTotal);
            newString.setCharAt(0, ' ');
            double orderTotalPrice = Double.parseDouble(String.valueOf(newString));
            return orderTotalPrice;
        }

        public void clickProceedToCheckoutButton() {this.proceedToCheckoutButton.click();}


    }
