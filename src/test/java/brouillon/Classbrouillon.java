package brouillon;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.nio.file.Path;

import javax.swing.JFileChooser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Classbrouillon {
	WebDriver driver;

	public static void main(String[] args) {
			
		Frame f = new Frame();
		FileDialog fd = new FileDialog(f, "Choose a file", FileDialog.LOAD);
		fd.setDirectory("C:\\Users\\isaoudi\\Desktop\\Testing doc et outils\\passant_avec_alerte");
		fd.setFile("Exemple.pdf");
		fd.setVisible(false);
		String filename = fd.getFile();
		if (filename == null)
		 System.out.println("You cancelled the choice");
		else
		 System.out.println("You chose " + filename);		
	    
		
	}}

