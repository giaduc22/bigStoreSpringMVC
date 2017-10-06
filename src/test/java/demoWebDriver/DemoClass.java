package demoWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DemoClass {
	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
		// Notice that the remainder of the code relies on the interface,
		// not the implementation.
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		
		
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary("C:\\Program Files\\Firefox Developer Edition\\firefox.exe");
		
		WebDriver driver = new FirefoxDriver(firefoxOptions);
		// And now use this to visit Google
		driver.get("http://localhost:8080/SpringMVC/");
		
		
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://www.google.com");

		// Find the text input element by its name
		WebElement element = driver.findElement(By.linkText("Product manager"));

		// Enter something to search for
		element.click();

		// Now submit the form. WebDriver will find the form for us from the
		// element

		// Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());

		// Close the browser
		driver.quit();
	}
}
