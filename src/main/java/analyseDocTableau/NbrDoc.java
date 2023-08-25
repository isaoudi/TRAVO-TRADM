package analyseDocTableau;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctions.MyKeyWord;
import microfonctions.mesFonctions;

public class NbrDoc {
	
	static List<WebElement> elements;
	static int nbr;
	
	public static int nbrDocuments(WebDriver driver, WebElement element) {
		//Recherche du nombre totatl de document 
		String myXpath = "//div[@fxlayout='row' and contains(text(),\"document\")]";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		String nbre = MyKeyWord.object(driver, myXpath).getText().trim().substring(0, MyKeyWord.object(driver, myXpath)
				.getText().indexOf(MyKeyWord.object(driver, myXpath).getText().trim().split(" ")[1]));
		nbr = Integer.parseInt(nbre.trim());
		
		System.out.println("Nombre de document : "+nbr);
		
		return nbr;
	}
	
	public static Integer nbrDocEnPrepa(WebDriver driver, WebElement element) throws Throwable {
		//retour première page
		mesFonctions.retourPremierePageDoc(driver);
		
		//Nbre de lignes du tableau par page
		String myXpath2 = "//tr[@class='cdk-row ng-star-inserted']";
		int nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
		@SuppressWarnings("unused")
		int tr = 0+1;
		while(nbrList==10 || nbrList!=0) {
//			System.out.println("le int tr " +tr);
			//Vérification de la page
			String myXpath0 = "(//button[contains(@class,\"item page\")])["+tr+"]";
			System.out.println("Page "+MyKeyWord.object(driver, myXpath0).getText().trim());
			
			//dénombrement de documents en préparation
			String myXpath = "//span[contains(text(),\" En préparation \")]";
			boolean verif = false;
			if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				nbr = MyKeyWord.objets(driver, elements, myXpath).size();
				System.out.println("Nombre de documents \"En préparation\" : "+nbr);
				
			}
			else {
				System.out.println("Aucun document au statut \"En préparation\" trouvé sur cette page");
			}
			
			//Changement de page
			String myXpath1 = "(//button[@class='next-previous-btn'])[2]";
			try {
				verif = MyKeyWord.object(driver, myXpath1).getAttribute("disabled") == null;
			} catch (Exception e) {
				
			} 
			
			MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath1).click();
			
//				System.out.println(verif);
				if(MyKeyWord.objets(driver, elements, myXpath2).size()>0 && verif) {
					nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
					}
				else {
					nbrList = 0;
				}
				tr++;
			} 
			
		
		return nbr;
	}
	
	
	public static Integer nbrDocDepose(WebDriver driver, WebElement element) throws Throwable {
		//retour première page
		mesFonctions.retourPremierePageDoc(driver);
		
		//Nbre de lignes du tableau par page
		String myXpath2 = "//tr[@class='cdk-row ng-star-inserted']";
		MyKeyWord.waiting(driver, myXpath2, Duration.ofSeconds(3));
		int nbrList = MyKeyWord.objets(driver, elements, myXpath2).size(); 
		@SuppressWarnings("unused")
		int tr = 0+1;
		while(nbrList>0) {
//			System.out.println("le int tr " +tr);	
			//Vérification de la page
					String myXpath0 = "(//button[contains(@class,\"item page\")])["+tr+"]";
					System.out.println("Page "+MyKeyWord.object(driver, myXpath0).getText().trim());
		
			
			//dénombrement de documents en préparation
			String myXpath = "//span[contains(text(),\" Déposé \")]";
			boolean verif = false;
			if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				nbr = MyKeyWord.objets(driver, elements, myXpath).size();
				System.out.println("Nombre de documents \" Déposé \" : "+nbr);
				
			}
			else {
				System.out.println("Aucun document au statut \"Déposé\" trouvé sur cette page");
			}
			
			//Changement de page
			String myXpath1 = "(//button[@class='next-previous-btn'])[2]";
			try {
				verif = MyKeyWord.object(driver, myXpath1).getAttribute("disabled") == null;
			} catch (Exception e) {
				
			} 
			
			MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath1).click();
			
