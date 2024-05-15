package models;

import java.util.Date;

// Esta clase va a actuar como Modelo y como DAO
public class Tarea {
  public int id;
  public String texto;
  public boolean completada;
  public Date fecha;
  
  public Tarea(int id, String texto, boolean completada, Date fecha) {
	super();
	this.id = id;
	this.texto = texto;
	this.completada = completada;
	this.fecha = fecha;
  }
}
