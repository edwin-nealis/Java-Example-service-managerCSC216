/**
 * 
 */
package edu.ncsu.csc216.service_wolf.model.command;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * tests command methods
 * @author edwin
 *
 */
public class CommandTest {

	/**
	 * Test method for Command
	 */
	@Test
	public void testCommand() {
		Command c1 = null;
		try {
			c1 = new Command(Command.CommandValue.HOLD, null, "message");
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(c1);
		}
		try {
			c1 = new Command(Command.CommandValue.INVESTIGATE, "not null", "message");
			fail();
		}
		catch (IllegalArgumentException e) {
			assertNull(c1);
		}
		Command c2 = new Command(Command.CommandValue.INVESTIGATE, null, "message");
		assertEquals(c2.getCommand(), Command.CommandValue.INVESTIGATE);
		assertNull(c2.getCommandInformation());
		assertTrue(c2.getCommandMessage().equals("message"));
	}

}
