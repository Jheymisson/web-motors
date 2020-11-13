package PagesPesquisaCarro;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Core.BasePageObject;

public class ResultadosPesquisa extends BasePageObject {

	public ResultadosPesquisa(WebDriver driver) {
		super(driver);
	}
	
	//Elementos de clique e digitacao
	private By btnTodosModelos = By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[5]/div[2]/div[2]/div[2]");
	private By opcaoModelo = By.xpath("//a[text()=\"CITY\"]");
	
	//Elementos de retorno de Strings
	private By nomeMarcaModelo = By.cssSelector("#FilterResultContainer > li:nth-child(2) > a");
	

	public ResultadosPesquisa selecionarBotaoModelos() {
		driver.findElement(btnTodosModelos).click();
		return this;
	}
	
	public ResultadosPesquisa selecionarOpcaoModelo() {
		wait.until(ExpectedConditions.elementToBeClickable(opcaoModelo));
		driver.findElement(opcaoModelo).click();
		return this;
	}
	
	
	/*
	 * métodos com retorno de texto ou value
	 */
	public String validarMarcaModelo() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(nomeMarcaModelo));
		return driver.findElement(nomeMarcaModelo).getText();
	}
	

	
//	public ResultadosPesquisa visualizarEstoque() {
//		if(listaDeAnunciosDeCarros().isEmpty())
//			System.out.println("Não tem carros no estoque");
//		else {
//			System.out.println("Lista de carros no estoque " + listaDeAnunciosDeCarros());
//		}
//		return this;
//	}
	
}
