
public class Creatine extends Supplement{
private int monohydrate;

public Creatine(String brand, int size, String type, boolean vegetarian, int totalServiceAmount, double price,
		int monohydrate) {
	super(brand, size, type, vegetarian, totalServiceAmount, price);
	this.monohydrate = monohydrate;
}

@Override
public String toString() {
	return "\nCreatine "+super.toString()+"\nmonohydrate=" + monohydrate;
}

public void bonusSize()
{
	Size*=1.20;
}
public void addShipmentPrice()
{
price+=20;	
}


}
