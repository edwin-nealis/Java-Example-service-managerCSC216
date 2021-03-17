package edu.ncsu.csc216.service_wolf.model.manager;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
/**
 * test service wolf manager class
 * @author edwin
 *
 */
public class ServiceWolfManagerTest {
	/** instance of manager */
	ServiceWolfManager instance;
	/** valid test file */
	private final String validFile = "test-files/incidents1.txt";
	/**
	 * gets an instance and sets counter for each test
	 */
	@Before
	public void setUp() {
		instance = ServiceWolfManager.getInstance();
		Incident.setCounter(1);
	}
	
	/**
	 * test save to file method
	 */
	@Test
	public void testSaveToFile() {
		instance.addServiceGroup("Service Group 1");
		instance.addIncidentToServiceGroup("title1", "caller1", "message1");
		assertEquals(instance.getIncidentById(1).getCaller(), "caller1");
		instance.addServiceGroup("Service Group 2");
		instance.addIncidentToServiceGroup("title2", "caller2", "message2");
		assertEquals(instance.getIncidentById(1).getCaller(), "caller2");
		instance.addServiceGroup("Service Group 3");
		instance.addIncidentToServiceGroup("title3", "caller3", "message3");
		assertEquals(instance.getIncidentById(1).getCaller(), "caller3");
		instance.addIncidentToServiceGroup("title4", "caller4", "message4");
		assertEquals(instance.getIncidentById(2).getCaller(), "caller4");
		instance.saveToFile("test-files/export.txt");
		checkFiles("test-files/incidents0.txt", "test-files/export.txt");
		instance.resetManager();
		
	}
	/**
	 * Helper method to compare two files for the same contents
	 * 
	 * @param expFile expected output
	 * @param actFile actual output
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new FileInputStream(expFile));
				Scanner actScanner = new Scanner(new FileInputStream(actFile));) {

			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}

			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}
	/**
	 * tests load from file method
	 */
	@Test
	public void testLoadFromFile() {
		instance.loadFromFile(validFile);
		assertEquals(instance.getServiceGroupName(), "CSC IT");
		assertEquals(instance.getIncidentById(3).getTitle(), "Moodle down");
		assertEquals(instance.getIncidentById(3).getState(), "New");
		assertEquals(instance.getIncidentById(3).getCaller(), "sesmith5");
		instance.resetManager();
	}

	/**
	 * tests delete incident by id
	 */
	@Test
	public void testDeleteIncidentById() {
		instance.addServiceGroup("sg");
		instance.loadServiceGroup("sg");
		assertEquals(instance.getServiceGroupName(), "sg");
		instance.addIncidentToServiceGroup("title", "caller", "message");
		instance.addIncidentToServiceGroup("title2", "caller2", "message");
		assertEquals(instance.getIncidentById(1).getTitle(), "title");
		assertEquals(instance.getIncidentById(2).getCaller(), "caller2");
		instance.deleteIncidentById(2);
		assertEquals(instance.getIncidentById(1).getTitle(), "title");
		assertNull(instance.getIncidentById(2));
		instance.resetManager();
		
	}

	/**
	 * tests load service group method
	 */
	@Test
	public void testLoadServiceGroup() {
		instance.addServiceGroup("sg");
		instance.loadServiceGroup("sg");
		assertEquals(instance.getServiceGroupName(), "sg");
		instance.resetManager();
	}

	/**
	 * test clear service groups method 
	 */
	@Test
	public void testClearServiceGroups() {
		instance.loadFromFile(validFile);
		instance.clearServiceGroups();
		assertNull(instance.getServiceGroupName());
		instance.resetManager();
	}

	/**
	 * test edit service group method
	 */
	@Test
	public void testEditServiceGroup() {
		instance.loadFromFile(validFile);
		instance.editServiceGroup("ZSZ IT");
		String[] temp = new String[] {"ITECS", "OIT", "ZSZ IT"};
		assertEquals(instance.getServiceGroupList()[0], temp[0]);
		assertEquals(instance.getServiceGroupList()[1], temp[1]);
		assertEquals(instance.getServiceGroupList()[2], temp[2]);
		instance.resetManager();
	}

	/**
	 * tests delete service group method
	 */
	@Test
	public void testDeleteServiceGroup() {
		instance.addServiceGroup("sg");
		instance.loadServiceGroup("sg");
		assertEquals(instance.getServiceGroupName(), "sg");
		instance.deleteServiceGroup();
		assertNull(instance.getServiceGroupName());
		instance.resetManager();
	}
	/**
	 * tests add incident to service group method
	 */
	@Test
	public void testAddIncidentToServiceGroup() {
		instance.addServiceGroup("sg");
		instance.addIncidentToServiceGroup("title1", "caller1", "message1");
		String[][] s = instance.getIncidentsAsArray();
		assertEquals(s.length, 1);
		assertEquals(s[0][0], "1");
		assertEquals(s[0][1], "New");
		assertEquals(s[0][2], "title1");
		assertEquals(s[0][3], "No Status");
		instance.resetManager();
	}

}
