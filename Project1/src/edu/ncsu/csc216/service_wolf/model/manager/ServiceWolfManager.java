package edu.ncsu.csc216.service_wolf.model.manager;



import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupsReader;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;
/**
 * service group manager is an object with no fields that provides methods that work with service groups.
 * has a save to file and a load from file for servcie groups. a gett incidets as array for the GUI a get incident by id a delete incident by id
 * an add incident to service group and a clear service group. 
 * @author edwin
 *
 */
public class ServiceWolfManager {
	/** array list of service groups */
	private ArrayList<ServiceGroup> serviceGroups = new ArrayList<ServiceGroup>();
	/** the instance of the registration manager */
	private static ServiceWolfManager instance;
	/** current service group */
	private ServiceGroup currentServiceGroup;
	/**
	 * constructor for service wolf manager
	 */
	private ServiceWolfManager() {
		
	}
	/**
	 * gets the instance for service wolf manager 
	 * @return instance
	 */
	public static ServiceWolfManager getInstance() {
		if (instance == null) {
			instance = new ServiceWolfManager();
		}
		return instance;
	}
	/**
	 * saves to a file
	 * @param fileName file name
	 */
	public void saveToFile(String fileName) {
		
	}
	/**
	 * load from file name
	 * @param fileName file name
	 */
	public void loadFromFile(String fileName) {
		serviceGroups = ServiceGroupsReader.readServiceGroupsFile(fileName);
		currentServiceGroup = serviceGroups.get(0);
	}
	/**
	 * makes a 2d array containing fields for incident
	 * @return 2d string array
	 */
	public String[][] getIncidentsAsArray() {
		int a = currentServiceGroup.getIncidents().size();
		String[][] array = new String[a][4];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < array[a].length; i++) {
				if (j == 0) {
					array[i][0] = String.valueOf(currentServiceGroup.getIncidents().get(i).getId());
				}
				if (j == 1) {
					array[i][1] = currentServiceGroup.getIncidents().get(i).getState();
				}
				if (j == 2) {
					array[i][2] = currentServiceGroup.getIncidents().get(i).getTitle();
				}
				if (j == 3) {
					array[i][3] = currentServiceGroup.getIncidents().get(i).getStatusDetails();
				}
			}
		}
		return array;
	}
	/**
	 * returns incident specified by id
	 * @param id id
	 * @return Incident
	 */
	public Incident getIncidentById(int id) {
		Incident i = currentServiceGroup.getIncidentById(id);
		return i;
	}
	/**
	 * passes incident give by id and passes it to command
	 * @param id id 
	 * @param c command
	 */
	public void executeCommand(int id, Command c) {
		currentServiceGroup.executeCommand(id, c);
	}
	/**
	 * Deletes incident by specified id
	 * @param id id
	 */
	public void deleteIncidentById(int id) {
		currentServiceGroup.deleteIncidentById(id);
	}
	/**
	 * adds an incident to the current service group
	 * @param title title
	 * @param caller caller
	 * @param message message for log
	 */
	public void addIncidentToServiceGroup(String title, String caller, String message) {
		Incident i = new Incident(title, caller, message);
		currentServiceGroup.addIncident(i);
	}
	/**
	 * loads a service group
	 * @param name name
	 */
	public void loadServiceGroup(String name) {
		for (int i = 0; i < serviceGroups.size(); i++) {
			if (serviceGroups.get(i).getServiceGroupName().equals(name)) {
				currentServiceGroup = serviceGroups.get(i);
			}
		}
	}
	/**
	 * returns the service group name
	 * @return name
	 */
	public String getServiceGroupName() {
		return currentServiceGroup.getServiceGroupName();
	}
	/**
	 * returns a string array for the service groups
	 * @return string array
	 */
	public String[] getServiceGroupList() {
		String[] array = new String[serviceGroups.size()];
		for (int i = 0; i < serviceGroups.size(); i++) {
			array[i] = serviceGroups.get(i).getServiceGroupName();
		}
		
		return array;
	}
	/**
	 * clears all service groups
	 */
	public void clearServiceGroups() {
		serviceGroups = new ArrayList<ServiceGroup>();
	}
	/**
	 * edits the service group 
	 * @param temp temp
	 */
	public void editServiceGroup(String temp) {
		
	}
	/**
	 * adds service group to the list by its specified name
	 * @param sg Service group
	 */
	private void addServiceGroupToListByName(ServiceGroup sg) {
		for (int i = 0; i < serviceGroups.size(); i++) {
			if (serviceGroups.get(i).getServiceGroupName().compareToIgnoreCase(sg.getServiceGroupName()) > 0) {
				serviceGroups.add(i + 1, sg);
			}
			if (!serviceGroups.contains(sg)) {
				serviceGroups.add(0, sg);
			}
		}
	}
	/**
	 * adds a service  group with parameter name 
	 * @param name name
	 */
	public void addServiceGroup(String name) {
		ServiceGroup sg;
		checkDuplicateServiceName(name);
		sg = new ServiceGroup(name);
		addServiceGroupToListByName(sg);
		loadServiceGroup(name);
	}
	/**
	 * checks if passed name is already used for a service group of if null or empty.
	 * @param name name
	 * @throws Illegal Argument Exception if name is invalid
	 */
	private void checkDuplicateServiceName(String name) {
		if (name == null || "".equals(name)) {
			throw new IllegalArgumentException("Invalid servcie group name.");
		}
		for (int i = 0; i < serviceGroups.size(); i++) {
			if (serviceGroups.get(i).getServiceGroupName().compareToIgnoreCase(name) == 0) {
				throw new IllegalArgumentException("Invalid servcie group name.");
			}
		}
	}
	/**
	 * Deletes the service group updates current service group to null if non left or the one at the 
	 * first spot in the list of service groups
	 * @throws IllegalArgumentException if no service group is selected
	 */
	public void deleteServiceGroup() {
		if (currentServiceGroup == null) {
			throw new IllegalArgumentException("No service group selected.");
		}
		serviceGroups.remove(currentServiceGroup);
		if (serviceGroups.size() < 1) {
			currentServiceGroup = null;
		}
		else {
			currentServiceGroup = serviceGroups.get(0);
		}
	}
	/**
	 * Resets the manager
	 */
	protected void resetManager() {
		serviceGroups = new ArrayList<ServiceGroup>();
	}
}
