import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccount extends PageObject{

    private WebDriverWait wait= new WebDriverWait(driver,15);

    @FindBy (xpath = "/html/body/div[2]/main/div[2]/div[2]/div/div[2]/ul/li[2]/a")
    private WebElement myOrders;

    @FindBy (xpath = "/html/body/div[2]/main/div[2]/div[1]/div[3]/table/tbody/tr/td[1]")
    private WebElement myOrderId;

    @FindBy (xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")
    private WebElement profileButton;

    @FindBy (xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")
    private WebElement logOutButton;

    public MyAccount(WebDriver driver) {super(driver);}

    public void clickMyOrder() {this.myOrders.click();}

    public String checkMyOrderId() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[3]/table/tbody/tr/td[1]")));
        return this.myOrderId.getText();
    }

    public void clickprofileButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")));
        this.profileButton.click();
    }

    public void clickLogOutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a")));
        this.logOutButton.click();
    }
}
