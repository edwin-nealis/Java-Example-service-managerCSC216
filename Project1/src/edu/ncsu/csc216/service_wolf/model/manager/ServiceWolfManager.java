package edu.ncsu.csc216.service_wolf.model.manager;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;

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
	 * @param fileName
	 */
	public void saveToFile(String fileName) {
		
	}
	/**
	 * load from file name
	 * @param fileName
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
	 * @param id
	 * @return Incident
	 */
	public Incident getIncidentById(int id) {
		return null;
	}
	/**
	 * passes incident give by id and passes it to command
	 * @param temp
	 * @param c
	 */
	public void executeCommand(int id, Command c) {
		
	}
	/**
	 * Deletes incident by specified id
	 * @param id
	 */
	public void deleteIncidentById(int id) {
		
	}
	/**
	 * adds an incident to a service group
	 * @param title
	 * @param caller
	 * @param message
	 */
	public void addIncidentToServiceGroup(String title, String caller, String message) {
		
	}
	/**
	 * loads a service group
	 * @param name
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
	 * @param temp
	 */
	public void editServiceGroup(String temp) {
		
	}
	/**
	 * adds service group to the list by its specified name
	 * @param sg
	 */
	private void addServiceGroupToListByName(ServiceGroup sg) {
		
	}
	/**
	 * adds a service  group with parameter name 
	 * @param name
	 */
	public void addServiceGroup(String name) {
		
	}
	/**
	 * checks if two service groups are duplicates 
	 * @param name
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
