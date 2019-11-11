package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mobilniOperaterBaseII.MobileOperater;
import mobilniOperaterBaseII.UserInterface;

class MobilniOperaterTest {

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
	final void testListMobileOperaters() {
		assertNotNull(mobilniOperaterBaseII.MobileOperater.mobileOperaters);
	}
	
	@Test
	final void testListMobileOperaters2() {
		ArrayList<MobileOperater> mobileOperaters = new ArrayList<>();
		assertEquals(mobileOperaters.getClass(), 
				mobilniOperaterBaseII.MobileOperater.mobileOperaters.getClass());
	}
	
	@Test
	final void testMatchMobileOperater() {
		MobileOperater mobileOperater = 
				mobilniOperaterBaseII.MobileOperater.matchMobileOperater("airtel");
		assertNotNull(mobileOperater);
	}

	@Test
	final void testAddMobileOperater() {
		MobileOperater mobileOperater = mobilniOperaterBaseII.MobileOperater.addMobileOperater();
		assertNotNull(mobileOperater);
	}

	@Test
	final void testLoadMobileOperater() {
		MobileOperater mobileOperater = mobilniOperaterBaseII.MobileOperater.loadMobileOperater();
		assertNotNull(mobileOperater);
	}

	@Test
	final void testListLog() {
		assertNotNull(mobilniOperaterBaseII.MobileOperater.log);
	}
	
	@Test
	final void testListLog2() {
		ArrayList<String> logs = new ArrayList<>();
		assertEquals(logs.getClass(), mobilniOperaterBaseII.MobileOperater.log.getClass());
		assertNotNull(mobilniOperaterBaseII.MobileOperater.log);
	}

	@Test
	final void testGeneratePostpaidBillShort() {
		int total = mobilniOperaterBaseII.MobileOperater.
				generatePostpaidBillShort(mobilniOperaterBaseII.Main.korPostBus);
		assertNotNull(total);
	}

}
