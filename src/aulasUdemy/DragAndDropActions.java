package aulasUdemy;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {
	
	// Aula 62
	
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://dhtmlx.com/docs/products/dhtmlxTree/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testDragAndDrop() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(6000);
		
		// Elemento De
		WebElement deElement1 = driver.findElement(By.xpath(".//*[@id='treebox1']//span[text()='James Johns']"));
		WebElement deElement2 = driver.findElement(By.xpath(".//*[@id='treebox1']//span[text()='Nancy Atherton']"));
		
		// Elemento Para
		WebElement paraElement = driver.findElement(By.xpath("//div[@id='treebox2']//span[text()='Bestsellers']"));
		
		
		// Ações que serão executadas, utilizam o Actions!
		Actions action = new Actions(driver);
//		action.clickAndHold(deElement1).moveToElement(paraElement).release(paraElement).build().perform();
//		Thread.sleep(6000);
//		action.clickAndHold(deElement2).moveToElement(paraElement).release(paraElement).build().perform();
		action.dragAndDrop(deElement1, paraElement).build().perform();
		
		

	}

//	@After
//	public void tearDown() throws Exception {
//		driver.quit();
//		
//	}
	

}
