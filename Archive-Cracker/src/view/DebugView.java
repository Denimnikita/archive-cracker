package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.plaf.metal.MetalScrollBarUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;

import model.Model;
import statics.Statics;

public class DebugView extends JFrame implements Observer{

	/****/private static final long serialVersionUID = 1L;
	private static DebugView instance = null;

	private int messageLineCounter = 0;

	private JPanel arbeitsflaeche;
	private JPanel pln1;
	private JPanel plo1;
	private JPanel pls1;
	private JPanel plw1;

	private JTextPane textbereich;
	private JScrollPane jsp;

	public static DebugView getInstance(){
		if(instance != null) return instance;
		return (instance = new DebugView());
	}

	private DebugView(){
		this.setTitle("Debugger");
		this.setPreferredSize(new Dimension(600, 400));
		this.setSize(new Dimension(600, 400));
		this.setLocation(new Point((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 610, 10));
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());

		arbeitsflaeche = new JPanel();
		arbeitsflaeche.setBackground(Color.BLACK);
		arbeitsflaeche.setBorder(BorderFactory.createDashedBorder(Color.RED));
		arbeitsflaeche.setLayout(new GridLayout(1, 1));

		jsp = new JScrollPane();

		textbereich = new JTextPane();
		textbereich.setBackground(Color.BLACK);
		textbereich.setForeground(Color.WHITE);
		textbereich.setEditable(false);
		textbereich.setBorder(BorderFactory.createEtchedBorder());

		jsp.setViewportView(textbereich);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		setScrollBars(jsp);

		arbeitsflaeche.add(jsp);

		pln1 = new JPanel();
		pln1.setBackground(Color.BLACK);
		plo1 = new JPanel();
		plo1.setBackground(Color.BLACK);
		pls1 = new JPanel();
		pls1.setBackground(Color.BLACK);
		plw1 = new JPanel();
		plw1.setBackground(Color.BLACK);
		this.add(arbeitsflaeche, BorderLayout.CENTER);
		this.add(pln1, BorderLayout.NORTH);
		this.add(plo1, BorderLayout.EAST);
		this.add(pls1, BorderLayout.SOUTH);
		this.add(plw1, BorderLayout.WEST);
	}

	public void appendText(String message, SimpleAttributeSet sas){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			messageLineCounter++;
			String strMessageLineCounter = "";
			if(messageLineCounter < 10){
				strMessageLineCounter += "00" + messageLineCounter;
			}else if(messageLineCounter > 9 && messageLineCounter < 100){
				strMessageLineCounter += "0" + messageLineCounter;
			}

			textbereich.getDocument().insertString(textbereich.getDocument().getLength(), strMessageLineCounter + ")\t" +  sdf.format(new Date()) + "\t" + message + "\n", sas);
			textbereich.setCaretPosition(textbereich.getDocument().getLength());
		} catch (BadLocationException e) {
			appendText(e.getMessage(), Statics.RED);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if(((Model) arg).getObserveMessage().equals(Statics.DEBUG)){
			appendText(((Model)arg).getLastDebugMessage(), ((Model) arg).getLastDebugAttribute());
		}
	}



	private void setScrollBars(JScrollPane pane) {
		setScrollBar(pane, JScrollBar.VERTICAL);
		setScrollBar(pane, JScrollBar.HORIZONTAL);
	}
	private void setScrollBar(JScrollPane pane, int adjustmend) {
		JScrollBar bar = new JScrollBar(adjustmend);
		bar.setUI(new MyScrollBarUI());
		if(adjustmend == JScrollBar.VERTICAL) {
			pane.setVerticalScrollBar(bar);
		} else if(adjustmend == JScrollBar.HORIZONTAL) {
			pane.setHorizontalScrollBar(bar);
		} else {
			//IllegalArgumentException
		}
	}

	private class MyScrollBarUI extends MetalScrollBarUI {
		protected void paintThumb(final Graphics g, final JComponent c, final Rectangle thumbBounds) {
			if(thumbBounds.isEmpty() || !scrollbar.isEnabled())	{
				return;
			}

			int w = thumbBounds.width;
			int h = thumbBounds.height;

			g.translate(thumbBounds.x, thumbBounds.y);

			g.setColor(Color.BLACK);
			g.drawRect(0, 0, w-1, h-1);
			g.setColor(Color.RED);
			g.fillRect(0, 0, w-1, h-1);

			//g.setColor(new Color(184, 207, 229));
			g.setColor(Color.BLACK);
			g.drawLine(1, 1, 1, h-2);
			g.drawLine(2, 1, w-3, 1);

			g.setColor(Color.BLACK);
			g.drawLine(2, h-2, w-2, h-2);
			g.drawLine(w-2, 1, w-2, h-3);

			g.translate(0 - thumbBounds.x, 0 - thumbBounds.y);
		}
	}

}
