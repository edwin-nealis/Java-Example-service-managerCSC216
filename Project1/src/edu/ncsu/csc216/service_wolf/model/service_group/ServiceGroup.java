package edu.ncsu.csc216.service_wolf.model.service_group;

import java.util.ArrayList;
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
	/** array list of incidents */
	ArrayList<Incident> incidents;
	/** 
	 * constructor for Service group with param service group name 
	 * also creates an empty array list for incidents
	 * @param serviceGroupName service group name
	 */
	public ServiceGroup(String serviceGroupName) {
		incidents = new ArrayList<Incident>();
		setServiceGroupName(serviceGroupName);
	}
	/**
	 *  sets incident count  to one more than highest id in service group
	 */
	public void setIncidentCounter() {
		int temp = 0;
		for (int i = 0; i < incidents.size(); i++) {
			if (incidents.get(i).getId() > temp) {
				temp = incidents.get(i).getId();
			}
		}
		Incident.setCounter(temp + 1); 
	}
	/**
	 * set service group name 
	 * @param serviceGroupName service group name
	 * @throws IllegalArgumentException if name is null or empty
	 */
	public void setServiceGroupName(String serviceGroupName) {
		if(serviceGroupName == null || "".equals(serviceGroupName)) {
			throw new IllegalArgumentException("Invalid service group name");
		}
		this.serviceGroupName = serviceGroupName;
	}
	/**
	 * return service group name
	 * @return serviceGroupName
	 */
	public String getServiceGroupName() {
		return serviceGroupName;
	}
	/**
	 * add incident to incident array
	 * @param i incident
	 * @throws IllegaalArgumetnException if id is already used
	 */
	public void addIncident(Incident i) {
		for (int j = 0; j < incidents.size(); j++) {
			if (i.getId() == incidents.get(j).getId()) {
				//throw new IllegalArgumentException("Incident cannot be created");
			}
			if (i.getId() < incidents.get(j).getId()) {
				incidents.add(j, i);
				break;
			}
		}
		if (incidents.isEmpty()) {
			incidents.add(0, i);
		}
		else if (!incidents.contains(i)){
			incidents.add(incidents.size(), i);
		}
	}
	/**
	 * returns list of incidents
	 * @return list of incidents
	 */
	public List<Incident> getIncidents() {
		return incidents;
	}
	/**
	 * returns an incident based on its id
	 * @param id id 
	 * @return incident 
	 */
	public Incident getIncidentById(int id) {
		for (int i = 0; i < incidents.size(); i++) {
			if (incidents.get(i).getId() == id) {
				return incidents.get(i);
			}
		}
		return null;
	}
	/**
	 * finds incident with give id and updates it by passing command
	 * @param id id 
	 * @param c command
	 */
	public void executeCommand(int id, Command c) {
		for (int i = 0; i < incidents.size(); i++) {
			if (incidents.get(i).getId() == id) {
				incidents.get(i).update(c);
			}
		}
	}
	/**
	 * deleted incident based on its id
	 * @param id id
	 */
	public void deleteIncidentById(int id) {
		for (int i = 0; i < incidents.size(); i++) {
			if (incidents.get(i).getId() == id) {
				incidents.remove(i);
			}
		}
	}
 
}