//				System.out.println(verif);
				if(MyKeyWord.objets(driver, elements, myXpath2).size()>0 && verif) {
					nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
					}
				else {
					nbrList = 0;
				}
				tr++;
			}
		return nbr;
	}
	
	public static Integer nbrDocEnreg(WebDriver driver, WebElement element) throws Throwable {
		//retour première page
		mesFonctions.retourPremierePageDoc(driver);
		
		//Nbre de lignes du tableau par page
		String myXpath2 = "//tr[@class='cdk-row ng-star-inserted']";
		MyKeyWord.waiting(driver, myXpath2, Duration.ofSeconds(3));
		int nbrList = MyKeyWord.objets(driver, elements, myXpath2).size(); 
		@SuppressWarnings("unused")
		int tr = 0+1;
		while(nbrList>0) {
//			System.out.println("le int tr " +tr);	
			//Vérification de la page
					String myXpath0 = "(//button[contains(@class,\"item page\")])["+tr+"]";
					System.out.println("Page "+MyKeyWord.object(driver, myXpath0).getText().trim());
		
			
			//dénombrement de documents en préparation
			String myXpath = "//span[contains(text(),\" Enregistré \")]";
			boolean verif = false;
			if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				nbr = MyKeyWord.objets(driver, elements, myXpath).size();
				System.out.println("Nombre de documents \" Enregistré \" : "+nbr);
				
			}
			else {
				System.out.println("Aucun document au statut \"Enregistré\" trouvé sur cette page");
			}
			
			//Changement de page
			String myXpath1 = "(//button[@class='next-previous-btn'])[2]";
			try {
				verif = MyKeyWord.object(driver, myXpath1).getAttribute("disabled") == null;
			} catch (Exception e) {
				
			} 
			
			MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath1).click();
			
//				System.out.println(verif);
				if(MyKeyWord.objets(driver, elements, myXpath2).size()>0 && verif) {
					nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
					}
				else {
					nbrList = 0;
				}
				tr++;
			}
		return nbr;
	}
	
	public static Integer nbrDocRefus(WebDriver driver, WebElement element) throws Throwable {
		//retour première page
		mesFonctions.retourPremierePageDoc(driver);
		
		//Nbre de lignes du tableau par page
		String myXpath2 = "//tr[@class='cdk-row ng-star-inserted']";
		MyKeyWord.waiting(driver, myXpath2, Duration.ofSeconds(3));
		int nbrList = MyKeyWord.objets(driver, elements, myXpath2).size(); 
		@SuppressWarnings("unused")
		int tr = 0+1;
		while(nbrList>0) {
//			System.out.println("le int tr " +tr);	
			//Vérification de la page
					String myXpath0 = "(//button[contains(@class,\"item page\")])["+tr+"]";
					System.out.println("Page "+MyKeyWord.object(driver, myXpath0).getText().trim());
		
			
			//dénombrement de documents en préparation
			String myXpath = "//span[contains(text(),\" Refusé \")]";
			boolean verif = false;
			if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				nbr = MyKeyWord.objets(driver, elements, myXpath).size();
				System.out.println("Nombre de documents \" Refusé \" : "+nbr);
				
			}
			else {
				System.out.println("Aucun document au statut \"Refusé\" trouvé sur cette page");
			}
			
			//Changement de page
			String myXpath1 = "(//button[@class='next-previous-btn'])[2]";
			try {
				verif = MyKeyWord.object(driver, myXpath1).getAttribute("disabled") == null;
			} catch (Exception e) {
				
			} 
			
			MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath1).click();
			
