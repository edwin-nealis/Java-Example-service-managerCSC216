package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.List;

import edu.ncsu.csc216.service_wolf.model.command.Command;
import edu.ncsu.csc216.service_wolf.model.incident.Incident;

public class ServiceGroup {
	/** holds service group name */
	private String serviceGroupName;
	/** 
	 * constructor for Service group with param service group name 
	 * also creates an empty array list for incidents
	 * @param serviceGroupName
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
	 * @param serviceGroupName
	 */
	public void setServiceGroupName(String serviceGorupName) {
		
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
	 * @param i
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
	 * @param id
	 * @return incident 
	 */
	public Incident getIncidentById(int id) {
		return null;
	}
	/**
	 * does command 
	 * @param temp
	 * @param c
	 */
	public void executeCommand(int temp, Command c) {
		
	}
	/**
	 * deleted incident based on its id
	 * @param id
	 */
	public void deleteIncidentByid(int id) {
		
	}
 
}
