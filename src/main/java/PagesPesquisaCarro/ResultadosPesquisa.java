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
	
	//Lista com informacoes do anuncio
	List<WebElement> listaMarcaModelo = new ArrayList();
	List<WebElement> listaEspecificacoes = new ArrayList();
	List<WebElement> listaPrecos = new ArrayList();
	
	//Elementos de clique e digitacao
	private By btnTodosModelos = By.xpath("//*[@id=\"root\"]/main/div[1]/div[2]/div/div[1]/div[2]/div[2]/div/form/div[5]/div[2]/div[2]/div[2]");
	private By opcaoModelo = By.xpath("//a[text()=\"CITY\"]");
	
	//Elementos de retorno de Strings
	private By nomeMarcaModelo = By.cssSelector("#FilterResultContainer > li:nth-child(2) > a");
	
	//Elementos que compoe a lista dos anuncios
	private By listaNomeMarcaModelo = By.cssSelector("div.Search-result.Search-result--container-right > div:nth-child(4) > div.ContainerCardVehicle > div > div > div div div:nth-child(2) a div h2");
	private By listaEspecificacaoCarro = By.cssSelector("div.Search-result.Search-result--container-right > div:nth-child(4) > div.ContainerCardVehicle > div > div > div div div:nth-child(2) a div h3");
	private By listaPrecosCarro = By.cssSelector("div.Search-result.Search-result--container-right > div:nth-child(4) > div.ContainerCardVehicle > div > div > div div div:nth-child(2) a:nth-child(2) > strong");
	
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
	
	/*
	 * Métodos que compoe a lista dos anuncios
	 */
	public List<String> listaDeMarcaModelo(){
		listaMarcaModelo = driver.findElements(listaNomeMarcaModelo);
		List<String> marcaModelo = new ArrayList<String>();
		for(WebElement obj : listaMarcaModelo) {
			marcaModelo.add(obj.getText());
		}
		return marcaModelo;
	}
	
	public List<String> listaDeEspecificacoes(){
		listaEspecificacoes = driver.findElements(listaEspecificacaoCarro);
		List<String> especificacao = new ArrayList<String>();
		for(WebElement obj : listaEspecificacoes) {
			especificacao.add(obj.getText());
		}
		return especificacao;
	}

	public List<String> listaDePreco(){
		listaPrecos = driver.findElements(listaPrecosCarro);
		List<String> precos = new ArrayList<String>();
		for(WebElement obj : listaPrecos) {
			precos.add(obj.getText());
		}
		return precos;
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
