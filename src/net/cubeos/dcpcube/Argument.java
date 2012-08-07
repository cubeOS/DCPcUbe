package net.cubeos.dcpcube;

public class Argument {
	
	private String command;
	private String alias;
	private String description;
	private String arg;
	
	/**
	 * @param command, --command
	 * @param alias, -c
	 * @param arg, <argument>
	 * @param description, "command that..."
	 */
	
	public Argument (String command, String alias, String arg, String description) {
		this.command = command;
		this.alias = alias;
		this.description = description;
		this.arg = arg;
		
	} //close constructor
	
	/**
	 * @return the command name
	 */
	
	public String getCommand() {
		return this.command;
	} //close get command
	
	/**
	 * @return the alias for the command
	 */
	
	public String getAlias() {
		return this.alias;
	} //close get alias
	
	/**
	 * @return the argument for the command
	 */
	
	public String getArg() {
		return this.arg;
	} //close get argument
	
	/**
	 * @return the description for the command
	 */
	
	public String getDescription() {
		return this.description;
	} //close get description
	
} //close class
