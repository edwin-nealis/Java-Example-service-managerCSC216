package edu.ncsu.csc216.service_wolf.model.incident;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;

/**
 * Incident is a class that creates an object with fields incidentId, title, caller, 
 * reopenCount, owner, statusDetails, and incidentLog. with incident log being an array list
 * this class has two constructors one with all fields one with just title owner and a message for the log.
 *  class also has all getters and setters for fields 
 *  this class also implements the interface state and holds several inner class New, In
 *  progress, On Hold, Resolver and Cancaled for this implementaion.
 * @author Edwin Nealis
 *
 */
public class Incident {
	/** Id for incident */
	private int incidentId;
	/** holds incidents title */
	private String title;
	/** holds incidents caller */
	private String caller;
	/** number of times incident reopened */
	private int reopenCount;
	/** holds owner of incident */
	private String owner;
	/** holds status details */
	private String statusDetails;
	/** holds incident log */
	private ArrayList<String> incidentLog;
	/** state name new */
	public static final String NEW_NAME = "New";
	/** state name in progress */
	public static final String IN_PROGRESS_NAME = "In Progress";
	/** state name on hold */
	public static final String ON_HOLD_NAME = "On Hold";
	/** state name Resolver */
	public static final String RESOLVED_NAME = "Resolved";
	/** state name canceled */
	public static final String CANCELED_NAME = "Canceled";
	/** Awaiting Caller message */
	public static final String HOLD_AWAITING_CALLER = "Awaiting Caller";
	/** Awaiting Change message */
	public static final String HOLD_AWAITING_CHANGE = "Awaiting Change";
	/** Awaiting Vendor message */
	public static final String HOLD_AWAITING_VENDOR = "Awaiting Vendor";
	/** Permanently solved message */
	public static final String RESOLUTION_PERMANENTLY_SOLVED = "Permanently Solved";
	/** Workaround message */
	public static final String RESOLUTION_WORKAROUND = "Workaround";
	/** CAller Closed message */
	public static final String RESOLUTION_CALLER_CLOSED = "Caller Closed";
	/** duplicate message */
	public static final String CANCELLATION_DUPLICATE = "Duplicate";
	/** unnecessary message */
	public static final String CANCELLATION_UNNECESSARY = "Unnecessry";
	/** not a incident message */
	public static final String CANCELLATION_NOT_AN_INCIDENT = "Not an Incident";
	/** Caller canceled message */
	public static final String CANCELLATION_CALLER_CANCELLED = "Caller Canceled";
	/** unowned message */
	public static final String UNOWNED = "Unowned";
	/** no status message */
	public static final String NO_STATUS = "No Status";
	/** counter */
	private static int counter = 1;
	/** holds state */
	private final IncidentState newState = new NewState();
	/** on hold state */
	private final IncidentState onHold = new OnHoldState();
	/** resolved state */
	private final IncidentState resolved = new ResolvedState();
	/** canceled state */
	private final IncidentState canceled = new CanceledState();
	/** in progess state */
	private final IncidentState inProgress = new InProgressState();
	/** holds state */
	private IncidentState state;
	/**
	 * constructor for incident sets id to one more than counter adds messge to messagelog.
	 * sets status to No status and owener to unowned.
	 * @param title title of incident 
	 * @param caller caller 
	 * @param message log message
	 */
	public Incident(String title, String caller, String message) {
		setTitle(title);
		setCaller(caller);
		incidentLog = new ArrayList<String>();
		addMessageToIncidentLog(message);
		setId(counter);
		Incident.incrementCounter();
		setOwner(UNOWNED);
		setStatusDetails(NO_STATUS);
		setState(NEW_NAME);
		
	}
	/**
	 * constructor for incident with full fields
	 * @param id id
	 * @param state state 
	 * @param title title
	 * @param caller caller 
	 * @param reopenCount num of times re opened
	 * @param owner owner
	 * @param statusDetails status details
	 * @param incidentLog incident log
	 */
	public Incident(int id, String state, String title, String caller, int reopenCount, String owner, String statusDetails, ArrayList<String> incidentLog) {
		setId(id);
		setTitle(title);
		setCaller(caller);
		setReopenCount(reopenCount);
		setOwner(owner);
		setStatusDetails(statusDetails);
		if (id > Incident.counter) {
			setCounter(id);
		}
		setState(state);
		if (incidentLog.isEmpty()) {
			throw new IllegalArgumentException("Incident cannot be created");
		}
		else {
			this.incidentLog = incidentLog;
		}
	}
	/** 
	 * sets Id value 
	 * @param id id
	 */
	private void setId(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("Incident cannot be created");
		}
		this.incidentId = id;
	}
	/** 
	 * returns id 
	 * @return id 
	 */
	public int getId() {
		return incidentId;
	}
	/** 
	 * sets state 
	 * @param state state
	 */
	private void setState(String state) {
		if (state.equals(NEW_NAME) && owner.equals(UNOWNED) && statusDetails.equals(NO_STATUS)) {
			this.state = newState;
		}
		else if (state.equals(CANCELED_NAME) && owner.equals(UNOWNED) && (statusDetails.equals(CANCELLATION_CALLER_CANCELLED) || statusDetails.equals(CANCELLATION_DUPLICATE) || statusDetails.equals(CANCELLATION_NOT_AN_INCIDENT) || statusDetails.equals(CANCELLATION_UNNECESSARY))) {
			this.state = canceled;
		}
		else if (state.equals(IN_PROGRESS_NAME) && statusDetails.equals(NO_STATUS) && !owner.equals(UNOWNED)) {
			this.state = inProgress;
		}
		else if (state.equals(ON_HOLD_NAME) && !owner.equals(UNOWNED) && (statusDetails.equals(HOLD_AWAITING_CALLER) || statusDetails.equals(HOLD_AWAITING_CHANGE) || statusDetails.equals(HOLD_AWAITING_VENDOR))) {
			this.state = onHold;
		}
		else if (state.equals(RESOLVED_NAME) && !owner.equals(UNOWNED) && (statusDetails.equals(RESOLUTION_PERMANENTLY_SOLVED) || statusDetails.equals(RESOLUTION_WORKAROUND) || statusDetails.equals(RESOLUTION_CALLER_CLOSED))) {
			this.state = resolved;
		}
		else {
			throw new IllegalArgumentException("Incident cannot be created");
		}
	}
	/** 
	 * returns state 
	 * @return state 
	 */
	public String getState() {
		return state.getStateName();
	}
	/**
	 * sets title
	 * @param title title
	 */
	private void setTitle(String title) {
		if (title == null || "".equals(title)) {
			throw new IllegalArgumentException("Incident cannot be created");
		}
		this.title = title;
	}
	/** 
	 * returns title 
	 * @return title 
	 */
	public String getTitle() {
		return title;
	}
	/** 
	 * sets caller 
	 * @param caller caller
	 */
	private void setCaller(String caller) {
		if (caller == null || "".equals(caller)) {
			throw new IllegalArgumentException("Incident cannot be created");
		}
		this.caller = caller;
	}
	/** 
	 * return caller 
	 * @return caller 
	 */
	public String getCaller() {
		return caller;
	}
	/** 
	 * sets reopen count 
	 * @param reopenCount num time reopned
	 */
	private void setReopenCount(int reopenCount) {
		if (reopenCount < 0) {
			throw new IllegalArgumentException("Incident cannot be created");
		}
		this.reopenCount = reopenCount;
	}
	/** 
	 * returns reopen count 
	 * @return reopenCount 
	 */
	public int getReopenCount() {
		return reopenCount;
	}
	/** 
	 * sets owner 
	 * @param owner owner
	 */
	private void setOwner(String owner) {
		if (owner == null || "".equals(owner)) {
			throw new IllegalArgumentException("Incident cannot be created");
		}
		this.owner = owner;
	}
	/** 
	 * returns owner 
	 * @return owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * sets StatusDetails
	 * @param statusDetails status details
	 */
	private void setStatusDetails(String statusDetails) {
		if (statusDetails == null || "".equals(statusDetails)) {
			throw new IllegalArgumentException();
		}
		this.statusDetails = statusDetails;
	}
	/** 
	 * returns status details 
	 * @return statusDetails 
	 */
	public String getStatusDetails() {
		return statusDetails;
	}
	/** 
	 * adds message to incident log 
	 * @param message message
	 * @return index of incident message was added to
	 */
	private int addMessageToIncidentLog(String message) {
		if (message == null || "".equals(message)) {
			throw new IllegalArgumentException("Incident cannot be created");
		}
		incidentLog.add(message);
		return incidentLog.indexOf(message);
	}
	/** 
	 * increments counter 
	 */
	public static void incrementCounter() {
		Incident.counter = Incident.counter + 1;
	}
	/** 
	 * sets counter 
	 * @param counter counter
	 */
	public static void setCounter(int counter) {
		Incident.counter = counter;
	}
	/** 
	 * returns incident log messages 
	 * @return messages
	 */
	public String getIncidentLogMessages() {
		String logMessages = "";
		for (int i = 0; i < incidentLog.size(); i++) {
			logMessages += "- " + incidentLog.get(i) + "\n";
		}
		return logMessages;
	}
	/** 
	 * makes fields into string
	 * @return string
	 */
	@Override
	public String toString() {
		return "* " + incidentId + "," + getState() + "," + title + "," + caller + ","
				+ reopenCount + "," + owner + "," + statusDetails + "\n" + getIncidentLogMessages();
	}
	/**
	 * updates command
	 * @param c command
	 * @throws UnsupportedOperationException
	 */
	public void update(Command c) {
		state.updateState(c);
		addMessageToIncidentLog(c.getCommandMessage());
	}
	/**
	 * inner calls that defines the InProgressState contains
	 * a constructor a method to update the state and a getter.
	 * @author Edwin Nealis
	 *
	 */
	public class InProgressState implements IncidentState{
		/**
		 * Constructor for InProgress State
		 */
		private InProgressState() {
			
		}
		/**
		 * updates state 
		 * @param c command
		 * @throws UnsupportedOperationException if command is invalid
		 */
		public void updateState(Command c) {
			if (c.getCommand() == Command.CommandValue.HOLD && (c.getCommandInformation().equals(HOLD_AWAITING_CALLER) || c.getCommandInformation().equals(HOLD_AWAITING_CHANGE) || c.getCommandInformation().equals(HOLD_AWAITING_VENDOR))) {
				state = onHold;
				setStatusDetails(c.getCommandInformation());
			}
			else if (c.getCommand() == Command.CommandValue.RESOLVE && (c.getCommandInformation().equals(RESOLUTION_CALLER_CLOSED) || c.getCommandInformation().equals(RESOLUTION_PERMANENTLY_SOLVED) || c.getCommandInformation().equals(RESOLUTION_WORKAROUND))) {
				state = resolved;
				setStatusDetails(c.getCommandInformation());
			}
			else if (c.getCommand() == Command.CommandValue.ASSIGN) {
				setOwner(c.getCommandInformation());
			}
			else if (c.getCommand() == Command.CommandValue.CANCEL && (c.getCommandInformation().equals(CANCELLATION_CALLER_CANCELLED) || c.getCommandInformation().equals(CANCELLATION_DUPLICATE) || c.getCommandInformation().equals(CANCELLATION_NOT_AN_INCIDENT) || c.getCommandInformation().equals(HOLD_AWAITING_VENDOR))) {
				state = canceled;
				setOwner(UNOWNED);
				setStatusDetails(c.getCommandInformation());
			}
			else {
				throw new UnsupportedOperationException();
			}
			
		}
		/**
		 * returns state name
		 * @return stateName
		 */
		public String getStateName() {
			return IN_PROGRESS_NAME;
		}
	}
	/**
	 * inner calls that defines the canceled state contains
	 * a constructor a method to update the state and a getter.
	 * @author Edwin Nealis
	 *
	 */
	public class CanceledState implements IncidentState{
		/**
		 * Constructor for Canceled State
		 */
		private CanceledState() {
			
		}
		/**
		 * updates state always throws if called
		 * @param c command
		 * @throws UnsupportedOperationException if called
		 */
		public void updateState(Command c) {
			throw new UnsupportedOperationException();
		}
		/**
		 * returns state name
		 * @return stateName
		 */
		public String getStateName() {
			return CANCELED_NAME;
		}
	}
	/**
	 * inner calls that defines the OnHoldState contains
	 * a constructor a method to update the state and a getter.
	 * @author Edwin Nealis
	 *
	 */
	public class OnHoldState implements IncidentState{
		/**
		 * Constructor for On hold State
		 */
		private OnHoldState() {
			
		}
		/**
		 * updates state 
		 * @param c command
		 */
		public void updateState(Command c) {
			if (c.getCommand() == Command.CommandValue.INVESTIGATE) {
				setStatusDetails(Incident.NO_STATUS);
				state = inProgress;
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
		/**
		 * returns state name
		 * @return stateName
		 */
		public String getStateName() {
			return ON_HOLD_NAME;
		}
	}
	/**
	 * inner calls that defines the ResolvedState contains
	 * a constructor a method to update the state and a getter.
	 * @author Edwin Nealis
	 *
	 */
	public class ResolvedState implements IncidentState {
		/**
		 * Constructor for resolved State
		 */
		private ResolvedState() {
			
		}
		/**
		 * updates state 
		 * @param c command
		 */
		public void updateState(Command c) {
			if (c.getCommand() == Command.CommandValue.REOPEN) {
				setReopenCount(getReopenCount() + 1);
				state = inProgress;
				setStatusDetails(Incident.NO_STATUS);
			}
			else if (c.getCommand() == Command.CommandValue.CANCEL && (c.getCommandInformation().equals(CANCELLATION_CALLER_CANCELLED) || c.getCommandInformation().equals(CANCELLATION_DUPLICATE) || c.getCommandInformation().equals(CANCELLATION_NOT_AN_INCIDENT) || c.getCommandInformation().equals(HOLD_AWAITING_VENDOR))) {
				state = canceled;
				incidentLog.remove(incidentLog.size() - 1);
				setOwner(UNOWNED);
				setStatusDetails(c.getCommandInformation());
			}
			else {
				throw new UnsupportedOperationException();
			}
			
		}
		/**
		 * returns state name
		 * @return stateName
		 */
		public String getStateName() {
			return RESOLVED_NAME;
		}
	}
	/**
	 * inner calls that defines the NewState contains
	 * a constructor a method to update the state and a getter.
	 * @author Edwin Nealis
	 *
	 */
	public class NewState implements IncidentState {
		/**
		 * Constructor for new State
		 */
		private NewState() {
			
		}
		/**
		 * updates state 
		 * @param c command
		 */
		public void updateState(Command c) {
			if (c.getCommand() == Command.CommandValue.CANCEL && (c.getCommandInformation().equals(CANCELLATION_CALLER_CANCELLED) || c.getCommandInformation().equals(CANCELLATION_DUPLICATE) || c.getCommandInformation().equals(CANCELLATION_NOT_AN_INCIDENT) || c.getCommandInformation().equals(HOLD_AWAITING_VENDOR))) {
				state = canceled;
				setOwner(UNOWNED);
				setStatusDetails(c.getCommandInformation());
			}
			else if (c.getCommand() == Command.CommandValue.ASSIGN) {
				setOwner(c.getCommandInformation());
				state = inProgress;
			}
			else if (c.getCommand() == Command.CommandValue.INVESTIGATE) {
				state = inProgress;
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
		/**
		 * returns state name
		 * @return stateName
		 */
		public String getStateName() {
			return NEW_NAME;
		}
	}
	/**
	 * Interface for states in the Incident State Pattern.  All 
	 * concrete incident states must implement the IncidentState interface.
	 * The IncidentState interface should be a private interface of the 
	 * Incident class.
	 * 
	 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu) 
	 */
	private interface IncidentState {
		
		/**
		 * Update the Incident based on the given Command.
		 * An UnsupportedOperationException is thrown if the Command
		 * is not a valid action for the given state.  
		 * @param command Command describing the action that will update the Incident's
		 * state.
		 * @throws UnsupportedOperationException if the Command is not a valid action
		 * for the given state.
		 */
		void updateState(Command command);
		
		/**
		 * Returns the name of the current state as a String.
		 * @return the name of the current state as a String.
		 */
		String getStateName();
			
	}
	
}
