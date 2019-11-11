package mobilniOperaterBaseII;

import java.util.Scanner;

public class Main {
	
	public static MobileOperater mobOp;
	public static PrepaidTariff preTar;
	public static PostpaidTariff postTar;
	public static Company fir;
	public static UserPrepaid korPre;
	public static UserPostpaidBusiness korPostBus;
	public static UserPostpaidPrivate korPostPri;
	public static User korPost;
	
	public static void main(String[] args) {

		UserInterface.hardcode();
		
		while(true) {

			System.out.println("1 - add mobile operater");
			System.out.println("2 - list mobile operaters");
			System.out.println("3 - load mobile operater");
			System.out.println();
			System.out.println("4 - add tariff addon");
			System.out.println("5 - list tariff addons");
			System.out.println();
			System.out.println("6 - add company");
			System.out.println("7 - list companies");
			System.out.println("8 - load company");
			System.out.println();
			System.out.println("9 - add prepaid tariff");
			System.out.println("10 - list prepaid tariffs");
			System.out.println("11 - load prepaid tariff");
			System.out.println();
			System.out.println("12 - add postpaid tariff");
			System.out.println("13 - list postpaid tariffs");
			System.out.println("14 - load postpaid tariff");
			System.out.println();
			System.out.println("15 - add prepaid user");
			System.out.println("16 - list prepaid users");
			System.out.println("17 - load prepaid user");
			System.out.println();
			System.out.println("18 - add postpaid private user");
			System.out.println("19 - list postpaid private users");
			System.out.println("20 - load postpaid private user");
			System.out.println();
			System.out.println("21 - add postpaid business user");
			System.out.println("22 - list postpaid business users by tariff");
			System.out.println("23 - list postpaid business users by company");
			System.out.println("24 - load postpaid business user");
			System.out.println();
			System.out.println("25 - list generic postpaid users");
			System.out.println("26 - load generic postpaid user");
			System.out.println();
			System.out.println("27 - prepaid user - talk");
			System.out.println("28 - prepaid user - message");
			System.out.println("29 - prepaid user - surf");
			System.out.println();
			System.out.println("30 - postpaid private user - talk");
			System.out.println("31 - postpaid private user - message");
			System.out.println("32 - postpaid private user - surf");
			System.out.println("33 - postpaid private user - tariff addon");
			System.out.println();
			System.out.println("34 - postpaid business user - talk");
			System.out.println("35 - postpaid business user - message");
			System.out.println("36 - postpaid business user - surf");
			System.out.println("37 - postpaid business user - tariff addon");
			System.out.println();
			System.out.println("38 - list log");
			System.out.println("39 - generate generic postpaid bill ");
			System.out.println("40 - generate postpaid private bill");
			System.out.println("41 - list employes by company for chosen mobile operater");
			System.out.println("42 - generate bill for chosen company");
			System.out.println("43 - generate all bills");
			System.out.println("44 - exit program");
			System.out.println();

			UserInterface.status();
			
			Scanner scannerInt = new Scanner(System.in);
			int c = scannerInt.nextInt();
	        switch (c) {
	            case (1): MobileOperater.addMobileOperater();break;
	            case (2): MobileOperater.listMobileOperaters();break;
	            case (3): MobileOperater.loadMobileOperater();break;
	            
	            case (4): TariffAddon.addTariffAddon(Main.mobOp);break;
	            case (5): TariffAddon.listTariffAddons(Main.mobOp);break;
	            
	            case (6): Company.addCompany(Main.mobOp);break;
	            case (7): Company.listAllCompanies(Main.mobOp);break;
	            case (8): Company.loadCompany(Main.mobOp);break;
	            
	            case (9): PrepaidTariff.addPrepaidTariff(Main.mobOp);break;
	            case (10): PrepaidTariff.listPrepaidTariffs(Main.mobOp);break;
	            case (11): PrepaidTariff.loadPrepaidTariff(Main.mobOp);break;
	            
	            case (12): PostpaidTariff.addPostpaidTariff(Main.mobOp);break;
	            case (13): PostpaidTariff.listPostpaidTariffs(Main.mobOp);break;
	            case (14): PostpaidTariff.loadPostpaidTariff(Main.mobOp);break;
	            
	            case (15): UserPrepaid.addPrepaidUser(Main.preTar);break;
	            case (16): UserPrepaid.listPrepaidUsers(Main.preTar);break;
	            case (17): UserPrepaid.loadPrepaidUser(Main.preTar);break;
	            
	            case (18): UserPostpaidPrivate.addPostpaidPrivateUser(Main.postTar);break;
	            case (19): UserPostpaidPrivate.listPostpaidPrivateUsersByTariff(Main.postTar);break;
	            case (20): UserPostpaidPrivate.loadPostpaidPrivateUser(Main.postTar);break;
	            
	            case (21): UserPostpaidBusiness.addPostpaidBusinessUser(Main.postTar, Main.fir);break;
	            case (22): UserPostpaidBusiness.listPostpaidBusinessUsersByTariff(Main.postTar);break;
	            case (23): UserPostpaidBusiness.listPostpaidBusinessUsersByCompany(Main.fir);break;
	            case (24): UserPostpaidBusiness.loadPostpaidBusinessUser(Main.postTar, Main.fir);break;
	            
	            case (25): User.listPostpaidUsers();break;
	            case (26): User.loadPostpaidUser();break;
	            
	            case (27): Main.korPre.talk();break;
	            case (28): Main.korPre.message();break;
	            case (29): Main.korPre.surf();break;
	            
	            case (30): Main.korPostPri.talk();break;
	            case (31): Main.korPostPri.message();break;
	            case (32): Main.korPostPri.surf();break;
	            case (33): Main.korPostPri.buyTariffAddon();break;
	            
	            case (34): Main.korPostBus.talk();break;
	            case (35): Main.korPostBus.message();break;
	            case (36): Main.korPostBus.surf();break;
	            case (37): Main.korPostBus.buyTariffAddon();break;
	            
	            case (38): MobileOperater.listLog();break;
	            case (39): MobileOperater.generatePostpaidBill(Main.korPost);break;
	            case (40): MobileOperater.generatePostpaidBillPrivate(Main.korPostPri);break;
	            case (41): MobileOperater.employesByCompanies(Main.mobOp);break;
	            case (42): MobileOperater.companyBill(Main.fir);break;
	            case (43): MobileOperater.allBills(Main.mobOp);break;
	            
	            case (44): System.exit(0);
			
	            default:
	                System.out.println("error");
	                break;
	        }
	
		}
		
	}
	
}
