package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Core.BasePageObject;
import Core.BaseTest;
import PagesPesquisaCarro.POPesquisarMarca;
import PagesPesquisaCarro.POResultadosPesquisa;
import PagesPesquisaCarro.POSelecionarModeloDeCarro;
import Utils.Reutilizavel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class SelecionarModeloDeCarroSteps  {

	private static WebDriver driver;
	
	@Before
	public static void inicializarNavegador() {
		driver = BaseTest.abreNavegador();
		driver.get("https://www.webmotors.com.br/");
		new Reutilizavel(driver)
			.aceitaCookies();
	}
	
	@Dado("entrar na página de resultados da pesquisa")
	public void entrar_na_página_de_resultados_da_pesquisa() {
		new POPesquisarMarca(driver)
			.selecionarAbaComprarCarros()
			.digitarMarca("HONDA")
			.selecionarOpcaoDropdownDaPesquisa();
		String marca =
		new POResultadosPesquisa(driver)
			.validarMarcaModelo();
		assertEquals(marca, "HONDA");
	}
	
	@Dado("selecionar modelo de um carro")
	public void selecionar_modelo_de_um_carro() {
		new Reutilizavel(driver)
			.scrollFrame();
		new POSelecionarModeloDeCarro(driver)
			.selecionarBotaoModelos()
			.selecionarOpcaoModelo();
	}

	@Quando("modelo for selecionado")
	public void modelo_será_selecionado_com_sucesso() {
		String marcaModelo =
		new POResultadosPesquisa(driver)
			.validarMarcaModelo();
		assertEquals(marcaModelo, "HONDA CITY");
	}
	
	@Entao("exportar os anuncios para um arquivo csv")
	public void exportar_os_anuncios_para_um_arquivo_csv() {
		new POResultadosPesquisa(driver)
			.exportaCsvResultado();
	} 
	
	@After
	public static void paralizacao() {
		driver.quit();
	}

}
