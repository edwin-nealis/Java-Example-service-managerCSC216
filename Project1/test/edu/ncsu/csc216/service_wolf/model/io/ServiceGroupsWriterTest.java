package edu.ncsu.csc216.service_wolf.model.io;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import edu.ncsu.csc216.service_wolf.model.service_group.ServiceGroup;
/**
 * tests service group writer class 
 * @author edwin
 *
 */
public class ServiceGroupsWriterTest {
	/** export file path */
	private final String export = "test-files/export.txt";
	/** valid file path */
	private final String validFile = "test-files/incidents1.txt";

	/**
	 * tests write service groups to file method
	 */
	@Test
	public void testWriteServiceGroupsToFile() {
			ArrayList<ServiceGroup> sg = ServiceGroupsReader.readServiceGroupsFile(validFile);
			ServiceGroupWriter.writeServiceGroupsToFile(export, sg);
			checkFiles(export, validFile);
			try {
				ServiceGroupWriter.writeServiceGroupsToFile(export, sg);
			} catch (IllegalArgumentException e) {
				fail("Cannot write to course records file");
			}
		}
		/**
		 * Helper method to compare two files for the same contents
		 * 
		 * @param expFile expected output
		 * @param actFile actual output
		 */
		private void checkFiles(String expFile, String actFile) {
			try (Scanner expScanner = new Scanner(new FileInputStream(expFile));
					Scanner actScanner = new Scanner(new FileInputStream(actFile));) {

				while (expScanner.hasNextLine()) {
					assertEquals(expScanner.nextLine(), actScanner.nextLine());
				}

				expScanner.close();
				actScanner.close();
			} catch (IOException e) {
				fail("Error reading files.");
			}
		}

}
