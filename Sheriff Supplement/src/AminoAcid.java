
public class AminoAcid extends Supplement {

	
		private int leucinePerSer;
		private int isolocinePerSer;
		private int ValinePerSer;
		public AminoAcid(String brand, int size, String type, boolean vegetarian, int totalServiceAmount, double price,
				int leucinePerSer, int isolocinePerSer, int valinePerSer) {
			super(brand, size, type, vegetarian, totalServiceAmount, price);
			this.leucinePerSer = leucinePerSer;
			this.isolocinePerSer = isolocinePerSer;
			ValinePerSer = valinePerSer;
			
		}
		@Override
		public String toString() {
			return "\nAminoAcid "+super.toString()+"\nleucinePerSer=" + leucinePerSer + "\n isolocinePerSer=" + isolocinePerSer
					+ "\n ValinePerSer=" + ValinePerSer;

		}
		public void bonusSize()
		{
			Size*=1.05;
		}
		public void addShipmentPrice()
		{
			price+=20;
		}
		
}
