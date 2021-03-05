package edu.ncsu.csc216.service_wolf.model.command;
/**
 * Command provides function to help change states it conatisn an enum
 * @author edwin
 *
 */
public class Command {
	/** holds command information */
	private String commandInformation;
	/** holds command message */
	private String commandMessage;
	/**
	 * constructor for command
	 * @param cv command value
	 * @param commandInformation command info
	 * @param commandMessage message for command
	 */
	public Command(CommandValue cv, String commandInformation, String commandMessage) {
		
	}
	/**
	 * Returns the command
	 * @return command value
	 */
	public CommandValue getCommand() {
		return null;
	}
	/**
	 * returns the command information 
	 * @return string
	 */
	public String getCommandInformation() {
		return null;
	}
	/**
	 * returns the command message
	 * @return string
	 */
	public String getCommandMessage() {
		return null;
	}
	/**
	 * enum with values assign, hold, investigate, resolve, reopen, and cancel.
	 * @author Edwin Nealis
	 *
	 */
	public enum CommandValue { ASSIGN, HOLD, INVESTIGATE, RESOLVE, REOPEN, CANCEL }
	
}
