package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Core.BasePageObject;

public class Reutilizavel extends BasePageObject {

	public Reutilizavel(WebDriver driver) {
		super(driver);
	}

	public static final String urlHome = "https://www.webmotors.com.br/";
	public static final String urlEstoque = "https://www.webmotors.com.br/carros/estoque/?IdRevendedor=3834764&TipoVeiculo=carros&anunciante=concession%C3%A1ria%7Cloja";

	private By btnLogoWebMotors = By.id("logoHomeWebmotors");
	private By btnAceitaCookies = By.xpath("//*[@id=\"root\"]/div[3]/div[2]/button");
	
	public Reutilizavel voltarParaHome() {
		driver.findElement(btnLogoWebMotors).click();
		return this;
	}
	
	public Reutilizavel scrollFrame() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.javaScriptThrowsNoExceptions("document.querySelector('div.Search-result.Search-result--container-left .Filters__container__scroll').scrollTop=400"));
		js.executeScript("document.querySelector('div.Search-result.Search-result--container-left .Filters__container__scroll').scrollTop=400");
		return this;
	}
	
	public Reutilizavel aceitaCookies() {
		boolean cookies = driver.findElement(btnAceitaCookies).isDisplayed();
		if(cookies) {
			driver.findElement(btnAceitaCookies).click();
		}
		return this;	
	}
	
	public String validarTitulo() {
		return driver.getTitle();
	}
}
