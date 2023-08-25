package envoiDoc;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import fonctions.MyKeyWord;
	
public class EnvoiDoc {
	
	static List<WebElement> elements;

	public static String envoiToutTypeDoc(WebDriver driver, WebElement element, String type) throws Throwable {
		switch (type) {
		
		case "Memoire":
			String myXpath = "//div[contains(text(),\"Mémoire\")]//preceding-sibling::input";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("type dépot Doc : Memoire "); 
			
			//Vérification de la présence de la barre de navigation
			myXpath = "//tradm-breadcrumb-container";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
			myXpath = "//tradm-breadcrumb-container//li//span";	
			List<WebElement> elt = MyKeyWord.objets(driver, elements, myXpath);		
			int list = elt.size();
				for(int i=0;i<list;i++) {
					String colored = Color.fromString(elt.get(i).getCssValue("color")).asHex();
//					System.out.println(mesFonctions.color(colored));

					if(colored.equals("#2dae64") && i==0) {
						System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
					
						}else if(colored.equals("#166393") && i!=0) {
							System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
							
							}else {
								System.err.println(elt.get(i).getText()+" | color : "+colored+" | couleur KO");
							}
				}
				
			// choisir depuis une liste box	
			myXpath = "//div[@class='ng-value-container']";
			String myXpath1 = "//h2[contains(.,'Type de mémoire')]";
			MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
			
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Choix du type de mémoire");
			
			myXpath = "(//div[@class='ng-option ng-star-inserted'])[2]";
			MyKeyWord.object(driver, myXpath).click();	
			System.out.println("Type de memoire choisi");
			
			//Vérification de la présence de la barre de navigation
			myXpath = "//tradm-breadcrumb-container";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
			myXpath = "//tradm-breadcrumb-container//li//span";	
			elt = MyKeyWord.objets(driver, elements, myXpath);		
			list = elt.size();
				for(int i=0;i<list;i++) {
					String colored = Color.fromString(elt.get(i).getCssValue("color")).asHex();
//					System.out.println(mesFonctions.color(colored));

					if(colored.equals("#2dae64") && i==0) {
					System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
						 
						}else if(colored.equals("#2dae64") && i==1) {
						System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
					
							}else if(colored.equals("#166393") && i!=0) {
							System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
							
								}else {
								System.err.println(elt.get(i).getText()+" | color : "+colored+" | couleur KO");
							}
				}
			
			
			// Choisir un fichier depuis mon ordinateur _  
			/*Partie à developper
			 *En attente de balise "input"
			 *Attention l'ajout de pièce se fera de mainière manuelle					
			 */
			System.out.println("Ajoutez la pièce manuellement (partie non encore scriptée)...");
			
			
			//attendre l'affichage d'un tag
			myXpath = "//tradm-file-input-display//div[@class='files-display-file-name']";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			
			String file = MyKeyWord.object(driver, myXpath).getText().trim();
			System.out.println("le fichier : "+file+" à bien été ajouté");
			
			
			// Choisir un fichier depuis mon ordinateur _ pièces complémentaires
			/*Partie à developper
			 *En attente de balise "input"
			 *Attention l'ajout de pièce se fera de mainière manuelle					
			 */
			System.out.println("Ajoutez la pièce manuellement (partie non encore scriptée)...");
			
			
			myXpath = "(//tradm-file-input-display)[2]//div[@class='files-display-file-name']";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			elt = MyKeyWord.objets(driver, elements, myXpath);		
			list = elt.size();
				for(int i=0;i<list;i++) {
					file = elt.get(i).getText().trim();
					System.out.println("le fichier : "+file+" à bien été ajouté");
					String coloredFile = Color.fromString(elt.get(i).getCssValue("color")).asHex();
						if(!coloredFile.equals("#e96608")) {
							System.out.println(file+" | color : "+coloredFile+" | libellé OK");
						}
							else {
								System.err.println(file+" | color : "+coloredFile+" | libellé KO");
							}
					}
				
			
			//Vérification de la présence de la barre de navigation
			myXpath = "//tradm-breadcrumb-container";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
			myXpath = "//tradm-breadcrumb-container//li//span";	
			elt = MyKeyWord.objets(driver, elements, myXpath);		
			list = elt.size();
				for(int i=0;i<list;i++) {
					String colored = Color.fromString(elt.get(i).getCssValue("color")).asHex();
//					System.out.println(mesFonctions.color(colored));

					if(colored.equals("#2dae64") && i==0) {
					System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
						 
						}else if(colored.equals("#2dae64") && i==1) {
						System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
						
							}else if(colored.equals("#2dae64") && i==2) {
							System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
					
								}else if(colored.equals("#166393") && i!=0) {
									System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
							
									}else {
										System.err.println(elt.get(i).getText()+" | color : "+colored+" | couleur KO");
							}
				}
				
			//Ajout de l'inventaire	
			myXpath = "//div[contains(text(),\"Inventaire automatique\")]//preceding-sibling::input";
			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MyKeyWord.object(driver, myXpath));
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Ajout de l'inventaire automatique"); 
			
			//Vérification de la présence de la barre de navigation
			myXpath = "//tradm-breadcrumb-container";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		
			myXpath = "//tradm-breadcrumb-container//li//span";	
			elt = MyKeyWord.objets(driver, elements, myXpath);		
			list = elt.size();
				for(int i=0;i<list;i++) {
					String colored = Color.fromString(elt.get(i).getCssValue("color")).asHex();
//					System.out.println(mesFonctions.color(colored));

					if(colored.equals("#2dae64")) {
					System.out.println(elt.get(i).getText()+" | color : "+colored+" | couleur OK");
						}else {
								System.err.println(elt.get(i).getText()+" | color : "+colored+" | couleur KO");
							}
				}
			
		    
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
		
		
		return null;
		
	}

}
