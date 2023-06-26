package TestDemoMaven1.TestDemoMaven1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {

	static WebDriver d;

	@BeforeMethod
	public void openBrowser() {
		d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		d.manage().window().maximize();
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Test
	public void loginTest1() {

		d.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		d.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement dashboard = d.findElement(By.xpath("//h6[text()='Dashboard']"));
		try {
			if (dashboard.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("Login Success");
			} else {
				System.out.println("Login Failed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println("Login Failed");
			e.printStackTrace();
		}
	}

	@Test
	public void loginTest2() {

		d.findElement(By.xpath("//input[@name='username']")).sendKeys("admin123");
		d.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		d.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement dashboard = d.findElement(By.xpath("//h6[text()='Dashboard']"));
		try {
			if (dashboard.isDisplayed()) {
				Assert.assertTrue(true);
				System.out.println("Login Success");
			} else {
				System.out.println("Login Failed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			System.out.println( e.getMessage() + "Login Failed");
		}
	}

	@AfterMethod
	public void tearDown() {
		d.quit();
	}
}
