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
	public static final String CANCELLATION_NOT_AN_INCIDENT = "Not a Incident";
	/** Caller canceled message */
	public static final String CANCELLATION_CALLER_CANCELLED = "Caller Canceled";
	/** unowned message */
	public static final String UNOWNED = "Unowned";
	/** no status message */
	public static final String NO_STATUS = "No Status";
	/** counter */
	private static int counter = 0;
	
	/**
	 * constructor for incident 
	 * @param title
	 * @param caller
	 * @param message
	 */
	public Incident(String title, String caller, String message) {
		setTitle(title);
		setCaller(caller);
	}
	/**
	 * constructor for incident with full fields
	 * @param id
	 * @param state
	 * @param title
	 * @param caller
	 * @param reopenCount
	 * @param owner
	 * @param statusDetails
	 * @param incidentLog
	 */
	public Incident(int id, String state, String title, String caller, int reopenCount, String owner, String statusDetails, ArrayList<String>incidentLog) {
		setId(id);
		setState(state);
		setTitle(title);
		setCaller(caller);
		setReopenCount(reopenCount);
		setOwner(owner);
		setStatusDetails(statusDetails);
		
	}
	/** sets Id value 
	 * 
	 */
	private void setId(int id) {
		
	}
	/** 
	 * returns id 
	 * @return id 
	 */
	public int getId() {
		return 0;
	}
	/** sets state 
	 * 
	 */
	private void setState(String state) {
		
	}
	/** 
	 * returns state 
	 * @return state 
	 */
	public String getState() {
		return null;
	}
	/**
	 * sets title
	 */
	private void setTitle(String title) {
		
	}
	/** 
	 * returns title 
	 * @return title 
	 */
	public String getTitle() {
		return null;
	}
	/** 
	 * sets caller 
	 */
	private void setCaller(String caller) {
	
	}
	/** 
	 * return caller 
	 * @return caller 
	 */
	public String getCaller() {
		return null;
	}
	/** 
	 * sets reopen count 
	 */
	private void setReopenCount(int reopenCount) {
		
	}
	/** 
	 * returns reopen count 
	 * @return reopenCount 
	 */
	public int getReopenCount() {
		return 0;
	}
	/** 
	 * sets owner  
	 */
	private void setOwner(String owner) {
		
	}
	/** 
	 * returns owner 
	 * @return owner
	 */
	public String getOwner() {
		return null;
	}
	/** 
	 * sets status details 
	 */
	private void setStatusDetails(String statusDetails) {
		
	}
	/** 
	 * returns status details 
	 * @return statusDetails 
	 */
	public String getStatusDetails() {
		return null;
	}
	/** 
	 * adds message to incident log 
	 * @return number   
	 */
	private int addMessageToIncidentLog(String message) {
		return 0;
	}
	/** 
	 * increments counter 
	 */
	public static void incrementCounter() {
		
	}
	/** 
	 * sets counter 
	 */
	public static void setCounter(int counter) {

	}
	/** 
	 * returns incident log messages 
	 * @return messages
	 */
	public String getIncidentLogMessages() {
		return null;
	}
	/** 
	 * makes fields into string
	 * @return string
	 */
	@Override
	public String toString() {
		return "Incident [incidentId=" + incidentId + ", title=" + title + ", caller=" + caller + ", reopenCount="
				+ reopenCount + ", owner=" + owner + ", statusDetails=" + statusDetails + ", incidentLog=" + incidentLog
				+ "]";
	}
	/**
	 * updates command
	 */
	public void update(Command c) {
		 
	}
	/**
	 * inner calls that defines the InProgressState contains
	 * a constructor a method to update the state and a getter.
	 * @author Edwin Nealis
	 *
	 */
	public class InProgressState {
		/**
		 * Constructor for InProgress State
		 */
		private InProgressState() {
			
		}
		/**
		 * updates state 
		 */
		public void updateState(Command c) {
			
		}
		/**
		 * returns state name
		 * @return stateName
		 */
		public String getStateName() {
			return null;
		}
	}
	/**
	 * inner calls that defines the canceled state contains
	 * a constructor a method to update the state and a getter.
	 * @author Edwin Nealis
	 *
	 */
	public class CanceledState {
		/**
		 * Constructor for Canceled State
		 */
		private CanceledState() {
			
		}
		/**
		 * updates state 
		 */
		public void updateState(Command c) {
			
		}
		/**
		 * returns state name
		 * @return stateName
		 */
		public String getStateName() {
			return null;
		}
	}
	/**
	 * inner calls that defines the OnHoldState contains
	 * a constructor a method to update the state and a getter.
	 * @author Edwin Nealis
	 *
	 */
	public class OnHoldState {
		/**
		 * Constructor for On hold State
		 */
		private OnHoldState() {
			
		}
		/**
		 * updates state 
		 */
		public void updateState(Command c) {
			
		}
		/**
		 * returns state name
		 * @return stateName
		 */
		public String getStateName() {
			return null;
		}
	}
	/**
	 * inner calls that defines the ResolvedState contains
	 * a constructor a method to update the state and a getter.
	 * @author Edwin Nealis
	 *
	 */
	public class ResolvedState {
		/**
		 * Constructor for resolved State
		 */
		private ResolvedState() {
			
		}
		/**
		 * updates state 
		 */
		public void updateState(Command c) {
			
		}
		/**
		 * returns state name
		 * @return stateName
		 */
		public String getStateName() {
			return null;
		}
	}
	/**
	 * inner calls that defines the NewState contains
	 * a constructor a method to update the state and a getter.
	 * @author Edwin Nealis
	 *
	 */
	public class NewState {
		/**
		 * Constructor for new State
		 */
		private NewState() {
			
		}
		/**
		 * updates state 
		 */
		public void updateState(Command c) {
			
		}
		/**
		 * returns state name
		 * @return stateName
		 */
		public String getStateName() {
			return null;
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
