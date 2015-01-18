package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InvalidPropertiesFormatException;
import java.util.Observable;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import statics.Statics;
import view.DebugView;
import view.MainView;
import view.OptionenView;
import model.Model;

public class Controller extends Observable implements ActionListener{
	private static Controller instance = null;

	private Model model;
	private DebugView dv;
	private MainView mv;
	private OptionenView ov;

	public static Controller getInstance(){
		if (instance != null) return instance;
		return (instance = new Controller());
	}

	private Controller(){
		try {
			model = new Model();
		} catch (InvalidPropertiesFormatException e) {
			model.AddDebugLine(e.getMessage(), Statics.RED);
		} catch (FileNotFoundException e) {
			model.AddDebugLine(e.getMessage(), Statics.RED);
		} catch (IOException e) {
			model.AddDebugLine(e.getMessage(), Statics.RED);
		}
		dv = DebugView.getInstance();
		model.addObserver(dv);
		dv.setVisible(true);
		model.AddDebugLine("DEBUGGER instanziiert", Statics.DEFAULT);
		mv = MainView.getInstance(this);
		model.addObserver(mv);
		mv.setVisible(true);
		model.AddDebugLine("MainFenster instanziiert", Statics.DEFAULT);
		model.SetPackerWahl(Statics.RARPACKER);
		ov = OptionenView.getInstance(this);
		model.AddDebugLine("Optionen-Fenster instanziiert", Statics.DEFAULT);
		ov.getRartextfeld().setText(model.getRarcrackpfad());
		ov.getSZtextfeld().setText(model.getSZcrackpfad());
		model.addObserver(ov);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equalsIgnoreCase(Statics.EXIT)){
			System.exit(0);
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.RARPACKER)){
			mv.getRarRadio().setActionCommand(null);
			mv.getSZRadio().setActionCommand(Statics.SZPACKER);
			model.SetPackerWahl(Statics.RARPACKER);
			//model.AddDebugLine("RAR-Cracker gewählt", Statics.GREEN);
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.SZPACKER)){
			mv.getRarRadio().setActionCommand(Statics.RARPACKER);
			mv.getSZRadio().setActionCommand(null);
			model.SetPackerWahl(Statics.SZPACKER);
			//model.AddDebugLine("ZIP-Cracker gewählt", Statics.GREEN);
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.OPTIONEN)){
			ov.setVisible(true);
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.OPTIONENEXIT)){
			ov.setVisible(false);
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.RARCRARKPFAD)){
			JFileChooser jfc = new JFileChooser(model.getRarcrackpfad());
			int retval = jfc.showOpenDialog(null);
			if(retval == JFileChooser.APPROVE_OPTION){
				File file = jfc.getSelectedFile();
				model.setRarcrackpfad(file.getAbsolutePath());
			}
			
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.SZCRARKPFAD)){
			JFileChooser jfc = new JFileChooser(model.getRarcrackpfad());
			int retval = jfc.showOpenDialog(null);
			if(retval == JFileChooser.APPROVE_OPTION){
				File file = jfc.getSelectedFile();
				model.setSZcrackpfad(file.getAbsolutePath());
			}
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.OPTIONENSPEICHERN)){
			
			try {
				model.getEinstellungen().setValue("rarcrark", ov.getRartextfeld().getText());
				model.setRarcrackpfad(ov.getRartextfeld().getText());
				model.getEinstellungen().setValue("szcrark", ov.getSZtextfeld().getText());
				model.setSZcrackpfad(ov.getSZtextfeld().getText());
				model.getEinstellungen().Speichern();
				model.AddDebugLine("Cracker-Pfade gespeichert", Statics.GREEN);
				model.AddDebugLine("RAR-Cracker : " + ov.getRartextfeld().getText(), Statics.DEFAULT);
				model.AddDebugLine("7Z-Cracker : " + ov.getSZtextfeld().getText(), Statics.DEFAULT);
			} catch (FileNotFoundException e) {
				model.AddDebugLine(e.getMessage(), Statics.RED);
			} catch (InvalidPropertiesFormatException e) {
				model.AddDebugLine(e.getMessage(), Statics.RED);
			} catch (IOException e) {
				model.AddDebugLine(e.getMessage(), Statics.RED);
			}
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.GEPACKTEDATEI)){
			FileFilter ff = new FileNameExtensionFilter("Rar- oder 7Z-Archive", "rar", "7z");
			JFileChooser jfc = new JFileChooser();
			jfc.addChoosableFileFilter(ff);
			int retval = jfc.showOpenDialog(null);

			if(retval == JFileChooser.APPROVE_OPTION){
				File file = jfc.getSelectedFile();
				model.setGepackteDatei(file.getAbsolutePath());
				model.AddDebugLine(model.getGepackteDatei() + " wurde zum Cracken gewählt", Statics.DEFAULT);
			}
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.MINPWLAENGECHECK)){
			if(mv.getMinpwlaenge().isSelected()){
				mv.getMinpwlaengetf().setEnabled(true);
				mv.getMinpwlaengetfButton().setEnabled(true);
				mv.getMinpwlaengetf().setText(model.getPasswortmin() + "");
			}else{
				mv.getMinpwlaengetf().setEnabled(false);
				mv.getMinpwlaengetfButton().setEnabled(false);
				model.setPasswortmin(1);
				model.AddDebugLine("Passwordmin zu " + model.getPasswortmin() + " geändert", Statics.DEFAULT);
			}
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.MINPWLAENGETFCHANGE)){
			model.setPasswortmin(Integer.parseInt(mv.getMinpwlaengetf().getText()));
			model.AddDebugLine("PasswortMin zu " + model.getPasswortmin() + " geändert", Statics.DEFAULT);
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.MAXPWLAENGECHECK)){
			if(mv.getMaxpwlaenge().isSelected()){
				mv.getMaxpwlaengetf().setEnabled(true);
				mv.getMaxpwlaengetfButton().setEnabled(true);
				mv.getMaxpwlaengetf().setText(model.getPasswortmax() + "");
			}else{
				mv.getMaxpwlaengetf().setEnabled(false);
				mv.getMaxpwlaengetfButton().setEnabled(false);
				model.setPasswortmax(5);
				model.AddDebugLine("PasswordMax zu " + model.getPasswortmax() + " geändert", Statics.DEFAULT);
			}
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.MAXPWLAENGETFCHANGE)){
			model.setPasswortmax(Integer.parseInt(mv.getMaxpwlaengetf().getText()));
			model.AddDebugLine("PasswortMax zu " + model.getPasswortmax() + " geändert", Statics.DEFAULT);
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.DEFINITIONSDATEI)){
			if(mv.getPasswortDefinition().isSelected()){
				mv.getPasswortDefinitionButton().setEnabled(true);
			}else{
				model.setPassworddef("password.def");
				mv.getPasswortDefinitionButton().setEnabled(false);
				model.AddDebugLine("Def-Datei auf \"password.def\" festegelegt", Statics.DEFAULT);
			}
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.DEFINITIONSDATEIWAHL)){
			FileFilter ff = new FileNameExtensionFilter("Definitionen", "def");
			File temp = new File("temp.tmp");
			try {
				temp.createNewFile();
			} catch (IOException e) {
				model.AddDebugLine(e.getMessage(), Statics.RED);
			}
			JFileChooser jfc = new JFileChooser(temp.getAbsolutePath());
			jfc.addChoosableFileFilter(ff);
			int retval = jfc.showOpenDialog(null);

			if(retval == JFileChooser.APPROVE_OPTION){
				File file = jfc.getSelectedFile();
				model.setPassworddef(file.getAbsolutePath());
				model.AddDebugLine(model.getPassworddef() + " wurde als Definition gewählt", Statics.DEFAULT);
			}
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.BENCHMARKEN)){
			if(mv.getBenchmarken().isSelected()){
				model.setBenchmark(true);
				model.AddDebugLine("Benchmark aktiviert", Statics.DEFAULT);
			}else{
				model.setBenchmark(false);
				model.AddDebugLine("Benchmark deaktiviert", Statics.DEFAULT);
			}
		}
		
		if(ae.getActionCommand().equalsIgnoreCase(Statics.TESTEN)){
			if(mv.getTesten().isSelected()){
				model.setCheckdef(true);
				model.AddDebugLine("DefinitionsCheck aktiviert", Statics.DEFAULT);
			}else{
				model.setCheckdef(false);
				model.AddDebugLine("DefinitionsCheck deaktiviert", Statics.DEFAULT);
			}
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.GPUDISABLE)){
			if(mv.getGpudisable().isSelected()){
				model.setDisablegpu(true);
				model.AddDebugLine("GPU-Nutzung deaktiviert", Statics.RED);
				mv.getGpudelay().setEnabled(false);
				mv.getGpudelayslider().setEnabled(false);
				mv.getGpudelaysliderButton().setEnabled(false);
			}else{
				model.setDisablegpu(false);
				model.AddDebugLine("GPU-Nutzung aktiviert", Statics.GREEN);
				mv.getGpudelay().setEnabled(true);
				if(mv.getGpudelay().isSelected()){
					mv.getGpudelayslider().setEnabled(true);
					mv.getGpudelaysliderButton().setEnabled(true);
				}
			}
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.DELAYSLIDERCHECK)){
			if(mv.getGpudelay().isSelected()){
				mv.getGpudelayslider().setEnabled(true);
				mv.getGpudelaysliderButton().setEnabled(true);
				mv.getGpudelayslider().setValue(model.getGpudelay());
			}else{
				mv.getGpudelayslider().setEnabled(false);
				mv.getGpudelaysliderButton().setEnabled(false);
				model.setGpudelay(2);
				model.AddDebugLine("GPU-Delay auf " + model.getGpudelay() + " gesetzt", Statics.DEFAULT);
			}
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.DELAYSLIDERCHECKCHANGE)){
			model.setGpudelay(mv.getGpudelayslider().getValue());
			model.AddDebugLine("GPU-Delay auf " + model.getGpudelay() + " gesetzt", Statics.DEFAULT);
		}
		if(ae.getActionCommand().equalsIgnoreCase(Statics.FEUER)){
			String prog;
			ArrayList<String> argumente = new ArrayList<String>();
			if(mv.getRarRadio().isSelected()){
				argumente.add(model.getRarcrackpfad());
			}
			if(mv.getSZRadio().isSelected()){
				argumente.add(model.getSZcrackpfad());
			}
			if(model.getPassworddef() != null){
				argumente.add("-p" + model.getPassworddef());
			}
			if(model.getPasswortmin() > 0){
				if(model.getPasswortmin() <= model.getPasswortmax()){
					argumente.add("-l" + model.getPasswortmin());
				}
				else{
					JOptionPane.showMessageDialog(null, "PasswortMin kann nicht größer PasswortMax sein.");
				}
			}else{
				JOptionPane.showMessageDialog(null, "PasswortMin darf nicht < 1 sein.");
			}
			if(model.getPasswortmax() >= model.getPasswortmin()){
				argumente.add("-g" + model.getPasswortmax());
			}else{
				JOptionPane.showMessageDialog(null, "PasswortMax kann nicht kleiner PasswortMin sein.");
			}
			
			if(model.isBenchmark()){
				argumente.add("-b");
			}
			if(model.isCheckdef()){
				argumente.add("-v");
				argumente.add("-c");
			}
			if(model.isDisablegpu()){
				if(!model.isCheckdef()){
					argumente.add("-c");
				}
			}
			if(!model.isDisablegpu()){
				argumente.add("-d" + model.getGpudelay());
			}
			if(model.getGepackteDatei()!= null){
				argumente.add(model.getGepackteDatei());
			}
			
			model.AddDebugLine("gewähltes Programm :" + model.GetPackerWahl(), Statics.GREEN);
			model.AddDebugLine("ArgumentenListe : " + argumente, Statics.GREEN);
			//try {
				CrackerKlasse ck = null;
				if(mv.getRarRadio().isSelected()){
					System.out.println(model.getGepackteDatei());
					ck = new CrackerKlasse(model.getRarcrackpfad(), argumente, model);
					
				}else if(mv.getSZRadio().isSelected()){
					ArrayList<String> temp =  new ArrayList<String>();
					temp.add(model.getSZcrackpfad());
					ck = new CrackerKlasse(model.getSZcrackpfad(),temp, model);
				}
			//} catch (IOException e) {
			//	model.AddDebugLine(e.getMessage(), Statics.RED);
			//}
		}
	}
}
