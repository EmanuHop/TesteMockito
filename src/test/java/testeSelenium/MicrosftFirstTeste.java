package testeSelenium;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class MicrosftFirstTeste {
	private WebDriver driver;
	private String URL_BASE = "https://www.google.com.br/";
	private String PATH_DRIVE = "src/test/resource/msedgedriver.exe";
	
	private void iniciar() {
		System.setProperty("webdriver.edge.driver", PATH_DRIVE);
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}
	
	@Test
	public void pesquisaNoGoogleTest() {
		iniciar();
		
		WebElement inputPesquisa = driver.findElement(By.name("q"));
		
		inputPesquisa.sendKeys("Carrinho da hot wheels" + Keys.ENTER);
		
		String result = driver.findElement(By.id("result-stats")).getText();
		
		System.out.println(result);
		
		assertTrue(result, result.contains("Aproximadamente"));
		
		driver.quit();
	}
}
