package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Revista;

public class RevistasDao {
	
	static public ArrayList<Revista> obtenerTodas () throws SQLException {
		// 1. Creamos un ArrayList vacío
		ArrayList<Revista> revistas = new ArrayList<Revista>();
		// 2. Pedimos una conección nueva
		Connection conn = MyConn.getConnection();
		// 3. Creamos y ejecutamos la consulta
		Statement consulta = conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from revistas order by id");
		
		// 4. Vamos llenando el ArrayList con lo que tenga la respuesta
		while (respuesta.next()) {
		  Revista nueva = new Revista(
			respuesta.getInt("id"),
			respuesta.getString("nombre"),
			respuesta.getString("portada")
		  );
		  revistas.add( nueva );
		}
		// 5. Retornamos el ArrayList, ahora lleno
		return revistas;
	}
}