package authentification;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import fonctions.MyKeyWord;

public class Auth_ADM {
	
	public static void authentification_user_ADM(WebDriver driver, String identifiant, String mdp) throws Throwable {
		//Acces à la page d'authentification
		driver.get("https://administrations.recette.telerecours.fr/");
		
		String myXpath = "//div[@id='left-panel']//p[text()=\"Télérecours administrations\"]";
		MyKeyWord.waiting2(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Acces à la page d'authentification...."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		//Authentification de l'utilisateur
		myXpath = "//input[@id='Username']";
		String myXpath1 = "//input[@id='password-field']";
		String myXpath2 = "//button[@id='login-submit']";
		
		MyKeyWord.waiting2(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).sendKeys(identifiant);
		System.out.println("Insertion de l'identifiant : "+identifiant+"....."+MyKeyWord.extractCurrentHeure());
		MyKeyWord.object(driver, myXpath1).sendKeys(mdp);
		System.out.println("Insertion du mot de passe : "+mdp+"......"+MyKeyWord.extractCurrentHeure());
		MyKeyWord.object(driver, myXpath2).click();
		
		myXpath = "//img[@alt=\"Télérecours administration\"]";
		System.out.println("Accès à la page d'accueil TRADM..."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
	}

}
