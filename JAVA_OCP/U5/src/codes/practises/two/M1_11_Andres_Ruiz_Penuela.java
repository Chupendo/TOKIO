package codes.practises.two;

public class M1_11_Andres_Ruiz_Penuela {

	public static void main(String[] args) {
		Rectangle fig1 = new Rectangle();
		System.out.println("Figura 1 (valores por defecto): "+fig1.toString());
		System.out.println("¿Es un cuadrado? "+fig1.isSquare());
		System.out.println("Área: "+fig1.area());
		System.out.println("Perímetro "+fig1.perimetrer());
		fig1.rotateIsometric();
		System.out.println("Giro isométrico: "+fig1.toString());
		System.out.println("----------------------------");
		
		Rectangle fig2 = new Rectangle(2,-1);
		System.out.println("Figura 2 (con un valore negativo: {base,altura}={2,-1}): "+fig2.toString());
		System.out.println("¿Es un cuadrado? "+fig2.isSquare());
		System.out.println("Área: "+fig2.area());
		System.out.println("Perímetro "+fig2.perimetrer());
		fig2.rotateIsometric();
		System.out.println("Giro isométrico: "+fig2.toString());
		System.out.println("----------------------------");
		
		Rectangle fig3 = new Rectangle(2,2);
		System.out.println("Figura 3 (figura que representa un cudrado base=altura=2): "+fig3.toString());
		System.out.println("¿Es un cuadrado? "+fig3.isSquare());
		System.out.println("Área: "+fig3.area());
		System.out.println("Perímetro "+fig3.perimetrer());
		fig3.rotateIsometric();
		System.out.println("Giro isométrico: "+fig3.toString());
		System.out.println("----------------------------");
		
		Rectangle fig4 = new Rectangle(3,2);
		System.out.println("Figura 4 (figura que representa un rectangulo {base,altura}={3,2}): "+fig4.toString());
		System.out.println("¿Es un cuadrado? "+fig4.isSquare());
		System.out.println("Área: "+fig4.area());
		System.out.println("Perímetro "+fig4.perimetrer());
		fig4.rotateIsometric();
		System.out.println("Giro isométrico: "+fig4.toString());
		System.out.println("----------------------------");
	}

}