//				System.out.println(verif);
				if(MyKeyWord.objets(driver, elements, myXpath2).size()>0 && verif) {
					nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
					}
				else {
					nbrList = 0;
				}
				tr++;
			}
		return nbr;
	}


	public static Integer triParStatuEnPrepa(WebDriver driver, WebElement element) throws Throwable {
		//Nbr de doc en préparation
		nbr = NbrDoc.nbrDocEnPrepa(driver, element);
//		System.out.println(nbr);
		
		//tri par colonne
		String myXpath = "//a[@routerlink='preparation']";
		MyKeyWord.object(driver, myXpath).click();
		Thread.sleep(2000);
		
		int nbr2 = NbrDoc.nbrDocuments(driver, element);
//		System.out.println(nbr2);
		if(nbr!=nbr2) {
			System.err.println("Le nombre de document En préparation dans la colonne \"Tous les documents\" : "+nbr2+ " est différent de celle de la colonne \"En préparation\" : "+nbr);
		}else {
			System.out.println("Fonction de tri par document \"En préparation\" OK | "+nbr2+" trouvé(s)");
		}
		
		
		return null;
	}
	
	public static Integer triParStatuDepose(WebDriver driver, WebElement element) throws Throwable {
		//Nbr de doc en préparation
		nbr = NbrDoc.nbrDocDepose(driver, element);
//		System.out.println(nbr);
		
		//tri par colonne
		String myXpath = "//a[@routerlink='deposes']";
		MyKeyWord.object(driver, myXpath).click();
		Thread.sleep(2000);
		
		int nbr2 = NbrDoc.nbrDocuments(driver, element);
//		System.out.println(nbr2);
		if(nbr!=nbr2) {
			System.err.println("Le nombre de document En préparation dans la colonne \"Tous les documents\" : "+nbr2+ " est différent de celle de la colonne \"En préparation\" : "+nbr);
		}else {
			System.out.println("Fonction de tri par document \"Déposés\" OK | "+nbr2+" trouvé(s)");
		}
		
		
		return null;
	}
	
	public static Integer triParStatuEnreg(WebDriver driver, WebElement element) throws Throwable {
		//Nbr de doc en préparation
		nbr = NbrDoc.nbrDocEnreg(driver, element);
//		System.out.println(nbr);
		
		//tri par colonne
		String myXpath = "//a[@routerlink='enregistres']";
		MyKeyWord.object(driver, myXpath).click();
		Thread.sleep(2000);
		
		int nbr2 = NbrDoc.nbrDocuments(driver, element);
//		System.out.println(nbr2);
		if(nbr!=nbr2) {
			System.err.println("Le nombre de document En préparation dans la colonne \"Tous les documents\" : "+nbr2+ " est différent de celle de la colonne \"En préparation\" : "+nbr);
		}else {
			System.out.println("Fonction de tri par document \"Enregistrés\" OK | "+nbr2+" trouvé(s)");
		}
		
		
		return null;
	}
	
	
	public static Integer triParStatuRefus(WebDriver driver, WebElement element) throws Throwable {
		//Nbr de doc en préparation
		nbr = NbrDoc.nbrDocRefus(driver, element);
//		System.out.println(nbr);
		
		//tri par colonne
		String myXpath = "//a[@routerlink='refuses']";
		MyKeyWord.object(driver, myXpath).click();
		Thread.sleep(2000);
		
		int nbr2 = NbrDoc.nbrDocuments(driver, element);
//		System.out.println(nbr2);
		if(nbr!=nbr2) {
			System.err.println("Le nombre de document En préparation dans la colonne \"Tous les documents\" : "+nbr2+ " est différent de celle de la colonne \"En préparation\" : "+nbr);
		}else {
			System.out.println("Fonction de tri par document \"Refusés\" OK | "+nbr2+" trouvé(s)");
		}
		
		
		return null;
	}
	
	
	public static String consultationDocEnprepa(WebDriver driver, WebElement element, String dossier) throws Throwable {
		//Accès onglet document
		String myXpath = "//a[@id='document-nav-btn']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		
		//retour à la premeière page
		mesFonctions.retourPremierePageDoc(driver);
		
		//Accès dossier en préparation
		String myXpath2 = "//tr[@class='cdk-row ng-star-inserted']";
		int nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
		@SuppressWarnings("unused")
		int tr = 0+1;
		while(nbrList==10 || nbrList!=0) {
//			System.out.println("le int tr " +tr);
			//Vérification de la page
			String myXpath0 = "(//button[contains(@class,\"item page\")])["+tr+"]";
			System.out.println("Page "+MyKeyWord.object(driver, myXpath0).getText().trim());
			
			//dénombrement de documents en préparation
			myXpath = "//tr//div[contains(text(),\""+dossier+"\")]//parent::td//following-sibling::td//span[contains(text(),\" En préparation \")]";
			boolean verif = false;
			if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				nbr = MyKeyWord.objets(driver, elements, myXpath).size();
				System.out.println("Nombre de documents \"En préparation\" : "+nbr+ " pour le dossier : "+dossier);
				
			}
			else {
				System.out.println("Aucun document au statut \"En préparation\" trouvé sur cette page pour le dossier " +dossier);
			}
			
			//Changement de page
			String myXpath1 = "(//button[@class='next-previous-btn'])[2]";
			try {
				verif = MyKeyWord.object(driver, myXpath1).getAttribute("disabled") == null;
			} catch (Exception e) {
				
			} 
			
			MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath1).click();
			
