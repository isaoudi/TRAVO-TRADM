package envoiDoc;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import authentification.Auth;
import browser.Navigateur;
import deconnexion.DeconnexionTRADM;
import fonctions.MyKeyWord;
import microfonctions.mesFonctions;
	
public class EnvoiDoc {
	
	
	static List<WebElement> elements;
	static String inventaire;
	static String enreg;
	static String type;
	static String ledoc;
	static String memoire;
	static String inventairePiece;
	static String choix;
	static List<String> color;
	static List<String> pieces;
	static List<String> str1 = new ArrayList<>();
	static Integer idDoc;

	public static String envoiToutTypeDoc(WebDriver driver, WebElement element, String doc) throws Throwable {
		switch (doc) {
		
		case "Memoire":
			String myXpath = "//div[contains(text(),\"Mémoire\")]//preceding-sibling::input";
			String myXpath2 = "//label";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			ledoc = MyKeyWord.object(driver, myXpath2).getText().replaceAll("[\r\n]", " ");
			System.out.println("type dépot Doc : "+MyKeyWord.object(driver, myXpath2).getText().replaceAll("[\r\n]", " ")); 
			
			//Vérification de la présence de la barre de navigation
			mesFonctions.navbarEnvoiDoc(driver, element);
				
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			// choisir depuis une liste box le type de mémoire	
				choix = "2";//liste déroulante de 14 éléments; choix[0-13] ex : choix = "0" - Décision de rétention ou d'assignation à résidence 
			type = mesFonctions.typeDocSelect(driver, element, choix);
			
			//Vérification de la présence de la barre de navigation
			mesFonctions.navbarEnvoiDoc(driver, element);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Modification du type de mémoire
			//supprimer le type de choix de mémoire
			mesFonctions.clearChoixTypeMemoire(driver, element);
			
			// choisir depuis une liste box	
				choix = "4";
			type = mesFonctions.typeDocSelect(driver, element, choix);
				
			//Etat de la barre d'envoi
			mesFonctions.navbarEnvoiDoc(driver, element);
				
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Ajout du mémoire
			mesFonctions.ajoutMemoire(driver);
			
			//visualisation du mémoire
			mesFonctions.visualiserMemoire(driver);
			
			//Suppression mémoire
			mesFonctions.supprimerMémoire(driver, element);
			
			//Etat de la barre d'envoi
			mesFonctions.navbarEnvoiDoc(driver, element);
			
			//Rajout du mémoire
			memoire = mesFonctions.ajoutMemoire(driver);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
			
			//Ajout de pièces complémentaires
			mesFonctions.ajoutDocPiecesAdds(driver);
			
			//Visualisation pièce complémentaire
			mesFonctions.visualiserPiecesAdd(driver);
			
			//suppression des pièces complémentaires
			mesFonctions.supprimerPiecesAdd(driver);
			
			//Rajout pièces complémentaires
			pieces = mesFonctions.ajoutDocPiecesAdds(driver);
			
				
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Vérification de la présence de la barre de navigation
			mesFonctions.navbarEnvoiDoc(driver, element);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Ajout de l'inventaire	
				inventaire = "automatique"; //manuel ou automatique
			mesFonctions.inventaireDoc(driver, element, inventaire);
			
			//visualiser inventaire automatique
			mesFonctions.visualiserInventaireAutomatique(driver, element);
			
			//Etat de la barre d'envoi
			mesFonctions.navbarEnvoiDoc(driver, element);
			
			//Modifier type d'inventaire
				inventaire = "manuel";
			mesFonctions.inventaireDoc(driver, element, inventaire);
			
			//Etat de la barre d'envoi
			mesFonctions.navbarEnvoiDoc(driver, element);
			
			//Ajout du fichier de l'inventaire manuel
				inventaire = "manuelfile";
			inventairePiece = mesFonctions.inventaireDoc(driver, element, inventaire);
			
			//visualiser inventaire manuel
			mesFonctions.visualiserInventaireManuel(driver);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Vérification de la présence de la barre de navigation
			color = mesFonctions.navbarEnvoiDoc(driver, element);	

				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Enregistrement du brouillon
			mesFonctions.EnregBrouillon(driver, element);
				
			//Vérification de la carte 	
			mesFonctions.verifInfoCarteBrouillonApresEnreg(driver, element);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Retour au brouillon
			mesFonctions.carteBoutonReprendreBrouillon(driver);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
			
			//Verification des informations conservées dans le brouillon
			EnvoiDoc.verifBrouillonEnreg(driver, element);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Vérification avant envoi
			EnvoiDoc.AccesVerificationAvantEnvoi(driver, element);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Test des boutons de modification depuis la page de vérification du document
			mesFonctions.boutonModifierTypeDocAvantEnvoi(driver);
			
			//clic bouton "Accéder à la vérification"
			mesFonctions.boutonAccesVerifAvantEnvoiDoc(driver, element);
			
			//Test des boutons de modification depuis la page de vérification de l'inventaire
			mesFonctions.boutonModifierInventaireAvantEnvoi(driver, element);
			
			//clic bouton "Accéder à la vérification"
			mesFonctions.boutonAccesVerifAvantEnvoiDoc(driver, element);
				
			//Coche checkbox
			mesFonctions.checkboxValidationEnvoi(driver, element);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Valider l'envoi des documents
			mesFonctions.boutonValiderEnvoiDoc(driver, element);
			

		    
			break;
			
		case "Pieces":
			myXpath = "//div[contains(text(),\"Pièces\")]";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			
			myXpath = "//div[@class='ng-value-container']";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			
			myXpath = "(//div[@class='ng-option ng-star-inserted'])[1]";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			
			Thread.sleep(1000); 


			
			
			break;	
			
		case "Courrier":
			myXpath = "//div[text()='Courrier']";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
						
			myXpath = "//div[@class='ng-value-container']";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();		
//			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MyKeyWord.object(driver, myXpath));
			
			myXpath = "(//div[@class='ng-option ng-star-inserted'])[2]";
			MyKeyWord.object(driver, myXpath).click();	
			System.out.println("Type de courrier choisit");	
			
			break;

		default:System.err.println("Aucun type retrouvé!");
			break;
		}
		
		
		return doc;
		
	}
	
