package testCaseDoc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import authentification.Auth;
import browser.Navigateur;
import choix_juridiction.Juridiction;
import envoiDoc.EnvoiDoc;
import microfonctions.mesFonctions;

public class TRADM_EnvoiDoc {
	WebElement element;
	WebDriver driver;
	String myXpath;
	String nav ;
	String login;
	String mdp;
	String jur;
	String dossier;
	String type;
	String url;
	String env;
	 
	
	@BeforeSuite
	public void navig() {
		nav = "chrome";
		// choit d'environnement RE7 ou INT
		env = "recette" ;
		url = "https://administrations." + env + ".telerecours.fr";
		driver = Navigateur.choixBrowser(nav);
		driver.get(url);
		System.out.println("Environnement : " + env);	
	
}  

	@BeforeMethod
	public void authentification() throws Throwable {
	login = "chaNC4d";
	mdp ="";
	jur = "CE";
	Auth.authAvocat(driver, login, mdp);
	Juridiction.choixJur(driver, jur);
	}

	@Test
	public void DepotDoc() throws Throwable {
		if (jur == "CAA") {
			//int
			//dossier = "2300018";
			//RECETTE
			dossier = "2300074";			
		}
		else if (jur == "TA"){
			//INT
			dossier = "xxx";
			//RE
			//dossier = "2300123";
		}
		else if (jur == "CE"){
			//INT
			dossier = "411932";
			//Recette
			dossier = "366699";
		}
		else{
			System.out.println("CNDA!!!");;
		}
		
		type = "Memoire";
		mesFonctions.trAdmAccesOngletDossier(driver);
		mesFonctions.choixDossier(driver, element, dossier);
		mesFonctions.buttonEnvoiDoc(driver, element);
		EnvoiDoc.envoiToutTypeDoc(driver, element, type);
		
		
		
	}
	
	@AfterSuite
	public void Deconnexion() {

	}

}
