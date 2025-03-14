package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import capturetool.My_SreenShot;
import fonctions.MyKeyWord;

public class Navigateur {
	

   static DesiredCapabilities caps;
   static WebDriver driver;
   
   
   public static WebDriver choixBrowser(String browserName) throws Throwable {

      switch (browserName) {
      case "chrome":
    	  try {
      caps = new DesiredCapabilities();
      System.setProperty("webdriver.chrome.driver", "C:\\APPLIS\\drivers\\chromedriver-win64\\chromedriver.exe");

      ChromeOptions options = new ChromeOptions();
	   options.merge(caps);
//	   options.addArguments("--headless");
	   options.addArguments("--start-maximized");
	   options.addArguments("--disable-popup-blocking");
	   options.addArguments("--remote-allow-origins=*");
	   options.addArguments("--incognito");//navigation privée
	   options.addArguments("--disable-search-engine-choice-screen");
//     options.addArguments("Zoom 67%");
	   System.out.println(options);
	   
	   driver = new ChromeDriver(options);
	   System.out.println("Initialisation réussie....."+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
	   
	   System.out.println("Début Testcase......"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
      } catch (Exception e) {
	My_SreenShot.screenshot();
	e.printStackTrace();
}

      break;
      

  case "firefox":
      System.setProperty("webdriver.gecko.driver", "C:\\drivers\\firefox_win64\\geckodriver.exe");
      
//      FirefoxOptions capabilities = DesiredCapabilities.firefox();
//     capabilities.setCapability("marionette", true);
//      driver = new FirefoxDriver(capabilities);          
      
      driver = new FirefoxDriver();

      driver.manage().window().maximize();
      System.out.println("Initialisation réussie");
      System. out. println( "Navigateur.java driver :" + driver);
      
      System.out.println("Début Testcase......"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
      
      break;
                  
  case "edge":
      caps = new DesiredCapabilities();
      System.setProperty("webdriver.edge.driver",  "C:\\drivers\\edgechromium_win64\\msedgedriver.exe");

     
      EdgeOptions option = new EdgeOptions();;
      option.merge(caps);
      option.addArguments("--start-maximized");
      option.addArguments("--disable-popup-blocking");


      driver = new EdgeDriver (option);
      
      System.out.println("Initialisation réussie");
      System. out. println( "Navigateur.java driver :" + driver);
      
      System.out.println("Début Testcase......"+MyKeyWord.extractCurrentDate()+" à "+MyKeyWord.extractCurrentHeure()+"\r");
      break;

  default:
      System.err.println("DRIVER ISSUE");
                      break;
                  }
      
      
               return driver;              
                

   }

}