//				System.out.println(verif);
				if(MyKeyWord.objets(driver, elements, myXpath2).size()>0 && verif) {
					nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
					}
				else {
					nbrList = 0;
				}
				tr++;
			} 
		
		if(nbr!=0) {
			//tri par colonne
			myXpath = "//a[@routerlink='preparation']";
			MyKeyWord.object(driver, myXpath).click();
			Thread.sleep(2000);
			
			//clic bouton vérifictaion
			myXpath = "//tr//div[contains(text(),\""+dossier+"\")]//following-sibling::a[@icon='pen']";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Clic bouton \"pen\" du dossier : "+dossier);
			
			//Affichage des doccument en préparation 
			MyKeyWord.echappe(driver);
			
			//Nbr de carte
			myXpath = "//tradm-draft-card";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			
			int nbrCard = MyKeyWord.objets(driver, elements, myXpath).size();
			if(nbr!=nbrCard) {
				System.err.println("Le nombre de document En préparation dans la colonne \"Tous les documents\" : "+nbr+ " est différent de la liste des doc \"En préparation\" : "+nbrCard+" pour le dossier : "+dossier);
			}else {
				System.out.println("Fonction de tri par document \"En préparation\" OK | "+nbrCard+" trouvé(s) | dossier:"+dossier);
			}
		}else {
			System.out.println("Sans objet, car il n'existe aucun document \"En préparation\" pour le dossier : "+dossier);
		}
		
		return null;
	}
	
	public static String consultationDocDepose(WebDriver driver, WebElement element, String dossier) throws Throwable {
		//Accès onglet document
		String myXpath = "//a[@id='document-nav-btn']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		
		//retour à la premeière page
		mesFonctions.retourPremierePageDoc(driver);
		
		//Accès dossier déposé
		String myXpath2 = "//tr[@class='cdk-row ng-star-inserted']";
		int nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
		@SuppressWarnings("unused")
		int tr = 0+1;
		while(nbrList==10 || nbrList != 0) {
//			System.out.println("le int tr " +tr);
			//Vérification de la page
			String myXpath0 = "(//button[contains(@class,\"item page\")])["+tr+"]";
			System.out.println("Page "+MyKeyWord.object(driver, myXpath0).getText().trim());
			
			//dénombrement de documents déposés
			myXpath = "//tr//div[contains(text(),\""+dossier+"\")]//parent::td//following-sibling::td//span[contains(text(),\" Déposé \")]";
			boolean verif = false;
			if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				nbr = MyKeyWord.objets(driver, elements, myXpath).size();
				System.out.println("Nombre de documents \"Déposé\" : "+nbr+ " pour le dossier : "+dossier);
				
			}
			else {
				System.out.println("Aucun document au statut \"Déposé\" trouvé sur cette page pour le dossier " +dossier);
			}
			
			//Changement de page
			String myXpath1 = "(//button[@class='next-previous-btn'])[2]";
			try {
				verif = MyKeyWord.object(driver, myXpath1).getAttribute("disabled") == null;
			} catch (Exception e) {
				
			} 
			
			MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath1).click();
			
