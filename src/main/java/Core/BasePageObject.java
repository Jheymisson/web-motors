package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	/**
     * Construtor extendido para pages objects
     * @param WebDriver driver referente ao navegador que esta em execução.
     * @param WebDriverWait wait que será utilizado para esperar elementos nos Tests.
    */
	public BasePageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}
	
	
}
