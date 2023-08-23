package browser;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Navigateur {
	

   static DesiredCapabilities caps;
   static WebDriver driver;
   
   
   public static WebDriver choixBrowser(String browserName) {

      switch (browserName) {
      case "chrome":
      caps = new DesiredCapabilities();
      System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32\\chromedriver.exe");

      HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
      ChromeOptions options = new ChromeOptions();
      options.merge(caps);
      options.addArguments("--start-maximized");
      options.addArguments("--disable-popup-blocking");
      options.addArguments("--remote-allow-origins=*");
      options.addArguments("Zoom 67%");
//      chromePrefs.get("C:\\Users\\isaoudi\\Desktop\\Testing doc et outils\\passant_avec_alerte");


      driver = new ChromeDriver(options);
      System.out.println("Initialisation réussie");
      System. out. println( "Navigateur.java driver :" + driver);

      break;
      

  case "firefox":
      System.setProperty("webdriver.gecko.driver", "C:\\drivers\\firefox_win64\\geckodriver.exe");
      
//      FirefoxOptions capabilities = DesiredCapabilities.firefox();
//     capabilities.setCapability("marionette", true);
//      driver = new FirefoxDriver(capabilities);          
      
      driver = new FirefoxDriver();

      driver.manage().window().maximize();
      System.out.println("Initialisation réussie");
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
      break;

  default:
      System.err.println("DRIVER ISSUE");
                      break;
                  }
      
      
               return driver;              
                

   }

}
