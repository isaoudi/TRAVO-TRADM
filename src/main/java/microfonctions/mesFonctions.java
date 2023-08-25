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
	
	public static String trAdmAccesOngletDocument(WebDriver driver, WebElement element) throws Throwable {
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
		driver.close();
		MyKeyWord.changementOnglet(driver, 1);
		
		//Accès onglet documents TRADM
		myXpath = "//a[@id='document-nav-btn']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("accès onglet \"Document\"");
			
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

	public static String  choixUrl(String url) {
		
		switch (url) {
		case "avo_rec":
			url = "https://avocats.recette.telerecours.fr/";
			System.out.println("URL est :"+url );
			break;
			
		case "avo_int":
			url = "https://avocats.int1.telerecours.fr/";
			System.out.println("URL est :"+url );
			break;
			
		case "admin_int":
			url = "https://administrations.int1.telerecours.fr/";
			System.out.println("URL est :"+url );
			break;
			
		case "admin_rec":
			url = "https://administrations.recette.telerecours.fr/";
			System.out.println("URL est :"+url );
			break;

		default:System.out.println("Aucune url correspondant");
			break;
		}
		return url;
		
	}
	
	public static String retourPremierePageDoc(WebDriver driver) {
		String myXpath = "//input[@type='number']";
		MyKeyWord.object(driver, myXpath).clear();
		MyKeyWord.object(driver, myXpath).sendKeys("1");
		myXpath = "//button[text()='Aller']";
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Retour à la première page");
		
		return null;
	}
	
	public static String NbrJrsRestants(WebDriver driver, WebElement element) {
		String myXpath = "//tradm-card//span[contains(text(),\"jour\")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).getText();
		
		return null;
	}
	
	public static String typeDoc(WebDriver driver, WebElement element) {
		String myXpath = "//tradm-card//div[@class='body-s-semibold ng-star-inserted']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String type = MyKeyWord.object(driver, myXpath).getText().trim();
		System.out.println(MyKeyWord.object(driver, myXpath).getText().trim());
		
		return type;
	}
	
	public static String typeDocSelect(WebDriver driver, WebElement element) {
		String myXpath = "//tradm-card//div[@class='document-type']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String type = MyKeyWord.object(driver, myXpath).getText().trim();
		System.out.println(MyKeyWord.object(driver, myXpath).getText().trim());
		
		return type;
	}

	public static String ajoutDoc(WebDriver driver, WebElement element) {
		//extract date courrante
		String date = MyKeyWord.extractCurrentDate();
		
		//Vérification de la date lors d l'ajout
		String myXpath = "//tradm-card//div[@class='change-information']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String tr = MyKeyWord.object(driver, myXpath).getText().trim();
		System.out.println(MyKeyWord.object(driver, myXpath).getText().trim());
		
		String ajout = tr.substring(0, tr.indexOf(tr.split(" ")[1])).trim();
		String date1 = tr.substring(tr.indexOf(tr.split(" ")[2]), tr.indexOf(tr.split(" ")[3])).trim();
		System.out.println(ajout+"...."+date1);
		if(ajout.equals("Ajouté") && date1.equals(date)) {
			System.out.println("le document en préparation à bien été : ");
		}
		return null;
		
	}
	
	
}
