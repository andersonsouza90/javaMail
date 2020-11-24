package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import email.ObjetoEnviaEmail;

@WebServlet("/email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Email() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String listaDestinatario = "andersonsouza.systems@gmail.com"; 
		String nomeRemetente = "Dandy TESTE";
		String assuntoEmail = "Chegou um email enviado com Java!";
		
		StringBuilder corpoEmail = new StringBuilder();
		corpoEmail.append(email);
		
		ObjetoEnviaEmail e = new ObjetoEnviaEmail(
													listaDestinatario, 
													nomeRemetente, 
													assuntoEmail, 
													corpoEmail.toString()
													);
		try {
			e.enviarEmail();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//RequestDispatcher d = request.getRequestDispatcher("index.jsp");
		//d.forward(request, response);
		
		response.sendRedirect(request.getContextPath());
		
	}

}
