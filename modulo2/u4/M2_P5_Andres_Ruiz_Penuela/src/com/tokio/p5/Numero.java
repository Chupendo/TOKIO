package com.tokio.p5;

public enum Numero {
	As('A'),dos('2'),tres('3'),cuatro('4'),cinco('5'),seis('6'),siete('7'),sota('S'),caballo('C'),rey('R');
	private char abreviatura;
	
	private Numero(char abreviatura) {
		this.abreviatura = abreviatura;
	}
	
	public char getAbreviatura(){
		return this.abreviatura;
	}
}
