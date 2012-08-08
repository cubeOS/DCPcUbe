package net.cubeos.dcpcube;

import javax.swing.JFrame;

public class Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private char [] emulateMe;

	public Screen (char [] emulateMe, String fileName) {
		super("DCPcUbe :: "+fileName);
		
		this.emulateMe = emulateMe;
		
		setSize(128, 96);
		setVisible(true);
		
		emulate();
		
	} //close constructor
	
	/**
	 * Emulates the file emulateMe
	 */
	
	private void emulate() {
		/**
		 * TODO: Emulate the file given, emulateMe
		 */
	} //close emulate
	
	
	
	/**
	 *  ---- PUBLIC COMMANDS ----
	 */
	
	/**
	 * @return the file that is currently being emulated
	 */
	
	public char [] getEmulatedFile() {
		return this.emulateMe;
	} //close get emulated file
	
	/**
	 * @param newEmulatedFile - the new file to be emulated
	 * If for some reason during running an emulated file
	 * a new emulated file is needed to be changed, one can
	 * set the new emulated file with this.
	 */
	
	public void setEmulatedFile(char [] newEmulatedFile) throws NullPointerException {
		this.emulateMe = newEmulatedFile;
	} //close set emulated file
	
} //close class
