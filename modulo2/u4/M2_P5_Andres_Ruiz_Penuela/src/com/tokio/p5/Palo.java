package com.tokio.p5;

public enum Palo {
	Espadas('E'), Copas('C'),Bastos('B'),Oros('O');
	private char abreviatura;
	
	Palo(char abreviatura){
		this.abreviatura = abreviatura;
	}
	
	public char getAbreviatura(){
		return this.abreviatura;
	}
}
