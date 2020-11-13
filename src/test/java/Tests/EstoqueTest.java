package Tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;

import Core.BaseTest;
import Estoque.POEstoque;
import StepDefinitions.SelecionarModeloDeCarroSteps;
import Utils.Reutilizavel;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class EstoqueTest extends BaseTest {

	private static WebDriver driver;
	
	@BeforeAll
	public static void inicializarNavegador() {
		driver = BaseTest.abreNavegador();
		driver.get("https://www.webmotors.com.br/carros/estoque/?IdRevendedor=3834764&TipoVeiculo=carros&anunciante=concession%C3%A1ria%7Cloja");
		new Reutilizavel(driver)
			.aceitaCookies();
	}
	
	@Test
	void TC001_Deve_Validar_A_Pagina_De_Estoque() {
		String tagLoja =
		new POEstoque(driver)
			.validarNomeDaTag();
		assertEquals(tagLoja, "CONCESSIONÁRIA, LOJA");
	}
	
	@Test
	void TC002_Deve_Listar_E_Exportar_Estoque_Da_loja() {
		new POEstoque(driver)
			.exportaCsv();
	}
	
    /*
     * Metodo criado para finalizar o driver do navegador apï¿½s todos os testes terem sidos executadas.
    */
	@AfterAll
	public static void paralizacao() {
		driver.quit();
	}
}