//				System.out.println(verif);
				if(MyKeyWord.objets(driver, elements, myXpath2).size()>0 && verif) {
					nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
					}
				else {
					nbrList = 0;
				}
				tr++;
			}
		
		return null;
	}
	
	public static String consultationDocEnreg(WebDriver driver, WebElement element, String dossier) throws Throwable {
		//Accès onglet document
		String myXpath = "//a[@id='document-nav-btn']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		
		//retour à la premeière page
		mesFonctions.retourPremierePageDoc(driver);
		
		//Accès dossier enregistré
		String myXpath2 = "//tr[@class='cdk-row ng-star-inserted']";
		int nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
		@SuppressWarnings("unused")
		int tr = 0+1;
		while(nbrList==10 || nbrList!=0) {
//			System.out.println("le int tr " +tr);
			//Vérification de la page
			String myXpath0 = "(//button[contains(@class,\"item page\")])["+tr+"]";
			System.out.println("Page "+MyKeyWord.object(driver, myXpath0).getText().trim());
			
			//dénombrement de documents enregitrés
			myXpath = "//tr//div[contains(text(),\""+dossier+"\")]//parent::td//following-sibling::td//span[contains(text(),\" Enregistré \")]";
			boolean verif = false;
			if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				nbr = MyKeyWord.objets(driver, elements, myXpath).size();
				System.out.println("Nombre de documents \"Enregistré\" : "+nbr+ " pour le dossier : "+dossier);
				
			}
			else {
				System.out.println("Aucun document au statut \"Enregistré\" trouvé sur cette page pour le dossier " +dossier);
			}
			
			//Changement de page
			String myXpath1 = "(//button[@class='next-previous-btn'])[2]";
			try {
				verif = MyKeyWord.object(driver, myXpath1).getAttribute("disabled") == null;
			} catch (Exception e) {
				
			} 
			
			MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath1).click();
			
//				System.out.println(verif);
				if(MyKeyWord.objets(driver, elements, myXpath2).size()>0 && verif) {
					nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
					}
				else {
					nbrList = 0;
				}
				tr++;
			}
		
		return null;
	}
	
	
	public static String consultationDocRefus(WebDriver driver, WebElement element, String dossier) throws Throwable {
		//Accès onglet document
		String myXpath = "//a[@id='document-nav-btn']";
		MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
		MyKeyWord.object(driver, myXpath).click();
		
		//retour à la premeière page
		mesFonctions.retourPremierePageDoc(driver);
		
		//Accès dossier refusé
		String myXpath2 = "//tr[@class='cdk-row ng-star-inserted']";
		int nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
		@SuppressWarnings("unused")
		int tr = 0+1;
		while(nbrList==10 || nbrList!=0) {
//			System.out.println("le int tr " +tr);
			//Vérification de la page
			String myXpath0 = "(//button[contains(@class,\"item page\")])["+tr+"]";
			System.out.println("Page "+MyKeyWord.object(driver, myXpath0).getText().trim());
			
			//dénombrement de documents refusés
			myXpath = "//tr//div[contains(text(),\""+dossier+"\")]//parent::td//following-sibling::td//span[contains(text(),\" Refusé \")]";
			boolean verif = false;
			if(MyKeyWord.isElementPresent(driver, myXpath, verif)) {
				nbr = MyKeyWord.objets(driver, elements, myXpath).size();
				System.out.println("Nombre de documents \"Refusé\" : "+nbr+ " pour le dossier : "+dossier);
				
			}
			else {
				System.out.println("Aucun document au statut \"Refusé\" trouvé sur cette page pour le dossier " +dossier);
			}
			
			//Changement de page
			String myXpath1 = "(//button[@class='next-previous-btn'])[2]";
			try {
				verif = MyKeyWord.object(driver, myXpath1).getAttribute("disabled") == null;
			} catch (Exception e) {
				
			} 
			
			MyKeyWord.waiting(driver, myXpath1, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath1).click();
			
//				System.out.println(verif);
				if(MyKeyWord.objets(driver, elements, myXpath2).size()>0 && verif) {
					nbrList = MyKeyWord.objets(driver, elements, myXpath2).size();
					}
				else {
					nbrList = 0;
				}
				tr++;
			}
		
		return null;
	}
}