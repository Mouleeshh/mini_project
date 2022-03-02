package xpractice;


import java.awt.Window;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Xpath {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\Muthukumar\\eclipse-workspace\\DemoProject\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement Tshirts = driver.findElement(By.xpath("(//a[text()='T-shirts'])[2]"));

		Actions a= new Actions(driver);
		a.moveToElement(Tshirts).build().perform();
		a.click(Tshirts).build().perform();

		WebElement pro = driver.findElement(By.xpath("(//a[@class='product-name'])[2]"));
		a.moveToElement(pro).build().perform();
		a.click(pro).build().perform();

		driver.findElement(By.xpath("//span[text()='Add to cart']")).click();

		driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']")).click();

		WebElement proceed = driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]"));
		a.moveToElement(proceed).build().perform();
		a.click().build().perform();

		driver.findElement(By.id("email")).sendKeys("mwtrainee@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("123456");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.findElement(By.name("processAddress")).click();
		WebElement click = driver.findElement(By.id("cgv"));
		a.moveToElement(click).build().perform();
		a.click().build().perform();
		driver.findElement(By.name("processCarrier")).click();

		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("window.scrollBy(0,400);");

		driver.findElement(By.xpath("//a[@title='Pay by check.']")).click();
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

		JavascriptExecutor sc = (JavascriptExecutor) driver;
		sc.executeScript("window.scrollBy,(0,1000);");

		Thread.sleep(3000);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);

		File dest = new File("C:\\Users\\Muthukumar\\eclipse-workspace\\Selenium_Practise\\Screenshot\\pic2.png");

		org.openqa.selenium.io.FileHandler.copy(src, dest) ;





	}

}


