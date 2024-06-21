package Web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.PostEntity;
import Logic.YamadaLogic2;

/**
 * Servlet implementation class GuestPostServlet
 */
@WebServlet("/GuestPostServlet")
public class GuestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuestPostServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8"); //最初に表示する・文字化け防止コード
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		
		request.setCharacterEncoding("UTF-8");

		YamadaLogic2 logic = new YamadaLogic2();
		// データベースに追加された後に検索を行い、最新のデータを取得する
		ArrayList<PostEntity> returnValue = logic.searchToyCarList();

		
		request.setAttribute("post", returnValue);
		
		
		

		 Collections.sort(returnValue, Comparator.comparing(PostEntity::getPostID).reversed());

		
		String next = "GuestPost.jsp";

		//結果画面を転送
		request.getRequestDispatcher(next).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
