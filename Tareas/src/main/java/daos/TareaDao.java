package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
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
	  
	  static public void addNew (String textoNuevaTarea) throws SQLException {
		// 1. Pedimos una conexion nueva
		Connection conn = MyConn.getConnection();
		// 2. Creamos la consulta
		PreparedStatement consulta = conn.prepareStatement(
			"insert into tareas (texto) values (?)"
		);
		consulta.setString(1, textoNuevaTarea);
		// 3. Ejecutar la consulta
		consulta.executeUpdate();
	  }
	  
	  static public void deleteById (int idTarea) throws SQLException {
		// 1. Pedimos una conexion nueva
		Connection conn = MyConn.getConnection();
		// 2. Creamos la consulta
		PreparedStatement stmt = conn.prepareStatement(
			"delete from tareas where id=?"
		);
		stmt.setInt(1, idTarea);
		// 3. Ejecutar la stmt
		stmt.executeUpdate();
	  }
	  
	  static public void checkById (int idTarea) throws SQLException {
		// 1. Pedimos una conexion nueva
		Connection conn = MyConn.getConnection();
		// 2. Creamos la consulta
		PreparedStatement stmt = conn.prepareStatement(
			"update tareas set completada = true where id = ?"
		);
		stmt.setInt(1, idTarea);
		// 3. Ejecutar la stmt
		stmt.executeUpdate();
	  }
	  
	  static public ArrayList<Tarea> getAll () throws SQLException {
		// 1. Creamos un ArrayList vacío
		ArrayList<Tarea> tareas = new ArrayList<Tarea>();
		// 2. Pedimos una conección nueva
		Connection conn = MyConn.getConnection();
		// 3. Creamos y ejecutamos la consulta
		Statement consulta = conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from tareas order by id");
		
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
