package a7.m3;

public class Run {

	public static void main(String[] args) {
		Libro l1 = new Libro(123412L, "Eragon", "Estiben", 532);
		Libro l2 = new Libro(123413L, "Programaicon II", "Gregor", 1050);
		
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		
		switch(l1.getNumeroPaginas().compareTo(l2.getNumeroPaginas())){
			case 1:
				System.out.println("Libro de "+l1.getAutor()+" con mas paginas");
				break;
			case -1:
				System.out.println("Libro de "+l2.getAutor()+" con mas paginas");
				break;
			case 0:
				System.out.println("Mismo numero de paginas");
		}
	}

}
