import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class ShippingInfo extends PageObject {

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[1]/fieldset/div/div/input")
    private WebElement emailInfo;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input")
    private WebElement firstName;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[2]/div/input")
    private WebElement lastName;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input")
    private WebElement streetAdress;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[4]/div/input")
    private WebElement cityName;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[7]/div/input")
    private WebElement zipCode;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[8]/div/select")
    private WebElement countryName;

    @FindBy(xpath = "/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[1]/div[2]/form[2]/div/div[9]/div/input")
    private WebElement phoneNumber;

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/div/button/span")
    private WebElement nextButton;


    public ShippingInfo(WebDriver driver) {
        super(driver);
    }

    public String typeEmailInfo() {
        String myEmail = Utils.randomMail();
        this.emailInfo.sendKeys(myEmail);
        return myEmail;
    }

    public String typeFirstName() {
        String myName = Utils.randomFirstName();
        this.firstName.sendKeys(myName);
        return myName;
    }

    public String typeLastName() {
        String myLastName = Utils.randomLastName();
        this.lastName.sendKeys(myLastName);
        return myLastName;
    }

    public String typeStreetAdress() {
        String myStreet = Utils.randomStreetAdress();
        this.streetAdress.sendKeys(myStreet);
        return myStreet;
    }

    public String typeCityName(String city) {
        this.cityName.sendKeys(city);
        return city;
    }

    public String typeZipCode(String zip) {
        this.zipCode.sendKeys(zip);
        return zip;
    }

    public void chooseCountryName() {
        Select drpCountry = new Select(countryName);
        drpCountry.selectByIndex(3);
    }

    public String typePhoneNumber() {
        String myPhone = Utils.randomPhoneNumber();
        this.phoneNumber.sendKeys(myPhone);
        return myPhone;
    }

    public void clickNextButton() {this.nextButton.click();}
}
