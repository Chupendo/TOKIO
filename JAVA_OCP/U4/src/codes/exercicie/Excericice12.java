package codes.exercicie;

public class Excericice12 {

	public static void main(String[] args) {
		int numero = 21;
		int numeroRotadoDerecha = numero >> 1;
		int numeroRotadoDerechaSinSigno = numero >>> 1;
		System.out.println("N�mero original en binario: \n" + Integer.toBinaryString(numero));
		System.out.println("N�mero rotado en binario    \n" + Integer.toBinaryString(numeroRotadoDerecha));
		System.out.println(
				"N�mero rotado sin signo en binario     \n" + Integer.toBinaryString(numeroRotadoDerechaSinSigno));

		numero = -1;
		numeroRotadoDerecha = numero >> 1;
		numeroRotadoDerechaSinSigno = numero >>> 1;
		System.out.println("N�mero original en binario: \n" + Integer.toBinaryString(numero));
		System.out.println("N�mero rotado en binario    \n" + Integer.toBinaryString(numeroRotadoDerecha));
		System.out.println(
				"N�mero rotado sin signo en binario     \n" + Integer.toBinaryString(numeroRotadoDerechaSinSigno));
	}
}
