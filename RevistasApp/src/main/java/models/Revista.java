package models;

public class Revista {
	public int id;
	public String nombre;
	public String portada;
	public Revista(int id, String nombre, String portada) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.portada = portada;
	}
	@Override
	public String toString() {
		return "Revista [id=" + id + ", nombre=" + nombre + ", portada=" + portada + "]";
	}
	
}
