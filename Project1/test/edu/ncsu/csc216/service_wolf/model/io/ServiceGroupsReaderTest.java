package edu.ncsu.csc216.service_wolf.model.io;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * test service group reader class
 * @author edwin
 *
 */
public class ServiceGroupsReaderTest {
	/** export file path */
	private final String export = "test-files/export.txt";
	/** valid file path */
	private final String validFile = "test-files/incidents1.txt";
	/** expected for valid incident CSC IT 2*/
	private final String cscIt2 = "* 2,Canceled,Piazza,sesmith5,0,Unowned,Not an Incident\n- Set up piazza for Spring 2021\n- Canceled; not an NC State IT service\n";
	/** expected for valid incident CSC IT 3*/
	private final String cscIt3 = "* 3,New,Moodle down,sesmith5,0,Unowned,No Status\n- When I go to wolfware.ncsu.edu, I get a 500 error\n";
	/** expected for valid incident CSC IT 4*/
	private final String cscIt4 = "* 4,Resolved,Set up Jenkins VMs,sesmith5,1,cgurley,Permanently Solved\n"
			+ "- Please set up Jenkins VMs for Spring 2021 semester.\n"
			+ "- Assigned to C. Gurley\n"
			+ "- Set up test VM. Awaiting verification from caller.\n"
			+ "- VM works great, please deploy the rest.\n"
			+ "- VMs deployed. Marked resolved.\n"
			+ "- One of the VMs has the wrong version of Checkstyle installed.\n"
			+ "- Updated version of Checkstyle.\n";
	/** expected for valid incident CSC IT 9*/
	private final String cscIt9 = "* 9,In Progress,Jenkins behind firewall,sesmith5,0,cgurley,No Status\n"
			+ "- Jenkins requires VPN to access.  Please open to general access.\n"
			+ "- Assigned to C. Gurley\n";
	/** expected for valid incident OIT*/
	private final String oit = "* 1,In Progress,Forgot password,jctetter,0,oit_staff,No Status\n- I forgot my password and can't log into NC State accounts\n- OIT staff member on call with support\n";
	/** expected for valid incident ITECS 7*/
	private final String itecs = "* 7,On Hold,Java not installed correctly,zmgrosec,0,itecs1,Awaiting Caller\n"
			+ "- I can't install Java on my computer.\n"
			+ "- Assigned to itecs1\n"
			+ "- Awaiting caller's feedback on attempting to install Java from Oracle\n";
	/**
	 * test service group reader method
	 */
	@Test
	public void testServiceGroupReaderValid() {
			ArrayList<ServiceGroup> sg = ServiceGroupsReader.readServiceGroupsFile(validFile);
			assertEquals(3, sg.size());
			assertEquals(sg.get(0).getIncidents().get(0).toString(), cscIt2);
			assertEquals(sg.get(0).getIncidents().get(1).toString(), cscIt3);
			assertEquals(sg.get(0).getIncidents().get(2).toString(), cscIt4);
			assertEquals(sg.get(0).getIncidents().get(3).toString(), cscIt9);
			assertEquals(sg.get(2).getIncidents().get(0).toString(), oit);
			assertEquals(sg.get(1).getIncidents().get(0).toString(), itecs);

	}
	@Test
	public void testServiceGroupReaderInValid() {
		ArrayList<ServiceGroup> sg = null;
		for (int i = 6; i < 28; i++) {
			try {
				sg = ServiceGroupsReader.readServiceGroupsFile("test-files/incidents" + i + ".txt");
				fail("incidents " + i + " failed");
			}
			catch (IllegalArgumentException e) {
				assertNull(sg);
			}
		}
	}
		
}
