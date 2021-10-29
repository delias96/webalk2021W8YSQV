package hu.me.iit.AutoConsoleApplication;

import hu.me.iit.AutoConsoleApplication.impl.BelsoEgesuMotor;

public class main {

	public static void main(String[] args) {

		Motor motor16 = new BelsoEgesuMotor(180, 1600);
		Auto opelAstra = new Auto(motor16,get4kerek(),"Opel Astra");
		
		out.println(opelAstra);

	}

	static Kerek[] get4kerek() {
		Kerek[] kerekek = new Kerek[4];
		
		for (int i = 0; i < kerekek.length; i++) {
			kerekek[i] = new hu.me.iit.AutoConsoleApplication.impl.Kerek(205, 15, 65);
		}
		return kerekek;
	}
	
}
