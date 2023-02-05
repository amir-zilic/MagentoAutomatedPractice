import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "E2E Smoke Test")
    public static void smokeTest() throws InterruptedException {
        driver.get(Utils.BASE_URL);
        //Front page
        FrontPage frontPage = new FrontPage(driver);
        Assert.assertTrue(frontPage.checkLabel(), Utils.didNotLoadMessage("Front"));
        frontPage.goToWhatsNew();
        //Catalog
        Catalog catalog = new Catalog(driver);
        Assert.assertEquals(catalog.getTitle(), "What's New", Utils.didNotLoadMessage("Catalog"));
        Thread.sleep(1000);
        String itemName = catalog.itemName();
        catalog.goToItemPage();
        //Item page
        ItemPage itempage = new ItemPage(driver);
        Assert.assertEquals(itempage.getItemTitle(), itemName, Utils.didNotLoadMessage("Correct item"));
        itempage.chooseSize();
        itempage.chooseColor();
        itempage.chooseQty();
        itempage.clickAddToCart();
        double fullPrice = itempage.getItemPrice();
        Thread.sleep(3000);
        Assert.assertEquals(itempage.checkGoToCartMessage(), "You added " + itemName + " to your shopping cart.", "Wrong item added to cart");
        String itemSize = itempage.checkItemSize();
        String itemColor = itempage.checkItemColor();
        itempage.clickGoToCartButton();
        Thread.sleep(3000);
        // Cart
        Cart cart = new Cart(driver);
        Assert.assertEquals(itemSize, cart.getCartSize(), "Wrong item size");
        Assert.assertEquals(itemColor, cart.getCartColor(), "Wrong item color");
        Assert.assertEquals(cart.getOrderTotal(),fullPrice*2, "Wrong full price");
        fullPrice *=2;
        cart.clickProceedToCheckoutButton();
        Thread.sleep(3000);
        //Shipping Info
        ShippingInfo shippingInfo = new ShippingInfo(driver);
        shippingInfo.chooseCountryName();
        Thread.sleep(5000);
        User user = new User();
        user.setEmail(shippingInfo.typeEmailInfo());
        user.setName(shippingInfo.typeFirstName());
        user.setLastName(shippingInfo.typeLastName());
        user.setStreetAddress(shippingInfo.typeStreetAdress());
        shippingInfo.typeCityName(user.getCityName());
        shippingInfo.typeZipCode(user.getZipCode());
        user.setPhone(shippingInfo.typePhoneNumber());
        Thread.sleep(3000);
        shippingInfo.clickNextButton();
        Thread.sleep(3000);
        //PlaceOrder
        PlaceOrder placeOrder = new PlaceOrder(driver);
        double shippingPrice = placeOrder.getShippingPrice();
        double fullPricePlusShipping = shippingPrice + fullPrice;
        double realOrderTotal = placeOrder.getOrderTotal();
        Assert.assertEquals(realOrderTotal, fullPricePlusShipping, "Wrong order total");
        Thread.sleep(3000);
        Assert.assertEquals(placeOrder.checkShippingInfo(), user.getName() + " " + user.getLastName() + "\n" +  user.getStreetAddress() + "\n"
                        + user.getCityName() + ", " + user.getZipCode() + "\n" + "Albania\n" + user.getPhone());
        Thread.sleep(1500);
        placeOrder.clickPlaceOrderButton();
        //Checkout
        Checkout checkout = new Checkout(driver);
        user.setOrderNumber(checkout.getOrderNumber());
        checkout.clickCreateAccountButton();
        //CreateAccount
        CreateAccount createAccount = new CreateAccount(driver);
        createAccount.typePassword();
        createAccount.typeConfirmPassword();
        createAccount.clickCreateAccountButton();
        Thread.sleep(3000);
        //MyAccount
        MyAccount myAccount = new MyAccount(driver);
        myAccount.clickMyOrder();
        Thread.sleep(1500);
        Assert.assertEquals(myAccount.checkMyOrderId(), user.getOrderNumber(), "Wrong order ID" );
        myAccount.clickprofileButton();
        myAccount.clickLogOutButton();
        Thread.sleep(6000);
        Assert.assertTrue(frontPage.checkLabel(), Utils.didNotLoadMessage("Front"));
    }

    @AfterSuite
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}