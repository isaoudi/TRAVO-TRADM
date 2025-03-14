package brouillon;

import org.openqa.selenium.WebDriver;

import authentification.Auth_ADM;
import browser.Navigateur;
import fonctions.MyKeyWord;
import microfonctions.mesFonctions;

public class Test {
	static WebDriver driver;
	static String browsername;
	static String id;
	static String mdp;

	public static void main(String[] args) throws Throwable {
		browsername = "chrome";
		id = "chaNC4d";
		mdp = "ConseilEtat123456*";
		
		driver = Navigateur.choixBrowser(browsername);
		Auth_ADM.authentification_user_ADM(driver, id, mdp);

	}

}
