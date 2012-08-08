package net.cubeos.dcpcube;

public class Opcode {

	private identifier name;
	private int cycles;
	private int value;
	
	/**
	 * @param name - the identifier
	 * @param cycles - the number of cycles
	 * @param value - the value
	 */
	
	public Opcode(identifier name, int cycles, int value) {
		this.name = name;
		this.cycles = cycles;
		this.value = value;
	} //close constructor
	
	public enum identifier {
		SET, ADD, SUB, MUL,
		MLI, DIV, DVI, MOD,
		MDI, AND, BOR, XOR,
		SHR, ASR, SHL, IFB,
		IFC, IFE, IFN, IFG,
		IFA, IFL, IFU, 
		     ADX, SBX,
		     STI, STD,
		
		JSR,
		               INT,
		IAG, IAS, RFI, IAQ,
		               HWN,
		HWQ, HWI
	} //close enum identifier
	
	/**
	 *  ---- PUBLIC COMMANDS ----
	 */
	
	/**
	 * @return the identifier  
	 */
	
	public identifier getIdentifier() {
		return this.name;
	} //close get identifier
	
	/**
	 * @param id - identifier to be changed
	 */
	
	public void setIdentifier(identifier id) {
		this.name = id;
	} //close set identifier
	
	/**
	 * @return cycles
	 */
	
	public int getCycle() {
		return this.cycles;
	} //close get cycles
	
	/**
	 * @param cycle - the new number of cycles
	 */
	
	public void setCycles(int cycle) {
		this.cycles = cycle;
	} //close set cycles
	
	/**
	 * @return values
	 */
	
	public int getValue() {
		return this.value;
	} //close get value
	
	/**
	 * @param val - the new value to be set
	 */
	
	public void setValue(int val) {
		this.value = val;
	} //close set value
	
} //close class
