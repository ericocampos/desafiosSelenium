package aulasUdemy;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverActions {
	
//	Aula 61
	
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://www.dhtmlx.com";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testMouseHoverActions() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(1000);
		
		// Elemento Principal - Products
		WebElement mainElement = driver.findElement(By.xpath(".//li[@xtitle='products']//a"));
		
		// Sub-elemento - DHTMLX Suite
		WebElement subElement = driver.findElement(By.linkText("DHTMLX Suite"));
		
		// Ações que serão executadas, utilizam o Actions!
		Actions action = new Actions(driver);
		
		// A ação consiste em um grupo de ações que serão "buildadas" juntas
		// Aqui ocorrem 3 ações:
		// 1. Move para o elemento mainElement
		// 2. Move para o elemento subElement
		// 3. Clica no subElement
		// 4. Builda a ação
		// 5. Realiza a ação
		action.moveToElement(mainElement).moveToElement(subElement).click().build().perform();
		assertEquals("DHTMLX Suite", driver.findElement(By.xpath(".//*[@id='topblock']/div[1]/div[1]/h1")).getText());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
	}
	

}
