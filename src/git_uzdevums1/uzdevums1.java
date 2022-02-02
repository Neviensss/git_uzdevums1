package git_uzdevums1;

import java.text.DecimalFormat;
import java.util.Scanner;


public class uzdevums1 {
	public static int studSk, kritSk;
	public static int[] kriterijaSvars = new int[kritSk];
	public static int[][] kriterijaVertejums = new int[studSk][kritSk];
	public static double[] semestraVertejums = new double[studSk];
	public static String[] kriteriji;
	public static String[] studenti;
	public static DecimalFormat df = new DecimalFormat("0.#");
	
	public static void ievaditSkolenusKrit(){
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Cik studentiem aprēķināsi gala vērtējumu?");
			studSk = scan.nextInt();
		}while(studSk<1);
		studenti = new String[studSk];
		
		for(int i=0; i<studenti.length; i++) {
			System.out.println("Ievadi "+(i+1)+". studentu");
			studenti[i] = scan.next();
		}
		do {
			System.out.println("Kāds būs kritēriju skaits?");
			kritSk = scan.nextInt();
		}while(kritSk<1);
		kriteriji = new String[kritSk];
		
		int maxSvars = 100;
		for(int i=0; i<kriteriji.length; i++) {
			System.out.println("Ievadi "+(i+1)+". kritēriju");
			kriteriji[i] = scan.next();
			//Norāda katra kritērija svaru
			do {
				System.out.println("Ievadi "+(i+1)+". kritērija svaru");
				kriterijaSvars[i] = scan.nextInt();
			}while(kriterijaSvars[i]>maxSvars || 
					kriterijaSvars[i]<1 || 
					(kriterijaSvars[0]==100 && kritSk > 1));
			maxSvars -= kriterijaSvars[i];
		}
		scan.close();
	}
	
	public static void ievaditVertejumu(){
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<kriterijaVertejums.length; i++) {
			for(int j=0; j<kriterijaVertejums[i].length; j++) {
				do {
					System.out.println("Ievadi "+studenti[i]+" vērtējumu par kritēriju "+kriteriji[j]);
					kriterijaVertejums[i][j] = scan.nextInt();
				}while(kriterijaVertejums[i][j]<0 || kriterijaVertejums[i][j]>10);
			}
		}
		scan.close();
	}
	
	public static void izvaditRez(){
		double rezultats;
		for(int i=0; i<studenti.length; i++) {
			rezultats=0;
			for(int j=0; j<kriteriji.length; j++) {
				rezultats += ((double) kriterijaSvars[j]/100)*kriterijaVertejums[i][j];
			}
			semestraVertejums[i] = rezultats;
		}
		
		for(int i=0; i<studenti.length; i++) {	
			for(int j=0; j<kriteriji.length; j++) {
				System.out.println("Studenta "+studenti[i]+" vērtējums par kritēriju "+kriteriji[j]+" ir "+kriterijaVertejums[i][j]+", kura svars ir "+kriterijaSvars[j]);
			}
			System.out.println("Semestra vērtējums ir "+df.format(semestraVertejums[i])+"\n");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int izvele;
		do{
			System.out.println("1-Ievadit Stundetus | 2. Ievadit kriterijus| 3. Ievadit vertejumu| 4. Izvadit datus. |5. Apturet");
			izvele=scan.nextInt();
			switch(izvele){
			case 1: 
				ievaditSkolenusKrit();
				break;
			case 3:
				ievaditVertejumu();
				break;
			case 4:
				izvaditRez();
				break;
				case 5:
					System.out.println("Programma apturēta!");
					break;
				default:
					System.out.println("Darbība nepastāv!");
			}
		}while(izvele!=5);
		scan.close();
	}
}

