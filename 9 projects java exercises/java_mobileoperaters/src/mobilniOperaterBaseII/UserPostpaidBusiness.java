package mobilniOperaterBaseII;

import java.util.ArrayList;
import java.util.Scanner;

public class UserPostpaidBusiness extends User implements Tariff {
	
	public static ArrayList<UserPostpaidBusiness> postpaidUsersBusiness = new ArrayList<>();

	private Company company;

	public UserPostpaidBusiness() {
	}

	public UserPostpaidBusiness(String name, int minutes, int messages, int mbSurf, int balance,
			PostpaidTariff postpaidTariff, ArrayList<TariffAddon> tariffAddons, Company company) {
		super(name, minutes, messages, mbSurf, balance, postpaidTariff, tariffAddons);
		this.company = company;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "UserPostpaidBusiness [company=" + company + "]";
	}

	// @@@@@@@@@@@@@@
	// logic
	
	public static UserPostpaidBusiness addPostpaidBusinessUser(PostpaidTariff tariff, Company company) {
		
		if (Main.postTar.isBusiness()==false) {
			System.out.println("choose business tariff");
			System.out.println();
			return null;
		} else {
			Scanner scannerString = new Scanner(System.in);
			
			// check for duplicates
			String userName = null;
			Loop:
			while(true) {
				System.out.println("enter name of postpaid business user");
				userName = scannerString.nextLine();
				if (postpaidUsersBusiness.size()==0) {
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
					System.out.println("duplicate, enter again");
					continue;
				}
			}
			
			int minutes = tariff.getMinutes();
			int messages = tariff.getMessage();
			int mb = tariff.getMb();
			int balance = 0;
			ArrayList<TariffAddon> tariffAddons = new ArrayList<>();
	
			UserPostpaidBusiness userPostpaidBusiness = new UserPostpaidBusiness(userName, minutes, messages, mb, balance, tariff, tariffAddons, company);
			postpaidUsersBusiness.add(userPostpaidBusiness);
			Main.korPostBus = userPostpaidBusiness;
			
			System.out.println(userPostpaidBusiness.toString());
			System.out.println(postpaidUsersBusiness.toString());
			System.out.println();
	
			return userPostpaidBusiness;
		}
	}
	
	// list for specific tariff
	public static void listPostpaidBusinessUsersByTariff(PostpaidTariff tariff) {
		System.out.println("users with tariff " + tariff.getTariff() + " are:");
		for (int i=0; i<postpaidUsersBusiness.size(); i++) {
			UserPostpaidBusiness user = (UserPostpaidBusiness)postpaidUsersBusiness.get(i);
			if (user.getPostpaidTariff()==tariff) {
				System.out.println(user.getName());
			}
		}
		System.out.println();
	}
	
	// list for specific company
		public static void listPostpaidBusinessUsersByCompany(Company company) {
			System.out.println("korisnici zaposleni u firmi " + company.getName() + " su:");
			for (int i=0; i<postpaidUsersBusiness.size(); i++) {
				UserPostpaidBusiness user = (UserPostpaidBusiness)postpaidUsersBusiness.get(i);
				if (user.getCompany().getName().equals(company.getName())) {
					System.out.println(user.getName());
				}
			}
			System.out.println();
		}
	
	// choose user
	public static UserPostpaidBusiness matchPostpaidUserII(String matchName) {
		UserPostpaidBusiness user = null;
		for (int i=0; i<postpaidUsersBusiness.size(); i++) {
			user = (UserPostpaidBusiness)postpaidUsersBusiness.get(i);
			if (user.getName().equals(matchName)) {
				break;
			}
		}
		return user;
	}
	
	public static UserPostpaidBusiness loadPostpaidBusinessUser(PostpaidTariff tariff, Company company) {
		listPostpaidBusinessUsersByTariff(tariff);
		listPostpaidBusinessUsersByCompany(company);
		System.out.println("choose postpaid business user");
		Scanner scannerString = new Scanner(System.in);
		String name = scannerString.nextLine();
		UserPostpaidBusiness user = matchPostpaidUserII(name);
		Main.korPostBus = user;
		System.out.println();
		return user;
	}

	@Override
	public boolean talk() {
		System.out.println("how many minutes do you wish to talk");
		Scanner sc = new Scanner(System.in);
		int minutes = sc.nextInt();
		if (this.getMinutes() < minutes) {
			System.out.println("you overdrafted you tariff package, it will be added to your balance");
			int minutesForBalance = minutes - this.getMinutes();
			int priceForBalance = this.getPostpaidTariff().getMobileOperater().getMinPrice() * minutesForBalance;
			this.setMinuts(0);
			this.setBalance(this.getBalance() + priceForBalance);
		} else {
			System.out.println("you are inside allowed spending");
			this.setMinuts(this.getMinutes() - minutes);
		}
		String string = "postpaid business user " + this.getName() 
				+ ", employed in company " + this.getCompany().getName() 
				+ ", tariff " + this.getPostpaidTariff().getTariff() 
				+ ", operater " + this.getPostpaidTariff().getMobileOperater().getName()
				+ ", minutes of conversation " + minutes;
		MobileOperater.log.add(string);
		System.out.println("succesfull conversation");
		System.out.println();
		return true;
	}

	@Override
	public boolean message() {
		int priceOfMessage = this.getPostpaidTariff().getMobileOperater().getMessagePrice();
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
			System.out.println("not enough credit to send message, it will be added to you balance");
			this.setBalance(this.getBalance() + priceOfMessage);
		} else {
			System.out.println("you message will be delivered");
			this.setMessage(this.getMessage() - 1);
		}
		System.out.println("enter message");
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		String string = "postpaid business user " + this.getName()
				+ ", employed in company " + this.getCompany().getName() 
				+ ", tariff " + this.getPostpaidTariff().getTariff() 
				+ ", operater " + this.getPostpaidTariff().getMobileOperater().getName()
				+ ", message sent <<" + message + ">>";
		MobileOperater.log.add(string);
		System.out.println("successfull sent message");
		System.out.println();
		return true;
	}

	@Override
	public boolean surf() {
		System.out.println("how much mb you want to spend");
		Scanner sc = new Scanner(System.in);
		int numberOfMb = sc.nextInt();
		System.out.println("enter wanted url");
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
			System.out.println("not enough mb, it will be transfered to you balance");
			int mbForBalance = numberOfMb - this.getMbSurf();
			int priceOfSurfa = this.getPostpaidTariff().getMobileOperater().getMbPrice() * numberOfMb;
			this.setMbSurf(0);
			this.setBalance(this.getBalance() + priceOfSurfa);
		} else {
			System.out.println("you have enough mb left");
			this.setMbSurf(this.getMbSurf() - numberOfMb);	
		}
		String string = "postpaid business user " + this.getName()
				+ ", employed in company " + this.getCompany().getName() 
				+ ", tariff " + this.getPostpaidTariff().getTariff() 
				+ ", operater " + this.getPostpaidTariff().getMobileOperater().getName()
				+ ", visited url <<" + url + ">>" + ", spent mb " + numberOfMb;
		MobileOperater.log.add(string);
		System.out.println("successfully visited website");
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
