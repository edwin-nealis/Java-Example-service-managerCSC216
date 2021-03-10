package edu.ncsu.csc216.service_wolf.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.ncsu.csc216.service_wolf.model.incident.Incident;
import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;
/**
 * class has two methods to read service groups from a file and two helper methods to process the data.
 * @author edwin
 *
 */
public class ServiceGroupsReader {
	/**
	 * constructor for service group reader
	 */
	public ServiceGroupsReader() {
		
	}
	/**
	 * reads service groups from file and returns them as an array list
	 * @param fileName file name
	 * @return array list
	 * @throws IllegalArgumentException if unable to load file
	 */
	public static ArrayList<ServiceGroup> readServiceGroupsFile(String fileName) {
			ArrayList<ServiceGroup> serviceGroups = new ArrayList<ServiceGroup>();
			String file = "";
			String serviceGroupToken;
			try {
			Scanner input = new Scanner(new FileInputStream(fileName));
			while(input.hasNext()) {
				file += input.nextLine() + "\n";
			}
			Scanner serviceGroup = new Scanner(file);
			serviceGroup.useDelimiter("\\r?\\n?[#]");
			while (serviceGroup.hasNext()) {
				serviceGroupToken = serviceGroup.next();
				ServiceGroup serviceGroupObj = processServiceGroup(serviceGroupToken);
				serviceGroups.add(serviceGroupObj);
			}
			serviceGroup.close();
			}
			catch (FileNotFoundException e) {
				throw new IllegalArgumentException("Unable to load file.");
			}
		return serviceGroups;
	}
	/**
	 * helper method that takes a string and creates a service group
	 * @param string string to be processed
	 * @return service group
	 */
	private static ServiceGroup processServiceGroup(String string) {
		String incident;
		String serviceGroupName;
		Scanner input = new Scanner(string);
		input.useDelimiter("\\r?\\n?[*]");
		serviceGroupName = input.next();
		serviceGroupName = serviceGroupName.substring(1);
		serviceGroupName = serviceGroupName.trim();
		ServiceGroup serviceGroup = new ServiceGroup(serviceGroupName);
		while(input.hasNext()) {
			incident = input.next();
			incident = incident.trim();
			Incident i = processIncident(incident);
			serviceGroup.addIncident(i);
		}
		input.close();
		return serviceGroup;
	}
	/**
	 * helper method that take a string and creates an incident
	 * @param string string to be processed
	 * @return incident
	 */
	private static Incident processIncident(String string) {
		int id;
		String state;
		String title;
		String caller;
		int reopenCount;
		String owner;
		String statusDetails;
		ArrayList<String> incidentLog = new ArrayList<String>();
		Scanner in = new Scanner(string);
		in.useDelimiter(",");
		id = in.nextInt();
		state = in.next();
		title = in.next();
		caller = in.next();
		reopenCount = in.nextInt();
		owner = in.next();
		statusDetails = in.nextLine();
		statusDetails = statusDetails.substring(1);
		in.useDelimiter("\\r?\\n?[-]");
		while (in.hasNext()) {
			String logMessage = in.next();
			logMessage = logMessage.substring(1);
			logMessage = logMessage.trim();
			incidentLog.add(logMessage);
		}
		Incident incident = new Incident(id, state, title, caller, reopenCount, owner, statusDetails, incidentLog);
		in.close();
		return incident;
	}
}
