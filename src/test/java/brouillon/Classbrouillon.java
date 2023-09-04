package brouillon;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.swing.JFileChooser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import analyseDocTableau.NbrDoc;
import authentification.Auth;
import browser.Navigateur;
import choix_juridiction.Juridiction;
import envoiDoc.EnvoiDoc;
import fonctions.MyKeyWord;
import microfonctions.mesFonctions;
import microfonctions.mesFonctions.codeCouleur;

public class Classbrouillon {
	
	static WebDriver driver;
	static WebElement element;
	static String mdp;
	static String ID;
	static String browser;
	static String URL;
	static String dossier;
	static String jur;
	static String type;
	

	public static void main(String[] args) throws Throwable {
			
//		Frame f = new Frame();
//		FileDialog fd = new FileDialog(f, "Choose a file", FileDialog.LOAD);
//		fd.setDirectory("C:\\Users\\isaoudi\\Desktop\\Testing doc et outils\\passant_avec_alerte");
//		fd.setFile("Exemple.pdf");
//		fd.setVisible(false);
//		String filename = fd.getFile();
//		if (filename == null)
//		 System.out.println("You cancelled the choice");
//		else
//		 System.out.println("You chose " + filename);	
		
		URL ="admin_rec";
		browser = "chrome";
		jur = "CAA";
		ID = "chaNC4d";
		mdp = "ConseilEtat123456*";
		dossier = "2300074";
		type = "Memoire";
		
		driver = Navigateur.choixBrowser(browser);
		driver.get(mesFonctions.choixUrl(URL));
		
		Auth.authAvocat(driver, ID, mdp);
		
		Juridiction.choixJur(driver, jur);
		
		mesFonctions.trAdmAccesOngletDocument(driver, element);
		mesFonctions.boutonAccesBrouillon(driver, element, dossier);
		MyKeyWord.echappe(driver);
		mesFonctions.buttonEnvoiDoc(driver, element);
		EnvoiDoc.envoiToutTypeDoc(driver, element, type);
//		EnvoiDoc.verifDepotDoc(driver, dossier);
		
		
		
		
//		int c = NbrDoc.nbrDocuments(driver, element);
//		int a = NbrDoc.nbrDocEnPrepa(driver, element);
//		int b = NbrDoc.nbrDocDepose(driver, element);
//		int d = NbrDoc.nbrDocEnreg(driver, element);
//		int e = NbrDoc.nbrDocRefus(driver, element);
				
		
//		if(a+b+d+e==c) {
//			System.out.println("le nombre de doc est bien = "+c);
//		}
		
//		NbrDoc.triParStatuEnPrepa(driver, element);
//		NbrDoc.triParStatuDepose(driver, element);
//		NbrDoc.triParStatuEnreg(driver, element);
//		NbrDoc.triParStatuRefus(driver, element);
		
//		NbrDoc.consultationDocEnprepa(driver, element, dossier);
//		NbrDoc.consultationDocEnreg(driver, element, dossier);
//		NbrDoc.consultationDocDepose(driver, element, dossier);
//		NbrDoc.consultationDocRefus(driver, element, dossier);
//		System.out.println(MyKeyWord.extractCurrentHeure());
//		System.out.println();
		
//		driver.quit();
	    
		}
}

