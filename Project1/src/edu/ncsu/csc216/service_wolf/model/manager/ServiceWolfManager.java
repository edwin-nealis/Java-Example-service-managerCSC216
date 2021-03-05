package edu.ncsu.csc216.service_wolf.model.manager;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;
/**
 * service group manager is an object with no fields that provides methods that work with service groups.
 * has a save to file and a load from file for servcie groups. a gett incidets as array for the GUI a get incident by id a delete incident by id
 * an add incident to service group and a clear service group. 
 * @author edwin
 *
 */
public class ServiceWolfManager {
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
		return null;
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
		
	}
	/**
	 * makes a 2d array containing fields for incident
	 * @return 2d string array
	 */
	public String[][] getIncidentsAsArray() {
		return null;
	}
	/**
	 * returns incident specified by id
	 * @param id id
	 * @return Incident
	 */
	public Incident getIncidentById(int id) {
		return null;
	}
	/**
	 * passes incident give by id and passes it to command
	 * @param id id 
	 * @param c command
	 */
	public void executeCommand(int id, Command c) {
		
	}
	/**
	 * Deletes incident by specified id
	 * @param id id
	 */
	public void deleteIncidentById(int id) {
		
	}
	/**
	 * adds an incident to a service group
	 * @param title title
	 * @param caller caller
	 * @param message message for log
	 */
	public void addIncidentToServiceGroup(String title, String caller, String message) {
		
	}
	/**
	 * loads a service group
	 * @param name name
	 */
	public void loadServiceGroup(String name) {
		
	}
	/**
	 * returns the service group name
	 * @return name
	 */
	public String getServiceGroupName() {
		return null;
	}
	/**
	 * returns a string array for the service groups
	 * @return string array
	 */
	public String[] getServiceGroupList() {
		return null;
	}
	/**
	 * clears all service groups
	 */
	public void clearServiceGroups() {
		
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
		
	}
	/**
	 * adds a service  group with parameter name 
	 * @param name name
	 */
	public void addServiceGroup(String name) {
		
	}
	/**
	 * checks if two service groups are duplicates 
	 * @param name name
	 */
	private void checkDuplicateServiceName(String name) {
		
	}
	/**
	 * Deletes the service group
	 */
	public void deleteServiceGroup() {
		
	}
	/**
	 * Resets the manager
	 */
	protected void resetManager() {
		
	}
}
