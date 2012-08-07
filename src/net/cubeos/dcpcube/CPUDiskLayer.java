package net.cubeos.dcpcube;

import java.io.File;
import java.util.ArrayList;

public class CPUDiskLayer {
	
	private File emulator;
	private ArrayList <File> disks;
	
	/**
	 * @param emulator
	 * @param disks
	 */
	
	public CPUDiskLayer (File emulator, ArrayList <File> disks) {
		this.emulator = emulator;
		this.disks = disks;
	} //close constructor
	
	/**
	 *  ---- PUBLIC COMMANDS ----
	 */
	
	/**
	 * @return emulator file
	 */
	
	public File getEmulator() {
		return this.emulator;
	} //close get emulator
	
	/**
	 * @return ArrayList of all disk files
	 */
	
	public ArrayList <File> getAllDisks() {
		return this.disks;
	} //close get all disks
	
	/**
	 * @param disk number
	 * @return disk file
	 */
	
	public File getSpecificDisk(int disk) {
		return disks.get(disk);
	} //close get specific disk
	
} //close class
