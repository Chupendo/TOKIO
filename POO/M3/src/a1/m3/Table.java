package a1.m3;

import java.util.function.Function;

public class Table {
	public static final double PI = 3.141592;
	private static final Function<Double, Double> AREARECTANGLE = (l) -> l * l;
	private static final Function<Double, Double> AREAROUND = (r) -> r *r * Table.PI;

	protected boolean isRoundTable = true;
	private Double length;

	/** Constructors **/
	public Table() {
	}

	public Table(Double length) {
		this.length = length;
	}

	public Table(Double length, boolean isRoundTable) {
		this.length = length;
		this.isRoundTable = isRoundTable;
	}

	/** Getters && Setters **/
	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	/** Methods Static **/
	public static int compareToArea(Double a1, Double a2) throws NullPointerException {
		return a1.compareTo(a2);
	}

	private static Double calculateArea(Function<Double, Double> fun, Double data) {
		return fun.apply(data);
	}

	/** Methods Publics **/
	public static Integer getTableWithBigger(Table t1, Table t2) {
		Double a1, a2;

		if(t1.isEmpaty()) {
			return null;
		}
		a1 = t1.getArea();
		a2 = t2.getArea();
		
		return compareToArea(a1, a2);
	}
		
	@Override
	public String toString() {
		return "Table [isRoundTable=" + isRoundTable + ", length=" + length + "]";
	}

	/** Methods Private **/
	private Double getArea() {
		if (this.isRoundTable) {
			return calculateArea(Table.AREARECTANGLE, this.getLength());
		} else {
			return calculateArea(Table.AREAROUND, this.getLength());
		}
	}

	private boolean isEmpaty() {
		if (this.length == null) {
			return true;
		}
		return false;
	}

}
