/*Drag and Drop
Neste desafio será necessário automatizar um carrinho de compras, onde as compras serão feitas arrastando os itens até o carrinho. Para que isso seja possível segue algumas dicas e os passos necessários para a automação deste desafio.

Para acessar o Carrinho de Compas e automatizar clique no link abaixo:
Carrinho de Compras 

Dicas:

Procupre pelos comandos de drag and drop no Selenium e verifique o que cada um faz
Use o Firebug para analisar o nome dos elementos
Quando for utilizar o comando de drag and drop o primeiro parâmetro é o elemento que representa o produto do carrinho e o segundo é o elemento que represente o próprio carrinho.

Se você conseguir colocar pelo menos um dos itens por automação ja está ótimo! Se conseguir isso eu sugiro você seguir os passos da sugestão:
SUGESTÃO: Passos a serem executados no script
Arraste os seguintes produtos para o Carrinho de Compas:
iPhone
iPod Shuffle
Apple TV
Valide o valor de cada um na lista e o valor total
Clique no botão 'Checkout'
Valide cada nome de produto e o valor total*/

package desafiosSelenium;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class desafio3 {
	
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUP() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://eliasnogueira.com/arquivos_blog/selenium/desafio/3desafio/drag_and_drop/demo.php";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void dragAndDrop() throws Exception {
		driver.get(baseUrl);
		WebElement iPod = driver.findElement(By.xpath("//div[@id='main-container']//img[@src='img/products/iPod-Shuffle.png']"));
		WebElement iPhone = driver.findElement(By.xpath("//div[@id='main-container']//img[@src='img/products/iPhone.png']"));
//		WebElement appleTv = driver.findElement(By.xpath("//div[@id='main-container']//img[@src='img/products/Apple-TV.png']"));
		WebElement carrinho = driver.findElement(By.xpath("//div[@id='cart-icon']//img[@src='img/Shoppingcart_128x128.png']"));
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(iPod).moveToElement(carrinho).release().build().perform();
		action.clickAndHold(iPhone).moveToElement(carrinho).release().build().perform();
//		action.clickAndHold(appleTv).moveToElement(carrinho).release().build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#table_3>tbody>tr>td")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#table_4>tbody>tr>td")));
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#table_6>tbody>tr>td")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='main-container']//a[text()='Checkout']")));
		
		driver.findElement(By.xpath("//div[@id='main-container']//a[text()='Checkout']")).click();
		
		assertEquals("1 x iPhone", driver.findElement(By.xpath("//h2[1]")).getText());
		assertEquals("1 x iPod Shuffle", driver.findElement(By.xpath("//h2[2]")).getText());
		assertEquals("Total: R$ 449", driver.findElement(By.xpath("//h1[2]")).getText());
		
	}

}
