package mobilniOperaterBaseII;

import java.util.ArrayList;
import java.util.Scanner;

public class PostpaidTariff {

	public static ArrayList<PostpaidTariff> postpaidTariffs = new ArrayList<>();
	
	String tariff;
	
	MobileOperater mobileOperater;
	
	boolean business;
	
	int minutes;
	
	int messages;
	
	int mb;

	public PostpaidTariff() {
	}

	public PostpaidTariff(String tariff, MobileOperater mobileOperater, boolean business, int minutes, int messages,
			int mb) {
		super();
		this.tariff = tariff;
		this.mobileOperater = mobileOperater;
		this.business = business;
		this.minutes = minutes;
		this.messages = messages;
		this.mb = mb;
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

	public boolean isBusiness() {
		return business;
	}

	public void setBusiness(boolean business) {
		this.business = business;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getMessage() {
		return messages;
	}

	public void setMessage(int message) {
		this.messages = message;
	}

	public int getMb() {
		return mb;
	}

	public void setMb(int mb) {
		this.mb = mb;
	}

	@Override
	public String toString() {
		return "PostpaidTariff [tariff=" + tariff + ", mobileOperater=" + mobileOperater + ", business=" + business
				+ ", minutes=" + minutes + ", messages=" + messages + ", mb=" + mb + "]";
	}
	
	// @@@@@@@@@@@@
	// logic
	
	// choose tariff
	public static PostpaidTariff matchPostpaidTariff(String matchName, MobileOperater mobileOperater) {
		PostpaidTariff tariff = null;
		for (int i=0; i<postpaidTariffs.size(); i++) {
			tariff = (PostpaidTariff)postpaidTariffs.get(i);
			if (tariff.getTariff().equals(matchName) && tariff.getMobileOperater()==mobileOperater) {
				break;
			}
		}
		return tariff;
	}
	
	// list for specific mobile operater
	public static void listPostpaidTariffs(MobileOperater mobOp) {
		System.out.println("available postpaid tariffs for " + mobOp.getName() + " are:");
		for (int i=0; i<postpaidTariffs.size(); i++) {
			PostpaidTariff tariff = (PostpaidTariff)postpaidTariffs.get(i);
			if (tariff.getMobileOperater().getName().equals(mobOp.getName())) {
				System.out.println(tariff.getTariff());
			}
		}
		System.out.println();
	}
	
	public static PostpaidTariff addPostpaidTariff(MobileOperater mobOp) {
		
		Scanner scannerString = new Scanner(System.in);
		Scanner scannerInt = new Scanner(System.in);
		
		System.out.println("enter postpaid tariff");
		String name = scannerString.nextLine();		
		System.out.println("is it business? 1-yes / 2-no");
		int busines = scannerInt.nextInt();
		boolean business=true;
		if (busines==1) {
			business=true;
		} else if (busines==2) {
			business=false;
		}
		System.out.println("enter number of minutes");
		int minutes = scannerInt.nextInt();
		System.out.println("enter number of messages");
		int messages = scannerInt.nextInt();
		System.out.println("enter numer of mb");
		int mb = scannerInt.nextInt();

		PostpaidTariff postpaidTariff = new PostpaidTariff(name, mobOp, business, minutes, messages, mb);
		postpaidTariffs.add(postpaidTariff);
		
		Main.postTar = postpaidTariff;
		
		System.out.println(postpaidTariff.toString());
		System.out.println(postpaidTariffs.toString());
		System.out.println();
		
		return postpaidTariff;
	}
	
	public static PostpaidTariff loadPostpaidTariff(MobileOperater mobOp) {
		listPostpaidTariffs(mobOp);
		System.out.println("choose postpaid tariff");
		Scanner scannerString = new Scanner(System.in);
		String name = scannerString.nextLine();
		PostpaidTariff postpaidTariff = matchPostpaidTariff(name, mobOp);
		Main.postTar = postpaidTariff;
		System.out.println();
		return postpaidTariff;
	}
	
	public int calculateTariffPrice() {
		int totalMinutesPrice = minutes * mobileOperater.getMinPrice();
		int totalMessagesPrice = messages * mobileOperater.getMessagePrice();
		int totalMbPrice = mb * mobileOperater.getMbPrice();
		int totalTariffPrice = totalMinutesPrice + totalMessagesPrice + totalMbPrice;
		return totalTariffPrice;
	}

}
