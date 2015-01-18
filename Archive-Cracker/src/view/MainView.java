package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import controller.Controller;
import model.Model;
import statics.Statics;

public class MainView extends JFrame implements Observer{

	/****/private static final long serialVersionUID = 1L;

	private static MainView instance = null;
	
	public static MainView getInstance(Controller al){
		if(instance != null) return instance;
		return (instance = new MainView(al));
	}
	
	private JPanel arbeitsflaeche;
	private JPanel pln1;
	private JPanel plo1;
	private JPanel pls1;
	private JPanel plw1;
	private ButtonGroup packergruppe;
	private JPanel packerauswahlPanel;
	private JPanel packer1;
	private JRadioButton packerRadio1;
	private JPanel packer2;
	private JRadioButton packerRadio2;
	private JPanel packer3;
	private JPanel packer4;
	private JPanel packer5;
	
	private JButton optionen;
	private JButton exit;
	
	private JPanel arbeitsflaecheMitte;
	
	private JPanel arbeitsflaecheMitteLinks;
	
	private JPanel minpwlaengePanel;
	private JCheckBox minpwlaenge;
	private JPanel minpwlaengetfPanel;
	private JTextField minpwlaengetf;
	private JButton minpwlaengetfButton;
	private JPanel maxpwlaengePanel;
	private JCheckBox maxpwlaenge;
	private JPanel maxpwlaengetfPanel;
	private JTextField maxpwlaengetf;
	private JButton maxpwlaengetfButton;
	private JCheckBox passwortdefinition;
	private JButton passwortdefinitionButton;
	private JCheckBox benchmarken;
	private JPanel plw2;
	private JCheckBox testen;
	private JLabel testeninfo;
	private JCheckBox gpudisable;
	private JLabel gpudisableinfo;
	private JCheckBox gpudelay;
	private JPanel gpudelaysliderPanel;
	private JSlider gpudelayslider;
	private JButton gpudelaysliderButton;
	private JPanel pls2;
	private JPanel pls3;
	private JPanel pls4;
	private JPanel pls5;
	
	private JPanel arbeitsflaecheMitteUnten;
	private JLabel extractLabel;
	private JTextField extractTF;
	private JButton extractButton;
	
	private JPanel arbeitsflaecheMitteMitte;
	private JButton crackstart;
	
	private MainView(ActionListener al){
		this.setTitle("Brute Forcer für Rar- und Zip-Archive");
		this.setUndecorated(true);
		this.setPreferredSize(new Dimension(600, 400));
		this.setSize(new Dimension(600, 400));
		this.setLocation(new Point(10, 10));
		this.setLayout(new BorderLayout());
		
		arbeitsflaeche = new JPanel();
		arbeitsflaeche.setBackground(Color.BLACK);
		arbeitsflaeche.setBorder(BorderFactory.createDashedBorder(Color.RED));
		arbeitsflaeche.setLayout(new BorderLayout());
		
		packerauswahlPanel = new JPanel();
		packerauswahlPanel.setLayout(new GridLayout(1, 5));
		packerauswahlPanel.setBackground(Color.BLACK);
		
		
		packer1 = new JPanel();
		packer1.setBackground(Color.BLACK);

		packerRadio1 = new JRadioButton("RAR-Cracker");
		packerRadio1.setBackground(Color.BLACK);
		packerRadio1.setForeground(Color.RED);
		packerRadio1.setPreferredSize(new Dimension(116, 30));
		packerRadio1.setBorder(BorderFactory.createEtchedBorder());
		packerRadio1.setSelected(true);
		packerRadio1.addActionListener(al);
		packerRadio1.setActionCommand(Statics.RARPACKER);
		packer1.add(packerRadio1);
		packerauswahlPanel.add(packer1);
		
		
		packer2 = new JPanel();
		packer2.setBackground(Color.BLACK);

		packerRadio2 = new JRadioButton("7Z-Cracker");
		packerRadio2.setBackground(Color.BLACK);
		packerRadio2.setForeground(Color.RED);
		packerRadio2.setPreferredSize(new Dimension(116, 30));
		packerRadio2.setBorder(BorderFactory.createEtchedBorder());
		packerRadio2.addActionListener(al);
		packerRadio2.setActionCommand(Statics.SZPACKER);
		packer2.add(packerRadio2);
		packerauswahlPanel.add(packer2);
		
		packergruppe = new ButtonGroup();
		packergruppe.add(packerRadio1);
		packergruppe.add(packerRadio2);
		
		packer3 = new JPanel();
		packer3.setBackground(Color.BLACK);

		packerauswahlPanel.add(packer3);
		packer4 = new JPanel();
		packer4.setBackground(Color.BLACK);
		
		optionen = new JButton("Optionen");
		optionen.setBackground(Color.BLACK);
		optionen.setForeground(Color.RED);
		optionen.setPreferredSize(new Dimension(116, 30));
		optionen.setBorder(BorderFactory.createEtchedBorder());
		optionen.addActionListener(al);
		optionen.setActionCommand(Statics.OPTIONEN);
		packer4.add(optionen);
		packerauswahlPanel.add(packer4);
		
		packer5 = new JPanel();
		packer5.setBackground(Color.BLACK);
		
		exit = new JButton("Exit");
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.RED);
		exit.setPreferredSize(new Dimension(116, 30));
		exit.setBorder(BorderFactory.createEtchedBorder());
		exit.addActionListener(al);
		exit.setActionCommand(Statics.EXIT);
		packer5.add(exit);
		packerauswahlPanel.add(packer5);
		
		
		arbeitsflaeche.add(packerauswahlPanel, BorderLayout.NORTH);
		
