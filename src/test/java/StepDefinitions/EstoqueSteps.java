package StepDefinitions;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.openqa.selenium.WebDriver;

import Core.BaseTest;
import Utils.Reutilizavel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;

public class EstoqueSteps {

	private static WebDriver driver;
	
	@Before
	public static void inicializarNavegador() {
		driver = BaseTest.abreNavegador();
		driver.get("https://www.webmotors.com.br/carros/estoque/?IdRevendedor=3834764&TipoVeiculo=carros&anunciante=concession%C3%A1ria%7Cloja");
		new Reutilizavel(driver)
			.aceitaCookies();
	}
	
	@Dado("entrar na página de estoque")
	public void entrar_na_página_de_estoque() {

	}

	@Dado("visualizar os anuncios disponiveis")
	public void visualizar_os_anuncios_disponiveis() {

	}

	@Entao("exportar os anuncios para um arquivo csv")
	public void exportar_os_anuncios_para_um_arquivo_csv() {

	}
	
	@After
	public static void paralizacao() {
		driver.quit();
	}
	
}
