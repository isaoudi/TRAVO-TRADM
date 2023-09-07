package deconnexion;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import fonctions.MyKeyWord;
import microfonctions.mesFonctions;

public class DeconnexionTRADM {
	
	public static Object deconnecteActeur(WebDriver driver) {
		//click popup information acteur 
		mesFonctions.informationActeurTRADM(driver);
		
		//clic bouton " Me déconnecter "
		String myXpath = "//button[text()=\" Me déconnecter \"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Clic bouton \" Me déconnecter \" : "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		//clic lien "ici"
		myXpath = "//a[@class='alert-link ' and (text()='ici')]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Clic lien \" ici \" : "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		
		myXpath = "//h1[text()='Se connecter']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Accès page d'authentification : "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		driver.quit();
		
		return null;
	}
	
	

}
