import java.util.ArrayList;

public class Hotel {
	private String name;
	private int classification;
	private double priceWeekday;
	private double priceWeekend;
	private double priceWeekdayVIP;
	private double priceWeekendVIP;
	
	

	public Hotel(String name, int classification, double priceWeekday, double priceWeekend, double priceWeekdayVIP,
			double priceWeekendVIP) {
		this.name = name;
		this.classification = classification;
		this.priceWeekday = priceWeekday;
		this.priceWeekend = priceWeekend;
		this.priceWeekdayVIP = priceWeekdayVIP;
		this.priceWeekendVIP = priceWeekendVIP;
	}

	public String getName() {
		return name;
	}

	public int getClassification() {
		return classification;
	}

	public double getPriceWeekday() {
		return priceWeekday;
	}

	public double getPriceWeekend() {
		return priceWeekend;
	}

	public double getPriceWeekdayVIP() {
		return priceWeekdayVIP;
	}

	public double getPriceWeekendVIP() {
		return priceWeekendVIP;
	}
	
	public double getFinalPrice(ArrayList<String> days, String clientType) {
		double price = 0;
		
		if(clientType.equals("Regular")) {
			for(String a:days) {
				if(a.contains("sat") || a.contains("sun")){
					price += priceWeekend;
				}
				else if(a.contains("mon") || a.contains("tues") || a.contains("wed") || a.contains("thur") || a.contains("fri")){
					price += priceWeekday;
				}
				else {
					System.out.println("insira entradas válidas. ");
				}
			}
		}
		
		else if(clientType.equals("Rewards")) {
			for(String a:days) {
				if(a.contains("(sat)") || a.contains("sun")){
					price += priceWeekendVIP;
				}
				else if(a.contains("mon") || a.contains("tues") || a.contains("wed") || a.contains("thur") || a.contains("fri")){
					price += priceWeekdayVIP;
				}
				
				else {
					System.out.println("insira entradas válidas. ");
				}
			}
		}
		
		return price;
		
	}
}
