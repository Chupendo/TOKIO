package a7.m3;

public class Libro {
	private Long isbn;
	private String name;
	private String autor;
	private Integer numeroPaginas;
	/**Constructor**/
	
	public Libro(Long isbn, String name, String autor, Integer numeroPaginas) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.autor = autor;
		this.numeroPaginas = numeroPaginas;
	}
	/**Getters&Setters**/
	public Long getIsbn() {
		return isbn;
	}
	public void setIsbn(Long isbn) {
		this.isbn = isbn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	
	/**Método publicos**/
	@Override
	public String toString() {
		return "El libro con título "+this.name+" con el ISBN "+this.isbn+" y autor "+this.autor+" tiene páginas"+this.numeroPaginas+".";
	}
	
	
}
