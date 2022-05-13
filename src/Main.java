import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Hotel lakewood = new Hotel("Lakewood", 3, 110, 90, 80, 80);
		Hotel bridgewood = new Hotel("Bridgewood", 4, 160, 60, 110, 50);
		Hotel ridgewood = new Hotel("Ridgewood", 5, 220, 150, 100, 40);
		
		ArrayList<String> days = new ArrayList();
		
		Scanner read = new Scanner(System.in);
		System.out.println("Qual tipo de cliente voce eh? ");
		String type = read.next();
		
		System.out.println("Quantos dias voce deseja passar no hotel? (digite um valor inteiro)");
		int totalDays = read.nextInt();
		
		System.out.println("Quais serao os dias? ( digite uma data de acordo com o exemplo: 09May2022(mon) )");
		for(int i = 0; i<totalDays; i++) {
			String newDate = read.next();
			days.add(newDate);		
		}
		
		System.out.println(calcularMaisBarato(lakewood, bridgewood, ridgewood, days, type));

	}	
	
	public static String calcularMaisBarato(Hotel aa, Hotel bb, Hotel cc, ArrayList<String> days, String type) {
		double valora = aa.getFinalPrice(days, type);
		
		double valorb = bb.getFinalPrice(days, type);
		
		double valorc = cc.getFinalPrice(days, type);
		
		if (valora == valorb && valora < valorc) {
			if(aa.getClassification() < bb.getClassification()) {
				return bb.getName();
			}
			return aa.getName();
		}
		
		else if (valora == valorc && valora < valorb) {
			if(aa.getClassification() < cc.getClassification()) {
				return cc.getName();
			}
			return aa.getName();
		}
			
		else if (valorc == valorb && valorc < valora) {
			if(cc.getClassification() < bb.getClassification()) {
				return bb.getName();
			}
			return cc.getName();
		}
		
		else if (valorc == valorb && valorc == valora) {
			if(cc.getClassification() < bb.getClassification()) {
				if(aa.getClassification() < bb.getClassification()) {
					return bb.getName();
				}
				return aa.getName();
			}
			else if(cc.getClassification() < aa.getClassification()) {
				return aa.getName();
			}
			return cc.getName();
		}
			
		else if (valora < valorb && valora < valorc) {
			return aa.getName();
		}
		
		else if (valorc < valorb && valorc < valora) {
			return cc.getName();
		}
			
		else if (valorb < valora && valorb < valorc) {
			return bb.getName();
		}
		
		return null;
	}
}


