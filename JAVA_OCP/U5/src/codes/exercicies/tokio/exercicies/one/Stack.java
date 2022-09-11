package codes.exercicies.tokio.exercicies.one;
/**
 * Pila de tipo FILO de caracteres
 * 
 * @author Andres Ruiz Peñuela
 * @version 1.0.
 *
 */
public class Stack {
	private int top,clim;
	private char[] stack;
	
	Stack(int clim){
		this.clim=clim;
		this.top = -1;
		stack = new char[this.clim];
	}
	
	public void push(char elem) {
		if(top<clim) {
			top++;
			stack[top] = elem;
		}
	}
	
	public char pop() {
		if(this.top>=0) {	
			this.top--;
			return this.stack[this.top+1];
		}
		return 0;
	}
}
