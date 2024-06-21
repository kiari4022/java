package Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.PostEntity;
import Logic.TanakaLogic;
import java.io.File;
import java.io.IOException;

/**
 * Servlet implementation class DeleteCheckServlet
 */
@WebServlet("/DeleteCheckServlet")
public class DeleteCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCheckServlet() {
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
		
		String postID= request.getParameter("postID");
		int postid = Integer.parseInt(postID);
		
		TanakaLogic logic =new TanakaLogic();// postidを条件に検索
		PostEntity post = logic.selectPost(postid);	
		
		
		
	    request.setAttribute("postdata", post);//postidを次の画面に渡す
		
		String next = "Delete.jsp";
		request.getRequestDispatcher(next).forward(request, response);
		
	}


}
