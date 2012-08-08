package net.cubeos.dcpcube;

public class Processor {
	
	public static final Opcode[] opcode = {
		null,							   	//x00
		new Opcode(Opcode.identifier.SET, 1, 0x01),
		new Opcode(Opcode.identifier.ADD, 2, 0x02),
		new Opcode(Opcode.identifier.SUB, 2, 0x03),
		new Opcode(Opcode.identifier.MUL, 3, 0x04),
		new Opcode(Opcode.identifier.MLI, 2, 0x05),
		new Opcode(Opcode.identifier.DIV, 2, 0x06),
		new Opcode(Opcode.identifier.DVI, 2, 0x07),
		new Opcode(Opcode.identifier.MOD, 2, 0x08),
		new Opcode(Opcode.identifier.MDI, 2, 0x09),
		new Opcode(Opcode.identifier.AND, 2, 0x0a),
		new Opcode(Opcode.identifier.BOR, 2, 0x0b),
		new Opcode(Opcode.identifier.XOR, 2, 0x0c),
		new Opcode(Opcode.identifier.SHR, 2, 0x0d),
		new Opcode(Opcode.identifier.ASR, 2, 0x0e),
		new Opcode(Opcode.identifier.SHL, 2, 0x0f),
		new Opcode(Opcode.identifier.IFB, 2, 0x10),
		new Opcode(Opcode.identifier.IFC, 2, 0x11),
		new Opcode(Opcode.identifier.IFE, 2, 0x12),
		new Opcode(Opcode.identifier.IFN, 2, 0x13),
		new Opcode(Opcode.identifier.IFG, 2, 0x14),
		new Opcode(Opcode.identifier.IFA, 2, 0x15),
		new Opcode(Opcode.identifier.IFL, 2, 0x16),
		new Opcode(Opcode.identifier.IFU, 2, 0x17),
		null,								//x18
		null,								//x19
		new Opcode(Opcode.identifier.IFG, 2, 0x1a),
		new Opcode(Opcode.identifier.IFG, 2, 0x1b),
		null,								//x1c
		null,								//x1d
		new Opcode(Opcode.identifier.STI, 2, 0x1e),
		new Opcode(Opcode.identifier.STD, 2, 0x1f),
	};
	public static final Opcode[] sopcode = {
		null,							   	//x00
		new Opcode(Opcode.identifier.JSR, 1, 0x01),
		null,								//x02
		null,								//x03
		null,								//x04
		null,								//x05
		null,								//x06
		null,								//x07
		new Opcode(Opcode.identifier.INT, 2, 0x08),
		new Opcode(Opcode.identifier.IAG, 2, 0x09),
		new Opcode(Opcode.identifier.IAS, 2, 0x0a),
		new Opcode(Opcode.identifier.RFI, 2, 0x0b),
		new Opcode(Opcode.identifier.IAQ, 2, 0x0c),
		null,								//x0d
		null,								//x0e
		null,								//x0f
		new Opcode(Opcode.identifier.HWN, 2, 0x10),
		new Opcode(Opcode.identifier.HWQ, 2, 0x11),
		new Opcode(Opcode.identifier.HWI, 2, 0x12),
		null,								//x13
		null,								//x14
		null,								//x15
		null,								//x16
		null,								//x17
		null,								//x18
		null,								//x19
		null,								//x1a
		null,								//x1b
		null,								//x1c
		null,								//x1d
		null,								//x1e
		null,								//x1f
	};
	
} //close class
