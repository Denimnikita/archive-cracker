package startbereich;

import controller.Controller;

public class Starter {
	Starter(){
		Controller.getInstance();
	}
	
	public static void main(String[] args) {
		new Starter();
	}
}
