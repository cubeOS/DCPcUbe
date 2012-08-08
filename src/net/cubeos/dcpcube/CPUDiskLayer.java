package net.cubeos.dcpcube;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CPUDiskLayer {
	
	private File emulator;
	private ArrayList <File> disks;
	private ArrayList <char []> chararrays;
	
	/**
	 * @param emulator
	 * @param disks
	 */
	
	public CPUDiskLayer (File emulator, ArrayList <File> disks) {
		this.emulator = emulator;
		this.disks = disks;
		try {
			chararrays.add(toCharArray(this.emulator));
			if (this.disks != null)
				for (File f : this.disks)
					chararrays.add(toCharArray(f));
			} //close try 
		catch (Exception e) {}
	} //close constructor
	
	/**
	 * 
	 * @param whichever file is being transfered to a char array
	 * @return the char array for the specified file
	 * @throws IOException, NullPointerException
	 */
	
	private char [] toCharArray(File f) throws IOException, NullPointerException {
		char [] ca = new char [(int) f.length()];
		int a;
		
		DataInputStream dis = new DataInputStream(new FileInputStream(f));
		BufferedReader br = new BufferedReader(new InputStreamReader(dis));
		
		for (int i = 0; ((a = br.read()) != -1); i++)
			if (!br.equals(null))
				ca[i] = (char) a;
		
		br.close();
		dis.close();
		
		// TEST PRINT OUT CHAR ARRAY
		for (int i = 0; i < ca.length; i++)
			System.out.println(ca[i]+" ");
			
		return ca;
	} //close to char array
	
	/**
	 * ---- PUBLIC COMMANDS ----
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
		return this.disks.get(disk);
	} //close get specific disk
	
	/**
	 * @return ArrayList of all the char arrays
	 * First char array being the emulator file
	 * Second, Third, ... being the disk files
	 */
	
	public ArrayList <char []> getAllCharArrays() {
		return this.chararrays;
	} //close get all char arrays
	
	/**
	 * @param the char array to return.
	 * First char array being the emulator file
	 * Second, Third, ... being the disk files
	 * @return the specific char array
	 */
	
	public char [] getSpecificCharArray(int arraynum) {
		return getAllCharArrays().get(arraynum);
	} //close get specific char array
	
} //close class
