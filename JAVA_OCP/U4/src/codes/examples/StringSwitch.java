package codes.examples;

public class StringSwitch {

	public static void main(String[] args) {
		String command = "cancel";
		
		switch(command) {
		case "connect":
			System.out.println("Connecting");
			break;
		case "cancel":
			System.out.println("Cannceling");
			break;
		case "disconnect":
			System.out.println("Disconnecting");
			break;
		default:
			System.out.println("Command Error!");
			break;
		}
	}
}
