package pages;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage extends BasePage {
	private Wait<WebDriver> wait;
	String usuarioLogado;
	String fileName = "loginConta";

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(2000)).ignoring(NoSuchElementException.class);
	}

	public void setBtnMenuUser() {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuUserLink']")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@class='loader']")));
		driver.findElement(By.xpath("//a[@id='menuUserLink']")).click();
	}
	
	public void setCmpUsername(String username) {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@class='loader']")));
		driver.findElement(By.name("username")).sendKeys(username);
	}
	
	public void setCmpPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	public void setBtnSignIn() {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@class='loader']")));
		driver.findElement(By.xpath("//button[.='SIGN IN']")).click();
	}
	
	public void setBtnSignOut(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains (@class, 'containMiniTitle')]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@class='loader']")));
		assertEquals(username, usuarioLogado = driver.findElement(By.xpath(".//*[contains (@class, 'containMiniTitle')]")).getText());
		System.out.println("Usuario validado: " + usuarioLogado);
		takeScreenshot(fileName);
	}

}
