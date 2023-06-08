package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class TestBase {
	private static WebDriver driver;
	public static Properties prop;

   public static String URL = "https://subscribe.stctv.com/sa-en";
  
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
	public static void CloseBrowser() {
		
		try {
			driver.quit();
		
		} catch (Exception ex) {
	
		}

	}

}
