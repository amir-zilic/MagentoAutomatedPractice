import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.DeleteSession;
import org.openqa.selenium.support.FindBy;

public class FrontPage extends PageObject{

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/a/img")
    private WebElement label;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[1]/a/span")
    private WebElement whatsNewButton;

    public FrontPage(WebDriver driver) {super(driver);
    }

    public boolean checkLabel() {
        return this.label.isDisplayed();
    }

    public void goToWhatsNew(){
        this.whatsNewButton.click();
    }
}
