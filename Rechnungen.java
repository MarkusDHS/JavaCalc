package PraxisphaseCalcGradle;

public class Rechnungen {
	
	public static void main(String[] args) {
		Rechnungen re= new Rechnungen();
	}
	
	public Rechnungen() {
		;
	}
	
	public double calculate(double zahleins, double zahlzwei, String operation){
		switch (operation) {
		case "+":
			return zahleins+zahlzwei;
		case "-":
			return zahleins-zahlzwei;
		case "*":
			return zahleins*zahlzwei;
		case "/":
			return zahleins/zahlzwei;
		default:
			return 0;
		}
	}
}
