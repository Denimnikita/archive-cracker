package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class Einstellungen{

	private static Einstellungen instance = null;
	
	public static Einstellungen getInstance() throws InvalidPropertiesFormatException, FileNotFoundException, IOException{
		if(instance != null){return instance;}
		return (instance = new Einstellungen());
	}
	
	private String speicherung = "properties.xml"; 
	
	private Properties einstellungen;
	
	
	
	private Einstellungen() throws InvalidPropertiesFormatException, FileNotFoundException, IOException{
		einstellungen = new Properties();
		if(!new File(speicherung).exists()){
			new File(speicherung).createNewFile();
			PreLoad();
		}
		einstellungen.loadFromXML(new BufferedInputStream(new FileInputStream(speicherung)));
	}

	private void PreLoad() throws FileNotFoundException, IOException{
		einstellungen.setProperty("rarcrark", "c:\\");
		einstellungen.setProperty("szcrark", "c:\\");
		einstellungen.storeToXML(new BufferedOutputStream(new FileOutputStream(speicherung)), new Date() + "");
	}
	
	public void Speichern() throws FileNotFoundException, IOException{
		einstellungen.storeToXML(new BufferedOutputStream(new FileOutputStream(speicherung)), new Date() + "");
	}
	
	public String getSpeicherung() {
		return speicherung;
	}

	public void setSpeicherung(String speicherung) {
		this.speicherung = speicherung;
	}
	
	public void setValue(String key, String value){
		einstellungen.setProperty(key, value);
	}
	
	public String getValue(String key){
		return einstellungen.getProperty(key);
	}
}
