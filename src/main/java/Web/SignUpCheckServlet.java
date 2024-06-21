package Web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpCheckServlet
 */
@WebServlet("/SignUpCheckServlet")
public class SignUpCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpCheckServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//���������h�~�R�[�h
		request.setCharacterEncoding("UTF-8");

		//���̉�ʐݒ�
		String next = "SignUpCheck.jsp";
		
		try {
			String name = request.getParameter("name");
			String tell = request.getParameter("tell");
			String pass = request.getParameter("pass");
			String repass = request.getParameter("repass");
			String date = request.getParameter("date");
			
			if(!pass.equals(repass)) throw new SQLException();
			if(pass.equals("")) throw new SQLException();
			if(name.equals("")) throw new SQLException();
			if(tell.equals("")) throw new SQLException();
	
			request.setAttribute("name", name);
			request.setAttribute("tell", tell);
			request.setAttribute("pass", pass);
			request.setAttribute("date", date);
		} catch (SQLException e) {
			next = "SignUp.jsp";
		}

		//���ʉ�ʂ�]��
		request.getRequestDispatcher(next).forward(request, response);

	}

}
