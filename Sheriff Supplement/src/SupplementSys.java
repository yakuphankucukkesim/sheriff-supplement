import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SupplementSys {
	private static HashSet<Supplement> sp=new HashSet<>();
	private static HashSet<Membership> ms=new HashSet<>();
	private static HashSet<Supplement> cart=new HashSet<>();
	private static boolean bonus;
	
	
	
	public static void addMembership(String username,String password)	
	{
		Membership mem=new Membership(username, password, 0);
		ms.add(mem);
	}
	public static boolean bonusOrNot(String username,String password)
	{
		int user=0;
		int pas=0;
		
		for(Membership me : ms)
		{
			if(username.equalsIgnoreCase(me.getUsername()))
			{
				if(password.equalsIgnoreCase(me.getPassword()))
				{
						if(me.getMonth()>3)
						{
							bonus= true;
						}
						pas++;
				}
				user++;
			}
		}
		bonus= false;
		if(user==0||pas==0)
			return false;
		else {
			return true;
		}
		
		
	}
	
	public static void readFromFileSup()
	{
		Scanner sc;
		
		
		try {
			sc=new Scanner(new File("Supplement.txt"));
			
			while(sc.hasNext())
			{
				String type=sc.next();
				String brand=sc.next();
				int size=sc.nextInt();
				boolean vegetarian=sc.nextBoolean();
				int totalserviceamount=sc.nextInt();
				double price=sc.nextDouble();
				if(type.equalsIgnoreCase("ProteinPowder"))
				{
					double proteintperserving=sc.nextDouble();
					double bcaaperserving=sc.nextDouble();
					String flavour=sc.next();
					ProteinPowder pp=new ProteinPowder(brand, size, type, vegetarian, totalserviceamount, price, proteintperserving, bcaaperserving, flavour);
					if(bonus)
						pp.bonusSize();
					pp.addShipmentPrice();
					sp.add(pp);
				}
				else if(type.equalsIgnoreCase("AminoAcid"))
				{
					int leucineperser=sc.nextInt();
					int isolosineperser=sc.nextInt();
					int valineperser=sc.nextInt();
					AminoAcid aa=new AminoAcid(brand, size, type, vegetarian, totalserviceamount, price, leucineperser, leucineperser, valineperser);					
					if(bonus)
						aa.bonusSize();
					aa.addShipmentPrice();
					sp.add(aa);
				}
				else if(type.equalsIgnoreCase("Carnitine"))
				{
					int caffeine=sc.nextInt();
					int lcarnitine=sc.nextInt();
					Carnitine car=new Carnitine(brand, size, type, vegetarian, totalserviceamount, price, caffeine, lcarnitine);
					if(bonus)
					car.bonusSize();
					car.addShipmentPrice();
					sp.add(car);
				}
				else if(type.equalsIgnoreCase("creatine"))
				{
					int monohydrate=sc.nextInt();
					
					Creatine crea=new Creatine(brand, size, type, vegetarian, totalserviceamount, price, monohydrate);
					if(bonus)
						crea.bonusSize();
					crea.addShipmentPrice();
					sp.add(crea);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String displayMember()
	{
		String str="";
		for(Supplement suf:cart)
		{
			str+=suf.toString();
		}
		return str;
	}
	public static void readfromfilemember()
	{
		Scanner sc;
		try {
			sc=new Scanner(new File("membership.txt"));
			
			while(sc.hasNext()) {
			String username=sc.next();
			String password=sc.next();
			int month=sc.nextInt();
			
			Membership mem=new Membership(username, password, month);
			ms.add(mem);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addtocart(Supplement supplement)
	{
		cart.add(supplement);
	}
	
	public static boolean removeFromCart(String brand,boolean vegetarian,boolean size,String type)
	{
		Supplement temp=null;
		for(Supplement sus:sp)
		{
			if(sus.getBrand().equalsIgnoreCase(brand)&& sus.vegetarian==vegetarian&&sus.getType().equalsIgnoreCase(type))
			{
		
			if(size)
			{
				if(sus.getSize()>600)
					temp=sus;
					
			}
			else
			{
				if(sus.getSize()<600)
					temp=sus;
			}
			}
			}
		
		if(cart.remove(temp))
			return true;
		else 
			return false;
	}
	public static Supplement SearchSupplement(String brand,boolean vegetarian,boolean size,String type)
	{
		
		for(Supplement sus:sp)
		{
			if(sus.getBrand().equalsIgnoreCase(brand)&& sus.vegetarian==vegetarian&&sus.getType().equalsIgnoreCase(type))
			{
		
			if(size)
			{
				if(sus.getSize()>600)
					return sus;
					
			}
			else
			{
				if(sus.getSize()<600)
					return sus;
			}
			}
			}
		return null;
	}
	public static HashSet<Supplement> getSupplement()
	{
		return sp;
	}
	public static String display()
	{
		String str="";
		for(Supplement sus:sp)
		{
			str+=sus.toString();
		}
		return str;
	}
	public static void calculatePricePerServing()
	{
		for(Supplement ss:sp)
		{
			ss.setPricePerServing(ss.getPrice()/ss.getTotalServiceAmount());
		}
	}
	public static double calculateTotalPrice()
	{
		double tot=0.0;
		for(Supplement sus:cart)
		{
			tot+=sus.getPrice();
		}
		return tot;
	}
}
