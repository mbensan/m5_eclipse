package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.MyConn;
import models.Tarea;

public class TareaDao {
	static public ArrayList<String> get_textos () throws SQLException {
		// 1. Creamos un ArrayList vacío
		ArrayList<String> textos = new ArrayList<String>();
		// 2. Pedimos una conección nueva
		Connection conn = MyConn.getConnection();
		// 3. Creamos y ejecutamos la consulta
		Statement consulta = conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from tareas");
		
		// 4. Vamos llenando el ArrayList con lo que tenga la respuesta
		while (respuesta.next()) {
		  textos.add( respuesta.getString("texto") );
		}
		// 5. Retornamos el ArrayList, ahora lleno
		return textos;
	  }
	  
	  static public ArrayList<Tarea> getAll () throws SQLException {
		// 1. Creamos un ArrayList vacío
		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		// 2. Pedimos una conección nueva
		Connection conn = MyConn.getConnection();
		// 3. Creamos y ejecutamos la consulta
		Statement consulta = conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from tareas");
		
		// 4. Vamos llenando el ArrayList con lo que tenga la respuesta
		while (respuesta.next()) {
		  Tarea t = new Tarea(
			respuesta.getInt("id"),
			respuesta.getString("texto"),
			respuesta.getBoolean("completada"),
			respuesta.getDate("fecha")
		  );
		  tareas.add( t );
		}
		// 5. Retornamos el ArrayList, ahora lleno
		return tareas;
	}
}
