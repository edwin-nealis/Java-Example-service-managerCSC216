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

}
