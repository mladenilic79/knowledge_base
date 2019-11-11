package mobilniOperaterBaseII;

import java.util.ArrayList;

public class UserInterface {
	
	public static void hardcode() {
		
		MobileOperater mobileOperater = new MobileOperater(new ArrayList<TariffAddon>(), "airtel", 3, 3, 3);
		MobileOperater.mobileOperaters.add(mobileOperater);
		Main.mobOp = mobileOperater;
		
		TariffAddon tariffAddon = new TariffAddon(Main.mobOp, "sms", 10);
		Main.mobOp.getTariffAddons().add(tariffAddon);
		
		Company company = new Company("srbijaSume", Main.mobOp);
		Company.companies.add(company);
		Main.fir = company;
		
		PrepaidTariff prepaidTariff = new PrepaidTariff("low", Main.mobOp, 30);
		PrepaidTariff.prepaidTariffs.add(prepaidTariff);
		Main.preTar = prepaidTariff;
		
		PostpaidTariff postpaidTariff = new PostpaidTariff("high private", Main.mobOp, false, 30, 30, 30);
		PostpaidTariff.postpaidTariffs.add(postpaidTariff);
		Main.postTar = postpaidTariff;
		
		PostpaidTariff postpaidTariff2 = new PostpaidTariff("high business", Main.mobOp, true, 30, 30, 30);
		PostpaidTariff.postpaidTariffs.add(postpaidTariff2);
//		Main.postTar = postpaidTarifa2;
		
		UserPrepaid userPrepaid = new UserPrepaid("tom", Main.preTar, Main.preTar.getPrepaidCredit());
		UserPrepaid.prepaidUsers.add(userPrepaid);
		Main.korPre = userPrepaid;
		
		UserPostpaidPrivate userPostpaidPrivate = new UserPostpaidPrivate("lela", Main.postTar.getMinutes(), Main.postTar.getMessage(), Main.postTar.getMb(), 0, Main.postTar, new ArrayList<>());
		UserPostpaidPrivate.postpaidUsersPrivate.add(userPostpaidPrivate);
		Main.korPostPri = userPostpaidPrivate;
		
		Main.postTar = postpaidTariff2;
		UserPostpaidBusiness userPostpaidBusiness = new UserPostpaidBusiness("li", Main.postTar.getMinutes(), Main.postTar.getMessage(), Main.postTar.getMb(), 0, Main.postTar, new ArrayList<>(), Main.fir);
		UserPostpaidBusiness.postpaidUsersBusiness.add(userPostpaidBusiness);
		Main.korPostBus = userPostpaidBusiness;
		
		// second
		
		MobileOperater mobileOperater2 = new MobileOperater(new ArrayList<TariffAddon>(), "telenor", 3, 3, 3);
		MobileOperater.mobileOperaters.add(mobileOperater2);
		Main.mobOp = mobileOperater2;
		
		Company company2 = new Company("srbijaVode", Main.mobOp);
		Company.companies.add(company2);
		Main.fir = company2;
		
		PrepaidTariff prepaidTariff2 = new PrepaidTariff("low", Main.mobOp, 30);
		PrepaidTariff.prepaidTariffs.add(prepaidTariff2);
		Main.preTar = prepaidTariff2;
		
		PostpaidTariff postpaidTariff3 = new PostpaidTariff("high private", Main.mobOp, false, 30, 30, 30);
		PostpaidTariff.postpaidTariffs.add(postpaidTariff3);
		Main.postTar = postpaidTariff3;
		
		UserPrepaid userPrepaid2 = new UserPrepaid("jack", Main.preTar, Main.preTar.getPrepaidCredit());
		UserPrepaid.prepaidUsers.add(userPrepaid2);
		Main.korPre = userPrepaid2;
		
		UserPostpaidPrivate userPostpaidPrivate2 = new UserPostpaidPrivate("ljilja", Main.postTar.getMinutes(), Main.postTar.getMessage(), Main.postTar.getMb(), 0, Main.postTar, new ArrayList<>());
		UserPostpaidPrivate.postpaidUsersPrivate.add(userPostpaidPrivate2);
		Main.korPostPri = userPostpaidPrivate2;
		
		PostpaidTariff postpaidTariff4 = new PostpaidTariff("high business", Main.mobOp, true, 30, 30, 30);
		PostpaidTariff.postpaidTariffs.add(postpaidTariff4);
		Main.postTar = postpaidTariff4;
		
		UserPostpaidBusiness userPostpaidBusiness2 = new UserPostpaidBusiness("perko", Main.postTar.getMinutes(), Main.postTar.getMessage(), Main.postTar.getMb(), 0, Main.postTar, new ArrayList<>(), Main.fir);
		UserPostpaidBusiness.postpaidUsersBusiness.add(userPostpaidBusiness2);
		Main.korPostBus = userPostpaidBusiness2;
		
	}
	
	public static void status() {
		System.out.println("choosen values: ");
		System.out.println();
		System.out.println("mobile operater:        " + Main.mobOp.getName());
		System.out.println("prepaid tariff:         " + Main.preTar.getMobileOperater().getName() + " @" + Main.preTar.getTariff() + "@");
		System.out.println("postpaid tariff:        " + Main.postTar.getMobileOperater().getName() + " @" + Main.postTar.getTariff() + "@");
		System.out.println("company:                " + Main.fir.getMobilniOperater().getName() + " <<<" + Main.fir.getName() + ">>>");
		System.out.println("prepaid user:           " + Main.korPre.getPrepaidTariff().getMobileOperater().getName() + " @" + Main.korPre.getPrepaidTariff().getTariff() + "@ " + Main.korPre.getName());
		System.out.println("private postpaid user:  " + Main.korPostPri.getPostpaidTariff().getMobileOperater().getName() + " @" + Main.korPostPri.getPostpaidTariff().getTariff() + "@ " + Main.korPostPri.getName());
		System.out.println("business postpaid user: " + Main.korPostBus.getPostpaidTariff().getMobileOperater().getName() + " @" + Main.korPostBus.getPostpaidTariff().getTariff() + "@ <<<" + Main.korPostBus.getCompany().getName() + ">>> " + Main.korPostBus.getName());
//		System.out.println("generic postpaid user" + Main.korPost.getNaziv());
		System.out.println();
	}

}
