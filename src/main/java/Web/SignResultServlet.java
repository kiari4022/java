package Web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logic.TakahashiLogic;

/**
 * Servlet implementation class SignResultServlet
 */
@WebServlet("/SignResultServlet")
public class SignResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String next = "SignUpResult.jsp";
		
		String name = request.getParameter("name");
		String tell = request.getParameter("tell");
		String pass = request.getParameter("pass");
		String date = request.getParameter("date");
		
		TakahashiLogic emp = new TakahashiLogic();
		try {
			emp.getLogic(name, tell, pass, date);
		} catch (SQLException e) {
		}
		
		
		request.getRequestDispatcher(next).forward(request, response);
	}

}
