package authentification;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctions.MyKeyWord;

public class Auth {
	
	static WebDriver driver;
	static WebElement element;
	static String browser;
	static String myXpath;
	
	public static String authAvocat(WebDriver driver, String login) throws Throwable {
		
		Thread.sleep(2000);
		//renseigner login/mot de passe
		myXpath = "//input[@id='Username']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).sendKeys(login);
		myXpath = "//input[@id='password-field']";
//		MyKeyWord.object(driver, myXpath).sendKeys("Conseildétat52546*");
		MyKeyWord.object(driver, myXpath).sendKeys("ConseilEtat123456*");		
		
		//click button
		myXpath = "//button[@id='login-submit']";
		MyKeyWord.object(driver, myXpath).click();
//		throw new Exception("Stop");
		return null;
		 
	}


}
