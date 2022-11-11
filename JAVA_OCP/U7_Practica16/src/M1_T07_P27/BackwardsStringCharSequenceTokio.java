package M1_T07_P27;

import java.util.stream.Stream;

public class BackwardsStringCharSequenceTokio implements CharSequenceTokio {
	public String data;
	
	public BackwardsStringCharSequenceTokio(String data) {
		this.data = invertir(data);
	}
	@Override
	public int length() {
		if(this.data==null) {
			return 0;
		}
		return this.data.length();
	}

	@Override
	public char charAt(int index) {
		if(data==null || index<0 || index >= length()) {
			return 0;
		}
		return data.charAt(index);
	}

	@Override
	public CharSequenceTokio subSequence(int start, int end) {
		if(data==null || start<0 || end<0 || end >= length()|| start>end ) {
			return null;
		}
		
		char[] chars = this.data.toCharArray();
		StringBuilder auxiliar = new StringBuilder();
		Stream.of(chars).forEach(c -> auxiliar.append(c));
		
		return new BackwardsStringCharSequenceTokio(auxiliar.toString());
	}
	
	public String toString() {
		if(data==null) {
			return null;
		}
		return data;
	}
	
	private String invertir(String data) {
		StringBuilder inv = new StringBuilder();
		for(int i=data.length()-1;i>=0;i--) {
			inv.append(data.charAt(i));
		}
		return inv.toString();
	}

}
