package mobilniOperaterBaseII;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class User{

	private String name;
	
	private int minutes;
	
	private int messages;
	
	private int mbSurf;
	
	private int balance;
	
	private PostpaidTariff postpaidTariff;

	ArrayList<TariffAddon> tariffAddons;

	public User() {
	}

	public User(String name, int minutes, int messages, int mbSurf, int balance, PostpaidTariff postpaidTariff,
			ArrayList<TariffAddon> tariffAddons) {
		this.name = name;
		this.minutes = minutes;
		this.messages = messages;
		this.mbSurf = mbSurf;
		this.balance = balance;
		this.postpaidTariff = postpaidTariff;
		this.tariffAddons = tariffAddons;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinuts(int minutes) {
		this.minutes = minutes;
	}

	public int getMessage() {
		return messages;
	}

	public void setMessage(int message) {
		this.messages = message;
	}

	public int getMbSurf() {
		return mbSurf;
	}

	public void setMbSurf(int mbSurf) {
		this.mbSurf = mbSurf;
	}

	public ArrayList<TariffAddon> getTariffAddons() {
		return tariffAddons;
	}

	public void setTariffAddons(ArrayList<TariffAddon> tariffAddons) {
		this.tariffAddons = tariffAddons;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public PostpaidTariff getPostpaidTariff() {
		return postpaidTariff;
	}

	public void setPostpaidTariff(PostpaidTariff postpaidTariff) {
		this.postpaidTariff = postpaidTariff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", minutes=" + minutes + ", messages=" + messages + ", mbSurf=" + mbSurf
				+ ", balance=" + balance + ", postpaidTariff=" + postpaidTariff + ", tariffAddons=" + tariffAddons
				+ "]";
	}
	
	// list for specific tariff
		public static void listPostpaidUsers() {
			System.out.println("postpaid users are:");
			for (int i=0; i<UserPostpaidPrivate.postpaidUsersPrivate.size(); i++) {
				UserPostpaidPrivate user = (UserPostpaidPrivate)UserPostpaidPrivate.postpaidUsersPrivate.get(i);
				System.out.println(user.getName());
			}
			for (int i=0; i<UserPostpaidBusiness.postpaidUsersBusiness.size(); i++) {
				UserPostpaidBusiness user = (UserPostpaidBusiness)UserPostpaidBusiness.postpaidUsersBusiness.get(i);
				System.out.println(user.getName());
			}
			System.out.println();
		}
		
		// choose user
		public static User matchPostpaidUser(String matchName) {
			User user1 = null;
			for (int i=0; i<UserPostpaidPrivate.postpaidUsersPrivate.size(); i++) {
				user1 = (User)UserPostpaidPrivate.postpaidUsersPrivate.get(i);
				if (user1.getName().equals(matchName)) {
					break;
				}
			}
			User user2 = null;
			for (int i=0; i<UserPostpaidBusiness.postpaidUsersBusiness.size(); i++) {
				user2 = (User)UserPostpaidBusiness.postpaidUsersBusiness.get(i);
				if (user2.getName().equals(matchName)) {
					break;
				}
			}
			if (user1 != null) {
				return user1;
			} else if (user2 != null) {
				return user2;
			} else {
				System.out.println("error");
				return user1;
			}
			
		}
		
		public static User loadPostpaidUser() {
			listPostpaidUsers();
			System.out.println("choose postpaid user");
			Scanner scannerString = new Scanner(System.in);
			String name = scannerString.nextLine();
			User user = matchPostpaidUser(name);
			Main.mobOp = user.getPostpaidTariff().getMobileOperater();
			Main.postTar = user.getPostpaidTariff();
			if(user.getPostpaidTariff().isBusiness()) {
				Main.korPostBus = (UserPostpaidBusiness) user;
				Main.fir = Main.korPostBus.getCompany();
			}else if(!user.getPostpaidTariff().isBusiness()){
				Main.korPostPri = (UserPostpaidPrivate) user;
			}
			Main.korPost = user;
			System.out.println();
			return user;
		}

}
