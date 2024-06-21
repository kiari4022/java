package Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.UserEntity;

/**
 * Servlet implementation class GestServlet
 */
@WebServlet("/GestServlet")
public class GestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//次の画面設定
		String next ="Guest.jsp";
		
//		UserEntity id = new UserEntity(0, "ゲスト","", "", "");
//		HttpSession session = request.getSession(true);
//		session.setAttribute("session", id);
		
		//結果画面を転送
		request.getRequestDispatcher(next).forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字化け防止コード
		request.setCharacterEncoding("UTF-8");
		
		//次の画面設定
		String next ="Guest.jsp";
		
//		UserEntity id = new UserEntity(0, "ゲスト","", "", "");
//		HttpSession session = request.getSession(true);
//		session.setAttribute("session", id);
		
		//結果画面を転送
		request.getRequestDispatcher(next).forward(request, response);
	}

}
