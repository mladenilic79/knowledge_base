package mobilniOperaterBaseII;

import java.util.ArrayList;
import java.util.Scanner;

public class TariffAddon {

	private MobileOperater mobileOperater;
	
	private String tariffAddon;

	private int tariffAddonPrice;
	
	public TariffAddon() {
	}
	
	public TariffAddon(MobileOperater mobileOperater, String tariffAddon,
			int tariffAddonPrice) {
		this.mobileOperater = mobileOperater;
		this.tariffAddon = tariffAddon;
		this.tariffAddonPrice = tariffAddonPrice;
	}

	public String getTariffAddon() {
		return tariffAddon;
	}

	public void setTariffAddon(String tariffAddon) {
		this.tariffAddon = tariffAddon;
	}

	public MobileOperater getMobileOperater() {
		return mobileOperater;
	}

	public void setMobileOperater(MobileOperater mobileOperater) {
		this.mobileOperater = mobileOperater;
	}

	public int getTariffAddonPrice() {
		return tariffAddonPrice;
	}

	public void setTariffAddonPrice(int tariffAddonPrice) {
		this.tariffAddonPrice = tariffAddonPrice;
	}

	@Override
	public String toString() {
		return "TariffAddon [mobileOperater=" + mobileOperater + ", tariffAddon=" + tariffAddon + ", tariffAddonPrice="
				+ tariffAddonPrice + "]";
	}
	
	// @@@@@@@@@@
	// logic
	
	public static void listTariffAddons(MobileOperater mobOp) {
		System.out.println("available tariff addons for " + mobOp.getName() + " are:");
		for (int i=0; i<mobOp.getTariffAddons().size(); i++) {
			TariffAddon tariffAddon = (TariffAddon)mobOp.getTariffAddons().get(i);
			System.out.println(tariffAddon.getTariffAddon());
		}
		System.out.println();
	}
	
	// choose addon
	public static TariffAddon matchTariffAddon(MobileOperater mobOp, String matchName) {
		TariffAddon tariffAddon = null;
		for (int i=0; i<mobOp.getTariffAddons().size(); i++) {
			tariffAddon = (TariffAddon)mobOp.getTariffAddons().get(i);
			if (tariffAddon.getTariffAddon() == matchName) {
				break;
			}
		}
		return tariffAddon;
	}
	
	public static TariffAddon addTariffAddon(MobileOperater mobOp) {
		
		Scanner scannerString = new Scanner(System.in);
		Scanner scannerInt = new Scanner(System.in);
		
		System.out.println("enter name of new addon");
		String name = scannerString.nextLine();
		System.out.println("enter price of new addon");
		int price = scannerInt.nextInt();	

		TariffAddon tariffAddon = new TariffAddon(mobOp, name, price);
		mobOp.getTariffAddons().add(tariffAddon);
		
		System.out.println(tariffAddon.toString());
		System.out.println(mobOp.getTariffAddons().toString());
		System.out.println();
		
		return tariffAddon;

	}

}
