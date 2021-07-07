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

public class CreateAccountStep {
	private CreateAccountPage createAccountPage;
	ChromeDriver driver = new ChromeDriver();

	public void CreateAccountStep() {
		this.createAccountPage = new CreateAccountPage(driver);
	}

	@Dado("^que eu acesse o site para cadastro \"([^\"]*)\"$")
	public void que_eu_acesse_o_site_para_cadastro(String site) throws Throwable {
		driver.get(site);
		driver.manage().window().maximize();
	}

	@Dado("^clico no menu User para cadastro$")
	public void clico_no_menu_User_para_cadastro() throws Throwable {
		new CreateAccountPage(driver).setBtnMenuUser();
	}

	@Dado("^clico no botao Create new account$")
	public void clico_no_botao_Create_new_account() throws Throwable {
		new CreateAccountPage(driver).setBtnCreateNewAcc();
	}

	@Dado("^preencho o formulario com os dados \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void preencho_o_formulario_com_os_dados(String username, String password, String email, String firstName,
			String lastName, String phoneNumber, String country, String city, String address, String state,
			String postalCode) throws Throwable {
		new CreateAccountPage(driver).setCmpUserName(username);
		new CreateAccountPage(driver).setCmpPassword(password);
		new CreateAccountPage(driver).setCmpEmail(email);
		new CreateAccountPage(driver).setCmpFirstName(firstName);
		new CreateAccountPage(driver).setCmpLastName(lastName);
		new CreateAccountPage(driver).setCmpPhoneNumber(phoneNumber);
		new CreateAccountPage(driver).setCmpCountry(country);
		new CreateAccountPage(driver).setCmpCity(city);
		new CreateAccountPage(driver).setCmpAddress(address);
		new CreateAccountPage(driver).setCmpState(state);
		new CreateAccountPage(driver).setCmpPostalCode(postalCode);
	}

	@Dado("^seleciono checkbox Conditions of use$")
	public void seleciono_checkbox_Conditions_of_use() throws Throwable {
		new CreateAccountPage(driver).setCheckConditions();
	}

	@Quando("^clico no botao Register$")
	public void clico_no_botao_Register() throws Throwable {
		new CreateAccountPage(driver).setBtnRegister();
	}

	@Entao("^valido o username no menu User \"([^\"]*)\" cadastrado$")
	public void valido_o_username_no_menu_User_cadastrado(String username) throws Throwable {
		new CreateAccountPage(driver).setBtnSignOut(username);
	}

	@After
	public void bfechaBrowser() throws InterruptedException {
		driver.quit();
	}

}
