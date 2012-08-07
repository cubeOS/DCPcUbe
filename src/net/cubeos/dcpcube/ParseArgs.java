package net.cubeos.dcpcube;

import java.io.File;
import java.util.ArrayList;

public class ParseArgs {
	
	private String [] args;
	private ArrayList <Argument> arguments = new ArrayList <Argument> ();
	
	public ParseArgs(String [] args) {
		addArguments();
		this.args = args;
		parse();
		
	} //close constructor
	
	/**
	 * parse the arguments
	 */

	private void parse() {
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("-h") || args[0].equalsIgnoreCase("--help")) {
				System.out.println();
				for (Argument i : arguments) {
					System.out.print(i.getCommand()+"");
					System.out.print("("+i.getAlias()+")");
					if (i.getArg() != null) 
						System.out.print(" <" + i.getArg()+">");
					System.out.print(" :: " + i.getDescription()+"\n");
				} //close for loop
				System.out.println();
			} //close printing help out
			else {
				System.out.println("Invalid argument structure.");
				System.exit(1);
			} //close else for exiting program
		} //close arguments equaling 1
		
		else if (args.length % 2 == 1) {
			System.out.println("Invalid argument structure.");
			System.exit(1);
		} //close invalid structure
		
		/**
		 * First: check to see if the second argument is not another type
		 * 		  type of argument and that it is what it should be
		 * 
		 * Second: check each command that it is what it should be
		 */
		
		else if (args.length >= 2) {
			for (int i = 1; i < args.length; i+=2)
				if (args[i].startsWith("-")) {
					System.out.println("Invalid argument structure.");
					System.exit(1);
				} //close invalid structure
			
			for (int i = 0; i < args.length; i+=2) {
				
				/**
				 * --emulate path/to/file
				 * -e path/to/file
				 */
				
				if (args[i].equalsIgnoreCase("--emulate") || args[i].equalsIgnoreCase("-e")) {
					File f = new File(args[i+1]);
					if (!f.isFile() || f.isDirectory()) {
						System.out.println("Invalid file path.");
						System.exit(1);
					} //close invalid file path
				} //close check if emulate has a real file path
				
				/**
				 * --disk path/to/file
				 * -d path/to/file
				 */
				
				if (args[i].equalsIgnoreCase("--disk") || args[i].equalsIgnoreCase("-d")) {
					File f = new File(args[i+1]);
					if (!f.isFile() || f.isDirectory()) {
						System.out.println("Invalid file path.");
						System.exit(1);
					} //close invalid file path
				} //close check if disk has a real file path
				
				/**
				 * below: any other commands eventually added
				 */
				
			} //close parse each
			
		} //close arguments equaling 2
		
	} //close parse
	
	/**
	 * creates a list of argumennts to be used
	 * to check for parsing and also to display
	 * on the help page
	 * 
	 * --emulate path/to/binary
	 * 		alias: -e path/to/binary
	 * 
	 * --disk path/to/binary
	 * 		alias: -d path/to/binary
	 * 
	 * --help
	 * 		alias: -h
	 */
	
	private void addArguments() {
		arguments.add(new Argument("--disk", "-d", "path/to/file", "Location of disk for the binary to use"));
		arguments.add(new Argument("--emulate", "-e", "path/to/file", "Emulates a binary file from a specific location"));
		arguments.add(new Argument("--help", "-h", null, "Shows the help menu"));
	} //close add arguments
	
	/**
	 * PUBLIC COMMANDS
	 */
	
} //close class
