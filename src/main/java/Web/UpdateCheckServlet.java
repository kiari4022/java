package Web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import Entity.PostEntity;
import Logic.TairaLogic;

/**
 * Servlet implementation class UpdateCheckServlet
 */
@WebServlet("/UpdateCheckServlet")
@MultipartConfig()
public class UpdateCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCheckServlet() {
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
		// */
	//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	// throws ServletException, IOException {
	// request.setCharacterEncoding("UTF-8");
	// String postID = request.getParameter("postID");
	// String userID = request.getParameter("userID");
	// String shop = request.getParameter("store");
	// String menu = request.getParameter("menu");
	// String price = request.getParameter("price");
	// String date = request.getParameter("date");//保留、ない
	// String address = request.getParameter("address");
	// String time = request.getParameter("time");
	// Part photo = request.getPart("picture");//ない	画像を上げなおすとき
	// String picturePath = null;
	// if(photo == null) {//更新画像がない
	// picturePath = request.getParameter("pic");// 画像を上げなおさない時
	// } else {
	// // アップロードした画像を保存する
	// // ファイル名を取得
	// String filename = photo.getSubmittedFileName();
	// // アップロードするフォルダ
	// String path = getServletContext().getRealPath("/upload");
	// // 書き込み
	// photo.write(path + File.separator + filename);
	// picturePath = path + File.separator + filename;
	// }
	// String text = request.getParameter("text");
	//
	// request.setAttribute("postID", postID);
	// request.setAttribute("userID", userID);
	// request.setAttribute("shop", shop);
	// request.setAttribute("menu", menu);
	// request.setAttribute("price", price);
	// request.setAttribute("date", date);
	// request.setAttribute("address", address);
	// request.setAttribute("time", time);
	// request.setAttribute("photo", picturePath);
	// request.setAttribute("text", text);
	//
	// String next = "UpdateCheck.jsp";
	// // 確認画面へフォワード
	// request.getRequestDispatcher(next).forward(request, response);
	//
	//	
	//
	//	}
	//}
	//
	//
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String postID = request.getParameter("postID");
		String userID = request.getParameter("userID");
		String shop = request.getParameter("store");
		String menu = request.getParameter("menu");
		String price = request.getParameter("price");
		String date = request.getParameter("date");
		String address = request.getParameter("address");
		String time = request.getParameter("time");
		Part photo = request.getPart("picture");
		String picturePath = null;
		String filename = Paths.get(photo.getSubmittedFileName()).getFileName().toString();
		if (!filename.isEmpty()) {
			// アップロードするフォルダ
			String uploadPath = getServletContext().getRealPath("/upload");
			System.out.println(uploadPath);
			// アップロードされたファイルの保存先のパス
			String filePath = uploadPath + File.separator + filename;
			// ファイルを保存
			photo.write(filePath);
			picturePath = "upload\\"+ filename;
		} else {
			// 写真がアップロードされなかった場合、既存の写真を使用する
			picturePath = request.getParameter("pic");
		}
		String text = request.getParameter("text");
		request.setAttribute("postID", postID);
		request.setAttribute("userID", userID);
		request.setAttribute("shop", shop);
		request.setAttribute("menu", menu);
		request.setAttribute("price", price);
		request.setAttribute("date", date);
		request.setAttribute("address", address);
		request.setAttribute("time", time);
		request.setAttribute("photo", picturePath);
		request.setAttribute("text", text);
		String next = "UpdateCheck.jsp";
		// 確認画面へフォワード
		request.getRequestDispatcher(next).forward(request, response);
	}
}