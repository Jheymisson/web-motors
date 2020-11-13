package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import Core.BaseTest;
import Estoque.POEstoque;
import Utils.Reutilizavel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class EstoqueSteps {

	
	private static WebDriver driver;
	
	
	@Before
	public static void inicializarNavegador() {
		driver = BaseTest.abreNavegador();
		driver.get(Reutilizavel.urlEstoque);
		new Reutilizavel(driver)
			.aceitaCookies();
	}
	
	@Dado("entrar na pagina de estoque da loja")
	public void entrar_na_pagina_de_estoque_da_loja() {
		String current =
		new POEstoque(driver)
			.validarUrl();
		assertEquals(current, Reutilizavel.urlEstoque);
	}

	@Dado("validar a pagina estoque")
	public void validar_a_pagina_estoque() {
		String tagLoja =
		new POEstoque(driver)
			.validarNomeDaTag();
		assertEquals(tagLoja, "CONCESSIONÁRIA, LOJA");
	}

	@Entao("exportar os anuncios para um arquivo csv")
	public void exportar_os_anuncios_para_um_arquivo_csv() {
		new POEstoque(driver)
			.exportaCsv();
	}
	
	@After
	public static void paralizacao() {
		driver.quit();
	}
	
}
