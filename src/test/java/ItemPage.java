import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends PageObject{

    private WebDriverWait wait= new WebDriverWait(driver,15);

    @FindBy (className = "base")
    private WebElement itemTitle;

    @FindBy (xpath = "/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[5]")
    private WebElement itemSize;

    @FindBy (id = "option-label-color-93-item-52")
    private WebElement itemColor;

    @FindBy (id = "qty")
    private WebElement itemQty;

    @FindBy (className = "price")
    private WebElement itemPrice;

    @FindBy (xpath = "//*[@id=\"product-addtocart-button\"]")
    private WebElement addToCart;

    @FindBy (css = "#maincontent > div.page.messages > div:nth-child(2) > div > div > div")
    private WebElement goToCartMessage;

    @FindBy (xpath = "/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/span[2]")
    private WebElement checkSize;

    @FindBy (xpath = "/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[2]/span[2]")
    private WebElement checkColor;

    @FindBy (xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a")
    private WebElement goToCartButton;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public String getItemTitle () {return this.itemTitle.getText();}

    public double getItemPrice () {
        String textPrice = this.itemPrice.getText();
        StringBuilder newString = new StringBuilder(textPrice);
        newString.setCharAt(0, ' ');
        double fullPrice = Double.parseDouble(String.valueOf(newString));
        return fullPrice;
    }

    public void chooseSize () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div[1]/div[4]/form/div[1]/div/div/div[1]/div/div[5]")));
        this.itemSize.click();
    }

    public void chooseColor () {this.itemColor.click();}

    public void chooseQty () {
        this.itemQty.clear();
        this.itemQty.sendKeys("2");
    }

    public void clickAddToCart(){this.addToCart.click();}

    public String checkGoToCartMessage(){return this.goToCartMessage.getText();}

    public String checkItemSize(){return this.checkSize.getText();}

    public String checkItemColor(){return this.checkColor.getText();}

    public void clickGoToCartButton(){this.goToCartButton.click();}
}
