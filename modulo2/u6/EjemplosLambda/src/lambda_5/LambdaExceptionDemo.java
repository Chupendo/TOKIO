package lambda_5;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;



public class LambdaExceptionDemo {

	public static void main(String[] args) {
		double[] values = {1.0,2.0,6.6,4.0};
		MyIOAction myIO = rdr -> {
			// Puede generar IOException
			int val = 0;
			System.out.print("Introduce un valor:");
			while((val=rdr.read())>-1 && val!=10 ) {
				System.out.println(val+": "+(char)val);				
			}
			return true;
		};
		
	
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boolean r = myIO.ioAction(br);
			System.out.println("r= "+r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public interface MyIOAction{
		boolean ioAction(Reader rdr) throws IOException;
	}
}
