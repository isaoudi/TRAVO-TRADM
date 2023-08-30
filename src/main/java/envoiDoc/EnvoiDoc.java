package envoiDoc;

import java.text.ParseException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import fonctions.MyKeyWord;
import microfonctions.mesFonctions;
	
public class EnvoiDoc {
	
	static List<WebElement> elements;
	static String inventaire;
	static String enreg;
	static String type;
	static String ledoc;
	static String memoire;
	static String choix;
	static List<String> color;
	static List<String> pieces;

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
				
			// choisir depuis une liste box	
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
			memoire = mesFonctions.ajoutMemoire(driver, element);
			
			//visualisation du mémoire
			mesFonctions.visualiserMemoire(driver, element);
			
			//Suppression mémoire
			mesFonctions.supprimerMémoire(driver, element);
			
			//Etat de la barre d'envoi
			mesFonctions.navbarEnvoiDoc(driver, element);
			
			//Rajout du mémoire
			memoire = mesFonctions.ajoutMemoire(driver, element);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
			
			//Ajout de pièces complémentaires
			pieces = mesFonctions.ajoutDocPiecesAdds(driver, element);
			
			//Visualisation pièce complémentaire
			mesFonctions.visualiserPiecesAdd(driver, element);
			
			//suppression des pièces complémentaires
			mesFonctions.supprimerPiecesAdd(driver, element);
			
			//Rajout pièces complémentaires
			pieces = mesFonctions.ajoutDocPiecesAdds(driver, element);
			
				
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
			mesFonctions.inventaireDoc(driver, element, inventaire);
			
			//visualiser inventaire manuel
			mesFonctions.visualiserInventaireManuel(driver, element);
			
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
			mesFonctions.carteBoutonReprendreBrouillon(driver, element);
			
			//Verification des informations conservées dans le brouillon
			EnvoiDoc.verifBrouillonEnreg(driver, element);
			
				//Repère horaire d'exécution
				System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
				
			//Vérification avant envoi
			EnvoiDoc.AccesVerificationAvantEnvoi(driver, element);
				
			
			
			
			
