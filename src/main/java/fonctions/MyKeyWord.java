package fonctions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyKeyWord {
	

	
	public static WebElement object(WebDriver driver, String xpath ) {
		WebElement element = driver.findElement(By.xpath(xpath));
				
		return element;
	}
	
	public static String changementOnglet(WebDriver driver, int tab) {
		
		String onglet = MyKeyWord.getNewTab(driver, tab);	
		driver.switchTo().window(onglet);
		return null;
	}
	

//fonction d'attente de chargement 2
	public static WebDriverWait waiting(WebDriver driver, String myXpath, Duration duree) {
		
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myXpath)));
	
		
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
	
	
	

}
