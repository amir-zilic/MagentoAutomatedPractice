import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Checkout extends PageObject{

    private WebDriverWait wait= new WebDriverWait(driver,15);

    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div/div[2]/p[1]/span")
    private WebElement orderNumber;

    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div/div[3]/div[2]/a/span")
    private WebElement createAccountButton;



    public Checkout(WebDriver driver) {super(driver);
    }


    public String getOrderNumber() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[3]/div/div[2]/p[1]/span")));
        return this.orderNumber.getText();}

    public  void clickCreateAccountButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[2]/a/span")));
        this.createAccountButton.click();
    }
}
