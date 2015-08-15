

/*
 *RegexChecker.java
 *
 * Version:
 *     $Id: RegexChecker.java,v 1.7 11/24/2014 $
 *     
 * @Authors: Raj & Kamaleshwar  
 *
 * Revisions:
 *     $Log$
 */
 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.*;


/**
 * This class prints the legal variables,single line comments,words that 
 * start with a and end with e,words that end with vowel and followed by consonant,
 * words that end with t and second next starting with consonant
 * 
 */
 
public class RegexChecker {

	BufferedReader read;
	String line;

	/**
	 * ReadFile reads the input file
	 * 
	 * @param path
	 * 		path of the input file  
	 */
	
	public void readFile(String path) {
		
		try {
			read = new BufferedReader(new FileReader(path)); 
			
			while((line=read.readLine())!=null)
			{	
				regexFinder("\\b\\s+[A-Za-z$_]+[A-Za-z0-9$_]*\\b\\s*[;=:]+", line,"Variable");
				regexFinder("//.*$", line,"comments");
				regexFinder("\\ba\\w*e\\b", line,"Start with a and end with e");
				regexFinder("\\b\\w*[aeiou]\\s[^aeiou&&\\w*]\\w*\\b", line,"end with vowels and followed by consonant");
				regexFinder("\\b\\w*t\\s\\w*\\s[^aeiou&&\\w*]\\w*\\b", line,"end with t and second next starting with consonant");
				
			}
			read.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not found");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	/**
	 * regexFinder prints the matched pattern
	 * 
	 * @param what
	 * 		pattern to be searched
	 *@param where
	 *		Line to be searched
	 *
	 */
	 
	public void regexFinder(String what, String where,String type)
	{
		Pattern p=Pattern.compile(what,Pattern.CASE_INSENSITIVE);
		
		Matcher m=p.matcher(where);
		while(m.find())
		{
			System.out.println(type+": "+m.group());
			System.out.println(where);
			
		}
		
		
	}
	public static void main(String args[]) {

		RegexChecker rc = new RegexChecker();

		if (args.length <=2) {
			rc.readFile(args[0]);
		}
		
	}
}




//PP 
//PPPP
//"foo abbbbbbb bar"
//_Life
//$Variable
/* http.// */
//@sea floor{ BUG
//sea floor
////sea +oor
//Sea eat
//eat Sea
//"tent post Hole"
//ale
//{ale{
//aleppppp
//Alealeexpress
//ale ate