	public static String verifBrouillonEnreg(WebDriver driver, WebElement element) throws ParseException, Throwable {
		//vérification de la navbar
		List<String> colr = mesFonctions.navbarEnvoiDoc(driver, element);
		if(color.equals(colr)) {
			System.out.println("Etat de la barre de navigation de dépôt OK....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		}
		
		//Verification des informations du document
		String myXpath = "//label";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		String myXpath2 ="//div[@class='ng-value ng-star-inserted']//span[2]";
		
			//1. Type de document 
		if(MyKeyWord.object(driver, myXpath).getText().replaceAll("[\r\n]", " ").equals(ledoc)) {
			System.out.println("Vérification du 1. Type de document : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println("Vérification du 1. Type de document : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath).getText().trim()+" est différent de "+ledoc+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
			//2. Type de mémoire
		if(MyKeyWord.object(driver, myXpath2).getText().trim().equals(type)) {
			System.out.println("Vérification du 2. Type de mémoire : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println("Vérification du 2. Type de mémoire : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath2).getText().trim()+" est différent de "+type+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
		
			//3. Liste des fichiers joints
		myXpath = "//div[@class='files-display-file-name']";
		if(MyKeyWord.object(driver, myXpath).getText().trim().equals(memoire)) {
			System.out.println("Vérification du 3. Liste des fichiers joints : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println("Vérification du 3. Liste des fichiers joints : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath).getText().trim()+" est différent de "+memoire+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
		
			//Pièces complémentaires
		myXpath = "(//div[@class='files-display-file-name'])[position()>1]";
		List<WebElement> myElts = driver.findElements(By.xpath(myXpath));
		int myList = myElts.size()-1;
		
		for(int i=0; i<myList; i++) {
			String coloredFile = Color.fromString(myElts.get(i).getCssValue("color")).asHex();
			if(pieces.contains(myElts.get(i).getText().trim())) {
				System.out.println("Vérification du 3. pièces complémmentaire "+myElts.get(i).getText().trim()+" : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
			}else {
				System.err.println("la pièce "+myElts.get(i).getText().trim()+" est différente de "+pieces.get(i)+"....." +MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
			}
			
			if(!coloredFile.equals("#e96608")) {
				System.out.println("libellé OK....."+MyKeyWord.extractCurrentHeure()+"\r");
			}
				else {
					System.err.println("libellé KO....."+MyKeyWord.extractCurrentHeure()+"\r");
				}
		}
		
			//4. Inventaire
		myXpath = "(//div[@class='files-display-file-name'])[last()]";
		boolean verif = false;
		if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
			System.out.println("l'inventaire est bien présent : "+MyKeyWord.object(driver, myXpath).getText().trim()+"\r");
			mesFonctions.visualiserInventaireManuel(driver);
		}
		else {
			System.err.println("Pas d'inventaire présent\r");
		}
		
		//Repère horaire d'exécution
		System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String verifDoc_TypeDoc(WebDriver driver, WebElement element) {
		//vérification de l'enregistrement du brouillon (Type de document sélectionné). Celui-ci doit suivre impérativement un cas d'enregistrement du brouillon !!!
		String ledoc1 = mesFonctions.carteBrouillonDocSelect(driver, element);
		String type1 = mesFonctions.carteBrouillonTypeDocSelect(driver, element);
		boolean verif = ledoc1.equals(ledoc);
		boolean verif1 = type1.equals(type);
		
		if(verif && verif1) {
			System.out.println("Le document : "+ledoc+" et le type de doccument : "+type+" ont bien été renseignés"+"\r");
		}else {
			System.err.println("Les informations enregistrées : "+ledoc+" + "+type+" sont différentes : "+ledoc1+" + "+type1);
		}
		
		System.out.println("Vérification type de document effectuée....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	
	public static List<String> AccesVerificationAvantEnvoi(WebDriver driver, WebElement element) throws Throwable {
		//clic bouton "Accéder à la vérification"
		mesFonctions.boutonAccesVerifAvantEnvoiDoc(driver, element);
		
		//Verification des informations du récap
		String myXpath = "//h1[text()=\"Vérification de l'envoi\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		String myXpath1 ="//h2//following-sibling::span";
		String myXpath2 ="(//h2//following-sibling::span)[2]";
		
		List<String> recap = new ArrayList<>();
		
			//1. Type de document 
		if(MyKeyWord.object(driver, myXpath1).getText().trim().equals(ledoc)) {
			System.out.println("Vérification avant envoi du 1. Type de document : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			recap.add(MyKeyWord.object(driver, myXpath1).getText().trim());
		}else {
			System.err.println("Vérification du 1. Type de document : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath1).getText().trim()+" est différent de "+ledoc+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			recap.add(MyKeyWord.object(driver, myXpath1).getText().trim());
		}
			//2. Type de mémoire
		if(MyKeyWord.object(driver, myXpath2).getText().trim().equals(type)) {
			System.out.println("Vérification avant envoi du 2. Type de mémoire : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			recap.add(MyKeyWord.object(driver, myXpath2).getText().trim());
		}else {
			System.err.println("Vérification avant envoi du 2. Type de mémoire : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath2).getText().trim()+" est différent de "+type+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			recap.add(MyKeyWord.object(driver, myXpath2).getText().trim());
		}
		
			//3. Liste des fichiers joints
		myXpath = "//div[@class='files-display-file-name']";
		if(MyKeyWord.object(driver, myXpath).getText().trim().equals(memoire)) {
			System.out.println("Vérification avant envoi du 3. Liste des fichiers joints : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			recap.add(MyKeyWord.object(driver, myXpath).getText().trim());
		}else {
			System.err.println("Vérification avant envoi du 3. Liste des fichiers joints : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath).getText().trim()+" est différent de "+memoire+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			recap.add(MyKeyWord.object(driver, myXpath).getText().trim());
		}
		
			//Pièces complémentaires
		myXpath = "(//div[@class='files-display-file-name'])[position()>1]";
		List<WebElement> myElts = driver.findElements(By.xpath(myXpath));
		int myList = myElts.size()-1;
		
		for(int i=0; i<myList; i++) {
			String coloredFile = Color.fromString(myElts.get(i).getCssValue("color")).asHex();
			if(pieces.contains(myElts.get(i).getText().trim())) {
				System.out.println("Vérification avant envoi du 3. pièces complémmentaire "+myElts.get(i).getText().trim()+" : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				recap.add(myElts.get(i).getText().trim());
			}else {
				System.err.println("la pièce "+myElts.get(i).getText().trim()+" est différente de "+pieces.get(i)+"....." +MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				recap.add(myElts.get(i).getText().trim());
			}
			
			if(!coloredFile.equals("#e96608")) {
				System.out.println("libellé OK....."+MyKeyWord.extractCurrentHeure()+"\r");
			}
				else {
					System.err.println("libellé KO....."+MyKeyWord.extractCurrentHeure()+"\r");
				}
		}
		
			//4. Inventaire
		myXpath = "(//div[@class='files-display-file-name'])[last()]";
		boolean verif = false;
		if(MyKeyWord.isElementPresent(driver, myXpath, verif) && MyKeyWord.object(driver, myXpath).getText().trim().equals("Inventaire automatique")) {
			System.out.println("l'inventaire est bien présent : "+MyKeyWord.object(driver, myXpath).getText().trim()+"\r");
			recap.add(MyKeyWord.object(driver, myXpath).getText().trim());
			mesFonctions.visualiserInventaireManuel(driver);//même xpath que pour l'inventaire manuel
			}
			else if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				System.out.println("l'inventaire est bien présent : "+MyKeyWord.object(driver, myXpath).getText().trim()+"\r");
				recap.add(MyKeyWord.object(driver, myXpath).getText().trim());
				mesFonctions.visualiserInventaireManuel(driver);
				}
				else {
					System.err.println("Pas d'inventaire présent\r");
				}
		
		return recap;
		
	}
	
	public static String verifEnregDoc(WebDriver driver, String dossier) throws Throwable {
		//accès onglet @Document
		mesFonctions.ongletDocument(driver);
		
		//Accès à l'onglet déposés
		mesFonctions.tableauVosDocument_enregistres(driver);
		
		//Clic sur le dossier déposé
		String myXpath = "//td//div[contains(text(),\""+dossier+"\")]//following-sibling::button[@icon='eye-show']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Accès au document déposé "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		
		//Verification des informations du récap
		myXpath = "//h1[text()=\"Contenu de l'envoi\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		String myXpath1 ="//div[text()=\"1. Type de document :\"]//following-sibling::div";
		String myXpath2 ="//div[text()=\"2. Type de Mémoire:\"]//following-sibling::div";
		
//		List<String> recap = new ArrayList<>();
		
		//1. Type de document 
		if(MyKeyWord.object(driver, myXpath1).getText().trim().equals(ledoc)) {
			System.out.println("Vérification avant enregistrement du 1. Type de document : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}else {
			System.err.println("Vérification du 1. Type de document : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath1).getText().trim()+" est différent de "+ledoc+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}
		//2. Type de mémoire
		if(MyKeyWord.object(driver, myXpath2).getText().trim().equals(type)) {
			System.out.println("Vérification avant enregistrement du 2. Type de mémoire : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}else {
			System.err.println("Vérification avant enregistrement du 2. Type de mémoire : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath2).getText().trim()+" est différent de "+type+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}
		
		//3. Liste des fichiers joints
		myXpath = "//div[@class='files-display-file-name']";
		if(MyKeyWord.object(driver, myXpath).getText().trim().equals(memoire)) {
			System.out.println("Vérification avant enregistrement du 3. Liste des fichiers joints : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}else {
			System.err.println("Vérification avant enregistrement du 3. Liste des fichiers joints : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath).getText().trim()+" est différent de "+memoire+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}
		
		//Pièces complémentaires
		myXpath = "(//div[@class='files-display-file-name'])[position()>1]";
		List<WebElement> myElts = driver.findElements(By.xpath(myXpath));
		int myList = myElts.size()-1;
		
		for(int i=0; i<myList; i++) {
			String coloredFile = Color.fromString(myElts.get(i).getCssValue("color")).asHex();
			if(pieces.contains(myElts.get(i).getText().trim())) {
				System.out.println("Vérification avant envoi du 3. pièces complémmentaire "+myElts.get(i).getText().trim()+" : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			}else {
				System.err.println("la pièce "+myElts.get(i).getText().trim()+" est différente de "+pieces.get(i)+"....." +MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			}
			
			if(!coloredFile.equals("#e96608")) {
				System.out.println("libellé OK....."+MyKeyWord.extractCurrentHeure()+"\r");
			}
				else {
					System.err.println("libellé KO....."+MyKeyWord.extractCurrentHeure()+"\r");
				}
		}
		
		//4. Inventaire
		myXpath = "(//div[@class='files-display-file-name'])[last()]";
		boolean verif = false;
		if(MyKeyWord.isElementPresent(driver, myXpath, verif) && MyKeyWord.object(driver, myXpath).getText().trim().equals("Inventaire automatique")) {
			System.out.println("l'inventaire est bien présent : "+MyKeyWord.object(driver, myXpath).getText().trim()+"\r");
			
			mesFonctions.visualiserInventaireManuel(driver);//même xpath que pour l'inventaire manuel
			}
			else if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				System.out.println("l'inventaire est bien présent : "+MyKeyWord.object(driver, myXpath).getText().trim()+"\r");
				
				mesFonctions.visualiserInventaireManuel(driver);
				}
				else {
					System.err.println("Pas d'inventaire présent\r");
				}
		
		//Bouton fermer
		myXpath = "//button[text()=\" Fermer \"]";
		MyKeyWord.waiting(driver, myXpath2, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Vérification du dépôt effectué "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
	
		return null;
	}
	
	public static String EnrgDoc(WebDriver driver, String juridiction) throws Throwable {
		switch (juridiction) {
		case "TA":
			// Récupération du num de reqête
			String dossier = mesFonctions.recupCaseFileNumber(driver);
			
			// déconnexion page TRADM
//			DeconnexionTRADM.deconnecteActeur(driver);
//			Thread.sleep(2000);
//			driver = Navigateur.choixBrowser("chrome");
			mesFonctions.choixJuridictionCAA(driver);
			mesFonctions.deconnexionTRLeg(driver);
			
			//Connexion page TR lEGACY
			String TrUrl = "https://www.telerecours.recette.juradm.fr/TA75";
			String TrUrlInt = "https://www.telerecours.int1.juradm.fr/TA75"; 
			String currentUrl = "int1";
		    //Authentification TA		
			boolean verif = driver.getCurrentUrl().contains(currentUrl);
			if(verif) {
				driver.get(TrUrlInt);
				String identifiant = "sice";
				String mdp = "sice";
				String myXpath = "//input[@id='txtIdentifiant']";
				MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				Auth.AuthentificationTaCaaCeInt(driver, mdp, identifiant);
				System.out.println("Connexion TA réussi");
			}else {
				driver.get(TrUrl);
				String identifiant = "lb";
				String mdp = "lb";
				String myXpath = "//input[@id='txtIdentifiant']";
				MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				Auth.AuthentificationTaCaaCeInt(driver, mdp, identifiant);
				System.out.println("Connexion TA réussi");
			}
			
			// Enregistrer le document
			driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='numDossier' and contains(text(),\"" + dossier + "\")]")).click();
			
			String  myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
			String caractSpec = " ";
			String strg = MyKeyWord.leNom(driver, myXpath, caractSpec);
			int fin = strg.indexOf(strg.split(" ")[2]);
			String acteur = strg.substring(0, fin).trim();
			System.out.println(acteur);
			
			// Rattachement
			mesFonctions.rattachement(driver, acteur);
			
			//Vérification fichiers 
//			List<String> str1 = new ArrayList<>();
			
			myXpath = "//a[@id='fileLinkFichierDocument_hplFichier']";
			caractSpec = "_";
			String verifFile1 = MyKeyWord.piece(driver, myXpath);
			str1.add(verifFile1);
			
			
			myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
			str1.addAll(MyKeyWord.fichier(driver, elements, myXpath));
			Thread.sleep(2000);
			
			myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
			String verifFile2 = MyKeyWord.piece(driver, myXpath);
			System.out.println(verifFile2);
			str1.add(verifFile2);
			
			List<String> mem = Arrays.asList(memoire);
			List<String> str = Stream.concat(pieces.stream(), mem.stream())
					.collect(Collectors.toList());
			
		   if(str1.contains(str)) {
			   System.out.println(str);
			   System.out.println("Tous les fichiers sont présents "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		   }
		   else {
			   System.err.println("Les tableaux sont différents. Le tableau actuel : "+str1+" tableau attendu : "+str+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		   }
			   
		   //Enregistrement du document 
		   Thread.sleep(1000);
		   mesFonctions.enrgDoc(driver);
		   
		   
		   System.out.println("Dépôt et enregistrement TA terminés");
		   break;
		   
		case "CAA":
			// Récupération du num de reqête
			dossier = mesFonctions.recupCaseFileNumber(driver);
			
			// déconnexion page TRADM
//			DeconnexionTRADM.deconnecteActeur(driver);
//			Thread.sleep(2000);
//			driver = Navigateur.choixBrowser("chrome");
			
			//Connexion page TR lEGACY
			TrUrl = "https://www.telerecours.recette.juradm.fr/CA75";
			TrUrlInt = "https://www.telerecours.int1.juradm.fr/CA75"; 
			currentUrl = "int1";
		    //Authentification CAA		
			verif = driver.getCurrentUrl().contains(currentUrl);
			if(verif) {
				driver.get(TrUrlInt);
				String identifiant = "sice";
				String mdp = "sice";
				myXpath = "//input[@id='txtIdentifiant']";
				MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				Auth.AuthentificationTaCaaCeInt(driver, mdp, identifiant);
				System.out.println("Connexion TA réussi");
			}else {
				driver.get(TrUrl);
				String identifiant = "lb";
				String mdp = "lb";
				myXpath = "//input[@id='txtIdentifiant']";
				MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				Auth.AuthentificationTaCaaCeInt(driver, mdp, identifiant);
				System.out.println("Connexion CAA réussi "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
			}
			
			// Enregistrer le document
			driver.findElement(By.xpath("//td[@id='Entete1_MenuActeur1_im1_AE']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@class='numDossier' and (text()='" + dossier + "')]")).click();
			System.out.println("Dossier : "+dossier);
			
			myXpath = "//td[contains(text(),'Déposé sur Télérecours par')]//following-sibling::td";
			caractSpec = " ";
			strg = MyKeyWord.leNom(driver, myXpath, caractSpec);
			fin = strg.indexOf(strg.split(" ")[2]);
			acteur = strg.substring(0, fin).trim();
			System.out.println(acteur);
			
			// Rattachement
			mesFonctions.rattachement(driver, acteur);
			
			//Vérification fichiers 
//			str1 = new ArrayList<>();
			
			myXpath = "//a[@id='fileLinkFichierDocument_hplFichier']";
			verifFile1 = MyKeyWord.piece(driver, myXpath);
			str1.add(verifFile1);
//			System.out.println(str1);
			
			myXpath = "//a[contains(@id,'fileLinkPiecesDocument_hplFichier')]";
			str1 = MyKeyWord.fichier(driver, elements, myXpath);
			Thread.sleep(2000);
//			System.out.println(str1);
			
			myXpath = "//a[@id='fileLinkFichierInventaire_hplFichier']";
			verifFile2 = MyKeyWord.piece(driver, myXpath);
			str1.add(verifFile2);
//			System.out.println(str1);
			
			mem = Arrays.asList(memoire);
			str = Stream.concat(pieces.stream(), mem.stream())
					.collect(Collectors.toList());
			
		   if(str1.contains(str)) {
			   System.out.println(str);
			   System.out.println("Tous les fichiers sont présents "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		   }
		   else {
			   System.err.println("Les tableaux sont différents. Le tableau actuel : "+str1+" tableau attendu : "+str+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		   }
			   
		   //Enregistrement du document 
		   Thread.sleep(1000);
		   mesFonctions.enrgDoc(driver);
		   
		   
		   System.out.println("Dépôt et enregistrement CAA terminés "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		   break;

		default:System.err.println("Aucune juridiction trouvée "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
			break;
		}
		
		return null;
	}
	
	public static String verifDepotDoc(WebDriver driver, String dossier) throws Throwable {
		//accès onglet @Document
		mesFonctions.ongletDocument(driver);
		
		//Accès à l'onglet déposés
		mesFonctions.tableauVosDocument_deposes(driver);
		
		//Vérification Ajout ligne document depose
		mesFonctions.recupIdDocTraite(driver);
		mesFonctions.recupDernierIdDocAjoute(driver);
		
		//Clic sur le document déposé
		String myXpath = "//td//div[contains(text(),\""+dossier+"\")]//following-sibling::button[@icon='eye-show']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Accès au document déposé "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		
		//Verification des informations du récap
		myXpath = "//h1[text()=\"Contenu de l'envoi\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		String myXpath1 ="//div[text()=\"1. Type de document :\"]//following-sibling::div";
		String myXpath2 ="//div[text()=\"2. Type de Mémoire:\"]//following-sibling::div";
		
//		List<String> recap = new ArrayList<>();
		
		//1. Type de document 
		if(MyKeyWord.object(driver, myXpath1).getText().trim().equals(ledoc)) {
			System.out.println("Vérification avant envoi du 1. Type de document : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}else {
			System.err.println("Vérification du 1. Type de document : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath1).getText().trim()+" est différent de "+ledoc+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}
		//2. Type de mémoire
		if(MyKeyWord.object(driver, myXpath2).getText().trim().equals(type)) {
			System.out.println("Vérification avant envoi du 2. Type de mémoire : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}else {
			System.err.println("Vérification avant envoi du 2. Type de mémoire : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath2).getText().trim()+" est différent de "+type+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}
		
		//3. Liste des fichiers joints
		myXpath = "//div[@class='files-display-file-name']";
		if(MyKeyWord.object(driver, myXpath).getText().trim().equals(memoire)) {
			System.out.println("Vérification avant envoi du 3. Liste des fichiers joints : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}else {
			System.err.println("Vérification avant envoi du 3. Liste des fichiers joints : KO - Les informations ne correspondent pas entre elles : "+MyKeyWord.object(driver, myXpath).getText().trim()+" est différent de "+memoire+" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}
		
		//Pièces complémentaires
		myXpath = "(//div[@class='files-display-file-name'])[position()>1]";
		List<WebElement> myElts = driver.findElements(By.xpath(myXpath));
		int myList = myElts.size()-1;
		
		for(int i=0; i<myList; i++) {
			String coloredFile = Color.fromString(myElts.get(i).getCssValue("color")).asHex();
			if(pieces.contains(myElts.get(i).getText().trim())) {
				System.out.println("Vérification avant envoi du 3. pièces complémmentaire "+myElts.get(i).getText().trim()+" : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			}else {
				System.err.println("la pièce "+myElts.get(i).getText().trim()+" est différente de "+pieces.get(i)+"....." +MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			}
			
			if(!coloredFile.equals("#e96608")) {
				System.out.println("libellé OK....."+MyKeyWord.extractCurrentHeure()+"\r");
			}
				else {
					System.err.println("libellé KO....."+MyKeyWord.extractCurrentHeure()+"\r");
				}
		}
		
		//4. Inventaire
		myXpath = "(//div[@class='files-display-file-name'])[last()]";
		boolean verif = false;
		if(MyKeyWord.isElementPresent(driver, myXpath, verif) && MyKeyWord.object(driver, myXpath).getText().trim().equals("Inventaire automatique")) {
			System.out.println("l'inventaire est bien présent : "+MyKeyWord.object(driver, myXpath).getText().trim()+"\r");
			
			mesFonctions.visualiserInventaireManuel(driver);//même xpath que pour l'inventaire manuel
			}
			else if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				System.out.println("l'inventaire est bien présent : "+MyKeyWord.object(driver, myXpath).getText().trim()+"\r");
				
				mesFonctions.visualiserInventaireManuel(driver);
				}
				else {
					System.err.println("Pas d'inventaire présent\r");
				}
		
		//Bouton fermer
		myXpath = "//button[text()=\" Fermer \"]";
		MyKeyWord.waiting(driver, myXpath2, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Vérification du dépôt effectué "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
	
		return null;
	}
}
