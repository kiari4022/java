package Web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Entity.PostEntity;
import Entity.UserEntity;
import Logic.YamadaLogic;

/**
 * Servlet implementation class InsertResultServlet
 */
@WebServlet("/InsertResultServlet")
public class InsertResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertResultServlet() {
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
		request.setCharacterEncoding("UTF-8");

		try {
//			String userID = request.getParameter("userID");
			String shop = request.getParameter("shop");
			String menu = request.getParameter("menu");
			String price = request.getParameter("price");
			String dateStr = request.getParameter("date");
			String address = request.getParameter("address");
			String time = request.getParameter("time");
			String photo = request.getParameter("photo");
			String text = request.getParameter("text");
//			int userIDInt = Integer.parseInt(userID);
			int priceInt = Integer.parseInt(price);
			int timeInt = Integer.parseInt(time);

			// 日付文字列をLocalDateに変換
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.parse(dateStr, formatter);
			// LocalDateをjava.sql.Dateに変換
			java.sql.Date date = java.sql.Date.valueOf(localDate);

			
			// Logic
			YamadaLogic logic = new YamadaLogic();
			
			
			
			HttpSession session = request.getSession();
		    UserEntity user = (UserEntity)session.getAttribute("session"); 
		    int userID = user.getUserID(); 
			
		    
		    
			PostEntity e = new PostEntity(0,userID, shop, menu, priceInt, date, address, timeInt, photo, text);
			logic.insertPost(e);
			if ( shop == null || menu == null || price == null || dateStr == null || address == null
					|| time == null || photo == null || text == null) {

				String next = "Insert.jsp";
				request.getRequestDispatcher(next).forward(request, response);

				return;
			}


			
			

			// userIDを指定して投稿情報を検索
			ArrayList<PostEntity> returnValue = logic.searchPostList(userID);
			
			 // リクエスト属性に設定
		    session.setAttribute("post", returnValue);

			// 投稿情報を降順でソート
			Collections.sort(returnValue, Comparator.comparing(PostEntity::getPostID).reversed());

			// リクエスト属性に設定
			request.setAttribute("photo", photo);
//			request.setAttribute("userID", userIDInt);
			request.setAttribute("store", shop);
			request.setAttribute("menu", menu);
			request.setAttribute("price", priceInt);
			request.setAttribute("address", address);
			request.setAttribute("time", timeInt);
			request.setAttribute("text", text);
			request.setAttribute("post", returnValue);

			
		} catch (NumberFormatException e) {
			String next = "Insert.jsp";
			request.getRequestDispatcher(next).forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
			String next = "Insert.jsp";
			request.getRequestDispatcher(next).forward(request, response);
		}
		
		String next = "MyPage.jsp";
		request.getRequestDispatcher(next).forward(request, response);

	}
}