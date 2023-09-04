package microfonctions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import envoiDoc.EnvoiDoc;
import fonctions.MyKeyWord;

public class mesFonctions {
	
	public static Object ongletDocument(WebDriver driver) throws Throwable {
		//Accès onglet documents TRADM
		Thread.sleep(1000);
		String myXpath = "//a[@id='document-nav-btn']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("accès onglet \"Document\"\r");
		
		return null;
	}
	
	public static Object informationActeurTRADM(WebDriver driver) {
		String myXpath = "//button[@aria-label=\"Mon profil\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		
		myXpath = "//tradm-connection-modal//div[@class='name']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Acteur : "+MyKeyWord.object(driver, myXpath).getText().trim()+"\r");
		return null;
	}
	
	public static String trAdmAccesOngletDossier(WebDriver driver) throws Throwable {
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
		System.out.println("accès page TR "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
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
		mesFonctions.ongletDocument(driver);
			
		return null;
	}
	
	public static String tableauVosDocument_tous(WebDriver driver) throws Throwable {
		//accès onglet Tous
		String myXpath = "//a[@routerlink='tous']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Accès onglet \"Tous\" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		Thread.sleep(2000);
		return null;
	}
	
	public static String tableauVosDocument_preparation(WebDriver driver) throws Throwable {
		//accès onglet En préparation 
		String myXpath = "//a[@routerlink='preparation']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Accès onglet \"En préparation\" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		Thread.sleep(2000);
		return null;
	}
	
	public static String tableauVosDocument_deposes(WebDriver driver) throws Throwable {
		//accès onglet Déposés
		String myXpath = "//a[@routerlink='deposes']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Accès onglet \"Déposés\" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		Thread.sleep(2000);
		return null;
	}
	
	public static String tableauVosDocument_enregistres(WebDriver driver) throws Throwable {
		//accès onglet Enregistrés
		String myXpath = "//a[@routerlink='enregistres']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Accès onglet \"Enregistrés\" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		Thread.sleep(2000);
		return null;
	}
	
	public static String tableauVosDocument_refuses(WebDriver driver) throws Throwable {
		//accès onglet Refusés
		String myXpath = "//a[@routerlink='refuses']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Accès onglet \"Refusés\" "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		Thread.sleep(2000);
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
     	System.out.println(MyKeyWord.object(driver, myXpath).getText()+"\r");
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
 		System.out.println(MyKeyWord.object(driver, myXpath).getText()+"\r");
 		Thread.sleep(1000);

    return null;
	}

	public static String  choixUrl(String url) {
		//sélectionner l'URL de redirection
		switch (url) {
		case "avo_rec":
			url = "https://avocats.recette.telerecours.fr/";
			System.out.println("URL est : "+url );
			break;
			
		case "avo_int":
			url = "https://avocats.int1.telerecours.fr/";
			System.out.println("URL est : "+url );
			break;
			
		case "admin_int":
			url = "https://administrations.int1.telerecours.fr/";
			System.out.println("URL est : "+url );
			break;
			
		case "admin_rec":
			url = "https://administrations.recette.telerecours.fr/";
			System.out.println("URL est : "+url );
			break;

		default:System.out.println("Aucune url correspondant");
			break;
		}
		return url;
		
	}
	
	public static String retourPremierePageDoc(WebDriver driver) {
		//Revenier à la première page du tableau de document
		String myXpath = "//input[@type='number']";
		MyKeyWord.object(driver, myXpath).clear();
		MyKeyWord.object(driver, myXpath).sendKeys("1");
		myXpath = "//button[text()='Aller']";
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Retour à la première page");
		
		return null;
	}
	
	public static String NbrJrsRestants(WebDriver driver, WebElement element) throws ParseException {
		//Le nombre de jour restant depuis la date d'enregistrement
		String myXpath = "//tradm-card//span[contains(text(),\"jour\")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String tr = MyKeyWord.object(driver, myXpath).getText();
		
		//Conversion du nombre de jours restant en integer
		String nbrRestant = tr.substring(0, tr.indexOf(tr.split(" ")[1])).trim();
		int nbr = Integer.parseInt(nbrRestant);
		
		DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		//Récupérartion de la date d'enregistrement/modification du brouillon
		myXpath = "//tradm-card//div[@class='change-information']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String str = MyKeyWord.object(driver, myXpath).getText().trim();
		System.out.println(MyKeyWord.object(driver, myXpath).getText().trim());
		String date = str.substring(str.indexOf(str.split(" ")[2]), str.indexOf(str.split(" ")[3])).trim();
		System.out.println("Récupérartion de la date d'enregistrement/modification du brouillon : "+date);
		
		//récupération de la date du jour
		String dateJour = MyKeyWord.extractCurrentDate();
		System.out.println("Récupérartion de la date du jour : "+dateJour);
		
		//Vérification du nombre de jour restant
		Date timing = sourceFormat.parse(date);
		Date timing1 = sourceFormat.parse(dateJour);
		
		long logintime = timing.getTime() -  timing1.getTime();
		int i = (int)(logintime/86400000);
		
		if(90-i==nbr) {
			System.out.println("Nbre de jours restants exact : "+tr);
		}else {
			System.err.println("Le nombre de jours restants n'est bas le bon");
		}
		
		System.out.println("Vérification nombre de jours restant effectuée....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String carteBrouillonDocSelect(WebDriver driver, WebElement element) {
		//le document choisi (mémoire, picèce ou lettre)
		String myXpath = "//tradm-card//div[@class='body-s-semibold ng-star-inserted']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String type = MyKeyWord.object(driver, myXpath).getText().trim();
		System.out.println("Le document choisi est : "+type);
		
		return type;
	}
	
	public static String typeDocSelect(WebDriver driver, WebElement element, String choix) {
		//Choisir depuis une liste box	
		String myXpath = "//div[@class='ng-value-container']";
		String myXpath1 = "//h2[contains(.,'Type de mémoire')]";
		MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
		
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Choix du type de mémoire effectué");
		
		myXpath = "(//div[@class='ng-option ng-star-inserted'])["+choix+"]";
		String myXpath2 ="//div[@class='ng-value ng-star-inserted']//span[2]";
		MyKeyWord.object(driver, myXpath).click();
		MyKeyWord.waiting(driver, myXpath2, Duration.ofSeconds(3));
		String type = MyKeyWord.object(driver, myXpath2).getText().trim();
		System.out.println("Type de memoire choisi : "+MyKeyWord.object(driver, myXpath2).getText().trim());
		
		return type;
	}
	
	public static String carteBrouillonTypeDocSelect(WebDriver driver, WebElement element) {
		//Le type document choisi
		String myXpath = "//tradm-card//div[@class='document-type']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String type = MyKeyWord.object(driver, myXpath).getText().trim();
		System.out.println("Le type de document choisi est : "+MyKeyWord.object(driver, myXpath).getText().trim());
		
		return type;
	}
	
	public static String verifInfoCarteBrouillonApresEnreg(WebDriver driver, WebElement element) throws Throwable {
		//vérification de l'enregistrement du brouillon. Celui-ci doit suivre impérativement un cas d'enregistrement du brouillon !!!
		MyKeyWord.echappe(driver);
		Thread.sleep(3500);
		String myXpath = "//h1[@class='case-file-number']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		System.out.println("Retour dossier : "+MyKeyWord.object(driver, myXpath).getText().trim()+"....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		//verification de la dernière carte enregistrée
		mesFonctions.NbrJrsRestants(driver, element);
		
		//vérification du type de document sélectionné
		EnvoiDoc.verifDoc_TypeDoc(driver, element);
		
		return null;
	}
	
	public static String boutonAccesBrouillon(WebDriver driver, WebElement element, String dossier) {
		//Vérifier les brouillons depuis la liste des documents en cliquant sur le bouton stylo "pen"
		String myXpath = "//tr//div[contains(text(),\""+dossier+"\")]//following-sibling::a[@icon='pen']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Clic bouton \"pen\" du dossier : "+dossier);
		return null;
	}

	public static String ajoutBrouillonDoc(WebDriver driver, WebElement element) {
		//extract date courrante
		String date = MyKeyWord.extractCurrentDate();
		
		//Vérification de la date lors de l'ajout
		String myXpath = "//tradm-card//div[@class='change-information']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String tr = MyKeyWord.object(driver, myXpath).getText().trim();
//		System.out.println(MyKeyWord.object(driver, myXpath).getText().trim());
		
		String ajout = tr.substring(0, tr.indexOf(tr.split(" ")[1])).trim();
		String date1 = tr.substring(tr.indexOf(tr.split(" ")[2]), tr.indexOf(tr.split(" ")[3])).trim();
//		System.out.println(ajout+"...."+date1);
		if(ajout.equals("Ajouté") && date1.equals(date)) {
			System.out.println("le brouillon en préparation à bien été : "+ajout+" le "+date);
		}else {
			System.err.println("Le brouillon en préparation n'est pas un ajout et/ou la date d'enregistrement ne correspond pas la date d'aujourd'hui");
		}
		System.out.println("Vérification de la date d'ajout effectuée ....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		return null;
		
	}
	
	public static String modifieBrouillonDoc(WebDriver driver, WebElement element) {
		//extract date courrante
		String date = MyKeyWord.extractCurrentDate();
		
		//Vérification de la date lors d l'ajout
		String myXpath = "//tradm-card//div[@class='change-information']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String tr = MyKeyWord.object(driver, myXpath).getText().trim();
		System.out.println(MyKeyWord.object(driver, myXpath).getText().trim());
		
		String modif = tr.substring(0, tr.indexOf(tr.split(" ")[1])).trim();
		String date1 = tr.substring(tr.indexOf(tr.split(" ")[2]), tr.indexOf(tr.split(" ")[3])).trim();
		System.out.println(modif+"...."+date1);
		if(modif.equals("Modifié") && date1.equals(date)) {
			System.out.println("le brouillon en préparation à bien été : "+modif+" le "+date);
		}else {
			System.err.println("Le brouillon en préparation n'est pas une modification et/ou la date d'enregistrement ne correspond pas la date d'aujourd'hui");
		}
		
		System.out.println("Vérification de la date de modification effectuée ....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		return null;
	}
	
	public static String color(String color) {
		//Code couleur CSS 
		switch (color) {
		case "#2dae64":
			
			System.out.println("sea-green-theme");
			
			break;
			
		case "#166393":
			
			System.out.println("sapphire-theme");
			
			break;
			
		case "#e96608":
			
			System.out.println("geranium-theme");
			
			break;

		default:System.err.println("Aucune couleur ne correspond à ce code");
			break;
		}
		
		return null;
	}
	
	public enum codeCouleur{
		sea_green_theme("#2dae64"),
		sapphire_theme("#166393"),
		geranium_theme("#e96608");
		
		private String couleur;
		
		private codeCouleur(String couleur) {
			this.couleur = couleur;
		}
		
		public String getCouleur() {
			return couleur;
		}
		
	}
	
	public static List<String> navbarEnvoiDoc(WebDriver driver, WebElement element){
		//Vérification de la présence de la barre de navigation
		System.out.println("\rEtat des étapes d'envoi");
		String myXpath = "//tradm-breadcrumb-container";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		myXpath = "//tradm-breadcrumb-container//li//span";	
		List<WebElement> elt = driver.findElements(By.xpath(myXpath));
		List<String> color = new ArrayList<>();
		int list = elt.size();
			for(int i=0;i<list;i++) {
				String colored = Color.fromString(elt.get(i).getCssValue("color")).asHex();
//				System.out.println(mesFonctions.color(colored));
				color.add(colored);

				if(colored.equals("#2dae64")) {
					System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
				
					}else if(colored.equals("#166393") && i!=0) {
						System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
						
						}else {
							System.err.println(elt.get(i).getText()+" | color : "+colored+" | couleur KO");
						}
			}
			System.out.println("\r");
			
			
//			myXpath = "//tradm-breadcrumb-container";
//			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
//		
//			myXpath = "//tradm-breadcrumb-container//li//span";	
//			elt = MyKeyWord.objets(driver, elements, myXpath);		
//			list = elt.size();
//				for(int i=0;i<list;i++) {
//					String colored = Color.fromString(elt.get(i).getCssValue("color")).asHex();
////					System.out.println(mesFonctions.color(colored));
//
//					if(colored.equals("#2dae64")) {
//					System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
//						}else {
//								System.err.println(elt.get(i).getText()+" | color : "+colored+" | couleur KO");
//							}
//				}
		return color;
	}
	
	public static String inventaireDoc(WebDriver driver, WebElement element, String inventaire) throws Throwable {
		//Choix du type l'inventaire :manuel ou automatique
		
		switch (inventaire) {
		//sans file
		case "manuel":
			String myXpath = "//div[contains(text(),\"Inventaire manuel\")]//ancestor::label/input";
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MyKeyWord.object(driver, myXpath));
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Choix inventaire manuel (sans ajout de fichier)....."+MyKeyWord.extractCurrentHeure());
			String myXpath1 = "//span[text()=\"Veuillez importer un fichier\"]";
			boolean verif = false;
			if(MyKeyWord.isElementPresent(driver, myXpath1, verif)) {
				System.out.println("Présence du message d'alerte : "+MyKeyWord.object(driver, myXpath1).getText()+"\r");
			}else {
				System.err.println("Pas de message d'alerte avertissant de l'absence de fichier"+"\r");
			}
			
			break;
			
		case "automatique":
			//inventaire automatique
			myXpath = "//div[contains(text(),\"Inventaire automatique\")]//preceding-sibling::input";
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MyKeyWord.object(driver, myXpath));
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Ajout de l'inventaire automatique....."+MyKeyWord.extractCurrentHeure()+"\r");
			
			break;
			
		case "manuelfile":
			//choix inventaire manuel avec fichier
			myXpath = "//div[contains(text(),\"Inventaire manuel\")]//ancestor::label/input";
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MyKeyWord.object(driver, myXpath));
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			
			// Choisir un fichier depuis mon ordinateur _  
			/*Partie à developper
			 *En attente de balise "input"
			 *Attention l'ajout de pièce se fera de mainière manuelle					
			 */
			System.out.println("Ajoutez la pièce manuellement (partie non encore scriptée)...");
			
			//attendre l'affichage d'un tag
			myXpath = "//div[contains(@class,'inventory')]//tradm-file-input-display//div[@class='files-display-file-name']";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			
			String file = MyKeyWord.object(driver, myXpath).getText().trim();
			System.out.println("le fichier : "+file+" à bien été ajouté....."+MyKeyWord.extractCurrentHeure());
			
			System.out.println("Ajout de l'inventaire manuel....."+MyKeyWord.extractCurrentHeure()+"\r"); 
			
			return file;
			
			

		default: System.out.println("Type d'inventaire non reconnu");
			break;
		}
		
		return null;
		
	}
	
	public static String EnregBrouillon(WebDriver driver, WebElement element) {
		//Enregistrer le brouillon 
		String myXpath = "//button[@aria-label='enregistrer le brouillon']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Brouillon enregistré....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		return null;
		
	}
	
	public static String popupEnregBrouillon(WebDriver driver, String choix) {
		//Choix d'enregistrer son brouillon
		switch (choix) {
		case "enreg":
			String myXpath = "//button[contains(text(),\" Quitter sans enregistrer \")]";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Quitter sans enregistrer....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			break;
			
		case "noEnreg":
			myXpath = "//button[contains(text(),\" Enregistrer en brouillon \")]";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Enregistrer en brouillon....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			break;
			
		case "referme":
			myXpath = "//button[@aria-label='Fermer la fenêtre modale']";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Enregistrer en brouillon....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			break;

		default: System.out.println("Choix inexistant");
			break;
		}
		return null;
	}
	
	public static String SortirBrouillon(WebDriver driver, String choix) {
		//Revenir au dossier le brouillon 
		String myXpath = "//button[@aria-label='fermer le panneau latéral' and contains(text(),\" Revenir au dossier \")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Clic \"Revenir au dossier\"....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		//Ouverture PopUp enregistrement en brouillon
		mesFonctions.popupEnregBrouillon(driver, choix);
		
		return null;
	}
	
	public static String boutonAccesVerifAvantEnvoiDoc(WebDriver driver, WebElement element) {
		String myXpath = "//button[@aria-label='accéder à la vérification']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Clic \"Accéder à la vérification\"....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		return null;
	}
	
	public static String carteBoutonReprendreBrouillon(WebDriver driver) {
		//Accès menu de la carte
		String myXpath = "//button//paju-icon[@icon='ellipsis-vertical']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		
		//reprendre le brouillon
		myXpath = "//button/span[contains(text(),\"Reprendre\")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		
		System.out.println("Brouillon repris....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		return null;
	}
	
	public static String carteBoutonSupprimerBrouillon(WebDriver driver) throws Throwable {
		//estimation du nombre de cartes
		String myXpath = "//tradm-draft-card";
		List<WebElement> elements = driver.findElements(By.xpath(myXpath));
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				
		int nbrCard = MyKeyWord.objets(driver, elements, myXpath).size();
		
		//Accès menu de la carte
		myXpath = "//button//paju-icon[@icon='ellipsis-vertical']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();

		
		//supprimer le brouillon
		myXpath = "//button/span[contains(text(),\"Supprimer\")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		Thread.sleep(3000);
		
		if(nbrCard==nbrCard-1) {
			System.out.println("Brouillon bien supprimé....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
		else {
			System.err.println("La suppression s'est mal passée !!");
		}
		
		return null;
	}
	
	public static String visualiserMemoire(WebDriver driver) throws Throwable {
		//Visualiser la pièce du mémoire
		String myXpath = "//paju-icon[@icon='eye-show']//parent::button";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.goToDown(driver, myXpath);
		Thread.sleep(1000);
		MyKeyWord.object(driver, myXpath).click();
		//ouverture d'une fenêtre de visualisation depuis le navigateur
		System.out.println("le document peut être visualisé"+"\r");
		Thread.sleep(2000);
		MyKeyWord.changementOnglet(driver, 2);
		Thread.sleep(5000);
		driver.close();
		MyKeyWord.changementOnglet(driver, 1);
		
		System.out.println("Visualisation du mémoire effectué....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	
	public static String visualiserPiecesAdd(WebDriver driver)throws Throwable {
		//Visualiser les pièces complémentaires
		String myXpath = "(//paju-icon[@icon='eye-show'])[2]//parent::button";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.goToDown(driver, myXpath);
		Thread.sleep(2000);
		MyKeyWord.object(driver, myXpath).click();
		
		//ouverture d'une fenêtre de visualisation depuis le navigateur
		System.out.println("le document peut être visualisé"+"\r");
		Thread.sleep(2000);
		MyKeyWord.changementOnglet(driver, 2);
		Thread.sleep(5000);
		driver.close();
		MyKeyWord.changementOnglet(driver, 1);
		
		System.out.println("Visualisation d'une pièce complémentaire effectué....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String visualiserInventaireAutomatique(WebDriver driver, WebElement element)throws Throwable {
		//Visualiser la pièce du mémoire
		String myXpath = "//paju-icon[@icon='eye-show']//parent::button[contains(@aria-label,\"visualiser l'inventaire\")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.goToDown(driver, myXpath);
		Thread.sleep(1000);
		MyKeyWord.object(driver, myXpath).click();
		//ouverture d'une fenêtre de visualisation depuis le navigateur
		System.out.println("le document peut être visualisé"+"\r");
		Thread.sleep(2000);
		MyKeyWord.changementOnglet(driver, 2);
		Thread.sleep(5000);
		driver.close();
		MyKeyWord.changementOnglet(driver, 1);
		
		System.out.println("\rVisualisation de l'inventaire effectué....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String visualiserInventaireManuel(WebDriver driver)throws Throwable {
		//Visualiser la pièce du mémoire
		String myXpath = "(//paju-icon[@icon='eye-show']//parent::button[contains(@aria-label,\"visualiser le fichier ayant comme nom\")])[last()]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.goToDown(driver, myXpath);
		Thread.sleep(1000);
		MyKeyWord.object(driver, myXpath).click();
		//ouverture d'une fenêtre de visualisation depuis le navigateur
		System.out.println("le document peut être visualisé\r");
		Thread.sleep(2000);
		MyKeyWord.changementOnglet(driver, 2);
		Thread.sleep(5000);
		driver.close();
		MyKeyWord.changementOnglet(driver, 1);
		
		System.out.println("\rVisualisation de l'inventaire effectué....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		
		return null;
	}
	
	public static String supprimerMémoire(WebDriver driver, WebElement element)throws Throwable {
		//Vérification du mémoire
		String myXpath = "//tradm-breadcrumb-container";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
	
		myXpath = "(//tradm-breadcrumb-container//li//span)[3]";
		String colored = Color.fromString(MyKeyWord.object(driver, myXpath).getCssValue("color")).asHex();

		if(colored.equals("#2dae64")) {
			System.out.println(MyKeyWord.object(driver, myXpath).getText()+" | color : "+colored+" | couleur OK");
		}else {
			System.err.println(MyKeyWord.object(driver, myXpath).getText()+" | color : "+colored+" | couleur KO");
		}
		
		//Suppression du mémoire 
		myXpath = "//paju-icon[@icon='trash']//parent::button";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.goToDown(driver, myXpath);
		MyKeyWord.moveToObject(driver, myXpath);
		Thread.sleep(3000);
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("le document a été supprimé");
		
		//Vérification de la présence du mémoire
		myXpath = "//tradm-breadcrumb-container";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
	
		myXpath = "(//tradm-breadcrumb-container//li//span)[3]";
		colored = Color.fromString(MyKeyWord.object(driver, myXpath).getCssValue("color")).asHex();

		if(colored.equals("#d92f2f")) {
			boolean verif = false;
			System.out.println(MyKeyWord.object(driver, myXpath).getText()+" | color : "+colored+" | couleur OK");
			String myXpath1 = "//span[text()=\"Veuillez importer un fichier\"]"; 
			MyKeyWord.isElementPresent(driver, myXpath1, verif);
			System.out.println("Présence du message d'alerte : "+MyKeyWord.object(driver, myXpath1).getText());
			System.out.println("Suppression du mémoire effectuée....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		}else {
			System.err.println(MyKeyWord.object(driver, myXpath).getText()+" | color : "+colored+" | couleur KO");
			System.err.println("La suppression du mémoire n'a pas bien fonctionnée"+"\r");
		}
		
		return null;
	}
	
	public static String supprimerPiecesAdd(WebDriver driver)throws Throwable {
		//nombre de pièce avant suppression
		String myXpath = "(//tradm-file-input-display)[2]//div[@class='files-display-file-name']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		List<WebElement> elt = driver.findElements(By.xpath(myXpath));		
		int list = elt.size();
		
		if(list!=0) {
		//Suppression de pièces complémentaire 
		myXpath = "(//button//paju-icon[@icon='trash'])[2]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("le document a été supprimé");
		
		//nombre de pièce après suppression
		Thread.sleep(2000);
		myXpath = "(//tradm-file-input-display)[2]//div[@class='files-display-file-name']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		elt = driver.findElements(By.xpath(myXpath));		
		int list1 = elt.size();
		
			if(list>list1) {
			
			System.out.println("Suppression de pièces complémentaires effectuée....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
			}else {
				System.err.println("La suppression de pièces complémentaires n'a pas bien fonctionnée"+"\r");
				}
			}
		else {
			System.out.println("Aucune pièce complémentaire à supprimer....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		}
		
		return null;
	}
	
	public static String ajoutMemoire(WebDriver driver) {
		// Choisir un fichier depuis mon ordinateur _  
		/*Partie à developper
		 *En attente de balise "input"
		 *Attention l'ajout de pièce se fera de mainière manuelle					
		 */
		System.out.println("Ajoutez la pièce manuellement (partie non encore scriptée)...");
		
		
		//attendre l'affichage d'un tag
		String myXpath = "//tradm-file-input-display//div[@class='files-display-file-name']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		String file = MyKeyWord.object(driver, myXpath).getText().trim();
		System.out.println("le fichier : "+file+" à bien été ajouté....."+MyKeyWord.extractCurrentHeure());
		
		return file;
	}
	
	public static List<String> ajoutDocPiecesAdds(WebDriver driver) throws Throwable {
		// Choisir un fichier depuis mon ordinateur _ pièces complémentaires
		/*Partie à developper
		 *En attente de balise "input"
		 *Attention l'ajout de pièce se fera de mainière manuelle					
		 */
		System.out.println("Ajoutez la pièce manuellement (partie non encore scriptée)...");
		
		boolean verif = false;
		List<String> files = new ArrayList<>();
		String myXpath = "(//tradm-file-input-display)[2]//div[@class='files-display-file-name']";
		
		try{MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));}
		catch(NoSuchElementException l) {}
		if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
		List<WebElement> elt = driver.findElements(By.xpath(myXpath));		
		int list = elt.size();
		
			for(int i=0;i<list;i++) {
				String file = elt.get(i).getText().trim();
				files.add(file);
				System.out.println("le fichier : "+file+" à bien été ajouté");
				String coloredFile = Color.fromString(elt.get(i).getCssValue("color")).asHex();
					if(!coloredFile.equals("#e96608")) {
						System.out.println(file+" | color : "+coloredFile+" | libellé OK....."+MyKeyWord.extractCurrentHeure()+"\r");
					}
						else {
							System.err.println(file+" | color : "+coloredFile+" | libellé KO....."+MyKeyWord.extractCurrentHeure()+"\r");
						}
				}
		}
		else {
			System.out.println("Aucune pièce complémentaire chargée\r");
		}
		
		
		return files;
	}
	
	public static String clearChoixTypeMemoire(WebDriver driver, WebElement element) throws Throwable {
		//Supprimer le choix du type de mémoire
		String myXpath = "//span[@title='Clear all']";
		boolean verif = false;
		if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
			MyKeyWord.goToUp(driver, myXpath);
			MyKeyWord.object(driver, myXpath).click();
			String myXpath1 = "//span[contains(text(),\"Veuillez sélectionner un élément dans la liste\")]";
			MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
			System.out.println("Présence du message d'alerte : "+MyKeyWord.object(driver, myXpath1).getText());
			System.out.println("le choix du type de mémoire a bien été supprimé....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}else {
			System.err.println("Aucun choix sélectionné"+"\r");
		}
		
		return null;
	}
	
	public static String checkboxValidationEnvoi(WebDriver driver, WebElement element) {
		//Coche "Je valide l'ordre, le libellé et la conversion en PDF de tous mes documents."
		String myXpath = "//span[contains(text(),\" Je valide l'ordre,\")]//preceding-sibling::input";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("\"Je valide l'ordre, le libellé et la conversion en PDF de tous mes documents\" a été coché "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		//Coche "Je valide l'ordre, le libellé et la conversion en PDF de tous mes documents."
		myXpath = "//span[contains(text(),\"Je valide l'exactitude de mon inventaire\")]//preceding-sibling::input";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("\"Je valide l'exactitude de mon inventaire\" a été coché "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");

		return null;
	}
	
	public static String boutonValiderEnvoiDoc(WebDriver driver, WebElement element) {
		String myXpath = "//div[@class='footer']//button[contains(text(),\" Envoyer \")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		
		myXpath = "//paju-icon[@class='toaster-close-icon']";
		String myXpath1 = "//paju-toast";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		if(MyKeyWord.getAttibuteValue(driver, myXpath1, "class").trim().equals("ng-star-inserted success")) {
			System.out.println("Le document a bien été envoyé : "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		}
		
		return null;
	}
	
	public static Object boutonModifierTypeDocAvantEnvoi(WebDriver driver) throws Throwable {
		String myXpath = "//button[@aria-label=\"modifier le type de document\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.scrollUp(driver);
		MyKeyWord.object(driver, myXpath).click();
		
		myXpath = "//legend[text()=\"Choisir un type de document :\"]//parent::fieldset//div[contains(text(),\"Mémoire\")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		System.out.println("Le \"Type de document à envoyer\" peut être modifié "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		Thread.sleep(2000);
		
		return null;
	}
	
	public static Object boutonModifierTypeMemoireAvantEnvoi(WebDriver driver) throws Throwable {
		String myXpath = "//button[@aria-label=\"modifier le type de memoire\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.scrollUp(driver);
		MyKeyWord.object(driver, myXpath).click();
		
		myXpath = "//label[text()=\"Choisir un type de mémoire :\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		System.out.println("Le \"Type de mémoire\" peut être modifié "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		Thread.sleep(2000);
		
		return null;
	}
	
	public static Object boutonModifierFichiersAvantEnvoi(WebDriver driver, WebElement element) throws InterruptedException {
		String myXpath = "//button[@aria-label=\"modifier la liste des fichiers joints\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.goToDown(driver, myXpath);
		MyKeyWord.object(driver, myXpath).click();
		
		myXpath = "//tradm-file-input-display//div[@class='files-display-file-name']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		System.out.println("Les \"fichiers joints\" peuvent être modifiés "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		Thread.sleep(2000);
		
		return null;
	}
	
	public static Object boutonModifierInventaireAvantEnvoi(WebDriver driver, WebElement element) throws InterruptedException {
		String myXpath = "//button[@aria-label=\"modifier le type d'inventaire\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.goToDown(driver, myXpath);
		MyKeyWord.object(driver, myXpath).click();
		
		myXpath = "//legend[text()=\"Choisir un type d'inventaire :\"]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
		System.out.println("Les \"fichiers joints\" peuvent être modifiés "+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
		Thread.sleep(2000);
		
		return null;
	}
	
	public static String recupNcasefileNumber(WebDriver driver) {
		String myXpath = "//td[contains(@class,\"cdk-cell case-file-number cdk-column-caseFileNumber ng-star-inserted\")]//div";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String dossier = MyKeyWord.object(driver, myXpath).getText().trim();
		return dossier;
	}

}
