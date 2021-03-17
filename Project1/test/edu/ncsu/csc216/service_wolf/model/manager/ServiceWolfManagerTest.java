package edu.ncsu.csc216.service_wolf.model.manager;

import static org.junit.Assert.*;

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
		fail("Not yet implemented");
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


}
