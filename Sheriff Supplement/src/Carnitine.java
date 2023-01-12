
public class Carnitine extends Supplement {
	private int caffeine;
	private int LCarnitine;
	public Carnitine(String brand, int size, String type, boolean vegetarian, int totalServiceAmount, double price,
			int caffeine, int lCarnitine) {
		super(brand, size, type, vegetarian, totalServiceAmount, price);
		this.caffeine = caffeine;
		LCarnitine = lCarnitine;
	}
	@Override
	public String toString() {
		return "\nCarnitine "+super.toString()+"\ncaffeine=" + caffeine + "\n LCarnitine=" + LCarnitine;
	}
	
	public void bonusSize()
	{
		Size*=1.15;
	}
	
	public void addShipmentPrice()
	{
		price+=15;
	}
}
