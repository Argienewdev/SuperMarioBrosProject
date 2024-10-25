package elementos;

public class Sonido {
	protected String rutaSonido;
	
	public Sonido(String rutaSonido) {
		this.rutaSonido = rutaSonido;
	}
	
	public String getRutaSonido() {
		return this.rutaSonido;
	}
	
	public void setRutaSonido(String rutaSonido) {
		this.rutaSonido = rutaSonido;
	}
	
	public boolean equals(Sonido sonido) {
		return this.getRutaSonido().equals(sonido.getRutaSonido());
	}
}
