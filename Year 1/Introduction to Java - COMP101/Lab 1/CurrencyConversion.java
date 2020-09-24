
public class CurrencyConversion {

    public static void main(String[] args) {
		double GBPEUR = 1.16771;
		double EURGBP = 0.85624;
		double Value = 5.67;
        System.out.println(String.valueOf(Value) + " GBP is " + String.valueOf(GBPEUR*Value) + "EUR" );
		System.out.println(String.valueOf(Value) + " EUR is " + String.valueOf(EURGBP*Value) + " GBP" );
		// Display the string.
    }
}
