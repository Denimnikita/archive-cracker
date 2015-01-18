package model;

public class DecodeTabelle{
	private char[][] decodeTab = null;
	
	public DecodeTabelle(){
		decodeTab = new char[17][17];
		decodeTab[0][0] = 'X';
		decodeTab[0][1] = '0';
		decodeTab[0][2] = '1';
		decodeTab[0][3] = '2';
		decodeTab[0][4] = '3';
		decodeTab[0][5] = '4';
		decodeTab[0][6] = '5';
		decodeTab[0][7] = '6';
		decodeTab[0][8] = '7';
		decodeTab[0][9] = '8';
		decodeTab[0][10] = '9';
		decodeTab[0][11] = 'A';
		decodeTab[0][12] = 'B';
		decodeTab[0][13] = 'C';
		decodeTab[0][14] = 'D';
		decodeTab[0][15] = 'E';
		decodeTab[0][16] = 'F';
		
		decodeTab[1][0] = '0';
		decodeTab[1][1] = ' ';
		decodeTab[1][2] = ' ';
		decodeTab[1][3] = ' ';
		decodeTab[1][4] = ' ';
		decodeTab[1][5] = ' ';
		decodeTab[1][6] = ' ';
		decodeTab[1][7] = ' ';
		decodeTab[1][8] = ' ';
		decodeTab[1][9] = ' ';
		decodeTab[1][10] = ' ';
		decodeTab[1][11] = ' ';
		decodeTab[1][12] = ' ';
		decodeTab[1][13] = ' ';
		decodeTab[1][14] = ' ';
		decodeTab[1][15] = ' ';
		decodeTab[1][16] = ' ';
		
		decodeTab[2][0] = '1';
		decodeTab[2][1] = ' ';
		decodeTab[2][2] = ' ';
		decodeTab[2][3] = ' ';
		decodeTab[2][4] = ' ';
		decodeTab[2][5] = ' ';
		decodeTab[2][6] = ' ';
		decodeTab[2][7] = ' ';
		decodeTab[2][8] = ' ';
		decodeTab[2][9] = ' ';
		decodeTab[2][10] = ' ';
		decodeTab[2][11] = ' ';
		decodeTab[2][12] = ' ';
		decodeTab[2][13] = ' ';
		decodeTab[2][14] = ' ';
		decodeTab[2][15] = ' ';
		decodeTab[2][16] = ' ';
		
		decodeTab[3][0] = '2';
		decodeTab[3][1] = ' ';
		decodeTab[3][2] = '!';
		decodeTab[3][3] = '"';
		decodeTab[3][4] = '#';
		decodeTab[3][5] = '$';
		decodeTab[3][6] = '%';
		decodeTab[3][7] = '&';
		decodeTab[3][8] = '\'';
		decodeTab[3][9] = '(';
		decodeTab[3][10] = ')';
		decodeTab[3][11] = '*';
		decodeTab[3][12] = '+';
		decodeTab[3][13] = ',';
		decodeTab[3][14] = '-';
		decodeTab[3][15] = '.';
		decodeTab[3][16] = '/';
		
		decodeTab[4][0] = '3';
		decodeTab[4][1] = '0';
		decodeTab[4][2] = '1';
		decodeTab[4][3] = '2';
		decodeTab[4][4] = '3';
		decodeTab[4][5] = '4';
		decodeTab[4][6] = '5';
		decodeTab[4][7] = '6';
		decodeTab[4][8] = '7';
		decodeTab[4][9] = '8';
		decodeTab[4][10] = '9';
		decodeTab[4][11] = ':';
		decodeTab[4][12] = ';';
		decodeTab[4][13] = '<';
		decodeTab[4][14] = '=';
		decodeTab[4][15] = '>';
		decodeTab[4][16] = '?';
		
		decodeTab[5][0] = '4';
		decodeTab[5][1] = '@';
		decodeTab[5][2] = 'A';
		decodeTab[5][3] = 'B';
		decodeTab[5][4] = 'C';
		decodeTab[5][5] = 'D';
		decodeTab[5][6] = 'E';
		decodeTab[5][7] = 'F';
		decodeTab[5][8] = 'G';
		decodeTab[5][9] = 'H';
		decodeTab[5][10] = 'I';
		decodeTab[5][11] = 'J';
		decodeTab[5][12] = 'K';
		decodeTab[5][13] = 'L';
		decodeTab[5][14] = 'M';
		decodeTab[5][15] = 'N';
		decodeTab[5][16] = 'O';
		
		decodeTab[6][0] = '5';
		decodeTab[6][1] = 'P';
		decodeTab[6][2] = 'Q';
		decodeTab[6][3] = 'R';
		decodeTab[6][4] = 'S';
		decodeTab[6][5] = 'T';
		decodeTab[6][6] = 'U';
		decodeTab[6][7] = 'V';
		decodeTab[6][8] = 'W';
		decodeTab[6][9] = 'X';
		decodeTab[6][10] = 'Y';
		decodeTab[6][11] = 'Z';
		decodeTab[6][12] = '[';
		decodeTab[6][13] = '\\';
		decodeTab[6][14] = ']';
		decodeTab[6][15] = '^';
		decodeTab[6][16] = '_';
		
		decodeTab[7][0] = '6';
		decodeTab[7][1] = '`';
		decodeTab[7][2] = 'a';
		decodeTab[7][3] = 'b';
		decodeTab[7][4] = 'c';
		decodeTab[7][5] = 'd';
		decodeTab[7][6] = 'e';
		decodeTab[7][7] = 'f';
		decodeTab[7][8] = 'g';
		decodeTab[7][9] = 'h';
		decodeTab[7][10] = 'i';
		decodeTab[7][11] = 'j';
		decodeTab[7][12] = 'k';
		decodeTab[7][13] = 'l';
		decodeTab[7][14] = 'm';
		decodeTab[7][15] = 'n';
		decodeTab[7][16] = 'o';
		
		decodeTab[8][0] = '7';
		decodeTab[8][1] = 'p';
		decodeTab[8][2] = 'q';
		decodeTab[8][3] = 'r';
		decodeTab[8][4] = 's';
		decodeTab[8][5] = 't';
		decodeTab[8][6] = 'u';
		decodeTab[8][7] = 'v';
		decodeTab[8][8] = 'w';
		decodeTab[8][9] = 'x';
		decodeTab[8][10] = 'y';
		decodeTab[8][11] = 'z';
		decodeTab[8][12] = '{';
		decodeTab[8][13] = '|';
		decodeTab[8][14] = '}';
		decodeTab[8][15] = '~';
		decodeTab[8][16] = ' ';
		
		decodeTab[9][0] = '8';
		decodeTab[9][1] = ' ';
		decodeTab[9][2] = ' ';
		decodeTab[9][3] = ' ';
		decodeTab[9][4] = ' ';
		decodeTab[9][5] = ' ';
		decodeTab[9][6] = ' ';
		decodeTab[9][7] = ' ';
		decodeTab[9][8] = ' ';
		decodeTab[9][9] = ' ';
		decodeTab[9][10] = ' ';
		decodeTab[9][11] = ' ';
		decodeTab[9][12] = ' ';
		decodeTab[9][13] = ' ';
		decodeTab[9][14] = ' ';
		decodeTab[9][15] = ' ';
		decodeTab[9][16] = ' ';
		
		decodeTab[10][0] = '9';
		decodeTab[10][1] = ' ';
		decodeTab[10][2] = ' ';
		decodeTab[10][3] = ' ';
		decodeTab[10][4] = ' ';
		decodeTab[10][5] = ' ';
		decodeTab[10][6] = ' ';
		decodeTab[10][7] = ' ';
		decodeTab[10][8] = ' ';
		decodeTab[10][9] = ' ';
		decodeTab[10][10] = ' ';
		decodeTab[10][11] = ' ';
		decodeTab[10][12] = ' ';
		decodeTab[10][13] = ' ';
		decodeTab[10][14] = ' ';
		decodeTab[10][15] = ' ';
		decodeTab[10][16] = ' ';
		
		decodeTab[11][0] = 'A';
		decodeTab[11][1] = ' ';
		decodeTab[11][2] = ' ';
		decodeTab[11][3] = ' ';
		decodeTab[11][4] = ' ';
		decodeTab[11][5] = ' ';
		decodeTab[11][6] = ' ';
		decodeTab[11][7] = ' ';
		decodeTab[11][8] = ' ';
		decodeTab[11][9] = ' ';
		decodeTab[11][10] = ' ';
		decodeTab[11][11] = ' ';
		decodeTab[11][12] = ' ';
		decodeTab[11][13] = ' ';
		decodeTab[11][14] = ' ';
		decodeTab[11][15] = ' ';
		decodeTab[11][16] = ' ';
		
		decodeTab[12][0] = 'B';
		decodeTab[12][1] = ' ';
		decodeTab[12][2] = ' ';
		decodeTab[12][3] = ' ';
		decodeTab[12][4] = ' ';
		decodeTab[12][5] = ' ';
		decodeTab[12][6] = ' ';
		decodeTab[12][7] = ' ';
		decodeTab[12][8] = ' ';
		decodeTab[12][9] = ' ';
		decodeTab[12][10] = ' ';
		decodeTab[12][11] = ' ';
		decodeTab[12][12] = ' ';
		decodeTab[12][13] = ' ';
		decodeTab[12][14] = ' ';
		decodeTab[12][15] = ' ';
		decodeTab[12][16] = ' ';
		
		decodeTab[13][0] = 'C';
		decodeTab[13][1] = ' ';
		decodeTab[13][2] = ' ';
		decodeTab[13][3] = ' ';
		decodeTab[13][4] = ' ';
		decodeTab[13][5] = ' ';
		decodeTab[13][6] = ' ';
		decodeTab[13][7] = ' ';
		decodeTab[13][8] = ' ';
		decodeTab[13][9] = ' ';
		decodeTab[13][10] = ' ';
		decodeTab[13][11] = ' ';
		decodeTab[13][12] = ' ';
		decodeTab[13][13] = ' ';
		decodeTab[13][14] = ' ';
		decodeTab[13][15] = ' ';
		decodeTab[13][16] = ' ';
		
		decodeTab[14][0] = 'D';
		decodeTab[14][1] = ' ';
		decodeTab[14][2] = ' ';
		decodeTab[14][3] = ' ';
		decodeTab[14][4] = ' ';
		decodeTab[14][5] = ' ';
		decodeTab[14][6] = ' ';
		decodeTab[14][7] = ' ';
		decodeTab[14][8] = ' ';
		decodeTab[14][9] = ' ';
		decodeTab[14][10] = ' ';
		decodeTab[14][11] = ' ';
		decodeTab[14][12] = ' ';
		decodeTab[14][13] = ' ';
		decodeTab[14][14] = ' ';
		decodeTab[14][15] = ' ';
		decodeTab[14][16] = ' ';
		
		decodeTab[15][0] = 'E';
		decodeTab[15][1] = ' ';
		decodeTab[15][2] = ' ';
		decodeTab[15][3] = ' ';
		decodeTab[15][4] = ' ';
		decodeTab[15][5] = ' ';
		decodeTab[15][6] = ' ';
		decodeTab[15][7] = ' ';
		decodeTab[15][8] = ' ';
		decodeTab[15][9] = ' ';
		decodeTab[15][10] = ' ';
		decodeTab[15][11] = ' ';
		decodeTab[15][12] = ' ';
		decodeTab[15][13] = ' ';
		decodeTab[15][14] = ' ';
		decodeTab[15][15] = ' ';
		decodeTab[15][16] = ' ';
		
		decodeTab[16][0] = 'F';
		decodeTab[16][1] = ' ';
		decodeTab[16][2] = ' ';
		decodeTab[16][3] = ' ';
		decodeTab[16][4] = ' ';
		decodeTab[16][5] = ' ';
		decodeTab[16][6] = ' ';
		decodeTab[16][7] = ' ';
		decodeTab[16][8] = ' ';
		decodeTab[16][9] = ' ';
		decodeTab[16][10] = ' ';
		decodeTab[16][11] = ' ';
		decodeTab[16][12] = ' ';
		decodeTab[16][13] = ' ';
		decodeTab[16][14] = ' ';
		decodeTab[16][15] = ' ';
		decodeTab[16][16] = ' ';
	}
	
	public char getValueAt(String strPosition){
		char[] chrPosition = strPosition.toCharArray();
		
		int getxwert = 0;
		int getywert = 0;
		
		for(int i = 0; i <= 16; i++){
			if(chrPosition[1] == decodeTab[i][0]){
				getywert = i;
			}
		}
		
		for(int i = 0; i <= 16; i++){
			if(chrPosition[2] == decodeTab[0][i]){
				getxwert = i;
			}
		}
		return decodeTab[getywert][getxwert];
	}
	
	public void printDecodeTab(){
		for(int i = 0; i <= 16; i++){
			for(int j = 0; j <= 16; j++){
				System.out.print(decodeTab[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
