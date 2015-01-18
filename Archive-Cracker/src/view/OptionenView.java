package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;
import controller.Controller;
import statics.Statics;

public class OptionenView extends JDialog implements Observer{

	/****/private static final long serialVersionUID = 1L;
	private static OptionenView instance = null;
	
	public static OptionenView getInstance(Controller al){
		if(instance != null) return instance;
		return (instance = new OptionenView(al));
	}

	private JPanel arbeitsflaeche;
	private JPanel pln1;
	private JPanel plo1;
	private JPanel pls1;
	private JPanel plw1;
	
	private JPanel buttonsRechtsPanel;
	
	private JButton rarbutton;
	private JButton szbutton;
	private JPanel plo2;
	private JPanel plo3;
	private JButton exit;
	
	private JPanel buttonsLinksPanel;
	private JPanel plw2;
	private JPanel plw3;
	private JPanel plw4;
	private JPanel plw5;
	private JButton speichern;
	
	private JPanel textfelderPanel;
	private JTextField rartextfeld;
	private JTextField sztextfeld;
	private JPanel plc1;
	private JPanel plc2;
	private JPanel plc3;
	
	private OptionenView(ActionListener al){
		this.setTitle("Optionen");
		this.setUndecorated(true);
		this.setPreferredSize(new Dimension(600, 150));
		this.setSize(new Dimension(600, 180));
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		arbeitsflaeche = new JPanel();
		arbeitsflaeche.setBackground(Color.BLACK);
		arbeitsflaeche.setBorder(BorderFactory.createDashedBorder(Color.RED));
		
		arbeitsflaeche.setLayout(new BorderLayout());
		
		buttonsLinksPanel = new JPanel();
		buttonsLinksPanel.setBackground(Color.BLACK);
		buttonsLinksPanel.setBorder(BorderFactory.createDashedBorder(Color.RED));
		buttonsLinksPanel.setLayout(new GridLayout(5,1));
		
		plw2 = new JPanel();
		plw3 = new JPanel();
		plw4 = new JPanel();
		plw5 = new JPanel();
		speichern = new JButton("Speichern");
		
		plw2.setBackground(Color.BLACK);
		plw3.setBackground(Color.BLACK);
		plw4.setBackground(Color.BLACK);
		plw5.setBackground(Color.BLACK);
		speichern.setPreferredSize(new Dimension(116,30));
		speichern.setBackground(Color.BLACK);
		speichern.setForeground(Color.RED);
		speichern.setBorder(BorderFactory.createEtchedBorder());
		speichern.addActionListener(al);
		speichern.setActionCommand(Statics.OPTIONENSPEICHERN);
		
		
		buttonsLinksPanel.add(plw2);
		buttonsLinksPanel.add(plw3);
		buttonsLinksPanel.add(plw4);
		buttonsLinksPanel.add(plw5);
		buttonsLinksPanel.add(speichern);
		
		arbeitsflaeche.add(buttonsLinksPanel, BorderLayout.WEST);
		
		textfelderPanel = new JPanel();
		textfelderPanel.setLayout(new GridLayout(5,1));
		textfelderPanel.setBackground(Color.BLACK);
		rartextfeld = new JTextField();
		rartextfeld.setBackground(Color.BLACK);
		rartextfeld.setForeground(Color.RED);
		rartextfeld.setBorder(BorderFactory.createEtchedBorder());
		sztextfeld = new JTextField();
		sztextfeld.setBackground(Color.BLACK);
		sztextfeld.setForeground(Color.RED);
		sztextfeld.setBorder(BorderFactory.createEtchedBorder());
		plc1 = new JPanel();
		plc1.setBackground(Color.BLACK);
		plc2 = new JPanel();
		plc2.setBackground(Color.BLACK);
		plc3 = new JPanel();
		plc3.setBackground(Color.BLACK);
		textfelderPanel.add(rartextfeld);
		textfelderPanel.add(sztextfeld);
		textfelderPanel.add(plc1);
		textfelderPanel.add(plc2);
		textfelderPanel.add(plc3);
		
		arbeitsflaeche.add(textfelderPanel, BorderLayout.CENTER);
		
		buttonsRechtsPanel = new JPanel();
		buttonsRechtsPanel.setBackground(Color.BLACK);
		buttonsRechtsPanel.setBorder(BorderFactory.createDashedBorder(Color.RED));
		buttonsRechtsPanel.setLayout(new GridLayout(5, 1));
		
		rarbutton = new JButton("CRARK");
		rarbutton.setPreferredSize(new Dimension(116,30));
		rarbutton.setBackground(Color.BLACK);
		rarbutton.setForeground(Color.RED);
		rarbutton.setBorder(BorderFactory.createEtchedBorder());
		rarbutton.addActionListener(al);
		rarbutton.setActionCommand(Statics.RARCRARKPFAD);
		
		szbutton = new JButton("CRARK-7z");
		szbutton.setPreferredSize(new Dimension(116,30));
		szbutton.setBackground(Color.BLACK);
		szbutton.setForeground(Color.RED);
		szbutton.setBorder(BorderFactory.createEtchedBorder());
		szbutton.addActionListener(al);
		szbutton.setActionCommand(Statics.SZCRARKPFAD);
		
		plo2 = new JPanel();
		plo2.setBackground(Color.BLACK);
		plo3 = new JPanel();
		plo3.setBackground(Color.BLACK);
		
		exit = new JButton("Abbruch");
		exit.setPreferredSize(new Dimension(116,30));
		exit.setBackground(Color.BLACK);
		exit.setForeground(Color.RED);
		exit.setPreferredSize(new Dimension(116, 30));
		exit.setBorder(BorderFactory.createEtchedBorder());
		exit.addActionListener(al);
		exit.setActionCommand(Statics.OPTIONENEXIT);
		
		
		buttonsRechtsPanel.add(rarbutton);
		buttonsRechtsPanel.add(szbutton);
		buttonsRechtsPanel.add(plo2);
		buttonsRechtsPanel.add(plo3);
		buttonsRechtsPanel.add(exit);
		
		
		arbeitsflaeche.add(buttonsRechtsPanel, BorderLayout.EAST);
		
		this.add(arbeitsflaeche, BorderLayout.CENTER);
		
		pln1 = new JPanel();
		plo1 = new JPanel();
		pls1 = new JPanel();
		plw1 = new JPanel();
		
		pln1.setBackground(Color.BLACK);
		plo1.setBackground(Color.BLACK);
		pls1.setBackground(Color.BLACK);
		plw1.setBackground(Color.BLACK);
		
		this.add(pln1, BorderLayout.NORTH);
		this.add(plo1, BorderLayout.EAST);
		this.add(pls1, BorderLayout.SOUTH);
		this.add(plw1, BorderLayout.WEST);
		
		this.setModal(true);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if(((Model)arg1).getObserveMessage().equalsIgnoreCase(Statics.RARCRARKPFADSAVE)){
			rartextfeld.setText(((Model)arg1).getRarcrackpfad());
		}
		if(((Model)arg1).getObserveMessage().equalsIgnoreCase(Statics.SZCRARKPFADSAVE)){
			sztextfeld.setText(((Model)arg1).getSZcrackpfad());
		}
	}

	public JTextField getRartextfeld() {
		return rartextfeld;
	}

	public void setRartextfeld(JTextField rartextfeld) {
		this.rartextfeld = rartextfeld;
	}

	public JTextField getSZtextfeld() {
		return sztextfeld;
	}

	public void setSZtextfeld(JTextField sztextfeld) {
		this.sztextfeld = sztextfeld;
	}
}
