package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import Core.BaseTest;
import PagesPesquisaCarro.POPesquisarMarca;
import PagesPesquisaCarro.ResultadosPesquisa;
import PagesPesquisaCarro.SelecionarModeloDeCarro;
import StepDefinitions.SelecionarModeloDeCarroSteps;
import Utils.Reutilizavel;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class PesquisarMarcaModeloTest extends BaseTest {

	private static WebDriver driver;
	
	@BeforeAll
	public static void inicializarNavegador() {
		driver = BaseTest.abreNavegador();
		driver.get("https://www.webmotors.com.br/");
		new Reutilizavel(driver)
			.aceitaCookies();
	}
	
	@Test
	void TC001_Deve_Buscar_Carro_Preenchendo_A_Marca() {
		new POPesquisarMarca(driver)
			.selecionarAbaComprarCarros()
			.digitarMarca("HONDA")
			.selecionarOpcaoDropdownDaPesquisa();
		String marcaModelo =
		new ResultadosPesquisa(driver)
			.validarMarcaModelo();
		assertEquals(marcaModelo, "HONDA");
	}
	
	@Test
	void TC002_Deve_Selecionar_Modelo() {
		new Reutilizavel(driver)
			.scrollFrame();
		new SelecionarModeloDeCarro(driver)
			.selecionarBotaoModelos()
			.selecionarOpcaoModelo();
		String marcaModelo =
		new ResultadosPesquisa(driver)
			.validarMarcaModelo();
		assertEquals(marcaModelo, "HONDA CITY");	
	}
	
	@Test
	void TC003_Deve_Listar_Os_Anuncios_Da_Pagina_Resultados() {
		new ResultadosPesquisa(driver)
			.exportaCsvResultado();
	}
	
    /*
     * Metodo criado para finalizar o driver do navegador apï¿½s todos os testes terem sidos executadas.
    */
	@AfterAll
	public static void paralizacao() {
		driver.quit();
	}
	
	
}
