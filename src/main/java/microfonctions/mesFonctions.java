package microfonctions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctions.MyKeyWord;

public class mesFonctions {
	
	public static String trAdmAccesOngletDossier(WebDriver driver, WebElement element) throws Throwable {
		//Clic onglet requête page Legacy
		String myXpath = "//td[@id='Entete1_MenuActeur1_im1_AD']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("accès page TR");
		
		//Clic bouton de redirection vers de dépôt de documents depuis TRADM  
		myXpath = "//a[@id='hlPadm']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("clic bouton \"Documents\"");
		
		//Changement d'onglet
		Thread.sleep(2000);
		MyKeyWord.changementOnglet(driver, 2);
		
		//Clic onglet dossier TRADM
		myXpath = "//a[@href='/dossiers']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("accès onglet \"Dossier\"");
			
		return null;
	}
	
	
	public static String choixDossier(WebDriver driver, WebElement element, String dossier) {
		//Choix du dossier
		String myXpath = "//span[contains(.,'" + dossier + "')]";
		System.out.println(myXpath);
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Le dossier choisi est : "+dossier);
		
		return dossier;
	}
	
	public static String buttonEnvoiDoc(WebDriver driver, WebElement element) {
		//Clic bouton envoyer un document
		String myXpath = "//button[contains(.,'Envoyer un document')]";
		System.out.println(myXpath);
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();		
		System.out.println("Clic bouton \"Envoyer un document\"");
		
		return null;
	}

	public static String choixJuridictionTA (WebDriver driver, WebElement element) throws Throwable {
	    //Choix de la juridiction
	    String myXpath = "//a[text()='TA Paris']";
	    MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
	    System.out.println("Page de choix de juridiction");
	    MyKeyWord.object(driver, myXpath).click();
	    
	    //vérification de la page
     	myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau' and (contains (text(),\"Tribunal administratif de Paris\"))]";
     	MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
     	System.out.println(MyKeyWord.object(driver, myXpath).getText());
     	Thread.sleep(1000);
    
     return null;
}

	public static String choixJuridictionCAA (WebDriver driver, WebElement element) throws Throwable {
		//Choix de la juridiction
		String myXpath = "//a[text()='CAA Paris']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Page de choix de juridiction");
     	MyKeyWord.object(driver, myXpath).click();
     	
     	//vérification de la page
 		myXpath = "//div[@id='Entete1_EnteteTeleProcedure1_bandeau' and (contains (text(),\"Cour administrative d'appel de Paris\"))]";
 		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
 		System.out.println(MyKeyWord.object(driver, myXpath).getText());
 		Thread.sleep(1000);

    return null;
}



}
