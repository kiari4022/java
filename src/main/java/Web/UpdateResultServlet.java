package Web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Entity.PostEntity;
import Entity.UserEntity;
import Logic.TairaLogic;
import Logic.YamadaLogic;

/**
 * Servlet implementation class UpdateResultServlet
 */
@WebServlet("/UpdateResultServlet")
public class UpdateResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateResultServlet() {
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
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//
//		String userID = request.getParameter("userID");
//		String shop = request.getParameter("store");
//		String menu = request.getParameter("menu");
//		String price = request.getParameter("price");
//		String dateStr = request.getParameter("date");//保留、ない
//		String address = request.getParameter("address");
//		String time = request.getParameter("time");
//		String photo = request.getParameter("picture");
//		String text = request.getParameter("text");
//		String postID = request.getParameter("postID");
//
//		PostEntity post = new PostEntity();
//		if (userID != null) {
//			post.setUserID(Integer.parseInt(userID));//全部で９項目
//		}
//		post.setStore(shop);
//		post.setMenu(menu);
//		if (price != null) {
//			post.setPrice(Integer.parseInt(price));
//		}
//		if (dateStr != null) {
//			// 日付文字列をLocalDateに変換
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//			LocalDate localDate = LocalDate.parse(dateStr, formatter);
//			// LocalDateをjava.sql.Dateに変換
//			java.sql.Date date = java.sql.Date.valueOf(localDate);
//			post.setDate(date);
//		}
//		post.setAddress(address);
//		if (time != null) {
//			post.setTime(Integer.parseInt(time));
//		}
//		post.setPhoto(photo);
//		if (postID != null) {
//			post.setPostID(Integer.parseInt(postID));
//		}
//		post.setText(text);
//		//postIDも画面から取得してpostEntityのインスタンスに設定する
//
//		TairaLogic logic = new TairaLogic();
//		HttpSession session = request.getSession();
//		UserEntity user = (UserEntity) session.getAttribute("session");
//		int userID1 = user.getUserID(); 
//		YamadaLogic logic1 = new YamadaLogic();
//		// userIDを指定して投稿情報を検索
//		ArrayList<PostEntity> returnValue = logic1.searchPostList(userID1);
//
//		// リクエスト属性に設定
//		session.setAttribute("post", returnValue);
//
//		// 投稿情報を降順でソート
//		Collections.sort(returnValue, Comparator.comparing(PostEntity::getPostID).reversed());
//
//		// リクエスト属性に設定
//		request.setAttribute("photo", photo);
//		//		request.setAttribute("userID", userIDInt);
//		request.setAttribute("store", shop);
//		request.setAttribute("menu", menu);
//		//request.setAttribute("price", priceInt);
//		request.setAttribute("address", address);
//		//request.setAttribute("time", timeInt);
//		request.setAttribute("text", text);
//		request.setAttribute("post", returnValue);
//
//		int result = logic.updatePost(post);
//
//		String next = "Top.jsp";
//		request.getRequestDispatcher(next).forward(request, response);
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			    request.setCharacterEncoding("UTF-8");
			    //String userID = request.getParameter("userID");
			    try {
			    String shop = request.getParameter("store");
			    String menu = request.getParameter("menu");
			    String price = request.getParameter("price");
			    String dateStr = request.getParameter("date");
			    String address = request.getParameter("address");
			    String time = request.getParameter("time");
			    String photo = request.getParameter("picture");
			    String text = request.getParameter("text");
			    String postID = request.getParameter("postID");
			    //int userIDInt = Integer.parseInt(userID);
			    PostEntity post = new PostEntity();
//			    if (userID != null) {
//			       // post.setUserID(Integer.parseInt(userID));
//			        int userIDInt = Integer.parseInt(userID);
//			    }
			    post.setStore(shop);
			    post.setMenu(menu);
			    if (price != null) {
			        post.setPrice(Integer.parseInt(price));
			    }
			    if (dateStr != null) {
			        // 日付文字列をLocalDateに変換
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			        LocalDate localDate = LocalDate.parse(dateStr, formatter);
			        // LocalDateをjava.sql.Dateに変換
			        java.sql.Date date = java.sql.Date.valueOf(localDate);
			        post.setDate(date);
			    }
			    post.setAddress(address);
			    if (time != null) {
			        post.setTime(Integer.parseInt(time));
			    }
			    post.setPhoto(photo);
			    if (postID != null) {
			        post.setPostID(Integer.parseInt(postID));
			    }
			    post.setText(text);

			    TairaLogic logic = new TairaLogic();
			    int result = logic.updatePost(post);

			    HttpSession session = request.getSession();
			    UserEntity user = (UserEntity) session.getAttribute("session");
			    int userID = user.getUserID();
			   
			    ArrayList<PostEntity> returnValue = logic.searchPostList(userID);
			    request.setAttribute("post", returnValue);
			    Collections.sort(returnValue, Comparator.comparing(PostEntity::getPostID).reversed());
			    
			  //リクエスト属性に設定
				request.setAttribute("photo", photo);
				//		request.setAttribute("userID", userIDInt);
				request.setAttribute("store", shop);
				request.setAttribute("menu", menu);
				//request.setAttribute("price", priceInt);
				request.setAttribute("address", address);
				//request.setAttribute("time", timeInt);
				request.setAttribute("text", text);
				request.setAttribute("post", returnValue);
			   
			    }
			    catch (NumberFormatException e) {
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