		arbeitsflaecheMitte = new JPanel();
		arbeitsflaecheMitte.setBackground(Color.BLACK);
		
		arbeitsflaecheMitte.setLayout(new BorderLayout());
		
		arbeitsflaecheMitteLinks = new JPanel();
		arbeitsflaecheMitteLinks.setLayout(new GridLayout(7,2));
		arbeitsflaecheMitteLinks.setBackground(Color.BLACK);
		arbeitsflaecheMitteLinks.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createDashedBorder(Color.RED), 
				"Optionen", 
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, 
				null, 
				Color.RED));
		minpwlaengePanel = new JPanel();
		minpwlaengePanel.setLayout(new BorderLayout());
		minpwlaenge = new JCheckBox("<html><body>Passwort (min)<br>(1-127 Default:1)</body></html>");
		minpwlaenge.setBackground(Color.BLACK);
		minpwlaenge.setForeground(Color.RED);
		minpwlaenge.addActionListener(al);
		minpwlaenge.setActionCommand(Statics.MINPWLAENGECHECK);
		minpwlaengetfPanel = new JPanel();
		minpwlaengetfPanel.setLayout(new BorderLayout());
		minpwlaengetf = new JTextField("1");
		minpwlaengetf.setHorizontalAlignment(JTextField.CENTER);
		minpwlaengetf.setPreferredSize(new Dimension(40,25));
		minpwlaengetf.setBackground(Color.BLACK);
		minpwlaengetf.setForeground(Color.RED);
		minpwlaengetf.setBorder(BorderFactory.createDashedBorder(Color.RED));
		minpwlaengetf.setEnabled(false);
		Icon hacken = new ImageIcon("hacken.png");
		minpwlaengetfButton = new JButton(hacken);
		minpwlaengetfButton.setBackground(Color.BLACK);
		minpwlaengetfButton.setForeground(Color.RED);
		minpwlaengetfButton.setBorder(BorderFactory.createEtchedBorder());
		minpwlaengetfButton.addActionListener(al);
		minpwlaengetfButton.setActionCommand(Statics.MINPWLAENGETFCHANGE);
		minpwlaengetfButton.setEnabled(false);
		minpwlaengetfPanel.add(minpwlaengetf, BorderLayout.CENTER);
		minpwlaengetfPanel.add(minpwlaengetfButton, BorderLayout.EAST);
		minpwlaengePanel.add(minpwlaenge, BorderLayout.CENTER);
		minpwlaengePanel.add(minpwlaengetfPanel, BorderLayout.EAST);
		
		maxpwlaengePanel = new JPanel();
		maxpwlaengePanel.setLayout(new BorderLayout());
		maxpwlaenge = new JCheckBox("<html><body>Passwort (max)<br>(1-127 Default:5)</body></html>");
		maxpwlaenge.setBackground(Color.BLACK);
		maxpwlaenge.setForeground(Color.RED);
		maxpwlaenge.addActionListener(al);
		maxpwlaenge.setActionCommand(Statics.MAXPWLAENGECHECK);
		maxpwlaengetfPanel = new JPanel();
		maxpwlaengetfPanel.setLayout(new BorderLayout());
		maxpwlaengetf = new JTextField("5");
		maxpwlaengetf.setHorizontalAlignment(JTextField.CENTER);
		maxpwlaengetf.setPreferredSize(new Dimension(40,25));
		maxpwlaengetf.setBackground(Color.BLACK);
		maxpwlaengetf.setForeground(Color.RED);
		maxpwlaengetf.setBorder(BorderFactory.createDashedBorder(Color.RED));
		maxpwlaengetf.setEnabled(false);
		maxpwlaengetfButton = new JButton(hacken);
		maxpwlaengetfButton.setBackground(Color.BLACK);
		maxpwlaengetfButton.setForeground(Color.RED);
		maxpwlaengetfButton.setBorder(BorderFactory.createEtchedBorder());
		maxpwlaengetfButton.addActionListener(al);
		maxpwlaengetfButton.setActionCommand(Statics.MAXPWLAENGETFCHANGE);
		maxpwlaengetfButton.setEnabled(false);
		maxpwlaengetfPanel.add(maxpwlaengetf, BorderLayout.CENTER);
		maxpwlaengetfPanel.add(maxpwlaengetfButton, BorderLayout.EAST);
		maxpwlaengePanel.add(maxpwlaenge, BorderLayout.CENTER);
		maxpwlaengePanel.add(maxpwlaengetfPanel, BorderLayout.EAST);
		
		passwortdefinition = new JCheckBox("<html><body>Def-Datei<br>(Default:password.def)</body></html>");
		passwortdefinition.setBackground(Color.BLACK);
		passwortdefinition.setForeground(Color.RED);
		passwortdefinition.addActionListener(al);
		passwortdefinition.setActionCommand(Statics.DEFINITIONSDATEI);
		passwortdefinitionButton = new JButton("wählen");
		passwortdefinitionButton.setBackground(Color.BLACK);
		passwortdefinitionButton.setForeground(Color.RED);
		passwortdefinitionButton.setBorder(BorderFactory.createEtchedBorder());
		passwortdefinitionButton.addActionListener(al);
		passwortdefinitionButton.setActionCommand(Statics.DEFINITIONSDATEIWAHL);
		passwortdefinitionButton.setEnabled(false);
		benchmarken = new JCheckBox("Benchmark");
		benchmarken.setBackground(Color.BLACK);
		benchmarken.setForeground(Color.RED);
		benchmarken.addActionListener(al);
		benchmarken.setActionCommand(Statics.BENCHMARKEN);
		plw2 = new JPanel();
		plw2.setBackground(Color.BLACK);
		testen = new JCheckBox("<html><body>Def-Tester<br>(kein Crack)</body></html>");
		testen.setBackground(Color.BLACK);
		testen.setForeground(Color.RED);
		testen.addActionListener(al);
		testen.setActionCommand(Statics.TESTEN);
		testeninfo = new JLabel("");
		testeninfo.setBackground(Color.BLACK);
		gpudisable = new JCheckBox("<html><body>GPU deaktivieren<br>(nur CPU-Crack)");
		gpudisable.setBackground(Color.BLACK);
		gpudisable.setForeground(Color.RED);
		gpudisable.addActionListener(al);
		gpudisable.setActionCommand(Statics.GPUDISABLE);
		gpudisableinfo = new JLabel("");
		gpudisableinfo.setBackground(Color.BLACK);
		gpudelay = new JCheckBox("<html><body>GPU-Verzögerung<br>(0-5 Default:2)</body></html>");
		gpudelay.setBackground(Color.BLACK);
		gpudelay.setForeground(Color.RED);
		gpudelay.addActionListener(al);
		gpudelay.setActionCommand(Statics.DELAYSLIDERCHECK);
		gpudelaysliderPanel = new JPanel();
		gpudelaysliderPanel.setLayout(new BorderLayout());
		gpudelayslider = new JSlider();
		gpudelayslider.setBackground(Color.BLACK);
		gpudelayslider.setForeground(Color.RED);
		gpudelayslider.setMinimum(0);
		gpudelayslider.setMaximum(5);
		gpudelayslider.setValue(2);
		gpudelayslider.setFont(new Font("ARIAL", Font.ITALIC, 10));
		gpudelayslider.setMajorTickSpacing(1);
		gpudelayslider.setMinorTickSpacing(1);
		gpudelayslider.createStandardLabels(1);
		gpudelayslider.setPaintTicks(true);
		gpudelayslider.setPaintLabels(true);
		int temphoehe = gpudelayslider.getSize().height;
		gpudelayslider.setSize(new Dimension(80, temphoehe));
		gpudelaysliderButton = new JButton(hacken);
		gpudelaysliderButton.setBackground(Color.BLACK);
		gpudelaysliderButton.setForeground(Color.RED);
		gpudelaysliderButton.setBorder(BorderFactory.createEtchedBorder());
		gpudelaysliderButton.addActionListener(al);
		gpudelaysliderButton.setActionCommand(Statics.DELAYSLIDERCHECKCHANGE);
		gpudelaysliderButton.setEnabled(false);
		gpudelaysliderPanel.add(gpudelayslider, BorderLayout.CENTER);
		gpudelaysliderPanel.add(gpudelaysliderButton, BorderLayout.EAST);
		
		pls2 = new JPanel();
		pls2.setBackground(Color.BLACK);
		pls3 = new JPanel();
		pls3.setBackground(Color.BLACK);
		pls4 = new JPanel();
		pls4.setBackground(Color.BLACK);
		pls5 = new JPanel();
		pls5.setBackground(Color.BLACK);
		
		arbeitsflaecheMitteLinks.add(minpwlaengePanel);
		arbeitsflaecheMitteLinks.add(maxpwlaengePanel);
		arbeitsflaecheMitteLinks.add(passwortdefinition);
		arbeitsflaecheMitteLinks.add(passwortdefinitionButton);
		arbeitsflaecheMitteLinks.add(benchmarken);
		arbeitsflaecheMitteLinks.add(plw2);
		arbeitsflaecheMitteLinks.add(testen);
		arbeitsflaecheMitteLinks.add(testeninfo);
		arbeitsflaecheMitteLinks.add(gpudisable);
		arbeitsflaecheMitteLinks.add(gpudisableinfo);
		arbeitsflaecheMitteLinks.add(gpudelay);
		arbeitsflaecheMitteLinks.add(gpudelaysliderPanel);
		arbeitsflaecheMitteLinks.add(pls2);
		arbeitsflaecheMitteLinks.add(pls3);
		
		arbeitsflaecheMitte.add(arbeitsflaecheMitteLinks, BorderLayout.WEST);
		
		arbeitsflaecheMitteUnten = new JPanel();
		arbeitsflaecheMitteUnten.setLayout(new BorderLayout());
		arbeitsflaecheMitteUnten.setBackground(Color.BLACK);
		arbeitsflaecheMitteUnten.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createDashedBorder(Color.RED), 
				"Zieldatei", 
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, 
				null, 
				Color.RED));
		
		extractLabel = new JLabel("Zu crackende Datei auswählen : ");
		extractLabel.setBackground(Color.BLACK);
		extractLabel.setForeground(Color.RED);
		extractLabel.setBorder(BorderFactory.createEtchedBorder());
		
		
		extractTF = new JTextField();
		extractTF.setBackground(Color.BLACK);
		extractTF.setForeground(Color.RED);
		extractTF.setBorder(BorderFactory.createEtchedBorder());
		extractTF.setHorizontalAlignment(JTextField.CENTER);
		
		extractButton = new JButton("auswählen");
		extractButton.setBackground(Color.BLACK);
		extractButton.setForeground(Color.RED);
		extractButton.setPreferredSize(new Dimension(116,30));
		extractButton.setBorder(BorderFactory.createEtchedBorder());
		extractButton.addActionListener(al);
		extractButton.setActionCommand(Statics.GEPACKTEDATEI);
		
		arbeitsflaecheMitteUnten.add(extractLabel, BorderLayout.WEST);
		arbeitsflaecheMitteUnten.add(extractTF, BorderLayout.CENTER);
		arbeitsflaecheMitteUnten.add(extractButton, BorderLayout.EAST);
		
		arbeitsflaecheMitte.add(arbeitsflaecheMitteUnten, BorderLayout.SOUTH);
		
		arbeitsflaeche.add(arbeitsflaecheMitte, BorderLayout.CENTER);
		
		arbeitsflaecheMitteMitte = new JPanel();
		arbeitsflaecheMitteMitte.setBackground(Color.BLACK);
		arbeitsflaecheMitteMitte.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createDashedBorder(Color.RED), 
				"Cracken starten", 
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, 
				null, 
				Color.RED));
		arbeitsflaecheMitteMitte.setLayout(new GridLayout(1,1));
		
		crackstart = new JButton("Cracken");
		crackstart.setBackground(Color.BLACK);
		crackstart.setForeground(Color.RED);
		crackstart.setBorder(BorderFactory.createEtchedBorder());
		crackstart.addActionListener(al);
		crackstart.setActionCommand(Statics.FEUER);
		
		arbeitsflaecheMitteMitte.add(crackstart);
		
		
		arbeitsflaecheMitte.add(arbeitsflaecheMitteMitte, BorderLayout.CENTER);
		
		
		this.add(arbeitsflaeche, BorderLayout.CENTER);
		
		pln1 = new JPanel();
		pln1.setBackground(Color.BLACK);
		this.add(pln1, BorderLayout.NORTH);
		plo1 = new JPanel();
		plo1.setBackground(Color.BLACK);
		this.add(plo1, BorderLayout.EAST);
		pls1 = new JPanel();
		pls1.setBackground(Color.BLACK);
		this.add(pls1, BorderLayout.SOUTH);
		plw1 = new JPanel();
		plw1.setBackground(Color.BLACK);
		this.add(plw1, BorderLayout.WEST);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(((Model)arg).getObserveMessage().equals(Statics.GEPACKTEDATEIPFAD)){
			extractTF.setText(((Model)arg).getGepackteDatei());
		}
		if(((Model)arg).getObserveMessage().equals(Statics.MINPWLAENGECHANGE)){
			minpwlaengetf.setText(((Model)arg).getPasswortmin() + "");
		}
		if(((Model)arg).getObserveMessage().equals(Statics.MAXPWLAENGECHANGE)){
			maxpwlaengetf.setText(((Model)arg).getPasswortmax() + "");
		}
		if(((Model)arg).getObserveMessage().equals(Statics.DELAYSLIDERCHANGE)){
			gpudelayslider.setValue(((Model)arg).getGpudelay());
		}
	}

	public JRadioButton getRarRadio(){return packerRadio1;}
	public JRadioButton getSZRadio(){return packerRadio2;}

	public JCheckBox getMinpwlaenge() {return minpwlaenge;}
	public JTextField getMinpwlaengetf() {return minpwlaengetf;}
	public JButton getMinpwlaengetfButton() {return minpwlaengetfButton;}

	
	public JCheckBox getMaxpwlaenge() {return maxpwlaenge;}
	public JTextField getMaxpwlaengetf() {return maxpwlaengetf;}
	public JButton getMaxpwlaengetfButton() {return maxpwlaengetfButton;}

	public JCheckBox getGpudelay() {return gpudelay;}
	public JSlider getGpudelayslider() {return gpudelayslider;}
	public JButton getGpudelaysliderButton() {return gpudelaysliderButton;}

	public JCheckBox getGpudisable() {return gpudisable;}

	public JCheckBox getTesten() {return testen;}

	public JCheckBox getBenchmarken() {return benchmarken;}
	
	public JCheckBox getPasswortDefinition(){return passwortdefinition;}
	public JButton getPasswortDefinitionButton(){return passwortdefinitionButton;}
}
