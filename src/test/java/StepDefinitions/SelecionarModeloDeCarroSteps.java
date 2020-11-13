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
import PagesPesquisaCarro.ResultadosPesquisa;
import PagesPesquisaCarro.SelecionarModeloDeCarro;
import Utils.Reutilizavel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

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
		new ResultadosPesquisa(driver)
			.validarMarcaModelo();
		assertEquals(marca, "HONDA");
	}
	
	@Dado("selecionar modelo de um carro")
	public void selecionar_modelo_de_um_carro() {
		new Reutilizavel(driver)
			.scrollFrame();
		new SelecionarModeloDeCarro(driver)
			.selecionarBotaoModelos()
			.selecionarOpcaoModelo();
	}

	@Entao("modelo será selecionado com sucesso")
	public void modelo_será_selecionado_com_sucesso() {
		String marcaModelo =
		new ResultadosPesquisa(driver)
			.validarMarcaModelo();
		assertEquals(marcaModelo, "HONDA CITY");
	}
	
	@After
	public static void paralizacao() {
		driver.quit();
	}

}
