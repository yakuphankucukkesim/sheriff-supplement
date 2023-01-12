
public abstract class Supplement {
		protected String Brand;
		protected int Size;
		protected String type;
		protected boolean vegetarian;
		protected double PricePerServing;
		protected int TotalServiceAmount;
		protected double price;
		private static int count=0;
		
		public Supplement(String brand, int size, String type, boolean vegetarian, int totalServiceAmount,
				double price) {
			super();
			Brand = brand;
			Size = size;
			this.type = type;
			this.vegetarian = vegetarian;
			TotalServiceAmount = totalServiceAmount;
			this.price = price;
			this.count++;
		}
		@Override
		public String toString() {
			return "\nSupplement \nBrand=" + Brand + "\n Size=" + Size + "\n type=" + type + "\n vegetarian=" + vegetarian
					+ "\n PricePerServing=" + PricePerServing + "\n TotalServiceAmount=" + TotalServiceAmount + "\n price="
					+ price;
		}
		public String getBrand() {
			return Brand;
		}
		public void setBrand(String brand) {
			Brand = brand;
		}
		public int getSize() {
			return Size;
		}
		public void setSize(int size) {
			Size = size;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public boolean isVegetarian() {
			return vegetarian;
		}
		public void setVegetarian(boolean vegetarian) {
			this.vegetarian = vegetarian;
		}
		public double getPricePerServing() {
			return PricePerServing;
		}
		public void setPricePerServing(double pricePerServing) {
			PricePerServing = pricePerServing;
		}
		public int getTotalServiceAmount() {
			return TotalServiceAmount;
		}
		public void setTotalServiceAmount(int totalServiceAmount) {
			TotalServiceAmount = totalServiceAmount;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public static int getCount() {
			return count;
		}
		public static void setCount(int count) {
			Supplement.count = count;
		};
		public abstract void bonusSize();
		
}
