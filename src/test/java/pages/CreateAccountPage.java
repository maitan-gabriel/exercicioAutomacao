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

public class CreateAccountPage extends BasePage {
	private Wait<WebDriver> wait;
	String usuarioLogado;
	String fileName = "cadastroConta";

	public CreateAccountPage(WebDriver driver) {
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

	public void setBtnCreateNewAcc() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@translate='CREATE_NEW_ACCOUNT']")));
		driver.findElement(By.xpath("//a[@translate='CREATE_NEW_ACCOUNT']")).click();
	}

	public void setCmpUserName(String username) throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("usernameRegisterPage")));
		driver.findElement(By.name("usernameRegisterPage")).sendKeys(username);
	}

	public void setCmpEmail(String email) {
		driver.findElement(By.name("emailRegisterPage")).sendKeys(email);
	}

	public void setCmpPassword(String password) {
		driver.findElement(By.name("passwordRegisterPage")).sendKeys(password);
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(password);
	}

	public void setCmpFirstName(String firstName) {
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys(firstName);
	}

	public void setCmpLastName(String lastName) {
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys(lastName);
	}

	public void setCmpPhoneNumber(String phoneNumber) {
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys(phoneNumber);
	}

	public void setCmpCountry(String country) {
		driver.findElement(By.name("countryListboxRegisterPage")).sendKeys(country);
	}

	public void setCmpCity(String city) {
		driver.findElement(By.name("cityRegisterPage")).sendKeys(city);
	}

	public void setCmpAddress(String address) {
		driver.findElement(By.name("addressRegisterPage")).sendKeys(address);
	}

	public void setCmpState(String state) {
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(state);
	}

	public void setCmpPostalCode(String postalCode) {
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(postalCode);
	}

	public void setCheckConditions() {
		driver.findElement(By.name("i_agree")).click();
	}

	public void setBtnRegister() {
		driver.findElement(By.id("register_btnundefined")).click();
	}
	
//	public void setBtnSignOut() {
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='menuUserLink']")));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@class='loader']")));
//		driver.findElement(By.xpath("//a[@id='menuUserLink']")).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='loginMiniTitle']/label[3]")));
//	}
	
	public void setBtnSignOut(String username) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[contains (@class, 'containMiniTitle')]")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@class='loader']")));
		assertEquals(username, usuarioLogado = driver.findElement(By.xpath(".//*[contains (@class, 'containMiniTitle')]")).getText());
		System.out.println("Usuario validado: " + usuarioLogado);
		takeScreenshot(fileName);
	}

}
