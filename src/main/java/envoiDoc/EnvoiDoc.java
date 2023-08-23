package envoiDoc;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import fonctions.MyKeyWord;

public class EnvoiDoc {

	public static String envoiToutTypeDoc(WebDriver driver, WebElement element, String type) throws InterruptedException {
		switch (type) {
		
		case "Memoire":
			String myXpath = "//div[contains(text(),\"Mémoire\")]";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("type dépot Doc : Memoire "); 
			//+ MyKeyWord.object(driver, myXpath).getText());
			
			// choisir depuis une liste box	
			myXpath = "//div[@class='ng-value-container']";
			String myXpath1 = "//h2[contains(.,'Type de mémoire')]";
			Actions actions = new Actions(driver);
			actions.scrollToElement(MyKeyWord.object(driver, myXpath1));
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			
			MyKeyWord.object(driver, myXpath).click();
			System.out.println("Choix du type de mémoire");
			
			myXpath = "(//div[@class='ng-option ng-star-inserted'])[2]";
			MyKeyWord.object(driver, myXpath).click();	
			System.out.println("Type de memoire choisi");	
			
// Choisir un fichier depuis mon ordinateur 	
			
			myXpath = "(//span[contains(.,'Choisir depuis mon ordinateur')])[1]";//"//button[@class='ng-star-inserted']";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
//			WebElement elementload = driver.findElement(By.xpath(myXpath));
//			elementload.click();

//			MyKeyWord.changementOnglet(driver, 2);
			 Actions action = new Actions(driver);
			 action.sendKeys(MyKeyWord.object(driver, myXpath),"C:\\Users\\isaoudi\\Desktop\\Testing doc et outils\\passant_avec_alerte\\Exemple.pdf").perform();
			 

		
			
//			element2.sendKeys("C:\\Users\\isaoudi\\Desktop\\Testing doc et outils\\passant_avec_alerte");			
//			Frame f = new Frame();
//			FileDialog fd = new FileDialog(f, "Choose a file", FileDialog.LOAD);
//			fd.setDirectory("C:\\Users\\isaoudi\\Desktop\\Testing doc et outils\\passant_avec_alerte");
//			fd.setFile("Exemple.pdf");
//			fd.setVisible(false);
//			String filename = fd.getFile();
//			if (filename == null)
//			 System.out.println("You cancelled the choice");
//			else
//			 System.out.println("You chose " + filename);		
			
			
		    
			System.out.println("Parcourir fichiers obligatoirs memoire : ");			
			
			
//			System.out.println("Parcourir fichiers secondaire ");			
		    
			break;
			
		case "Pieces":
//			myXpath = "//div[text()='Pièces']";
//			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
//			MyKeyWord.object(driver, myXpath).click();
//			
//			
//			myXpath = "//div[@class='ng-value-container']";
//			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
//			MyKeyWord.object(driver, myXpath).click();	
////			((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MyKeyWord.object(driver, myXpath));
//			
//	
//			myXpath = "(//div[@class='ng-option ng-star-inserted'])[2]";
//			System.out.println("Type de piece choisit");
//			
//			
//			WebElement element3 =  driver.findElement(By.xpath(myXpath));	
//			element3.click();
//			element.sendKeys("C:\\Users\\isaoudi\\Desktop\\Testing doc et outils\\passant_avec_alerte");
			
			
			
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
