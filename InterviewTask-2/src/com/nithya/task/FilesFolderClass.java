package com.nithya.task;

import java.io.File;
import java.util.Date;

/**
 * this Class is used to group the file based on the month of the file in given
 * folder
 *
 * 
 */
public class FilesFolderClass {
	private static String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "jul", "Aug", "Sep", "Oct", "Nov",
			"Dec" };
	private static int MAX_VAL = 12;
	private static int[] count = new int[MAX_VAL];

	public static void getTheFilesBasedString(String location) {
		getTheFilesBasedFile(new File(location));
	}

	public static void getTheFilesBasedFile(File path) {
		File[] files = path.listFiles();
		if (files != null) {
			for (int i = 0; i < files.length; i++)
				// if (files[i].isFile())
				// Initialize count array index
				count[new Date(files[i].lastModified()).getMonth()]++;
			// else
			// getTheFilesBasedFile(files[i]);
			// Create an array of given files size
			int month[] = new int[files.length];
			for (int i = 0; i < files.length; i++) {

				month[i] = new Date(files[i].lastModified()).getMonth();
				int find = 0;
				for (int j = 0; j <= i; j++) {

					// If any matches found
					if (new Date(files[i].lastModified()).getMonth() == month[j])
						find++;
				}

				if (find == 1)
					System.out
							.println("Number files  Occurrence based on month of ::" + getMonthBasedOnMonthNo(files[i])
									+ " is:" + count[new Date(files[i].lastModified()).getMonth()]);
			}

	
	}
	else{
		System.out.println("given path/location does not exits!");
	}
	}

	public static String getMonthBasedOnMonthNo(File f) {
		return months[new Date(f.lastModified()).getMonth()];

	}

	
}
