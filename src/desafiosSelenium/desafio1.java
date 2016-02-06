/*Soma com números aleatórios
Neste desafio, tente criar um script que some os dois valores e os inclua na caixa de texto. O resultado tem que ser o texto 'Correto'.

Dicas!!!

Tente pegar o valor dos dois números
Tente somá-los com o Selenium
Insira o valor somado na caixa de texto
Você vai precisar utilizar, no Selenium IDE, alguns comandos (não exatamente os que serão listados para não perder a graça, mas proximo deles):
assertText
store
*/
package desafiosSelenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

public class desafio1 {
	
	private WebDriver driver;
	private WebDriverWait wait;
//	private WebElement resultado;
	private String baseUrl;
	private int numero1;
	private int numero2;
	private int soma;
	
	@Before
	public void setUP() throws Exception {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		baseUrl = "http://eliasnogueira.com/arquivos_blog/selenium/desafio/1desafio/";
		numero1 = 0;
		numero2 = 0;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void somaNumerosAleatorios() throws Exception {
		driver.get(baseUrl);
		numero1 = Integer.parseInt(driver.findElement(By.id("number1")).getText());
		numero2 = Integer.parseInt(driver.findElement(By.id("number2")).getText());
		soma = numero1+numero2;
		driver.findElement(By.name("soma")).clear();
		driver.findElement(By.name("soma")).sendKeys(String.valueOf(soma));
		driver.findElement(By.name("submit")).click();
//		resultado = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("resultado")));
		Thread.sleep(2000);
		assertEquals("CORRETO", driver.findElement(By.id("resultado")).getText());
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
