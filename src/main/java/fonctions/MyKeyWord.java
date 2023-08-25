package fonctions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyKeyWord {
	

	//Fonction objet
	public static WebElement object(WebDriver driver, String xpath ) {
		WebElement element = driver.findElement(By.xpath(xpath));
				
		return element;
	}
	
	//fonction de recherche d'éléments
		public static List<WebElement> objets (WebDriver driver, List<WebElement> elements, String myXpath) {
		elements = driver.findElements(By.xpath(myXpath));
		return elements;
		}

	//Changement d'onglet
	public static String changementOnglet(WebDriver driver, int tab) {
		
		String onglet = MyKeyWord.getNewTab(driver, tab);	
		driver.switchTo().window(onglet);
		return null;
	}
	

	//fonction d'attente de chargement 1
	public static WebDriverWait waiting(WebDriver driver, String myXpath, Duration duree) {
		
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(100));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myXpath)));
		return null;
	} 
	
	//fonction d'attente de chargement 2
	public static WebDriverWait waiting2 (WebDriver driver, String tag, Duration duree) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(190));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tag)));
	return null;
			}
	
	//Fonction bascule à un autre onglet
	public static String getNewTab(WebDriver driver, int tr) {
		
		Set<String> tab = driver.getWindowHandles();
		Iterator<String> it = tab.iterator();
		String onglet="";
		for(int i=1 ; tr>=i; i++){
		onglet = it.next();
		System.out.println("tab:" + onglet);
		
	}
		return onglet;
}
	
	//fonction de séléction d'option par valeur
	public static Select selection(WebDriver driver, String myXpath, String value) {
	Select select = new Select(object(driver, myXpath));
	select.selectByValue(value);
	
	return select;
	} 
	
	//fonction de vérification d'élément présent
	public static boolean isElementPresent(WebDriver driver, String myXpath, boolean verif) throws Throwable {
		try {Thread.sleep(2000);
			verif = driver.findElement(By.xpath(myXpath)).isDisplayed();
			System.out.println("ELEMENT IS DISPLAYED : "+verif);
			return verif;
		}catch (NoSuchElementException l) {
			Thread.sleep(2000);
			System.out.println("ELEMENT IS DISPLAYED : "+verif);
			return verif;
		}
}
			
	public static String echappe(WebDriver driver) throws Throwable {
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.ESCAPE).perform();
//		Thread.sleep(2000);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(2000);
		return null;
	}
	
	public static String extractCurrentDate() {
		String pattern = "dd/MM/yyyy";
		Date date2 = new Date(System.currentTimeMillis());
		DateFormat sdf = new SimpleDateFormat(pattern);
		String dateActuelle = sdf.format(date2);
		
		
		return dateActuelle;
	}
	
}
