package net.cubeos.dcpcube;

import java.util.ArrayList;

public class ParseArgs {
	
	private String [] args;
	private ArrayList <Argument> arguments = new ArrayList <Argument> ();
	
	public ParseArgs(String [] args) {
		addArguments();
		this.args = args;
		
	} //close constructor

	/**
	 * 
	 * @return arguments that have been passed
	 */
	
	public String [] getArgs() {
		return this.args;
	} //close get arguments
	
	/**
	 * 
	 * @return argument array list 
	 */
	
	public ArrayList <Argument> getArgumentList() {
		return this.arguments;
	} //close get argument list
	
	/**
	 * 
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
		arguments.add(new Argument("--disk", "-d", "path/to/binary", "Location of disk for the binary to use"));
		arguments.add(new Argument("--emulate", "-e", "path/to/binary", "Emulates a binary file from a specific location"));
		arguments.add(new Argument("--help", "-h", "", "Shows the help menu"));
	} //close add arguments

} //close class
