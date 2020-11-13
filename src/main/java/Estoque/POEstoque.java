package Estoque;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Core.BasePageObject;

public class POEstoque extends BasePageObject {

	public POEstoque(WebDriver driver) {
		super(driver);
	}

	//Lista com informacoes do anuncio
	List<WebElement> listaMarcaModelo = new ArrayList();
	List<WebElement> listaEspecificacoes = new ArrayList();
	List<WebElement> listaPrecos = new ArrayList();
	
	//Elementos que compoe a lista dos anuncios
	private By listaNomeMarcaModelo = By.cssSelector("div.Search-result.Search-result--container-right > div:nth-child(3) > div > div:nth-child(1) > div:nth-child(1) div > div > div:nth-child(2) > a:nth-child(1) > div:nth-child(3) > h2");
	private By listaEspecificacaoCarro = By.cssSelector("div.Search-result.Search-result--container-right > div:nth-child(3) > div > div:nth-child(1) > div:nth-child(1) div > div > div:nth-child(2) > a:nth-child(1) > div:nth-child(3) > h3");
	private By listaPrecosCarro = By.cssSelector("div.Search-result.Search-result--container-right > div:nth-child(3) > div > div:nth-child(1) > div:nth-child(1) div > div > div:nth-child(2) > a:nth-child(2) > Strong");
	
	//Elementos de retorno de Strings
	private By verificaTag = By.cssSelector("#FilterResultContainer > li:nth-child(3) > a");
	
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
	
	public POEstoque exportaCsv() {
		List<String> listaMarcaModelo = listaDeMarcaModelo();
		List<String> listaEspecificacoes = listaDeEspecificacoes();
		List<String> listaPrecos = listaDePreco();
		File f = new File(".\\estoqueDaLoja.csv");
		try {
			FileWriter fw = new FileWriter(f);
			fw.write("Marca e Modelo; Especificacoes; Precos");
			fw.write("\n");
			for(int i=0;i < listaMarcaModelo.size(); i++){
				String linha = 
						listaMarcaModelo.get(i) + ";" 
						+ listaEspecificacoes.get(i) + ";"
						+ listaPrecos.get(i);
				fw.write(linha);
				fw.write("\n");
			}
			fw.flush();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao criar arquivo");
		}
		return this;
	}
	
	
	/*
	 * métodos com retorno de texto ou value
	 */
	public String validarNomeDaTag() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(verificaTag));
		return driver.findElement(verificaTag).getText();
	}
	
	public String validarUrl() {
		return driver.getCurrentUrl();
	}
}
