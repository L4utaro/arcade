package structure;

import enums.StructureType;

public class TypeOfStructure {
	private StructureType structureType;
	private boolean collisicionBullet;
	private boolean collisicionTank;
	
	public TypeOfStructure (StructureType tipo, boolean collisicionBullet, boolean collisicionTank){
		this.structureType = tipo;
		this.collisicionBullet = collisicionBullet;
		this.collisicionTank = collisicionTank;
	}

	public StructureType getStructureType() {
		return structureType;
	}

	public void setStructureType(StructureType tipo) {
		this.structureType = tipo;
	}

	public boolean isCollisicionBullet() {
		return collisicionBullet;
	}

	public void setCollisicionBullet(boolean collisicionBullet) {
		this.collisicionBullet = collisicionBullet;
	}

	public boolean isColisicionTank() {
		return collisicionTank;
	}

	public void setCollisicionTank(boolean collisicionTank) {
		this.collisicionTank = collisicionTank;
	}
}
