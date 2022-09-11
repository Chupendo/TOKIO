	package codes.exercicies.tokio.exercicies.two;

public class Test {
	int a;
    Test(int i){ a = i;}
    
    public void swap(Test t) {
    	int aux = this.a;
    	this.a = t.a;
    	t.a = aux;
    }
}
