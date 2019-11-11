package mobilniOperaterBaseII;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {

	public static ArrayList<Company> companies = new ArrayList<>();
	
	private String name;
	private MobileOperater mobileOperater;

	public Company() {
	}

	public Company(String name) {
		this.name = name;
	}

	public Company(String name, MobileOperater mobileOperater) {
		this.name = name;
		this.mobileOperater = mobileOperater;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MobileOperater getMobilniOperater() {
		return mobileOperater;
	}

	public void setMobilniOperater(MobileOperater mobilniOperater) {
		this.mobileOperater = mobilniOperater;
	}

	@Override
	public String toString() {
		return "Firma [name=" + name + ", mobilniOperater=" + mobileOperater + "]";
	}
	
	// @@@@@@@@@@@@@@
	// logic
		
	public static Company addCompany(MobileOperater mobOp) {
		
		Scanner scannerString = new Scanner(System.in);
		
		// check for duplicates
		String companyName = null;
		Loop:
		while(true) {	
			System.out.println("enter company name");
			companyName = scannerString.nextLine();
			if (companies.size()==0) {
				break Loop;
			}
			int x = 0;
			for (int i=0; i<companies.size(); i++) {
				Company company = (Company)companies.get(i);
				if (company.getName().equals(companyName)) {
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
		
		Company company = new Company(companyName, mobOp);
		companies.add(company);
		Main.fir = company;
		
		System.out.println(company.toString());
		System.out.println(companies.toString());
		System.out.println();

		return company;
		
	}
	
	// listaj za konkretnog operatera
	public static void listAllCompanies(MobileOperater mobOp) {
		System.out.println("available companies for " + mobOp.getName() + " are:");
		for (int i=0; i<companies.size(); i++) {
			Company company = (Company)companies.get(i);
			if ((company.getMobilniOperater().getName()).equals(mobOp.getName())) {
				System.out.println(company.getName());
			}
		}
		System.out.println();
	}
	
	// izbor firme
	public static Company matchCompany(String matchName, MobileOperater mobileOperater) {
		Company company = null;
		for (int i=0; i<companies.size(); i++) {
			company = (Company)companies.get(i);
			if (company.getName().equals(matchName) && company.getMobilniOperater()==mobileOperater) {
				break;
			}
		}
		return company;
	}
	
	public static Company loadCompany(MobileOperater mobOp) {
		listAllCompanies(mobOp);
		System.out.println("enter company name");
		Scanner scannerString = new Scanner(System.in);
		String name = scannerString.nextLine();
		Company company = matchCompany(name, mobOp);
		Main.fir = company;
		System.out.println();
		return company;
	}
	
}
