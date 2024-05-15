package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import classes.Operaciones;

/**
 * Servlet implementation class Calc
 */
public class Calc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calc() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String resultado = (String) session.getAttribute("resultado");
		if (resultado == null) {
			session.setAttribute("resultado", "0");
		}
		
		RequestDispatcher vista = request.getRequestDispatcher("WEB-INF/calculadora.jsp");
		vista.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float num1 = Float.parseFloat(request.getParameter("num1"));
		String op = request.getParameter("op");
		float num2 = Float.parseFloat(request.getParameter("num2"));
		
		float resultado = Operaciones.operar(num1, op, num2);
		
		HttpSession session = request.getSession();
		session.setAttribute("resultado", resultado + "");
		
		response.sendRedirect("/Calculadora/Calc");
	}

}




