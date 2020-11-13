package StepDefinitions;

import static org.junit.Assert.assertEquals;


import org.openqa.selenium.WebDriver;

import Core.BaseTest;
import PagesPesquisaCarro.POPesquisarMarca;
import PagesPesquisaCarro.ResultadosPesquisa;
import Utils.Reutilizavel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PesquisarMarcaSteps {

	private static WebDriver driver;
	
	@Before
	public static void inicializarNavegador() {
		driver = BaseTest.abreNavegador();
		driver.get(Reutilizavel.urlHome);
		new Reutilizavel(driver)
			.aceitaCookies();
	}
	
	@Dado("entrar na página home da WebMotors")
	public void entrar_na_página_home_da_web_motors() {
		String tituloPagina =
		new Reutilizavel(driver)
			.validarTitulo();
		assertEquals(tituloPagina, "Webmotors | Compre, venda e financie carros usados, novos e motos");
	}

	@Dado("selecionar aba de Comprar Carros")
	public void selecionar_aba_de_comprar_carros() {
		new POPesquisarMarca(driver)
			.selecionarAbaComprarCarros();
	}

	@Dado("preencher o campo de pesquisa com uma marca ou modelo")
	public void preencher_o_campo_de_pesquisa_com_uma_marca_ou_modelo() {
		new POPesquisarMarca(driver)
			.selecionarAbaComprarCarros()
			.digitarMarca("HONDA");
	}

	@Quando("selecionar opção com a marca preenchida no campo")
	public void selecionar_opção_com_a_marca_preenchida_no_campo() {
		new POPesquisarMarca(driver)
			.selecionarOpcaoDropdownDaPesquisa();
	}

	@Entao("irá apareccer uma nova tela com resultados obtidos através da pesquisa")
	public void irá_apareccer_uma_nova_tela_com_resultados_obtidos_através_da_pesquisa() {
		String marcaModelo =
		new ResultadosPesquisa(driver)
			.validarMarcaModelo();
		assertEquals(marcaModelo, "HONDA");
	}
	
	@After
	public static void paralizacao() {
		driver.quit();
	}
}
