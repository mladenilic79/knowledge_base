package mobilniOperaterBaseII;

import java.util.ArrayList;
import java.util.Scanner;

public class MobileOperater {
	
	public static ArrayList<MobileOperater> mobileOperaters = new ArrayList<>();
	
	public static ArrayList<String> log = new ArrayList<>();
	
	private ArrayList<TariffAddon> addons = new ArrayList<>();
	private String name;
	private int minPrice;
	private int messagePrice;
	private int mbPrice;
	
	public MobileOperater() {
	}

	public MobileOperater(ArrayList<TariffAddon> addons, String name, int minPrice, int messagePrice, int mbPrice) {
		this.addons = addons;
		this.name = name;
		this.minPrice = minPrice;
		this.messagePrice = messagePrice;
		this.mbPrice = mbPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(int minPrice) {
		this.minPrice = minPrice;
	}

	public int getMessagePrice() {
		return messagePrice;
	}

	public void setMessagePrice(int messagePrice) {
		this.messagePrice = messagePrice;
	}

	public int getMbPrice() {
		return mbPrice;
	}

	public void setMbPrice(int mbPrice) {
		this.mbPrice = mbPrice;
	}

	public ArrayList<TariffAddon> getTariffAddons() {
		return addons;
	}

	public void setDodaci(ArrayList<TariffAddon> dodaci) {
		this.addons = dodaci;
	}

	// addons in toString makes stackOverflow (loop) error
	@Override
	public String toString() {
		return "MobileOperater [name=" + name + ", minPrice=" + minPrice + ", messagePrice="
				+ messagePrice + ", mbPrice=" + mbPrice + "]";
	}
	
	// @@@@@@@@@@@@@@
	// logic
	
	public static void listMobileOperaters() {
		System.out.println("available mobile operaters are:");
		for (int i=0; i<mobileOperaters.size(); i++) {
			MobileOperater mobileOperater = (MobileOperater)mobileOperaters.get(i);
			System.out.println(mobileOperater.getName());
		}
		System.out.println();
	}
	
	// choose mobile operater
	public static MobileOperater matchMobileOperater(String matchName) {
		MobileOperater mobileOperater = null;
		for (int i=0; i<MobileOperater.mobileOperaters.size(); i++) {
			mobileOperater = (MobileOperater)MobileOperater.mobileOperaters.get(i);
			if (mobileOperater.getName().equals(matchName)) {
				break;
			}
		}
		return mobileOperater;
	}
	
	public static MobileOperater addMobileOperater() {
		
		Scanner scannerString = new Scanner(System.in);
		Scanner scannerInt = new Scanner(System.in);
		
		System.out.println("enter mobile operater");
		String name = scannerString.nextLine();		
		System.out.println("enter minut price");
		int minut = scannerInt.nextInt();
		System.out.println("enter message price");
		int poruka = scannerInt.nextInt();
		System.out.println("enter mb price");
		int mb = scannerInt.nextInt();
		
		ArrayList<TariffAddon> addons = new ArrayList<>();
		
		MobileOperater mobileOperater = new MobileOperater(addons, name, minut, poruka, mb);
		mobileOperaters.add(mobileOperater);
		Main.mobOp = mobileOperater;
		
		System.out.println(mobileOperater.toString());
		System.out.println(mobileOperaters.toString());
		System.out.println();
		
		return mobileOperater;

	}
	
	public static MobileOperater loadMobileOperater() {
		MobileOperater.listMobileOperaters();
		System.out.println("enter mobile operater name");
		Scanner scannerString = new Scanner(System.in);
		String name = scannerString.nextLine();
		MobileOperater mobileOperater = MobileOperater.matchMobileOperater(name);
		Main.mobOp = mobileOperater;
		System.out.println();
		return mobileOperater;
	}
	
	public static void listLog() {
		System.out.println("log:");
		for(String string : MobileOperater.log) {
			System.out.println(string);
		}
		System.out.println();
	}
	
	public static void generatePostpaidBill(User user) {
		int fixedPriceOfTariffPackage = user.getPostpaidTariff().calculateTariffPrice();
		int totalAddons = user.getBalance();
		int total = fixedPriceOfTariffPackage + totalAddons;
		System.out.println("postpaid bill of every user " + user.getName());
		System.out.println("items: fixed price of tariff is " + fixedPriceOfTariffPackage 
				+ ", total overdraft and addons is " + totalAddons);
		System.out.println("total: " + total);
		System.out.println();
	}
	
	public static void generatePostpaidBillPrivate(UserPostpaidPrivate user) {
		int fixedPackagePrice = user.getPostpaidTariff().calculateTariffPrice();
		int totalAddons = user.getBalance();
		int total = fixedPackagePrice + totalAddons;
		System.out.println("postpaid private bill " + user.getName());
		System.out.println("items: fixed price of tariff is " + fixedPackagePrice 
				+ ", total overdraft and addons is " + totalAddons);
		System.out.println("total: " + total);
		System.out.println();
	}
	
	// ovaj vraca vrednost
	public static int generatePostpaidBillShort(User user) {
		int fixedPackagePrice = user.getPostpaidTariff().calculateTariffPrice();
		int totalAddons = user.getBalance();
		int total = fixedPackagePrice + totalAddons;
		return total;
	}
	
	// for operater
	public static void employesByCompanies(MobileOperater mobOp) {
		for (Company company : Company.companies) {
			if (company.getMobilniOperater().equals(mobOp)) {
				System.out.println("company " + company.getName());
				int num = 0;
				for (UserPostpaidBusiness user : UserPostpaidBusiness.postpaidUsersBusiness) {
					if (user.getCompany().equals(company)) {
						System.out.println("    user " + user.getName());
						num++;
					}
				}
				System.out.println("total employes in company " + num);
				System.out.println();
			}
		}
	}
	
	public static void companyBill(Company company) {
		System.out.println("bill for company " + company.getName());
		int numberOfEmployes = 0;
		int totalBill = 0;
		for (UserPostpaidBusiness user : UserPostpaidBusiness.postpaidUsersBusiness) {
			if (user.getCompany().equals(company)) {
				int singleBill = generatePostpaidBillShort(user);
				System.out.println("    user " + user.getName() + ", bill balance " + singleBill);
				numberOfEmployes++;
				totalBill = totalBill + singleBill;
			}
		}
		System.out.println("total employes " + numberOfEmployes + ", total invoice " + totalBill);
		System.out.println();
	}
	
	public static void allBills(MobileOperater mobOp) {
		System.out.println("<<all bills>>");
		System.out.println();
		for (UserPostpaidPrivate user : UserPostpaidPrivate.postpaidUsersPrivate) {
			generatePostpaidBillPrivate(user);
		} for (Company company : Company.companies) {
			companyBill(company);
		}
		System.out.println();
	}
}
