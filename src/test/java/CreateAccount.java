import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount extends PageObject {

    private WebDriverWait wait= new WebDriverWait(driver,15);

    @FindBy (id="password")
    private WebElement enterPassword;

    @FindBy (id="password-confirmation")
    private WebElement confirmPassword;

    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div/form/div/div[1]/button")
    private WebElement createAccountButton;

    public CreateAccount(WebDriver driver) {super(driver);}

    public void typePassword() {this.enterPassword.sendKeys("MyFavoriteBand182");}

    public void typeConfirmPassword() {this.confirmPassword.sendKeys("MyFavoriteBand182");}

    public void clickCreateAccountButton() {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[3]/div/form/div/div[1]/button")));
                this.createAccountButton.click();
            }
}




