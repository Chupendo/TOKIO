package M1_T07_P27;

import java.util.Arrays;

public class ArrayCharSequenceTokio implements CharSequenceTokio {
	private CharSequenceTokio data = null;
	protected char[] matriz = null;
	public ArrayCharSequenceTokio(char... matriz ) {
		this.matriz = matriz;
	}
	@Override
	public int length() {
		
		return this.matriz==null?0:this.matriz.length;
	}

	@Override
	public char charAt(int index) {
		if(this.matriz==null || index>=0 || this.matriz.length<index) {
			return 0;
		}
		return this.matriz[index];
	}

	@Override
	public CharSequenceTokio subSequence(int start, int end) {
		if(this.matriz==null || start<0 || start>end || end>this.length() ) {
			return this;
		}
		
		if(start==end) {
			return new ArrayCharSequenceTokio(matriz[start]);
		}
		
		char[] aux = new char[end-start];
		for(int i = start;i<end;i++) {
			aux[i] = this.charAt(i);
		}
		return new ArrayCharSequenceTokio(aux);
	}
	
	@Override
	public String toString() {
		
		return Arrays.toString(this.matriz)
				.replace("[", "")
				.replace("]", "")
				.replace(", ", "")
				.trim();
	}

}