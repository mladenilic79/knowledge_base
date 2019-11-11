package mobilniOperaterBaseII;

import java.util.ArrayList;
import java.util.Scanner;

public class PrepaidTariff {

	public static ArrayList<PrepaidTariff> prepaidTariffs = new ArrayList<>();
	
	private String tariff;
	
	private MobileOperater mobileOperater;
	
	private int prepaidCredit;

	public PrepaidTariff() {
	}

	public PrepaidTariff(String tariff, MobileOperater mobileOperater, int prepaidCredit) {
		this.tariff = tariff;
		this.mobileOperater = mobileOperater;
		this.prepaidCredit = prepaidCredit;
	}

	public String getTariff() {
		return tariff;
	}

	public void setTariff(String tariff) {
		this.tariff = tariff;
	}

	public MobileOperater getMobileOperater() {
		return mobileOperater;
	}

	public void setMobileOperater(MobileOperater mobileOperater) {
		this.mobileOperater = mobileOperater;
	}

	public int getPrepaidCredit() {
		return prepaidCredit;
	}

	public void setPrepaidCredit(int prepaidCredit) {
		this.prepaidCredit = prepaidCredit;
	}

	@Override
	public String toString() {
		return "PrepaidTariff [tariff=" + tariff + ", mobileOperater=" + mobileOperater + ", prepaidCredit="
				+ prepaidCredit + "]";
	}
	
	// @@@@@@@@@@@@
	// logic
	
	// choose tariff
	public static PrepaidTariff matchPrepaidTariff(String matchName, MobileOperater mobileOperater) {
		PrepaidTariff tariff = null;
		for (int i=0; i<prepaidTariffs.size(); i++) {
			tariff = (PrepaidTariff)prepaidTariffs.get(i);
			if (tariff.getTariff().equals(matchName) && tariff.getMobileOperater()==mobileOperater) {
				break;
			}
		}
		return tariff;
	}
	
	// list for specific operater
	public static void listPrepaidTariffs(MobileOperater mobOp) {
		System.out.println("available prepaid tariffs for mobile operater " + mobOp.getName() + " are:");
		for (int i=0; i<prepaidTariffs.size(); i++) {
			PrepaidTariff tariff = (PrepaidTariff)prepaidTariffs.get(i);
			if (tariff.getMobileOperater().getName().equals(mobOp.getName())) {
				System.out.println(tariff.getTariff());
			}
		}
		System.out.println();
	}
	
	public static PrepaidTariff addPrepaidTariff(MobileOperater mobOp) {
		
		Scanner scannerString = new Scanner(System.in);
		Scanner scannerInt = new Scanner(System.in);
		
		System.out.println("enter name of new tariff");
		String name = scannerString.nextLine();		
		System.out.println("enter starting balance");
		int credit = scannerInt.nextInt();

		PrepaidTariff prepaidTariff = new PrepaidTariff(name, mobOp, credit);
		prepaidTariffs.add(prepaidTariff);
		
		Main.preTar = prepaidTariff;
		
		System.out.println(prepaidTariff.toString());
		System.out.println(prepaidTariffs.toString());
		System.out.println();
		
		return prepaidTariff;
	}
	
	public static PrepaidTariff loadPrepaidTariff(MobileOperater mobOp) {
		listPrepaidTariffs(mobOp);
		System.out.println("choose prepaid tariff");
		Scanner scannerString = new Scanner(System.in);
		String name = scannerString.nextLine();
		PrepaidTariff prepaidTariff = matchPrepaidTariff(name, mobOp);
		Main.preTar = prepaidTariff;
		System.out.println();
		return prepaidTariff;
	}
	
}
