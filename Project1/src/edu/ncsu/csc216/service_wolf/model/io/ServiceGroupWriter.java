package edu.ncsu.csc216.service_wolf.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;
/**
 * class provides methods to write a service group to a file.
 * @author edwin
 *
 */
public class ServiceGroupWriter {
	/**
	 * Constructor for service groupwriter
	 */
	public ServiceGroupWriter() {
		//empty by choice
	}
	/**
	 * put service groups to a file with name fileName
	 * @param fileName file name
	 * @param list list of service groups
	 */
	public static void writeServiceGroupsToFile(String fileName, List<ServiceGroup> list) {
		PrintStream fileWriter;
		try {
			fileWriter = new PrintStream(new File(fileName));
			for (int i = 0; i < list.size(); i++) {
				fileWriter.println("# " + list.get(i).getServiceGroupName());
				for (int j = 0; j < list.get(i).getIncidents().size(); j++) {
					fileWriter.println(list.get(i).getIncidents().get(j).toString().substring(0, list.get(i).getIncidents().get(j).toString().length() -1));
				}
			}
			fileWriter.close();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
	
}
