package M1_T08_P30;

public class ExceptionLengthString extends Exception{
	public ExceptionLengthString() {
		super("The Name or SurName has length upper "+ITeam.limitString);
	}
}
