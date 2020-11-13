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
import StepDefinitions.SelecionarModelodDeCarro;
import Utils.Reutilizavel;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class PesquisarCarro extends BaseTest {

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
		new ResultadosPesquisa(driver)
			.selecionarBotaoModelos()
			.selecionarOpcaoModelo();
		String marcaModelo =
		new ResultadosPesquisa(driver)
			.validarMarcaModelo();
		assertEquals(marcaModelo, "HONDA CITY");	
	}
	
	@Test
	void TC003_Deve_Listar_Os_Anuncios_Da_Pagina_Resultados() {
		SelecionarModelodDeCarro selecionarModelodDeCarro = new SelecionarModelodDeCarro(this.driver);
		List<String> listaMarcaModelo = selecionarModelodDeCarro.listaDeMarcaModelo();
		List<String> listaEspecificacoes = selecionarModelodDeCarro.listaDeEspecificacoes();
		List<String> listaPrecos = selecionarModelodDeCarro.listaDePreco();
		File f = new File(".\\anunciosHondaCity.csv");
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
	
    /*
     * Metodo criado para finalizar o driver do navegador apï¿½s todos os testes terem sidos executadas.
    */
	@AfterAll
	public static void paralizacao() {
		driver.quit();
	}
	
	
}
