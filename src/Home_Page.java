import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Home_Page {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Eclipse\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		
		
		String user_name = "standard_user";
		String password = "secret_sauce";
		
		driver.findElement(By.id("user-name")).sendKeys(user_name);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		
		Assert.assertEquals(actualTitle,expectedTitle);
		


				
	}
}


