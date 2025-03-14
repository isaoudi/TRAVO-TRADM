package fonctions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyKeyWord {
	

	//Fonction objet
	public static WebElement object(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
				
		return element;
	}
	
	//fonction de recherche d'éléments
		public static List<WebElement> objets (WebDriver driver, List<WebElement> elements, String myXpath) {
		elements = driver.findElements(By.xpath(myXpath));
		return elements;
		}

	//Changement d'onglet
	public static String changementOnglet(WebDriver driver, int tab) throws Throwable {
		String onglet = MyKeyWord.getNewTab(driver, tab);
		Thread.sleep(500);
		driver.switchTo().window(onglet);
		return null;
	}
	
	//Ajouter un onglet
	public static JavascriptExecutor addTab (WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("window.open();");
		
		return null;
	}

	//fonction d'attente de chargement 1
	public static WebDriverWait waiting(WebDriver driver, String myXpath, Duration duree) {
		
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(100));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myXpath)));
		return null;
	} 
	
	//fonction d'attente de chargement 2
	public static WebDriverWait waiting2 (WebDriver driver, String myXpath, Duration duree) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myXpath)));
	return null;
			}
	
	//Fonction bascule à un autre onglet
	public static String getNewTab(WebDriver driver, int tr){
		Set<String> tab = driver.getWindowHandles();
		Iterator<String> it = tab.iterator();
		String onglet="";
		for(int i=1 ; tr>=i; i++){
		onglet = it.next();
		System.out.println("Index tab:" + onglet);
		
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
			System.err.println("ELEMENT IS DISPLAYED : "+verif);
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
		//récupération de la date du jour
		String pattern = "dd/MM/yyyy";
		Date date2 = new Date(System.currentTimeMillis());
		DateFormat sdf = new SimpleDateFormat(pattern);
		String dateActuelle = sdf.format(date2);
		
		
		return dateActuelle;
	}
	
	public static String extractCurrentHeure() {
		//récupération de l'heure actuelle
		String pattern = "HH:mm:ss.SSS";
		Date date2 = new Date(System.currentTimeMillis());
		DateFormat sdf = new SimpleDateFormat(pattern);
		String dateActuelle = sdf.format(date2);
		
		
		return dateActuelle;
	}
	
	//Rendre visible un élément en bas de page
	public static void goToDown(WebDriver driver, String myXpath) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", MyKeyWord.object(driver, myXpath));	
		} 
	
	//Rendre visible un élément en haut de page
	public static void scrollUp(WebDriver driver, String myXpath) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", MyKeyWord.object(driver, myXpath));
	}
		
	//Rendre visible un élément en haut de page
	public static Object scrollDown(WebDriver driver) {
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,900);");
		return null;
	}
	
	//Rendre visible un élément
	public static Actions moveToObject(WebDriver driver, String xpath) {
		Actions actions = new Actions(driver);
		actions.moveToElement(MyKeyWord.object(driver, xpath));
		actions.perform();
		return null;
	}
		
	//Rendre visible un élément en haut de page
	public static Object goToUp(WebDriver driver, String myXpath) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", MyKeyWord.object(driver, myXpath));
		return null;
	}
	
	//Zoomer la page
	public static Object zoomPage(WebDriver driver, String myXpath) {
		((JavascriptExecutor)driver).executeScript("document.body.style.zoom = '0.67'");//zoom de la page 100% = 1
		return null;
		}
	
	public static String getCSSvalue(WebDriver driver, String xpath, String value) {
		//Récupération des valeur CSS
		String vl = MyKeyWord.object(driver, xpath).getCssValue(value);
		System.out.println("CSS value : "+vl);
		
		return vl;
	}
	
	public static String getAttibuteValue(WebDriver driver, String xpath, String value) {
		String attr = MyKeyWord.object(driver, xpath).getDomAttribute(value);
		return attr;
	}
	
	//fonction de création de nom
	public static String leNom(WebDriver driver, String myXpath, String caractSpec) {
		String nom = driver.findElement(By.xpath(myXpath)).getText();
		int deb = nom.indexOf(nom.split(caractSpec)[1]);
		String nomNew = nom.substring(deb , nom.length()).trim();
		return nomNew;
	}
	
	//renommer les pièces
	public static String piece(WebDriver driver, String myXpath) {
		String n = MyKeyWord.object(driver, myXpath).getText().trim();
		String h = n.substring(10, n.length()).replaceAll("_", " ").trim();
		System.out.println(h);
		return h;
	}
	

	//fonction de recherche d'éléments
	public static List<String> fichier (WebDriver driver, List<WebElement> elements, String myXpath) {
	elements = driver.findElements(By.xpath(myXpath));
	int nbr = elements.size();
	List<String> files = new ArrayList<>();
	for(int i=0; i<nbr; i++) {
		String lesFiles = elements.get(i).getText();
		String h = lesFiles.substring(10, lesFiles.length()).replaceAll("_", " ").trim();
		files.add(h);
		//System.out.println(files);
		}
	return files;
	}
	
	//Converting String into int
	public static int convertStringToInt(String nbr) {
	int i = Integer.parseInt(nbr);
	return i;  
	}
	
	public static void souriOver (WebDriver driver, String myXpath) {
		Actions action = new Actions(driver);
		WebElement element  = MyKeyWord.object(driver, myXpath);
		action.moveToElement(element).build().perform();
	}
	
	public static Actions souris_mvt(WebDriver driver, String myXpath) {
		Actions action = new Actions(driver);
		WebElement element  = MyKeyWord.object(driver, myXpath);
		return action.moveToElement(element);
	}
	
	
	public static String time (String str, String pattern) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = simpleDateFormat.parse(str);
		String dt = simpleDateFormat.format(date);
		return dt;
	}
	
	public static String currentTime () throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY HH:mm");
		Date date = new Date(System.currentTimeMillis());
		return formatter.format(date);
	}

	
	public static String loadingTime(WebDriver driver, String myXpath) throws Throwable {
		//Estimation du temps de chargement d'un élément ou objet
		String pattern = "ss.SSS";
	    String pattern1 = "mm:ss.SSS";
	    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	    SimpleDateFormat sdf1 = new SimpleDateFormat(pattern1);
		
		long starttime = System.currentTimeMillis();
		MyKeyWord.waiting2(driver, myXpath, Duration.ofSeconds(3));
		long stoptime = System.currentTimeMillis();
		long logintime = stoptime -  starttime;
		Date loadingPage = new Date(logintime);
		   
		   
		   if(logintime>999){
			   System.out.println("Temps de chargement de la page " + sdf1.format(loadingPage)+"ms");
			   return sdf1.format(loadingPage); 
		   }else {
			   System.out.println("Temps de chargement de la page  " + sdf.format(loadingPage)+"ms");
			   return sdf.format(loadingPage);
		   }

	}
	
	public static String ajouter_jour_date(Integer nbr) {
		
		Date date2 = new Date(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date2);
		calendar.add(Calendar.DATE, nbr);
		date2 = calendar.getTime();
		
		String pattern = "dd/MM/yyyy";
		DateFormat sdf = new SimpleDateFormat(pattern);
		String myDate = sdf.format(date2);
		
		return myDate;
	}
	
	public static String recuperation_Majuscule_String(String str) {
		//Récupérer les majuscules dans une string 
		String pat = "\\p{Upper}\\p{Lower}";
		Pattern pattern = Pattern.compile(pat);
		Matcher matcher = pattern.matcher(str);
		while(matcher.find()) {
			str = str.replace(matcher.group(), "");
		}
		
			String txt = "";
			for(int i=0;i<str.length();i++) {
				if(Character.isUpperCase(str.charAt(i)) || (str.charAt(i)==' ' || str.charAt(i)=='-' && str.length()!=0 )) {
					txt += String.valueOf(str.charAt(i));
				}	
			}
			txt = txt.trim();
			
		System.out.println(txt);
		return txt;
	}
	
	//récupère les n chiffres d'une string
		public static Object regex_num_req(String str, int digit_num_req) {
			String pat = "\\d{"+digit_num_req+"}";
			Pattern pattern = Pattern.compile(pat);
			Matcher matcher = pattern.matcher(str);
			
			String code = "";

		    	if(matcher.find()) { 
					  code = matcher.group();
					  System.out.println(code);
					    }
		    	else {
		    		System.err.println("Aucune occurence");
		    		}
		    
		    return code;
		}
		
	//compte nombre de caractère d'une string		
	public static int count_caractere(String s, char c){
		int count = 0;
		for (char a : s.toCharArray()){
		count = (a == c ? count + 1 : count);
		}
		System.out.println("Nombre de caractère(s) trouvé(s) : " +count);
		return count;
		} 
	
	public static String rewriteDigits(int number, int nbDigits){
	    String res = "";
	    res += number;
	    while(res.length() < nbDigits){
	       res = "0".concat(res);
	    }
	    return res;
	}
	
}
