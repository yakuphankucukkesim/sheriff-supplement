
public class ProteinPowder extends Supplement{
	private double ProteinPerServing;
	private double BCAAPerServing;
	private String flavour;
	public ProteinPowder(String brand, int size, String type, boolean vegetarian, int totalServiceAmount, double price,
			double proteinPerServing, double bCAAPerServing, String flavour) {
		super(brand, size, type, vegetarian, totalServiceAmount, price);
		ProteinPerServing = proteinPerServing;
		BCAAPerServing = bCAAPerServing;
		this.flavour = flavour;
	}
	@Override
	public String toString() {
		return "\nProteinPowder"+super.toString()+ "\nProteinPerServing=" + ProteinPerServing + "\n BCAAPerServing=" + BCAAPerServing
				+ "\n flavour=" + flavour;
	}
	public void bonusSize()
	{
		Size*=1.1;
	}
	
	public void addShipmentPrice()
	{
		price+=30;
	}
	
	
}
