package git_uzdevums1;

import java.util.Scanner;

public class uzdevums1 {

	public static void main(String[] args) {
		Scanner dati = new Scanner(System.in);
		int[]atzime;
		int[]procenti;
		int daudzums;
		
		System.out.print("Cik skolēnus vēlies ievadīt?: ");
		daudzums = dati.nextInt();
		String[] skoleni = new String[daudzums];
		String[] kriteriji = new String[daudzums];
		
		for(int i=0;i<skoleni.length;i++){
			System.out.print("Ievadi skolēnu vārdus: ");
			skoleni[i] = dati.next();
		}
		
		for(int i=0;i<daudzums;i++){
			System.out.print("Ievadi vērtēšanas kritērijus: ");
			 kriteriji[i] = dati.next();
		}
		int skaititajs= 0;
		for(int i=0;i<daudzums;i++){
			System.out.print("Ievadi % svarīgumu kritērijam "+kriteriji[skaititajs]+": \n");
			skaititajs++;
		}
		
		
		dati.close();
	}

}
