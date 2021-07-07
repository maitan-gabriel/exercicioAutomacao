package pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class BasePage {
	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void takeScreenshot(String fileName) {
		DateTimeFormatter date = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
		LocalDateTime dateNow = LocalDateTime.now();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Date data = new Date();
		try {
			FileUtils.copyFile(scrFile, new File("screenshots/" + fileName + date.format(dateNow) + ".jpeg"), true);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
