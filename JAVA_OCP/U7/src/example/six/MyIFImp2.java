package example.six;

public class MyIFImp2 implements MyIF{

	 // Solo tiene obligaridad de implmentar "getUserID()"
	public int getUserID(){
		return 100;
	}
	
	@Override
	public int getAdminID() {
		// TODO Auto-generated method stub
		return MyIF.super.getAdminID();
	}
}
