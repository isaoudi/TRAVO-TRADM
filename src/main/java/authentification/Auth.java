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
	
	public static String authAvocat(WebDriver driver, String login, String mdp) throws Throwable {
		
		Thread.sleep(2000);
		//renseigner login/mot de passe
		myXpath = "//input[@id='Username']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).sendKeys(login);
		myXpath = "//input[@id='password-field']";
		MyKeyWord.object(driver, myXpath).sendKeys(mdp);
		
		//click button
		myXpath = "//button[@id='login-submit']";
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Le login : "+login+" et le password : "+mdp+" ont été validés "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");

		return null;
		 
	}

	public static String AuthentificationTaCaaCeInt (WebDriver driver, String identifiant, String mdp ) {
		
		String myXpath1 = "//input[@id='txtIdentifiant']";
		String myXpath2 = "//input[@id='txtPassword']";
		String myXpath3 = "//a[@id='ibOk']/span[@class='button-text' and (text()='Valider')]";
		MyKeyWord.waiting(driver, myXpath3, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath1).sendKeys(identifiant);
		MyKeyWord.object(driver, myXpath2).sendKeys(mdp);
		MyKeyWord.object(driver, myXpath3).click();
		System.out.println("Validation des identifiants......"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		//vérification de la page
		String myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Nom de la juridiction : "+MyKeyWord.object(driver, myXpath).getText().trim());
		return null;
	}
}
