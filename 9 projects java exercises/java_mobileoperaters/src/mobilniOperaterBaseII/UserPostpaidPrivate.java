package mobilniOperaterBaseII;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPostpaidPrivate extends User implements Tariff {
	
	public static ArrayList<UserPostpaidPrivate> postpaidUsersPrivate = new ArrayList<>();

	public UserPostpaidPrivate() {
	}

	public UserPostpaidPrivate(String name, int minutes, int messages, int mbSurf, int balance,
			PostpaidTariff postpaidTariff, ArrayList<TariffAddon> tariffAddons) {
		super(name, minutes, messages, mbSurf, balance, postpaidTariff, tariffAddons);
	}

	@Override
	public String toString() {
		return "UserPostpaidPrivate [tariffAddons=" + tariffAddons + "]";
	}

	// @@@@@@@@@@@@@@
	// logic
	
	public static UserPostpaidPrivate addPostpaidPrivateUser(PostpaidTariff tariff) {
		
		if (Main.postTar.isBusiness()==true) {
			System.out.println("choose private tariff");
			System.out.println();
			return null;
		} else {
			Scanner scannerString = new Scanner(System.in);
			
			// check for duplicates
			String userName = null;
			Loop:
			while(true) {
				System.out.println("enter name of postpaid private user");
				userName = scannerString.nextLine();
				if (postpaidUsersPrivate.size()==0) {
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

			int minutes = tariff.getMinutes();
			int messages = tariff.getMessage();
			int mb = tariff.getMb();
			int balance = 0;
			ArrayList<TariffAddon> tariffAddons = new ArrayList<>();
	
			UserPostpaidPrivate userPostpaidPrivate = new UserPostpaidPrivate(userName, minutes, messages, mb, balance, tariff, tariffAddons);
			postpaidUsersPrivate.add(userPostpaidPrivate);
			Main.korPostPri = userPostpaidPrivate;
			
			System.out.println(userPostpaidPrivate.toString());
			System.out.println(postpaidUsersPrivate.toString());
			System.out.println();
	
			return userPostpaidPrivate;
		}
	}
	
	// list for specific tariff
	public static void listPostpaidPrivateUsersByTariff(PostpaidTariff tariff) {
		System.out.println("users with tariff " + tariff.getTariff() + " are:");
		for (int i=0; i<postpaidUsersPrivate.size(); i++) {
			UserPostpaidPrivate user = (UserPostpaidPrivate)postpaidUsersPrivate.get(i);
			if (user.getPostpaidTariff().equals(tariff)) {
				System.out.println(user.getName());
			}
		}
		System.out.println();
	}
	
	// choose user
	public static UserPostpaidPrivate matchPostpaidUserIII(String matchName) {
		UserPostpaidPrivate user = null;
		for (int i=0; i<postpaidUsersPrivate.size(); i++) {
			user = (UserPostpaidPrivate)postpaidUsersPrivate.get(i);
			if (user.getName().equals(matchName)) {
				break;
			}
		}
		return user;
	}
	
	public static UserPostpaidPrivate loadPostpaidPrivateUser(PostpaidTariff tariff) {
		listPostpaidPrivateUsersByTariff(tariff);
		System.out.println("chooser postpaid private user");
		Scanner scannerString = new Scanner(System.in);
		String name = scannerString.nextLine();
		UserPostpaidPrivate user = matchPostpaidUserIII(name);
		Main.korPostPri = user;
		System.out.println();
		return user;
	}

	@Override
	public boolean talk() {
		System.out.println("how many minutes do you want to talk");
		Scanner sc = new Scanner(System.in);
		int minutes = sc.nextInt();
		if (this.getMinutes() < minutes) {
			System.out.println("you overdrafted your package, it will be added to your balance");
			int minutesForBalance = minutes - this.getMinutes();
			int priceForBalance = this.getPostpaidTariff().getMobileOperater().getMinPrice() * minutesForBalance;
			this.setMinuts(0);
			this.setBalance(this.getBalance() + priceForBalance);
		} else {
			System.out.println("you are inside package limits, you hava minutes");
			this.setMinuts(this.getMinutes() - minutes);
		}
		String string = "postpaid private user " + this.getName() + ", tariff "
				+ this.getPostpaidTariff().getTariff() + ", operater "
				+ this.getPostpaidTariff().getMobileOperater().getName()
				+ ", minutes of talk " + minutes;
		MobileOperater.log.add(string);
		System.out.println("successfull conversation");
		System.out.println();
		return true;
	}

	@Override
	public boolean message() {
		int cenaPoruke = this.getPostpaidTariff().getMobileOperater().getMessagePrice();
		int freeMessages = 0;
		for (TariffAddon tariffAddon : this.getTariffAddons()) {
			if (tariffAddon.getTariffAddon().equals("sms")) {
				freeMessages = 1;
				break;
			} else {
				freeMessages = 2;
			}
		}
		if (freeMessages == 1) {
			System.out.println("you have free messages");
		}
		else if (this.getMessage() <= 0) {
			System.out.println("you don't have enough to send message, it will be added to your balance");
			this.setBalance(this.getBalance() + cenaPoruke);
		} else {
			System.out.println("you have messages, your message will be sent");
			this.setMessage(this.getMessage() - 1);
		}
		System.out.println("enter your message");
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		String string = "postpaid private user " + this.getName() + ", tariff "
				+ this.getPostpaidTariff().getTariff() + ", operater "
				+ this.getPostpaidTariff().getMobileOperater().getName()
				+ ", message sent <<" + message + ">>";
		MobileOperater.log.add(string);
		System.out.println("message successfully sent");
		System.out.println();
		return true;
	}

	@Override
	public boolean surf() {
		System.out.println("how much mb do you wish to spend");
		Scanner sc = new Scanner(System.in);
		int numberOfMb = sc.nextInt();
		System.out.println("enter desired url");
		Scanner scs = new Scanner(System.in);
		String url = scs.nextLine();
		int freeSurf = 0;
		for (TariffAddon tariffAddon : this.getTariffAddons()) {
			if (tariffAddon.getTariffAddon().equals("net")) {
				freeSurf = 1;
				break;
			} else {
				freeSurf = 2;
			}
		}
		if (freeSurf == 1) {
			System.out.println("you have free surf");
		}
		else if (this.getMbSurf() < numberOfMb) {
			System.out.println("you don't have enough mb, it will be added to your balance");
			int mbForBalance = numberOfMb - this.getMbSurf();
			int priceOfSurf = this.getPostpaidTariff().getMobileOperater().getMbPrice() * numberOfMb;
			this.setMbSurf(0);
			this.setBalance(this.getBalance() + priceOfSurf);
		} else {
			System.out.println("you have enough mb on your account");
			this.setMbSurf(this.getMbSurf() - numberOfMb);	
		}
		String string = "postpaid private user " + this.getName() + ", tariff "
				+ this.getPostpaidTariff().getTariff() + ", operater "
				+ this.getPostpaidTariff().getMobileOperater().getName()
				+ ", visited url <<" + url + ">>" + ", spent mb " + numberOfMb;
		MobileOperater.log.add(string);
		System.out.println("successfully visited site");
		System.out.println();
		return true;
	}
	
	public TariffAddon buyTariffAddon() {
		MobileOperater mobileOperater = this.getPostpaidTariff().getMobileOperater();
		TariffAddon.listTariffAddons(mobileOperater);
		System.out.println("choose tariff addon");
		Scanner sc = new Scanner(System.in);
		String addon = sc.nextLine();
		TariffAddon tariffAddon = TariffAddon.matchTariffAddon(mobileOperater, addon);
		this.setBalance(this.getBalance() + tariffAddon.getTariffAddonPrice());
		this.getTariffAddons().add(tariffAddon);
		System.out.println();
		return tariffAddon;
	}
	
}
