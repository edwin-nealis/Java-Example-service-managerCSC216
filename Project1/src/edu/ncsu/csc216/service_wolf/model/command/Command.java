package edu.ncsu.csc216.service_wolf.model.command;

public class Command {
	private String commandInformation;
	private String commandMessage;
	/**
	 * constructor for command
	 * @param cv
	 * @param commandInformation
	 */
	public Command(CommandValue cv, String commandInformation, String commandMessage) {
		
	}
	/**
	 * Returns the command
	 * @return
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
