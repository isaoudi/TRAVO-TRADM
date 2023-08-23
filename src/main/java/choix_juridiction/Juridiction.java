package choix_juridiction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fonctions.MyKeyWord;
import microfonctions.mesFonctions;

public class Juridiction {
	
	static WebDriver driver;
	static WebElement element;
	static String myXpath;
	
	
	public static String choixJur(WebDriver driver, String jur) throws Throwable { 
		
		switch (jur) {
		case "CE":
			
			if(driver.getCurrentUrl().contains("recette")) {
				
				myXpath = "//a[@href='https://www.telerecours.recette.conseil-etat.fr']";
				MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				MyKeyWord.object(driver, myXpath).click();
			}
			else {
				myXpath = "//a[@href='https://www.telerecours.int1.conseil-etat.fr']";
				MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				MyKeyWord.object(driver, myXpath).click();
			}
			break;
			
		case "TA":
			
			if(driver.getCurrentUrl().contains("recette")) {
				
				myXpath = "//a[contains(.,'https://www.telerecours.recette.juradm.fr')]";
				MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				MyKeyWord.object(driver, myXpath).click();
				
			}
			else {
				myXpath = "//a[contains(.,'https://www.telerecours.int1.juradm.fr')]";
				MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				MyKeyWord.object(driver, myXpath).click();
			}
			mesFonctions.choixJuridictionTA(driver, element);
			
			break;
			
		case "CAA":
			
			if(driver.getCurrentUrl().contains("recette")) {
				
				myXpath = "//a[contains(.,'https://www.telerecours.recette.juradm.fr')]";
				MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				MyKeyWord.object(driver, myXpath).click();
				
			}
			else {
				myXpath = "//a[contains(.,'https://www.telerecours.int1.juradm.fr')]";
				MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
				MyKeyWord.object(driver, myXpath).click();
			}
			mesFonctions.choixJuridictionCAA(driver, element);
			
			
			break;
			
		case "CNDA":
	
			myXpath = "";
			MyKeyWord.waiting(driver, myXpath, Duration.ofSeconds(3));
			MyKeyWord.object(driver, myXpath).click();
			
			break;

		default:
			break;
		}
		
		return null;
	}

}