			EnvoiDoc.verifDoc_TypeDoc(driver, element);
			mesFonctions.ajoutBrouillonDoc(driver, element);
			mesFonctions.carteBoutonReprendreBrouillon(driver, element);
			EnvoiDoc.AccesVerificationAvantEnvoi(driver, element);
			mesFonctions.carteBoutonReprendreBrouillon(driver, element);
			EnvoiDoc.visualiserDocs(driver, element);
			EnvoiDoc.suppressionDoc(driver, element);
			EnvoiDoc.defautEtapeEnvoiDoc(driver, element);
		    
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
			System.out.println("Etat de la barre de navigation de dépôt OK....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
		
		//Verification des informations du document
		String myXpath = "//label";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		String myXpath2 ="//div[@aria-selected='true']//span";
		
			//1. Type de document 
		if(MyKeyWord.object(driver, myXpath).getText().replaceAll("[\r\n]", " ").equals(ledoc)) {
			System.out.println("Vérification du 1. Type de document : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println("Vérification du 1. Type de document : KO - Les informations ne correspondent pas entre eux "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
			//2. Type de mémoire
		if(MyKeyWord.object(driver, myXpath2).getText().trim().equals(type)) {
			System.out.println("Vérification du 2. Type de mémoire : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println("Vérification du 2. Type de mémoire : KO - Les informations ne correspondent pas entre eux "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
		
			//3. Liste des fichiers joints
		myXpath = "//div[@class='files-display-file-name']";
		if(MyKeyWord.object(driver, myXpath).getText().trim().equals(memoire)) {
			System.out.println("Vérification du 3. Liste des fichiers joints : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println("Vérification du 3. Liste des fichiers joints : KO - Les informations ne correspondent pas entre eux "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
		
			//Pièces complémentaires
		myXpath = "(//div[@class='files-display-file-name'])[position()>1]";
		List<WebElement> myElts = driver.findElements(By.xpath(myXpath));
		int myList = myElts.size()-1;
		
		for(int i=0; i<myList; i++) {
			String coloredFile = Color.fromString(myElts.get(i).getCssValue("color")).asHex();
			if(pieces.contains(myElts.get(i).getText().trim())) {
				System.out.println("Vérification du 3. pièces complémmentaire "+myElts.get(i).getText().trim()+" : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			}else {
				System.err.println("la pièce "+myElts.get(i).getText().trim()+" est différente de "+pieces.get(i)+"....." +MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			}
			
			if(!coloredFile.equals("#e96608")) {
				System.out.println("libellé OK....."+MyKeyWord.extractCurrentHeure());
			}
				else {
					System.err.println("libellé KO....."+MyKeyWord.extractCurrentHeure());
				}
		}
		
			//4. Inventaire
		myXpath = "(//div[@class='files-display-file-name'])[last()]";
		boolean verif = false;
		if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
			System.out.println("l'inventaire est bien présent : "+MyKeyWord.object(driver, myXpath).getText().trim());
			mesFonctions.visualiserInventaireManuel(driver, element);
		}
		else {
			System.err.println("Pas d'inventaire présent");
		}
		MyKeyWord.echappe(driver);
		
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
			System.out.println("Le document : "+ledoc+" et le type de doccument : "+type+" ont bien été renseignés");
		}else {
			System.err.println("Les informations enregistrées : "+ledoc+" + "+type+" sont différentes : "+ledoc1+" + "+type1);
		}
		
		System.out.println("Vérification type de document effectuée....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		//Repère horaire d'exécution
		System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String visualiserDocs(WebDriver driver, WebElement element) throws Throwable {
//		mesFonctions.visualiserDoc(driver, element);
//		mesFonctions.visualiserPiecesAdd(driver, element);
//		
//		//Repère horaire d'exécution
//		System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String suppressionDoc(WebDriver driver, WebElement element) throws Throwable {
//		//supprimer les pièces complémentaires
//		mesFonctions.supprimerPiecesAdd(driver, element);
//		
//		//Repère horaire d'exécution
//		System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String defautEtapeEnvoiDoc(WebDriver driver, WebElement element) throws Throwable {
//		//supprimer le type de choix de mémoire
//		mesFonctions.clearChoixTypeMemoire(driver, element);
//		
//		//supprimer le mémoire
////		mesFonctions.supprimerMémoire(driver, element);
//		
//		//supprimer l'inventaire automatique
//		inventaire = "manuel";
//		mesFonctions.inventaireDoc(driver, element, inventaire);
//		
//		//Etat de la barre d'envoi
//		mesFonctions.navbarEnvoiDoc(driver, element);
//		
//		//Repère horaire d'exécution
//		System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String AccesVerificationAvantEnvoi(WebDriver driver, WebElement element) throws Throwable {
		//clic bouton "Accéder à la vérification"
		mesFonctions.boutonAccesVerifAvantEnvoiDoc(driver, element);
		
		//Verification des informations du récap
		String myXpath = "//h1[text()=\"Vérification de l'envoi\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		String myXpath1 ="//h2//following-sibling::span";
		String myXpath2 ="(//h2//following-sibling::span)[2]";
		
			//1. Type de document 
		if(MyKeyWord.object(driver, myXpath1).getText().trim().equals(ledoc)) {
			System.out.println("Vérification du 1. Type de document : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println("Vérification du 1. Type de document : KO - Les informations ne correspondent pas entre eux "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
			//2. Type de mémoire
		if(MyKeyWord.object(driver, myXpath2).getText().trim().equals(type)) {
			System.out.println("Vérification du 2. Type de mémoire : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println("Vérification du 2. Type de mémoire : KO - Les informations ne correspondent pas entre eux "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
		
			//3. Liste des fichiers joints
		myXpath = "//div[@class='files-display-file-name']";
		if(MyKeyWord.object(driver, myXpath).getText().trim().equals(memoire)) {
			System.out.println("Vérification du 3. Liste des fichiers joints : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println("Vérification du 3. Liste des fichiers joints : KO - Les informations ne correspondent pas entre eux "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
		
			//Pièces complémentaires
		myXpath = "(//div[@class='files-display-file-name'])[position()>1]";
		List<WebElement> myElts = driver.findElements(By.xpath(myXpath));
		int myList = myElts.size()-1;
		
		for(int i=0; i<myList; i++) {
			String coloredFile = Color.fromString(myElts.get(i).getCssValue("color")).asHex();
			if(pieces.contains(myElts.get(i).getText().trim())) {
				System.out.println("Vérification du 3. pièces complémmentaire "+myElts.get(i).getText().trim()+" : OK "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			}else {
				System.err.println("la pièce "+myElts.get(i).getText().trim()+" est différente de "+pieces.get(i)+"....." +MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			}
			
			if(!coloredFile.equals("#e96608")) {
				System.out.println("libellé OK....."+MyKeyWord.extractCurrentHeure());
			}
				else {
					System.err.println("libellé KO....."+MyKeyWord.extractCurrentHeure());
				}
		}
		
			//4. Inventaire
		myXpath = "(//div[@class='files-display-file-name'])[last()]";
		boolean verif = false;
		if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
			System.out.println("l'inventaire est bien présent : "+MyKeyWord.object(driver, myXpath).getText().trim());
			mesFonctions.visualiserInventaireManuel(driver, element);
		}
		else {
			System.err.println("Pas d'inventaire présent");
		}
		MyKeyWord.echappe(driver);
		
		//Repère horaire d'exécution
		System.out.println("\rEnvoiDoc.envoiToutTypeDoc()"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		return null;
	}

}
