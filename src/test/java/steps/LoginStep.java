package steps;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import pages.CreateAccountPage;
import pages.LoginPage;

public class LoginStep {
	private LoginPage loginPage;
	ChromeDriver driver = new ChromeDriver();

	public void LoginStep() {
		this.loginPage = new LoginPage(driver);
	}

	@Dado("^que eu acesse o site para login \"([^\"]*)\"$")
	public void que_eu_acesse_o_site_para_login(String site) throws Throwable {
		driver.get(site);
		driver.manage().window().maximize();
	}

	@Dado("^clico no menu User para login$")
	public void clico_no_menu_User_para_login() throws Throwable {
		new LoginPage(driver).setBtnMenuUser();
	}

	@Dado("^digito \"([^\"]*)\" e \"([^\"]*)\"$")
	public void digito_e(String username, String password) throws Throwable {
		new LoginPage(driver).setCmpUsername(username);
		new LoginPage(driver).setCmpPassword(password);
	}

	@Dado("^clico em Sign in$")
	public void clico_em_Sign_in() throws Throwable {
		new LoginPage(driver).setBtnSignIn();
	}
	
	@Entao("^valido o username no menu User \"([^\"]*)\" logado$")
	public void valido_o_username_no_menu_User_logado(String username) throws Throwable {
		new LoginPage(driver).setBtnSignOut(username);
	}

	@After
	public void bfechaBrowser() throws InterruptedException {
		driver.quit();
	}

}
