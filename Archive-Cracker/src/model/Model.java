package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Observable;

import javax.swing.text.SimpleAttributeSet;

import statics.Statics;

public class Model extends Observable{
	private DecodeTabelle decTab;
	private ArrayList<String> debugtext;
	private ArrayList<SimpleAttributeSet> debugattribute;
	private String observeMessage;
	
	private String packerwahl;
	
	private String rarcrackpfad = "c:\\";
	private String szcrackpfad = "c:\\";
	
	private String gepackteDatei;
	
	private Einstellungen einstellungen;
	
	
	private int passwortmin;
	private int passwortmax;
	private String passworddef;
	private boolean benchmark;
	private boolean checkdef;
	private boolean disablegpu;
	private int gpudelay;
	
	
	
	public Model() throws InvalidPropertiesFormatException, FileNotFoundException, IOException{
		debugtext = new ArrayList<String>();
		debugattribute = new ArrayList<SimpleAttributeSet>();
		decTab = new DecodeTabelle();
		EinstellungenLaden();
		passwortmin = 1;
		passwortmax = 5;
		passworddef = "password.def";
		benchmark = false;
		checkdef = false;
		disablegpu = false;
		gpudelay = 2;
	}
	
	private void EinstellungenLaden() throws InvalidPropertiesFormatException, FileNotFoundException, IOException{
		einstellungen = Einstellungen.getInstance();
		rarcrackpfad = einstellungen.getValue("rarcrark");
		szcrackpfad = einstellungen.getValue("szcrark");
	}
	
	public void setGepackteDatei(String datei){
		gepackteDatei = datei;
		observeMessage = Statics.GEPACKTEDATEIPFAD;
		setChanged();
		notifyObservers(this);
	}
	public String getGepackteDatei(){
		return gepackteDatei;
	}
	
	public void AddDebugLine(String message, SimpleAttributeSet as){
		debugtext.add(message);
		debugattribute.add( as);
		observeMessage = Statics.DEBUG;
		setChanged();
		notifyObservers(this);
	}
	
	public String getObserveMessage(){
		return observeMessage;
	}
	
	public String getLastDebugMessage(){
		return debugtext.get(debugtext.size() - 1);
	}
	
	public SimpleAttributeSet getLastDebugAttribute(){
		return debugattribute.get(debugattribute.size() - 1);
	}
	
	public void SetPackerWahl(String packer){
		packerwahl = packer;
		AddDebugLine(packerwahl + " gewählt", Statics.GREEN);
	}
	
	public String GetPackerWahl(){
		return packerwahl;
	}


	public String getRarcrackpfad() {
		return rarcrackpfad;
	}


	public void setRarcrackpfad(String rarcrackpfad) {
		this.rarcrackpfad = rarcrackpfad;
		observeMessage = Statics.RARCRARKPFADSAVE;
		setChanged();
		notifyObservers(this);
	}


	public String getSZcrackpfad() {
		return szcrackpfad;
	}


	public void setSZcrackpfad(String szcrackpfad) {
		this.szcrackpfad = szcrackpfad;
		observeMessage = Statics.SZCRARKPFADSAVE;
		setChanged();
		notifyObservers(this);
	}

	public Einstellungen getEinstellungen() {
		return einstellungen;
	}

	public void setEinstellungen(Einstellungen einstellungen) {
		this.einstellungen = einstellungen;
	}

	public int getPasswortmin() {
		return passwortmin;
	}

	public void setPasswortmin(int passwortmin) {
		this.passwortmin = passwortmin;
		observeMessage = Statics.MINPWLAENGECHANGE;
		setChanged();
		notifyObservers(this);
	}

	public int getPasswortmax() {
		return passwortmax;
	}

	public void setPasswortmax(int passwortmax) {
		this.passwortmax = passwortmax;
		observeMessage = Statics.MAXPWLAENGECHANGE;
		setChanged();
		notifyObservers(this);
	}

	public String getPassworddef() {
		return passworddef;
	}

	public void setPassworddef(String passworddef) {
		this.passworddef = passworddef;
	}

	public boolean isBenchmark() {
		return benchmark;
	}

	public void setBenchmark(boolean benchmark) {
		this.benchmark = benchmark;
	}

	public boolean isCheckdef() {
		return checkdef;
	}

	public void setCheckdef(boolean checkdef) {
		this.checkdef = checkdef;
	}

	public boolean isDisablegpu() {
		return disablegpu;
	}

	public void setDisablegpu(boolean disablegpu) {
		this.disablegpu = disablegpu;
	}

	public int getGpudelay() {
		return gpudelay;
	}

	public void setGpudelay(int gpudelay) {
		this.gpudelay = gpudelay;
		observeMessage = Statics.DELAYSLIDERCHANGE;
		setChanged();
		notifyObservers(this);
	}

	public DecodeTabelle getDecTab() {
		return decTab;
	}

	public void setDecTab(DecodeTabelle decTab) {
		this.decTab = decTab;
	}
}
