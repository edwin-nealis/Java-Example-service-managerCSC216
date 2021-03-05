package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.List;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;
/**
 * this class outlines ojbect ServiceGroup which has one field name. there is one constuctor and a getter and setter for name.
 * there are also methods to add and delete an incident and a getter for all incidents. A method for setting an incident counter and a method
 * to execute command.
 * @author edwin
 *
 */
public class ServiceGroup {
	/** holds service group name */
	private String serviceGroupName;
	/** 
	 * constructor for Service group with param service group name 
	 * also creates an empty array list for incidents
	 * @param serviceGroupName service group name
	 */
	public ServiceGroup(String serviceGroupName) {
		setServiceGroupName(serviceGroupName);
	}
	/**
	 *  sets incident count 
	 */
	public void setIncidentCounter() {
		
	}
	/**
	 * set service group name 
	 * @param serviceGroupName service group name
	 */
	public void setServiceGroupName(String serviceGroupName) {
		
	}
	/**
	 * return service group name
	 * @return serviceGroupName
	 */
	public String getServiceGroupName() {
		return null;
	}
	/**
	 * add incident to incident array
	 * @param i incident
	 */
	public void addIncident(Incident i) {
		
	}
	/**
	 * returns list of incidents
	 * @return list of incidents
	 */
	public List<Incident> getIncidents() {
		return null;
	}
	/**
	 * returns an incident based on its id
	 * @param id id 
	 * @return incident 
	 */
	public Incident getIncidentById(int id) {
		return null;
	}
	/**
	 * does command 
	 * @param id id 
	 * @param c command
	 */
	public void executeCommand(int id, Command c) {
		
	}
	/**
	 * deleted incident based on its id
	 * @param id id
	 */
	public void deleteIncidentById(int id) {
		
	}
 
}
