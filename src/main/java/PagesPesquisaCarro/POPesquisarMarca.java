package PagesPesquisaCarro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Core.BasePageObject;

public class POPesquisarMarca extends BasePageObject {

	public POPesquisarMarca(WebDriver driver) {
		super(driver);
	}
	
	private By abaCompraCarro = By.cssSelector("#WhiteBox > div.NavBar > div.NavBar--tabs h1:nth-child(1)");
	private By inputPesquisa = By.xpath("//input[@placeholder=\"Digite marca ou modelo do carro\"]");
	private By marca = By.xpath("//div[text()=\"Marcas\"]");
	private By selecionarOpcao = By.cssSelector("#WhiteBox > div.NavBar > div.NavBar--content > div > div > div > div > div > div:nth-child(1) > a");
	
	public POPesquisarMarca selecionarAbaComprarCarros() {
		driver.findElement(abaCompraCarro).click();
		return this;
	}
	
	public POPesquisarMarca digitarModelo(String modelo) {
		driver.findElement(inputPesquisa).click();
		driver.findElement(inputPesquisa).sendKeys(modelo);
		return this;
	}
	
	public POPesquisarMarca digitarMarca(String marca) {
		driver.findElement(inputPesquisa).sendKeys(marca);
		return this;
	}
	
	public ResultadosPesquisa selecionarOpcaoDropdownDaPesquisa() {
		boolean modelo = driver.findElement(marca).isDisplayed();
		if(modelo) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(selecionarOpcao));
			driver.findElement(selecionarOpcao).click();
		}
		return new ResultadosPesquisa(driver);
	}
	
}
