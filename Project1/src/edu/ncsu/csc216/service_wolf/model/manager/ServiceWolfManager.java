package edu.ncsu.csc216.service_wolf.model.manager;

import java.util.ArrayList;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupWriter;
import edu.ncsu.csc216.service_wolf.model.io.ServiceGroupsReader;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

/**
 * service group manager is an object with no fields that provides methods that
 * work with service groups. has a save to file and a load from file for servcie
 * groups. a gett incidets as array for the GUI a get incident by id a delete
 * incident by id an add incident to service group and a clear service group.
 * 
 * @author edwin
 *
 */
public class ServiceWolfManager {
	/** array list of service groups */
	private ArrayList<ServiceGroup> serviceGroups;
	/** the instance of the registration manager */
	private static ServiceWolfManager instance;
	/** current service group */
	private ServiceGroup currentServiceGroup;

	/**
	 * constructor for service wolf manager
	 */
	private ServiceWolfManager() {
		serviceGroups = new ArrayList<ServiceGroup>();
		currentServiceGroup = null;
	}

	/**
	 * gets the instance for service wolf manager
	 * 
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
	 * 
	 * @param fileName file name
	 * @throws IllegalArgumetnException if currentServiceGroup is null or has no incidents
	 */
	public void saveToFile(String fileName) {
		if (currentServiceGroup == null || currentServiceGroup.getIncidents().size() == 0) {
			throw new IllegalArgumentException("Unable to save file.");
		}
		ServiceGroupWriter.writeServiceGroupsToFile(fileName, serviceGroups);
	}

	/**
	 * load service groups from file name and sort by name
	 * 
	 * @param fileName file name
	 */
	public void loadFromFile(String fileName) {
		ArrayList<ServiceGroup> sg = ServiceGroupsReader.readServiceGroupsFile(fileName);
		currentServiceGroup = sg.get(0);
		for (int j = 0; j < sg.size(); j++) {
				for (int i = 0; i < serviceGroups.size(); i++) {
					if (serviceGroups.get(i).getServiceGroupName().compareToIgnoreCase(sg.get(j).getServiceGroupName()) > 0) {
						serviceGroups.add(i, sg.get(j));
						break;
					}
				}
				if (serviceGroups.isEmpty()) {
					serviceGroups.add(0, sg.get(j));
				}
				else if (!serviceGroups.contains(sg.get(j))){
					serviceGroups.add(serviceGroups.size(), sg.get(j));
				}
		}
	}

	/**
	 * makes a 2d array containing fields for incident
	 * 
	 * @return 2d string array
	 */
	public String[][] getIncidentsAsArray() {
		if (currentServiceGroup != null) {
			int a = currentServiceGroup.getIncidents().size();
			String[][] array = new String[a][4];
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < array[i].length; j++) {
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
		return null;
	}

	/**
	 * returns incident specified by id
	 * 
	 * @param id id
	 * @return Incident
	 */
	public Incident getIncidentById(int id) {
		if (currentServiceGroup != null) {
			Incident i = currentServiceGroup.getIncidentById(id);
			return i;
		}
		return null;
	}

	/**
	 * passes incident give by id and passes it to command
	 * 
	 * @param id id
	 * @param c  command
	 */
	public void executeCommand(int id, Command c) {
		if (currentServiceGroup != null) {
			currentServiceGroup.executeCommand(id, c);
		}
	}

	/**
	 * Deletes incident by specified id
	 * 
	 * @param id id
	 */
	public void deleteIncidentById(int id) {
		if (currentServiceGroup != null) {
			currentServiceGroup.deleteIncidentById(id);
		}
	}

	/**
	 * adds an incident to the current service group
	 * 
	 * @param title   title
	 * @param caller  caller
	 * @param message message for log
	 */
	public void addIncidentToServiceGroup(String title, String caller, String message) {
		if (currentServiceGroup != null) {
			Incident i = new Incident(title, caller, message);
			currentServiceGroup.addIncident(i);
		}
	}

	/**
	 * loads a service group
	 * 
	 * @param name name
	 */
	public void loadServiceGroup(String name) {
		if (!serviceGroups.isEmpty()) {
			for (int i = 0; i < serviceGroups.size(); i++) {
				if (serviceGroups.get(i).getServiceGroupName().equals(name)) {
					currentServiceGroup = serviceGroups.get(i);
				}
			}
		}
	}

	/**
	 * returns the service group name
	 * 
	 * @return name
	 */
	public String getServiceGroupName() {
		if (currentServiceGroup != null) {
			return currentServiceGroup.getServiceGroupName();
		}
		return null;
	}

	/**
	 * returns a string array for the service groups
	 * 
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
		currentServiceGroup = null;
	}

	/**
	 * edits the service group
	 * 
	 * @param temp temp
	 */
	public void editServiceGroup(String temp) {
		if (currentServiceGroup != null) {
			checkDuplicateServiceName(temp);
			currentServiceGroup.setServiceGroupName(temp);
			ServiceGroup temp2 = serviceGroups.remove(serviceGroups.indexOf(currentServiceGroup));
			addServiceGroupToListByName(temp2);
			loadServiceGroup(temp);
		}
	}

	/**
	 * adds service group to the list by its specified name
	 * 
	 * @param sg Service group
	 */
	private void addServiceGroupToListByName(ServiceGroup sg) {
		for (int i = 0; i < serviceGroups.size(); i++) {
			if (serviceGroups.get(i).getServiceGroupName().compareToIgnoreCase(sg.getServiceGroupName()) > 0) {
				serviceGroups.add(i, sg);
				break;
			}
		}
		if (serviceGroups.isEmpty()) {
			serviceGroups.add(0, sg);
		}
		else if (!serviceGroups.contains(sg)){
			serviceGroups.add(serviceGroups.size(), sg);
		}
	}

	/**
	 * adds a service group with parameter name
	 * 
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
	 * checks if passed name is already used for a service group of if null or
	 * empty.
	 * 
	 * @param name name
	 * @throws Illegal Argument Exception if name is invalid
	 */
	private void checkDuplicateServiceName(String name) {
		if (name == null || "".equals(name)) {
			throw new IllegalArgumentException("Invalid service group name.");
		}
		if (!serviceGroups.isEmpty()) {
			for (int i = 0; i < serviceGroups.size(); i++) {
				if (serviceGroups.get(i).getServiceGroupName().compareToIgnoreCase(name) == 0) {
					throw new IllegalArgumentException("Invalid service group name.");
				}
			}
		}
	}

	/**
	 * Deletes the service group updates current service group to null if non left
	 * or the one at the first spot in the list of service groups
	 * 
	 * @throws IllegalArgumentException if no service group is selected
	 */
	public void deleteServiceGroup() {
		if (currentServiceGroup == null || serviceGroups.size() == 0) {
			throw new IllegalArgumentException("No service group selected.");
		}
		serviceGroups.remove(currentServiceGroup);
		if (serviceGroups.size() < 1) {
			currentServiceGroup = null;
		} else {
			currentServiceGroup = serviceGroups.get(0);
		}
	}

	/**
	 * Resets the manager
	 */
	protected void resetManager() {
		instance = null;
	}
}
