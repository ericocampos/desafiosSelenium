package desafiosSelenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class desafio2 {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private String nome;
	private String email;
	private String telefone;

	@Before
	public void setUP() {
		driver = new FirefoxDriver();
		driver.get("http://eliasnogueira.com/arquivos_blog/selenium/desafio/2desafio/");
		wait = new WebDriverWait(driver, 10);
		nome = "Erico Campos";
		email = "ericocampos@gmail.com";
		telefone = "83 98828-7258";
	}
	
	@Test
	public void testDesafio2() throws Exception {
		// Alterando o nome
		driver.findElement(By.id("name_rg_display_section")).click();
		driver.findElement(By.id("nome_pessoa")).clear();
		driver.findElement(By.id("nome_pessoa")).sendKeys(nome);
		driver.findElement(By.xpath(".//*[@id='name_hv_editing_section']/input[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name_rg_display_section")));
		
		// Alterando o email
		driver.findElement(By.id("email_rg_display_section")).click();
		driver.findElement(By.id("email_value")).clear();
		driver.findElement(By.id("email_value")).sendKeys(email);
		driver.findElement(By.xpath(".//*[@id='email_hv_editing_section']/input[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_rg_display_section")));
		
		// Alterando o telefone
		driver.findElement(By.id("phone_rg_display_section")).click();
		driver.findElement(By.id("phone_value")).clear();
		driver.findElement(By.id("phone_value")).sendKeys(telefone);
		driver.findElement(By.xpath(".//*[@id='phone_hv_editing_section']/input[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone_rg_display_section")));
		
		// Validação dos dados
		assertEquals(nome, driver.findElement(By.id("name_rg_display_section")).getText());
		assertEquals("Email: " + email, driver.findElement(By.id("email_rg_display_section")).getText());
		assertEquals("Telefone: " + telefone, driver.findElement(By.id("phone_rg_display_section")).getText());
	}
	
	@After
	public void  tearDown() {
		driver.quit();
	}
	
}
