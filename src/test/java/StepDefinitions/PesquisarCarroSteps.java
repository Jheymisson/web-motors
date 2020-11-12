package StepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import Core.BaseTest;
import PagesPesquisaCarro.POPesquisarCarro;
import PagesPesquisaCarro.ResultadosPesquisa;
import Utils.Reutilizavel;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PesquisarCarroSteps {

	private static WebDriver driver;
	
	@Before
	public static void inicializarNavegador() {
		driver = BaseTest.abreNavegador();
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
		new POPesquisarCarro(driver)
			.selecionarAbaComprarCarros();
	}

	@Dado("preencher o campo de pesquisa com uma marca ou modelo")
	public void preencher_o_campo_de_pesquisa_com_uma_marca_ou_modelo() {

	}

	@Quando("selecionar opção com a marca preenchida no campo")
	public void selecionar_opção_com_a_marca_preenchida_no_campo() {

	}

	@Entao("irá apareccer uma nova tela com resultados obtidos através da pesquisa")
	public void irá_apareccer_uma_nova_tela_com_resultados_obtidos_através_da_pesquisa() {

	}

	@Dado("entrar na página de resultados da pesquisa")
	public void entrar_na_página_de_resultados_da_pesquisa() {

	}

	@Dado("selecionar modelo de um carro")
	public void selecionar_modelo_de_um_carro() {

	}

	@Entao("modelo será selecionado com sucesso")
	public void modelo_será_selecionado_com_sucesso() {

	}

	@Entao("resultados serao exportados para arquivo cvs com sucesso")
	public void resultados_serao_exportados_para_arquivo_cvs_com_sucesso() {

	}
	
	@After
	public static void paralizacao() {
		driver.quit();
	}
}
