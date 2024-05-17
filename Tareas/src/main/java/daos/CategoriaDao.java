package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Categoria;
import models.MyConn;
import models.Tarea;

public class CategoriaDao {
	static public ArrayList<Categoria> getAll () throws SQLException {
		// 1. Creamos un ArrayList vacío
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		// 2. Pedimos una conección nueva
		Connection conn = MyConn.getConnection();
		// 3. Creamos y ejecutamos la consulta
		Statement consulta = conn.createStatement();
		ResultSet respuesta = consulta.executeQuery("select * from categorias order by id");
		
		// 4. Vamos llenando el ArrayList con lo que tenga la respuesta
		while (respuesta.next()) {
		  Categoria t = new Categoria(
			respuesta.getInt("id"),
			respuesta.getString("nombre")
		  );
		  categorias.add( t );
		}
	  // 5. Retornamos el ArrayList, ahora lleno
	  return categorias;
	}
}
