package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Categoria;
import models.Tarea;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import daos.CategoriaDao;
import daos.TareaDao;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Pedimos el texto de cada tarea
		try {
			ArrayList<Tarea> tareas = TareaDao.getAll();		
			System.out.println(tareas);
			request.setAttribute("tareas", tareas);
			ArrayList<Categoria> cats = CategoriaDao.getAll();
			request.setAttribute("cats", cats);
		} catch(SQLException e) {
			System.out.println(e);
		}
		// 2. Cargamos el JSP
		RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/home.jsp");
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String textoNuevaTarea = request.getParameter("texto");
		
		try {
			TareaDao.addNew(textoNuevaTarea);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/Tareas/Home");
	}

}
