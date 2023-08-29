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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

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
		Thread.sleep(1000);
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
		//sélectionner l'URL de redirection
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
		
		System.out.println("Vérification nombre de jours restant effectuée....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		return null;
	}
	
	public static String verifDoc(WebDriver driver, WebElement element) {
		//le document choisi (mémoire, picèce ou lettre)
		String myXpath = "//tradm-card//div[@class='body-s-semibold ng-star-inserted']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String type = MyKeyWord.object(driver, myXpath).getText().trim();
		System.out.println(type);
		
		return type;
	}
	
	public static String typeDocSelect(WebDriver driver, WebElement element) {
		//Choisir depuis une liste box	
		String myXpath = "//div[@class='ng-value-container']";
		String myXpath1 = "//h2[contains(.,'Type de mémoire')]";
		MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
		
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Choix du type de mémoire");
		
		myXpath = "(//div[@class='ng-option ng-star-inserted'])[2]";
		String myXpath2= "(//div[@class='ng-option ng-star-inserted'])[2]//span";
		String type = MyKeyWord.object(driver, myXpath2).getText().trim();
		MyKeyWord.object(driver, myXpath).click();	
		System.out.println("Type de memoire choisi");
		
		return type;
	}
	
	public static String verifTypeDocSelect(WebDriver driver, WebElement element) {
		//Le type document choisi
		String myXpath = "//tradm-card//div[@class='document-type']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String type = MyKeyWord.object(driver, myXpath).getText().trim();
		System.out.println(MyKeyWord.object(driver, myXpath).getText().trim());
		
		return type;
	}
	
	public static String boutonVerifBrouillon(WebDriver driver, WebElement element, String dossier) {
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
	
	public static List<String> navbarEnvoiDoc(WebDriver driver, WebElement element){
		//Vérification de la présence de la barre de navigation
		String myXpath = "//tradm-breadcrumb-container";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
	
		myXpath = "//tradm-breadcrumb-container//li//span";	
		List<WebElement> elt = driver.findElements(By.xpath(myXpath));		
		int list = elt.size();
			for(int i=0;i<list;i++) {
				String colored = Color.fromString(elt.get(i).getCssValue("color")).asHex();
//				System.out.println(mesFonctions.color(colored));

				if(colored.equals("#2dae64")) {
					System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
				
					}else if(colored.equals("#166393") && i!=0) {
						System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
						
						}else {
							System.err.println(elt.get(i).getText()+" | color : "+colored+" | couleur KO");
						}
			}
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
		return null;
	}
	
	public static String inventaireDoc(WebDriver driver, WebElement element, String inventaire) {
		//Choix du type l'inventaire :manuel ou automatique
		
		switch (inventaire) {
		case "manuel":
			String myXpath = "//div[contains(text(),\"Inventaire manuel\")]//ancestor::label/input";
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MyKeyWord.object(driver, myXpath));
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Ajout de l'inventaire automatique....."+MyKeyWord.extractCurrentHeure()); 
			
			
			break;
			
		case "automatique":
			myXpath = "//div[contains(text(),\"Inventaire automatique\")]//preceding-sibling::input";
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MyKeyWord.object(driver, myXpath));
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Ajout de l'inventaire automatique....."+MyKeyWord.extractCurrentHeure()); 
			
			break;

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
	
	public static String popupEnregBrouillon(WebDriver driver, WebElement element, String choix) {
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
	
	public static String SortirBrouillon(WebDriver driver, WebElement element, String choix) {
		//Revenir au dossier le brouillon 
		String myXpath = "//button[@aria-label='fermer le panneau latéral' and contains(text(),\" Revenir au dossier \")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Clic \"Revenir au dossier\"....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		//Ouverture PopUp enregistrement en brouillon
		mesFonctions.popupEnregBrouillon(driver, element, choix);
		
		return null;
	}
	
	public static String boutonAccesVerifAvantEnvoiDoc(WebDriver driver, WebElement element) {
		String myXpath = "//button[@aria-label='accéder à la vérification']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		System.out.println("Clic \"Accéder à la vérification\"....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		return null;
	}
	
	public static String carteBoutonReprendreBrouillon(WebDriver driver, WebElement element) {
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
	
	public static String carteBoutonSupprimerBrouillon(WebDriver driver, WebElement element) throws Throwable {
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
	
	public static String visualiserDoc(WebDriver driver, WebElement element)throws Throwable {
		//Visualiser la pièce du mémoire
		String myXpath = "//paju-icon[@icon='eye-show']//parent::button";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.goToUp(driver, myXpath);
		Thread.sleep(1000);
		MyKeyWord.object(driver, myXpath).click();
		//ouverture d'une fenêtre de visualisation depuis le navigateur
		System.out.println("le document peut être visualisé");
		Thread.sleep(2000);
		MyKeyWord.changementOnglet(driver, 2);
		Thread.sleep(5000);
		driver.close();
		MyKeyWord.changementOnglet(driver, 1);
		
		System.out.println("Visualisation du mémoire effectué....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		return null;
	}
	
	
	public static String visualiserPiecesAdd(WebDriver driver, WebElement element)throws Throwable {
		//Visualiser les pièces complémentaires
		String myXpath = "(//paju-icon[@icon='eye-show'])[2]//parent::button";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.goToDown(driver, myXpath);
		Thread.sleep(2000);
		MyKeyWord.object(driver, myXpath).click();
		//ouverture d'une fenêtre de visualisation depuis le navigateur
		System.out.println("le document peut être visualisé");
		Thread.sleep(2000);
		MyKeyWord.changementOnglet(driver, 2);
		Thread.sleep(5000);
		driver.close();
		MyKeyWord.changementOnglet(driver, 1);
		
		System.out.println("Visualisation d'une pièce complémentaire effectué....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
		return null;
	}
	
	public static String visualiserInventaire(WebDriver driver, WebElement element)throws Throwable {
		//Visualiser la pièce du mémoire
		String myXpath = "//paju-icon[@icon='eye-show']//parent::button[contains(@aria-label,\"visualiser le fichier ayant comme nom : Inventaire\")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.goToUp(driver, myXpath);
		Thread.sleep(1000);
		MyKeyWord.object(driver, myXpath).click();
		//ouverture d'une fenêtre de visualisation depuis le navigateur
		System.out.println("le document peut être visualisé");
		Thread.sleep(2000);
		MyKeyWord.changementOnglet(driver, 2);
		Thread.sleep(5000);
		driver.close();
		MyKeyWord.changementOnglet(driver, 1);
		
		System.out.println("Visualisation de l'inventaire effectué....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		
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

		if(colored.equals("#e96608")) {
			boolean verif = false;
			System.out.println(MyKeyWord.object(driver, myXpath).getText()+" | color : "+colored+" | couleur OK");
			String myXpath1 = "//span[text()=\"Veuillez importer un fichier\"]"; 
			MyKeyWord.isElementPresent(driver, myXpath1, verif);
			System.out.println("Présence du message d'alerte : "+MyKeyWord.object(driver, myXpath1).getText());
			System.out.println("Suppression du mémoire effectuée....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println(MyKeyWord.object(driver, myXpath).getText()+" | color : "+colored+" | couleur KO");
			System.err.println("La suppression de pièces complémentaires n'a pas bien fonctionnée");
		}
		
		return null;
	}
	
	public static String supprimerPiecesAdd(WebDriver driver, WebElement element)throws Throwable {
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
		
		System.out.println("Suppression de pièces complémentaires effectuée....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}else {
			System.err.println("La suppression de pièces complémentaires n'a pas bien fonctionnée");
			}
		}else {
			System.out.println("Aucune pièce complémentaire à supprimer....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
		}
		
		return null;
	}
	
	public static String ajoutMemoire(WebDriver driver, WebElement element) {
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
	
	public static List<String> ajoutDocPiecesAdds(WebDriver driver, WebElement element) {
		// Choisir un fichier depuis mon ordinateur _ pièces complémentaires
		/*Partie à developper
		 *En attente de balise "input"
		 *Attention l'ajout de pièce se fera de mainière manuelle					
		 */
		System.out.println("Ajoutez la pièce manuellement (partie non encore scriptée)...");
		
		
		String myXpath = "(//tradm-file-input-display)[2]//div[@class='files-display-file-name']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		List<WebElement> elt = driver.findElements(By.xpath(myXpath));		
		int list = elt.size();
		List<String> files = new ArrayList<>();
			for(int i=0;i<list;i++) {
				String file = elt.get(i).getText().trim();
				files.add(file);
				System.out.println("le fichier : "+file+" à bien été ajouté");
				String coloredFile = Color.fromString(elt.get(i).getCssValue("color")).asHex();
					if(!coloredFile.equals("#e96608")) {
						System.out.println(file+" | color : "+coloredFile+" | libellé OK....."+MyKeyWord.extractCurrentHeure());
					}
						else {
							System.err.println(file+" | color : "+coloredFile+" | libellé KO....."+MyKeyWord.extractCurrentHeure());
						}
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
			System.out.println("Présence du message d'alerte : "+MyKeyWord.object(driver, myXpath1).getText());
			System.out.println("le choix du type de mémoire a bien été supprimé....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure());
			
		}else {
			System.err.println("Aucun choix sélectionné");
		}
		
		return null;
	}
	
	
}
