package edu.ncsu.csc216.service_wolf.model.incident;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.command.Command;
/**
 * tests the incindent class
 * @author edwin
 *
 */
public class IncidentTest {
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
	 * tests the Incident constructor
	 */
	@Test
	public void testIncident() {
		Incident i1 = new Incident("title", "caller", "message");
		Incident i2;
		Incident i3;
		Incident i4;
		i2 = null;
		try {
			i2 = new Incident(null, "caller", "message");
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(i2);
		}
		i3 = null;
		try {
			i3 = new Incident("title", null, "message");
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(i3);
		}
		i4 = null;
		try {
			i4 = new Incident("title", "caller", null);
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(i4);
		}
		
		assertEquals(i1.getTitle(), "title");
		assertEquals(i1.getCaller(), "caller");
		assertEquals(i1.getState(), "New");
		assertEquals(i1.getOwner(), "Unowned");
		assertEquals(i1.getId(), 1);
		ArrayList<String> list = new ArrayList<String>();
		list.add("abc");
		Incident i5 = new Incident(1, "New", "title", "caller", 0, "Unowned", Incident.NO_STATUS, list);
		assertEquals(i5.getId(), 1);
		assertEquals(i5.getState(), "New");
		assertEquals(i5.getTitle(), "title");
		assertEquals(i5.getCaller(), "caller");
		assertEquals(i5.getReopenCount(), 0);
		assertEquals(i5.getOwner(), "Unowned");
		assertEquals(i5.getStatusDetails(), Incident.NO_STATUS);
		assertEquals(i5.getIncidentLogMessages(), "- abc\n");
		
	}
	/**
	 * tests going trough the fsm with all valid commands goes through all states
	 */
	@Test
	public void testIncidentState() {
		Incident i1 = new Incident("title", "caller", "message");
		assertEquals(i1.getState(), "New");
		Command c = new Command(Command.CommandValue.ASSIGN, "info", "message");
		i1.update(c);
		assertEquals(i1.getState(), Incident.IN_PROGRESS_NAME);
		assertEquals(i1.getOwner(), "info");
		Command c2 = new Command(Command.CommandValue.RESOLVE, "Permanently Solved", "message");
		i1.update(c2);
		assertEquals(i1.getState(), Incident.RESOLVED_NAME);
		assertEquals(i1.getStatusDetails(), "Permanently Solved");
		Command c3 = new Command(Command.CommandValue.REOPEN, null, "message1");
		i1.update(c3);
		assertEquals(i1.getState(), Incident.IN_PROGRESS_NAME);
		assertEquals(i1.getStatusDetails(), Incident.NO_STATUS);
		Command c4 = new Command(Command.CommandValue.HOLD, "Awaiting Caller", "message1");
		i1.update(c4);
		assertEquals(i1.getState(), Incident.ON_HOLD_NAME);
		assertEquals(i1.getStatusDetails(), "Awaiting Caller");
		Command c5 = new Command(Command.CommandValue.INVESTIGATE, null, "message1");
		i1.update(c5);
		assertEquals(i1.getState(), Incident.IN_PROGRESS_NAME);
		assertEquals(i1.getStatusDetails(), Incident.NO_STATUS);
		
		
	}
	/**
	 * tests the resolved state with transition in and out
	 */
	@Test
	public void testStateTransitionResolved() {
		Incident i1 = new Incident("title", "caller", "message");
		assertEquals(i1.getState(), "New");
		assertEquals(i1.getOwner(), Incident.UNOWNED);
		Command c = new Command(Command.CommandValue.ASSIGN, "info", "message");
		i1.update(c);
		assertEquals(i1.getState(), Incident.IN_PROGRESS_NAME);
		assertEquals(i1.getOwner(), "info");
		Command c2 = new Command(Command.CommandValue.RESOLVE, "Permanently Solved", "message");
		i1.update(c2);
		assertEquals(i1.getState(), Incident.RESOLVED_NAME);
		assertEquals(i1.getStatusDetails(), "Permanently Solved");
		Command c3 = new Command(Command.CommandValue.CANCEL, Incident.CANCELLATION_DUPLICATE, "message");
		i1.update(c3);
		assertEquals(i1.getState(), Incident.CANCELED_NAME);
		assertEquals(i1.getStatusDetails(), Incident.CANCELLATION_DUPLICATE);
		assertEquals(i1.getOwner(), Incident.UNOWNED);
		
	}
	/**
	 * test transition in and out of inprogress state
	 */
	@Test 
	public void testStateTransitionInProgress() {
		Incident i1 = new Incident("title", "caller", "message");
		assertEquals(i1.getState(), "New");
		Command c = new Command(Command.CommandValue.ASSIGN, "info", "message");
		i1.update(c);
		assertEquals(i1.getState(), Incident.IN_PROGRESS_NAME);
		assertEquals(i1.getOwner(), "info");
		Command c2 = new Command(Command.CommandValue.CANCEL, Incident.CANCELLATION_CALLER_CANCELLED, "message");
		i1.update(c2);
		assertEquals(i1.getState(), Incident.CANCELED_NAME);
		assertEquals(i1.getStatusDetails(), Incident.CANCELLATION_CALLER_CANCELLED);
		assertEquals(i1.getOwner(), Incident.UNOWNED);
		
	}
	/**
	 * tests transition in and out of new state
	 */
	@Test
	public void testStateTransitionNew() {
		Incident i1 = new Incident("title", "caller", "message");
		assertEquals(i1.getState(), "New");
		Command c1 = new Command(Command.CommandValue.CANCEL, Incident.CANCELLATION_CALLER_CANCELLED, "message");
		i1.update(c1);
		assertEquals(i1.getState(), Incident.CANCELED_NAME);
		assertEquals(i1.getStatusDetails(), Incident.CANCELLATION_CALLER_CANCELLED);
		assertEquals(i1.getOwner(), Incident.UNOWNED);
	}

	

}
