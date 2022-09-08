package pom;

import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Login {
	WebDriver driver;

	@CacheLookup
	@FindBy(id = "ap_email")
	WebElement emailid;

	@CacheLookup
	@FindBy(id = "ap_password")
	WebElement passwd;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-flyout-ya-signin\']/a/span")
	WebElement signinpage;

	@CacheLookup
	@FindBy(id = "continue")
	WebElement Continuebtn;

	@CacheLookup
	@FindBy(id = "signInSubmit")
	WebElement signinbtn;

	@CacheLookup
	@FindBy(partialLinkText = "Forgotten password?")
	WebElement forgotPasswordLink;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-link-accountList\']/span")
	WebElement Accountlist;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-al-your-account\']/a[3]/span")
	WebElement wishlist;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-xshop\']/a[11]")
	WebElement accountpay;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'nav-xshop\']/a[9]")
	WebElement newrelease;

	@CacheLookup
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchbox;

	@CacheLookup
	@FindBy(id = "nav-search-submit-button")
	WebElement searchbtn;

	@CacheLookup
	@FindBy(xpath = "//*[@id='search']/span/div/h1/div/div[1]/div/div/span[1]")
	WebElement searchresults;

	@CacheLookup
	@FindBy(xpath = "//*[@id=\'p_72/1318476031\']/span/a/section/i")
	WebElement custreview;

	
	////div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']
	@CacheLookup
	//@FindBy(xpath="//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/div[1]")
	@FindBy(xpath="//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']")
	WebElement FirstProduct;
	
	@CacheLookup
	@FindBy(xpath="//*[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[2]/span[2]/span[1]")
	WebElement symbol ;
	
	@CacheLookup
	@FindBy(xpath="//*[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[2]/span[2]/span[2]")
	WebElement pricewhole ;
	
	
	
	@CacheLookup
	@FindBy(xpath="//*[@id='corePriceDisplay_desktop_feature_div']/div[1]/span[2]/span[2]/span[3]")
	WebElement fractions;
	
	@CacheLookup
	@FindBy(id="contextualIngressPtLabel_deliveryShortLine")
	WebElement Location;
	

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginWithCredentials(String username, String password) {

		Reporter.log("username = " + username);
		Reporter.log("password = " + password);
		emailid.clear();
		emailid.sendKeys(username);
		Continuebtn.click();

		passwd.clear();
		passwd.sendKeys(password);

	}

	public void InvalidloginWithCredentials(String username, String password) {

		Reporter.log("username = " + username);
		Reporter.log("password = " + password);
		emailid.clear();
		emailid.sendKeys(username);
		Continuebtn.click();

	}

	public void forgotPassword(String username) {
		forgotPasswordLink.click();
	}

	public void Hover_Accounts() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Accountlist).perform();
		signinpage.click();

	}

	public void Accountwishlist() {
		Actions actions = new Actions(driver);
		actions.moveToElement(Accountlist).perform();
		wishlist.click();

	}

	public void Account_Pay_Module() {
		accountpay.click();
	}

	public void New_Release_Module() {
		newrelease.click();
	}

	public void searchtextbox() {
		searchbox.click();
		searchbox.sendKeys("mi mobile");
		searchbtn.click();
		Reporter.log("navigated to search box successfully ");
	}

	public void result_text() {
		String expected = "1-16 of 76 results for";
		String result = searchresults.getText();
		String failureMessage = " results does not match";
		System.out.println(result);
		assertTrue(result.equals(expected), failureMessage + ",");
		Reporter.log(result + " mi mobile");
		Reporter.log(expected + " mi mobile");
	}

	public void CustomerReview() {
		custreview.click();
		Reporter.log("4 star customer reveiew clicked successfully");
	}

	public void Select_product()
	{   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		//FirstProduct.click();
		
		String StrResultPath = "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']";

		driver.findElements(By.xpath(StrResultPath)).get(1).click();
		Reporter.log("First mi mobile product selected successfully with 4 star rating");
		//FirstProduct.get(0).click();
		
		
	}
	public void productPrice()
	{
		String Sym= symbol.getText();
		String pri =pricewhole.getText();
		String frac =fractions.getText();
		Reporter.log(Sym+" "+pri+"."+frac);
		
	}
	
	public void selectDelivery()
	{
		Location.click();
		Location.sendKeys("560079");
	}
}
