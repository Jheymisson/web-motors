package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

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
		new POPesquisarCarro(driver)
			.selecionarAbaComprarCarros()
			.digitarMarca("HONDA");
	}

	@Quando("selecionar opção com a marca preenchida no campo")
	public void selecionar_opção_com_a_marca_preenchida_no_campo() {
		new POPesquisarCarro(driver)
			.selecionarOpcaoDropdownDaPesquisa();
	}

	@Entao("irá apareccer uma nova tela com resultados obtidos através da pesquisa")
	public void irá_apareccer_uma_nova_tela_com_resultados_obtidos_através_da_pesquisa() {
		String marcaModelo =
		new ResultadosPesquisa(driver)
			.validarMarcaModelo();
		assertEquals(marcaModelo, "HONDA");
	}

	@Dado("entrar na página de resultados da pesquisa")
	public void entrar_na_página_de_resultados_da_pesquisa() {
		new POPesquisarCarro(driver)
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
		new ResultadosPesquisa(driver)
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

	@Entao("resultados serao exportados para arquivo cvs com sucesso")
	public void resultados_serao_exportados_para_arquivo_cvs_com_sucesso() {
		ResultadosPesquisa resultados = new ResultadosPesquisa(this.driver);
		List<String> listaMarcaModelo = resultados.listaDeMarcaModelo();
		List<String> listaEspecificacoes = resultados.listaDeEspecificacoes();
		List<String> listaPrecos = resultados.listaDePreco();
		File f = new File(".\\dados.csv");
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
	}
	
	@After
	public static void paralizacao() {
		driver.quit();
	}
}
