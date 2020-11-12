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

	private By btnLogoWebMotors = By.id("logoHomeWebmotors");
	
	
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
	
	public String validarTitulo() {
		return driver.getTitle();
	}
}
