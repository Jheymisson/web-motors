package StepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Core.BasePageObject;

public class SelecionarModelodDeCarro extends BasePageObject {

	public SelecionarModelodDeCarro(WebDriver driver) {
		super(driver);
	}
	
	//Lista com informacoes do anuncio
	List<WebElement> listaMarcaModelo = new ArrayList();
	List<WebElement> listaEspecificacoes = new ArrayList();
	List<WebElement> listaPrecos = new ArrayList();
	
	//Elementos que compoe a lista dos anuncios
	private By listaNomeMarcaModelo = By.cssSelector("div.Search-result.Search-result--container-right > div:nth-child(4) > div.ContainerCardVehicle > div > div > div div div:nth-child(2) a div h2");
	private By listaEspecificacaoCarro = By.cssSelector("div.Search-result.Search-result--container-right > div:nth-child(4) > div.ContainerCardVehicle > div > div > div div div:nth-child(2) a div h3");
	private By listaPrecosCarro = By.cssSelector("div.Search-result.Search-result--container-right > div:nth-child(4) > div.ContainerCardVehicle > div > div > div div div:nth-child(2) a:nth-child(2) > strong");
	
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

}
