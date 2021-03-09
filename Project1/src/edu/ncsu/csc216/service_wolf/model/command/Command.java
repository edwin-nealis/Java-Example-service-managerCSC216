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
	/** holds command value */
	private CommandValue cv;
	/**
	 * constructor for command
	 * @param cv command value
	 * @param commandInformation command info
	 * @param commandMessage message for command
	 */
	public Command(CommandValue cv, String commandInformation, String commandMessage) {
		if (cv == null) {
			throw new IllegalArgumentException();
		}
		if (commandMessage == null || "".equals(commandMessage)) {
			throw new IllegalArgumentException();
		}
		if ((cv == Command.CommandValue.ASSIGN || cv == Command.CommandValue.HOLD || cv == Command.CommandValue.RESOLVE || cv == Command.CommandValue.CANCEL) && (commandInformation == null || "".equals(commandInformation)) ) {
			throw new IllegalArgumentException();
		}
		if ((cv == Command.CommandValue.INVESTIGATE || cv == Command.CommandValue.REOPEN) && commandInformation != null) {
			throw new IllegalArgumentException();
		}
		this.commandInformation = commandInformation;
		this.commandMessage = commandMessage;
		this.cv = cv;
		
	}
	/**
	 * Returns the command
	 * @return command value
	 */
	public CommandValue getCommand() {
		return cv;
	}
	/**
	 * returns the command information 
	 * @return string
	 */
	public String getCommandInformation() {
		return commandInformation;
	}
	/**
	 * returns the command message
	 * @return string
	 */
	public String getCommandMessage() {
		return commandMessage;
	}
	/**
	 * enum with values assign, hold, investigate, resolve, reopen, and cancel.
	 * @author Edwin Nealis
	 *
	 */
	public enum CommandValue { ASSIGN, HOLD, INVESTIGATE, RESOLVE, REOPEN, CANCEL }
	
}
