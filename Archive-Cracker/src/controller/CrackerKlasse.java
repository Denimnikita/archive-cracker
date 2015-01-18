package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import statics.Statics;
import model.DecodeTabelle;
import model.Model;

public class CrackerKlasse extends Thread{
	
	private Process process;
	private Map <String, String> env;
	private Scanner scanner;
	private Model model;
	private ProcessBuilder pb;
	private String crackTool;
	private ArrayList<String> parameter;
	private String subtext;
	private String text;
	
	public CrackerKlasse(String prog, ArrayList<String> argumente, Model model){
		System.out.println("prog==>" + prog);
		this.model = model;
		this.crackTool = prog;
		this.parameter = argumente;
		this.start();
	}
	
	public void run(){
		System.out.println("Thread gestartet");
		
		pb = new ProcessBuilder(parameter);
		
		pb.redirectErrorStream(true);
		System.out.println("crackTool : " + crackTool);
		
		pb.directory(new File(new File(crackTool).getParent()));
		env = pb.environment();
		try{
		process = pb.start();
		}catch(Exception e){
			e.printStackTrace();
		}
		BufferedInputStream bis = new BufferedInputStream(process.getInputStream());
		scanner = new Scanner(bis);
		
		Scanner s = scanner.useDelimiter("\n");
		System.out.println("Scanner müsste laufen");
		while(s.hasNext()){
			text = s.next();
			model.AddDebugLine(text, Statics.DEFAULT);
			
			if(text.contains("In hex (PCL style):")){
				String sub = text.substring(20, text.length()-1);
				System.out.println(sub);
				String[] subarray = sub.split(" ");
				subtext = "";
				System.out.println(subarray.length);
				for(int i = 0; i < subarray.length; i++){
					DecodeTabelle dt = new DecodeTabelle();
					subtext += dt.getValueAt(subarray[i]);
				}
				new Thread(){
					public void run(){
						
						JOptionPane.showMessageDialog(null, "Das gesucht Passwort ist : " + subtext);
					}
				}.start();
				
			}
		}
	}
	
	public void setProcess(Process p){process = p;}
	public Process getProcess(){return process;}
	
	public void setEnv(Map <String, String> tempenv){env = tempenv;}
	public Map<String, String> getEnv(){return env;}
	
	public void setScanner(Scanner sc){scanner = sc;}
	public Scanner getScanner(){return scanner;}
}
