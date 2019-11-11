package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mobilniOperaterBaseII.Company;
import mobilniOperaterBaseII.UserInterface;

class CompanyTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		UserInterface.hardcode();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	final void testAddCompany() {
		Company company = mobilniOperaterBaseII.Company.addCompany(mobilniOperaterBaseII.Main.mobOp);
		assertNotNull(company);
	}

	@Test
	final void testListAllCompanies() {
		assertNotNull(mobilniOperaterBaseII.Company.companies);
	}

	@Test
	final void testMatchCompany() {
		Company company = mobilniOperaterBaseII.Company.matchCompany("srbijaSume", mobilniOperaterBaseII.Main.mobOp);
		assertNotNull(company);
	}

	@Test
	final void testLoadCompany() {
		Company company = mobilniOperaterBaseII.Company.loadCompany(mobilniOperaterBaseII.Main.mobOp);
		assertNotNull(company);
	}

}
