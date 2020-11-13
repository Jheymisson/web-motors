package PagesPesquisaCarro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Core.BasePageObject;
import io.cucumber.java.After;

public class SelecionarModeloDeCarro extends BasePageObject {

	public SelecionarModeloDeCarro(WebDriver driver) {
		super(driver);
	}

	private By btnTodosModelos = By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[5]/div[2]/div[2]/div[2]");
	private By opcaoModelo = By.xpath("//a[text()=\"CITY\"]");
	
	
	public SelecionarModeloDeCarro selecionarBotaoModelos() {
		driver.findElement(btnTodosModelos).click();
		return this;
	}
	
	public SelecionarModeloDeCarro selecionarOpcaoModelo() {
		wait.until(ExpectedConditions.elementToBeClickable(opcaoModelo));
		driver.findElement(opcaoModelo).click();
		return this;
	}
	
}
