/*
 *GrepPattern.java
 *
 * Version:
 *     $Id: GrepPattern.java,v 1.7 11/24/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */

/*Java program which has the same functionlity as:
 *   grep pattern file
 *   
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class GrepPattern {

	/**
	 * GrepPatterns() This method searches input files for the pattern provided
	 * and prints all lines where the pattern is matched and also outputs what
	 * pattern was matched in the line.
	 * 
	 * @param :File searchFile
	 * @param :String Pattern to be searched for.
	 * @return :void
	 */

	private static void GrepPatterns(File searchFile, String searchPattern) {

		BufferedReader input;

		try {

			String line;
			Pattern patt = Pattern.compile(searchPattern);

			input = new BufferedReader(new FileReader(searchFile));
			// Read each line of file

			while ((line = input.readLine()) != null) {

				Matcher m = patt.matcher(line);

				int count = 0;

				while ((m.find())) {

					if (count == 0) {
						System.out.println(line);
						count = 1;
					}

					for (int i = 0; i <= m.groupCount(); i++) {
						System.out.println("What Matched? [" + i + "]: "
								+ m.group(i));
					}

				}

			}

			input.close();
		}

		catch (Exception e) {
			System.out.println("ExceptionType occurred: " + e.getMessage());

		}

	}

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage:"
					+ "java filename searchFile searchPattern");
			System.exit(1);

		}

		File searchFile = new File(args[0]);

		GrepPatterns(searchFile, args[1]);

	}

}

// PP
// PPPP
// "foo abbbbbbb bar"
// ale ale
// bale Bale
