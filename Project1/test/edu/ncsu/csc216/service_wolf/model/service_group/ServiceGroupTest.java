package edu.ncsu.csc216.service_wolf.model.service_group;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
/**
 * tests the service group class
 * @author edwin
 *
 */
public class ServiceGroupTest {
	/**
	 * resets counter before each test
	 * @throws Exception exception
	 */
	@Before
	public void setUp() throws Exception {
		//Reset the counter at the beginning of every test.
		Incident.setCounter(1);
	}
	/**
	 * tests constructor for service group
	 */
	@Test
	public void testDeletIncidentById() {
		ServiceGroup sg = new ServiceGroup("sg");
		Incident i1 = new Incident("title1", "caller", "message");
		Incident i2 = new Incident("title2", "caller", "message");
		Incident i3 = new Incident("title3", "caller", "message");
		sg.addIncident(i1);
		sg.addIncident(i2);
		sg.addIncident(i3);
		assertEquals(sg.getIncidents().size(), 3);
		sg.deleteIncidentById(2);
		assertEquals(sg.getIncidents().size(), 2);
		assertEquals(sg.getIncidentById(1).getTitle(), "title1");
		assertEquals(sg.getIncidentById(3).getTitle(), "title3");
		
	}
	/**
	 * tests set incident counter
	 */
	@Test
	public void testSetIncidentCounter() {
		ServiceGroup sg = new ServiceGroup("sg");
		Incident i1 = new Incident("title1", "caller", "message");
		Incident i2 = new Incident("title2", "caller", "message");
		Incident i3 = new Incident("title3", "caller", "message");
		ArrayList<String> list = new ArrayList<String>();
		list.add("abc");
		Incident i5 = new Incident(5, "New", "title", "caller", 0, "Unowned", Incident.NO_STATUS, list);
		sg.addIncident(i1);
		sg.addIncident(i2);
		sg.addIncident(i3);
		sg.addIncident(i5);
		assertEquals(sg.getIncidents().size(), 4);
		sg.setIncidentCounter();
		Incident i4 = new Incident("title4", "caller", "message");
		assertEquals(i4.getId(), 6);
		
		
	}
	/**
	 * tests add incident
	 */
	@Test
	public void testAddIncident() {
		ArrayList<String> list = new ArrayList<String>();
		ServiceGroup sg = new ServiceGroup("sg");
		list.add("abc");
		Incident i1 = new Incident(3, "New", "title", "caller", 0, "Unowned", Incident.NO_STATUS, list);
		sg.addIncident(i1);
		assertEquals(i1.getId(), 3);
		Incident i2 = new Incident(7, "New", "title", "caller", 0, "Unowned", Incident.NO_STATUS, list);
		sg.addIncident(i2);
		assertEquals(i2.getId(), 7);
		Incident i3 = new Incident(5, "New", "title", "caller", 0, "Unowned", Incident.NO_STATUS, list);
		sg.addIncident(i3);
		assertEquals(i3.getId(), 5);
		Incident i4 = new Incident(2, "New", "title", "caller", 0, "Unowned", Incident.NO_STATUS, list);
		sg.addIncident(i4);
		assertEquals(i4.getId(), 2);
		Incident i5 = new Incident(4, "New", "title", "caller", 0, "Unowned", Incident.NO_STATUS, list);
		sg.addIncident(i5);
		assertEquals(i5.getId(), 4);
	}

}
