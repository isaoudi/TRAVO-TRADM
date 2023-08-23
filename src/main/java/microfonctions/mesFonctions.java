package microfonctions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctions.MyKeyWord;

public class mesFonctions {
	
	public static String trAdmAccesOngletDossier(WebDriver driver, WebElement element) throws Throwable {
		String myXpath = "//td[@id='Entete1_MenuActeur1_im1_AD']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("accès page TR");
		
		myXpath = "//a[@id='hlPadm']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("clic onglet \"Documents\"");
//		System.out.println("aaa");
//		myXpath = "//a[@id='document-nav-btn']";
//		Fonctionnalites.waiting(driver, myXpath, Duration.ofSeconds(3));
//		System.out.println("bbb");
		
		Thread.sleep(2000);
		MyKeyWord.changementOnglet(driver, 2);
		
		myXpath = "//a[@href='/dossiers']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		//String dossier = ChoixDossier(driver, element, "411932");
		System.out.println("accès onglet \"Dossier\"");
			
		return null;
	}
	
	
	public static String ChoixDossier(WebDriver driver, WebElement element, String dossier) {
		
//		String myXpath = "//span[text='" + dossier + "']";
		String myXpath = "//span[contains(.,'" + dossier + "')]";
		System.out.println(myXpath);
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();		
		
		return dossier;
	}
	
public static String buttonEnvoiDoc(WebDriver driver, WebElement element) {
		
//		String myXpath = "//span[text='" + dossier + "']";
		String myXpath = "//button[contains(.,'Envoyer un document')]";
		System.out.println(myXpath);
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();		
		
		return null;
	}

public static String choixJuridictionTA (WebDriver driver, WebElement element) throws Throwable {
    // Choix de la juridiction
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
    // Choix de la juridiction
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
