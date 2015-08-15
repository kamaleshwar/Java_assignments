/*
 *SearchFiles.java
 *
 * Version:
 *     $Id: SearchFiles.java,v 1.7 11/15/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

/*Java program which has the same functionlity as:

       find . -type f -exec grep Hello {} \;
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class SearchFiles {
	
	
	/**
	 * searchFiles() This method searches all files in directory and 
	 * sub directories for the searchKey.
	 * @param :File startDirectory
	 * 			 directory to start search 
	 * @param :String searchKey
	 * 				search string				
	 * @return :void
	 */

	private static void searchFiles(File startDirectory, String searchKey) {

		BufferedReader input;

		File[] startFilesList = startDirectory.listFiles();

		for (File file : startFilesList) {

			boolean check = true;

			if (file.isDirectory())
				searchFiles(file, searchKey);

			if (file.isFile()) {

				try {

					String line;

					input = new BufferedReader(new FileReader(file));
					//Read each line of file
					while ((line = input.readLine()) != null) {
						if (line.indexOf(searchKey) >= 0) {

							for (int i = 0; i < line.length(); i++) {

								// System.out.println( (int)line.charAt(i)
								// +" is " + line.charAt(i));
								if ((int) line.charAt(i) == 0) {
									check = false;
									break;
								}

							}
							//If file is normal type
							if (check == true) {
								System.out.println(line);
							}
							//If file is binary type
							if (check == false) {
								System.out.println("Binary file " + file
										+ " matches");
								break;
							}

						}

					}

					// System.out.println(file.getName());
					input.close();

				}

				catch (Exception e) {
					System.out.println("ExceptionType occurred: "
							+ e.getMessage());

				}

			}

		}

	}

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage:" + "java filename searchdirectory searchkey");
			System.exit(1);

		}
		
		File startDirectory = new File(args[0]);

		searchFiles(startDirectory, args[1]);

	}

}
