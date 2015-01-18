package statics;

import java.awt.Color;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Statics {
	public final static String DEBUG = "debugging";
	public final static String RARPACKER = "RAR-Cracker";
	public final static String SZPACKER = "7Z-Cracker";
	public final static String OPTIONEN = "optionen";
	public final static String EXIT = "exit";
	
	public final static String RARCRARKPFAD = "rarcrarkpfad";
	public final static String RARCRARKPFADSAVE = "rarcrarkpfadsave"; 
	public final static String SZCRARKPFAD = "7zcrarkpfad";
	public final static String SZCRARKPFADSAVE = "7zcrarkpfadsave";
	public final static String OPTIONENEXIT = "optionenexit";
	public final static String OPTIONENSPEICHERN = "optionenspeichern";
	
	public final static String GEPACKTEDATEI = "gepacktedatei";
	public final static String GEPACKTEDATEIPFAD = "gepacktedateipfad";
	
	public final static String MINPWLAENGECHECK = "minpwlaengecheck";
	public final static String MINPWLAENGECHANGE = "minpwlaengechange";
	public final static String MINPWLAENGETFCHANGE = "minpwlaengetfchange";
	
	public final static String MAXPWLAENGECHECK = "maxpwlaengecheck";
	public final static String MAXPWLAENGECHANGE = "maxpwlaengechange";
	public final static String MAXPWLAENGETFCHANGE = "maxpwlaengetfchange";
	
	public final static String DEFINITIONSDATEI = "definitionsdatei";
	public final static String DEFINITIONSDATEIWAHL = "definitionsdateiwahl";
	
	public final static String BENCHMARKEN = "benchmarken";
	
	public final static String TESTEN = "testen";
	
	public final static String GPUDISABLE = "gpudisable";
	
	public final static String DELAYSLIDERCHECK = "delayslidercheck";
	public final static String DELAYSLIDERCHANGE = "delaysliderchange";
	public final static String DELAYSLIDERCHECKCHANGE = "delayslidercheckchange";
	
	public final static String FEUER = "feuer";
	
	public static SimpleAttributeSet DEFAULT = new SimpleAttributeSet();
	public static SimpleAttributeSet GREEN = new SimpleAttributeSet();
	public static SimpleAttributeSet RED = new SimpleAttributeSet();
	
	static{
		StyleConstants.setForeground(DEFAULT, Color.WHITE);
		StyleConstants.setFontFamily(DEFAULT, "Helvetica");
		StyleConstants.setFontSize(DEFAULT, 12);
		
		StyleConstants.setForeground(GREEN, Color.GREEN);
		StyleConstants.setFontFamily(GREEN, "Helvetica");
		StyleConstants.setFontSize(GREEN, 12);
		
		StyleConstants.setForeground(RED, Color.RED);
		StyleConstants.setFontFamily(RED, "Helvetica");
		StyleConstants.setFontSize(RED, 12);
	}
}
