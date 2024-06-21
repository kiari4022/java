package Web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Entity.PostEntity;
import Entity.UserEntity;
import Logic.YamadaLogic;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html; charset=UTF-8"); 
		
//		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	    
		
		
	    try {
		    // Logic
		    YamadaLogic logic = new YamadaLogic();

		    
		    HttpSession session = request.getSession();
		    UserEntity user = (UserEntity)session.getAttribute("session"); 
		    int userID = user.getUserID(); 
		    
		    ArrayList<PostEntity> returnValue = logic.searchPostList(userID); 
		    // リクエスト属性に設定
		    session.setAttribute("post", returnValue);
		    
		    // 投稿情報を降順でソート
		    Collections.sort(returnValue, Comparator.comparing(PostEntity::getPostID).reversed());

		    
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	    
	    String next = "MyPage.jsp";
	    request.getRequestDispatcher(next).forward(request, response);

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
	}

}
