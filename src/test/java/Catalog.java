import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Catalog extends PageObject {

    @FindBy (className = "base")
    private WebElement title;

    @FindBy (xpath = "/html/body/div[2]/main/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[1]/div/a/span/span/img")
    private WebElement item;

    @FindBy (xpath = "//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[1]/div/div/strong/a")
    private WebElement itemName;


    public Catalog(WebDriver driver) {super(driver);
    }

    public String getTitle() {return this.title.getText();
    }

    public void goToItemPage() {this.item.click();}

    public String itemName() {return this.itemName.getText();}


}
