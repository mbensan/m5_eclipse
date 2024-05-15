package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import classes.GeneradorAzar;
import classes.Mensaje;

/**
 * Servlet implementation class NinjaOro
 */
public class NinjaOro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NinjaOro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// cargamos la cantidad de oros de la sesión
		HttpSession ses = request.getSession();
		String oro = (String) ses.getAttribute("oro");
		ArrayList mensajes = (ArrayList) ses.getAttribute("mensajes");
		// si es que es la primera vez que accedemos a "oro" en la sesión
		// entonces iniciamos este atributo (de sesión) en "0"
		if (oro == null) {
			ses.setAttribute("oro", "0");
		}
		if (mensajes == null) {
			ses.setAttribute("mensajes", new ArrayList<Mensaje>());
		}
		// cargamos la vista
		RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/ninja_oro.jsp");
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Obtengo el lugar
		String lugar = request.getParameter("lugar");
		// 2. Calculo la cantidad de Oros
		int nuevosOros = GeneradorAzar.generarOros(lugar);
		// 3. Calculo la nueva cantidad de Oros
		HttpSession ses = request.getSession();
		int viejosOros = Integer.parseInt((String) ses.getAttribute("oro"));
		ArrayList<Mensaje> mensajes = (ArrayList<Mensaje>) ses.getAttribute("mensajes");
		
		// 4. Fijamos la nueva cantidad de Oro
		ses.setAttribute("oro", (viejosOros + nuevosOros) + "");
		
		// 5. Agregamos el nuevo mensaje
		Mensaje nuevoMensaje;
		if (nuevosOros > 0) {
			mensajes.add(new Mensaje(
				"Ha generado " + nuevosOros + " oro en " + lugar,
				"success"
			));
		}
		else {
			mensajes.add(new Mensaje(
				"Ha generado " + nuevosOros + " oro en " + lugar,
				"danger"
			));
		}
		ses.setAttribute("mensajes", mensajes);

		// 6. Redirijo hacia el GET
		response.sendRedirect("/Juego/NinjaOro");
	}

}
