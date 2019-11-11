package mobilniOperaterBaseII;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPrepaid implements Tariff{

	public static ArrayList<UserPrepaid> prepaidUsers = new ArrayList<>();
	
	private String name;
	
	private PrepaidTariff prepaidTariff;
	
	private int prepaidCredit;

	public UserPrepaid() {
	}

	public UserPrepaid(String name, PrepaidTariff prepaidTariff, int prepaidCredit) {
		this.name = name;
		this.prepaidTariff = prepaidTariff;
		this.prepaidCredit = prepaidCredit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PrepaidTariff getPrepaidTariff() {
		return prepaidTariff;
	}

	public void setPrepaidTariff(PrepaidTariff prepaidTariff) {
		this.prepaidTariff = prepaidTariff;
	}

	public int getPrepaidCredit() {
		return prepaidCredit;
	}

	public void setPrepaidCredit(int prepaidCredit) {
		this.prepaidCredit = prepaidCredit;
	}

	@Override
	public String toString() {
		return "UserPrepaid [name=" + name + ", prepaidTariff=" + prepaidTariff + ", prepaidCredit=" + prepaidCredit
				+ "]";
	}
	
	// @@@@@@@@@@@@@@
	// logic
		
	public static UserPrepaid addPrepaidUser(PrepaidTariff tariff) {
		
		Scanner scannerString = new Scanner(System.in);
		
		// check for duplicates
		String userName = null;
		Loop:
		while(true) {	
			System.out.println("enter name for prepaid user");
			userName = scannerString.nextLine();
			if (prepaidUsers.size()==0) {
				break Loop;
			}
			int x = 0;
			for (int i=0; i<UserPostpaidPrivate.postpaidUsersPrivate.size(); i++) {
				UserPostpaidPrivate user = (UserPostpaidPrivate)UserPostpaidPrivate.postpaidUsersPrivate.get(i);
				if (user.getName().equals(userName)) {
					x++;
				} 
			} for (int i=0; i<UserPostpaidBusiness.postpaidUsersBusiness.size(); i++) {
				UserPostpaidBusiness user = (UserPostpaidBusiness)UserPostpaidBusiness.postpaidUsersBusiness.get(i);
				if (user.getName().equals(userName)) {
					x++;
				} 
			} for (int i=0; i<UserPrepaid.prepaidUsers.size(); i++) {
				UserPrepaid user = (UserPrepaid)UserPrepaid.prepaidUsers.get(i);
				if (user.getName().equals(userName)) {
					x++;
				} 
			}
			if (x == 0) {
				break;
			} else {
				System.out.println("duplicate enter again");
				continue;
			}
		}
		
		int credit = tariff.getPrepaidCredit();

		UserPrepaid userPrepaid = new UserPrepaid(userName, tariff, credit);
		prepaidUsers.add(userPrepaid);
		Main.korPre = userPrepaid;
		
		System.out.println(userPrepaid.toString());
		System.out.println(prepaidUsers.toString());
		System.out.println();

		return userPrepaid;
		
	}
	
	// list for specific tariff
	public static void listPrepaidUsers(PrepaidTariff tariff) {
		System.out.println("users with tariff " + tariff.getTariff() + " are:");
		for (int i=0; i<prepaidUsers.size(); i++) {
			UserPrepaid user = (UserPrepaid)prepaidUsers.get(i);
			if (user.getPrepaidTariff()==tariff) {
				System.out.println(user.getName());
			}
		}
		System.out.println();
	}
	
	// chooser user
	public static UserPrepaid matchPrepaidUser(String matchName, PrepaidTariff tariff) {
		UserPrepaid user = null;
		for (int i=0; i<prepaidUsers.size(); i++) {
			user = (UserPrepaid)prepaidUsers.get(i);
			if (user.getName().equals(matchName) && user.getPrepaidTariff()==tariff) {
				break;
			}
		}
		return user;
	}
	
	public static UserPrepaid loadPrepaidUser(PrepaidTariff tariff) {
		listPrepaidUsers(tariff);
		System.out.println("choose prepaid user");
		Scanner scannerString = new Scanner(System.in);
		String name = scannerString.nextLine();
		UserPrepaid user = matchPrepaidUser(name, tariff);
		Main.korPre = user;
		System.out.println();
		return user;
	}

	@Override
	public boolean talk() {
		System.out.println("how many minutes do you want to talk");
		Scanner sc = new Scanner(System.in);
		int minutes = sc.nextInt();
		int priceOfConversation = this.getPrepaidTariff().getMobileOperater().getMinPrice() * minutes;
		if (this.getPrepaidCredit() < priceOfConversation) {
			System.out.println("you dont have enough credit");
			return false;
		} else {
			this.setPrepaidCredit(this.getPrepaidCredit() - priceOfConversation);
			String string = "prepaid user " + this.getName() + ", tariff "
					+ this.getPrepaidTariff().getTariff() + ", operater "
					+ this.getPrepaidTariff().getMobileOperater().getName()
					+ ", minutes spent " + minutes;
			MobileOperater.log.add(string);
			System.out.println("successfull conversation");
			System.out.println();
			return true;
		}
	}

	@Override
	public boolean message() {
		int priceOfMessage = this.getPrepaidTariff().getMobileOperater().getMessagePrice();
		if (this.getPrepaidCredit() < priceOfMessage) {
			System.out.println("you dont have enough credit");
			return false;
		} else {
			this.setPrepaidCredit(this.getPrepaidCredit() - priceOfMessage);
			System.out.println("enter your message");
			Scanner sc = new Scanner(System.in);
			String message = sc.nextLine();
			String string = "prepaid user " + this.getName() + ", tariff "
					+ this.getPrepaidTariff().getTariff() + ", operater "
					+ this.getPrepaidTariff().getMobileOperater().getName()
					+ ", message sent <<" + message + ">>";
			MobileOperater.log.add(string);
			System.out.println("successfully sent message");
			System.out.println();
			return true;
		}
	}

	@Override
	public boolean surf() {
		System.out.println("how many mb do you want to spend");
		Scanner sc = new Scanner(System.in);
		int numberOfMb = sc.nextInt();
		int priceOfSurf = this.getPrepaidTariff().getMobileOperater().getMbPrice() * numberOfMb;
		if (this.getPrepaidCredit() < priceOfSurf) {
			System.out.println("you dont have enough credit");
			return false;
		} else {
			this.setPrepaidCredit(this.getPrepaidCredit() - priceOfSurf);
			System.out.println("enter url");
			Scanner sc2 = new Scanner(System.in);
			String url = sc2.nextLine();
			String string = "prepaid user " + this.getName() + ", tariff "
					+ this.getPrepaidTariff().getTariff() + ", operater "
					+ this.getPrepaidTariff().getMobileOperater().getName()
					+ ", visited url <<" + url + ">>" + ", spent mb " + numberOfMb;
			MobileOperater.log.add(string);
			System.out.println("successfully visited site");
			System.out.println();
			return true;
		}
	}
	
}
