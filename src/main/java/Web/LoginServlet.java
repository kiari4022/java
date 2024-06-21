package Web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.UserEntity;
import Logic.KamiyaLogic;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 String redirectURL = "Top.jsp"; 
		 response.sendRedirect(redirectURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//文字化け防止コード
		request.setCharacterEncoding("UTF-8");
		
		//次の画面設定
		String next ="Top.jsp";
		
		try {
			String a = request.getParameter("phone");
			String p = request.getParameter("pass");
			
			KamiyaLogic emp = new KamiyaLogic();
			UserEntity id = emp.searchLogin(a, p);
			HttpSession session = request.getSession(true);
			session.setAttribute("session", id);
		} catch (SQLException e) {
			next = "Login.jsp";
		}
		
		//結果画面を転送
		request.getRequestDispatcher(next).forward(request, response);
//	
	}

}
