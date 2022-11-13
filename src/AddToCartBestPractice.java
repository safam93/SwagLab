import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AddToCartBestPractice {

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

		int expectedItemsAdded = 6;

		List<WebElement> myButtons = driver.findElements(By.className("btn"));

		for (int i = 0; i < myButtons.size(); i++) {

			myButtons.get(i).click();
		}

		String actualItemsAdded = driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();

		int converToInt = Integer.parseInt(actualItemsAdded);
		Assert.assertEquals(converToInt, expectedItemsAdded);
	}

}
