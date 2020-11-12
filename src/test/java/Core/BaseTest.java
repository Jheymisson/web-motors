package Core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
   
	/*
 	* URL base de onde o sistema deve inicar antes do primeiro caso de teste.
 	*/
	static String url = "https://www.webmotors.com.br/";

    /**
     * Este metodo inicia o navegador do Google Chrome e direciona para inicio do sistema.
     * @param Webdriver Driver referente ao navegador que esta em execução.
     * @param ChromeOptions é referente a configuração de rodar os testes em headless
    */
	public static WebDriver abreNavegador() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1300x800");
		options.addArguments("--disable-gpu"); 
		options.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
