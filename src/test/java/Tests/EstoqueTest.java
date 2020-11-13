package Tests;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import Core.BaseTest;
import Estoque.POEstoque;
import StepDefinitions.SelecionarModeloDeCarroSteps;
import Utils.Reutilizavel;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class EstoqueTest extends BaseTest {

	private static WebDriver driver;
	
	@BeforeAll
	public static void inicializarNavegador() {
		driver = BaseTest.abreNavegador();
		driver.get(Reutilizavel.urlHome);
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
	
	@After(order = 1)
	public static void printScreen(Scenario scenario) {
		TakesScreenshot foto = (TakesScreenshot) driver;
		File captura = foto.getScreenshotAs(OutputType.FILE);
		try {
			Files.move(captura, new File("src\\test\\resources" + scenario.getName() + "_" + scenario.getStatus() + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
    /*
     * Metodo criado para finalizar o driver do navegador apï¿½s todos os testes terem sidos executadas.
    */
	@AfterAll
	public static void paralizacao() {
		driver.quit();
	}
}
