package net.cubeos.dcpcube;

import java.io.File;
import java.util.ArrayList;

public class ParseArgs {
	
	private String [] args;
	private ArrayList <Argument> arguments = new ArrayList <Argument> ();
	private ArrayList <CPUDiskLayer> layers = new ArrayList <CPUDiskLayer> ();
	
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
			if (args[0].equals("-h") || args[0].equals("--help")) {
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
		 * 
		 * Third: create CPUDiskLayers
		 * 
		 * Forth: emulate the screens
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
				
				if (args[i].equals("--emulate") || args[i].equals("-e")) {
					File f = new File(args[i+1]);
					if (!f.isFile() || f.isDirectory()) {
						System.out.println("Invalid file path.");
						System.exit(1);
					} //close invalid file path
					
					/**
					 * Create the ArrayList of all Disks before creating
					 * the CPUDiskLayer and adding it to the ArrayList
					 * 
					 * --disk path/to/file
					 * -d path/to/file
					 */
					
					ArrayList <File> disks = new ArrayList <File> ();
					
					for (int x = i; x < args.length-1; x++) {
						if (args[x+1].equals("--emulate") || args[x+1].equals("-e")) 
							break;
						else if (args[x+1].equals("--disk") || args[x+1].equals("-d")) {
							File f2 = new File(args[x+2]);							
							if (!f2.isFile() || f2.isDirectory()) {
								System.out.println("Invalid file path.");
								System.exit(1);
							} //close invalid file path
							else disks.add(f2);
						}//close adding disks if correct
					} //close for loop for adding disks
					
					layers.add(new CPUDiskLayer(f, disks));
					
				} //close check if emulate has a real file path
				
				/**
				 * below: any other commands eventually added
				 */
				
			} //close parse each
			
			/**
			 * Emulate each screen below
			 */
			
			for (CPUDiskLayer layer : layers)
				try {
					new Screen(layer.toCharArray(layer.getEmulator()), layer.getEmulator().getName());
				} //close try
				catch (Exception e) {
					e.printStackTrace();
				} //close catch
			
		} //close arguments equaling 2
		
	} //close parse
	
	/**
	 * creates a list of arguments to be used
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
	 *  ---- PUBLIC COMMANDS ----
	 */
	
	/**
	 * @param emulator number. each emulator is numbered
	 * @return the specified disk layer
	 */
	
	public CPUDiskLayer getSpecificDiskLayer(int emulator) {
		return getAllCPUDiskLayers().get(emulator);
	} //close get specific disk layer
	
	/**
	 * @return an ArrayList of all CPUDiskLayers
	 */
	
	public ArrayList <CPUDiskLayer> getAllCPUDiskLayers() {
		return this.layers;
	} //close get all CPUDiskLayers
	
	/**
	 * @return an ArrayList of all the emulated files
	 */
	
	public ArrayList <File> getAllEmulatedFiles() {
		ArrayList <File> emFiles = new ArrayList <File> ();
		for (int i = 0; i < args.length; i+=2) {
			if (args[i].equals("--emulate") || args[i].equals("-e")) {
				File f = new File(args[i+1]);
				if (!f.isFile() || f.isDirectory()) {
					System.out.println("Invalid file path.");
					System.exit(1);
				} //close invalid file path
				emFiles.add(f);
			} //close check if emulate has a real file path
		} //close for loop
		return emFiles;
	} //close get emulated files
	
	/**
	 * @return an ArrayList of all the disk files
	 */
	
	public ArrayList <File> getAllDiskFiles() {
		ArrayList <File> diskFiles = new ArrayList <File> ();
		for (int i = 0; i < args.length; i+=2) {
			if (args[i].equals("--disk") || args[i].equals("-d")) {
				File f = new File(args[i+1]);
				if (!f.isFile() || f.isDirectory()) {
					System.out.println("Invalid file path.");
					System.exit(1);
				} //close invalid file path
				diskFiles.add(f);
			} //close check if disk has a real file path
		} //close for loop
		return diskFiles;
	} //close get disk files
	
} //close class
