package hu.me.iit.AutoConsoleApplication.impl;

import hu.me.iit.AutoConsoleApplication.Motor;

public class VillanyMotor implements Motor {

	private final int teljesítmény;
	private final int feszultseg;
	public VillanyMotor(int teljesítmény, int feszultseg) {
		super();
		this.teljesítmény = teljesítmény;
		this.feszultseg = feszultseg;
	}
	@Override
	public String toString() {
		return "VillanyMotor [teljesítmény=" + teljesítmény + ", feszultseg=" + feszultseg + "]";
	}
	
	
	
}
