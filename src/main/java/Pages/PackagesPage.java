package Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

//import  java.time.Duration.ofSeconds;


public class PackagesPage {

	  public static WebDriver driver ;
	public static String URL = "https://subscribe.stctv.com/sa-en";
	//public WebDriverWait wait;

	//Locators of the page
	// By currentCountry = By.id("country-btn");
	By kwCountry = By.id("kw");
	By saCountry = By.id("sa");
	By bhCountry = By.id("bh");
	static By litePackage = By.id("name-lite");
	static By classicPackage = By.id("name-classic");
	static By premiumPackage =By.id("name-premium");
	static By priceLite = By.xpath("//div[@id='currency-lite']/b");
	static By priceClassic= By.xpath("//div[@id='currency-classic']/b");
	static By pricePremium = By.xpath("//div[@id='currency-premium']/b");
	static By currentCurrency = By.xpath("//div[@id='currency-classic']/i");


	
	
	// Constructor
	public PackagesPage(WebDriver driver) {
		PackagesPage.driver = driver;
		//PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
		//this.wait = new WebDriverWait(driver,1000);
		//this.wait = new WebDriverWait(driver, ofSeconds(10));
		//@deprecated Instead, use {@link WebDriverWait#WebDriverWait(WebDriver, Duration)};


	}

	public static void selectCountryByCode(String code) throws InterruptedException{
		//driver.findElement( By.xpath( "//a[@id='" + code + "']" ) );
		driver.findElement( By.id( code + "-contry-flag" ) ).click();
	}

	//navigate to kuwait country
	public static void NavigateKuwaitCountry() throws InterruptedException {

		//wait.until(ExpectedConditions.visibilityOfElementLocated(kwCountry));
		//driver.findElement(kwCountry).click();
	}
	//navigate to Bahrien country
	public static void NavigateBahrainCountry() throws InterruptedException {

		//wait.until(ExpectedConditions.visibilityOfElementLocated(bhCountry));
		//driver.findElement(bhCountry).click();
	}
	// click on current country button
		public static void clickCurrentCountry() throws InterruptedException {
	
			//wait.until(ExpectedConditions.visibilityOfElementLocated(currentCountry));
			driver.findElement(By.id("country-btn")).click();
		}

//		public static void selectCountryByCode(String code)throws InterruptedException{
//		driver.findElement(By.xpath("//*[@id='" + code + "']" ) );
//		}
	// click on Saudi country button
	public static void clickSACountry() throws InterruptedException {

		//wait.until(ExpectedConditions.visibilityOfElementLocated(saCountry));
		//driver.findElement(saCountry).click();
	}
	// click on Kuwait country button
	public static void clickKWCountry() throws InterruptedException {

		//wait.until(ExpectedConditions.visibilityOfElementLocated(kwCountry));
		//driver.findElement(kwCountry).click();
	}
	// click on Bahrin country button
	public void clickBHCountry() throws InterruptedException {

		//wait.until(ExpectedConditions.visibilityOfElementLocated(bhCountry));
		driver.findElement(bhCountry).click();
	}
	//Verify Lite Package exists
	public static String verifyLitePackageExists()throws InterruptedException{

		//wait.until(ExpectedConditions.visibilityOfElementLocated(litePackage));

		String actualText = driver.findElement(litePackage).getText();
		System.out.println( actualText );
		return actualText;


	}


	//Verify Classic Package exists
	public static String verifyClassicPackageExists()throws InterruptedException{

		//wait.until(ExpectedConditions.visibilityOfElementLocated(classicPackage));

		String actualText = driver.findElement(classicPackage).getText();
		System.out.println( actualText );
		return actualText;


	}
	//Verify Premium Package exists
	public static String verifyPremiumPackageExists()throws InterruptedException {

		//wait.until(ExpectedConditions.visibilityOfElementLocated(premiumPackage));

		String actualText = driver.findElement(premiumPackage).getText();
		System.out.println( actualText );
		return actualText;
	}

	public static double getLitePricing()throws InterruptedException{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(priceLite));
		String actualText = driver.findElement(priceLite).getText();
		double i=Double.parseDouble( actualText );
		return i;
		}
	public static double getClassicPricing()throws InterruptedException{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(priceClassic));
		String actualText = driver.findElement(priceClassic).getText();
		double i= Double.parseDouble( actualText );
		return i;
	}
	public static double getPremiumPricing()throws InterruptedException{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(pricePremium));
		String actualText = driver.findElement(pricePremium).getText();
		double i=Double.parseDouble( actualText );
		return i;
	}
	public static String getCurrentCurrency()throws InterruptedException{
		//wait.until(ExpectedConditions.visibilityOfElementLocated(currentCurrency));
		String actualText = driver.findElement(currentCurrency).getText();
		return actualText;
	}
	public static WebElement countryFlag(String country) {

		return driver.findElement(By.id(country + "-contry-flag"));
	}



	public static void initialization()  {


		//set the path of chrome driver
		//System.setProperty("webdriver.chrome.driver",
		//	System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");

		WebDriverManager.chromedriver().setup();
		// Initialize browser
		driver = new ChromeDriver();

		// Open the URL ..
		driver.get(URL);
		driver.manage().window().maximize();

	}
		public static void takeScreenshot(WebDriver driver, String fileName) throws  IOException {
			fileName = fileName + ".png";
			String userDirectory = System.getProperty("user.dir");
			String directory = userDirectory+ "\\Screenshots\\" ;
			File sourceFile;
			sourceFile = ((TakesScreenshot)driver).getScreenshotAs( OutputType.FILE);
			FileUtils.copyFile(sourceFile , new File(directory + fileName));
			String destination = directory + fileName;


		}
	public static void CloseBrowser() {

		try {
			driver.quit( );

		} catch (Exception ex) {

		}
	}
}


